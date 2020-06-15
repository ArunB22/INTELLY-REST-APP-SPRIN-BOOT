package com.example.restservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.example.restservice.models.*;
import com.example.restservice.repository.RepairRepository;
import com.example.restservice.repository.UserRepository;
import com.example.restservice.response.ResponseWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@CrossOrigin
@RestController
public class Controller {

    private User user;
    private final UserRepository userRepository = new UserRepository();
    private final RepairRepository repairRepository = new RepairRepository();

    @PostMapping("/login")
    public ResponseWrapper<UserResponse> login(@RequestBody LoginRequest loginRequest) throws Exception {
        user = userRepository.getUserByEmail(loginRequest.getEmail());
        if (user.getPassword().equals(loginRequest.getPassword()))
            return new ResponseWrapper<>(new UserResponse(user.getId(),
                    user.getName(),
                    user.getEmail()),
                    HttpStatus.OK);
        else
            throw new Exception("Password Mismatch");

    }

    @PostMapping("/register")
    public ResponseWrapper<UserResponse> register(@RequestBody RegisterRequest registerRequest) throws Exception {

        if (userRepository.checkUserForEmailExists(registerRequest.getEmail()))
            throw new Exception("User with email already exists");
        else
            user = userRepository.addUser(registerRequest);


        return new ResponseWrapper<>(new UserResponse(user.getId(),
                user.getName(), user.getEmail()), HttpStatus.OK);

    }

    @GetMapping("/getRepairs")
    public ResponseWrapper<List<Repairs>> getRepairList(@RequestParam("id") Integer id) {
        return new ResponseWrapper<>(repairRepository.getRepairsListForUser(id), HttpStatus.OK);
    }


}
