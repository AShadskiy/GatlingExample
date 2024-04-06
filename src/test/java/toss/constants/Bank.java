package toss.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Bank {
    SBER(""),
    TINKOFF(""),
    OTHER(""),
    ;

    private final String bank;
}
