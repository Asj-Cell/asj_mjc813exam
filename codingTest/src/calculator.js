let leftNumber = "";
let rightNumber = "";
let operator = "";
let result = "";

function checkWhere(number) {
    if( operator === "" ) {
        leftNumber += number.toString();
    } else {
        rightNumber += number.toString();
    }
    document.getElementById("outDiv").innerText = leftNumber + " " + operator + " " + rightNumber;
}

function buttonNum(number) {
    checkWhere(number);

}

function buttonAdd() {
    operator = "+";
     document.getElementById("outDiv").innerText = leftNumber + " " + operator;
}

function buttonSub() {
    operator = "-";
     document.getElementById("outDiv").innerText = leftNumber + " " + operator;
}

function buttonMul() {
    operator = "*";
     document.getElementById("outDiv").innerText = leftNumber + " " + operator;
}

function buttonDiv() {
    operator = "/";
     document.getElementById("outDiv").innerText = leftNumber + " " + operator;
}

function buttonEqu() {
    try{
    let res = eval(leftNumber + operator + rightNumber);
    switch(operator) {
        case "+":
            result = (Number(leftNumber) + Number(rightNumber)).toString();
            break;
        case "-":
            result = (Number(leftNumber) - Number(rightNumber)).toString();
            break;
        case "*":
            result = (Number(leftNumber) * Number(rightNumber)).toString();
            break;
        case "/":
            result = (Number(leftNumber) / Number(rightNumber)).toString();
            break;
    }
    document.getElementById("outDiv").innerText = leftNumber + " " + operator
     + " " + rightNumber + " = " + result;
     }catch(e){
        console.log("잘못된 입력입니다.")
        alert("잘못된 입력입니다.")
     }

}

function buttonCE() {
    leftNumber = "";
    rightNumber = "";
    operator = "";
    result = "0";
    document.getElementById("outDiv").innerText = result;
}