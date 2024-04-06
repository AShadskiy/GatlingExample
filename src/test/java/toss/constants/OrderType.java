package toss.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OrderType {
    DEPOSIT("deposit"),
    PAYOUT("payout"),
    SITE_DEPOSIT("SiteDepositOrder"),
    SITE_PAYOUT("SitePayoutOrder"),
    ;

    private final String type;
}
