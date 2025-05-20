//
//
//function solveExam40() {
//    let totalWeight = document.getElementById("exam40_01").value;
//    // html 태그에서 id="exam04_01" 인 value 속성을 가져온다.
//    // html 태그에서 id="exam40_01" 인 value 속성을 가져온다.
//    let countFriends = document.getElementById("exam40_02").value;
//    // html 태그에서 id="exam04_02" 인 value 속성을 가져온다.
//    // html 태그에서 id="exam40_02" 인 value 속성을 가져온다.
//    let strFriendWeights = document.getElementById("exam40_03").value;
//    // html 태그에서 id="exam04_03" 인 value 속성을 가져온다.
//    // html 태그에서 id="exam40_03" 인 value 속성을 가져온다.
//    if ( checkValidInputExam40(totalWeight, countFriends, strFriendWeights) ) {
//        // checkValidInputExam40 함수가 참이면 실행한다.
//        let exam40 = new Exam40(totalWeight, countFriends, strFriendWeights);
// class Exam40 {
//        }
//        return i;
//    }
//}




//function solveExam41() {
//    let number = document.getElementById("exam41_01").value;
//    // html 태그에서 id="exam41_01" 인 value 속성을 가져온다.
//    if (checkValidInputExam41(number)) {
//        // checkValidInputExam41 함수가 참이면 실행한다.
//        let exam41 = new Exam41(number);
//        let result = exam41.solve();
//        document.getElementById("exam41result").innerText = result;
//    }
//}
//
//function checkValidInputExam41(number) {
//    if ( number <= 2 ) {
//        alert("숫자는 2 이상 입력하세요.");
//        return false;
//    }
//          return true;
//        }
//
//class Exam41 {
//    number = 0;
//    countFriends = 0;
//    arrFriendWeights = [];
//
//    constructor(number) {
//    // new Exam41(a);
//    // Exam41 클래스를 인스턴스객체로 생성하는 비 기본생성자
//        this.number = Number(number);
//    }
//
//    solve() {
//        for(let i =this.number-1; i>=2; i--) {
//            if(this.number % i === 0){
//            return false;
//            }
//            // this.number 를 하나씩 뺀 값을 이용하여
//            // this.number % this.number - 1 === 0 ===> 나머지가 0이면 소수가 아님
//            // this.number % this.number - 2 === 0 ===> 나머지가 0이면 소수가 아님
//            // this.number % this.number - 3 === 0 ===> 나머지가 0이면 소수가 아님
//            // this.number % 2 === 0    ===> 2 까지 수행해본다.
//        }
//        return true;
//    }
//}
//
////const exam41 = new Exam41()
//function checkValidInputExam53(strMessage){
//    if(strMessage.length <= 2){
//        alert("문자열을 2글자이상 입력하세요.")
//        return false;
//    }
//    return true;
//}
//
//
//function solveExam53() {
//    let strMessage = prompt("문자열을 입력하세요");
//    let result =[];
//    if(checkValidInputExam53(strMessage)){
//        for(let i=0; i<strMessage.length;i++){
//            if(strMessage[i] == ")"){
//                if(result.length <= 0){
//                console.log("no");
//                }
//                result.pop();
//            } else if(strMessage[i] == "("){
//                result.push("d");
//            }
//        }
//        if(result.length != 0){
//            console.log("no");
//        }
//        console.log("yes");
//
//    }
//
//
//}
