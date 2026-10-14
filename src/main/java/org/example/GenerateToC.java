package org.example;

public class GenerateToC implements Visitor {

    private final TableOfContents toc = new TableOfContents();

    @Override
    public void visit(Book book) {
        toc.addEntry(book.getTitle());
    }

    @Override
    public void visit(Section section) {
        toc.addEntry(section.getTitle());
    }

    @Override
    public void visit(TableOfContents tableOfContents) {
    }

    @Override
    public void visit(Paragraph paragraph) {
    }

    @Override
    public void visit(ImageProxy imageProxy) {
    }

    @Override
    public void visit(Image image) {
    }

    @Override
    public void visit(Table table) {
    }

    public TableOfContents getToC() {
        return toc;
    }
}