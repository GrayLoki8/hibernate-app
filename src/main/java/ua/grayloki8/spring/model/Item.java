package ua.grayloki8.spring.model;

import javax.persistence.*;

@Entity
@Table(name = "Item")
public class Item {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "item_name")
    private String iteName;
    @ManyToOne
    @JoinColumn(name = "person_id",referencedColumnName = "id")
    private Person owner;

    public Item(String iteName) {
        this.iteName = iteName;
    }

    public Item() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIteName() {
        return iteName;
    }

    public void setIteName(String iteName) {
        this.iteName = iteName;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", iteName='" + iteName + '\'' +
                '}';
    }
}
