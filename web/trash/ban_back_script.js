$(document).ready(function(){
    setTimeout(banBack, 1000);
});

function banBack() {
    history.pushState(null, null, location.href);
    window.onpopstate = function(event) {
        history.go(1);
    };
    console.log("xixi ");
}