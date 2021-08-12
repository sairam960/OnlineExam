var i = 0;
/*var jsonData = [
    {
        "q" : "The common element which describe the web page, is ?",
        "opt1" : "heading",
        "opt2" : "paragraph",
        "opt3" : "All of these",
        "answer" : "All of these"
    },
    {
        "q" : "HTML stands for?",
        "opt1" : "Hyper Text Markup Language",
        "opt2" : "High Text Markup Language",
        "opt3" : "Hyper Tabular Markup Language",
        "answer" : "Hyper Text Markup Language"
    },
    {
        "q" : "which of the following tag is used to mark a begining of paragraph ?",
        "opt1" : "TD",
        "opt2" : "br",
        "opt3" : "P",
        "answer" : "P"
    },
    {
        "q" : "From which tag descriptive list starts ?",
        "opt1" : "LL",
        "opt2" : "DL",
        "opt3" : "DD",
        "answer" : "DL"
    },
    {
        "q" : "Correct HTML tag for the largest heading is _____",
        "opt1" : "h1",
        "opt2" : "h6",
        "opt3" : "heading",
        "answer" : "h1"
    }
]; */
var correctCount = 0 ;
//initialize the first question
generate(0);
// generate from json array data with index
function generate(index) {
    document.getElementById("question").innerHTML = jsonData[index].q;
    document.getElementById("optt1").innerHTML = jsonData[index].opt1;
    document.getElementById("optt2").innerHTML = jsonData[index].opt2;
    document.getElementById("optt3").innerHTML = jsonData[index].opt3;
}

function checkAnswer() {
    if (document.getElementById("opt1").checked && jsonData[i].opt1 == jsonData[i].answer) {
       correctCount++;
    }
    if (document.getElementById("opt2").checked && jsonData[i].opt2 == jsonData[i].answer) {
        correctCount++;
    }
    if (document.getElementById("opt3").checked && jsonData[i].opt3 == jsonData[i].answer) {
        correctCount++;
    }
    // increment i for next question
    i++;
    if(jsonData.length-1 < i){
        document.write("<body style='background-color:lightblue;'>");
        document.write("<div style='color:#ffffff;font-size:18pt;text-align:center;'>*****Your score is : "+correctCount+"*****</div>");
        document.write("</body>");
    }
    // callback to generate
    generate(i);
}