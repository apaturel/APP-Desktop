package org.app.desktop.repository.impl;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;
import org.app.desktop.model.WeeklyTrainingLoadModel;
import org.app.desktop.repository.WeeklyTrainingLoadRepository;
import org.bson.Document;

import static org.app.desktop.mapper.WeeklyTrainingLoadMapper.weeklyTrainingLoadToDocument;

public class WeeklyTrainingLoadRepositoryImpl implements WeeklyTrainingLoadRepository {

    MongoCollection<Document> collection;

    public WeeklyTrainingLoadRepositoryImpl(MongoCollection<Document> collection) {this.collection = collection;}

    @Override
    public String save(WeeklyTrainingLoadModel weeklyTrainingLoad) {
        InsertOneResult result = this.collection.insertOne(weeklyTrainingLoadToDocument(weeklyTrainingLoad));
        return result.getInsertedId().toString();
    }
}
