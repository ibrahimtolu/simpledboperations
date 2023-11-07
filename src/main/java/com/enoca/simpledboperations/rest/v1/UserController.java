package com.enoca.simpledboperations.rest.v1;

import com.enoca.simpledboperations.core.domain.User;
import com.enoca.simpledboperations.core.dto.UserDto;
import com.enoca.simpledboperations.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(path = "/save")
    public ResponseEntity save(@RequestBody User user) {


        if (userService.save(user))
            return new ResponseEntity<>(HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);


    }


    @GetMapping(path = "/find/{id}")
    public ResponseEntity<Optional<User>> findByUserId(@PathVariable Long id) {

        Optional<User> userById = userService.UserFindById(id);
        if (userById.isEmpty())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        return ResponseEntity.ok(userById);
    }

    @GetMapping(path = "/findAll")
    public ResponseEntity<List<UserDto>> findAllUser() {

        List<UserDto> allUser = userService.findAll();
        if (allUser.isEmpty())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        return ResponseEntity.ok(allUser);
    }

    @DeleteMapping(path = "/deleteById/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {

        boolean status = userService.deleteById(id);
        if (!status)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        return new ResponseEntity(HttpStatus.ACCEPTED);
    }


}
