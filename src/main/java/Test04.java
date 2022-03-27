public class Test04 {
    public static void main(String[] args) {
        final Banana<Integer> banana = new Banana<>(2);
        System.out.println(banana.getKey());
    }
}

/**
 * 泛型接口的实现类，是一个泛型类，
 * 那么要保证实现接口的泛型类泛型标识包含泛型接口的泛型标识
 * @param <T>
 */
class Banana<T> implements FruitGenerator<T> {
    private T key;

    public Banana(T key) {
        this.key = key;
    }

    @Override
    public T getKey() {
        return key;
    }
}

/**
 * 实现泛型接口的类，不是泛型类，需要明确泛型接口的数据类型
 */
class Apple implements FruitGenerator<String> {

    @Override
    public String getKey() {
        return "generator apple";
    }
}

interface FruitGenerator<T> {
    T getKey();
}

