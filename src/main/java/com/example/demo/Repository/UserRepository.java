package com.example.demo.Repository;



import com.example.demo.Entity.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> { // Change Long to Integer
User findByEmail(String email);
    //Optional<User> findByEmail(String email);
  
    //User save(User user);
}
