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
    if (window.localStorage.hasOwnProperty("order")) {
        var phase = window.localStorage.getItem("order");
        if (phase == 2) {
            getRoomPhase(window.localStorage.getItem("showtime"));
        } else if (phase == 3) {
            var values = window.localStorage.getItem("seats");
            $.ajax({
                type: 'POST',
                url: "order-book-confirm",
                data: {id: window.localStorage.getItem("showtime"), seats: values},
                success: function (a) {
                    $("#main-content").html(a);
                }
            });
        }
    }

});

function openOrCloseShowTimeSelect(select) {
    var value = $(select).val();
    if (value == 0) {
        $("select[name=st]").prop("disabled", "disabled");
        $("button[name=button-seat]").prop("disabled", "disabled");
        window.localStorage.removeItem("film");
    } else {
        window.localStorage.setItem("film", value);
        $("td[name=st]").html("<select><option value='0' >Fetching...</option></select>");
        $.ajax({
            type: 'POST',
            url: "form-order-date",
            data: {id: value},
            success: function (a) {
                $("td[name=st]").html(a);
                $("select[name=st]").removeProp("disabled");
                if ($("select[name=st]").val() != 0) {
                    $("button[name=button-seat]").removeProp("disabled");
                }
            }
        });
    }
}

function openOrCloseChooseSeat(select) {
    var value = $(select).val();
    if (value == 0) {
        $("button[name=button-seat]").prop("disabled", "disabled");
        window.localStorage.removeItem("showtime");
    } else {
        $("button[name=button-seat]").removeProp("disabled");
        window.localStorage.setItem("showtime", value);
    }
}

function toRoomPhase() {
    window.localStorage.setItem("order", 2);
    getRoomPhase($("select[name=st]").val());
}

function getRoomPhase(stId) {
    $.ajax({
        type: 'POST',
        url: "form-order-room",
        data: {id: stId},
        success: function (a) {
            $("#main-content").html(a);
        }
    });
}

function clearAllOrder() {
    var id = window.localStorage.getItem("id");
    var name = window.localStorage.getItem("name");
    window.localStorage.clear();
    window.localStorage.setItem("id", id);
    window.localStorage.setItem("name", name);
    window.location.replace("home");
}

function backToPrevious() {
    var phase = window.localStorage.getItem("order") - 1;
    if (phase == 1) {
        window.localStorage.setItem("order", 1);
        window.location.reload();
    } else if (phase == 2) {
        window.localStorage.setItem("order", 2);
        getRoomPhase(window.localStorage.getItem("showtime"));
    }
}

function select(button) {
    if ($(button).hasClass("selected")) {
        $(button).removeClass("selected");
    } else {
        $(button).addClass("selected");
    }
}

function toConfirmPhase() {
    var selecteds = $("button[class=selected]");
    if ((selecteds.length - 1) == 0) {
        alert("Please choose seat to go to cofirm section");
    } else {
        var values = "";
        window.localStorage.setItem("order", 3);
        for (var i = 0; i < selecteds.length - 1; i++) {
            values += selecteds[i].value + "|";
        }
        window.localStorage.setItem("seats", values);
        $.ajax({
            type: 'POST',
            url: "order-book-confirm",
            data: {id: window.localStorage.getItem("showtime"), seats: values},
            success: function (a) {
                $("#main-content").html(a);
            }
        });
    }
}

function bookOrder() {
    $.ajax({
        type: 'POST',
        url: "order-save",
        data: {stId: window.localStorage.getItem("showtime"),
            aId: window.localStorage.getItem("id"),
            seats: window.localStorage.getItem("seats")},
        success: function (a) {
            if (a == "success") {
                alert("Ticket Booking succeeds");
            } else if (a == "fail") {
                alert("Ticket Booking fails");
            }
            clearAllOrder();
        }
    });
}