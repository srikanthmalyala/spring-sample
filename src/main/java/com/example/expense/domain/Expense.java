package com.example.expense.domain;

import javax.persistence.*;

@Entity
@Table(name = "expense")
public class Expense {

    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @Column(name = "expense_desc")
    private String descrpion;

    @Column(name = "amount")
    private double amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescrpion() {
        return descrpion;
    }

    public void setDescrpion(String descrpion) {
        this.descrpion = descrpion;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
