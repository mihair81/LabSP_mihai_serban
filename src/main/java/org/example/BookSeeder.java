package org.example;

import org.example.persistence.CrudRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// Optional: salveaza o carte de test la pornire, ca sa vezi ierarhia in H2 si in JSON
@Component
public class BookSeeder implements CommandLineRunner {

    private final CrudRepository<Book, Integer> booksRepository;

    public BookSeeder(CrudRepository<Book, Integer> booksRepository) {
        this.booksRepository = booksRepository;
    }

    @Override
    public void run(String... args) {
        if (!booksRepository.findAll().isEmpty()) {
            return;
        }
        Book book = new Book("Noapte buna, copii!");
        book.addAuthor(new Author("Radu Pavel Gheo"));

        Section cap1 = new Section("Capitolul 1");
        Section cap11 = new Section("Capitolul 1.1");
        book.addContent(new Paragraph("Multumesc celor care ..."));
        book.addContent(cap1);
        cap1.add(new Paragraph("Moto capitol"));
        cap1.add(cap11);
        cap11.add(new Paragraph("Text from subchapter 1.1"));
        cap11.add(new ImageProxy("Image subchapter 1.1"));
        cap11.add(new Table("Table 1"));

        booksRepository.save(book);
    }
}
