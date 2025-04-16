class Square{
    run(num1,num2){
    let result = 1;
     for (let i = 0; i < num2; i++) {
       result *= num1;
     }
     return result;
    }
}
const test0 = new Square();
let result=test0.run(10,3);
console.log(result);


class Planet{
    run(){
        let result = prompt("행성이름을 입력하세요");
        switch (result) {
         case "수성" :
                       console.log("Mercury");
                        break;
                    case "금성" :
                        console.log("Venus");
                        break;

                    case "지구" :
                        console.log("Earth");
                        break;

                    case "화성" :
                       console.log("Mars");
                        break;

                    case "목성" :
                        console.log("Jupiter");
                        break;

                    case "토성" :
                       console.log("Saturn");
                        break;

                    case "천왕성" :
                        console.log("Uranus");
                        break;

                    case "해왕성" :
                       console.log("Neptune");

        }
    }
}
const test1 = new Planet();
test1.run();

class Mathhhhhhhh{

    run(){
     let result = prompt("원의 반지름을 입력하세요");
     return result*result*3.14;
    }

}

const test2 = new Mathhhhhhhh();
let result2=test2.run();
console.log(result2);