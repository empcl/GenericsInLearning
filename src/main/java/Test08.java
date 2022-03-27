import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class Test08 {
    public static void main(String[] args) {
        final ArrayList<Animal> animals = new ArrayList<>();
        final ArrayList<Cat> cats = new ArrayList<>();
        final ArrayList<MiniCat> miniCats = new ArrayList<>();

//        cats.addAll(animals);
        cats.addAll(miniCats);

//        showAnimal(animals);
        showAnimal(cats);
        showAnimal(miniCats);

        showAllAnimal(animals);
        showAllAnimal(cats);
//        showAllAnimal(miniCats);

        comparator();
    }

    /**
     * 类型通配符下限的使用
     */
    public static void comparator() {
        final TreeSet<Cat> cats = new TreeSet<>(new Comparator1());
//        final TreeSet<Cat> cats = new TreeSet<>(new Comparator2());
//        final TreeSet<Cat> cats = new TreeSet<Cat>(new Comparator3());
        cats.add(new Cat("c1", 1));
        cats.add(new Cat("c3", 3));
        cats.add(new Cat("c2", 2));

        for (Cat cat : cats) {
            System.out.println(cat);
        }
    }

    /**
     * 类型通配符下限，要求集合只能是Cat或者Cat的父类类型
     * @param list
     */
    public static void showAllAnimal(List<? super Cat> list) {
        list.add(new Cat("c1", 1));
        // 可以填充子类元素，但是不能填充父类元素
        list.add(new MiniCat("c2", 2, 2));
//        list.add(new Animal());
        for (Object o : list) {
            System.out.println(o);
        }
    }

    /**
     * 泛型上线通配符，传递的集合类型，只能是Cat或者Cat子类
     */
    public static void showAnimal(List<? extends Cat> list) {
        // list 在这里不能填充元素，因为这里确认不了list中的数据类型
//        list.add(new Cat());
//        list.add(new MiniCat());
//        list.add(new Animal());

        for (Cat cat : list) {
            System.out.println(cat);
        }
    }



}

class Animal {
    public String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Cat extends Animal {
    public int age;

    public Cat(String name, int age) {
        super(name);
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class MiniCat extends Cat {
    public int level;

    public MiniCat(String name, int age, int level) {
        super(name, age);
        this.level = level;
    }

    @Override
    public String toString() {
        return "MiniCat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", level=" + level +
                '}';
    }
}

class Comparator1 implements Comparator<Animal> {

    @Override
    public int compare(Animal o1, Animal o2) {
        return o1.name.compareTo(o2.name);
    }
}

class Comparator2 implements Comparator<Cat> {

    @Override
    public int compare(Cat o1, Cat o2) {
        return o1.age - o2.age;
    }
}

class Comparator3 implements Comparator<MiniCat> {

    @Override
    public int compare(MiniCat o1, MiniCat o2) {
        return o1.level - o2.level;
    }
}


