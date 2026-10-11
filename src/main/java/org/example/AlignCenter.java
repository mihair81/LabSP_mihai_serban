package org.example;

public class AlignCenter implements AlignStrategy {

    @Override
    public String render(Paragraph paragraph, Context context) {
        String text = paragraph.getText();
        int padding = Math.max(0, (context.getWidth() - text.length()) / 2);
        return context.spaces(padding) + text;
    }
}