package toss.apiManager.merchant;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import toss.constants.Amount;
import toss.constants.Currency;

import java.util.UUID;

@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Deposit {

    private int amount;
    private String currency;
    @JsonProperty("c_id")
    private String cId;
    @JsonProperty("i_id")
    private String iId;
    private String description;
    @Getter
    private String signature;

    public Deposit() {
        this.amount = Amount.DEPOSIT_AMOUNT.getAmount();
        this.currency = Currency.RUB.getCurrency();
        this.cId = UUID.randomUUID().toString();
        this.iId = UUID.randomUUID().toString();
        this.description = "description";
        this.signature = Signature.getSignature(this.getDepositBody());
    }

    public String getDepositBody() {
        return "";
    }

}
