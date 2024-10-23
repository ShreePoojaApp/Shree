package com.shreepooja.repository;

import com.shreepooja.entity.Worship;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorshipRepository extends MongoRepository<Worship, String> {
}
