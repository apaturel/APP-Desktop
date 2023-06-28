package org.app.desktop.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.app.desktop.model.WeeklyTrainingLoadModel;
import org.bson.Document;

import java.util.Date;

public class WeeklyTrainingLoadDAO {
    private MongoCollection<Document> collection;

    public WeeklyTrainingLoadDAO(MongoDatabase database) {
        this.collection = database.getCollection("weeklyTrainingLoadDAO");
    }

    public void addWeeklyTrainingLoad(WeeklyTrainingLoadModel weeklyTrainingLoad) {
        Document document = new Document()
                .append("totalLoad", weeklyTrainingLoad.getTotalLoad())
                .append("monotony", weeklyTrainingLoad.getMonotony())
                .append("constraint", weeklyTrainingLoad.getConstraint())
                .append("fitness", weeklyTrainingLoad.getFitness())
                .append("acuteChronicWorkLoadRatio", weeklyTrainingLoad.getAcuteChronicWorkloadRatio());
        collection.insertOne(document);
    }

    public WeeklyTrainingLoadModel getWeeklyTrainingLoad(String totalLoad, int monotony, Date constraint, int fitness, double acuteChronicWorkLoadRatio) {
        Document query = new Document();

        Document activityDocument = collection.find(query).first();

        if (activityDocument != null) {
            WeeklyTrainingLoadModel weeklyTrainingLoad = new WeeklyTrainingLoadModel();
            weeklyTrainingLoad.setTotalLoad(activityDocument.getDouble("totalLoad"));
            weeklyTrainingLoad.setMonotony(activityDocument.getDouble("monotony"));
            weeklyTrainingLoad.setConstraint(activityDocument.getInteger("constraint"));
            weeklyTrainingLoad.setFitness(activityDocument.getInteger("fitness"));
            weeklyTrainingLoad.setAcuteChronicWorkloadRatio(activityDocument.getDouble("acuteChronicWorkLoadRatio"));

            return weeklyTrainingLoad;
        } else {
            return null;
        }
    }
    // Implémentez d'autres méthodes comme getAthlete, updateAthlete, deleteAthlete, etc.
}
