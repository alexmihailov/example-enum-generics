package ru.digitalleague.generics.example7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UpperBoundedWildcardsExample {

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        List<Float> floatList = new ArrayList<>();
        List<Long> longList = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < 10; ++i) {
            integerList.add(random.nextInt());
            floatList.add(random.nextFloat());
            longList.add(random.nextLong());
        }
// По сути List<Integer>, List<Float>, List<Long> являются подтипами List<? extends Number> (и  List<?>).
        System.out.println("Sum integerList: " + sumOfList(integerList));
        System.out.println("Sum floatList: " + sumOfList(floatList));
        System.out.println("Sum longList: " + sumOfList(longList));

// Так как List<String> не является подтипом List<? extends Number> (тут и срабатывает ограничение),
// но List<String> является подтипом List<?>.
        List<String> stringList = new ArrayList<>();
        stringList.add("first");
        stringList.add("second");
//        System.out.println("Sum stringList: " + sumOfList(stringList));

//  List<String>, List<Integer> являются подтипами List<?> (любой List<TYPE> будет подтипом List<?>).
        System.out.println(joinToString(integerList));
        System.out.println(joinToString(stringList));
    }

// Объявляем метод, который принимает список - в качестве параметра типа выступает Upper Bounded Wildcard.
// Это значит, что в качестве параметра мы сможем передать любой список, у которого в параметре типа будет указан
// наследник класса Number.
    private static double sumOfList(List<? extends Number> list) {
        double s = 0.0;
        for (Number n : list)
            s += n.doubleValue();
        return s;
    }

// В этот метод мы можем передать список с любыми параметрами типа!
    private static String joinToString(List<?> list) {
        StringBuilder builder = new StringBuilder();
        list.forEach(item -> builder.append(item.toString()).append(","));
        return builder.toString();
    }
}
