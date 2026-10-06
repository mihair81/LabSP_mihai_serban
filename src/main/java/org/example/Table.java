package org.example;

public class Table implements Element {

    // In diagrama atributul apare doar ca "something"
    private String something;

    public Table() {
    }

    public Table(String something) {
        this.something = something;
    }

    @Override
    public void print() {
        System.out.println("Table");
    }
}