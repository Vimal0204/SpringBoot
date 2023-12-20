package com.kharchkhata.springboot.kharchkhataCruddemo.Service;

import com.kharchkhata.springboot.kharchkhataCruddemo.DAO.ExpensesDAO;
import com.kharchkhata.springboot.kharchkhataCruddemo.Entity.Expenses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ExpensesServiceImpl implements ExpensesServices{
    ExpensesDAO expensesDAO;

    @Autowired
    public ExpensesServiceImpl(ExpensesDAO theExpensesDAO) {
        this.expensesDAO = theExpensesDAO;
    }

    @Override
    public List<Expenses> findByIdentityId(String identifyingId) {
        List<Expenses> expenses = expensesDAO.findByIdentityId(identifyingId);
        return expenses;
    }

    @Transactional
    @Override
    public Expenses save(Expenses theExpenses) {
        return expensesDAO.save(theExpenses);
    }

    @Transactional
    @Override
    public void deleteById(long theId) {
       expensesDAO.deleteById(theId);
    }

    @Override
    public Expenses findById(long theId) {
        return expensesDAO.findById(theId);
    }

    @Override
    public double getTotalAmountByIdentityId(String identifyingId) {
        return expensesDAO.getTotalAmountByIdentityId(identifyingId);
    }
}
