package ru.aston.stream_53.lesson_1;

public class Bear extends Mammal {

    private final Wool wool;

    protected Bear(String name, Wool wool) {
        super(name);
        this.wool = wool;
    }
}
