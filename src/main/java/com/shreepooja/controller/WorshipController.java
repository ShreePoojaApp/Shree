package com.shreepooja.controller;

import com.shreepooja.entity.User;
import com.shreepooja.entity.Worship;
import com.shreepooja.exception.ResourceNotFoundException;
import com.shreepooja.service.WorshipService;
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
@RequestMapping(value = "/worship")
@SecurityRequirement(name = "Keycloak")
public class WorshipController {
    @Autowired
    MessageSourceConfig messageSourceConfig;
    /*@Autowired
    KeyCloakService keyCloakService;*/
    @Autowired
    private WorshipService worshipService;

    @GetMapping(value = "/{id}")
    //@PreAuthorize("hasRole('admin')")
    public ResponseEntity<ApiResponse> getWorship(@PathVariable(value = "id", required = true) final String id) {
        log.info("Getting the Worship info with id {}", id);
        final Optional<Worship> worship = worshipService.getWorship(id);
        if (worship.isEmpty()) {
            String message = messageSourceConfig.getString("error.worship.notfound", id);
            throw  new ResourceNotFoundException(message);
        } else {
            final ApiResponse apiResponse = GenericCommonUtils.buildResponse(worship, "Success.",
                    true, HttpStatus.OK.value(), null);
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/all")
    //@PreAuthorize("hasRole('admin')")
    public ResponseEntity<ApiResponse> getWorships() {
        log.info("Getting all the Worships");
        final List<Worship> worships = worshipService.getAllWorships();
        final ApiResponse apiResponse = GenericCommonUtils.buildResponse(worships, "Success.",
                true, HttpStatus.OK.value(), null);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createWorship(@RequestBody final Worship worship) {
        worshipService.createWorship(worship);
        final ApiResponse apiResponse = GenericCommonUtils.buildResponse(null, "The Worship is created successfully.",
                true, HttpStatus.CREATED.value(), null);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }
}
