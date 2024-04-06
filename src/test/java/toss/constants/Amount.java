package toss.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Amount {
    DEPOSIT_AMOUNT(1000),
    PAYOUT_AMOUNT(1000),
    ;

    private final int amount;
}
