package toss.constants;


public enum Schema {
    DEPOSIT_ORDER_CONFIRM(".graphql"),
    DROP_ACTIVATE(".graphql"),
    DROP_DEACTIVATE(".graphql"),
    GET_BANK_CARD(".graphql"),
    GET_BANK_CARD_STATISTICS(".graphql"),
    GET_DROP(".graphql"),
    GET_ORDERS(".graphql"),
    GET_ORDERS_ARCHIVE(".graphql"),
    GET_PROFILE(".graphql"),
    PAYOUT_ORDER_CONFIRM(".graphql"),
    ;

    private String queryPath = "src/test/resources/graphQlSchema/";

    private String schema;

    Schema(String schema) {
        this.schema = schema;
    }

    public String getSchema() {
        return queryPath + schema;
    }
}
