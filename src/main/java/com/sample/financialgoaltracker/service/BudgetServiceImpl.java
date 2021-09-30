package com.sample.financialgoaltracker.service;

import com.sample.financialgoaltracker.dto.BudgetDTO;
import com.sample.financialgoaltracker.entity.Budget;
import com.sample.financialgoaltracker.mapper.BudgetMapper;
import com.sample.financialgoaltracker.repository.BudgetComponentRepository;
import com.sample.financialgoaltracker.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BudgetServiceImpl implements BudgetService {
    @Autowired
    private BudgetRepository budgetRepository;

    @Autowired
    private BudgetMapper budgetMapper;

    @Override
    public List<BudgetDTO> findAll(){
        List<BudgetDTO> budgetDTOS = new ArrayList<>();
        List<Budget> budgets = (List<Budget>) budgetRepository.findAll();
        for(Budget budget: budgets){
            BudgetDTO budgetDTO = budgetMapper.convertToDTO(budget);
            budgetDTOS.add(budgetDTO);
        }
        return budgetDTOS;
    }

    @Override
    public BudgetDTO findById(int id){
        return budgetMapper.convertToDTO(budgetRepository.findById(id).get());
    }

    @Override
    public BudgetDTO save(BudgetDTO theBudgetDTO){
        Budget budget = budgetMapper.convertToEntity(theBudgetDTO);
        budgetRepository.save(budget);
        BudgetDTO budgetDTO = budgetMapper.convertToDTO(budget);
        return budgetDTO;
    }

    @Override
    public boolean deleteById(int id) {
        budgetRepository.deleteById(id);
        return true;
    }
}
