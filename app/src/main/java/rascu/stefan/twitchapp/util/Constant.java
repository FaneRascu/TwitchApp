package rascu.stefan.twitchapp.util;

public class Constant {

    public static final String BASE_URL = "https://api.twitch.tv/kraken/";

    public static final String ACCEPT_HEADER = "Accept: application/vnd.twitch.v5+json";

    public static final String PATH_GAMES = "games/top";

    public static final String PATH_STREAMS = "streams/featured";

    public static final String PATH_COMMUNITIES = "communities?name=DallasTesterCommunity";

    public static final String Client_ID = "Client-ID: xkpx1ff2owe311sufdja5wcfdiu243";

    public static final String LIMIT_PARAMETER = "limit";

    public static final String OFFSET_PARAMETER = "offset";

    public static final String DEFAULT_LIMIT = "50";

    public static final int DEFAULT_OFFSET = 50;

    public static final String POSITION = "Position: %d";

    public static final String GAME_INFORMATION = "GAME_INFORMATION";

    public static final String CHANNELS = "Number of active channels: %d";

    public static final String FOLLOWERS = "Number of active followers: %d";

    public static final String GAME_NAME = "Currently playing: %s";

    public static final String VIEWERS = "Number of viewers: %d";

    public static final int GAME_BOX_MEDIUM_WIDTH = 160;

    public static final int GAME_BOX_MEDIUM_HEIGHT = 160;

    public static final int GAME_BOX_LARGE_WIDTH = 410;

    public static final int GAME_BOX_LARGE_HEIGHT = 410;

    public static final String LINE_FEED = "\n";

    public static final int MAX_AGE = 30; // will be used for reading from cache during 30 seconds

    public static final int MAX_STALE = 60; // will be used for reading from cache during 1 minute

    public static final int CACHE_SIZE = 4096; // 4MB of cache
}
