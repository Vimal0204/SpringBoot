package com.kharchkhata.springboot.kharchkhataCruddemo.Entity;
import jakarta.persistence.*;

import java.math.BigInteger;


@Entity
@Table(name="expenses")
public class Expenses {
    // define the neccesary fields here
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name="identify_id")
    private String identityId;

    public Expenses(long id, String identityId, String expenseName, double expenseAmount, String expenseType, String expenseDate) {
        this.id = id;
        this.identityId = identityId;
        this.expenseName = expenseName;
        this.expenseAmount = expenseAmount;
        this.expenseType = expenseType;
        this.expenseDate = expenseDate;
    }

    @Column(name = "expense_name")
    private  String expenseName;

    public Expenses() {
    }

    @Column(name = "expense_amount")
    private  double expenseAmount;

    @Column(name = "expense_Type")
    private  String expenseType;

    @Column(name = "expense_date")
    private String expenseDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdentityId() {
        return identityId;
    }

    public void setIdentityId(String identityId) {
        this.identityId = identityId;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public double getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public String getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }

    public String getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(String expenseDate) {
        this.expenseDate = expenseDate;
    }
}
