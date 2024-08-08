package com.gyarsilalsolanki011.JournalApp.repository;

import com.gyarsilalsolanki011.JournalApp.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepository extends MongoRepository<JournalEntry, ObjectId> {

}
