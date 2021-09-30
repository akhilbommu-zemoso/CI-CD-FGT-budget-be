package com.sample.financialgoaltracker.service;

import com.sample.financialgoaltracker.dto.BudgetDTO;

import java.util.List;

public interface BudgetService {
    List<BudgetDTO> findAll();

    BudgetDTO findById(int id);

    BudgetDTO save(BudgetDTO budgetDTO);

    boolean deleteById(int id);
}
