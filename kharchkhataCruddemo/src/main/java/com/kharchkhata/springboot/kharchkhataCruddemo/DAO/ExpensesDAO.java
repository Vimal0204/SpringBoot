package com.kharchkhata.springboot.kharchkhataCruddemo.DAO;

import com.kharchkhata.springboot.kharchkhataCruddemo.Entity.Expenses;

import java.util.*;

public interface ExpensesDAO {
    List<Expenses> findByIdentityId(String identifyingId);
    Expenses save(Expenses theExpenses);
    void deleteById(long theId,String identifyingId);
    Expenses findById(long theId);
    double getTotalAmountByIdentityId(String identifyingId);
}
