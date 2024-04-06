package toss.helpers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Converter {

    public static Map<String, String> convertListInvoicesToMap(List<String> invoices) {
        Map<String, String> result = new HashMap<>();
        for (int i = 0; i < invoices.size(); i += 2) {
            result.put(invoices.get(i), invoices.get(i + 1));
        }

        return result;
    }

    public static Iterator<Map<String, Object>> testMethod(List<String> invoices) {
        Map<String, Object> result = new HashMap<>();

        return Stream.generate(() -> {
                    for (int i = 0; i < invoices.size(); i += 2) {
                        result.put(invoices.get(i), invoices.get(i + 1));
                    }
                    return result;
                }
        ).iterator();
    }
}
