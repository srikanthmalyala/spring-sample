package com.example.expense;

import com.example.expense.service.ExpenseService;
import com.example.expense.view.ExpenseView;
import com.example.expense.domain.Expense;
import com.example.expense.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/expense")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    public String get() {
        return "hello";
    }


    @PostMapping
    public String addExpense(final @RequestBody  ExpenseView expenseView) {

        Expense expense = new Expense();
        User user = new User();

        user.setGroupId(expenseView.getGroupId());
        user.setId(expenseView.getUserId());

        expense.setDescrpion(expenseView.getDescription());
        expense.setAmount(expenseView.getAmount());
        expense.setUser(user);


        expenseService.addExpense(expense);
        return "Expense added successfully";
    }
}
