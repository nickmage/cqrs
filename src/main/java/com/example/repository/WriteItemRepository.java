package com.example.repository;

import com.example.entity.WriteItem;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface WriteItemRepository extends JpaRepository<WriteItem, Long> {
}
