package org.app.desktop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityModel {
    private String name;
    private int duration;
    private Date date;
    private int feltPostEffort;
    private double load;

    public ActivityModel(String name, int duration, Date date, int feltPostEffort){
        this.name = name;
        this.duration = duration;
        this.date = date;
        this.feltPostEffort = feltPostEffort;
    }
}
