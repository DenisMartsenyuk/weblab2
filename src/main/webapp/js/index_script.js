$(document).ready(function(){
    setTimeout(banBack, 1000);
});

function banBack() {
    history.pushState(null, null, location.href);
    window.onpopstate = function(event) {
        history.go(1);
    };
    console.log("xixi ");
} //todo убрать если что

function clickSvg(evt) {
    let element = evt.target;
    let position = element.getBoundingClientRect();
    let srcX = evt.clientX - position.left;
    let srcY = evt.clientY - position.top;
    let x = (srcX - 150) / 100.0;
    let y = (150 - srcY) / 100.0;
    buildClickRequest(x, y);
}


function selectCheckBox(checkBox) {
    $(':checkbox[name="r"]').prop("checked", false);
    $(checkBox).prop("checked", true);
    let form = document.createElement('form');
}

function validation(input) {
    let value = $(input).val().replace(/,/,".");
    if (value === "" || isNaN(value) || (Number(value) >= 5 || Number(value) <= -5)) {
        setDesignInput(input, "#f5e0d9", "2px solid #f64072");
        return false;
    } else {
        setDesignInput(input, "WHITE", "1px solid #000000");
        return true;
    }
}

function setDesignInput(input, color, border) {
    $(input).css("border", border);
    $(input).css("background", color);
}

function buildRequest() {
    if (validation($("#x-field")) && validation($("#y-field"))) {
        $("#request").submit();
    }
}

function buildClickRequest(x, y) {
    let r = Number($('input[name="radioGroup"]:checked').val());
    x = Number(x);
    y = Number(y);
    x = x * r;
    y = y * r;
    console.log(x);
    console.log(y);
    document.getElementById('x-field').value = x.toString();
    $("#x-field").val(x.toString());
    $("#y-field").val(y.toString());
    $("#request").submit(); //todo понять что тут не так
}