package com.shreepooja.controller;

import com.shreepooja.entity.User;
import com.shreepooja.exception.ResourceNotFoundException;
import com.shreepooja.service.UserService;
import com.shreepooja.utils.ApiResponse;
import com.shreepooja.utils.GenericCommonUtils;
import com.shreepooja.utils.MessageSourceConfig;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(value = "/user")
@SecurityRequirement(name = "Keycloak")
public class UserController {
    @Autowired
    MessageSourceConfig messageSourceConfig;
    /*@Autowired
    KeyCloakService keyCloakService;*/
    @Autowired
    private UserService userService;

    @GetMapping(value = "/{id}")
    //@PreAuthorize("hasRole('admin')")
    public ResponseEntity<ApiResponse> getUser(@PathVariable(value = "id", required = true) final String id) {
        log.info("Getting the user info for the user with id {}", id);
        final Optional<User> user = userService.getUser(id);
        if (user.isEmpty()) {
            String message = messageSourceConfig.getString("error.user.notfound", id);
            throw  new ResourceNotFoundException(message);
        } else {
            final ApiResponse apiResponse = GenericCommonUtils.buildResponse(user, "Success.",
                    true, HttpStatus.OK.value(), null);
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/all")
    //@PreAuthorize("hasRole('admin')")
    public ResponseEntity<ApiResponse> getUser() {
        List<User> users = userService.getUsers();

        final ApiResponse apiResponse = GenericCommonUtils.buildResponse(users, "Success.",
                true, HttpStatus.OK.value(), null);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createUser(@RequestBody final User user) {
        userService.createUser(user);
        final ApiResponse apiResponse = GenericCommonUtils.buildResponse(null, "The User is created successfully.",
                true, HttpStatus.CREATED.value(), null);
        //userService.createUser(user.getuserId(), user.getEmail(), user.getFirstName(), user.getLastName(), user.getFirstName());
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseBody updateUser(@RequestBody final User user) {
        return null;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ApiResponse> removeUser(
            @PathVariable(value = "id", required = true) final String id) {
        //userService.delete(id);
        final ApiResponse apiResponse = GenericCommonUtils.buildResponse(null, "Success.",
                true, HttpStatus.NO_CONTENT.value(), null);
        return new ResponseEntity<>(apiResponse, HttpStatus.NO_CONTENT);
    }
}
