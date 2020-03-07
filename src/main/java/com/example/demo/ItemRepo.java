package com.example.demo;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Service;

@EnableJpaRepositories
@RepositoryRestResource
@Service
public interface ItemRepo extends JpaRepository<Item,Integer> {

}
