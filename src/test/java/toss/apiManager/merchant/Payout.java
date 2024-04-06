package toss.apiManager.merchant;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import toss.constants.Amount;
import toss.constants.Card;
import toss.constants.Currency;

import java.util.UUID;

import static toss.requests.site.QueryRequests.faker;

@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Payout {

    private String cNumber;
    private int amount;
    private String currency;
    private String description;
    private String cId;
    private String wId;
    @Getter
    private String signature;

    public Payout() {
        this.cNumber = Card.values()[faker.random().nextInt(0, Card.values().length) - 1].getNumber();
        this.amount = Amount.PAYOUT_AMOUNT.getAmount();
        this.currency = Currency.RUB.getCurrency();
        this.description = "description";
        this.cId = UUID.randomUUID().toString();
        this.wId = UUID.randomUUID().toString();
        this.signature = Signature.getSignature(this.getPayoutBody());
    }

    public String getPayoutBody() {
        return "";
    }
}
