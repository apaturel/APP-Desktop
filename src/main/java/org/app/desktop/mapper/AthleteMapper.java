package org.app.desktop.mapper;

import org.app.desktop.model.AthleteModel;
import org.bson.Document;

public class AthleteMapper {
    public static Document athleteToDocument(AthleteModel athlete) {
        Document document = new Document()
                .append("firstName", athlete.getFirstName())
                .append("lastName", athlete.getLastName())
                .append("birthDate", athlete.getBirthDate())
                .append("gender", athlete.getGender());
        return document;
    }
}
