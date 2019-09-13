package com.example.expense.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "expense_owe")
public class ExpenseOwe {

    @Id
    @Column(name = "user_id")
    private int userId;

    @Column(name = "owe_amount")
    private double oweAmount;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getOweAmount() {
        return oweAmount;
    }

    public void setOweAmount(double oweAmount) {
        this.oweAmount = oweAmount;
    }
}
