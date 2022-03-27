public class Test02 {
    public static void main(String[] args) {

    }
}

class Generic<T> {
    T t;
}

class ChildGeneric<T, E> extends Generic<T> {
    E e;
}
