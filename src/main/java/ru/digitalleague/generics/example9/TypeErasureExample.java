package ru.digitalleague.generics.example9;

import java.util.ArrayList;
import java.util.List;

public class TypeErasureExample {

    public static void main(String[] args) {
// Пример стирания типов для метода.
        Integer[] arr = {1, 2, 3, 3};
        System.out.println(count(arr, 3));
// Пример стирания типов для класса.
        Box<List<String>> box = new Box<>();
        box.setValue(new ArrayList<>());
// Пример bridge method.
        StringBox stringBox = new StringBox();
        stringBox.setValue("Bridge method");
        System.out.println(stringBox.getValue());
    }

// Показать стирание типа для шаблонного метода.
    private static <T extends Number> int count(T[] anArray, T elem) {
        int cnt = 0;
        for (T e : anArray)
            if (e.equals(elem))
                ++cnt;
        return cnt;
    }
}
