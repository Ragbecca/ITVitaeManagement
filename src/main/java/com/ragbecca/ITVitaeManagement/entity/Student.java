package com.ragbecca.ITVitaeManagement.entity;

import com.ragbecca.ITVitaeManagement.validation.UniqueUsername;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Column(name = "id", nullable = false)
    private Long id;

    @Getter
    @Setter
    @UniqueUsername
    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "{manager.constraints.email.Pattern.message}")
    private String email;

    @Getter
    @Setter
    @NotNull
    private String displayName;

    @Getter
    @Setter
    private float percentagePresent;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "id", nullable = false)
    private Class inClass;
}
