package ru.aston.stream_53.lesson_1;

public class Wool {
    private final String collor;
    private final String length;

    public Wool(String collor, String length) {
        this.collor = collor;
        this.length = length;
    }

    @Override
    public String toString() {
        return "Wool{" +
                "collor='" + collor + '\'' +
                ", length='" + length + '\'' +
                '}';
    }
}
