package com.ragbecca.ITVitaeManagement.entity.vm;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class UserUpdateVM {

    @NotNull(message = "{manager.constraints.displayName.NotNull.message}")
    @Size(min = 4, max = 255, message = "{manager.constraints.displayName.Size.message}")
    private String displayName;


    @NotNull(message = "{manager.constraints.password.NotNull.message}")
    @Size(min = 8, max = 255, message = "{manager.constraints.password.Size.message}")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,30}$", message = "{manager.constraints.password.Pattern.message}")
    private String password;
}
