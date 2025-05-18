package fan.esports.championship.Esports.Championship.core.enums;

public enum Games {
    LEAGUE_OF_LEGENDS("LEAGUE OF LEGENDS", 0),
    COUNTER_STRIKE("COUNTER STRIKE", 1),
    VALORANT("VALORANT", 2),
    DOTA("DOTA", 3),
    OVERWATCH("OVERWATCH", 4),
    MARVEL_RIVALS("MARVEL RIVALS", 5);


    private final String gameName;
    private final int code;

    Games(String gameName, int code) {
        this.gameName = gameName;
        this.code = code;
    }

    public String getGameName() {
        return gameName;
    }

    public int getCode() {
        return code;
    }
}
