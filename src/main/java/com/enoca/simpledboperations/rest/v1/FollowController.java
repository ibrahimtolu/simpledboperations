package com.enoca.simpledboperations.rest.v1;

import com.enoca.simpledboperations.core.domain.Follow;
import com.enoca.simpledboperations.core.domain.User;
import com.enoca.simpledboperations.core.dto.FollowDto;
import com.enoca.simpledboperations.core.dto.UserDto;
import com.enoca.simpledboperations.core.service.FollowService;
import com.enoca.simpledboperations.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/follow")
public class FollowController {

    @Autowired
    FollowService followService;


    @GetMapping(path = "/findFollower/{userId}")
    public ResponseEntity<List<FollowDto>> findByUserId(@PathVariable Long userId) {

        List<FollowDto> allFollower = followService.findAllFollower(userId);

        if (allFollower.isEmpty())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        return ResponseEntity.ok(allFollower);
    }

    @GetMapping(path = "/follow")
    public ResponseEntity follow(@RequestBody Follow follow) {

        if (!followService.follow(follow)) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return  new ResponseEntity(HttpStatus.ACCEPTED);
    }

}
