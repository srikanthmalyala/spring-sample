package com.example.expense.repo;

import com.example.expense.domain.ExpenseOwe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpennseOweRepository extends JpaRepository<ExpenseOwe, Integer> {


}
