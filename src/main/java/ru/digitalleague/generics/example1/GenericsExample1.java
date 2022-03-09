package ru.digitalleague.generics.example1;

import java.math.BigDecimal;
import java.util.Random;

public class GenericsExample1 {

    public static void main(String[] args) {
// 1. Показать, как создавать параметризованные типы и преимущества их использования.
        advantagesUsageGenerics();
// 2. Показать пример diamond.
        diamondUsageInInstantiatingGeneric();
// 3. Показать множественные параметры типов,
// параметры в интерфейсе ru.digitalleague.generics.example1.Pair
// использование обобщенного программирования (пере использование кода).
        multipleTypeParameters();
    }

    private static void advantagesUsageGenerics() {
        String originalValue = "Hello, World";

        OldBox oldBox = new OldBox();
        oldBox.set(originalValue);
// Так как в метод мы можем передать Object, то можно ошибиться и вместо ожидаемого далее
// объекта типа String, передать объект типа BigDecimal
//        oldBox.set(BigDecimal.ONE);

        String value = null;
// Так как метод get возвращает Object, то нужно делать явное приведение типа.
        value = (String) oldBox.get();
// Если мы не уверены, что именно вернет метод get, то нужно дополнительно добавлять проверку типа.
//        if (oldBox.get() instanceof String) {
//            value = (String) oldBox.get();
//        }
        System.out.println(value);

// Для создания объекта параметризованного типа нужно указать имя класса,
// а в угловых скобках задать тип-параметр.
        NewBox<String> newBox = new NewBox<String>();
        newBox.set(originalValue);
// Так как класс NewBox параметризован, то мы не можем передать объект другого типа.
// Это способствует улучшению кода и обнаружению ошибок во время компиляции.
//        newBox.set(BigDecimal.ONE);
// При использовании generic отпадает необходимость проверки типа и кастинга.
        value = newBox.get();
        System.out.println(value);
    }

    private static void diamondUsageInInstantiatingGeneric() {
        NewBox<String> newBox1 = new NewBox<String>();
// Начиная с Java 7 для создания объекта класса (в правой части выражения перед оператором new)
//, использующего generic можно не задавать имя типа параметра.
// Компилятор выведет значение из контекста (левой части выражения).
// Такое использование (<>) называется бриллиантовым(diamond).
        NewBox<String> newBox2 = new NewBox<>();
    }

    private static void multipleTypeParameters() {
// У generics имеется возможность множественного задания типов параметров.
        Pair<Integer, String> orderedPair = new OrderedPair<>(1, "One");

// Нельзя предать в конструктор объект типа отличного от указанного в параметрах типа.
//        Pair<Integer, String> orderedPairV2 = new OrderedPair<>(1, new Random());

        Pair<Integer, Integer> orderedPairInt = new OrderedPair<>(1, 1);
        Pair<Integer, Integer> integerPair = new IntegerPair(2, 2);
// По сути класс IntegerPair не нужен, так как OrderedPair может вполне его заменить,
// используя конструкцию OrderedPair<Integer, Integer>. Но при этом OrderedPair имеет преимущество в том,
// что код написанный один раз может применяться для любых типов данных.
// Именно все коллекции и распространенные классы являются параметризованными типами.
// (открыть java.util.Collection)
        System.out.println(orderedPair);
        System.out.println(orderedPairInt);
        System.out.println(integerPair);

// Параметризованные типы можно использовать в качестве параметров типа для других параметризованных типов.
        NewBox<Integer> box = new NewBox<>();
        box.set(200);
        Pair<String, NewBox<Integer>> pairBox = new OrderedPair<>("string value", box);
        System.out.println(pairBox);
    }
}
