package org.example;

public class AlignRight implements AlignStrategy {

    @Override
    public String render(Paragraph paragraph, Context context) {
        String text = paragraph.getText();
        int padding = Math.max(0, context.getWidth() - text.length());
        return context.spaces(padding) + text;
    }
}