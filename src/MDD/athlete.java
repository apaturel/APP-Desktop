import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Athlete {
    private String lastName;
    private String firstName;
    private Date birthDate;
    private Gender gender;
}

public enum Gender {
    Male,
    Female
}
