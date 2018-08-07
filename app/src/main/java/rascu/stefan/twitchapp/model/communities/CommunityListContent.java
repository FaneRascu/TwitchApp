package rascu.stefan.twitchapp.model.communities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommunityListContent {

    @JsonProperty("_cursor")
    private String cursor;

    @JsonProperty("_total")
    private String total;

    @JsonProperty("communities")
    private List<TopCommunity> communities;

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<TopCommunity> getCommunities() {
        return communities;
    }

    public void setCommunities(List<TopCommunity> communities) {
        this.communities = communities;
    }


}
