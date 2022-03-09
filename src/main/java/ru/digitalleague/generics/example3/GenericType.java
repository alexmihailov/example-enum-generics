package ru.digitalleague.generics.example3;

public class GenericType {

    private Object value;

// Пример использования параметризованного конструктора.
// Где такое можно применить - в голову не приходит =)
    public <T> GenericType(T value) {
        this.value = value;
    }

// Пример использования параметризованного метода.
// Как видно, в качестве возвращаемого значения также
// можно использовать параметр типа.
    public <T> T getValue() {
        return (T)value;
    }
}
