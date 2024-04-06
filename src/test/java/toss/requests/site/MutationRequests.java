package toss.requests.site;

import io.gatling.javaapi.core.ChainBuilder;
import toss.apiManager.graphQl.Input;
import toss.apiManager.graphQl.QueryBuilder;
import toss.apiManager.graphQl.QueryVariables;
import toss.configManager.SessionConstants;
import toss.constants.Schema;

import static io.gatling.javaapi.core.CoreDsl.StringBody;
import static io.gatling.javaapi.core.CoreDsl.exec;
import static io.gatling.javaapi.http.HttpDsl.http;

public class MutationRequests {

    public static ChainBuilder dropActivate = exec(
            http("MUTATION drop activate")
                    .post("")
                    .asJson()
                    .body(StringBody(QueryBuilder.getQuery(
                            Schema.DROP_ACTIVATE
                    )))
    );

    public static ChainBuilder dropDeactivateActivate = exec(
            http("MUTATION drop deactivate")
                    .post("")
                    .asJson()
                    .body(StringBody(QueryBuilder.getQuery(
                            Schema.DROP_DEACTIVATE
                    )))
    );

    public static ChainBuilder payoutOrderConfirm = exec(
            http("MUTATION payout order confirm")
                    .post("")
                    .asJson()
                    .body(StringBody(QueryBuilder.getQuery(
                            Schema.PAYOUT_ORDER_CONFIRM,
                            new QueryVariables()
                                    .withInput(new Input().withInput(SessionConstants.ORDER_ID.getElString()))
                    )))
    );

    public static ChainBuilder depositOrderConfirm = exec(
            http("MUTATION deposit order confirm")
                    .post("")
                    .asJson()
                    .body(StringBody(QueryBuilder.getQuery(
                            Schema.PAYOUT_ORDER_CONFIRM,
                            new QueryVariables()
                                    .withInput(new Input()
                                            .withInput(SessionConstants.ORDER_ID.getElString())
                                            .withAmount(1000))
                    )))
    );
}
