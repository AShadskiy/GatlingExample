package toss.simulations;

import io.gatling.javaapi.core.Simulation;
import toss.configManager.HttpProtocol;
import toss.scenarios.LogInScenario;

import static io.gatling.javaapi.core.CoreDsl.constantUsersPerSec;

public class LogInTest extends Simulation implements HttpProtocol {

    public LogInTest() {
        this.setUp(
                LogInScenario.logIn.injectOpen(
                        constantUsersPerSec(1).during(1)
                )
        ).protocols(siteHttpProtocol);
    }
}
