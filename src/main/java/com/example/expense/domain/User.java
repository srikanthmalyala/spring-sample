package com.example.expense.domain;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "user")
public class User {

    @Column(name = "id")
    @Id
    private int id;

    @Column(name = "name")
    private String userName;

    @Column(name = "phone_no")
    private String phoneNo;

    @Column(name = "group_id")
    private String groupId;

    @OneToMany(cascade=ALL, mappedBy = "user")
    private List<Expense> expenseList;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public List<Expense> getExpenseList() {
        return expenseList;
    }

    public void setExpenseList(List<Expense> expenseList) {
        this.expenseList = expenseList;
    }
}
