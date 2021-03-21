package dev.godraadam.untold.assembler;

import org.springframework.stereotype.Component;

import dev.godraadam.untold.dto.UserDTO;
import dev.godraadam.untold.model.Role;
import dev.godraadam.untold.model.User;

@Component
public class UserAssembler implements GeneralAssembler<UserDTO, User> {

    @Override
    public User createModel(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        user.setRole(Role.valueOf(dto.getRole()));
        return user;
    }


    @Override
    public UserDTO createDTO(User model) {
        UserDTO dto = new UserDTO();
        dto.setId(model.getId());
        dto.setUsername(model.getUsername());
        dto.setRole(model.getRole().name());
        return dto;
    }

    
}
