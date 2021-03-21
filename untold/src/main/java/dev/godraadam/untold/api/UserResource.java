package dev.godraadam.untold.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.godraadam.untold.assembler.UserAssembler;
import dev.godraadam.untold.assembler.UserRegisterAssembler;
import dev.godraadam.untold.dto.UserDTO;
import dev.godraadam.untold.dto.UserRegisterDTO;
import dev.godraadam.untold.model.User;
import dev.godraadam.untold.service.UserService;

@RestController
@CrossOrigin
public class UserResource {

    @Autowired
    private UserAssembler userAssembler;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRegisterAssembler userRegisterAssembler;

    @GetMapping("/admin/api/user/{username}")
    public UserDTO getUserByUsername(@PathVariable("username") String username) {

        User user = userService.getUserByUsername(username);
        return userAssembler.createDTO(user);
 
    }

    @GetMapping("/admin/api/cashiers")
    public List<UserDTO> getCashiers() {
        return userAssembler.createDTOList(userService.getCashiers());
    }

    @PostMapping("/admin/api/user/register/admin")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO registerAdmin(@RequestBody UserRegisterDTO dto) {
        User user = userService.registerAdmin(userRegisterAssembler.createModel(dto));
        return userAssembler.createDTO(user);
  
    }

    @PostMapping("/admin/api/user/register/cashier")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO registerCashier(@RequestBody UserRegisterDTO dto) {
        User user = userService.registerCashier(userRegisterAssembler.createModel(dto));
        return userAssembler.createDTO(user);
  
    }

    @DeleteMapping("/admin/api/user/delete/{username}")
    public void removeUser(@PathVariable String username) {
        userService.deleteUser(username);
    }

    @PostMapping("/login")
    public UserDTO login(@RequestBody UserRegisterDTO dto) {
        return userAssembler.createDTO(userService.login(userRegisterAssembler.createModel(dto)));
    }
    
}
