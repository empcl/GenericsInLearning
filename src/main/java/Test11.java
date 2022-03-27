import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * 泛型和反射
 *  Class<T>
 *  Constructor<T>
 */
public class Test11 {
    @Test
    public void fun1() throws NoSuchMethodException, InstantiationException, IllegalAccessException {
        final Class<Person> clazz = Person.class;
        final Constructor<Person> constructors = clazz.getConstructor();

        final Person person = clazz.newInstance();
    }
}

class Person {
    private String name;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
