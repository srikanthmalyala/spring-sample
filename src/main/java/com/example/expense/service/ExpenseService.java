package com.example.expense.service;

import com.example.expense.repo.ExpennseOweRepository;
import com.example.expense.repo.ExpenseRepository;
import com.example.expense.repo.UserRepository;
import com.example.expense.domain.Expense;
import com.example.expense.domain.ExpenseOwe;
import com.example.expense.domain.Group;
import com.example.expense.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ExpennseOweRepository expennseOweRepository;

    public void addExpense(Expense expense) {
        expenseRepository.save(expense);
        updateExpenseOwes(expense);
    }

    public void updateExpenseOwes(final Expense expense) {

        final String groupId = expense.getUser().getGroupId();
        List<User> users = userRepository.findByGroupId(groupId);

        List<Integer> userIds = users.stream().map(user -> user.getId()).collect(Collectors.toList());

        final double totalAmount = expenseRepository.findotalAmount(userIds);
        final double avgExpenseAmount = totalAmount/userIds.size();

        userIds.forEach(userId -> {
            double totalAmountOfUser = expenseRepository.findTotalAmountOfUser(userId);

            final double oweMount;
            if(avgExpenseAmount > totalAmountOfUser) {
                oweMount = avgExpenseAmount - totalAmountOfUser;
            } else {
                oweMount = 0;
            }

            final ExpenseOwe expenseOwe = new ExpenseOwe();
            expenseOwe.setUserId(userId);
            expenseOwe.setOweAmount(oweMount);

            updateExpenseOwes(expenseOwe);
        });


    }

    private void updateExpenseOwes(final ExpenseOwe expenseOwe) {

        expennseOweRepository.save(expenseOwe);

    }
}
