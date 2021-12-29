/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.controllers;

import com.group11.pojos.Tickets;
import com.group11.services.OrderService;
import com.group11.utils.Utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.cloudinary.json.JSONArray;
import org.cloudinary.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    
    @PostMapping("/api/pay")
    public HttpStatus pay(@RequestBody Tickets params, HttpSession session) {
        try {
            if(this.orderService.addOrder(params))
                return HttpStatus.OK;
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
        return HttpStatus.BAD_REQUEST;
    }
    
    @GetMapping("/api/get-bank-list")
    public ResponseEntity<String> info(HttpSession session) throws URISyntaxException, IOException {
        String appid = Utils.config.get("appid");
        String reqtime = Long.toString(System.currentTimeMillis());
        String data = appid +"|"+ reqtime;
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
        return new ResponseEntity<>(banksObject.toString(),HttpStatus.OK);
    }
    
//    @PostMapping("/api/payment")
//    public int pay(HttpSession session) throws MalformedURLException, IOException {
//        String accessKey = "tZcZe2IoWYMT2We7";
//        String secretKey = "aWgU46POmumUKUk8DgcHS3Za6ZcAS3Iu";
//        String amount = "50000";
//        try {
//            URL url = new URL("https://test-payment.momo.vn/v2/gateway/api/create");
//            HttpURLConnection con = (HttpURLConnection) url.openConnection();
//            con.setRequestMethod("POST");
//            con.setRequestProperty("Content-Type", "application/json");
//            Map<String, String> parameters = new HashMap<>();
//            parameters.put("partnerCode", "MOMO6UA320211225");
//            parameters.put("partnerName", "Test Payment");
//            parameters.put("storeId", "BanVeTest");
//            parameters.put("requestType", "captureWallet");
//            parameters.put("redirectUrl", "localhost:8080/CS82TicketSale/");
//            parameters.put("ipnUrl", "localhost:8080/CS82TicketSale/api/info");
//            parameters.put("orderId", UUID.randomUUID().toString().getBytes("UTF-8").toString());
//            parameters.put("requestId", UUID.randomUUID().toString().getBytes("UTF-8").toString());
//            parameters.put("orderInfo", "pay with MoMo");
//            parameters.put("extraData", "");
//            return 1;
//        } catch (NullPointerException ex) {
//            ex.printStackTrace();
//        }
//        return 0;
//    }
}
