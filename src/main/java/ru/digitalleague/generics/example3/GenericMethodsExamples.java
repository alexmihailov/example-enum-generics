package ru.digitalleague.generics.example3;

import ru.digitalleague.generics.example1.OrderedPair;
import ru.digitalleague.generics.example1.Pair;

public class GenericMethodsExamples {

    public static void main(String[] args) {
// 1. Показать пример статического параметризованного метода и вывод типа.
        staticGenericMethod();
// 2. Показать пример обычного параметризованного метода и конструктора.
        genericMethodAndConstructor();
    }

    private static void staticGenericMethod() {
        Pair<Integer, String> first = new OrderedPair<>(1, "One");
        Pair<Integer, String> second = new OrderedPair<>(2, "Two");

// В базовом синтаксисе можно указать какие параметры типы передаются для метода.
        boolean equals = GenericMethodsExamples.<Integer, String>compare(first, second);
        System.out.println(equals);
// Но компилятор может вывести типы из контекста - type inference
// (в данном случае на основе передаваемых аргументов - они оба имеют типы <Integer, String>.
        boolean equals2 = GenericMethodsExamples.compare(first, second);
// Если будет передавать параметры с другими параметрами типов, то получим ошибку.
//        boolean equals2 = GenericMethodsExamples.compare(first, new OrderedPair<>(10, 10));
        System.out.println(equals2);
    }

// Задаем статический метод с параметрами типов.
    private static <K, V> boolean compare(Pair<K, V> first, Pair<K, V> second) {
        return first.getKey().equals(second.getKey()) &&
                first.getValue().equals(second.getValue());
    }

    private static void genericMethodAndConstructor() {
// Пример параметризованного конструктора.
        GenericType genericType = new <String>GenericType("String value");
// Параметр не даем нам передать объект другого типа.
//        GenericType genericType = new <String>GenericType(100);
// Если изменим на Integer, то получим cast exception.
//        GenericType genericType = new <Integer>GenericType(100);
// Пример параметризованного метода.
        String value = genericType.<String>getValue();
// Так как тут может использовать type inference, то указание параметра типа можно опустить,
// он будет выведен из левой части выражения.
//        String value = genericType.getValue();
        System.out.println(value);
    }
}
