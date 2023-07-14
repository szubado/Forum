function validate() {
/*
    var title = document.getElementById("title");
    var text = document.getElementById("text");

    var info = document.getElementById("info");

    var titleRegex = /^.{5,}$/;
    var textRegex = /^.{5,}$/;

    var result = true;
    var infoResult = "";

    if(!titleRegex.test(title.value)) {
        infoResult = infoResult + "Zły tytuł tematu <br>";
        title.style.background = "#ffcc00";
        result = false;
    } else {
        title.style.background = "#ffffff";
    }

    if(!textRegex.test(text.value)) {
        infoResult = infoResult + "Zły post <br>";
        text.style.background = "#ffcc00";
        result = false;
       } else {
        text.style.background = "#ffffff";
       }

    info.innerHTML = infoResult;
    return result;
*/
var title = document.getElementById("title");
var text = document.getElementById("text");
var info = document.getElementById("info");

var nameRegex = /^.{5,}$/;

if(!nameRegex.test(title.value)) {
info.innerHTML = "Zły temat";
return false;
}
if(!nameRegex.test(text.value)) {
info.innerHTML = "Zły post";
return false;
}
return true;
}