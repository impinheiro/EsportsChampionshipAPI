package fan.esports.championship.Esports.Championship.core.enums;

public enum ChampionshipFormat {
    SINGLE_ELIMINATION("SINGLE ELIMINATION", 0),
    DOUBLE_ELIMINATION("DOUBLE ELIMINATION", 1),
    ROUND_ROBIN("ROUND ROBIN", 2),
    GROUP_STAGE("GROUP STAGE", 3),
    SWISS_SYSTEM("SWISS SYSTEM", 4),
    GAUNTLET("GAUNTLET", 5),
    BEST_OF_SERIES("BEST OF SERIES", 6),
    BATTLE_ROYALE("BATTLE ROYALE", 7),
    LADDER_TOURNAMENT("LADDER TOURNAMENT", 8),
    ROUND_ROBIN_INTO_SINGLE_ELIMINATION("ROUND ROBIN INTO SINGLE ELIMINATION", 9),
    LCQ("LCQ", 10),
    INVITATIONAL("INVITATIONAL", 11),
    SHOWMATCH("SHOWMATCH", 12),
    OPEN_QUALIFIERS("OPEN QUALIFIERS", 13),;

    private final String formatName;
    private final int formatCode;


    ChampionshipFormat(String formatName, int formatCode) {
        this.formatName = formatName;
        this.formatCode = formatCode;
    }

    public String getFormatName() {
        return formatName;
    }

    public int getFormatCode() {
        return formatCode;
    }
}
