package rascu.stefan.twitchapp.model.streams;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TopStreams implements Serializable{

    @JsonProperty("image")
    private String image;

    @JsonProperty("priority")
    private int priority;

    @JsonProperty("scheduled")
    private boolean scheduled;

    @JsonProperty("sponsored")
    private boolean sponsored;

    @JsonProperty("stream")
    private Stream stream;

    @JsonProperty("text")
    private String text;

    @JsonProperty("title")
    private String title;

    int position;

    public String getImage() {
        return image;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isScheduled() {
        return scheduled;
    }

    public boolean isSponsored() {
        return sponsored;
    }

    public Stream getStream() {
        return stream;
    }

    public String getText() {
        return text;
    }

    public String getTitle() {
        return title;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setScheduled(boolean scheduled) {
        this.scheduled = scheduled;
    }

    public void setSponsored(boolean sponsored) {
        this.sponsored = sponsored;
    }

    public void setStream(Stream stream) {
        this.stream = stream;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
