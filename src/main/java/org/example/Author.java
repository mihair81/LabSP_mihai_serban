package org.example;

public class Author {

    private String name;
    private String surname;

    // Primeste numele complet, ex: "Radu Pavel Gheo".
    // Ultimul cuvant devine surname, restul name.
    public Author(String fullName) {
        String trimmed = fullName.trim();
        int lastSpace = trimmed.lastIndexOf(' ');
        if (lastSpace == -1) {
            this.name = trimmed;
            this.surname = "";
        } else {
            this.name = trimmed.substring(0, lastSpace);
            this.surname = trimmed.substring(lastSpace + 1);
        }
    }

    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void print() {
        System.out.println("Author: " + name + " " + surname);
    }
}