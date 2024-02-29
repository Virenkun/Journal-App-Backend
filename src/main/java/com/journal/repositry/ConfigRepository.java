package com.journal.repositry;

import com.journal.entity.Config;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigRepository extends MongoRepository<Config, ObjectId> {
}
