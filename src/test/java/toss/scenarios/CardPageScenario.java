package toss.scenarios;

import io.gatling.javaapi.core.ScenarioBuilder;
import toss.configManager.SessionConstants;
import toss.constants.StatisticPeriod;
import toss.requests.site.QueryRequests;

import java.util.List;

import static io.gatling.javaapi.core.CoreDsl.scenario;
import static toss.requests.site.QueryRequests.faker;

public class CardPageScenario {

    public static ScenarioBuilder openCardPageAndCheckCardStatistic = scenario("Open card page")
            .exec(session -> session.set(SessionConstants.STATISTICS_PERIOD.getConstant(), StatisticPeriod.WEEK))
            .exec(QueryRequests.getDrop)
            .exec(session -> {
                List<Object> ids = session.getList(SessionConstants.BANK_CARDS.getConstant());
                return session.set(
                        SessionConstants.BANK_CARD_ID.getConstant(),
                        ids.get(faker.random().nextInt(0, ids.size()) - 1));
            })
            .exec(QueryRequests.getBankCard)
            .exec(QueryRequests.getBankCardStatistics)
            .pause(1, 5)
            .exec(session -> session.set(
                    SessionConstants.STATISTICS_PERIOD.getConstant(),
                    StatisticPeriod.values()[faker.random().nextInt(0, StatisticPeriod.values().length - 1)]))
            .exec(QueryRequests.getBankCardStatistics);
}
