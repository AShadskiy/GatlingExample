package toss.requests.site;

import com.github.javafaker.Faker;
import io.gatling.javaapi.core.ChainBuilder;
import toss.apiManager.graphQl.Input;
import toss.apiManager.graphQl.QueryBuilder;
import toss.apiManager.graphQl.QueryVariables;
import toss.configManager.SessionConstants;
import toss.constants.Schema;
import toss.constants.SortDirection;

import static io.gatling.javaapi.core.CoreDsl.StringBody;
import static io.gatling.javaapi.core.CoreDsl.exec;
import static io.gatling.javaapi.core.CoreDsl.jsonPath;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class QueryRequests {
    public static final Faker faker = new Faker();

    private final static String queryUrl = "";

    public static ChainBuilder getProfile = exec(
            http("QUERY get profile")
                    .post(queryUrl)
                    .asJson()
                    .body(StringBody(QueryBuilder.getQuery(
                            Schema.GET_PROFILE
                    )))
    );

    public static ChainBuilder getDrop = exec(
            http("QUERY get drop")
                    .post(queryUrl)
                    .asJson()
                    .body(StringBody(QueryBuilder.getQuery(
                            Schema.GET_DROP
                    )))
                    .check(status().is(200))
                    .check(jsonPath("$..bankCards.[*].id").findAll().saveAs(SessionConstants.BANK_CARDS.getConstant()))
    );

//    public static ChainBuilder getBankCard = doIfEqualsOrElse(session -> {
//        List<String> cardsIds = session.getList(SessionConstants.BANK_CARDS.getConstant());
//        if (!cardsIds.isEmpty()) {
//            session.set(SessionConstants.BANK_CARD_ID.getConstant(), cardsIds.get(faker.random().nextInt(0, cardsIds.size() - 1)));
//        }
//        return cardsIds.size();
//    }, 0)
//            .then(
//                    exitHere()
//            ).orElse(
//                    http("QUERY get bank card")
//                            .post(queryUrl)
//                            .asJson()
//                            .body(StringBody(QueryBuilder.getQuery(
//                                    Schema.GET_BANK_CARD,
//                                    new QueryVariables().withId(SessionConstants.BANK_CARD_ID.getElString())
//                            )))
//                            .check(status().is(200))
//            );

    public static ChainBuilder getBankCard = exec(
            http("QUERY get bank card")
                    .post(queryUrl)
                    .asJson()
                    .body(StringBody(QueryBuilder.getQuery(
                            Schema.GET_BANK_CARD,
                            new QueryVariables().withId(SessionConstants.BANK_CARD_ID.getElString())
                    )))
                    .check(status().is(200))
    );

    public static ChainBuilder getBankCardFlow = exec(
            session -> {
                System.out.println("------- GET BANK CARD -------");
                System.out.println("GET BANK WITH ID " + SessionConstants.BANK_CARD_ID.getElString());
                System.out.println(session);
                return session;
            }
    );

//    public static ChainBuilder getBankCardStatistics = doIfEqualsOrElse(session -> session.getList(SessionConstants.BANK_CARDS.getConstant()).size(), 0)
//            .then(
//                    exitHere()
//            ).orElse(
//                    http("QUERY get bank card statistics")
//                            .post(queryUrl)
//                            .asJson()
//                            .body(StringBody(QueryBuilder.getQuery(
//                                    Schema.GET_BANK_CARD_STATISTICS,
//                                    new QueryVariables()
//                                            .withId(SessionConstants.BANK_CARD_ID.getElString())
//                                            .withPeriod(SessionConstants.STATISTICS_PERIOD.getElString())
//                            )))
//                            .check(status().is(200))
//            );

    public static ChainBuilder getBankCardStatistics = exec(
            http("QUERY get bank card statistics")
                    .post(queryUrl)
                    .asJson()
                    .body(StringBody(QueryBuilder.getQuery(
                            Schema.GET_BANK_CARD_STATISTICS,
                            new QueryVariables()
                                    .withId(SessionConstants.BANK_CARD_ID.getElString())
                                    .withPeriod(SessionConstants.STATISTICS_PERIOD.getElString())
                    )))
                    .check(status().is(200))
    );

//    public static ChainBuilder getOrders = doWhile(session -> session.getBoolean("condition")).on(
//            exec(
//                    http("QUERY get orders")
//                            .post(queryUrl)
//                            .asJson()
//                            .body(StringBody(QueryBuilder.getQuery(
//                                    Schema.GET_ORDERS,
//                                    new QueryVariables()
//                                            .withInput(new Input())
//                                            .withLimit(20)
//                                            .withOffset(0)
//                            )))
//                            .check(status().is(200))
//                            .check()
//            ).pause(Duration.ofSeconds(10))
//    );

    public static ChainBuilder getOrders = exec(
            http("QUERY get orders")
                    .post(queryUrl)
                    .asJson()
                    .body(StringBody(QueryBuilder.getQuery(
                            Schema.GET_ORDERS,
                            new QueryVariables()
                                    .withInput(new Input())
                                    .withLimit(20)
                                    .withOffset(0)
                    )))
                    .check(status().is(200))
                    .check(jsonPath("$..items[*].id,__typename").findAll().saveAs(SessionConstants.ORDERS_DATA.getConstant()))
    );

    public static ChainBuilder getOrdersArchive = exec(
            http("QUERY get orders archive")
                    .post(queryUrl)
                    .asJson()
                    .body(StringBody(QueryBuilder.getQuery(
                            Schema.GET_ORDERS_ARCHIVE,
                            new QueryVariables()
                                    .withInput(new Input().withInput(SessionConstants.ORDER_TYPE.getElString()))
                                    .withLimit(20)
                                    .withOffset(0)
                                    .withSortDirection(SortDirection.DESC.getDirection())
                    )))
                    .check(status().is(200))
    );
}
