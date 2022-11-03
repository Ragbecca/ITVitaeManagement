package com.ragbecca.ITVitaeManagement.entity;

import com.ragbecca.ITVitaeManagement.validation.UniqueUsername;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Column(name = "id", nullable = false)
    private Long id;

    @Getter
    @Setter
    @Column(name = "email", nullable = false)
    @UniqueUsername
    @NotNull(message = "{manager.constraints.email.NotNull.message}")
    @Size(min = 5, max = 255, message = "{manager.constraints.email.Size.message}")
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "{manager.constraints.email.Pattern.message}")
    private String username;

    @Getter
    @Setter
    @NotNull(message = "{manager.constraints.displayName.NotNull.message}")
    @Size(min = 4, max = 255, message = "{manager.constraints.displayName.Size.message}")
    private String displayName;

    @Getter
    @Setter
    @NotNull(message = "{manager.constraints.password.NotNull.message}")
    @Size(min = 8, max = 30, message = "{manager.constraints.password.Size.message}")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,30}$", message = "{manager.constraints.password.Pattern.message}")
    private String password;
}
