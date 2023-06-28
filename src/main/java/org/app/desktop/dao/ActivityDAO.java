package org.app.desktop.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.app.desktop.model.ActivityModel;
import org.bson.Document;

import java.util.Date;

public class ActivityDAO {
    private MongoCollection<Document> collection;

    public ActivityDAO(MongoDatabase database) {
        this.collection = database.getCollection("activities");
    }

    public void addActivity(ActivityModel activity) {
        Document document = new Document()
                .append("name", activity.getName())
                .append("duration", activity.getDuration())
                .append("date", activity.getDate())
                .append("feltPostEffort", activity.getFeltPostEffort())
                .append("load", activity.getLoad());
        collection.insertOne(document);
    }

    public ActivityModel getActivity(String activityName, int duration, Date date, int feltPostEffort, double load) {
        Document query = new Document();

        Document activityDocument = collection.find(query).first();

        if (activityDocument != null) {
            ActivityModel activity = new ActivityModel();
            activity.setName(activityDocument.getString("name"));
            activity.setDuration(activityDocument.getInteger("duration"));
            activity.setDate(activityDocument.getDate("birthDate"));
            activity.setFeltPostEffort(activityDocument.getInteger("feltPostEffort"));
            activity.setLoad(activityDocument.getDouble("load"));

            return activity;
        } else {
            return null;
        }
    }
    // Implémentez d'autres méthodes comme getAthlete, updateAthlete, deleteAthlete, etc.
}
