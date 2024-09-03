package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class ClientSettings {
    @OriginalMember(owner = "client!je", name = "H", descriptor = "Lclient!jc;")
    public static final ModeWhat MODEWHAT_LIVE = new ModeWhat("LIVE", 0);

    @OriginalMember(owner = "client!rl", name = "d", descriptor = "Lclient!jc;")
    public static final ModeWhat MODEWHAT_RC = new ModeWhat("RC", 1);

    @OriginalMember(owner = "client!de", name = "c", descriptor = "Lclient!jc;")
    public static final ModeWhat MODEWHAT_WIP = new ModeWhat("WIP", 2);

    @OriginalMember(owner = "client!st", name = "f", descriptor = "Lclient!sp;")
    public static final ModeWhere MODEWHERE_LIVE = new ModeWhere("LIVE", 0);

    @OriginalMember(owner = "client!client", name = "fb", descriptor = "Lclient!sp;")
    public static final ModeWhere MODEWHERE_WTRC = new ModeWhere("WTRC", 1);

    @OriginalMember(owner = "client!ku", name = "m", descriptor = "Lclient!sp;")
    public static final ModeWhere MODEWHERE_WTQA = new ModeWhere("WTQA", 2);

    @OriginalMember(owner = "client!vf", name = "q", descriptor = "Lclient!sp;")
    public static final ModeWhere MODEWHERE_WTWIP = new ModeWhere("WTWIP", 3);

    @OriginalMember(owner = "client!lp", name = "l", descriptor = "Lclient!sp;")
    public static final ModeWhere MODEWHERE_WTI = new ModeWhere("WTI", 5);

    @OriginalMember(owner = "client!oj", name = "m", descriptor = "Lclient!sp;")
    public static final ModeWhere MODEWHERE_LOCAL = new ModeWhere("LOCAL", 4);

    @OriginalMember(owner = "client!jt", name = "D", descriptor = "Lclient!jk;")
    public static final GameDetails RUNESCAPE_GAME_DETAILS = new GameDetails("runescape", 0);

    @OriginalMember(owner = "client!pv", name = "p", descriptor = "Lclient!jk;")
    public static final GameDetails STELLAR_DAWN_GAME_DETAILS = new GameDetails("stellardawn", 1);

    @OriginalMember(owner = "client!fg", name = "e", descriptor = "I")
    public static int worldID = 1;

    @OriginalMember(owner = "client!fd", name = "Rd", descriptor = "Lclient!sp;")
    public static ModeWhere modewhere;

    @OriginalMember(owner = "client!ws", name = "a", descriptor = "Lclient!jc;")
    public static ModeWhat modewhat;

    @OriginalMember(owner = "client!j", name = "o", descriptor = "I")
    public static int langID = 0;

    @OriginalMember(owner = "client!tl", name = "q", descriptor = "Z")
    public static boolean hasJS = false;

    @OriginalMember(owner = "client!ie", name = "e", descriptor = "Z")
    public static boolean hasObjectTag = false;

    @OriginalMember(owner = "client!tt", name = "v", descriptor = "Lclient!jk;")
    public static GameDetails currentGameDetails = null;

    @OriginalMember(owner = "client!t", name = "d", descriptor = "Z")
    public static boolean aBoolean573 = false;

    @OriginalMember(owner = "client!mk", name = "l", descriptor = "Z")
    public static boolean aBoolean423 = false;

    @OriginalMember(owner = "client!bn", name = "G", descriptor = "Ljava/lang/String;")
    public static String settings = null;

    @OriginalMember(owner = "client!ll", name = "b", descriptor = "I")
    public static int countryID;

    @OriginalMember(owner = "client!im", name = "G", descriptor = "I")
    public static int affiliateID = 0;

    @OriginalMember(owner = "client!rk", name = "E", descriptor = "I")
    public static int colourID = 0;

    @OriginalMember(owner = "client!ii", name = "p", descriptor = "Ljava/lang/String;")
    public static String quitURL;

    @OriginalMember(owner = "client!ru", name = "i", descriptor = "I")
    public static int width = 765;

    @OriginalMember(owner = "client!hu", name = "n", descriptor = "I")
    public static int height = 503;

    @OriginalMember(owner = "client!an", name = "d", descriptor = "(I)[Lclient!sp;")
    public static ModeWhere[] getValidModeWhereValues() {
        return new ModeWhere[] {
                MODEWHERE_LIVE,
                MODEWHERE_WTRC,
                MODEWHERE_WTQA,
                MODEWHERE_WTWIP,
                MODEWHERE_LOCAL,
                MODEWHERE_WTI
        };
    }

    @OriginalMember(owner = "client!pu", name = "a", descriptor = "(IZ)Lclient!sp;")
    public static ModeWhere resolveModeWhereFromID(@OriginalArg(0) int id) {
        for (ModeWhere modeWhere : getValidModeWhereValues()) {
            if (id == modeWhere.getID()) {
                return modeWhere;
            }
        }

        return null;
    }

    @OriginalMember(owner = "client!nm", name = "b", descriptor = "(B)[Lclient!jc;")
    public static ModeWhat[] getValidModeWhatValues() {
        return new ModeWhat[] {
                MODEWHAT_LIVE,
                MODEWHAT_RC,
                MODEWHAT_WIP
        };
    }
}
