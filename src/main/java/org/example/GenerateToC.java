package org.example;

public class GenerateToC implements Visitor {

    private final TableOfContents toc = new TableOfContents();
    private int currentPage = 1; // simulam numarul paginii curente

    @Override
    public void visit(Book book) {
        toc.addEntry(book.getTitle(), currentPage);
    }

    @Override
    public void visit(Section section) {
        toc.addEntry(section.getTitle(), currentPage);
    }

    @Override
    public void visit(TableOfContents tableOfContents) {
    }

    @Override
    public void visit(Paragraph paragraph) {
        currentPage += 1; // un paragraf ocupa 1 pagina
    }

    @Override
    public void visit(ImageProxy imageProxy) {
        currentPage += 2; // o imagine ocupa 2 pagini (fara sa fie incarcata)
    }

    @Override
    public void visit(Image image) {
        currentPage += 2;
    }

    @Override
    public void visit(Table table) {
        currentPage += 1; // un tabel ocupa 1 pagina
    }

    public TableOfContents getToC() {
        return toc;
    }
}