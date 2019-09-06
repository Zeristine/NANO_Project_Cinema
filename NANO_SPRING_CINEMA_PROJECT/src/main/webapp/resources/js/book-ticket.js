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
        if (phase == 1) {
            $("select[name=film]").val(localStorage.getItem("film"));
            $("select[name=date]").val(localStorage.getItem("date"));
            $("select[name=time]").val(localStorage.getItem("time"));
            $("select[name=date]").removeProp("disabled");
            $("select[name=time]").removeProp("disabled");
            $("button[name=button-seat]").removeProp("disabled");
        } else if (phase == 2) {

        }
    }
});

function openOrCloseShowDateSelect(select) {
    var value = $(select).val();
    if (value == 0) {
        $("select[name=date]").prop("disabled", "disabled");
        $("select[name=time]").prop("disabled", "disabled");
        $("button[name=button-seat]").prop("disabled", "disabled");
    } else {
        $("select[name=date]").removeProp("disabled");
        if ($("select[name=date]").val() != 0) {
            $("select[name=time]").removeProp("disabled");
            if ($("select[name=time]").val() != 0) {
                $("button[name=button-seat]").removeProp("disabled");
            }
        }
    }
}

function openOrCloseTimeDateSelect(select) {
    var value = $(select).val();
    if (value == 0) {
        $("select[name=time]").prop("disabled", "disabled");
        $("button[name=button-seat]").prop("disabled", "disabled");
    } else {
        $("select[name=time]").removeProp("disabled");
        if ($("select[name=time]").val() != 0) {
            $("button[name=button-seat]").removeProp("disabled");
        }
    }
}

function openOrCloseChooseSeat(select) {
    var value = $(select).val();
    if (value == 0) {
        $("button[name=button-seat]").prop("disabled", "disabled");
    } else {
        $("button[name=button-seat]").removeProp("disabled");
    }
}

function toRoomPhase() {
    var filmId = $("select[name=film]").val();
    var dateId = $("select[name=date]").val();
    var timeId = $("select[name=time]").val();
    window.localStorage.setItem("order", 1);
    window.localStorage.setItem("film", filmId);
    window.localStorage.setItem("time", timeId);
    window.localStorage.setItem("date", dateId);
    getRoomPhase();
}

function getRoomPhase() {
    $.ajax({
        type: 'POST',
        url: "form-order-room",
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
    var phase = window.localStorage.getItem("order");
    if (phase == 1) {
        window.location.reload();
    }else if (phase == 2){
        getRoomPhase();
    }
}