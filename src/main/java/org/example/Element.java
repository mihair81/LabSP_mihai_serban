package org.example;

public interface Element {

    void print();

    default void add(Element element) {
        throw new UnsupportedOperationException("Operatia add nu este suportata de " + getClass().getSimpleName());
    }

    default void remove(Element element) {
        throw new UnsupportedOperationException("Operatia remove nu este suportata de " + getClass().getSimpleName());
    }

    default Element get(int index) {
        throw new UnsupportedOperationException("Operatia get nu este suportata de " + getClass().getSimpleName());
    }
}