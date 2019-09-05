$(document).ready(function () {
    if (window.localStorage.hasOwnProperty("id") &&
            window.localStorage.hasOwnProperty("name")) {
        var name = window.localStorage.getItem("name");
        $("button[name=logged]").text(name);
        $("div[name=logged]")
                .css({"display": "block"});
    } else {
        $("div[name=not-logged]")
                .css({"display": "block"});
    }
    loadFilms();
});

function loadFilms() {
    $.ajax({
        type: 'GET',
        url: "current-films",
        success: function (a) {
            $("#main-content").html(a);
        }
    });
}

function logout() {
    if (window.localStorage.hasOwnProperty("id") &&
            window.localStorage.hasOwnProperty("name")) {
        window.localStorage.removeItem("id");
        window.localStorage.removeItem("name");
    }
    if (!window.localStorage.hasOwnProperty("id") &&
            !window.localStorage.hasOwnProperty("name")) {
        window.location.reload();
    }
}

function getTicketForm(button) {
    $("button").removeClass("active");
    $(button).addClass("active");
    $.ajax({
        type: 'POST',
        url: "form-order",
        success: function (a) {
            $("#main-content").html(a);
        }
    });
}

function getTicketPriceList(button) {
    $("button").removeClass("active");
    $(button).addClass("active");
    $.ajax({
        type: 'POST',
        url: "ticket-price",
        success: function (a) {
            $("#main-content").html(a);
        }
    });
}

function showProfile(button) {
    $("button").removeClass("active");
    $(button).addClass("active");
    var id = window.localStorage.getItem("id");
    $.ajax({
        type: 'POST',
        url: "account-profile",
        data: {id: id},
        success: function (a) {
            $("#main-content").html(a);
        }
    });
}

function reload() {
    window.location.reload();
}

function search() {
    var search = $("input[name=name]").val();
    $.ajax({
        type: 'POST',
        url: "search-film",
        data: {name: search},
        success: function (a) {
            $("#main-content").html(a);
        }
    });
}
