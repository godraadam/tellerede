package dev.godraadam.untold.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import dev.godraadam.untold.model.Role;
import dev.godraadam.untold.model.User;

public interface UserRepo extends CrudRepository<User, Long>  {
    public Optional<User> findByUsername(String username);
    public List<User> findByRole(Role role);
}
