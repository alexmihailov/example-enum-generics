package ru.digitalleague.generics.example1;

// При реализации интерфейса с параметрами типов (или наследовании от класса) можно
// передать конкретные типы.
public class IntegerPair implements Pair<Integer, Integer> {

    private final Integer key;
    private final Integer value;

    public IntegerPair(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public Integer getKey() {
        return key;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "IntegerPair{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
