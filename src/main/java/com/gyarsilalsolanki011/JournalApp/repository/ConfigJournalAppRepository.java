package com.gyarsilalsolanki011.JournalApp.repository;

import com.gyarsilalsolanki011.JournalApp.entity.ConfigJournalAppEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConfigJournalAppRepository extends MongoRepository<ConfigJournalAppEntity, String> {

}
