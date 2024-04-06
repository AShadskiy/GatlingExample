package toss.scenarios;

import io.gatling.javaapi.core.ScenarioBuilder;
import toss.requests.site.MutationRequests;
import toss.requests.site.QueryRequests;

import static io.gatling.javaapi.core.CoreDsl.scenario;

public class DropDeactivateScenario {

    public static ScenarioBuilder dropDeactivate = scenario("Drop deactivate")
            .exec(MutationRequests.dropDeactivateActivate)
            .exec(QueryRequests.getDrop);
}
