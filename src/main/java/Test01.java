import java.util.ArrayList;
import java.util.Random;

public class Test01 {
    public static void main(String[] args) {
        final ProductGetter<String> productGetter1 = new ProductGetter<>();
        String[] products = {"A", "B", "C"};

        for (String product : products) {
            productGetter1.addProduct(product);
        }

        System.out.println("====> " + productGetter1.getProduct());

        System.out.println("---------------------------------------------");

        final ProductGetter<Integer> productGetter2 = new ProductGetter<>();
        int[] intProducts = {1, 2, 3};

        for (int intProduct : intProducts) {
            productGetter2.addProduct(intProduct);
        }

        System.out.println("....." + productGetter2.getProduct());

    }
}

class ProductGetter<T> {
    Random random = new Random();
    ArrayList<T> list = new ArrayList<T>();

    public void addProduct(T t) {
        list.add(t);
    }

    public T getProduct() {
        return list.get(random.nextInt(list.size()));
    }
}
