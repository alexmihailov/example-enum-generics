package ru.digitalleague.generics.example4;

public class BoundedTypeParametersExample {

    public static void main(String[] args) {
// 1. Пример использования Bounded Type + возможность вызов методов базового типа
        usageBoundedTypeExample();
// 2. Пример Multiple Bounds
        multipleBoundsExample();
    }

    private static void usageBoundedTypeExample() {
        NumbersList<Integer> intList = new NumbersList<>();
        NumbersList<Float> floatList = new NumbersList<>();
// При попытке указать тип, которые не наследуется от java.lang.Number получаем ошибку.
//        NumbersList<String> stringList = new NumbersList<>();

        intList.add(100);
        intList.add(200);
        System.out.println(intList.sum());

        floatList.add(256.6f);
        floatList.add(300.6f);
        System.out.println(floatList.sum());
    }

    private static void multipleBoundsExample() {
// Так как класс D наследуется от класса А и реализует интерфейсы B и C,
// то мы можем его использовать в качестве параметра типа
        Box<D> box = new Box<>(new D());
        System.out.println(box.getAllNames());
    }

    public static abstract class A {
        public String classA() {
            return "class A";
        }
    }

    public interface B {
        default String interfaceB() {
            return "interface B";
        }
    }

    public interface C {
        default String interfaceC() {
            return "interface C";
        }
    }

    public static class D extends A implements B, C {
    }

// Для параметра T задано множественное ограничение -
// он обязан наследоваться от класса А и реализовывать интерфейсы B и C.
    public static class Box<T extends A & B & C> {
        private final T value;

        public Box(T value) {
            this.value = value;
        }

        public String getAllNames() {
            return value.classA() + " " + value.interfaceB() + " " + value.interfaceC();
        }
    }

// Если в множественных ограничениях присутствует класс, то он должен быть на первой позиции.
//    public static class Box2<T extends B & A & C> {
//    }
}
