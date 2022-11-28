package com.ragbecca.ITVitaeManagement.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table
public class Days {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @Getter
    private Long id;

    @Getter
    private String displayName;
}
