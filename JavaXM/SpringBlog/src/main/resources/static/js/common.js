$(document).ajaxSend(function (e, xhr, opt) {
    var user_token = localStorage.getItem("user_token");
    xhr.setRequestHeader("user_token", user_token);
});

function logout() {
    localStorage.removeItem("user_token");
    location.href = "/blog_login.html";
}