package ru.digitalleague.generics.example1;

// Используя параметр типа T появляется возможность
// задать типизацию при работе с классом NewBox.
public class NewBox<T> {
    // T stands for "Type"
    private T t;

// Так как параметр T объявлен для всего класса, то
// его можно использовать во всем описании тела класса.
// По сути компилятор заменит шаблон T на тот параметр, который
// будет передан при создании объекта класса NewBox.
    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    @Override
    public String toString() {
        return "NewBox{" +
                "t=" + t +
                '}';
    }
}
