package com.kharchkhata.springboot.kharchkhataCruddemo.Service;

import com.kharchkhata.springboot.kharchkhataCruddemo.Entity.Expenses;

import java.util.List;

public interface ExpensesServices {
    List<Expenses> findByIdentityId(String identifyingId);
    Expenses save(Expenses theExpenses);
    void deleteById(long theId);
    double getTotalAmountByIdentityId(String identifyingId);
}
