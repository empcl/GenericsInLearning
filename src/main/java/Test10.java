import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 泛型与数组
 * 可以声明带泛型的数组引用（如fun2(), fun3()），但是不能直接创建带泛型的数组对象(如fun1())
 * 可以通过 java.lang.reflect.Array 的 newInstance(Class<T>, int) 创建 T[] 数组，如fun4()
 */
public class Test10 {
    @Test
    public void fun1() {
//        final ArrayList<String>[] arrayLists = new ArrayList<String>[5];
    }

    @Test
    public void fun2() {
        // 类型不确定
        // java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
        ArrayList[] list = new ArrayList[5];
        final ArrayList<String>[] listArr;
        listArr = list;

        final ArrayList<Integer> intList = new ArrayList<>();
        intList.add(100);

        list[0] = intList;
        final String content = listArr[0].get(0);
        System.out.println(content);
    }

    @Test
    public void fun3() {
        final ArrayList<String>[] listArr = new ArrayList[5];

        final ArrayList<String> strList = new ArrayList<>();
        strList.add("A");

        listArr[0] = strList;
        final String content = listArr[0].get(0);
        System.out.println(content);
    }

    @Test
    public void fun4() {
        final Fruit<String> fruits = new Fruit<>(String.class, 3);
        fruits.put(1, "B");
        fruits.put(2, "A");

        System.out.println(fruits.get(2));
        System.out.println(Arrays.toString(fruits.getAll()));
    }
}

class Fruit<T> {
//    private T[] array = new T[3];

    private T[] array;

    @SuppressWarnings("unchecked")
    public Fruit(Class<T> clazz, int len) {
        // 通过Array.newInstance创建泛型数组
        this.array = (T[]) Array.newInstance(clazz, len);
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {
        return array[index];
    }

    public T[] getAll() {
        return array;
    }
}
