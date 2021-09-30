package com.sample.financialgoaltracker.mapper;

import com.sample.financialgoaltracker.dto.BudgetComponentDTO;
import com.sample.financialgoaltracker.entity.BudgetComponent;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BudgetComponentMapper {

    @Autowired
    private ModelMapper modelMapper;

    public BudgetComponent convertToEntity(BudgetComponentDTO budgetComponentDTO){
        return modelMapper.map(budgetComponentDTO,BudgetComponent.class);
    }

    public BudgetComponentDTO convertToDTO(BudgetComponent budgetComponent){
        return modelMapper.map(budgetComponent, BudgetComponentDTO.class);
    }
}
