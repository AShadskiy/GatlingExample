package toss.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Pause {
    SECOND_1(1),
    SECONDS_5(5),
    SECONDS_10(10),
    ;

    private final int seconds;
}
