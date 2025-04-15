//let strToDay = new Date();
//console.log(`오늘 날짜는 ${strToDay} 입니다`);
//console.log(`오늘 년도는 ${strToDay.getFullYear()} 입니다`);
//console.log(`오늘 월는 ${strToDay.getMonth()+1} 입니다`);
//console.log(`오늘 일는 ${strToDay.getDate()} 입니다`);
//console.log(`지금 시간는 ${strToDay.getHours()} 입니다`);
//console.log(`지금 분는 ${strToDay.getMinutes()} 입니다`);
//console.log(`지금 초는 ${strToDay.getSeconds()} 입니다`);
//
//strToDay.setDate(strToDay.getDate()+50);
//strToDay.setMinutes(strToDay.getMinutes()+50);
//console.log(`50일을 더한 날짜는 ${strToDay} 입니다.`);
//console.log(`60분을 더한 날짜는 ${strToDay} 입니다.`);
//
//
//console.log(Math.round(10.17));
//console.log(Math.ceil(10.17));
//console.log(Math.floor(10.17));
//console.log(Math.trunc(10.17));
//
//console.log(`Math.random() = ${Math.random()}`);

let numList = [];


for(let size=0;size<6;){
    let num = Math.floor(Math.random()*45)+1;
    if(isEquals(num)){
    numList[size] = num;
    size++;
    }
}
numList.sort(function(a, b){return a-b});
console.log(numList)

function isEquals(num){
    for(let i=0; i<numList.length; i++){
    if(numList[i] == num){
        return false;
    }
    }
    return true;
}

class Wizard{
     health=0;
     mana=0;
     armor=0;

    constructor(health,mana,armor){
    this.health= health;
    this.mana= mana;
    this.armor= armor;
    }

     attack(){
        console.log(`파이어볼`);
    }

}

const x =new Wizard(545,210,10);
console.log(x.health, x.mana, x.armor);
x.attack();