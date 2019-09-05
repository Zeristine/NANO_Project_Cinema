$(document).ready(function () {    
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
