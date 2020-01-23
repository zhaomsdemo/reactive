package com.zjh.reactive.repository;

import com.zjh.reactive.entity.User;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveCrudRepository<User,String> {

    Flux<User> findByName(String name);

    Flux<User> findByAgeBetween(int before,int after);

    @Query(value = "{'attributes.?0':{$exists:true}}")
    Flux<User> findByPropertiesIsContaining(String key);

}
