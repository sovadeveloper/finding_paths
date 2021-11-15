package Utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class AutoIncrement {
    private int id = 0;

    public AutoIncrement() {
    }

    public int setId(){
        id++;
        return id;
    }
}
