package com.kharchkhata.springboot.kharchkhataCruddemo.DAO;

import com.kharchkhata.springboot.kharchkhataCruddemo.Entity.Expenses;

import java.util.*;

public interface ExpensesDAO {
    List<Expenses> findByIdentityId(String identifyingId);
    Expenses save(Expenses theExpenses);
    void deleteById(long theId);
    Expenses findById(long theId);
    double getTotalAmountByIdentityId(String identifyingId);
}
