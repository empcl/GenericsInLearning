import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 类型擦除
 */
public class Test09 {
    @Test
    public void fun1() {
        final ArrayList<Integer> integerArrayList = new ArrayList<>();
        final ArrayList<String> stringArrayList = new ArrayList<>();

        final Class<? extends ArrayList> clazz1 = integerArrayList.getClass();
        final Class<? extends ArrayList> clazz2 = stringArrayList.getClass();
        System.out.println(clazz1);
        System.out.println(clazz2);

        System.out.println(clazz1 == clazz2);
    }

    @Test
    public void fun2() {
        final Erasure<Integer> erasure = new Erasure<>();
        final Class<? extends Erasure> clazz = erasure.getClass();

        final Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            // key ---- Integer -> Object 类型擦除
            System.out.println(field + "\t" + field.getName() + "\t" + field.getType());
        }
        System.out.println("==================");
        final Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if ("show".equals(method.getName())) {
                System.out.println(method + "\t" + method.getName() + "\t" + method.getReturnType());
            }
        }
    }

    @Test
    public void fun3() {
        final Class<InfoImpl> infoClass = InfoImpl.class;
        final Method[] methods = infoClass.getDeclaredMethods();

        for (Method method : methods) {
            System.out.println(method.getName() +" , " + method.getReturnType());
        }
    }
}

//class Erasure<T> { // fun1()
class Erasure<T extends Number> {
    private T key;

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public <T extends List> T show(T t) {
        return t;
    }
}

interface Info<T> {
    T info(T t);
}

class InfoImpl implements Info<Integer> {

    @Override
    public Integer info(Integer value) {
        return value;
    }
}