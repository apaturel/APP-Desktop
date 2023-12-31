package org.app.desktop;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Connection {
    private static Logger logger = LoggerFactory.getLogger(Connection.class);
    public static void main(String[] args) {
        String connectionString = "mongodb+srv://arthurpaturel:arthurpaturel@app-desktop.cwfrlkx.mongodb.net/?retryWrites=true&w=majority";
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            List<Document> databases = mongoClient.listDatabases().into(new ArrayList<>());
            databases.forEach(db -> logger.info("Test", db.toJson()));
        }
    }
}