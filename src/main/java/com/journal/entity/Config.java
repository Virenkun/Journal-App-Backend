package com.journal.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "config")
@Data
@NoArgsConstructor
public class Config {
    @Id
    private ObjectId id;
    private String name;
    private String value;
}
