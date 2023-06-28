package org.app.desktop.mapper;

import org.app.desktop.model.ActivityModel;
import org.bson.Document;

public class ActivityMapper {
    public static Document activityToDocument(ActivityModel activity) {
        return new Document()
                .append("name", activity.getName())
                .append("duration", activity.getDuration())
                .append("date", activity.getDate())
                .append("feltPostEffort", activity.getFeltPostEffort())
                .append("load", activity.getFeltPostEffort());
    }
}
