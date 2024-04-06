package toss.scenarios;

import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Session;
import toss.apiManager.merchant.Deposit;
import toss.configManager.SessionConstants;
import toss.constants.Bank;
import toss.requests.merchant.MerchantRequests;

import static io.gatling.javaapi.core.CoreDsl.scenario;
import static toss.requests.site.QueryRequests.faker;

public class CreateInvoiceScenario {

    public static ScenarioBuilder createInvoices = scenario("Create deposits")
            .exec(session -> {
                Deposit deposit = new Deposit();
                Session newSession = session.set(
                        SessionConstants.DEPOSIT_BODY.getConstant(),
                        deposit.getDepositBody()
                );
                newSession.set(
                        SessionConstants.DEPOSIT_SIGNATURE.getConstant(),
                        deposit.getSignature()
                );
                newSession.set(
                        SessionConstants.BANK_FOR_DEPOSIT.getConstant(),
                        Bank.values()[faker.random().nextInt(0, Bank.values().length - 1)]
                );
                return newSession;
            })
            .exec(MerchantRequests.createDeposit)
            .exec(MerchantRequests.getBanksPage)
            .exec(MerchantRequests.setBankForTheDeposit)
            .exec(MerchantRequests.createPayout);
}
