package org.app.desktop.repository.impl;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;
import org.app.desktop.model.AthleteModel;
import org.app.desktop.repository.AthleteRepository;
import org.bson.Document;

import static org.app.desktop.mapper.AthleteMapper.athleteToDocument;

public class AthleteRepositoryImpl implements AthleteRepository {

    MongoCollection<Document> collection;

    public AthleteRepositoryImpl(MongoCollection<Document> collection) {this.collection = collection;}

    @Override
    public String save(AthleteModel athlete) {
        InsertOneResult result = this.collection.insertOne(athleteToDocument(athlete));
        return result.getInsertedId().toString();
    }
}
