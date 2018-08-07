package rascu.stefan.twitchapp.model.streams;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StreamsListContent {

    @JsonProperty("featured")
    private List<TopStreams> featured;

    public List<TopStreams> getFeatured() {
        return featured;
    }

    public void setFeatured(List<TopStreams> featured) {
        this.featured = featured;
    }
}
