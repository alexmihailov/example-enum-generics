package ru.digitalleague.generics.example4;

import java.util.ArrayList;
import java.util.List;

// Задаем ограничение для параметра типа E.
// Это означает, что в качестве типа мы сможем передать
// только наследников класса Number или сам Number.
public class NumbersList<E extends Number> {

    private List<E> elements;

    public NumbersList() {
        this.elements = new ArrayList<>();
    }

    public void add(E element) {
        this.elements.add(element);
    }

    public E get(int index) {
        return this.elements.get(index);
    }

    public int sum() {
        int sum = 0;
        for (E element : elements) {
// Так как E является наследником класса Number, то мы можем вызывать
// методы, которые определены в Number.
            sum += element.intValue();
        }
        return sum;
    }
}
