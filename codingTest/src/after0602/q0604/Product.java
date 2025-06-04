package after0602.q0604;

public class Product <T,K>{

    private T kind;
    private K model;

    public K getModel() {
        return this.model;
    }
    public T getKind() {
        return this.kind;
    }

    public void setModel(K model) {
        this.model = model;
    }
    public void setKind(T kind) {
        this.kind = kind;
    }
}
