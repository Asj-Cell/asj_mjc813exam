class Car{

    name = "";
    model = "";
    weight = "";
    color = "";

    constructor(name,model,weight,color){
        this.name = name;
        this.model = model;
        this.weight = weight;
        this.color = color;
    }
    start(){
        alert(JSON.stringify(this,0,4) + "출발합니다.");
    }
    drive(){
        console.log(this.name + "운전합니다.");

    }

    brake(){
        console.log(this.name + "브래이크 페달 밟아요.");

    }

    stop(){
        console.log(this.name + "정지합니다.");

    }
     showRedSign(){
            console.log(this.name + "빨간불을 봤습니다.");
            this.brake();
        }

//    printCarInformation() {
//        alert(JSON.stringify(this,null,2))
//
//    }

}
    let accentMD = new Car("Accent","MD","700kg","gray");
    accentMD.start();
    accentMD.drive();
    accentMD.showRedSign();

//      Const car = new Car("car1", 500,"850kg","write");
//
//    showInfo(){
//      car.printCarInformation();
//    }
class Zeep extends Car{

    engine = "";
    constructor(name,model,weight,color,engine){
        super(name,model,weight,color);
        this.engine=engine;
    }

    fourWd(){
        console.log(this.name+", "+this.engine+"4횔 입니다.");
    }
}

    let zeep1 =new Zeep("코란도4","코란도","1200kg","brown","120마력");
    zeep1.start();
    zeep1.drive();
    zeep1.fourWd();
    zeep1.stop();




