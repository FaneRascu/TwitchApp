package rascu.stefan.twitchapp.model.games;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GamesListContent {

    @JsonProperty("_total")
    private int total;

    @JsonProperty("top")
    private List<TopGame> top;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<TopGame> getTop() {
        return top;
    }

    public void setTop(List<TopGame> top) {
        this.top = top;
    }
}