public class Test07 {
    public static void main(String[] args) {
        final Box<Double> box1 = new Box<>();
        box1.setFirst(100d);
        showBox(box1);

        System.out.println("--------------------");
        final Box<Integer> box2 = new Box<>();
        box2.setFirst(200);
        showBox(box2);
    }

    public static void showBox(Box<? extends Number> box) {
        final Object first = box.getFirst();
        System.out.println(first);
    }
}

class Box<E> {
    private E first;

    public E getFirst() {
        return first;
    }

    public void setFirst(E first) {
        this.first = first;
    }
}