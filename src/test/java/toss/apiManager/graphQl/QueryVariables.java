package toss.apiManager.graphQl;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.With;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@With
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QueryVariables {

    private String id;
    private String period;
    private Object input;
    private int limit;
    private int offset;
    private String sortDirection;
}
