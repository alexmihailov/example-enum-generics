package ru.digitalleague.generics.example9;

// Показать bridge-method
public class StringBox extends Box<String> {

    @Override
    public void setValue(String value) {
        super.setValue(value);
    }
}
