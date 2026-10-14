package org.example;

import java.util.ArrayList;
import java.util.List;

public class TableOfContents implements Element {

    private final List<String> entries = new ArrayList<>();

    public TableOfContents() {
    }

    public void addEntry(String entry) {
        entries.add(entry);
    }

    public List<String> getEntries() {
        return entries;
    }

    public void render() {
        System.out.println("Table of contents");
        for (String entry : entries) {
            System.out.println(" - " + entry);
        }
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}