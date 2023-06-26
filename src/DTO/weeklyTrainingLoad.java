import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
public class WeeklyTrainingLoad {
    private double totalLoad;
    private double monotony;
    private int constraint;
    private int fitness;
    private double acuteChronicWorkloadRatio;
}
