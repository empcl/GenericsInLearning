public class Test03 {
    public static void main(String[] args) {

    }
}

class SimpleGeneric<T> {
    public T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}

class ChildSimpleGeneric extends SimpleGeneric<String> {
    @Override
    public String getT() {
        return super.getT();
    }

    @Override
    public void setT(String s) {
        super.setT(s);
    }
}