package rascu.stefan.twitchapp.model.streams;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Channel implements Serializable{

    @JsonProperty("_id")
    private long id;

    @JsonProperty("broadcaster_language")
    private String broadcaster_language;

    @JsonProperty("created_at")
    private String created_at;

    @JsonProperty("display_name")
    private String display_name;

    @JsonProperty("followers")
    private long followers;

    @JsonProperty("game")
    private String game;

    @JsonProperty("language")
    private String language;

    @JsonProperty("logo")
    private String logo;

    @JsonProperty("mature")
    private String mature;

    @JsonProperty("name")
    private String name;

    @JsonProperty("partner")
    private boolean partner;

    @JsonProperty("profile_banner")
    private String profile_banner;

    @JsonProperty("profile_banner_background_color")
    private String profile_banner_background_color;

    @JsonProperty("status")
    private String status;

    @JsonProperty("updated_at")
    private String updated_at;

    @JsonProperty("url")
    private String url;

    @JsonProperty("video_banner")
    private String video_banner;

    @JsonProperty("views")
    private long views;

    public long getId() {
        return id;
    }

    public String getBroadcaster_language() {
        return broadcaster_language;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public long getFollowers() {
        return followers;
    }

    public String getGame() {
        return game;
    }

    public String getLanguage() {
        return language;
    }

    public String isLogo() {
        return logo;
    }

    public String getMature() {
        return mature;
    }

    public String getName() {
        return name;
    }

    public boolean isPartner() {
        return partner;
    }

    public String getProfile_banner() {
        return profile_banner;
    }

    public String getProfile_banner_background_color() {
        return profile_banner_background_color;
    }

    public String getStatus() {
        return status;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public String getUrl() {
        return url;
    }

    public String getVideo_banner() {
        return video_banner;
    }

    public long getViews() {
        return views;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setBroadcaster_language(String broadcaster_language) {
        this.broadcaster_language = broadcaster_language;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public void setFollowers(long followers) {
        this.followers = followers;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public void setMature(String mature) {
        this.mature = mature;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPartner(boolean partner) {
        this.partner = partner;
    }

    public void setProfile_banner(String profile_banner) {
        this.profile_banner = profile_banner;
    }

    public void setProfile_banner_background_color(String profile_banner_background_color) {
        this.profile_banner_background_color = profile_banner_background_color;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setVideo_banner(String video_banner) {
        this.video_banner = video_banner;
    }

    public void setViews(long views) {
        this.views = views;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "id=" + id +
                ", broadcaster_language='" + broadcaster_language + '\'' +
                ", created_at='" + created_at + '\'' +
                ", display_name='" + display_name + '\'' +
                ", followers=" + followers +
                ", game='" + game + '\'' +
                ", language='" + language + '\'' +
                ", logo=" + logo +
                ", mature='" + mature + '\'' +
                ", name='" + name + '\'' +
                ", partner=" + partner +
                ", profile_banner='" + profile_banner + '\'' +
                ", profile_banner_background_color='" + profile_banner_background_color + '\'' +
                ", status='" + status + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", url='" + url + '\'' +
                ", video_banner='" + video_banner + '\'' +
                ", views=" + views +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Channel  channel = (Channel) o;

        return id == channel.id;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
