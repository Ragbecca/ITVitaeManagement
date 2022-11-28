package com.ragbecca.ITVitaeManagement.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "classes")
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @Getter
    private Long id;

    @Getter
    @Setter
    @NotNull(message = "{manager.constraints.displayName.NotNull.message}")
    private String name;

    @Getter
    @Setter
    @NotNull
    private String type;

    @Getter
    @Setter
    @ManyToMany
    private List<User> teachers;

    @Getter
    @Setter
    @ManyToMany
    private List<Days> days;

}
