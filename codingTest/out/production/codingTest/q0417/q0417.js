class Exam27 {
    maps = new Map();

    inputFunc() {
        let names = prompt("이름을 공백으로 구분하여 입력하세요.");
        let score = prompt("점수를 공백으로 구분하여 입력하세요.");
        let arrName = names.split(" ");
        let arrScore = score.split(" ");
        if (arrName.length != arrScore.length) {
            alert("두개 배열의 길이가 다릅니다. 다시 시작하세요.");
            return false;   // 함수가 false 를 리턴한다.
        }

        for(let iterator=0; iterator<arrName.length;iterator++){
        this.maps.set(arrName[iterator], Number(arrScore[iterator])); // Number 는 문자열을 숫자로 변경
        }

        console.log(this.maps);
        return true;    // 함수가 true 를 리턴한다.
    }
    outputFunc() {
        let strOutput = "{";

        for( let item of this.maps ) {
            strOutput += `'${item[0]}': ${item[1]}, `
        }
        strOutput = strOutput.substring(0 , strOutput.length - 2);
        // 문자열의 길이에서 -2 시킨 길이의 문자열로 다시 저장. "abcd" => "ab"
        strOutput += "}";
        console.log(strOutput);
    }
}

let exam = new Exam27();
if ( exam.inputFunc() ) {   // inputFunc() 를 실행하고 리턴값이 true 이면
    exam.outputFunc();  // outputFunc() 를 실행한다.
}


class Str{


     input(){
     let str = prompt("문자열 입력");
     let resultStr = str.split("");


     for(let i =0; i< resultStr.length; i++){
        let temp ="";
        if(i == resultStr.length-2){
        temp= resultStr[i]+resultStr[i+1];
        console.log(temp);
        break;
        }

        temp = resultStr[i]+ resultStr[i+1];
        console.log(temp);
     }

     }
}
const x = new Str();
x.input();
