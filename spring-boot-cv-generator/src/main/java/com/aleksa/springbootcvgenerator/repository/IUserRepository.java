package com.aleksa.springbootcvgenerator.repository;

import com.aleksa.springbootcvgenerator.model.Role;
import com.aleksa.springbootcvgenerator.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface IUserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String username);

    @Modifying
    @Query("update User set role= :role where username = :username")
    void updateRoleUser(@Param("username") String username, @Param("role")Role role);


}
