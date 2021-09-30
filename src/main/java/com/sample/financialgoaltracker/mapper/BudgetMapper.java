package com.sample.financialgoaltracker.mapper;

import com.sample.financialgoaltracker.dto.BudgetDTO;
import com.sample.financialgoaltracker.entity.Budget;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BudgetMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Budget convertToEntity(BudgetDTO budgetDTO){
        return modelMapper.map(budgetDTO,Budget.class);
    }

    public BudgetDTO convertToDTO(Budget budget){
        return modelMapper.map(budget,BudgetDTO.class);
    }

}
