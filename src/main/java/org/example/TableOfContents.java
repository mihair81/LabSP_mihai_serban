package org.example;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;

import java.util.ArrayList;
import java.util.List;

@Entity
public class TableOfContents extends BaseElement {

    @ElementCollection
    private List<String> entries = new ArrayList<>();

    public TableOfContents() {
    }

    public void addEntry(String title, int page) {
        entries.add(title + " ........ " + page);
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
