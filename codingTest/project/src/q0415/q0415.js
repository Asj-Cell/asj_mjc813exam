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

//let list =["수성","금성","지구","화성","목성","토성","천왕성","해왕성"];
//let num = prompt("숫자를 입력하세요");
//let result = list[num-1];
//console.log(result);

        let newArray=[];
        let size=0;
        let input = prompt("입력");
        for(let i = input.length-1; i>=0; i--){
            newArray[size]=input.charAt(i);
            size++;
        }
        let real=newArray.toString().;
        console.log(`출력: +${real}`);