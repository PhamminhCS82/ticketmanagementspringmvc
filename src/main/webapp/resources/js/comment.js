/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function addComment(idtrip) {

    fetch("/CS82TicketSale/api/add-comment/", {
        method: 'post',
        body: JSON.stringify({
            "detail": document.getElementById("commentId").value,
            "idtrip": idtrip
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        console.info(res);
        return res.json();

    }).then(function (data) {
        console.info(data);
        let area = document.getElementById("commentArea");
        area.innerHTML = `
                            <div class="commented-section mt-4"class="d-flex flex-row add-comment-section mt-4 mb-4"><img class=" avatar img-fluid img-responsive rounded-circle mr-2" src="${data.user.avatar}" width="45">
                                <div class="d-flex flex-row align-items-center commented-user mt-3">
                                    <span class="dot mb-3">${data.user.username}</span>
                                    <i class=" mb-3 ml-4">${moment(data.createdDate).fromNow()}</i>
                                </div>
                                <div class="comment-text-sm"><span>${data.detail}</span></div>                  
                            </div>` + area.innerHTML;
    
    });
     location.reload();
}
function show_alert(){
    Swal.fire({
            icon: 'error',
            title: 'Xảy ra lỗi',
            text: 'Bạn chưa đăng nhập tài khoản!'
        });
}