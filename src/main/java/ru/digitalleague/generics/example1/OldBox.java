package ru.digitalleague.generics.example1;

public class OldBox {
    // Так как мы хотим использовать объекты всех типов, то приходится
    // использовать класс Object
    private Object object;

    public void set(Object object) {
        this.object = object;
    }

    public Object get() {
        return object;
    }
}