package org.app.desktop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeeklyTrainingLoad {
    private double totalLoad;
    private double monotony;
    private int constraint;
    private int fitness;
    private double acuteChronicWorkloadRatio;
}
