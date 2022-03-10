package ru.digitalleague.generics.example5;

import ru.digitalleague.generics.example1.NewBox;

import java.util.*;

public class GenericInheritanceExample {

    public static void main(String[] args) {
        Integer intValue = 100;
// Так как Integer наследуется от Number, то можем присвоить.
        Number number = intValue;
        System.out.println(number);

        NewBox<Integer> intBox = new NewBox<>();
        intBox.set(intValue);
// NewBox<Integer> и NewBox<Number> это разные типы, поэтому получаем ошибку!
//        NewBox<Number> numberBox = intBox;
        NewBox<Number> numberBox = new NewBox<>();
// Так как Integer наследуется от Number, то вполне его можем передать в качестве параметра.
        numberBox.set(intBox.get());
        System.out.println(numberBox);
// Все классы наследуются от Object, даже если они параметризованные.
        Object objValue = intBox;
        System.out.println(objValue);

        ArrayList<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(10);
        integerArrayList.add(20);
        integerArrayList.add(30);
// List<Integer> является базовым классом для ArrayList<Integer>.
        List<Integer> intList = integerArrayList;
// Collection<Integer> является базовым классом для ArrayList<Integer> и List<Integer>.
        Collection<Integer> intCollections = intList;
// Collection<String> не является базовым классом для ArrayList<Integer> и List<Integer>.
//        Collection<String> stringCollection = intList;

        printCollection(integerArrayList);
        printCollection(intList);
        printCollection(intCollections);

        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("one");
        hashSet.add("two");
// HashSet<String> наследуется от Collection<String>.
        printCollection(hashSet);
    }

    private static <T> void printCollection(Collection<T> collection) {
        System.out.println(Arrays.toString(collection.toArray()));
    }
}
