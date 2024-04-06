package toss.helpers;

import io.gatling.javaapi.core.Session;
import toss.configManager.SessionConstants;

import java.util.ArrayList;
import java.util.List;

public class SessionHelper {

    public static Session saveOrderWithType(Session session) {
        Session newSession = session;
        List<String> ordersData = newSession.getList(SessionConstants.ORDERS_DATA.getConstant());
        for (int i = 0; i < ordersData.size(); i += 2) {
            newSession = newSession.set(ordersData.get(i), ordersData.get(i + 1));
        }
        return newSession;
    }

    public static Session saveOrderWithTypeFlow(Session session) {
        Session newSession = session;
        System.out.println("------- SAVE ORDER WITH TYPE -------");
        List<String> ordersData = newSession.getList(SessionConstants.ORDERS_DATA.getConstant());
        for (int i = 0; i < ordersData.size(); i += 2) {
            newSession = newSession.set(ordersData.get(i), ordersData.get(i + 1));
        }
        return newSession;
    }

    public static Session saveOrdersList(Session session) {
        Session newSession = session;
        List<String> ordersData = newSession.getList(SessionConstants.ORDERS_DATA.getConstant());
        List<String> ordersList = new ArrayList<>();
        for (int i = 0; i < ordersData.size(); i += 2) {
            ordersList.add(ordersData.get(i));
        }
        return newSession.set(SessionConstants.ORDERS_LIST.getConstant(), ordersList);
    }

    public static Session saveOrdersListFlow(Session session) {
        Session newSession = session;
        System.out.println("------- SAVE ORDER LIST -------");
        List<String> ordersData = newSession.getList(SessionConstants.ORDERS_DATA.getConstant());
        List<String> ordersList = new ArrayList<>();
        for (int i = 0; i < ordersData.size(); i += 2) {
            ordersList.add(ordersData.get(i));
        }
        newSession = newSession.set(SessionConstants.ORDERS_LIST.getConstant(), ordersList);
        return newSession;
    }
}
