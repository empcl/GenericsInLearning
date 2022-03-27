import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test05 {
    public static void main(String[] args) {
        final Product<String> product = new Product<>();

        final ArrayList<Integer> contents = new ArrayList<>();
        contents.add(0);
        contents.add(1);
        contents.add(2);

        final Integer result = product.getProductByList(contents);
        System.out.println(result);

        System.out.println("--------------------------------");

        Product.print(100, "Jack", true);

        System.out.println("--------------------------------");

        Product.print(true, 100, "CK");

        System.out.println("--------------------------------");

        Product.print(1, 2, 3, 4);

        System.out.println("--------------------------------");

        Product.print("a", "b", "c", "d");

    }
}

class Product<T> {
    Random random = new Random();
    ArrayList<T> list = new ArrayList<T>();

    public void addProduct(T t) {
        list.add(t);
    }

    public T getProduct() {
        return list.get(random.nextInt(list.size()));
    }

    public void addProduct(List<T> products) {
        list.addAll(products);
    }

    /**
     * 泛型方法的标记独立于所属的类
     */
    public <E> E getProductByList(List<E> products) {
        return products.get(0);
    }

    public static <T,E,K> void print(T t, E e, K k) {
        System.out.println(t + "\t" + t.getClass().getName());
        System.out.println(e + "\t" + e.getClass().getName());
        System.out.println(k + "\t" + k.getClass().getName());
    }

    /**
     * 如果static方法要使用泛型能力，就必须使其成为泛型方法
     */
    public static <T> void print(T... e) {
        for (T t : e) {
            System.out.println(t);
        }
    }
}