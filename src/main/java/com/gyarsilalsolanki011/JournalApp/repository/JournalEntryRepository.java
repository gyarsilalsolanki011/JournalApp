package com.gyarsilalsolanki011.JournalApp.repository;

import com.gyarsilalsolanki011.JournalApp.Entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

public interface JournalEntryRepository extends MongoRepository<JournalEntry, ObjectId> {

}
