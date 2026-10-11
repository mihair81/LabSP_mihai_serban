package org.example;

public class Paragraph implements Element {

    private static final Context DEFAULT_CONTEXT = new Context(40);

    private String text;
    private AlignStrategy textAlignment;

    public Paragraph(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setAlignStrategy(AlignStrategy textAlignment) {
        this.textAlignment = textAlignment;
    }

    @Override
    public void print() {
        if (textAlignment == null) {
            System.out.println("Paragraph: " + text);
        } else {
            System.out.println(textAlignment.render(this, DEFAULT_CONTEXT));
        }
    }
}