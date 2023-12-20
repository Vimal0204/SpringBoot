package com.kharchkhata.springboot.kharchkhataCruddemo.Rest;

import com.kharchkhata.springboot.kharchkhataCruddemo.Entity.Expenses;
import com.kharchkhata.springboot.kharchkhataCruddemo.Service.ExpensesServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ExpensesRestController {
    private ExpensesServices expensesServices;

    public ExpensesRestController(ExpensesServices expensesServices) {
        this.expensesServices = expensesServices;
    }
    // Getlist of expenses
    @GetMapping("/expenses/{identifyingId}")
    public List<Expenses> getExpenses(@PathVariable String identifyingId){
        List<Expenses> theExpenses = expensesServices.findByIdentityId(identifyingId);
        return theExpenses;
    }
    @GetMapping("/amount/{identifyingId}")
    public double getAmount(@PathVariable String identifyingId){
        return expensesServices.getTotalAmountByIdentityId(identifyingId);
    }
    @PostMapping("/expenses")
    public Expenses addExpenses(@RequestBody Expenses theExpenses){
        theExpenses.setId(0);
        Expenses db = expensesServices.save(theExpenses);
        return db;
    }
    @DeleteMapping("expenses/{identifyingId}/{id}")
    public String deleteExpenses(@PathVariable long id,@PathVariable String identifyingId){
        Expenses deleteExpense = expensesServices.findById(id);
        if (deleteExpense == null) {
            throw new RuntimeException("Expenses id not found: "+id);
        }
        expensesServices.deleteById(id,identifyingId);
        return "The id is : "+id;
    }
}


