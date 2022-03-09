package ru.digitalleague.generics.example1;

// При реализации интерфейса с параметрами типов (или наследовании от класса) можно
// в классе определить другие параметры типов (с другими названиями)
// и при этом класс будет параметризованным.
public class OrderedPair<KEY, VALUE> implements Pair<KEY, VALUE> {

    private final KEY key;
    private final VALUE value;

    public OrderedPair(KEY key, VALUE value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public KEY getKey() {
        return key;
    }

    @Override
    public VALUE getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "OrderedPair{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
