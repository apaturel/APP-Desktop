package org.app.desktop.mapper;

import org.app.desktop.model.WeeklyTrainingLoadModel;
import org.bson.Document;

public class WeeklyTrainingLoadMapper {
    public static Document weeklyTrainingLoadToDocument(WeeklyTrainingLoadModel weeklyTrainingLoad) {
        return new Document()
                .append("totalLoad", weeklyTrainingLoad.getTotalLoad())
                .append("monotony", weeklyTrainingLoad.getMonotony())
                .append("constraint", weeklyTrainingLoad.getConstraint())
                .append("fitness", weeklyTrainingLoad.getFitness())
                .append("acuteChronicWorkLoadRatio", weeklyTrainingLoad.getAcuteChronicWorkloadRatio());
    }
}
