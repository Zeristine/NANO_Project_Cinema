function logout() {
    if (window.localStorage.hasOwnProperty("id") &&
            window.localStorage.hasOwnProperty("name")) {
        if (window.localStorage.hasOwnProperty("order")) {
            var confirm = confirm("You are having unfinished order. If you log out, eveything will be gone. Are you sure?");
            if (confirm) {
                window.localStorage.clear();
            }
        } else {
            window.localStorage.clear();
        }
    }
    if (!window.localStorage.hasOwnProperty("id") &&
            !window.localStorage.hasOwnProperty("name")) {
        window.location.replace("home");
    }
}