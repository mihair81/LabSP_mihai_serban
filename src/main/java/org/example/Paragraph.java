package org.example;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;

@Entity
public class Paragraph extends BaseElement {

    private static final Context DEFAULT_CONTEXT = new Context(40);

    @Column(length = 2000)
    private String text;

    // strategia de aliniere nu se salveaza in baza de date
    @Transient
    private AlignStrategy textAlignment;

    protected Paragraph() {
    }

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

    public void render() {
        if (textAlignment == null) {
            System.out.println("Paragraph: " + text);
        } else {
            System.out.println(textAlignment.render(this, DEFAULT_CONTEXT));
        }
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
