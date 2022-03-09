package ru.digitalleague.exampleEnum;

public enum Planet {
    MERCURY(3.303e+23, 2.4397e6),
    VENUS(4.869e+24, 6.0518e6),
    EARTH(5.976e+24, 6.37814e6),
    MARS(6.421e+23, 3.3972e6),
    JUPITER(1.9e+27, 7.1492e7),
    SATURN(5.688e+26, 6.0268e7),
    URANUS(8.686e+25, 2.5559e7),
    NEPTUNE(1.024e+26, 2.4746e7);
// Если в enum необходимо задать поля, методы или конструктор, то
// это описание должно идти после задания экземпляров (констант),
// причем задание экземпляров должно заканчиваться `;`, чтобы затем можно было описать поля, методы и тд.

// В enum так же как и в классах можно задавать поля.
    private final double mass;   // in kilograms
    private final double radius; // in meters

// Для enum разрешен только package-private конструктор.
    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }

//    public Planet(double mass, double radius) {
//        this.mass = mass;
//        this.radius = radius;
//    }
//    private Planet(double mass, double radius) {
//        this.mass = mass;
//        this.radius = radius;
//    }

// В enum так же как и в классах можно определять методы (как обычные, так и статические).
    public double mass() {
        return mass;
    }

    public double radius() {
        return radius;
    }

// Можно задавать и статические поля (константы).
    // universal gravitational constant  (m3 kg-1 s-2)
    public static final double G = 6.67300E-11;

    public double surfaceGravity() {
        return G * mass / (radius * radius);
    }

    public double surfaceWeight(double otherMass) {
        return otherMass * surfaceGravity();
    }
}