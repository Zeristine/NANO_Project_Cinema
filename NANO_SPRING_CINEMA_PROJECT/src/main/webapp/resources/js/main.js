$(document).ready(function () {
    if (window.localStorage.hasOwnProperty("id") &&
            window.localStorage.hasOwnProperty("name")) {
        var name = window.localStorage.getItem("name");
        var id = window.localStorage.getItem("id");
        $("button[name=logged]").text(name);
        $("div[name=logged]")
                .css({"display": "block"});
        $("a[name=logged-link]").attr("href", "account-profile-" + id);
    } else {
        $("div[name=not-logged]")
                .css({"display": "block"});
    }
});