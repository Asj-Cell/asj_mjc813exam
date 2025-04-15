// 이건 별찍기

// let layer = prompt("==층수를 입력하세요==");
//        for (let i = 1; i <= layer; i++) {
//            for (let j = 1; j < layer-i; j++) {
//                document.write("&nbsp;");
//            }
//            for (let j = 1; j <= 2*i-1; j++) {
//                 document.write("*");
//            }
//            document.write("<br>");
//
//        }


// 이건 행성 출력
//let list =["수성","금성","지구","화성","목성","토성","천왕성","해왕성"];
//let num = prompt("숫자를 입력하세요");
//let result = list[num-1];
//console.log(result);


// 이건 문자열 거꾸로
//        let newArray=[];
//        let size=0;
//        let input = prompt("입력");
//        for(let i = input.length-1; i>=0; i--){
//            newArray[size]=input.charAt(i);
//            size++;
//        }
//        let real=newArray.join('');
//        console.log(`출력: +${real}`);
//
class Toy{
    height= prompt("입력");

     isTall(){
        if(this.height > 150){
        console.log("YES");
        }else{
         console.log("NO");
        }

     }
}

const toy=new Toy();
toy.isTall()

class AvgScore{


     avg(){
     let numbs = prompt("좋아하는 숫자 3개 입력");
     let realNumbs=numbs.split(" ");
     let total = 0;
        for(let i =0 ; i< 3; i++){
        total+= Number(realNumbs[i]);
        }
        total = Math.floor(total/3);
       console.log(total);
     }
}
const avgScore=new AvgScore();
avgScore.avg()


class Str{


     input(){
     let str = prompt("문자열 입력");
     for(let i =0; i< str.length; i++){
        let temp ="";
        if(i == str.length-1){
        temp= str[i]+" 끄읏";
        console.log(temp);
        break;
        }

        temp = str[i]+ str[i+1];
        console.log(temp);
     }

     }
}
const x = new Str();
x.input();

class{
   num =;
}