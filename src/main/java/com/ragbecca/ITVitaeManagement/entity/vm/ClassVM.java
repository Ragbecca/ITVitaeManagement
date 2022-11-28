package com.ragbecca.ITVitaeManagement.entity.vm;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ClassVM {

    @NotNull
    private String name;

    @NotNull
    private String type;

    private String[] teachers;

    private String[] days;

}
