package com.ragbecca.ITVitaeManagement.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Column(name = "id", nullable = false)
    private Long id;

    @Getter
    @Setter
    @NotNull(message = "{manager.constraints.displayName.NotNull.message}")
    private String displayName;

    @Getter
    @Setter
    @ManyToMany
    private List<User> teachers;

    @Getter
    @Setter
    private boolean monday;

    @Getter
    @Setter
    private boolean tuesday;

    @Getter
    @Setter
    private boolean wednesday;

    @Getter
    @Setter
    private boolean thursday;

    @Getter
    @Setter
    private boolean friday;

}
