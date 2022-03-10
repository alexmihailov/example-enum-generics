package ru.digitalleague.generics.example8;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LowerBoundedWildcardsExample {

    private static final Random random = new Random();

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        List<Number> numberList = new ArrayList<>();
        List<Comparable<Integer>> comparableList = new ArrayList<>();
        List<Serializable> serializableList = new ArrayList<>();
        List<Object> objectList = new ArrayList<>();

// Передаем List<Integer> - удовлетворяет нижней границе.
        addRandomIntValues(integerList, 10);
// Передаем List<Number> - удовлетворяет нижней границе, так как Integer наследуется от Number.
        addRandomIntValues(numberList, 10);
// Передаем List<Comparable<Integer>> - удовлетворяет нижней границе, так как Integer имплементирует Comparable<Integer>.
        addRandomIntValues(comparableList, 10);
// Передаем List<Serializable> - удовлетворяет нижней границе, так как Integer наследуется от Number,
// а Number имплементирует Serializable.
        addRandomIntValues(serializableList, 10);
// Передаем List<Object> - удовлетворяет нижней границе, так как Integer наследуется от Object.
        addRandomIntValues(objectList, 10);

        System.out.println("integerList: " + Arrays.toString(integerList.toArray()));
        System.out.println("numberList: " + Arrays.toString(numberList.toArray()));
        System.out.println("comparableList: " + Arrays.toString(comparableList.toArray()));
        System.out.println("serializableList: " + Arrays.toString(serializableList.toArray()));
        System.out.println("objectList: " + Arrays.toString(objectList.toArray()));

        List<BigDecimal> bigDecimalList = new ArrayList<>();
// Передаем List<BigDecimal> - не удовлетворяет нижней границе, так как BigDecimal не является суперклассом для Integer.
//        addRandomIntValues(bigDecimalList, 5);
    }

// Определяем метод вставки случайных целых чисел в список.
// Для списка в качестве параметра типа выступает Lower Bounded Wildcard.
// Это значит, что мы можем передавать список с параметром типа Integer
// и всех его супертипов (Number, Comparable<Integer>, Serializable, Object)
    private static void addRandomIntValues(List<? super Integer> list, int count) {
        for (int i = 0; i < count; ++i) {
            list.add(random.nextInt());
        }
    }
}
