/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.controllers;

import com.group11.pojos.Tickets;
import com.group11.pojos.User;
import com.group11.services.OrderService;
import com.group11.services.UserService;
import com.group11.utils.Utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.servlet.http.HttpSession;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vn.zalopay.crypto.HMACUtil;

/**
 *
 * @author pminh
 */
@RestController
public class ApiBuyTicketController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userDetailsService;

    @PostMapping("/api/pay")
    public HttpStatus pay(@RequestBody Tickets params, HttpSession session) {
        try {
            if (this.orderService.addOrder(params)) {
                return HttpStatus.OK;
            }
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
        return HttpStatus.BAD_REQUEST;
    }

    @GetMapping("/api/get-bank-list")
    public ResponseEntity<String> info(HttpSession session) throws URISyntaxException, IOException {
        String appid = Utils.config.get("appid");
        String reqtime = Long.toString(System.currentTimeMillis());
        String data = appid + "|" + reqtime;
        String mac = HMACUtil.HMacHexStringEncode(HMACUtil.HMACSHA256, Utils.config.get("key1"), data);

        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("appid", appid));
        params.add(new BasicNameValuePair("reqtime", reqtime)); // miliseconds
        params.add(new BasicNameValuePair("mac", mac));

        URIBuilder uri = new URIBuilder(Utils.config.get("endpoint"));
        uri.addParameters(params);

        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet(uri.build());

        CloseableHttpResponse res = client.execute(get);
        BufferedReader rd = new BufferedReader(new InputStreamReader(res.getEntity().getContent()));
        StringBuilder resultJsonStr = new StringBuilder();
        String line;

        while ((line = rd.readLine()) != null) {
            resultJsonStr.append(line);
        }

        JSONObject result = new JSONObject(resultJsonStr.toString());
        JSONObject banksObject = result.getJSONObject("banks");
        return new ResponseEntity<>(banksObject.toString(), HttpStatus.OK);
    }

    @PostMapping(path = "/api/payment", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<String> payment(@RequestBody final Tickets params, HttpSession session) throws UnsupportedEncodingException, IOException {
        Random rand = new Random();
        final User u = this.userDetailsService.getUserId(params.getUserId());
        BigDecimal p = BigDecimal.valueOf(params.getSeats().length);
        final BigDecimal total = params.getPrice().multiply(p);
        final int random_id = rand.nextInt(1000000);
        final Map embed_data = new HashMap() {
            {
                put("redirecturl", "https://docs.zalopay.vn/result");
            }
        };
        
        final Map[] item = {
            new HashMap(){{
                put("itemid", "veXe");
                put("itemname", "So ghe ngoi");
                put("itemprice", total);
                put("itemquantity", params.getSeats().length);
            }}
        };
        try {
            Map<String, Object> order;
            order = new HashMap<String, Object>() {
                {
                    put("app_id", Utils.config.get("appid"));
                    put("app_trans_id", Utils.getCurrentTimeString("yyMMdd") + "_" + random_id); // translation missing: vi.docs.shared.sample_code.comments.app_trans_id
                    put("app_time", System.currentTimeMillis()); // miliseconds
                    put("app_user", u.getSurname() + " " + u.getFirstname());
                    put("amount", total.longValue());
                    put("description", "Ticket - Payment for the order #" + random_id);
                    put("bank_code", "zalopayapp");
                    put("item", new JSONArray(item));
                    put("embed_data", new JSONObject(embed_data));
                    put("callback_url", "https://localhost:8080/CS82TicketSale/callback");
                }
            };

            session.setAttribute("app_trans", order.get("app_trans_id"));
            // app_id +”|”+ app_trans_id +”|”+ appuser +”|”+ amount +"|" + app_time +”|”+ embed_data +"|" +item
            String data = order.get("app_id") + "|" + order.get("app_trans_id") + "|" + order.get("app_user") + "|" + order.get("amount")
                    + "|" + order.get("app_time") + "|" + order.get("embed_data") + "|" + order.get("item");
            order.put("mac", HMACUtil.HMacHexStringEncode(HMACUtil.HMACSHA256, Utils.config.get("key1"), data));
            System.out.println(data);
            CloseableHttpClient client = HttpClients.createDefault();
            HttpPost post = new HttpPost(Utils.config.get("create_order_url"));
            List<NameValuePair> parameter = new ArrayList<>();
            for (Map.Entry<String, Object> e : order.entrySet()) {
                BasicNameValuePair bs = new BasicNameValuePair(e.getKey(), String.valueOf(e.getValue()));
                parameter.add(bs);
            }
            // Content-Type: application/x-www-form-urlencoded
            post.setEntity(new UrlEncodedFormEntity(parameter));
            CloseableHttpResponse res = client.execute(post);
            BufferedReader rd = new BufferedReader(new InputStreamReader(res.getEntity().getContent()));
            StringBuilder resultJsonStr = new StringBuilder();
            String line;

            while ((line = rd.readLine()) != null) {
                resultJsonStr.append(line);
            }
            JSONObject result = new JSONObject(resultJsonStr.toString());
            return new ResponseEntity<>(result.toString(), HttpStatus.OK);
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(path = "/api/getOrder", produces = {
        
    })
    public ResponseEntity<String> status(HttpSession session) throws IOException, URISyntaxException {
        String app_trans_id = session.getAttribute("app_trans").toString();  // Input your app_trans_id
        String data = Utils.config.get("appid") + "|" + app_trans_id + "|" + Utils.config.get("key1");
        String mac = HMACUtil.HMacHexStringEncode(HMACUtil.HMACSHA256, Utils.config.get("key1"), data);

        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("app_id", Utils.config.get("appid")));
        params.add(new BasicNameValuePair("app_trans_id", app_trans_id));
        params.add(new BasicNameValuePair("mac", mac));
        try {
            URIBuilder uri = new URIBuilder(Utils.config.get("get_order_status_url"));
            uri.addParameters(params);

            CloseableHttpClient client = HttpClients.createDefault();
            HttpPost post = new HttpPost(uri.build());
            post.setEntity(new UrlEncodedFormEntity(params));

            CloseableHttpResponse res = client.execute(post);
            BufferedReader rd = new BufferedReader(new InputStreamReader(res.getEntity().getContent()));
            StringBuilder resultJsonStr = new StringBuilder();
            String line;

            while ((line = rd.readLine()) != null) {
                resultJsonStr.append(line);
            }

            JSONObject result = new JSONObject(resultJsonStr.toString());
            return new ResponseEntity<>(result.toString(), HttpStatus.OK);
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
