package ru.digitalleague.generics.example9;

// Показать стирание параметра типа для класса.
class Box<T> {

    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}