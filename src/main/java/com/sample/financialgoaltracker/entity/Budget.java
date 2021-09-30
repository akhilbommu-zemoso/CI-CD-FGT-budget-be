package com.sample.financialgoaltracker.entity;

import lombok.*;
import org.hibernate.annotations.JoinColumnOrFormula;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;

@Entity
@Table(name = "budget")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Budget {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

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


    /*@OneToOne
    @JoinColumn(name = "user_id")
    private User user;*/
}










