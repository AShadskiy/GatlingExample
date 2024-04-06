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
public class QueryBody {

    private String query;
    private Object variables;
}
