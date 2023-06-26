import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
public class Activity {
    private String name;
    private int duration;
    private Date date;
    private int feltPostEffort;
    private double load;

}
