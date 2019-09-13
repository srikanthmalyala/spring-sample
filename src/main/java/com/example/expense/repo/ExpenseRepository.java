package com.example.expense.repo;

import com.example.expense.domain.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {


    @Query(value = "SELECT SUM(amount) FROM expense WHERE user_id IN (1,2)" , nativeQuery = true)
    double findotalAmount(List<Integer> userids);

    @Query(value = "SELECT SUM(amount) FROM expense WHERE user_id = ?1" , nativeQuery = true)
    double findTotalAmountOfUser(final Integer userId);

}
