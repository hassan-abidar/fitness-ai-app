package com.fitness.userservice.repository;

import com.fitness.userservice.model.User;
import com.fitness.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    boolean existsByEmail(String email);
}
