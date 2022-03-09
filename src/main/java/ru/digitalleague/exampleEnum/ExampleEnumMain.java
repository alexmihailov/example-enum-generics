package ru.digitalleague.exampleEnum;

import java.util.Arrays;

public class ExampleEnumMain {

    public static void main(String[] args) {
// 1. Показать простой enum ru.digitalleague.exampleEnum.Day
        simpleUsageEnum();
// 2. Показать использование полей и методов в enum
        enumBody();
// 3. Показать методы и свойства в java.lang.Enum
        enumDefaultMethodsAndFields();
// 4. Показать сравнение enum через == и через equals
        enumEquals();
    }

    private static void simpleUsageEnum() {
        tellItLikeItIs(Day.FRIDAY);
        tellItLikeItIs(Day.MONDAY);
        tellItLikeItIs(Day.SATURDAY);
// Enum может в качестве экземпляра принимать только значения, которые определены в нем!
//        Day day = Day.TEST
    }

    private static void enumBody() {
        var yourWeightInEarth = 78.5;
        var mass = yourWeightInEarth / Planet.EARTH.surfaceGravity();
// Конструктор для enum может быть вызван только внутри самого enum
//        Planet planet = new Planet(0.0, 0.0)
        for (Planet p : Planet.values()) {
            System.out.printf("Your weight on %s is %f kg%n",
                    p, p.surfaceWeight(mass));
        }
    }

    private static void enumDefaultMethodsAndFields() {
        // java.lang.Enum.name
        System.out.println(Planet.MARS.name());
        // java.lang.Enum.ordinal
        System.out.println(Planet.JUPITER.ordinal());
        // java.lang.Enum.valueOf
        System.out.println(Planet.valueOf("SATURN").name());
        System.out.println(Enum.valueOf(Planet.class, "SATURN").name());

// Если передать имя, которое не соответствует значениям в enum, то будет выброшено исключение IllegalArgumentException.
//        System.out.println(Planet.valueOf("must throw exception").name());

// Передаваемое имя должно в точности совпадать, включая регистр.
//        System.out.println(Planet.valueOf("saturn").name());

        // values возвращает все возможные значения
        System.out.println(Arrays.toString(Planet.values()));
    }

    private static void enumEquals() {
        // Для сравнения enum можно использовать == и equals.

        // == never throws NullPointerException
        Planet planet = null;
        if (planet == Planet.EARTH) { // OK
            System.out.println("Planet is EARTH");
        }
//        if (planet.equals(Planet.EARTH)) {  // NPE
//            System.out.println("Planet is EARTH");
//        }

        // == is subject to type compatibility check at compile time
        planet = Planet.MARS;
        if (planet.equals(Day.FRIDAY)) { // OK compile
            System.out.println("Planet is FRIDAY");
        }
//        if (planet == Day.FRIDAY) { // DOESN'T compile
//            System.out.println("Planet is FRIDAY");
//        }

        // Вывод - для enum лучше использовать ==
    }

    private static void tellItLikeItIs(Day day) {
        switch (day) {
            case MONDAY:
                System.out.println("Mondays are bad.");
                break;
            case FRIDAY:
                System.out.println("Fridays are better.");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("Weekends are best.");
                break;
            default:
                System.out.println("Midweek days are so-so.");
                break;
        }
    }
}
