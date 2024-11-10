package com.jagex.client;

import com.jagex.client.env.ModeGame;
import com.jagex.client.env.ModeWhat;
import com.jagex.client.env.ModeWhere;
import org.openrs2.deob.annotation.OriginalMember;

public final class ClientSettings {
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

    @OriginalMember(owner = "client!pk", name = "o", descriptor = "Z")
    public static boolean hasAdvert = false;

    @OriginalMember(owner = "client!tt", name = "v", descriptor = "Lclient!jk;")
    public static ModeGame modeGame = null;

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
}
