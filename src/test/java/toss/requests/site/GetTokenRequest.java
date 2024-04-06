package toss.requests.site;

import io.gatling.javaapi.core.ChainBuilder;
import toss.configManager.SessionConstants;

import static io.gatling.javaapi.core.CoreDsl.StringBody;
import static io.gatling.javaapi.core.CoreDsl.exec;
import static io.gatling.javaapi.core.CoreDsl.jmesPath;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class GetTokenRequest {
    public static ChainBuilder pwaLogIn = exec(
            http("GET token request")
                    .get("/auth/token")
                    .ignoreProtocolHeaders()
                    .asJson()
                    .body(StringBody("{\n" +
                            "    \"username\": \"\",\n" +
                            "    \"password\": \"\"\n" +
                            "}"))
                    .check(status().is(200))
                    .check(jmesPath("token").saveAs(SessionConstants.JWT_TOKEN.getConstant()))
    );

    public static ChainBuilder dmLogIn = exec(
            http("GET token request")
                    .get("")
                    .ignoreProtocolHeaders()
                    .asJson()
                    .body(StringBody("{\n" +
                            "    \"username\": \"\",\n" +
                            "    \"password\": \"\"\n" +
                            "}"))
                    .check(status().is(200))
                    .check(jmesPath("token").saveAs(SessionConstants.JWT_TOKEN.getConstant()))
    );
}
