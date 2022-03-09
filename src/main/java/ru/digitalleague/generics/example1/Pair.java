package ru.digitalleague.generics.example1;

// Параметризованными могут быть как классы, так и интерфейсы.
// Можно использовать несколько параметров типа!
public interface Pair<K, V> {
    K getKey();
    V getValue();
}
