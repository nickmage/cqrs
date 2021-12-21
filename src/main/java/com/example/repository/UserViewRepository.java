package com.example.repository;

import com.example.entity.UserView;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface UserViewRepository extends JpaRepository<UserView, Long> {

}
