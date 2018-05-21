package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Repository extends CrudRepository<ProfilesEntity, Integer> {

    List<ProfilesEntity> findByLastName(String lastName);

    List<ProfilesEntity> findByFirstName(String firstName);
}
