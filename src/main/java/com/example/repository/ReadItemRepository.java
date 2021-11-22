package com.example.repository;

import com.example.entity.ReadItem;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface ReadItemRepository extends JpaRepository<ReadItem, Long> {

}
