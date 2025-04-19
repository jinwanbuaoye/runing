$(document).ajaxSend(function (e, xhr, opt) {
    var user_token = localStorage.getItem("user_token");
    xhr.setRequestHeader("user_token", user_token);
});

        function getUserInfo() {
            $.ajax({
                type: "get",
                url: "/user/getUserInfo",
                success: function (result) {
                    if (result.code == 200 && result.data != null) {
                        $(".left .card h3").text(result.data.userName);
                        $(".left .card a").attr("href", result.data.githubUrl);
                    }else{
                        alert("请先登录");
                        window.location.href = "blog_login.html";
                    }
                },
                error: function (err) {
                }
            });
        }