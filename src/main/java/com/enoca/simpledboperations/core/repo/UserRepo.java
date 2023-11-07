package com.enoca.simpledboperations.core.repo;

import com.enoca.simpledboperations.core.domain.User;
import com.enoca.simpledboperations.core.dto.UserDto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface UserRepo extends JpaRepository<User,Long> {


    @Query("SELECT user.userName as userName, user.email as userEmail, user.age as age, user.createdAt as createdTime from  User user ")
    List<UserDto> findAllUser();



}
