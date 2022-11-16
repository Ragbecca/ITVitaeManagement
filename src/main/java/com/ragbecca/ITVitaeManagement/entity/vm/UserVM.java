package com.ragbecca.ITVitaeManagement.entity.vm;

import com.ragbecca.ITVitaeManagement.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserVM {

    private long id;

    private String username;

    private String displayName;

    private String role;

    private boolean master;

    public UserVM(User user) {
        this.setId(user.getId());
        this.setUsername(user.getUsername());
        this.setDisplayName(user.getDisplayName());
        this.setRole(user.getRole());
        this.setMaster(user.isMaster());
    }
}
