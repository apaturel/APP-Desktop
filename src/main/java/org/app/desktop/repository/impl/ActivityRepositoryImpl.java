package org.app.desktop.repository.impl;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;
import org.app.desktop.model.ActivityModel;
import org.app.desktop.repository.ActivityRepository;
import org.bson.Document;

import static org.app.desktop.mapper.ActivityMapper.activityToDocument;

public class ActivityRepositoryImpl implements ActivityRepository {

    MongoCollection<Document> collection;

    public ActivityRepositoryImpl(MongoCollection<Document> collection) {this.collection = collection;}

    @Override
    public String save(ActivityModel activity) {
        InsertOneResult result = this.collection.insertOne(activityToDocument(activity));
        return result.getInsertedId().toString();
    }
}
