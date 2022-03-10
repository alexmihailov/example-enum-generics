package ru.digitalleague.generics.example6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnboundedWildcardsExample {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            list.add(i);
        }
// Как уже обсуждалось ранее, List<Integer> не является наследником List<Object>,
// поэтому List<Integer> мы не можем передать в метод printList1.
//        printList1(list);

// Данный вариант будет работать, но в нем есть один изъян - зачем
// нам знать тип параметров, если мы просто хотим у них вызвать метод toString (метод из класса Object) ?
        printList2(list);
// В текущей ситуации использование unbounded wildcard является самым верным решением.
// ВАЖНО! List<Object> != List<?>. Как видно ранее, в метод printList1 можно передать только List<Object>.
// При этом в printList3 мы можем передать список любых типов!
// Также в List<Object> могут храниться объекты разных типов, а в List<?> - только одного типа, просто мы не знаем какого.
        printList3(list);
    }

// Если ставят задачу вывода списка, то первое, что приходит в голову - использовать Object.
    public static void printList1(List<Object> list) {
        System.out.println(Arrays.toString(list.toArray()));
    }
// Данные вариант приходит вторым в голову - использовать шаблонный метод.
    public static <T> void printList2(List<T> list) {
        System.out.println(Arrays.toString(list.toArray()));
    }
// В данном варианте воспользовались unbounded wildcard.
    public static void printList3(List<?> list) {
        System.out.println(Arrays.toString(list.toArray()));
    }
}
