package toss.scenarios;

import io.gatling.javaapi.core.ScenarioBuilder;
import toss.requests.site.GetTokenRequest;
import toss.requests.site.QueryRequests;

import static io.gatling.javaapi.core.CoreDsl.scenario;

public class LogInScenario {
    public static ScenarioBuilder logIn = scenario("Log in")
            .exec(GetTokenRequest.pwaLogIn)
            .exec(QueryRequests.getDrop)
            .exec(QueryRequests.getProfile);
}
