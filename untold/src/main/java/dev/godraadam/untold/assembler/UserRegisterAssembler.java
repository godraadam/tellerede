package dev.godraadam.untold.assembler;

import org.springframework.stereotype.Component;

import dev.godraadam.untold.dto.UserRegisterDTO;
import dev.godraadam.untold.model.User;

@Component
public class UserRegisterAssembler implements GeneralAssembler<UserRegisterDTO, User> {
    
    @Override
    public User createModel(UserRegisterDTO dto) {
        User user = new User();
        user.setPassword(dto.getPassword());
        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        return user;
    }


    @Override
    public UserRegisterDTO createDTO(User model) {
        UserRegisterDTO dto = new UserRegisterDTO();
        dto.setId(model.getId());
        dto.setUsername(model.getUsername());
        dto.setPassword(model.getPassword());
        return dto;
    }
}
