package com.sample.financialgoaltracker.dto;

import com.sample.financialgoaltracker.entity.Budget;
import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
public class BudgetComponentDTO {

    private int id;

    private String category;

    private double currency;

    private String currencyFormat;

    private String frequency;

    private String createdAt;

    private String createdBy;

    private String modifiedAt;

    private String modifiedBy;

    private boolean isDeleted;

    private boolean isActive;

    private Budget budget;
}
