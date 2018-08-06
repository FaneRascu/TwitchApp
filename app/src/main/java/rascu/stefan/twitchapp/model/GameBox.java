package rascu.stefan.twitchapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GameBox implements Serializable {

    @JsonProperty("large")
    private String large;

    @JsonProperty("medium")
    private String medium;

    @JsonProperty("small")
    private String small;

    @JsonProperty("template")
    private String template;

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    @Override
    public String toString() {
        return "GameBox{" +
                "large='" + large + '\'' +
                ", medium='" + medium + '\'' +
                ", small='" + small + '\'' +
                ", template='" + template + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GameBox gameBox = (GameBox) o;

        if (large != null ? !large.equals(gameBox.large) : gameBox.large != null) return false;
        if (medium != null ? !medium.equals(gameBox.medium) : gameBox.medium != null) return false;
        if (small != null ? !small.equals(gameBox.small) : gameBox.small != null) return false;
        return !(template != null ? !template.equals(gameBox.template) : gameBox.template != null);

    }

    @Override
    public int hashCode() {
        int result = large != null ? large.hashCode() : 0;
        result = 31 * result + (medium != null ? medium.hashCode() : 0);
        result = 31 * result + (small != null ? small.hashCode() : 0);
        result = 31 * result + (template != null ? template.hashCode() : 0);
        return result;
    }
}