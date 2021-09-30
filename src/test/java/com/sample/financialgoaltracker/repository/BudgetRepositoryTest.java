package com.sample.financialgoaltracker.repository;

import com.sample.financialgoaltracker.entity.Budget;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@RunWith(SpringRunner.class)
@DataJpaTest
public class BudgetRepositoryTest {
    @Autowired
    private BudgetRepository budgetRepository;

    private Budget budget1;
    private Budget budget2;

    @Before
    public void testSetUp(){
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
        List<Budget> expectedBudgets = new ArrayList<>();
        expectedBudgets.add(budget1);
        expectedBudgets.add(budget2);

        budgetRepository.save(budget1);
        budgetRepository.save(budget2);

        List<Budget> actualBudgets = (List<Budget>) budgetRepository.findAll();
        assertThat(actualBudgets).isEqualTo(expectedBudgets);
    }

    @Test
    public void testFindById(){
        Budget expectedBudget = budget1;
        budgetRepository.save(expectedBudget);
        Optional<Budget> actualBudget = budgetRepository.findById(expectedBudget.getId());
        assertThat(actualBudget.get()).isEqualTo(expectedBudget);
    }

    @Test
    public void testSave(){
        Budget expectedBudget = budget1;
        budgetRepository.save(expectedBudget);
        Optional<Budget> actualBudget = budgetRepository.findById(expectedBudget.getId());
        assertThat(actualBudget.get()).isEqualTo(expectedBudget);
    }

    @Test
    public void testDelete(){
        Budget budget = budget1;
        budgetRepository.save(budget);
        Optional<Budget> actualBudget = budgetRepository.findById(budget.getId());
        assertThat(actualBudget.get()).isEqualTo(budget);
        budgetRepository.delete(budget);
        Optional<Budget> returnedBudget = budgetRepository.findById(budget.getId());
        assertThat(returnedBudget).isEqualTo(Optional.empty());
    }
}















