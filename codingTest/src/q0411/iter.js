//let array01 = [1,2,3,4,5,6,7,8,9];
//for( let i = 1; i <= 9; i++ ) {
//    // 배열의 모든 원소를 처리하기 위하여
//    // for (시작;조건;증감) {...} i 라는 인덱스 사용
//    console.log(`3 * ${i} = ${3*i}`);
//}
//
//// 배열변수이름.forEach(......)
//
//array01.forEach(function(item) {
//    // forEach 는 배열의 모든 원소를 차례대로 실행하는 이름없는 함수를 선언한다.
//     console.log(`3 * ${item} = ${3*item}`);
//});
//
//
//// 배열변수이름.forEach(......)
//array01.forEach((item) => {
//    // 이름없는 함수는 (매개변수) => { ... } 로 선언 가능하다.
//    console.log(`3 * ${item} = ${3*item}`);
//});




//
//
//// 배열변수이름.forEach(......)
//array01.forEach(myForEach);
//// forEach 는 배열의 모든 원소를 차례대로 myForEach 함수를 이용하여 실행한다.
//function myForEach(item) {
//   console.log(`3 * ${item} = ${3*item}`);
//}
//// 여기서 부터 map
//
//let array02 = ["A","B","C","D"];
//let resultArray02 = array02.map(function(value,index,array){
//    console.log(array)
//
//    return value+index;
//});
//
//console.log(resultArray02);
//
////Filter 결과값이 boolean 형이 나와야 함
//let resultArray03 = array02.filter((v) => {
//    return v > "B" && v < "D";
//});
//
//console.log(resultArray03);
//
//let resultArray03 = array02.filter((v) => {
//    return v== "D";
//});
//console.log(resultArray03);


const numbers1 =[36, 122, 79, 8, "무궁화", 391, "words", 509, 20192
                , "B", 321, 473, 73, "france", "Korea", 24, 99];
numbers1.sort();
//numbers1.sort((a,b) => {return a-b});
numbers1.sort(function(a, b){return a - b});
console.log(numbers1);


let max =numbers1[numbers1.length-1];
console.log(max);



let arr = [];
for(let i=0; i<numbers1.length; i++){

    if(i % 2 == 0){
       arr[i] = numbers1[i];
    }
}
console.log(arr);


let charArr = [];
for(let i=0; i<numbers1.length; i++){

}














