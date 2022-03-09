package ru.digitalleague.generics.example2;

import ru.digitalleague.generics.example1.NewBox;

import java.math.BigDecimal;

public class RawTypesExample {

    public static void main(String[] args) {
// Без указания параметра типа будет использоваться raw type.
        NewBox box = new NewBox();
// Вместо параметра типа будет использоваться Object, поэтому нужно делать явное приведение типа.
        box.set("string value");
        String value = (String) box.get();
        System.out.println(value);

        NewBox<String> box2 = new NewBox<>();
        box2.set("string value 2");
// Для обратной совместимости имеется возможность присвоения параметризованного типа к raw type.
        NewBox rawBox = box2;
        System.out.println(rawBox.get());

// Можно делать и обратное присвоение, компилятор выдаст warning.
        box.set(BigDecimal.ONE);
        box2 = box;
// Получим ClassCastException, так как на самом деле box2 будет содержать число, а не строку!
//        System.out.println(box2.get());

// Вывод - везде, где возможно нужно пытаться избегать raw типов.
// Нужно исправлять warnings, которые отображает компилятор,
// в нашем случае исправить warning uses unchecked or unsafe operations!
    }
}
