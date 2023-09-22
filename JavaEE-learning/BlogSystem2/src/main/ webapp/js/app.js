function getLoginStatus() {
    $.ajax({
        type: 'get',
        url: 'login',
        success: function (body) {
            // 已经在登录状态，不处理
        },
        error: function () {
            // 非登录或其他状态，则强行跳转
            alert("未登录！请登录后再访问")
            location.assign('BlogLoginPage.html')
        }
    });
}