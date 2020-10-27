function selectCheckBox(checkBox) {
    $(':checkbox[name="r"]').prop("checked", false);
    $(checkBox).prop("checked", true);
}

function validation(input) {
    let value = $(input).val().replace(/,/,".");
    if (value === "" || isNaN(value) || (Number(value) >= 5 || Number(value) <= -5)) {
        setDesignInput(input, "#f5e0d9", "2px solid #f64072");
    } else {
        setDesignInput(input, "WHITE", "1px solid #000000");
    }
}

function setDesignInput(input, color, border) {
    $(input).css("border", border);
    $(input).css("background", color);
}

function buildRequest() {

}

function clickSvg(svg) {
    // let point = document.createElement("circle");
    // point.className = "figures";
    // point.cx = "150";
    // point.cy = "150";
    // point.r = "10";
    // $(svg).append(point);
    // let e = svg.target;
    // let dim = e.getBoundingClientRect();
    // let x = svg.clientX - dim.left;
    // let y = svg.clientY - dim.top;
    // alert("x: "+x+" y:"+y);
    let p = $("#graph").createSVGPoint();
    p.x = e.clientX;
    p.y = e.clientY;
    let ctm = $("#graph").getScreenCTM().inverse();
    p =  p.matrixTransform(ctm);
    console.log("x: "+p.x+" y:"+p.y);
}

// let debug = false;


// function getX() {
//     return Number($('input[name="radioGroup"]:checked').val());
// }
//
// function whiteColorInput() {
//     $("#yValue").css("border", "1px solid #000000");
//     $("#yValue").css("background", "WHITE");
// }
//
// function getAndCheckY() {
//     let srcY = $("#yValue").val().replace(/,/,".");
//     if (debug) {
//         console.log("y = " + srcY);
//     }
//
//     if (srcY === "" || isNaN(srcY) || (Number(srcY) > 3 || Number(srcY) < -3)) {
//         $("#yValue").css("border", "2px solid #f64072");
//         $("#yValue").css("background", "#f5e0d9");
//     } else {
//         return Number(srcY);
//     }
// }
//
// function selectR(button) {
//     $('.selected').removeClass("selected").addClass("not_selected");
//     button.classList.remove("not_selected");
//     button.classList.add("selected")
//
//     if (debug) {
//         console.log("r = " + button.value);
//     }
// }

// function buildRequest() {
//
//     x = getX();
//     y = getAndCheckY();
//     r = $('.selected').val()
//
//     if (debug) {
//         console.log(x + " " + y + " " + r);
//     }
//
//     if (x !== undefined && y !== undefined && r !== undefined) {
//         $.ajax({
//             url: "php/handler_is_hit.php",
//             type: "GET",
//             data: {"x": x, "y": y, "r": r},
//             success: function (response) {
//                 addRowTable(response);
//             }
//         });
//     }
// }
//
// function addRowTable(data) {
//     $("#tableResult").append(data);
//
//     if (debug) {
//         console.log(data);
//     }
// }