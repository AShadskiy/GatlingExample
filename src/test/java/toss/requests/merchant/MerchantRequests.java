package toss.requests.merchant;

import io.gatling.javaapi.core.ChainBuilder;
import toss.configManager.SessionConstants;

import java.util.Map;

import static io.gatling.javaapi.core.CoreDsl.StringBody;
import static io.gatling.javaapi.core.CoreDsl.exec;
import static io.gatling.javaapi.core.CoreDsl.jsonPath;
import static io.gatling.javaapi.http.HttpDsl.StringBodyPart;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class MerchantRequests {

    public static ChainBuilder createDeposit = exec(
            http("POST create deposit")
                    .post("")
                    .headers(Map.of("Signature", SessionConstants.DEPOSIT_SIGNATURE.getElString()))
                    .asJson()
                    .body(StringBody(SessionConstants.DEPOSIT_BODY.getElString()))
                    .check(status().is(200))
                    .check(jsonPath("$invoiceId").saveAs(SessionConstants.ORDER_ID.getConstant()))
    );

    public static ChainBuilder getBanksPage = exec(
            http("GET bank page")
                    .get(String.format("%s", SessionConstants.ORDER_ID.getElString()))
    );

    public static ChainBuilder setBankForTheDeposit = exec(
            http("POST bank for the deposit")
                    .post(String.format("%s", SessionConstants.ORDER_ID.getElString()))
                    .bodyPart(
                            StringBodyPart("select_bank[bank]", SessionConstants.BANK_FOR_DEPOSIT.getElString())
                    )
    );

    public static ChainBuilder createPayout = exec(
            http("POST create deposit")
                    .post("")
                    .headers(Map.of("Signature", SessionConstants.PAYOUT_SIGNATURE.getElString()))
                    .asJson()
                    .body(StringBody(SessionConstants.PAYOUT_BODY.getElString()))
                    .check(status().is(200))
    );
}
