package com.ragbecca.ITVitaeManagement.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table
@Entity(name = "missedlessons")
public class MissedLesson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @Getter
    private Long id;

    @Getter
    @Setter
    @NotNull
    @ManyToOne
    private Student student;

    @Getter
    @Setter
    @NotNull
    @ManyToOne
    private User FilledInBy;

    @Getter
    @Setter
    @NotNull
    private String reason;
}
