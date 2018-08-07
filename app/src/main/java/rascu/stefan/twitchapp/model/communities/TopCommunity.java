package rascu.stefan.twitchapp.model.communities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TopCommunity implements Serializable {

    @JsonProperty("avtar_image_url")
    private String avatarImageURL;

    @JsonProperty("channels")
    private long channels;

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("viewers")
    private long viewers;

    private int position;

    public String getAvatarImageURL() {
        return avatarImageURL;
    }

    public long getChannels() {
        return channels;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getViewers() {
        return viewers;
    }

    public void setAvatarImageURL(String avatarImageURL) {
        this.avatarImageURL = avatarImageURL;
    }

    public void setChannels(long channels) {
        this.channels = channels;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setViewers(long viewers) {
        this.viewers = viewers;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "TopCommunity{" +
                "avatarImageURL='" + avatarImageURL + '\'' +
                ", channels=" + channels +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", viewers=" + viewers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TopCommunity)) return false;
        TopCommunity topCommunity = (TopCommunity) o;
        return Objects.equals(getId(), topCommunity.getId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }
}
