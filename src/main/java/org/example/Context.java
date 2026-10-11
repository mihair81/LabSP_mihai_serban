package org.example;

// Contextul de randare: tine latimea liniei in care se aliniaza textul
public class Context {

    private final int width;

    public Context(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public String spaces(int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(' ');
        }
        return sb.toString();
    }
}