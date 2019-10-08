package org.tk.swagger2.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    @ApiModelProperty(notes = "Name of the user", name = "name", required = true, value = "test_user")
    private String name;

    @ApiModelProperty(notes = "Age of the user", name = "age", required = true, value = "24")
    private int age;

    @ApiModelProperty(notes = "Country of the user", name = "country", required = true, value = "India")
    private String country;
}
