package toss.scenarios;

import io.gatling.javaapi.core.ScenarioBuilder;
import toss.requests.site.MutationRequests;
import toss.requests.site.QueryRequests;

import static io.gatling.javaapi.core.CoreDsl.scenario;

public class DropActivateScenario {

    public static ScenarioBuilder dropActivate = scenario("Drop activate")
            .exec(MutationRequests.dropActivate)
            .exec(QueryRequests.getDrop);
}
