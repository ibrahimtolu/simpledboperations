package com.enoca.simpledboperations.core.service;


import com.enoca.simpledboperations.core.domain.User;
import com.enoca.simpledboperations.core.dto.UserDto;
import com.enoca.simpledboperations.core.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;


    public List<UserDto> findAll() {

        return userRepo.findAllUser();
    }

    public boolean save(User user) {

        User save = userRepo.save(user);

        if(user.getId().equals(null)) return false;
        return true;

    }

    public Optional<User> UserFindById(Long id) {

        return userRepo.findById(id);
    }


    public boolean deleteById(Long id) {

        userRepo.deleteById(id);
        Optional<User> user = UserFindById(id);
        if (user.isEmpty()) return true;
        else throw new RuntimeException("User cannot delete");

    }


}
