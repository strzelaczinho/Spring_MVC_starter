package adam.projekty.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data                       // generuje wszystko
@EqualsAndHashCode(of = "id") // utworzy equals and hash code  tylko dla elementy id  a nie jakis object czy cos-->
public class TodoItem {

    // == fields ==
    private int id;
    private String title;
    private String details;
    private LocalDate deadline;

    // == constructors ==
    public TodoItem(String title, String details, LocalDate deadline) {
        this.title = title;
        this.details = details;
        this.deadline = deadline;
    }
}