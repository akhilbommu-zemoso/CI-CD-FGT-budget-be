package com.sample.financialgoaltracker.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BudgetDTO {

    private int id;

    private String startDate;

    private String endDate;

    private String frequency;

    private String createdAt;

    private String createdBy;

    private String modifiedAt;

    private String modifiedBy;

    private boolean isDeleted;

    private boolean isActive;

    /*private User user;*/
}
