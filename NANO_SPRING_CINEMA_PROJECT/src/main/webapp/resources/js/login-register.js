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

function validateRegister() {
    var username = $("input[name=username]").val().trim();
    var password = $("input[name=password").val().trim();
    var retype = $("input[name=retype").val().trim();
    var firstname = $("input[name=firstname").val().trim();
    var lastname = $("input[name=lastname").val().trim();
    var birthdate = $("input[name=birthdate").val().trim();
    var phone = $("input[name=phone").val().trim();
    var msg = "";
    if (username.length == 0 || password.length == 0 || retype.length == 0
            || firstname.length == 0 || lastname.length == 0
            || birthdate.length == 0 || phone.length == 0) {
        msg = "Please input all fields";
    } else {
        if (password.length < 5) {
            msg += "Password length >= 5";
        } else if (password !== retype) {
            msg += "Password and confirm must match\n";
        }
    }
    msg = msg.trim();
    if (msg.length > 0) {
        alert(msg);
        return false;
    } else {
        return true;
    }
}
function login() {
    var username = $("input[name=username]").val().trim();
    var password = $("input[name=password]").val().trim();
    $.ajax({
        type: 'POST',
        url: "login",
        data: {username: username, password: password},
        success: function (a) {
            if (a == "fail") {
                alert("Invalid username or password");
                $("input[name=username]")
            } else {
                var pos = a.indexOf("-");
                var name = a.substring(0, pos);
                var id = a.substring(pos + 1);
                window.localStorage.setItem("id", id);
                window.localStorage.setItem("name", name);
                alert("Welcome, " + name);
                window.location.replace("home");
            }
        }
    });
}

function getName(id) {
    $.ajax({
        type: 'POST',
        url: "login-name",
        data: {id: id},
        success: function (a) {
            return a;
        }
    });
}

function backToHome() {
    window.location.replace("home");
}