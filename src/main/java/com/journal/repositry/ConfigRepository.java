package com.journal.repositry;

import com.journal.entity.Config;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConfigRespository extends MongoRepository<Config, ObjectId> {
}
