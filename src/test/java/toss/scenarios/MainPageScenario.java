package toss.scenarios;

import io.gatling.javaapi.core.ScenarioBuilder;
import toss.requests.site.QueryRequests;

import static io.gatling.javaapi.core.CoreDsl.scenario;

public class MainPageScenario {

    public static ScenarioBuilder openMainPage = scenario("Open main page")
            .exec(QueryRequests.getProfile)
            .exec(QueryRequests.getDrop);
}
