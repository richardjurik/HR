package sk.jurik.hr.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Department {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    @Column(unique=true)
    private String name;

    public Department() {
    }

    public Department(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
