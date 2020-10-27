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
    drawPoints(checkBox.value);
}

function drawPoints(value) {
    let table = document.querySelector('#table-result');
    let group = document.getElementById("point-storage");
    let points = "";
    for (let i = 1; i < table.rows.length; i++) {
        if (table.rows[i].cells[3].textContent === "true" && Number(table.rows[i].cells[2].textContent) === Number(value)) {
            points = points + getDescriptionPoint(Number(table.rows[i].cells[0].textContent), Number(table.rows[i].cells[1].textContent), Number(table.rows[i].cells[2].textContent));
        }
    }
    group.innerHTML = points;
}

function getDescriptionPoint(x, y, r) {
    x = Number(x);
    y = Number(y);
    r = Number(r);
    x = 150.0 + x * 100.0 / r;
    y = 150.0 - y * 100.0 / r;
    return '<circle class="points" r="3" cx="' + x + '" cy="' + y + '"></circle>';
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
    let r = Number($('input[name="r"]:checked').val());
    console.log(r + " r");
    x = Number(x);
    y = Number(y);
    x = x * r;
    y = y * r;
    $("#x-field").val(x);
    $("#y-field").val(y);
    $("#request").submit();
}