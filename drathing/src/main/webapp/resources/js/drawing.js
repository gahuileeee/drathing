document.addEventListener("DOMContentLoaded", function() {
    var canvas = document.getElementById("drawingCanvas");
    var context = canvas.getContext("2d");

    var drawing = false;
    var erasing = false;
    var currentColor = "#FF0000";

    canvas.addEventListener("mousedown", function(e) {
        drawing = true;
        draw(e.pageX - this.offsetLeft, e.pageY - this.offsetTop, false);
    });

    canvas.addEventListener("mousemove", function(e) {
        if (drawing) {
            draw(e.pageX - this.offsetLeft, e.pageY - this.offsetTop, true);
        }
    });

    canvas.addEventListener("mouseup", function() {
        drawing = false;
        context.beginPath();
    });

    canvas.addEventListener("mouseleave", function() {
        drawing = false;
    });

    // 지우개 모드 토글
    document.getElementById("eraserButton").addEventListener("click", function() {
        erasing = !erasing;
        if (erasing) {
            currentColor = "#ffffff"; // 흰색으로 설정하여 지우개 모드
        } else {
            currentColor = document.getElementById("colorPicker").value; // 색상 선택기의 값으로 설정
        }
    });

    // 색상 변경
     document.getElementById("colorPicker").addEventListener("input", function() {
        currentColor = this.value;
        erasing = false;
        toggleEraserSizeUI(false);
    });

    function draw(x, y, isDrawing) {
        if (!isDrawing) {
            context.beginPath();
        }
        context.lineWidth = 5;
        context.lineCap = "round";
        context.strokeStyle = currentColor;
        context.globalCompositeOperation = erasing ? "destination-out" : "source-over";

        context.lineTo(x, y);
        context.stroke();
    }
});

function submitDrawing() {
    var canvas = document.getElementById('drawingCanvas');
    var drawingData = canvas.toDataURL("image/png");

    document.getElementById('drawingDataInput').value = drawingData;

    return true;
}