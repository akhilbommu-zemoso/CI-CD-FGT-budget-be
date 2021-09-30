package com.sample.financialgoaltracker.service;

import com.sample.financialgoaltracker.dto.BudgetDTO;

import com.sample.financialgoaltracker.entity.Budget;
import com.sample.financialgoaltracker.mapper.BudgetMapper;
import com.sample.financialgoaltracker.repository.BudgetRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@RunWith(SpringRunner.class)
@SpringBootTest
public class BudgetServiceTest {

    @MockBean
    private BudgetRepository budgetRepository;

    @Autowired
    private BudgetServiceImpl budgetServiceImpl;

    @Autowired
    private BudgetMapper budgetMapper;

    private Budget budget1;
    private Budget budget2;

    @Before
    public void setUp(){
        budget1 = new Budget();
        budget1.setStartDate("2020-05-01");
        budget1.setEndDate("2020-12-01");
        budget1.setFrequency("monthly");
        budget1.setCreatedAt("13:45");
        budget1.setCreatedBy("ray");
        budget1.setModifiedAt("15:45");
        budget1.setModifiedBy("ray");
        budget1.setDeleted(false);
        budget1.setActive(false);

        budget2 = new Budget();
        budget2.setStartDate("2020-03-01");
        budget2.setEndDate("2020-11-01");
        budget2.setFrequency("monthly");
        budget2.setCreatedAt("13:45");
        budget2.setCreatedBy("bruce");
        budget2.setModifiedAt("15:45");
        budget2.setModifiedBy("bruce");
        budget2.setDeleted(false);
        budget2.setActive(false);
    }

    @Test
    public void testFindAll(){
        List<Budget> budgetsList = new ArrayList<>();

        budgetsList.add(budget1);
        budgetsList.add(budget2);

        //Mocking
        Mockito.when(budgetRepository.findAll()).thenReturn(budgetsList);

        //Test
        List<BudgetDTO> totalBudgets = budgetServiceImpl.findAll();
        assertThat(2).isEqualTo(totalBudgets.size());
    }

    @Test
    public void testFindById(){
        Mockito.when(budgetRepository.findById(budget1.getId())).
                thenReturn(Optional.of(budget1));
        BudgetDTO budgetDTO = budgetServiceImpl.findById(budget1.getId());
        assertThat(budget1).isEqualToComparingFieldByField(budgetMapper.convertToEntity(budgetDTO));
    }

    @Test
    public void testSave(){
        Mockito.when(budgetRepository.save(budget1)).thenReturn(budget1);
        assertThat(budgetMapper.convertToDTO(budget1)).isEqualToComparingFieldByField(budgetServiceImpl.save(budgetMapper.convertToDTO(budget1)));
    }

    @Test
    public void testDeleteById(){
        budgetServiceImpl.deleteById(budget1.getId());
        Mockito.verify(budgetRepository,Mockito.times(1))
                .deleteById(budget1.getId());
    }
}














