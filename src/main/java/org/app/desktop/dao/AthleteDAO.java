package org.app.desktop.dao;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.app.desktop.model.AthleteModel;
import org.app.desktop.enumeration.Gender;
import org.bson.Document;

import java.util.Date;

public class AthleteDAO {
    private MongoCollection<Document> collection;

    public AthleteDAO(MongoDatabase database) {
        this.collection = database.getCollection("athletes");
    }

    public void addAthlete(AthleteModel athlete) {
        Document document = new Document()
                .append("firstName", athlete.getFirstName())
                .append("lastName", athlete.getLastName())
                .append("birthDate", athlete.getBirthDate())
                .append("gender", athlete.getGender().toString());
        collection.insertOne(document);
    }

    public AthleteModel getAthlete(String firstName, String lastName, Date birthDate, Gender gender) {
        Document query = new Document();

        Document athleteDocument = collection.find(query).first();

        if (athleteDocument != null) {
            AthleteModel athlete = new AthleteModel();
            athlete.setFirstName(athleteDocument.getString("firstName"));
            athlete.setLastName(athleteDocument.getString("lastName"));
            athlete.setBirthDate(athleteDocument.getDate("birthDate"));
            athlete.setGender(Gender.valueOf(athleteDocument.getString("gender")));

            return athlete;
        } else {
            return null;
        }
    }
    // Implémentez d'autres méthodes comme getAthlete, updateAthlete, deleteAthlete, etc.
}
