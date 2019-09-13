package com.example.expense.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "group")
public class Group {

    @Id
    public String name;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
