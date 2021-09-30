package com.sample.financialgoaltracker.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "budget_component")
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BudgetComponent {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "category")
    private String category;

    @Column(name = "currency")
    private double currency;

    @Column(name = "currency_format")
    private String currencyFormat;

    @Column(name = "frequency")
    private String frequency;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "modified_at")
    private String modifiedAt;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @Column(name = "is_active")
    private boolean isActive;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "budget_id")
    private Budget budget;
}
