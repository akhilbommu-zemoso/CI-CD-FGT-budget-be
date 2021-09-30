package com.sample.financialgoaltracker.repository;

import com.sample.financialgoaltracker.entity.Budget;
import com.sample.financialgoaltracker.entity.BudgetComponent;
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
public class BudgetComponentRepositoryTest {

    @Autowired
    private BudgetComponentRepository budgetComponentRepository;

    private BudgetComponent budgetComponent1;
    private BudgetComponent budgetComponent2;

    @Before
    public void testSetUp(){
        budgetComponent1 = new BudgetComponent();
        budgetComponent2 = new BudgetComponent();

        budgetComponent1.setCategory("sales");
        budgetComponent1.setCurrency(1000.00);
        budgetComponent1.setCurrencyFormat("Indian Rupee");
        budgetComponent1.setFrequency("monthly");
        budgetComponent1.setCreatedAt("2020-05-11");
        budgetComponent1.setCreatedBy("ray");
        budgetComponent1.setModifiedAt("2020-05-16");
        budgetComponent1.setModifiedBy("ray");
        budgetComponent1.setDeleted(false);
        budgetComponent1.setActive(false);

        Budget budget1 = new Budget();
        budget1.setStartDate("2020-05-01");
        budget1.setEndDate("2020-12-01");
        budget1.setFrequency("monthly");
        budget1.setCreatedAt("13:45");
        budget1.setCreatedBy("ray");
        budget1.setModifiedAt("15:45");
        budget1.setModifiedBy("ray");
        budget1.setDeleted(false);
        budget1.setActive(false);

        budgetComponent1.setBudget(budget1);

        budgetComponent2.setCategory("purchases");
        budgetComponent2.setCurrency(10000.00);
        budgetComponent2.setCurrencyFormat("Indian Rupee");
        budgetComponent2.setFrequency("weekly");
        budgetComponent2.setCreatedAt("2020-03-11");
        budgetComponent2.setCreatedBy("bruce");
        budgetComponent2.setModifiedAt("2020-05-16");
        budgetComponent2.setModifiedBy("bruce");
        budgetComponent2.setDeleted(false);
        budgetComponent2.setActive(false);
        budgetComponent2.setBudget(budget1);
    }

    @Test
    public void testFindAll(){
        List<BudgetComponent> expectedBudgetComponents = new ArrayList<>();
        expectedBudgetComponents.add(budgetComponent1);
        expectedBudgetComponents.add(budgetComponent2);

        budgetComponentRepository.save(budgetComponent1);
        budgetComponentRepository.save(budgetComponent2);

        List<BudgetComponent> actualBudgetComponents = (List<BudgetComponent>) budgetComponentRepository.findAll();
        assertThat(actualBudgetComponents).isEqualTo(expectedBudgetComponents);
    }

    @Test
    public void testFindById(){
        BudgetComponent expectedBudgetComponent = budgetComponent1;
        budgetComponentRepository.save(expectedBudgetComponent);
        Optional<BudgetComponent> actualBudgetComponent = budgetComponentRepository.findById(expectedBudgetComponent.getId());
        assertThat(actualBudgetComponent.get()).isEqualTo(expectedBudgetComponent);
    }

    @Test
    public void testSave(){
        BudgetComponent expectedBudgetComponent = budgetComponent1;
        budgetComponentRepository.save(expectedBudgetComponent);
        Optional<BudgetComponent> actualBudgetComponent = budgetComponentRepository.findById(expectedBudgetComponent.getId());
        assertThat(actualBudgetComponent.get()).isEqualTo(expectedBudgetComponent);
    }

    @Test
    public void testDelete(){
        BudgetComponent budgetComponent = budgetComponent1;
        budgetComponentRepository.save(budgetComponent);
        Optional<BudgetComponent> actualBudgetComponent = budgetComponentRepository.findById(budgetComponent.getId());
        assertThat(actualBudgetComponent.get()).isEqualTo(budgetComponent);
        budgetComponentRepository.delete(budgetComponent);
        Optional<BudgetComponent> returnedBudgetComponent = budgetComponentRepository.findById(budgetComponent.getId());
        assertThat(returnedBudgetComponent).isEqualTo(Optional.empty());
    }
}
