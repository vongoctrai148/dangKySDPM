package com.doan1.doan1_quanlipm.forms;


import lombok.*;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginForm {
    @NotBlank(message = "Please enter username")
    private String username;
    @NotBlank(message = "Please enter password")
    private String passwords;

}
