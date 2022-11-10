package com.ragbecca.ITVitaeManagement.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.ragbecca.ITVitaeManagement.util.Views;
import com.ragbecca.ITVitaeManagement.validation.UniqueUsername;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Column(name = "id", nullable = false)
    @JsonView(Views.Base.class)
    private Long id;

    @Getter
    @Setter
    @Column(name = "email", nullable = false)
    @UniqueUsername
    @NotNull(message = "{manager.constraints.email.NotNull.message}")
    @Size(min = 5, max = 255, message = "{manager.constraints.email.Size.message}")
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "{manager.constraints.email.Pattern.message}")
    @JsonView(Views.Base.class)
    private String username;

    @Getter
    @Setter
    @NotNull(message = "{manager.constraints.displayName.NotNull.message}")
    @Size(min = 4, max = 255, message = "{manager.constraints.displayName.Size.message}")
    @JsonView(Views.Base.class)
    private String displayName;

    @Getter
    @Setter
    @NotNull(message = "{manager.constraints.password.NotNull.message}")
    @Size(min = 8, max = 255, message = "{manager.constraints.password.Size.message}")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,30}$", message = "{manager.constraints.password.Pattern.message}")
    private String password;

    @Getter
    @Setter
    @JsonView(Views.Base.class)
    private String role;

    @Override
    @Transient
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<>();

        String ROLE_PREFIX = "ROLE_";
        list.add(new SimpleGrantedAuthority(ROLE_PREFIX + role));

        return list;
    }

    @Override
    @Transient
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @Transient
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @Transient
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @Transient
    public boolean isEnabled() {
        return true;
    }
}
