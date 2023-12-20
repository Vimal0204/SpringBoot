package com.kharchkhata.springboot.kharchkhataCruddemo.DAO;

import com.kharchkhata.springboot.kharchkhataCruddemo.Entity.Expenses;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ExpensesDAOImpl implements ExpensesDAO{
    EntityManager entityManager;
    @Autowired
    public ExpensesDAOImpl(EntityManager theEntityManager) {
        this.entityManager=theEntityManager;
    }

    @Override
    public List<Expenses> findByIdentityId(String identifyingId) {
        TypedQuery<Expenses> theQuery =entityManager.createQuery("from Expenses where identity_id='identifyingId'",Expenses.class).setParameter("identifyingId",identifyingId);
        List<Expenses> theExpenses = theQuery.getResultList();
        return theExpenses;
    }

    @Override
    public Expenses save(Expenses theExpenses) {
        Expenses expensesDb = entityManager.merge(theExpenses);
        return expensesDb;
    }

    @Override
    public void deleteById(long theId) {
        Expenses theExpense = entityManager.find(Expenses.class,theId);
        entityManager.remove(theExpense);
    }

    @Override
    public double getTotalAmountByIdentityId(String identifyingId) {
        Query theQuery = entityManager.createQuery("Sum(expenses_amount) from Expenses where identity_id=identifyingId as amount").setParameter("identifyingId",identifyingId);
        return (double) theQuery.getSingleResult();
    }
}
