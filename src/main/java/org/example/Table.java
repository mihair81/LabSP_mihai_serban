package org.example;

import jakarta.persistence.Entity;

// "Table" este cuvant rezervat in SQL, de aceea tabela se numeste TableElement
@Entity(name = "TableElement")
public class Table extends BaseElement {

    // In diagrama atributul apare doar ca "something"
    private String something;

    public Table() {
    }

    public Table(String something) {
        this.something = something;
    }

    public String getSomething() {
        return something;
    }

    public void render() {
        System.out.println("Table");
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
