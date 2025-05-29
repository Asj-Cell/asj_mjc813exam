//let str = "Javascript strings are primitive and immutable: All string methods produce a new string without altering the original string.";
//
//    function splitStr(str){
//         let sArrays = str.split(" ");
//           return sArrays;
//    }
//
//   function swapChar(str){
//    let result="";
//          for(let char of str){
//            if(char ===char.toUpperCase()){
//                result += char.toLowerCase();
//            }else{
//                result += char.toUpperCase();
//            }
//          }
//         return result;
//
//    }
//    function convert(str){
//        let newStr=str.replaceAll("string","문자열");
//        return newStr;
//    }
//
//
//    console.log(swapChar(str));
//    console.log(splitStr(str));
//    console.log(convert(str));
//class Question0410 {
//    strExam = "Javascript strings are primitive and immutable: All string methods produce a new string without altering the original string.";
//
//    exam1() {
////- 위의 문장을 각 단어가 원소인 배열로 변환하기
////    => ["Javascript", "strings", "are", ....]
//        let arrExam1 = this.strExam.split(" ");
//        document.getElementById("result1").innerText = arrExam1;
//    }
//
//    exam2() {
////- 대문자 -> 소문자, 소문자는 -> 대문자로 바꾸어서 문장으로 만들기
////	=> jAVASCRIPT STRINGS ARE ....
//        let result2 = "";
//        for( let i = 0; i < this.strExam.length; i++ ) {
//            let ch = this.strExam.charAt(i);
//            if ( ch >= 'A' && ch <= 'Z' ) {
//                result2 += ch.toLowerCase();
//            } else if ( ch >= 'a' && ch <= 'z' ) {
//                result2 += ch.toUpperCase();
//            } else {
//                result2 += ch;
//            }
//        }
//        document.getElementById("result2").innerText = result2;
//    }
//
//    exam3() {
////- 위의 문장에서 [string] 이라는 단어를 [문자열] 으로 변환하기
////	=> Javascript 문자열s are ....
//        let result3 = this.strExam.replaceAll("string", "문자열");
//        document.getElementById("result3").innerText = result3;
//    }
//}
//
//let question = new Question0410();
//question.exam1();
//question.exam2();
//question.exam3();

  let str= "Javascript strings are primitive and immutable: All string methods produce a new string without altering the original string.";


  function indexConvert1(str){
  let split = str.split(" ");


 if (split.indexOf("string") != -1) {
    let i = split.indexOf("string");
   return i;
     }

      return -1;
    }

 function indexConvert2(str){
  let split = str.split(" ");
 if (split.indexOf("string") != -1) {
    let i = split.indexOf("string");
   return split[i];
     }

      return -1;
    }

function sortAlpha(str){
    let split = str.split(" ");
    split.sort();


    return split;
   }




    console.log(indexConvert1(str));
    console.log(indexConvert2(str));
    console.log(sortAlpha(str));