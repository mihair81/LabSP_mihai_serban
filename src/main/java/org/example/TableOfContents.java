package org.example;

public class TableOfContents implements Element {

    // In diagrama atributul apare doar ca "something"
    private String something;

    public TableOfContents() {
    }

    public TableOfContents(String something) {
        this.something = something;
    }

    @Override
    public void print() {
        System.out.println("Table of contents");
    }
}