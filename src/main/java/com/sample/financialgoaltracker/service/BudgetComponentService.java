package com.sample.financialgoaltracker.service;

import com.sample.financialgoaltracker.dto.BudgetComponentDTO;
import com.sample.financialgoaltracker.entity.BudgetComponent;

import java.util.List;

public interface BudgetComponentService {
    List<BudgetComponentDTO> findAll();

    BudgetComponentDTO findById(int id);

    BudgetComponentDTO save(BudgetComponentDTO budgetComponentDTO);

    boolean deleteById(int id);
}
