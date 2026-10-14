package org.example;

public class AppVisitor {

    public static void main(String[] args) throws Exception {
        Section cap1 = new Section("Capitolul 1");
        Paragraph p1 = new Paragraph("Paragraph 1");
        cap1.add(p1);
        Paragraph p2 = new Paragraph("Paragraph 2");
        cap1.add(p2);
        Paragraph p3 = new Paragraph("Paragraph 3");
        cap1.add(p3);
        Paragraph p4 = new Paragraph("Paragraph 4");
        cap1.add(p4);
        cap1.add(new ImageProxy("ImageOne"));
        cap1.add(new Image("ImageTwo"));
        cap1.add(new Paragraph("Some text"));
        cap1.add(new Table("Table 1"));

        BookStatistics stats = new BookStatistics();
        cap1.accept(stats);
        stats.printStatistics();

        System.out.println();

        // Table of contents pe o carte cu mai multe capitole
        Book book = new Book("Noapte buna, copii!");
        Section c1 = new Section("Capitolul 1");
        c1.add(new Paragraph("Text 1"));
        c1.add(new Paragraph("Text 2"));
        Section c11 = new Section("Capitolul 1.1");
        c11.add(new ImageProxy("Imagine"));
        c1.add(c11);
        Section c2 = new Section("Capitolul 2");
        c2.add(new Table("Tabel"));
        c2.add(new Paragraph("Text 3"));
        book.addContent(c1);
        book.addContent(c2);

        GenerateToC toc = new GenerateToC();
        book.accept(toc);
        toc.getToC().render();
    }
}