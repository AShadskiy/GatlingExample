package toss.scenarios;

import io.gatling.javaapi.core.ScenarioBuilder;
import toss.configManager.SessionConstants;
import toss.constants.OrderType;
import toss.requests.site.QueryRequests;

import static io.gatling.javaapi.core.CoreDsl.scenario;

public class OrdersPageScenario {

    public static ScenarioBuilder openOrdersPage = scenario("Open orders page")
            .exec(QueryRequests.getDrop)
            .exec(QueryRequests.getOrders);

    public static ScenarioBuilder openOrdersPageAndCheckArchive = scenario("Open orders page")
            .exec(QueryRequests.getDrop)
            .exec(QueryRequests.getOrders)
            .pause(1, 5)
            .exec(session -> session.set(SessionConstants.ORDER_TYPE.getConstant(), OrderType.DEPOSIT))
            .exec(QueryRequests.getOrdersArchive);
}
