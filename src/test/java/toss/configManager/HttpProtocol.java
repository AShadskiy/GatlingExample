package toss.configManager;

import io.gatling.javaapi.http.HttpProtocolBuilder;

import static io.gatling.javaapi.http.HttpDsl.http;

public interface HttpProtocol {

    HttpProtocolBuilder siteHttpProtocol = http
            .baseUrl("")
            .header("Authorization", String.format("Bearer %s", SessionConstants.JWT_TOKEN.getElString()));

    HttpProtocolBuilder merchantHttpProtocol = http
            .baseUrl("");
}
