package org.example;

public class AlignLeft implements AlignStrategy {

    @Override
    public String render(Paragraph paragraph, Context context) {
        return paragraph.getText();
    }
}