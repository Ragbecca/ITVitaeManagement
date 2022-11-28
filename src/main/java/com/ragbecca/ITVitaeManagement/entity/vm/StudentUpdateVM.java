package com.ragbecca.ITVitaeManagement.entity.vm;

import com.ragbecca.ITVitaeManagement.entity.Class;
import com.ragbecca.ITVitaeManagement.validation.UniqueUsername;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class StudentUpdateVM {

    @UniqueUsername
    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "{manager.constraints.email.Pattern.message}")
    private String email;

    @NotNull
    private String displayName;

    @NotNull
    private Class inClass;


}
