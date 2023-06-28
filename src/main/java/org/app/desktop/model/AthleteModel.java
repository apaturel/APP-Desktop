package org.app.desktop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.app.desktop.enumeration.Gender;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AthleteModel {
    private String lastName;
    private String firstName;
    private Date birthDate;
    private Gender gender;
}

