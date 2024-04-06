package toss.simulations;

import io.gatling.javaapi.core.Simulation;
import toss.configManager.HttpProtocol;
import toss.scenarios.CardPageScenario;
import toss.scenarios.CreateInvoiceScenario;
import toss.scenarios.DropActivateScenario;
import toss.scenarios.DropWorkScenario;
import toss.scenarios.LogInScenario;
import toss.scenarios.OrdersPageScenario;

import static io.gatling.javaapi.core.CoreDsl.constantUsersPerSec;

public class DropAndMerchantActionsTest extends Simulation implements HttpProtocol {

    public DropAndMerchantActionsTest() {
        this.setUp(
                LogInScenario.logIn.injectOpen(
                                constantUsersPerSec(1).during(1))
                        .andThen(DropActivateScenario.dropActivate.injectOpen(
                                constantUsersPerSec(1).during(1)))
                        .andThen(CardPageScenario.openCardPageAndCheckCardStatistic.injectOpen(
                                constantUsersPerSec(1).during(1)))
                        .andThen(OrdersPageScenario.openOrdersPageAndCheckArchive.injectOpen(
                                constantUsersPerSec(1).during(1)))
                        .andThen(OrdersPageScenario.openOrdersPage.injectOpen(
                                constantUsersPerSec(1).during(1)))
                        .andThen(
                                DropWorkScenario.dropWorkScenario.injectOpen(
                                        constantUsersPerSec(1).during(1)
                                ),
                                CreateInvoiceScenario.createInvoices.injectOpen(
                                        constantUsersPerSec(1).during(1)
                                ).protocols(merchantHttpProtocol)
                        )
        ).protocols(siteHttpProtocol);
    }
}
