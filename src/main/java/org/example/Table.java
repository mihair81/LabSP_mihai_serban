package org.example;

public class Table implements Element {

    // In diagrama atributul apare doar ca "something"
    private String something;

    public Table() {
    }

    public Table(String something) {
        this.something = something;
    }

    public void render() {
        System.out.println("Table");
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}