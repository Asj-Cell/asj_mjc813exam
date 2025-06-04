package after0602.q0604;

public class CarAgency implements Rentable<Carr>{
    @Override
    public Carr rent() {
        return new Carr();

    }
}
