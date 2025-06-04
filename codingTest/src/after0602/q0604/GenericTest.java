package after0602.q0604;

public class GenericTest {

    public static void main(String[] args) {
        Box<String> box1 = new Box<>();
        box1.contnet = "안녕하세요";
        String str = box1.contnet;
        System.out.println(str);


        Box<Integer> box2 = new Box<>();
        box2.contnet = 100;
        Integer value = box2.contnet;
        System.out.println(value);

        Product<Tv, String> product1 = new Product<>();
        product1.setKind(new Tv());
        product1.setModel("스마트 TV");

        Tv tv = product1.getKind();
        String tvModel = product1.getModel();

        Product<Car, String> product2 = new Product<>();
        product2.setKind(new Car());
        product2.setModel("SUV자동차");

        Car car = product2.getKind();
        String carModel = product2.getModel();

        HomeAgency homeAgency = new HomeAgency();
        Home home = homeAgency.rent();
        home.turnOnLight();

        CarAgency carAgency = new CarAgency();
        Carr carr = carAgency.rent();
        carr.run();


    }
}
