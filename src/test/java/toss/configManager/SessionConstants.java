package toss.configManager;

public enum SessionConstants {
    JWT_TOKEN("jwtToken"),
    BANK_CARDS("bankCards"),
    BANK_CARD_ID("bankCardId"),
    STATISTICS_PERIOD("period"),
    ORDER_TYPE("orderType"),
    ORDER_ID("orderId"),
    ORDERS_DATA("ordersData"),
    ORDERS_LIST("ordersList"),
    BANK_FOR_DEPOSIT("bankForDeposit"),
    DEPOSIT_SIGNATURE("depositSignature"),
    PAYOUT_SIGNATURE("payoutSignature"),
    DEPOSIT_BODY("depositBody"),
    PAYOUT_BODY("payoutBody"),
    ;

    private final String constant;

    SessionConstants(String constant) {
        this.constant = constant;
    }

    public String getConstant() {
        return constant;
    }

    public String getElString() {
        return String.format("#{%s}", constant);
    }
}
