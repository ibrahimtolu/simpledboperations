package com.enoca.simpledboperations.core.service;


import com.enoca.simpledboperations.core.domain.Follow;
import com.enoca.simpledboperations.core.domain.User;
import com.enoca.simpledboperations.core.dto.FollowDto;
import com.enoca.simpledboperations.core.dto.UserDto;
import com.enoca.simpledboperations.core.repo.FollowRepo;
import com.enoca.simpledboperations.core.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FollowService {

    @Autowired
    FollowRepo followRepo;

    public List<FollowDto> findAllFollower(Long userId){
        return followRepo.findAllFollower(userId);
    }

    public boolean follow(Follow follow){
        Follow save = followRepo.save(follow);
        if (save.equals(null)) return false;
        return true;
    }



}
