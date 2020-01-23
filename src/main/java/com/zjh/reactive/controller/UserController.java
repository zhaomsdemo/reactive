package com.zjh.reactive.controller;

import com.zjh.reactive.entity.User;
import com.zjh.reactive.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/")
    public Mono<User> createUser(@RequestBody User user) {
        Mono<User> userMono = userRepository.save(user);
        return userMono;
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteUser(@PathVariable String id){
        return userRepository.deleteById(id);
    }

    @PutMapping("/")
    public Mono<User> updateUser(@RequestBody User user){
        Mono<User> userMono = userRepository.save(user);
        return userMono;
    }

    /*Get methods*/

    @GetMapping("/{id}")
    public Mono<User> findById(@PathVariable String id){
        return userRepository.findById(id);
    }

    @GetMapping("/findByName")
    public Flux<User> getUsersByName(@RequestParam String name) {
        Flux<User> userFlux = userRepository.findByName(name);
        return userFlux;
    }

    @GetMapping("/findByAge")
    public Flux<User> getUsersByAgeBetween(@RequestParam int before, @RequestParam int after) {
        Flux<User> userFlux = userRepository.findByAgeBetween(before, after);
        return userFlux;
    }

    @GetMapping("/findByKey")
    public Flux<User> getUsersByPropertiesKey(@RequestParam String key){
        Flux<User> userFlux = userRepository.findByPropertiesIsContaining(key);
        return userFlux;
    }
}