package rascu.stefan.twitchapp.model.streams;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Stream implements Serializable{

    @JsonProperty("_id")
    private long id;

    @JsonProperty("average_fps")
    private long average_fps;

    @JsonProperty("channel")
    private Channel channel;

    @JsonProperty("created_at")
    private String created_at;

    @JsonProperty("delay")
    private long delay;

    @JsonProperty("game")
    private String game;

    @JsonProperty("is_playlist")
    private boolean is_playlist;

    @JsonProperty("preview")
    private StreamPreview streamPreview;

    @JsonProperty("video_height")
    private long video_height;

    @JsonProperty("viewers")
    private long viewers;

    public long getId() {
        return id;
    }

    public long getAverage_fps() {
        return average_fps;
    }

    public Channel getChannel() {
        return channel;
    }

    public String getCreated_at() {
        return created_at;
    }

    public long getDelay() {
        return delay;
    }

    public String getGame() {
        return game;
    }

    public boolean isIs_playlist() {
        return is_playlist;
    }

    public StreamPreview getStreamPreview() {
        return streamPreview;
    }

    public long getVideo_height() {
        return video_height;
    }

    public long getViewers() {
        return viewers;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAverage_fps(long average_fps) {
        this.average_fps = average_fps;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setDelay(long delay) {
        this.delay = delay;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public void setIs_playlist(boolean is_playlist) {
        this.is_playlist = is_playlist;
    }

    public void setStreamPreview(StreamPreview streamPreview) {
        this.streamPreview = streamPreview;
    }

    public void setVideo_height(long video_height) {
        this.video_height = video_height;
    }

    public void setViewers(long viewers) {
        this.viewers = viewers;
    }

    @Override
    public String toString() {
        return "Stream{" +
                "id=" + id +
                ", average_fps=" + average_fps +
                ", channel=" + channel +
                ", created_at='" + created_at + '\'' +
                ", delay=" + delay +
                ", game='" + game + '\'' +
                ", is_playlist=" + is_playlist +
                ", streamPreview=" + streamPreview +
                ", video_height=" + video_height +
                ", viewers=" + viewers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stream stream = (Stream) o;

        return id == stream.id;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
