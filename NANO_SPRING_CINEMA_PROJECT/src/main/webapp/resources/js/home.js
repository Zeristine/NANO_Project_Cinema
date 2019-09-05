$(document).ready(function () {
    var loggedId = window.localStorage.getItem("id");
    loadFilms();
});

function loadFilms(){
    $.ajax({
        type: 'GET',
        url: "current-films",
        success: function (a) {
            $("#film-content").html(a);
        }
    });
}