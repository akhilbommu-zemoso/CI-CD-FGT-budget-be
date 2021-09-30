package com.sample.financialgoaltracker.service;

import com.sample.financialgoaltracker.dto.BudgetComponentDTO;
import com.sample.financialgoaltracker.entity.BudgetComponent;
import com.sample.financialgoaltracker.mapper.BudgetComponentMapper;
import com.sample.financialgoaltracker.repository.BudgetComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BudgetComponentServiceImpl implements BudgetComponentService{

    @Autowired
    private BudgetComponentRepository budgetComponentRepository;

    @Autowired
    private BudgetComponentMapper budgetComponentMapper;

    @Override
    public List<BudgetComponentDTO> findAll(){
        List<BudgetComponentDTO> budgetComponentDTOS = new ArrayList<>();
        List<BudgetComponent> budgetComponents = (List<BudgetComponent>) budgetComponentRepository.findAll();
        for(BudgetComponent budgetComponent: budgetComponents){
            BudgetComponentDTO budgetComponentDTO = budgetComponentMapper.convertToDTO(budgetComponent);
            budgetComponentDTOS.add(budgetComponentDTO);
        }
        return budgetComponentDTOS;
    }

    @Override
    public BudgetComponentDTO findById(int id){
        return budgetComponentMapper.convertToDTO(budgetComponentRepository.findById(id).get());
    }

    @Override
    public BudgetComponentDTO save(BudgetComponentDTO theBudgetComponentDTO){
        BudgetComponent budgetComponent = budgetComponentMapper.convertToEntity(theBudgetComponentDTO);
        budgetComponentRepository.save(budgetComponent);
        BudgetComponentDTO budgetComponentDTO = budgetComponentMapper.convertToDTO(budgetComponent);
        return budgetComponentDTO;
    }

    @Override
    public boolean deleteById(int id) {
        budgetComponentRepository.deleteById(id);
        return true;
    }

}
