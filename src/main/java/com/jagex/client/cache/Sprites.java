package com.jagex.client.cache;

import com.jagex.client.js5.Js5;

public class Sprites {
  public static int p11FullId;

  public static int p12FullId;

  public static int b12FullId;

  public static int hitmarksId;

  public static int hitbarDefaultId;

  public static int timerbarDefaultId;

  public static int headiconsPkId;

  public static int headiconsPrayerId;

  public static int hintHeadiconsId;

  public static int hintMapmarkersId;

  public static int mapflagId;

  public static int crossId;

  public static int mapdotsId;

  public static int scrollbarId;

  public static int nameIconsId;

  public static int floorshadowsId;

  public static int compassId;

  public static int otherlevelId;

  public static int hintMapedgeId;

  public static void initializeSpriteIds(Js5 archive) {
    p11FullId = archive.getGroupId("p11_full");
    p12FullId = archive.getGroupId("p12_full");
    b12FullId = archive.getGroupId("b12_full");
    hitmarksId = archive.getGroupId("hitmarks");
    hitbarDefaultId = archive.getGroupId("hitbar_default");
    timerbarDefaultId = archive.getGroupId("timerbar_default");
    headiconsPkId = archive.getGroupId("headicons_pk");
    headiconsPrayerId = archive.getGroupId("headicons_prayer");
    hintHeadiconsId = archive.getGroupId("hint_headicons");
    hintMapmarkersId = archive.getGroupId("hint_mapmarkers");
    mapflagId = archive.getGroupId("mapflag");
    crossId = archive.getGroupId("cross");
    mapdotsId = archive.getGroupId("mapdots");
    scrollbarId = archive.getGroupId("scrollbar");
    nameIconsId = archive.getGroupId("name_icons");
    floorshadowsId = archive.getGroupId("floorshadows");
    compassId = archive.getGroupId("compass");
    otherlevelId = archive.getGroupId("otherlevel");
    hintMapedgeId = archive.getGroupId("hint_mapedge");
  }
}
