package toss.scenarios;

import io.gatling.javaapi.core.ScenarioBuilder;
import toss.configManager.SessionConstants;
import toss.constants.OrderType;
import toss.constants.Pause;
import toss.helpers.SessionHelper;
import toss.requests.site.MutationRequests;
import toss.requests.site.QueryRequests;

import static io.gatling.javaapi.core.CoreDsl.doSwitch;
import static io.gatling.javaapi.core.CoreDsl.exec;
import static io.gatling.javaapi.core.CoreDsl.onCase;
import static io.gatling.javaapi.core.CoreDsl.scenario;

public class DropWorkScenario {

    public static ScenarioBuilder dropWorkScenario = scenario("Drop work scenario")
            .doWhile(session -> session.getList(SessionConstants.ORDERS_DATA.getConstant()).isEmpty()).on(
                    exec(QueryRequests.getOrders)
                            .pause(Pause.SECONDS_10.getSeconds())
            )
            .exec(SessionHelper::saveOrderWithType)
            .exec(SessionHelper::saveOrdersList)
            .foreach(session -> session.getList(SessionConstants.ORDERS_LIST.getConstant()),
                    SessionConstants.ORDER_ID.getConstant())
            .on(
                    doSwitch(session -> {
                        String id = session.getString(SessionConstants.ORDER_ID.getConstant());
                        assert id != null;
                        return session.getString(id);
                    }).on(
                            onCase(OrderType.SITE_PAYOUT.getType()).then(
                                    exec(MutationRequests.payoutOrderConfirm)
                            ),
                            onCase(OrderType.SITE_DEPOSIT.getType()).then(
                                    exec(MutationRequests.depositOrderConfirm)
                            )
                    )
            );
}
