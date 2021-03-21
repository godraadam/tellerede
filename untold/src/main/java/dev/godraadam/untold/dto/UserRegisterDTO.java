package dev.godraadam.untold.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterDTO extends BaseDTO {
    private String password;
    private String username;

}
