package org.app.desktop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Activity {
    private String name;
    private int duration;
    private Date date;
    private int feltPostEffort;
    private double load;

}
