package org.app.desktop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeeklyTrainingLoadModel {
    private double totalLoad;
    private double monotony;
    private int constraint;
    private int fitness;
    private double acuteChronicWorkloadRatio;
}
