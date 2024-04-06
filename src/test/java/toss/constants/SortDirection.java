package toss.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SortDirection {
    DESC("desc"),
    ;

    private final String direction;
}
