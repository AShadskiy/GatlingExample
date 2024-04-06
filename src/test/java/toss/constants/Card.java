package toss.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Card {
    TINKOFF(""),
    RAIFFEIZEN(""),
    SBER(""),
    VTB(""),
    ALPHA(""),
    OTKRITIE(""),
    ;

    private final String number;
}
