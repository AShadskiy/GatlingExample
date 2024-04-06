package toss.constants;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StatisticPeriod {
    TODAY("day"),
    WEEK("week"),
    MONTH("month"),
    ALL_TIME("all"),
    ;

    private final String period;
}
