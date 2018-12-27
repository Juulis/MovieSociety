$(function(){
    let name = $('#login-name').val();
    let pw = $('#login-pw').val();
    $.ajax({
        type: "POST",
        url: `/login?name=${name}&pw=${pw}`,
        data: String,
        success: function (response) {
            console.log(response);
            if (response === "logged in") {
                $('#status').text("logged in!!");
            }
            else if (response === "not authorized"){
                $('#status').text("Wrong pw");
            }
        }
    });
});