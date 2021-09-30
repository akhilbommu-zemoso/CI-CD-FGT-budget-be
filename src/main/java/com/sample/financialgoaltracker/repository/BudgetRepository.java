package com.sample.financialgoaltracker.repository;

import com.sample.financialgoaltracker.entity.Budget;
import org.springframework.data.repository.CrudRepository;

public interface BudgetRepository extends CrudRepository<Budget, Integer> {
}
