package org.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Author> authors = new ArrayList<>();

    @OneToMany(targetEntity = BaseElement.class, cascade = CascadeType.ALL)
    private List<Element> content = new ArrayList<>();

    protected Book() {
    }

    public Book(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    // continutul apare in JSON-ul de raspuns, dar nu se citeste din JSON-ul primit
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public List<Element> getContent() {
        return content;
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void addContent(Element element) {
        content.add(element);
    }

    public void render() {
        System.out.println("Book: " + title);
        for (Author author : authors) {
            author.print();
        }
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
        for (Element element : content) {
            element.accept(visitor);
        }
    }
}
