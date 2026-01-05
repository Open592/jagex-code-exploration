package com.jagex.client;

import com.jagex.client.cache.Fonts;
import com.jagex.client.cache.Sprites;
import com.jagex.client.crypto.RSA;
import com.jagex.client.display.FullScreenWindow;
import com.jagex.client.encoding.Base37;
import com.jagex.client.env.ModeGame;
import com.jagex.client.env.ModeWhat;
import com.jagex.client.env.ModeWhere;
import com.jagex.client.js5.Cache;
import com.jagex.client.js5.Js5;
import com.jagex.client.js5.Js5DiskCache;
import com.jagex.client.js5.Js5MasterIndexProvider;
import com.jagex.client.js5.Js5NetQueue;
import com.jagex.client.locale.Messages;
import com.jagex.client.preferences.ClientPreferences;
import com.jagex.client.preferences.PreferencesImpl;
import com.jagex.client.utilities.ThreadingUtilities;
import com.jagex.signlink.Message;
import com.jagex.signlink.MonotonicClock;
import com.jagex.signlink.SignLink;
import jagex3.jagmisc.jagmisc;
import java.awt.Container;
import java.awt.Frame;
import java.awt.Insets;
import java.awt.Rectangle;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Optional;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!client")
public final class client extends GameShell {

  @OriginalMember(owner = "client!mp", name = "ab", descriptor = "[I")
  public static final int[] ARCHIVE_FILE_SIZE_WEIGHTS =
      new int[] {
        4, // 	4%
        4, // 	8%
        1, // 	9%
        2, // 	11%
        6, // 	17%
        4, // 	21%
        2, // 	23%
        47, // 	70%
        2, // 	72%
        2, // 	74%
        2, // 	76%
        2, // 	78%
        2, // 	80%
        2, // 	82%
        2, // 	84%
        2, // 	86%
        1, // 	87%
        1, // 	88%
        1, // 	89%
        1, // 	90%
        1, // 	91%
        1, // 	92%
        1, // 	93%
        1, // 	94%
        1, // 	95%
        1, // 	96%
        1, // 	97%
        1, // 	98%
        1, // 	99%
        1 // 	100%
      };

  @OriginalMember(owner = "client!md", name = "e", descriptor = "Lclient!al;")
  public static ServerConnection serverConnection;

  @OriginalMember(owner = "client!dt", name = "c", descriptor = "I")
  public static int js5ConnectionStage = 0;

  @OriginalMember(owner = "client!nf", name = "V", descriptor = "Lclient!vn;")
  public static Js5NetQueue js5NetQueue;

  @OriginalMember(owner = "client!tl", name = "w", descriptor = "Lclient!vl;")
  public static Js5DiskCache aJs5DiskCache_3;

  @OriginalMember(owner = "client!pu", name = "k", descriptor = "I")
  public static int previousJS5ConnectionAttepts = 0;

  @OriginalMember(owner = "client!bi", name = "B", descriptor = "Lclient!qt;")
  public static Message connectionInitializationMessage;

  @OriginalMember(owner = "client!a", name = "g", descriptor = "I")
  public static int anInt5 = 0;

  @OriginalMember(owner = "client!qj", name = "m", descriptor = "J")
  public static long connectionInitializationTimestamp;

  @OriginalMember(owner = "client!pr", name = "g", descriptor = "I")
  public static int primaryServerPort;

  @OriginalMember(owner = "client!er", name = "C", descriptor = "I")
  public static int fallbackServerPort;

  @OriginalMember(owner = "client!ts", name = "q", descriptor = "I")
  public static int connectionRetrySkipIterations = 0;

  @OriginalMember(owner = "client!un", name = "w", descriptor = "I")
  public static int port;

  @OriginalMember(owner = "client!qc", name = "c", descriptor = "Ljava/lang/String;")
  public static String host;

  @OriginalMember(owner = "client!qk", name = "c", descriptor = "J")
  public static long lastGarbageCollectionRequestTimestamp = 0L;

  @OriginalMember(owner = "client!av", name = "S", descriptor = "J")
  public static long firstLoadClientAssetsTimestamp = 0L;

  @OriginalMember(owner = "client!ba", name = "C", descriptor = "I")
  public static int gameLogicStepCount = 0;

  @OriginalMember(owner = "client!eo", name = "n", descriptor = "Lclient!nj;")
  public static Js5MasterIndexProvider masterIndexProvider;

  @OriginalMember(owner = "client!client", name = "main", descriptor = "([Ljava/lang/String;)V")
  public static void main(@OriginalArg(0) String[] arguments) {
    try {
      if (arguments.length != 4) {
        handleInvalidCommandArguments("argument count");
      }

      ClientSettings.worldID = Integer.parseInt(arguments[0]);
      ClientSettings.modewhere = ModeWhere.LOCAL;

      Optional<ModeWhat> modeWhatFromArguments = ModeWhat.fromName(arguments[1]);

      if (modeWhatFromArguments.isPresent()) {
        ClientSettings.modewhat = modeWhatFromArguments.get();
      } else {
        handleInvalidCommandArguments("modewhat");
      }

      ClientSettings.langID = Static73.method1357(arguments[2]);

      if (ClientSettings.langID == -1) {
        if (arguments[2].equals("english")) {
          ClientSettings.langID = 0;
        } else if (arguments[2].equals("german")) {
          ClientSettings.langID = 1;
        } else {
          handleInvalidCommandArguments("language");
        }
      }

      ClientSettings.hasJS = false;
      ClientSettings.hasObjectTag = false;

      Optional<ModeGame> gameWhatFromArguments = ModeGame.fromGameId(arguments[3]);

      if (gameWhatFromArguments.isPresent()) {
        ClientSettings.modeGame = gameWhatFromArguments.get();
      } else {
        handleInvalidCommandArguments("game");
      }

      ClientSettings.aBoolean573 = true;
      ClientSettings.aBoolean423 = true;
      ClientSettings.settings = "";
      ClientSettings.countryID = 0;
      ClientSettings.affiliateID = 0;
      ClientSettings.colourID = ClientSettings.modeGame.getId();

      @Pc(130)
      client local130 = new client();
      Static6.client = local130;
      local130.method885(ClientSettings.modeGame.getName(), ClientSettings.modewhat.getId() + 32);
      GameShell.frame.setLocation(40, 40);
    } catch (
        @Pc(153)
        Exception local153) {
      Static94.handleClientError(local153, null);
    }
  }

  @OriginalMember(owner = "client!pn", name = "a", descriptor = "(Ljava/lang/String;B)V")
  public static void handleInvalidCommandArguments(@OriginalArg(0) String error) {
    System.out.println(
        "Bad " + error + ", Usage: worldid, <live/rc/wip>, <english/german>, <game0/game1>");

    System.exit(1);
  }

  @OriginalMember(owner = "client!cc", name = "a", descriptor = "(Z)V")
  public static void method3938() {
    if (GameShell.fullScreenFrame != null) {
      return;
    }

    @Pc(13)
    Container container;
    if (GameShell.frame == null) {
      container = GameShell.signLink.hostApplet;
    } else {
      container = GameShell.frame;
    }
    Static425.anInt7000 = container.getSize().width;
    Static17.anInt222 = container.getSize().height;
    @Pc(31)
    Insets local31;
    if (GameShell.frame == container) {
      local31 = GameShell.frame.getInsets();
      Static425.anInt7000 -= local31.left + local31.right;
      Static17.anInt222 -= local31.bottom + local31.top;
    }
    if (Static450.method5664() == 1) {
      Static302.height = ClientSettings.height;
      Static141.width = ClientSettings.width;
      Static230.xPOS = (Static425.anInt7000 - ClientSettings.width) / 2;
      Static303.yPOS = 0;
    } else if (Static70.anInt1503 < 96 && Static177.anInt2973 == 0) {
      @Pc(100)
      int local100 = Static425.anInt7000 > 1024 ? 1024 : Static425.anInt7000;
      Static141.width = local100;
      @Pc(109)
      int local109 = Static17.anInt222 <= 768 ? Static17.anInt222 : 768;
      Static230.xPOS = (Static425.anInt7000 - local100) / 2;
      Static302.height = local109;
      Static303.yPOS = 0;
    } else {
      Static302.height = Static17.anInt222;
      Static141.width = Static425.anInt7000;
      Static303.yPOS = 0;
      Static230.xPOS = 0;
    }
    if (!ClientSettings.modewhere.isLive()) {
      @Pc(132)
      boolean local132;
      if (Static141.width < 1024 && Static302.height < 768) {
        local132 = true;
      } else {
        local132 = false;
      }
    }
    GameShell.canvas.setSize(Static141.width, Static302.height);
    if (Static122.aClass19_16 != null) {
      Static122.aClass19_16.method4272(GameShell.canvas);
    }
    if (container == GameShell.frame) {
      local31 = GameShell.frame.getInsets();
      GameShell.canvas.setLocation(Static230.xPOS + local31.left, local31.top - -Static303.yPOS);
    } else {
      GameShell.canvas.setLocation(Static230.xPOS, Static303.yPOS);
    }
    if (Static334.anInt5766 != -1) {
      Static327.method4422(true);
    }
    Static348.method4697();
  }

  @OriginalMember(owner = "client!oi", name = "a", descriptor = "(I)V")
  public static void method3510() {
    if (Static405.anInt6682 == 0) {
      return;
    }
    try {
      if (++anInt970 > 1500) {
        if (Static125.aServerConnection_5 != null) {
          Static125.aServerConnection_5.shutdown();
          Static125.aServerConnection_5 = null;
        }
        if (Static239.anInt4518 >= 1) {
          Static296.anInt5302 = -5;
          Static405.anInt6682 = 0;
          return;
        }
        if (Static313.anInt5435 == Static133.JS5Port) {
          Static313.anInt5435 = Static11.HTTPPort;
        } else {
          Static313.anInt5435 = Static133.JS5Port;
        }
        Static239.anInt4518++;
        anInt970 = 0;
        Static405.anInt6682 = 1;
      }
      if (Static405.anInt6682 == 1) {
        Static36.aClass199_3 =
            GameShell.signLink.emitConnectionInitializationMessage(
                Static13.host, Static313.anInt5435);
        Static405.anInt6682 = 2;
      }
      @Pc(118)
      int local118;
      if (Static405.anInt6682 == 2) {
        if (Static36.aClass199_3.status == 2) {
          throw new IOException();
        }
        if (Static36.aClass199_3.status != 1) {
          return;
        }
        Static125.aServerConnection_5 =
            new ServerConnection((Socket) Static36.aClass199_3.output, GameShell.signLink);
        Static36.aClass199_3 = null;
        Static125.aServerConnection_5.write(
            Static3.aClass4_Sub12_Sub1_5.pos, Static3.aClass4_Sub12_Sub1_5.data);
        Static329.method4427();
        local118 = Static125.aServerConnection_5.readByteFromServer();
        Static329.method4427();
        if (local118 != 101) {
          Static296.anInt5302 = local118;
          Static405.anInt6682 = 0;
          Static125.aServerConnection_5.shutdown();
          Static125.aServerConnection_5 = null;
          return;
        }
        Static405.anInt6682 = 3;
      }
      if (Static405.anInt6682 == 3
          && Static125.aServerConnection_5.getEstimatedBytesAvailable() >= 2) {
        local118 =
            Static125.aServerConnection_5.readByteFromServer() << 8
                | Static125.aServerConnection_5.readByteFromServer();
        Static162.method5279(local118);
        if (WorldManager.worldId == -1) {
          Static405.anInt6682 = 0;
          Static296.anInt5302 = 6;
          Static125.aServerConnection_5.shutdown();
          Static125.aServerConnection_5 = null;
        } else {
          Static405.anInt6682 = 0;
          Static125.aServerConnection_5.shutdown();
          Static125.aServerConnection_5 = null;
          Static445.method5617();
        }
      }
    } catch (
        @Pc(188)
        IOException local188) {
      if (Static125.aServerConnection_5 != null) {
        Static125.aServerConnection_5.shutdown();
        Static125.aServerConnection_5 = null;
      }
      if (Static239.anInt4518 >= 1) {
        Static405.anInt6682 = 0;
        Static296.anInt5302 = -4;
      } else {
        Static405.anInt6682 = 1;
        anInt970 = 0;
        Static239.anInt4518++;
        if (Static133.JS5Port == Static313.anInt5435) {
          Static313.anInt5435 = Static11.HTTPPort;
        } else {
          Static313.anInt5435 = Static133.JS5Port;
        }
      }
    }
  }

  @OriginalMember(owner = "client!wa", name = "a", descriptor = "(I)V")
  public static void method4042() {
    if (Static188.anInt5353 > 1) {
      Static308.anInt5413 = Static325.anInt5640;
      Static188.anInt5353--;
    }

    if (Static95.anInt1910 > 0) {
      Static95.anInt1910--;
    }

    if (Static22.aBoolean38) {
      Static22.aBoolean38 = false;
      Static165.method2731();

      return;
    }

    if (!Static234.aBoolean411) {
      Static314.method4198();
    }

    for (@Pc(38) int local38 = 0; local38 < 100 && Protocol.readPacket(); local38++) {}

    if (Static403.anInt6667 != 30) {
      return;
    }

    Static321.method4336(Static251.aClass215_54.method4926(), Static3.aClass4_Sub12_Sub1_5);

    if (Static178.aClass4_Sub42_2 == null) {
      if (Static419.aLong212 <= MonotonicClock.getCurrentTimeInMilliseconds()) {
        Static178.aClass4_Sub42_2 = Static402.aClass256_1.method5479(host);
      }
    } else if (Static178.aClass4_Sub42_2.anInt6883 != -1) {
      Static429.method5476(Static27.aClass215_7);
      Static3.aClass4_Sub12_Sub1_5.p2(Static178.aClass4_Sub42_2.anInt6883);
      Static178.aClass4_Sub42_2 = null;
      Static419.aLong212 = MonotonicClock.getCurrentTimeInMilliseconds() + 30000L;
    }

    @Pc(99)
    Node_Sub5 local99 = (Node_Sub5) Static413.A_LINKED_LIST___47.tail();
    @Pc(119)
    int local119;
    @Pc(140)
    int local140;
    @Pc(159)
    int local159;
    @Pc(175)
    boolean local175;
    @Pc(227)
    int local227;
    @Pc(234)
    int local234;
    @Pc(246)
    int local246;

    if (local99 != null
        || MonotonicClock.getCurrentTimeInMilliseconds() - 2000L > Static292.aLong177) {
      @Pc(116)
      boolean local116 = false;
      local119 = Static3.aClass4_Sub12_Sub1_5.pos;

      for (@Pc(124) Node_Sub5 local124 = (Node_Sub5) Static348.A_LINKED_LIST___42.tail();
          local124 != null && Static3.aClass4_Sub12_Sub1_5.pos - local119 < 240;
          local124 = (Node_Sub5) Static348.A_LINKED_LIST___42.previous()) {
        local124.popSelf();
        local140 = local124.method519();
        if (local140 < 0) {
          local140 = 0;
        } else if (local140 > 65534) {
          local140 = 65534;
        }
        local159 = local124.method518();
        if (local159 < 0) {
          local159 = 0;
        } else if (local159 > 65534) {
          local159 = 65534;
        }
        local175 = false;
        if (local124.method519() == -1 && local124.method518() == -1) {
          local140 = -1;
          local175 = true;
          local159 = -1;
        }
        if (local159 != Static452.anInt7358 || local140 != Static410.anInt6734) {
          if (!local116) {
            Static429.method5476(Static266.aClass215_62);
            Static3.aClass4_Sub12_Sub1_5.p1(0);
            local116 = true;
            local119 = Static3.aClass4_Sub12_Sub1_5.pos;
          }
          local227 = local159 - Static452.anInt7358;
          Static452.anInt7358 = local159;
          local234 = local140 - Static410.anInt6734;
          Static410.anInt6734 = local140;
          local246 = (int) ((local124.method516() - Static292.aLong177) / 20L);
          if (local246 < 8
              && local227 >= -32
              && local227 <= 31
              && local234 >= -32
              && local234 <= 31) {
            local234 += 32;
            local227 += 32;
            Static3.aClass4_Sub12_Sub1_5.p2(local234 + (local246 << 12) + (local227 << 6));
          } else if (local246 < 32
              && local227 >= -128
              && local227 <= 127
              && local234 >= -128
              && local234 <= 127) {
            Static3.aClass4_Sub12_Sub1_5.p1(local246 + 128);
            local227 += 128;
            local234 += 128;
            Static3.aClass4_Sub12_Sub1_5.p2(local234 + (local227 << 8));
          } else if (local246 >= 32) {
            Static3.aClass4_Sub12_Sub1_5.p2(local246 + 57344);
            if (local175) {
              Static3.aClass4_Sub12_Sub1_5.p4(Integer.MIN_VALUE);
            } else {
              Static3.aClass4_Sub12_Sub1_5.p4(local140 << 16 | local159);
            }
          } else {
            Static3.aClass4_Sub12_Sub1_5.p1(local246 + 192);
            if (local175) {
              Static3.aClass4_Sub12_Sub1_5.p4(Integer.MIN_VALUE);
            } else {
              Static3.aClass4_Sub12_Sub1_5.p4(local140 << 16 | local159);
            }
          }
          Static292.aLong177 = local124.method516();
        }
      }
      if (local116) {
        Static3.aClass4_Sub12_Sub1_5.pSize1(Static3.aClass4_Sub12_Sub1_5.pos - local119);
      }
    }
    @Pc(416)
    int local416;
    @Pc(463)
    int local463;
    if (local99 != null) {
      @Pc(402)
      long local402 = (local99.method516() - Static259.aLong160) / 50L;
      if (local402 > 32767L) {
        local402 = 32767L;
      }
      Static259.aLong160 = local99.method516();
      local416 = local99.method519();
      if (local416 < 0) {
        local416 = 0;
      } else if (local416 > 65535) {
        local416 = 65535;
      }
      local140 = local99.method518();
      if (local140 < 0) {
        local140 = 0;
      } else if (local140 > 65535) {
        local140 = 65535;
      }
      @Pc(447)
      byte local447 = 0;
      if (local99.method515() == 2) {
        local447 = 1;
      }
      local463 = (int) local402;
      Static429.method5476(Static226.aClass215_47);
      Static3.aClass4_Sub12_Sub1_5.p4(local416 << 16 | local140);
      Static3.aClass4_Sub12_Sub1_5.p2_alt2(local463 | local447 << 15);
    }
    @Pc(489)
    int local489;
    if (Static190.anInt3602 > 0) {
      local489 = 0;
      for (local119 = 0; local119 < Static190.anInt3602; local119++) {
        if (Static164.aClass30Array4[local119].method741()) {
          local489++;
        }
      }
      if (local489 > 0) {
        Static429.method5476(Static224.aClass215_44);
        if (local489 > 75) {
          local489 = 75;
        }
        Static3.aClass4_Sub12_Sub1_5.p1(local489 * 3);
        for (local416 = 0; local416 < Static190.anInt3602; local416++) {
          @Pc(537)
          Class30 local537 = Static164.aClass30Array4[local416];
          if (local537.method741()) {
            @Pc(550)
            long local550 = (local537.method742() - Static256.aLong156) / 50L;
            Static256.aLong156 = local537.method742();
            if (local550 > 65535L) {
              local550 = 65535L;
            }
            Static3.aClass4_Sub12_Sub1_5.p1(local537.method746());
            Static3.aClass4_Sub12_Sub1_5.p2((int) local550);
          }
        }
      }
    }
    if (Static324.anInt5626 > 0) {
      Static324.anInt5626--;
    }
    if (Static251.aBoolean429 && Static324.anInt5626 <= 0) {
      Static251.aBoolean429 = false;
      Static324.anInt5626 = 20;
      Static429.method5476(Static253.aClass215_57);
      Static3.aClass4_Sub12_Sub1_5.p2_alt2((int) Static368.aFloat192 >> 3);
      Static3.aClass4_Sub12_Sub1_5.p2_alt3((int) Static164.aFloat142 >> 3);
    }
    if (Static265.aBoolean457 && !Static41.aBoolean74) {
      Static41.aBoolean74 = true;
      Static429.method5476(Static44.aClass215_9);
      Static3.aClass4_Sub12_Sub1_5.p1(1);
    }
    if (!Static265.aBoolean457 && Static41.aBoolean74) {
      Static41.aBoolean74 = false;
      Static429.method5476(Static44.aClass215_9);
      Static3.aClass4_Sub12_Sub1_5.p1(0);
    }
    if (!Static249.aBoolean425) {
      Static429.method5476(Static197.aClass215_39);
      Static3.aClass4_Sub12_Sub1_5.p1(0);
      local489 = Static3.aClass4_Sub12_Sub1_5.pos;
      @Pc(692)
      Packet local692 = ClientPreferences.preferences.encodePreferences();
      Static3.aClass4_Sub12_Sub1_5.pArrayBuffer(local692.data, local692.pos);
      Static3.aClass4_Sub12_Sub1_5.pSize1(Static3.aClass4_Sub12_Sub1_5.pos - local489);
      Static249.aBoolean425 = true;
    }
    if (Static202.aClass164ArrayArrayArray5 != null) {
      if (Static111.anInt2386 == 2) {
        Static329.method4430();
      } else if (Static111.anInt2386 == 3) {
        Static294.method514();
      }
    }
    if (Static308.aBoolean487) {
      Static308.aBoolean487 = false;
    } else {
      Static380.aFloat195 /= 2.0F;
    }
    if (Static32.aBoolean63) {
      Static32.aBoolean63 = false;
    } else {
      Static50.aFloat28 /= 2.0F;
    }
    Static255.method3687();
    if (Static403.anInt6667 != 30) {
      return;
    }
    Static248.method3623();
    Static80.method1433();
    Static412.method5294();
    Static177.method2527();
    Static410.anInt6735++;
    if (Static410.anInt6735 > 750) {
      Static165.method2731();
      return;
    }
    Static229.method3458();
    method884();
    Static108.method2009();
    for (local489 = Static257.aClass114_1.method2832(true);
        local489 != -1;
        local489 = Static257.aClass114_1.method2832(false)) {
      Static277.method3934(local489);
      Static8.anIntArray7[Static292.anInt5255++ & 0x1F] = local489;
    }
    @Pc(840)
    Class247 local840;
    for (@Pc(815) SecondaryNode_Sub1_Sub11 local815 = Static92.method1614();
        local815 != null;
        local815 = Static92.method1614()) {
      local416 = local815.method2606();
      local140 = local815.method2609();
      if (local416 == 1) {
        Static165.anIntArray210[local140] = local815.anInt3083;
        Static135.aBoolean256 |= Static22.aBooleanArray3[local140];
        Static143.anIntArray184[Static314.anInt5473++ & 0x1F] = local140;
      } else if (local416 == 2) {
        Static265.aStringArray20[local140] = local815.aString32;
        Static277.anIntArray337[Static218.anInt4042++ & 0x1F] = local140;
      } else if (local416 == 3) {
        local840 = Static392.method5121(local140);
        if (!local815.aString32.equals(local840.aString67)) {
          local840.aString67 = local815.aString32;
          Static63.method1142(local840);
        }
      } else if (local416 == 4) {
        local840 = Static392.method5121(local140);
        local463 = local815.anInt3083;
        local227 = local815.anInt3082;
        local234 = local815.anInt3079;
        if (local463 != local840.anInt6796
            || local840.anInt6781 != local227
            || local234 != local840.anInt6848) {
          local840.anInt6781 = local227;
          local840.anInt6848 = local234;
          local840.anInt6796 = local463;
          Static63.method1142(local840);
        }
      } else if (local416 == 5) {
        local840 = Static392.method5121(local140);
        if (local815.anInt3083 != local840.anInt6788 || local815.anInt3083 == -1) {
          local840.anInt6815 = 0;
          local840.anInt6829 = 0;
          local840.anInt6783 = 1;
          local840.anInt6788 = local815.anInt3083;
          Static63.method1142(local840);
        }
      } else if (local416 == 6) {
        local159 = local815.anInt3083;
        local463 = local159 >> 10 & 0x1F;
        local227 = local159 >> 5 & 0x1F;
        local234 = local159 & 0x1F;
        local246 = (local234 << 3) + (local227 << 11) + (local463 << 19);
        @Pc(937)
        Class247 local937 = Static392.method5121(local140);
        if (local937.anInt6772 != local246) {
          local937.anInt6772 = local246;
          Static63.method1142(local937);
        }
      } else if (local416 == 7) {
        local840 = Static392.method5121(local140);
        local175 = local815.anInt3083 == 1;
        if (local175 != local840.aBoolean616) {
          local840.aBoolean616 = local175;
          Static63.method1142(local840);
        }
      } else if (local416 == 8) {
        local840 = Static392.method5121(local140);
        if (local840.anInt6844 != local815.anInt3083
            || local840.anInt6858 != local815.anInt3082
            || local815.anInt3079 != local840.anInt6857) {
          local840.anInt6857 = local815.anInt3079;
          local840.anInt6858 = local815.anInt3082;
          local840.anInt6844 = local815.anInt3083;
          if (local840.anInt6779 != -1) {
            if (local840.anInt6822 > 0) {
              local840.anInt6857 = local840.anInt6857 * 32 / local840.anInt6822;
            } else if (local840.anInt6816 > 0) {
              local840.anInt6857 = local840.anInt6857 * 32 / local840.anInt6816;
            }
          }
          Static63.method1142(local840);
        }
      } else if (local416 == 9) {
        local840 = Static392.method5121(local140);
        if (local840.anInt6779 != local815.anInt3083 || local840.anInt6832 != local815.anInt3082) {
          local840.anInt6832 = local815.anInt3082;
          local840.anInt6779 = local815.anInt3083;
          Static63.method1142(local840);
        }
      } else if (local416 == 10) {
        local840 = Static392.method5121(local140);
        if (local840.anInt6814 != local815.anInt3083
            || local840.anInt6826 != local815.anInt3082
            || local840.anInt6843 != local815.anInt3079) {
          local840.anInt6814 = local815.anInt3083;
          local840.anInt6826 = local815.anInt3082;
          local840.anInt6843 = local815.anInt3079;
          Static63.method1142(local840);
        }
      } else if (local416 == 11) {
        local840 = Static392.method5121(local140);
        local840.aByte79 = 0;
        local840.anInt6836 = local840.anInt6804 = local815.anInt3083;
        local840.aByte81 = 0;
        local840.anInt6859 = local840.anInt6808 = local815.anInt3082;
        Static63.method1142(local840);
      } else if (local416 == 12) {
        local840 = Static392.method5121(local140);
        local463 = local815.anInt3083;
        if (local840 != null && local840.anInt6840 == 0) {
          if (local463 > local840.anInt6834 - local840.anInt6805) {
            local463 = local840.anInt6834 - local840.anInt6805;
          }
          if (local463 < 0) {
            local463 = 0;
          }
          if (local840.anInt6849 != local463) {
            local840.anInt6849 = local463;
            Static63.method1142(local840);
          }
        }
      } else if (local416 == 14) {
        local840 = Static392.method5121(local140);
        local840.lb = local815.anInt3083;
      } else if (local416 == 15) {
        Static60.anInt1094 = local815.anInt3082;
        Static350.aBoolean556 = true;
        Static343.anInt771 = local815.anInt3083;
      } else if (local416 == 16) {
        local840 = Static392.method5121(local140);
        local840.anInt6791 = local815.anInt3083;
      }
    }
    Static176.anInt3414++;
    if (Static85.anInt1764 != 0) {
      Static216.anInt4014 += 20;
      if (Static216.anInt4014 >= 400) {
        Static85.anInt1764 = 0;
      }
    }
    if (Static378.aClass247_8 != null) {
      Static91.anInt1087++;
      if (Static91.anInt1087 >= 15) {
        Static63.method1142(Static378.aClass247_8);
        Static378.aClass247_8 = null;
      }
    }
    Static81.aClass247_2 = null;
    Static232.aClass247_9 = null;
    Static361.aBoolean570 = false;
    Static390.aBoolean584 = false;
    Static361.method4870(-1, null, -1);
    Static40.method697(null, -1, -1);
    if (!Static341.aBoolean599) {
      Static157.anInt3147 = -1;
    }
    Static164.method3582();
    Static325.anInt5640++;
    if (Static219.aBoolean588) {
      Static429.method5476(Static372.aClass215_84);
      Static3.aClass4_Sub12_Sub1_5.p4_alt2(
          Static445.anInt7274 | Static263.anInt4958 << 14 | Static155.anInt3644 << 28);
      Static219.aBoolean588 = false;
    }
    while (true) {
      @Pc(1462)
      Node_Sub34 local1462;
      @Pc(1467)
      Class247 local1467;
      do {
        local1462 = (Node_Sub34) Static237.A_LINKED_LIST___52.pollLast();
        if (local1462 == null) {
          while (true) {
            do {
              local1462 = (Node_Sub34) Static39.A_LINKED_LIST___3.pollLast();
              if (local1462 == null) {
                while (true) {
                  do {
                    local1462 = (Node_Sub34) Static291.A_LINKED_LIST___35.pollLast();
                    if (local1462 == null) {
                      if (Static81.aClass247_2 == null) {
                        Static64.anInt1367 = 0;
                      }
                      if (Static281.aClass247_12 != null) {
                        Static1.method3();
                      }
                      if (Static104.anInt2252 > 0
                          && Static384.aClass244_1.method5489(82)
                          && Static384.aClass244_1.method5489(81)
                          && Static430.anInt3862 != 0) {
                        local416 = Static1.aClass16_Sub1_Sub5_Sub1_1.aByte82 - Static430.anInt3862;
                        if (local416 < 0) {
                          local416 = 0;
                        } else if (local416 > 3) {
                          local416 = 3;
                        }
                        Static200.method3168(
                            local416,
                            Static86.anInt1771 + Static1.aClass16_Sub1_Sub5_Sub1_1.anIntArray427[0],
                            Static1.aClass16_Sub1_Sub5_Sub1_1.anIntArray426[0]
                                + Static180.anInt3453);
                      }
                      Static41.method730();
                      for (local416 = 0; local416 < 5; local416++) {
                        @Pc(1675)
                        int local1675 = Static390.anIntArray486[local416]++;
                      }
                      if (Static135.aBoolean256
                          && Static174.aLong119
                              < MonotonicClock.getCurrentTimeInMilliseconds() - 60000L) {
                        Static316.method4216();
                      }
                      Static200.anInt3873++;
                      if (Static200.anInt3873 > 500) {
                        Static200.anInt3873 = 0;
                        local140 = (int) (Math.random() * 8.0D);
                        if ((local140 & 0x1) == 1) {
                          Static217.anInt4024 += Static105.anInt2326;
                        }
                        if ((local140 & 0x4) == 4) {
                          Static273.anInt5119 += Static268.anInt5006;
                        }
                        if ((local140 & 0x2) == 2) {
                          Static323.anInt5620 += Static195.anInt3714;
                        }
                      }
                      if (Static217.anInt4024 < -50) {
                        Static105.anInt2326 = 2;
                      }
                      if (Static323.anInt5620 < -55) {
                        Static195.anInt3714 = 2;
                      }
                      if (Static217.anInt4024 > 50) {
                        Static105.anInt2326 = -2;
                      }
                      if (Static323.anInt5620 > 55) {
                        Static195.anInt3714 = -2;
                      }
                      if (Static273.anInt5119 < -40) {
                        Static268.anInt5006 = 1;
                      }
                      Static74.anInt1528++;
                      if (Static273.anInt5119 > 40) {
                        Static268.anInt5006 = -1;
                      }
                      if (Static74.anInt1528 > 500) {
                        Static74.anInt1528 = 0;
                        local140 = (int) (Math.random() * 8.0D);
                        if ((local140 & 0x2) == 2) {
                          Static110.anInt2374 += Static110.anInt2369;
                        }
                        if ((local140 & 0x1) == 1) {
                          Static175.anInt3399 += Static400.anInt6628;
                        }
                      }
                      if (Static175.anInt3399 < -60) {
                        Static400.anInt6628 = 2;
                      }
                      if (Static175.anInt3399 > 60) {
                        Static400.anInt6628 = -2;
                      }
                      if (Static110.anInt2374 < -20) {
                        Static110.anInt2369 = 1;
                      }
                      if (Static110.anInt2374 > 10) {
                        Static110.anInt2369 = -1;
                      }
                      Static162.anInt6744++;
                      if (Static162.anInt6744 > 50) {
                        Static429.method5476(Static14.aClass215_2);
                      }
                      if (Static83.aBoolean159) {
                        Static374.method4996();
                        Static83.aBoolean159 = false;
                      }
                      try {
                        if (Static125.aServerConnection_5 != null
                            && Static3.aClass4_Sub12_Sub1_5.pos > 0) {
                          Static60.anInt1097 += Static3.aClass4_Sub12_Sub1_5.pos;
                          Static125.aServerConnection_5.write(
                              Static3.aClass4_Sub12_Sub1_5.pos, Static3.aClass4_Sub12_Sub1_5.data);
                          Static3.aClass4_Sub12_Sub1_5.pos = 0;
                          Static162.anInt6744 = 0;
                          return;
                        }
                        return;
                      } catch (
                          @Pc(1884)
                          IOException local1884) {
                        Static165.method2731();
                        return;
                      }
                    }
                    local1467 = local1462.aClass247_15;
                    if (local1467.anInt6865 < 0) {
                      break;
                    }
                    local840 = Static392.method5121(local1467.anInt6850);
                  } while (local840 == null
                      || local840.aClass247Array2 == null
                      || local1467.anInt6865 >= local840.aClass247Array2.length
                      || local1467 != local840.aClass247Array2[local1467.anInt6865]);
                  Static271.method3894(local1462);
                }
              }
              local1467 = local1462.aClass247_15;
              if (local1467.anInt6865 < 0) {
                break;
              }
              local840 = Static392.method5121(local1467.anInt6850);
            } while (local840 == null
                || local840.aClass247Array2 == null
                || local1467.anInt6865 >= local840.aClass247Array2.length
                || local840.aClass247Array2[local1467.anInt6865] != local1467);
            Static271.method3894(local1462);
          }
        }
        local1467 = local1462.aClass247_15;
        if (local1467.anInt6865 < 0) {
          break;
        }
        local840 = Static392.method5121(local1467.anInt6850);
      } while (local840 == null
          || local840.aClass247Array2 == null
          || local840.aClass247Array2.length <= local1467.anInt6865
          || local1467 != local840.aClass247Array2[local1467.anInt6865]);
      Static271.method3894(local1462);
    }
  }

  @OriginalMember(owner = "client!vk", name = "f", descriptor = "(I)V")
  public static void method5430() {
    if (Static238.anInt4506 == 0 || Static238.anInt4506 == 5) {
      return;
    }
    try {
      if (++Static64.anInt1366 > 2000) {
        if (Static125.aServerConnection_5 != null) {
          Static125.aServerConnection_5.shutdown();
          Static125.aServerConnection_5 = null;
        }
        if (Static212.anInt3932 >= 1) {
          Static238.anInt4506 = 0;
          Static296.anInt5302 = -5;
          return;
        }
        Static238.anInt4506 = 1;
        Static212.anInt3932++;
        if (primaryServerPort == port) {
          port = fallbackServerPort;
        } else {
          port = primaryServerPort;
        }
        Static64.anInt1366 = 0;
      }
      if (Static238.anInt4506 == 1) {
        Static36.aClass199_3 = GameShell.signLink.emitConnectionInitializationMessage(host, port);
        Static238.anInt4506 = 2;
      }
      @Pc(112)
      int local112;
      if (Static238.anInt4506 == 2) {
        if (Static36.aClass199_3.status == 2) {
          throw new IOException();
        }
        if (Static36.aClass199_3.status != 1) {
          return;
        }
        Static125.aServerConnection_5 =
            new ServerConnection((Socket) Static36.aClass199_3.output, GameShell.signLink);
        Static36.aClass199_3 = null;
        @Pc(102)
        long local102 = Static286.aLong174 = Base37.encode(LoginManager.username);
        Static3.aClass4_Sub12_Sub1_5.pos = 0;
        local112 = (int) (local102 >> 16 & 0x1FL);
        Static3.aClass4_Sub12_Sub1_5.p1(Class60.aClass60_1.anInt1812);
        Static3.aClass4_Sub12_Sub1_5.p1(local112);
        Static125.aServerConnection_5.write(2, Static3.aClass4_Sub12_Sub1_5.data);
        Static329.method4427();
        @Pc(134)
        int local134 = Static125.aServerConnection_5.readByteFromServer();
        Static329.method4427();
        if (local134 != 0) {
          Static238.anInt4506 = 0;
          Static296.anInt5302 = local134;
          Static125.aServerConnection_5.shutdown();
          Static125.aServerConnection_5 = null;
          return;
        }
        Static238.anInt4506 = 3;
      }
      if (Static238.anInt4506 == 3) {
        if (Static125.aServerConnection_5.getEstimatedBytesAvailable() < 8) {
          return;
        }
        Static125.aServerConnection_5.readBytesFromServer(
            0, 8, Static146.aClass4_Sub12_Sub1_3.data);
        Static146.aClass4_Sub12_Sub1_3.pos = 0;
        Static309.aLong183 = Static146.aClass4_Sub12_Sub1_3.g8();
        @Pc(185)
        Packet local185 = new Packet(70);
        @Pc(188)
        int[] local188 =
            new int[] {
              (int) (Math.random() * 9.9999999E7D),
              (int) (Math.random() * 9.9999999E7D),
              (int) (Static309.aLong183 >> 32),
              (int) Static309.aLong183
            };
        local185.p1(10);
        local185.p4(local188[0]);
        local185.p4(local188[1]);
        local185.p4(local188[2]);
        local185.p4(local188[3]);
        local185.p8(Base37.encode(LoginManager.username));
        local185.pjstr(LoginManager.password);
        local185.rsaEncrypt(RSA.EXPONENT, RSA.MODULUS);
        Static3.aClass4_Sub12_Sub1_5.pos = 0;
        if (Static403.anInt6667 == 40) {
          Static3.aClass4_Sub12_Sub1_5.p1(Class60.aClass60_5.anInt1812);
        } else {
          Static3.aClass4_Sub12_Sub1_5.p1(Class60.aClass60_3.anInt1812);
        }
        Static3.aClass4_Sub12_Sub1_5.p2(0);
        local112 = Static3.aClass4_Sub12_Sub1_5.pos;
        Static3.aClass4_Sub12_Sub1_5.p4(592);
        Static3.aClass4_Sub12_Sub1_5.p1(Static161.anInt3177);
        Static3.aClass4_Sub12_Sub1_5.p1(Static450.method5664());
        Static3.aClass4_Sub12_Sub1_5.p2(Static141.width);
        Static3.aClass4_Sub12_Sub1_5.p2(Static302.height);
        Static3.aClass4_Sub12_Sub1_5.p1(ClientPreferences.preferences.anInt3440);
        Static82.method1471(Static3.aClass4_Sub12_Sub1_5);
        Static3.aClass4_Sub12_Sub1_5.pjstr(ClientSettings.settings);
        Static3.aClass4_Sub12_Sub1_5.p4(ClientSettings.affiliateID);
        @Pc(323)
        Packet local323 = ClientPreferences.preferences.encodePreferences();
        Static3.aClass4_Sub12_Sub1_5.p1(local323.pos);
        Static3.aClass4_Sub12_Sub1_5.pArrayBuffer(local323.data, local323.pos);
        Static249.aBoolean425 = true;
        Static3.aClass4_Sub12_Sub1_5.p2(Static183.anInt3512);
        Static3.aClass4_Sub12_Sub1_5.p4(Static395.archive0.getChecksum());
        Static3.aClass4_Sub12_Sub1_5.p4(Static324.archive1.getChecksum());
        Static3.aClass4_Sub12_Sub1_5.p4(Static74.archive2.getChecksum());
        Static3.aClass4_Sub12_Sub1_5.p4(Static256.archive3.getChecksum());
        Static3.aClass4_Sub12_Sub1_5.p4(Static67.archive4.getChecksum());
        Static3.aClass4_Sub12_Sub1_5.p4(Static49.archive5.getChecksum());
        Static3.aClass4_Sub12_Sub1_5.p4(Static46.archive6.getChecksum());
        Static3.aClass4_Sub12_Sub1_5.p4(Static357.archive7.getChecksum());
        Static3.aClass4_Sub12_Sub1_5.p4(Static293.archive8.getChecksum());
        Static3.aClass4_Sub12_Sub1_5.p4(Static196.archive9.getChecksum());
        Static3.aClass4_Sub12_Sub1_5.p4(Static88.archive10.getChecksum());
        Static3.aClass4_Sub12_Sub1_5.p4(Static284.archive11.getChecksum());
        Static3.aClass4_Sub12_Sub1_5.p4(Static197.archive12.getChecksum());
        Static3.aClass4_Sub12_Sub1_5.p4(Static209.archive13.getChecksum());
        Static3.aClass4_Sub12_Sub1_5.p4(Static312.archive14.getChecksum());
        Static3.aClass4_Sub12_Sub1_5.p4(Static350.archive15.getChecksum());
        Static3.aClass4_Sub12_Sub1_5.p4(Static424.archive16.getChecksum());
        Static3.aClass4_Sub12_Sub1_5.p4(Static208.archive17.getChecksum());
        Static3.aClass4_Sub12_Sub1_5.p4(Static381.archive18.getChecksum());
        Static3.aClass4_Sub12_Sub1_5.p4(Static391.archive19.getChecksum());
        Static3.aClass4_Sub12_Sub1_5.p4(Static388.archive20.getChecksum());
        Static3.aClass4_Sub12_Sub1_5.p4(Static55.archive21.getChecksum());
        Static3.aClass4_Sub12_Sub1_5.p4(Static64.archive22.getChecksum());
        Static3.aClass4_Sub12_Sub1_5.p4(Static163.archive23.getChecksum());
        Static3.aClass4_Sub12_Sub1_5.p4(Static66.archive24.getChecksum());
        Static3.aClass4_Sub12_Sub1_5.p4(Static154.archive25.getChecksum());
        Static3.aClass4_Sub12_Sub1_5.p4(Static24.archive26.getChecksum());
        Static3.aClass4_Sub12_Sub1_5.p4(Static417.archive27.getChecksum());
        Static3.aClass4_Sub12_Sub1_5.p4(Static19.archive28.getChecksum());
        Static3.aClass4_Sub12_Sub1_5.p4(Static366.archive29.getChecksum());
        Static3.aClass4_Sub12_Sub1_5.pArrayBuffer(local185.data, local185.pos);
        Static3.aClass4_Sub12_Sub1_5.pSize2(Static3.aClass4_Sub12_Sub1_5.pos - local112);
        Static125.aServerConnection_5.write(
            Static3.aClass4_Sub12_Sub1_5.pos, Static3.aClass4_Sub12_Sub1_5.data);
        Static3.aClass4_Sub12_Sub1_5.initializeIsaacRandom(local188);
        for (@Pc(551) int local551 = 0; local551 < 4; local551++) {
          local188[local551] += 50;
        }
        Static146.aClass4_Sub12_Sub1_3.initializeIsaacRandom(local188);
        Static238.anInt4506 = 4;
      }
      if (Static238.anInt4506 == 4) {
        if (Static125.aServerConnection_5.getEstimatedBytesAvailable() < 1) {
          return;
        }
        @Pc(585)
        int local585 = Static125.aServerConnection_5.readByteFromServer();
        if (local585 == 21) {
          Static238.anInt4506 = 7;
        } else if (local585 == 29) {
          Static238.anInt4506 = 11;
        } else if (local585 == 1) {
          Static238.anInt4506 = 5;
          Static296.anInt5302 = local585;
          return;
        } else if (local585 == 2) {
          Static238.anInt4506 = 8;
        } else if (local585 == 15) {
          Static454.anInt4075 = -2;
          Static238.anInt4506 = 12;
        } else if (local585 == 23 && Static212.anInt3932 < 1) {
          Static64.anInt1366 = 0;
          Static238.anInt4506 = 1;
          Static212.anInt3932++;
          Static125.aServerConnection_5.shutdown();
          Static125.aServerConnection_5 = null;
          return;
        } else {
          Static238.anInt4506 = 0;
          Static296.anInt5302 = local585;
          Static125.aServerConnection_5.shutdown();
          Static125.aServerConnection_5 = null;
          return;
        }
      }
      if (Static238.anInt4506 == 6) {
        Static3.aClass4_Sub12_Sub1_5.pos = 0;
        Static3.aClass4_Sub12_Sub1_5.method1133(Class60.aClass60_4.anInt1812);
        Static125.aServerConnection_5.write(
            Static3.aClass4_Sub12_Sub1_5.pos, Static3.aClass4_Sub12_Sub1_5.data);
        Static238.anInt4506 = 4;
      } else if (Static238.anInt4506 == 7) {
        if (Static125.aServerConnection_5.getEstimatedBytesAvailable() >= 1) {
          Static175.anInt3398 = (Static125.aServerConnection_5.readByteFromServer() + 3) * 60;
          Static296.anInt5302 = 21;
          Static238.anInt4506 = 0;
          Static125.aServerConnection_5.shutdown();
          Static125.aServerConnection_5 = null;
        }
      } else if (Static238.anInt4506 != 11) {
        if (Static238.anInt4506 == 8) {
          if (Static125.aServerConnection_5.getEstimatedBytesAvailable() < 13) {
            return;
          }
          Static125.aServerConnection_5.readBytesFromServer(
              0, 13, Static146.aClass4_Sub12_Sub1_3.data);
          Static146.aClass4_Sub12_Sub1_3.pos = 0;
          Static104.anInt2252 = Static146.aClass4_Sub12_Sub1_3.g1();
          Static123.anInt6262 = Static146.aClass4_Sub12_Sub1_3.g1();
          Static109.aBoolean628 = Static146.aClass4_Sub12_Sub1_3.g1() == 1;
          Static396.aBoolean443 = Static146.aClass4_Sub12_Sub1_3.g1() == 1;
          Static436.aBoolean668 = Static146.aClass4_Sub12_Sub1_3.g1() == 1;
          Static308.aBoolean486 = Static146.aClass4_Sub12_Sub1_3.g1() == 1;
          Static207.anInt5452 = Static146.aClass4_Sub12_Sub1_3.g2();
          ClientSettings.aBoolean423 = Static146.aClass4_Sub12_Sub1_3.g1() == 1;
          Static325.aBoolean506 = Static146.aClass4_Sub12_Sub1_3.g1() == 1;
          Static267.aClass262_2.method5564(Static325.aBoolean506);
          Static444.aClass206_3.method4704(Static325.aBoolean506);
          Static329.aClass240_1.method5230(Static325.aBoolean506);
          if (Static109.aBoolean628 && !Static436.aBoolean668 || ClientSettings.aBoolean423) {
            try {
              Static458.callJavaScriptMethod(GameShell.signLink.hostApplet, "zap");
            } catch (
                @Pc(880)
                Throwable local880) {
              if (ClientSettings.hasAdvert) {
                try {
                  GameShell.signLink
                      .hostApplet
                      .getAppletContext()
                      .showDocument(
                          new URL(GameShell.signLink.hostApplet.getCodeBase(), "blank.ws"), "tbi");
                } catch (
                    @Pc(896)
                    Exception local896) {
                }
              }
            }
          } else {
            try {
              Static458.callJavaScriptMethod(GameShell.signLink.hostApplet, "unzap");
            } catch (
                @Pc(870)
                Throwable local870) {
            }
          }
          if (ClientSettings.modewhere.isLive()) {
            try {
              Static458.callJavaScriptMethod(GameShell.signLink.hostApplet, "loggedin");
            } catch (
                @Pc(908)
                Throwable local908) {
            }
          }
          Static238.anInt4506 = 10;
        }
        if (Static238.anInt4506 == 10) {
          if (Static146.aClass4_Sub12_Sub1_3.method1141()) {
            if (Static125.aServerConnection_5.getEstimatedBytesAvailable() < 1) {
              return;
            }
            Static125.aServerConnection_5.readBytesFromServer(
                Static146.aClass4_Sub12_Sub1_3.pos + 2, 1, Static146.aClass4_Sub12_Sub1_3.data);
          }
          Protocol.currentOpcode =
              Protocol.getOpcodes()[Static146.aClass4_Sub12_Sub1_3.readOpcode()];
          Static454.anInt4075 = Static146.aClass4_Sub12_Sub1_3.g2();
          Static238.anInt4506 = 9;
        }
        @Pc(970)
        int local970;
        if (Static238.anInt4506 == 9) {
          if (Static125.aServerConnection_5.getEstimatedBytesAvailable() >= Static454.anInt4075) {
            Static125.aServerConnection_5.readBytesFromServer(
                0, Static454.anInt4075, Static146.aClass4_Sub12_Sub1_3.data);
            Static146.aClass4_Sub12_Sub1_3.pos = 0;
            local970 = Static454.anInt4075;
            Static238.anInt4506 = 0;
            Static296.anInt5302 = 2;
            Static167.method2736();
            Static391.method5117(Static146.aClass4_Sub12_Sub1_3);
            Static169.anInt3265 = -1;
            Static230.method3470();
            if (local970 != Static146.aClass4_Sub12_Sub1_3.pos) {
              throw new RuntimeException(
                  "lswp pos:" + Static146.aClass4_Sub12_Sub1_3.pos + " psize:" + local970);
            }
            Protocol.currentOpcode = null;
          }
        } else if (Static238.anInt4506 == 12) {
          if (Static454.anInt4075 == -2) {
            if (Static125.aServerConnection_5.getEstimatedBytesAvailable() < 2) {
              return;
            }
            Static125.aServerConnection_5.readBytesFromServer(
                0, 2, Static146.aClass4_Sub12_Sub1_3.data);
            Static146.aClass4_Sub12_Sub1_3.pos = 0;
            Static454.anInt4075 = Static146.aClass4_Sub12_Sub1_3.g2();
          }
          if (Static125.aServerConnection_5.getEstimatedBytesAvailable() >= Static454.anInt4075) {
            Static125.aServerConnection_5.readBytesFromServer(
                0, Static454.anInt4075, Static146.aClass4_Sub12_Sub1_3.data);
            Static146.aClass4_Sub12_Sub1_3.pos = 0;
            local970 = Static454.anInt4075;
            Static238.anInt4506 = 0;
            Static296.anInt5302 = 15;
            Static297.method4069();
            Static391.method5117(Static146.aClass4_Sub12_Sub1_3);
            if (local970 != Static146.aClass4_Sub12_Sub1_3.pos) {
              throw new RuntimeException(
                  "lswpr pos:" + Static146.aClass4_Sub12_Sub1_3.pos + " psize:" + local970);
            }
            Protocol.currentOpcode = null;
          }
        }
      } else if (Static125.aServerConnection_5.getEstimatedBytesAvailable() >= 1) {
        Static299.anInt5328 = Static125.aServerConnection_5.readByteFromServer();
        Static238.anInt4506 = 0;
        Static296.anInt5302 = 29;
        Static125.aServerConnection_5.shutdown();
        Static125.aServerConnection_5 = null;
      }
    } catch (
        @Pc(1095)
        IOException local1095) {
      if (Static125.aServerConnection_5 != null) {
        Static125.aServerConnection_5.shutdown();
        Static125.aServerConnection_5 = null;
      }
      if (Static212.anInt3932 >= 1) {
        Static296.anInt5302 = -4;
        Static238.anInt4506 = 0;
      } else {
        if (primaryServerPort == port) {
          port = fallbackServerPort;
        } else {
          port = primaryServerPort;
        }
        Static238.anInt4506 = 1;
        Static212.anInt3932++;
        Static64.anInt1366 = 0;
      }
    }
  }

  @OriginalMember(owner = "client!kv", name = "e", descriptor = "(B)V")
  public static void method3275() {
    Static299.method4087(false);
    Static100.anInt2020 = 0;
    @Pc(12)
    boolean local12 = true;
    for (@Pc(14) int local14 = 0; local14 < Static386.aByteArrayArray15.length; local14++) {
      if (Static225.anIntArray291[local14] != -1 && Static386.aByteArrayArray15[local14] == null) {
        Static386.aByteArrayArray15[local14] =
            Static49.archive5.method2104(0, Static225.anIntArray291[local14]);
        if (Static386.aByteArrayArray15[local14] == null) {
          Static100.anInt2020++;
          local12 = false;
        }
      }
      if (Static346.anIntArray418[local14] != -1 && Static247.aByteArrayArray16[local14] == null) {
        Static247.aByteArrayArray16[local14] =
            Static49.archive5.method2121(
                Static346.anIntArray418[local14], 0, Static376.anIntArrayArray50[local14]);
        if (Static247.aByteArrayArray16[local14] == null) {
          Static100.anInt2020++;
          local12 = false;
        }
      }
      if (Static95.anIntArray155[local14] != -1 && Static435.aByteArrayArray30[local14] == null) {
        Static435.aByteArrayArray30[local14] =
            Static49.archive5.method2104(0, Static95.anIntArray155[local14]);
        if (Static435.aByteArrayArray30[local14] == null) {
          Static100.anInt2020++;
          local12 = false;
        }
      }
      if (Static189.anIntArray236[local14] != -1 && Static193.aByteArrayArray13[local14] == null) {
        Static193.aByteArrayArray13[local14] =
            Static49.archive5.method2104(0, Static189.anIntArray236[local14]);
        if (Static193.aByteArrayArray13[local14] == null) {
          Static100.anInt2020++;
          local12 = false;
        }
      }
      if (Static175.anIntArray222 != null
          && Static34.aByteArrayArray1[local14] == null
          && Static175.anIntArray222[local14] != -1) {
        Static34.aByteArrayArray1[local14] =
            Static49.archive5.method2121(
                Static175.anIntArray222[local14], 0, Static376.anIntArrayArray50[local14]);
        if (Static34.aByteArrayArray1[local14] == null) {
          Static100.anInt2020++;
          local12 = false;
        }
      }
    }
    if (Static292.aClass195_2 == null) {
      if (Static197.aClass4_Sub1_Sub5_2 == null
          || !Static163.archive23.method2107(
              Static197.aClass4_Sub1_Sub5_2.aString16 + "_staticelements")) {
        Static292.aClass195_2 = new Class195(0);
      } else if (Static163.archive23.method2103(
          Static197.aClass4_Sub1_Sub5_2.aString16 + "_staticelements")) {
        Static292.aClass195_2 =
            Static380.method5018(
                Static163.archive23,
                Static197.aClass4_Sub1_Sub5_2.aString16 + "_staticelements",
                Static325.aBoolean506);
      } else {
        local12 = false;
        Static100.anInt2020++;
      }
    }
    if (!local12) {
      Static51.anInt883 = 1;
      return;
    }
    local12 = true;
    Static275.anInt5144 = 0;
    @Pc(266)
    int local266;
    @Pc(276)
    int local276;
    for (@Pc(248) int local248 = 0; local248 < Static386.aByteArrayArray15.length; local248++) {
      @Pc(254)
      byte[] local254 = Static247.aByteArrayArray16[local248];
      if (local254 != null) {
        local266 = (Static308.anIntArray372[local248] >> 8) * 64 - Static180.anInt3453;
        local276 = (Static308.anIntArray372[local248] & 0xFF) * 64 - Static86.anInt1771;
        if (Static448.anInt7307 != 0) {
          local266 = 10;
          local276 = 10;
        }
        local12 &=
            Static361.method4871(
                Static326.anInt5666, local266, Static283.anInt5187, local254, local276);
      }
      local254 = Static193.aByteArrayArray13[local248];
      if (local254 != null) {
        local266 = (Static308.anIntArray372[local248] >> 8) * 64 - Static180.anInt3453;
        local276 = (Static308.anIntArray372[local248] & 0xFF) * 64 - Static86.anInt1771;
        if (Static448.anInt7307 != 0) {
          local266 = 10;
          local276 = 10;
        }
        local12 &=
            Static361.method4871(
                Static326.anInt5666, local266, Static283.anInt5187, local254, local276);
      }
    }
    if (!local12) {
      Static51.anInt883 = 2;
      return;
    }
    if (Static51.anInt883 != 0) {
      Static436.method5519(
          true,
          Static439.A_LOCALIZED_STRING___148.getString(ClientSettings.langID) + "<br>(100%)",
          Static207.aClass46_9);
    }
    Static159.method2701();
    Static409.method5485();
    @Pc(386)
    boolean local386 = false;
    if (Static122.aClass19_16.method4261() && ClientPreferences.preferences.aBoolean294) {
      for (local266 = 0; local266 < Static386.aByteArrayArray15.length; local266++) {
        if (Static193.aByteArrayArray13[local266] != null
            || Static435.aByteArrayArray30[local266] != null) {
          local386 = true;
          break;
        }
      }
    }
    if (ClientPreferences.preferences.aBoolean298) {
      local266 = Static149.anIntArray189[Static140.anInt2845];
    } else {
      local266 = Static164.anIntArray302[Static140.anInt2845];
    }
    if (Static122.aClass19_16.method4286()) {
      local266++;
    }
    Static253.method3677(
        Static326.anInt5666,
        Static283.anInt5187,
        local266,
        local386,
        Static122.aClass19_16.method4260() > 0);
    for (local276 = 0; local276 < 4; local276++) {
      Static175.aClass213Array1[local276].method4851();
    }
    Static241.method3555();
    Static388.method5094(false);
    Static265.method3816();
    Static10.aClass242_1 = null;
    Static159.method2701();
    System.gc();
    Static299.method4087(true);
    Static261.method3788();
    Static63.anInt1262 = ClientPreferences.preferences.method2850(Static177.anInt2973);
    Static41.aBoolean75 = Static70.anInt1503 >= 96;
    Static321.aBoolean498 = ClientPreferences.preferences.aBoolean294;
    Static242.aBoolean418 = ClientPreferences.preferences.method2854(Static177.anInt2973);
    Static147.aBoolean263 = !ClientPreferences.preferences.aBoolean293;
    Static259.anInt4877 =
        ClientPreferences.preferences.method2861(Static177.anInt2973) ? -1 : Static317.anInt5523;
    Static436.aBoolean667 = ClientPreferences.preferences.isTexturesEnabled;
    Static54.aBoolean93 = Static177.anInt2973 == 1 || ClientPreferences.preferences.aBoolean289;
    Static67.aClass266_Sub1_1 =
        new Class266_Sub1(4, Static326.anInt5666, Static283.anInt5187, false);
    if (Static448.anInt7307 == 0) {
      Static235.method3523(Static67.aClass266_Sub1_1, Static386.aByteArrayArray15);
    } else {
      Static259.method3757(Static67.aClass266_Sub1_1, Static386.aByteArrayArray15);
    }
    Static7.method4194(Static326.anInt5666 >> 4, Static283.anInt5187 >> 4);
    Static248.method3623();
    if (local386) {
      Static86.method1547(true);
      Static143.aClass266_Sub1_2 =
          new Class266_Sub1(1, Static326.anInt5666, Static283.anInt5187, true);
      if (Static448.anInt7307 == 0) {
        Static235.method3523(Static143.aClass266_Sub1_2, Static435.aByteArrayArray30);
        Static299.method4087(true);
      } else {
        Static259.method3757(Static143.aClass266_Sub1_2, Static435.aByteArrayArray30);
        Static299.method4087(true);
      }
      Static143.aClass266_Sub1_2.method5633(Static67.aClass266_Sub1_1.anIntArrayArrayArray15[0]);
      Static143.aClass266_Sub1_2.method5635(null, null, Static122.aClass19_16);
      Static86.method1547(false);
    }
    Static67.aClass266_Sub1_1.method5635(
        local386 ? Static143.aClass266_Sub1_2.anIntArrayArrayArray15 : null,
        Static175.aClass213Array1,
        Static122.aClass19_16);
    if (Static448.anInt7307 == 0) {
      Static299.method4087(true);
      Static344.method4655(Static67.aClass266_Sub1_1, Static247.aByteArrayArray16);
      if (Static34.aByteArrayArray1 != null) {
        Static194.method3044();
      }
    } else {
      Static299.method4087(true);
      Static390.method4993(Static67.aClass266_Sub1_1, Static247.aByteArrayArray16);
    }
    Static409.method5485();
    Static299.method4087(true);
    Static67.aClass266_Sub1_1.method5636(
        null, local386 ? Static285.aClass65Array3[0] : null, Static122.aClass19_16);
    Static67.aClass266_Sub1_1.method5651(Static122.aClass19_16);
    Static299.method4087(true);
    if (local386) {
      Static86.method1547(true);
      Static299.method4087(true);
      if (Static448.anInt7307 == 0) {
        Static344.method4655(Static143.aClass266_Sub1_2, Static193.aByteArrayArray13);
      } else {
        Static390.method4993(Static143.aClass266_Sub1_2, Static193.aByteArrayArray13);
      }
      Static409.method5485();
      Static299.method4087(true);
      Static143.aClass266_Sub1_2.method5636(
          Static67.aClass65Array1[0], null, Static122.aClass19_16);
      Static143.aClass266_Sub1_2.method5651(Static122.aClass19_16);
      Static299.method4087(true);
      Static86.method1547(false);
    }
    Static270.method3866();
    @Pc(729)
    int local729 = Static67.aClass266_Sub1_1.anInt7311;
    if (local729 > Static263.anInt4963) {
      local729 = Static263.anInt4963;
    }
    if (Static263.anInt4963 - 1 > local729) {
      local729 = Static263.anInt4963 - 1;
    }
    if (ClientPreferences.preferences.method2861(Static177.anInt2973)) {
      method882(0);
    } else {
      method882(local729);
    }
    @Pc(766)
    int local766;
    @Pc(770)
    int local770;
    for (@Pc(762) int local762 = 0; local762 < 4; local762++) {
      for (local766 = 0; local766 < Static326.anInt5666; local766++) {
        for (local770 = 0; local770 < Static283.anInt5187; local770++) {
          Static443.method5595(local762, local766, local770);
        }
      }
    }
    Static215.method3238();
    Static159.method2701();
    Static1.method1();
    Static409.method5485();
    Static199.aBoolean362 = false;
    Static317.method4231();
    if (GameShell.frame != null
        && Static125.aServerConnection_5 != null
        && Static403.anInt6667 == 25) {
      Static429.method5476(Static427.aClass215_94);
      Static3.aClass4_Sub12_Sub1_5.p4(1057001181);
    }
    if (Static448.anInt7307 == 0) {
      local766 = (Static169.anInt3265 - (Static326.anInt5666 >> 4)) / 8;
      local770 = (Static169.anInt3265 + (Static326.anInt5666 >> 4)) / 8;
      @Pc(856)
      int local856 = (Static453.anInt7373 - (Static283.anInt5187 >> 4)) / 8;
      @Pc(864)
      int local864 = (Static453.anInt7373 + (Static283.anInt5187 >> 4)) / 8;
      for (@Pc(868) int local868 = local766 - 1; local868 <= local770 + 1; local868++) {
        for (@Pc(874) int local874 = local856 - 1; local874 <= local864 + 1; local874++) {
          if (local766 > local868
              || local770 < local868
              || local874 < local856
              || local864 < local874) {
            Static49.archive5.method2126("m" + local868 + "_" + local874);
            Static49.archive5.method2126("l" + local868 + "_" + local874);
          }
        }
      }
    }
    if (Static403.anInt6667 == 28) {
      Static187.method2932(10);
    } else {
      Static187.method2932(30);
      if (Static125.aServerConnection_5 != null) {
        Static429.method5476(Static412.aClass215_90);
      }
    }
    Static126.method2262();
    Static159.method2701();
    GameShell.method3660();
  }

  @OriginalMember(owner = "client!tn", name = "a", descriptor = "(Z)V")
  public static void method5090() {
    if (Static354.anInt6183 == 0) {
      return;
    }
    try {
      if (++Static348.anInt5976 > 2000) {
        if (Static125.aServerConnection_5 != null) {
          Static125.aServerConnection_5.shutdown();
          Static125.aServerConnection_5 = null;
        }
        if (Static119.anInt2524 >= 1) {
          Static354.anInt6183 = 0;
          Static249.anInt4623 = -5;
          return;
        }
        Static354.anInt6183 = 1;
        Static348.anInt5976 = 0;
        if (primaryServerPort == port) {
          port = fallbackServerPort;
        } else {
          port = primaryServerPort;
        }
        Static119.anInt2524++;
      }
      if (Static354.anInt6183 == 1) {
        Static36.aClass199_3 = GameShell.signLink.emitConnectionInitializationMessage(host, port);
        Static354.anInt6183 = 2;
      }
      @Pc(120)
      int local120;
      if (Static354.anInt6183 == 2) {
        if (Static36.aClass199_3.status == 2) {
          throw new IOException();
        }
        if (Static36.aClass199_3.status != 1) {
          return;
        }
        Static125.aServerConnection_5 =
            new ServerConnection((Socket) Static36.aClass199_3.output, GameShell.signLink);
        Static36.aClass199_3 = null;
        Static125.aServerConnection_5.write(
            Static3.aClass4_Sub12_Sub1_5.pos, Static3.aClass4_Sub12_Sub1_5.data);
        Static329.method4427();
        local120 = Static125.aServerConnection_5.readByteFromServer();
        Static329.method4427();
        if (local120 != 21) {
          Static249.anInt4623 = local120;
          Static354.anInt6183 = 0;
          Static125.aServerConnection_5.shutdown();
          Static125.aServerConnection_5 = null;
          return;
        }
        Static354.anInt6183 = 3;
      }
      if (Static354.anInt6183 == 3) {
        if (Static125.aServerConnection_5.getEstimatedBytesAvailable() < 1) {
          return;
        }
        Static206.aStringArray16 = new String[Static125.aServerConnection_5.readByteFromServer()];
        Static354.anInt6183 = 4;
      }
      if (Static354.anInt6183 == 4
          && Static125.aServerConnection_5.getEstimatedBytesAvailable()
              >= Static206.aStringArray16.length * 8) {
        Static146.aClass4_Sub12_Sub1_3.pos = 0;
        Static125.aServerConnection_5.readBytesFromServer(
            0, Static206.aStringArray16.length * 8, Static146.aClass4_Sub12_Sub1_3.data);
        for (local120 = 0; local120 < Static206.aStringArray16.length; local120++) {
          Static206.aStringArray16[local120] =
              Base37.decodeLower(Static146.aClass4_Sub12_Sub1_3.g8());
        }
        Static249.anInt4623 = 21;
        Static354.anInt6183 = 0;
        Static125.aServerConnection_5.shutdown();
        Static125.aServerConnection_5 = null;
      }
    } catch (
        @Pc(214)
        IOException local214) {
      if (Static125.aServerConnection_5 != null) {
        Static125.aServerConnection_5.shutdown();
        Static125.aServerConnection_5 = null;
      }
      if (Static119.anInt2524 >= 1) {
        Static354.anInt6183 = 0;
        Static249.anInt4623 = -4;
      } else {
        Static354.anInt6183 = 1;
        if (port == primaryServerPort) {
          port = fallbackServerPort;
        } else {
          port = primaryServerPort;
        }
        Static119.anInt2524++;
        Static348.anInt5976 = 0;
      }
    }
  }

  @OriginalMember(owner = "client!nh", name = "f", descriptor = "(I)V")
  public static void method3806() {
    if (!areModeratorPrivilegesAvailable()) {
      return;
    }
    if (Static102.aStringArray8 == null) {
      Static19.method198();
    }
    Static69.aBoolean292 = true;
    Static259.anInt4882 = 0;
    try {
      Static348.aClipboard1 = Static6.client.getToolkit().getSystemClipboard();
    } catch (
        @Pc(16)
        Exception local16) {
    }
  }

  @OriginalMember(owner = "client!vi", name = "b", descriptor = "(Z)Z")
  public static boolean areModeratorPrivilegesAvailable() {
    return !ClientSettings.modewhere.isLive() || Static104.anInt2252 >= 2;
  }

  @OriginalMember(owner = "client!hp", name = "d", descriptor = "(I)J")
  public static long method2607() {
    return aFrameTimer_1.method2252();
  }

  @OriginalMember(owner = "client!nj", name = "a", descriptor = "(ZIZII)Lclient!fs;")
  public static Js5 loadArchive(boolean arg0, int archiveIndex, boolean arg2) {
    Cache local5 = null;

    if (Static88.cacheDataFile != null) {
      local5 =
          new Cache(
              archiveIndex,
              Static88.cacheDataFile,
              Static86.cacheIndexFiles[archiveIndex],
              1000000);
    }

    Static119.archiveDataResourceProviders[archiveIndex] =
        masterIndexProvider.getArchiveDataResourceProvider(
            Static225.aCache_2, local5, archiveIndex);

    if (arg2) {
      Static119.archiveDataResourceProviders[archiveIndex].method3526();
    }

    return new Js5(Static119.archiveDataResourceProviders[archiveIndex], arg0, 1);
  }

  @OriginalMember(owner = "client!client", name = "i", descriptor = "(I)V")
  private void js5connect() {
    if (js5NetQueue.connectionFailures > previousJS5ConnectionAttepts) {
      connectionRetrySkipIterations = (js5NetQueue.connectionFailures * 50 - 50) * 5;

      if (port == primaryServerPort) {
        port = fallbackServerPort;
      } else {
        port = primaryServerPort;
      }

      if (connectionRetrySkipIterations > 3000) {
        connectionRetrySkipIterations = 3000;
      }

      if (js5NetQueue.connectionFailures >= 2 && js5NetQueue.errorCode == 6) {
        this.handleGameError("js5connect_outofdate");

        Static403.anInt6667 = 1000;

        return;
      }

      if (js5NetQueue.connectionFailures >= 4 && js5NetQueue.errorCode == -1) {
        this.handleGameError("js5crc");

        Static403.anInt6667 = 1000;

        return;
      }

      if (js5NetQueue.connectionFailures >= 4
          && (Static403.anInt6667 == 0 || Static403.anInt6667 == 5)) {
        if (js5NetQueue.errorCode == 7 || js5NetQueue.errorCode == 9) {
          this.handleGameError("js5connect_full");
        } else if (js5NetQueue.errorCode <= 0) {
          this.handleGameError("js5io");
        } else {
          this.handleGameError("js5connect");
        }

        Static403.anInt6667 = 1000;

        return;
      }
    }

    previousJS5ConnectionAttepts = js5NetQueue.connectionFailures;

    if (connectionRetrySkipIterations > 0) {
      connectionRetrySkipIterations--;
      return;
    }

    try {
      if (js5ConnectionStage == 0) {
        connectionInitializationMessage =
            GameShell.signLink.emitConnectionInitializationMessage(host, port);

        js5ConnectionStage++;
      }

      if (js5ConnectionStage == 1) {
        if (connectionInitializationMessage.status == 2) {
          this.signalJS5ConnectionFailedWithErrorCode(1000);

          return;
        }
        if (connectionInitializationMessage.status == 1) {
          js5ConnectionStage++;
        }
      }

      if (js5ConnectionStage == 2) {
        serverConnection =
            new ServerConnection(
                (Socket) connectionInitializationMessage.output, GameShell.signLink);

        @Pc(194)
        Packet connectionInitializationPacket = new Packet(5);
        connectionInitializationPacket.p1(Class60.aClass60_2.anInt1812);
        connectionInitializationPacket.p4(592);

        serverConnection.write(5, connectionInitializationPacket.data);

        js5ConnectionStage++;

        connectionInitializationTimestamp = MonotonicClock.getCurrentTimeInMilliseconds();
      }

      if (js5ConnectionStage == 3) {
        if (Static403.anInt6667 == 0
            || Static403.anInt6667 == 5
            || serverConnection.getEstimatedBytesAvailable() > 0) {
          @Pc(259)
          int response = serverConnection.readByteFromServer();

          if (response != 0) {
            this.signalJS5ConnectionFailedWithErrorCode(response);

            return;
          }

          js5ConnectionStage++;
        } else if (MonotonicClock.getCurrentTimeInMilliseconds() - connectionInitializationTimestamp
            > 30000L) {
          this.signalJS5ConnectionFailedWithErrorCode(1001);

          return;
        }
      }

      if (js5ConnectionStage == 4) {
        @Pc(293)
        boolean local293 =
            Static403.anInt6667 == 5 || Static403.anInt6667 == 10 || Static403.anInt6667 == 28;

        js5NetQueue.init(serverConnection, !local293);

        connectionInitializationMessage = null;
        js5ConnectionStage = 0;
        serverConnection = null;
      }
    } catch (
        @Pc(312)
        IOException e) {
      this.signalJS5ConnectionFailedWithErrorCode(1002);
    }
  }

  @OriginalMember(owner = "client!client", name = "e", descriptor = "(I)V")
  @Override
  protected void method886() {
    if (Static135.aBoolean256) {
      Static316.method4216();
    }

    if (Static122.aClass19_16 != null) {
      Static122.aClass19_16.method4267();
    }

    if (GameShell.fullScreenFrame != null) {
      FullScreenWindow.exitFullScreenMode(GameShell.signLink, GameShell.fullScreenFrame);
      GameShell.fullScreenFrame = null;
    }

    if (Static125.aServerConnection_5 != null) {
      Static125.aServerConnection_5.shutdown();
      Static125.aServerConnection_5 = null;
    }

    if (Static223.aIMouseWheel_1 != null) {
      Static223.aIMouseWheel_1.removeListener(GameShell.canvas);
    }

    Static223.aIMouseWheel_1 = null;

    Static64.method1241();
    js5NetQueue.shutdown();
    aJs5DiskCache_3.stop();

    if (Static402.aClass256_1 != null) {
      Static402.aClass256_1.method5475();
      Static402.aClass256_1 = null;
    }
  }

  @OriginalMember(owner = "client!client", name = "j", descriptor = "(I)V")
  private void graphicsStep() {
    if (Static403.anInt6667 == 1000) {
      return;
    }
    @Pc(19)
    long local19 = method2607() / 1000000L - Static153.aLong107;
    Static153.aLong107 = method2607() / 1000000L;
    @Pc(27)
    boolean local27 = Static303.method4111();
    if (local27 && Static436.aBoolean666 && Static424.aClass49_2 != null) {
      Static424.aClass49_2.method2064();
    }
    if (Static403.anInt6667 == 30 || Static403.anInt6667 == 10) {
      if (Static453.aLong223 != 0L
          && MonotonicClock.getCurrentTimeInMilliseconds() > Static453.aLong223) {
        Static188.method4107(
            Static450.method5664(),
            ClientPreferences.preferences.anInt3450,
            ClientPreferences.preferences.anInt3431,
            false);
      } else if (!Static122.aClass19_16.method4258() && Static84.aBoolean383) {
        Static349.method4711();
      }
    }
    @Pc(98)
    int local98;
    @Pc(102)
    int local102;
    if (GameShell.fullScreenFrame == null) {
      @Pc(89)
      Container local89;
      if (GameShell.frame == null) {
        local89 = GameShell.signLink.hostApplet;
      } else {
        local89 = GameShell.frame;
      }
      local98 = local89.getSize().width;
      local102 = local89.getSize().height;
      if (local89 == GameShell.frame) {
        @Pc(108)
        Insets local108 = GameShell.frame.getInsets();
        local102 -= local108.bottom + local108.top;
        local98 -= local108.left + local108.right;
      }
      if (local98 != Static425.anInt7000 || Static17.anInt222 != local102) {
        if (Static122.aClass19_16 == null || Static122.aClass19_16.method4245()) {
          method3938();
        } else {
          Static17.anInt222 = local102;
          Static425.anInt7000 = local98;
        }
        Static453.aLong223 = MonotonicClock.getCurrentTimeInMilliseconds() + 500L;
      }
    }
    if (GameShell.fullScreenFrame != null
        && !Static265.aBoolean457
        && (Static403.anInt6667 == 30 || Static403.anInt6667 == 10)) {
      Static188.method4107(ClientPreferences.preferences.anInt3447, -1, -1, false);
    }
    @Pc(176)
    boolean local176 = false;
    if (GameShell.aBoolean189) {
      GameShell.aBoolean189 = false;
      local176 = true;
    }
    if (local176) {
      Static348.method4697();
    }
    if (Static122.aClass19_16 != null && Static122.aClass19_16.method4258()
        || Static450.method5664() != 1) {
      Static369.method4940();
    }
    if (Static403.anInt6667 == 0) {
      GameShell.initializeClientLoadingBox(
          Static171.aColorArray5[ClientSettings.colourID],
          Static164.aColorArray6[ClientSettings.colourID],
          Static64.aColorArray3[ClientSettings.colourID],
          Static247.anInt4590,
          local176,
          Static24.currentLoadingBoxText);
    } else if (Static403.anInt6667 == 5) {
      Static260.method3773(
          Static164.aColorArray6[ClientSettings.colourID].getRGB(),
          local176 | Static122.aClass19_16.method4258(),
          Static64.aColorArray3[ClientSettings.colourID].getRGB(),
          Static171.aColorArray5[ClientSettings.colourID].getRGB(),
          Static331.aClass46_10,
          Static122.aClass19_16);
    } else if (Static403.anInt6667 == 10) {
      Static298.method4085();
    } else if (Static403.anInt6667 == 25 || Static403.anInt6667 == 28) {
      if (Static51.anInt883 == 1) {
        if (Static100.anInt2020 > Static26.anInt448) {
          Static26.anInt448 = Static100.anInt2020;
        }
        local98 = (Static26.anInt448 - Static100.anInt2020) * 50 / Static26.anInt448;
        Static436.method5519(
            true,
            Static439.A_LOCALIZED_STRING___148.getString(ClientSettings.langID)
                + "<br>("
                + local98
                + "%)",
            Static207.aClass46_9);
      } else if (Static51.anInt883 == 2) {
        if (Static444.anInt7298 < Static275.anInt5144) {
          Static444.anInt7298 = Static275.anInt5144;
        }
        local98 = (Static444.anInt7298 - Static275.anInt5144) * 50 / Static444.anInt7298 + 50;
        Static436.method5519(
            true,
            Static439.A_LOCALIZED_STRING___148.getString(ClientSettings.langID)
                + "<br>("
                + local98
                + "%)",
            Static207.aClass46_9);
      } else {
        Static436.method5519(
            true,
            Static439.A_LOCALIZED_STRING___148.getString(ClientSettings.langID),
            Static207.aClass46_9);
      }
    } else if (Static403.anInt6667 == 30) {
      Static45.method764(local19);
    } else if (Static403.anInt6667 == 40) {
      Static436.method5519(
          true,
          Static444.A_LOCALIZED_STRING___150.getString(ClientSettings.langID)
              + "<br>"
              + Static168.A_LOCALIZED_STRING___69.getString(ClientSettings.langID),
          Static207.aClass46_9);
    }
    if (Static293.anInt5286 == 3) {
      for (local98 = 0; local98 < Static229.anInt4407; local98++) {
        @Pc(394)
        Rectangle local394 = Node_Sub6_Sub23.aRectangleArray1[local98];
        if (Static65.aBooleanArray9[local98]) {
          Static122.aClass19_16.method4293(
              local394.x, local394.width, local394.y, -1996553985, local394.height);
        } else if (Static263.aBooleanArray15[local98]) {
          Static122.aClass19_16.method4293(
              local394.x, local394.width, local394.y, -1996554240, local394.height);
        }
      }
    }
    if (Static426.method5440()) {
      Static433.method5498(Static122.aClass19_16);
    }
    if ((Static403.anInt6667 == 30 || Static403.anInt6667 == 10)
        && Static293.anInt5286 == 0
        && Static450.method5664() == 1
        && !local176
        && SignLink.javaVersion.equals("1.1")) {
      local98 = 0;
      for (local102 = 0; local102 < Static229.anInt4407; local102++) {
        if (Static263.aBooleanArray15[local102]) {
          Static263.aBooleanArray15[local102] = false;
          Static367.aRectangleArray2[local98++] = Node_Sub6_Sub23.aRectangleArray1[local102];
        }
      }
      Static122.aClass19_16.method4290(Static367.aRectangleArray2, local98);
    } else if (Static403.anInt6667 != 0) {
      Static122.aClass19_16.method4247();
      for (local98 = 0; local98 < Static229.anInt4407; local98++) {
        Static263.aBooleanArray15[local98] = false;
      }
    }
    if (ClientPreferences.preferences.anInt3437 == 0) {
      ThreadingUtilities.sleepFor(15L);
    } else if (ClientPreferences.preferences.anInt3437 == 1) {
      ThreadingUtilities.sleepFor(10L);
    } else if (ClientPreferences.preferences.anInt3437 == 2) {
      ThreadingUtilities.sleepFor(5L);
    } else if (ClientPreferences.preferences.anInt3437 == 3) {
      ThreadingUtilities.sleepFor(2L);
    }
    if (Static9.aBoolean10) {
      Static198.method3117();
    }
    if (ClientPreferences.preferences.aBoolean297
        && Static403.anInt6667 == 10
        && Static334.anInt5766 != -1) {
      ClientPreferences.preferences.aBoolean297 = false;
      ClientPreferences.preferences.writeToFile(GameShell.signLink);
    }
  }

  @OriginalMember(owner = "client!client", name = "a", descriptor = "(B)V")
  @Override
  protected void runGameLogicStep() {
    try {
      this.gameLogicStep();
    } catch (OutOfMemoryError e) {
      if (e.getMessage() == null || !e.getMessage().startsWith("native")) {
        throw e;
      }

      Static239.method3551(0);

      Static94.handleClientError(e, e.getMessage() + " (Recovered) " + this.getErrorContext());
    }
  }

  @OriginalMember(owner = "client!client", name = "e", descriptor = "(B)Ljava/lang/String;")
  @Override
  protected String getErrorContext() {
    @Pc(5)
    String local5 = null;
    try {
      local5 =
          "[1)"
              + Static180.anInt3453
              + ","
              + Static86.anInt1771
              + ","
              + Static326.anInt5666
              + ","
              + Static283.anInt5187
              + "|";
      if (Static1.aClass16_Sub1_Sub5_Sub1_1 != null) {
        local5 =
            local5
                + "2)"
                + Static263.anInt4963
                + ","
                + (Static180.anInt3453 + Static1.aClass16_Sub1_Sub5_Sub1_1.anIntArray426[0])
                + ","
                + (Static1.aClass16_Sub1_Sub5_Sub1_1.anIntArray427[0] + Static86.anInt1771)
                + "|";
      }
      local5 =
          local5
              + "3)"
              + Static177.anInt2973
              + "|4)"
              + ClientPreferences.preferences.anInt3440
              + "|5)"
              + Static450.method5664()
              + "|6)"
              + Static141.width
              + ","
              + Static302.height
              + "|";
      local5 = local5 + "7)" + ClientPreferences.preferences.method2854(Static177.anInt2973) + "|";
      local5 = local5 + "8)" + ClientPreferences.preferences.method2850(Static177.anInt2973) + "|";
      local5 = local5 + "9)" + ClientPreferences.preferences.aBoolean294 + "|";
      local5 = local5 + "10)" + ClientPreferences.preferences.isTexturesEnabled + "|";
      local5 = local5 + "11)" + ClientPreferences.preferences.aBoolean300 + "|";
      local5 = local5 + "12)" + ClientPreferences.preferences.method2861(Static177.anInt2973) + "|";
      local5 = local5 + "13)" + Static70.anInt1503 + "|";
      try {
        local5 = local5 + "|15)" + jagmisc.getTotalPhysicalMemory();
      } catch (
          @Pc(212)
          Throwable local212) {
      }
      local5 = local5 + "]";
    } catch (
        @Pc(223)
        Throwable local223) {
    }
    return local5;
  }

  @OriginalMember(owner = "client!client", name = "l", descriptor = "(I)V")
  private void method897() {
    Static176.anInt3414++;
    Static361.method4870(-1, null, -1);
    Static40.method697(null, -1, -1);
    Static164.method3582();
    Static325.anInt5640++;
    for (@Pc(31) int local31 = 0; local31 < 32768; local31++) {
      @Pc(37)
      Class16_Sub1_Sub5_Sub2 local37 = Static143.aClass16_Sub1_Sub5_Sub2Array1[local31];
      if (local37 != null) {
        @Pc(43)
        byte local43 = local37.aClass264_1.aByte99;
        if ((local43 & 0x1) != 0) {
          @Pc(51)
          int local51 = local37.method4751();
          @Pc(78)
          int local78;
          if ((local43 & 0x2) != 0 && local37.anInt6086 == 0 && Math.random() * 1000.0D < 10.0D) {
            local78 = (int) Math.round(Math.random() * 10.0D - 5.0D);
            @Pc(86)
            int local86 = (int) Math.round(Math.random() * 10.0D - 5.0D);
            if (local78 != 0 || local86 != 0) {
              @Pc(101)
              int local101 = local37.anIntArray426[0] + local78;
              if (local101 < 0) {
                local101 = 0;
              } else if (Static326.anInt5666 - local51 - 1 < local101) {
                local101 = Static326.anInt5666 - local51 - 1;
              }
              @Pc(136)
              int local136 = local37.anIntArray427[0] + local86;
              if (local136 < 0) {
                local136 = 0;
              } else if (local136 > Static283.anInt5187 - local51 - 1) {
                local136 = Static283.anInt5187 - local51 - 1;
              }
              @Pc(183)
              int local183 =
                  Static6.method49(
                      Static175.aClass213Array1[local37.aByte82],
                      local37.anIntArray426[0],
                      local101,
                      local51,
                      local136,
                      local51,
                      0,
                      Static33.anIntArray36,
                      0,
                      true,
                      Static392.anIntArray498,
                      local37.anIntArray427[0],
                      local51,
                      -1);
              if (local183 > 0) {
                if (local183 > 9) {
                  local183 = 9;
                }
                for (@Pc(195) int local195 = 0; local195 < local183; local195++) {
                  local37.anIntArray426[local195] =
                      Static392.anIntArray498[local183 - local195 - 1];
                  local37.anIntArray427[local195] = Static33.anIntArray36[local183 - local195 - 1];
                  local37.aByteArray84[local195] = 1;
                }
                local37.anInt6086 = local183;
              }
            }
          }
          Static395.method5163(true, local37);
          local78 = Static141.method2424(local37);
          Static447.method5628(local37, Static249.anInt4620, Static82.anInt1655, local78);
          Static371.method4959(local37);
        }
      }
    }
    if (Static238.anInt4506 == 0 && Static354.anInt6183 == 0) {
      if (Static111.anInt2386 == 2) {
        Static329.method4430();
      } else {
        Static294.method514();
      }
      if (Static163.anInt3197 >> 7 < 14
          || Static326.anInt5666 - 14 <= Static163.anInt3197 >> 7
          || Static145.anInt2906 >> 7 < 14
          || Static145.anInt2906 >> 7 >= Static283.anInt5187 - 14) {
        Static63.method1134();
      }
    }
    while (true) {
      @Pc(311)
      Node_Sub34 local311;
      @Pc(316)
      Class247 local316;
      @Pc(327)
      Class247 local327;
      do {
        local311 = (Node_Sub34) Static237.A_LINKED_LIST___52.pollLast();
        if (local311 == null) {
          while (true) {
            do {
              local311 = (Node_Sub34) Static39.A_LINKED_LIST___3.pollLast();
              if (local311 == null) {
                while (true) {
                  do {
                    local311 = (Node_Sub34) Static291.A_LINKED_LIST___35.pollLast();
                    if (local311 == null) {
                      if (Static281.aClass247_12 != null) {
                        Static1.method3();
                      }
                      if (gameLogicStepCount % 1500 == 0) {
                        Static343.method744();
                      }
                      Static375.method4999();
                      if (Static135.aBoolean256
                          && MonotonicClock.getCurrentTimeInMilliseconds() - 60000L
                              > Static174.aLong119) {
                        Static316.method4216();
                        return;
                      }
                      return;
                    }
                    local316 = local311.aClass247_15;
                    if (local316.anInt6865 < 0) {
                      break;
                    }
                    local327 = Static392.method5121(local316.anInt6850);
                  } while (local327 == null
                      || local327.aClass247Array2 == null
                      || local316.anInt6865 >= local327.aClass247Array2.length
                      || local316 != local327.aClass247Array2[local316.anInt6865]);
                  Static271.method3894(local311);
                }
              }
              local316 = local311.aClass247_15;
              if (local316.anInt6865 < 0) {
                break;
              }
              local327 = Static392.method5121(local316.anInt6850);
            } while (local327 == null
                || local327.aClass247Array2 == null
                || local327.aClass247Array2.length <= local316.anInt6865
                || local316 != local327.aClass247Array2[local316.anInt6865]);
            Static271.method3894(local311);
          }
        }
        local316 = local311.aClass247_15;
        if (local316.anInt6865 < 0) {
          break;
        }
        local327 = Static392.method5121(local316.anInt6850);
      } while (local327 == null
          || local327.aClass247Array2 == null
          || local327.aClass247Array2.length <= local316.anInt6865
          || local327.aClass247Array2[local316.anInt6865] != local316);
      Static271.method3894(local311);
    }
  }

  @OriginalMember(owner = "client!client", name = "m", descriptor = "(I)V")
  private void gameLogicStep() {
    if (Static403.anInt6667 == 1000) {
      return;
    }

    gameLogicStepCount++;

    if (gameLogicStepCount % 1000 == 1) {
      @Pc(24)
      GregorianCalendar gregorianCalendar = new GregorianCalendar();
      Static239.randomSeed =
          gregorianCalendar.get(Calendar.HOUR_OF_DAY) * 600
              + gregorianCalendar.get(Calendar.MINUTE) * 10
              + gregorianCalendar.get(Calendar.SECOND) / 6;
      Static325.random.setSeed(Static239.randomSeed);
    }
    if (gameLogicStepCount % 50 == 0) {
      Static449.anInt7316 = Static60.anInt1097;
      Static55.anInt1020 = Static138.anInt2826;
      Static60.anInt1097 = 0;
      Static138.anInt2826 = 0;
    }
    this.method912();
    if (masterIndexProvider != null) {
      masterIndexProvider.method3819();
    }
    Static225.method3438();
    Static384.aClass244_1.method5487();
    Static420.aClass80_1.method2236();
    if (Static223.aIMouseWheel_1 != null) {
      int local85 = Static223.aIMouseWheel_1.getWheelRotation();
      Static430.anInt3862 = local85;
    }
    if (Static122.aClass19_16 != null) {
      Static122.aClass19_16.method4246((int) MonotonicClock.getCurrentTimeInMilliseconds());
    }
    Static201.method4605();
    Static190.anInt3602 = 0;
    for (@Pc(106) Class30 local106 = Static384.aClass244_1.method5483();
        local106 != null && Static190.anInt3602 < 128;
        local106 = Static384.aClass244_1.method5483()) {
      if (local106.method745() != 1) {
        @Pc(119)
        char local119 = local106.method749();
        if (!areModeratorPrivilegesAvailable() || local119 != '`' && local119 != '§') {
          Static164.aClass30Array4[Static190.anInt3602] = local106;
          Static190.anInt3602++;
        } else if (Static426.method5440()) {
          Static433.method5500();
        } else {
          method3806();
        }
      }
    }
    for (@Pc(168) Node_Sub5 local168 = Static420.aClass80_1.method2232();
        local168 != null;
        local168 = Static420.aClass80_1.method2232()) {
      @Pc(174)
      int local174 = local168.method515();
      if (local174 == -1) {
        Static348.A_LINKED_LIST___42.addFirst(local168);
      } else if (Static105.method1981(local174)) {
        Static413.A_LINKED_LIST___47.addFirst(local168);
      }
      if (Static413.A_LINKED_LIST___47.count() > 10) {
        Static413.A_LINKED_LIST___47.pollLast();
      }
    }
    if (Static426.method5440()) {
      Static213.method3223();
    }
    if (Static403.anInt6667 == 0) {
      this.loadClientAssets();
      GameShell.method3660();
    } else if (Static403.anInt6667 == 5) {
      this.loadClientAssets();
      GameShell.method3660();
    } else if (Static403.anInt6667 == 25 || Static403.anInt6667 == 28) {
      method3275();
    }
    if (Static403.anInt6667 == 10) {
      this.method897();
      method5090();
      method3510();
      method5430();
    } else if (Static403.anInt6667 == 30) {
      method4042();
    } else if (Static403.anInt6667 == 40) {
      method5430();
      if (Static296.anInt5302 != -3 && Static296.anInt5302 != 2 && Static296.anInt5302 != 15) {
        Static251.method3639();
      }
    }
    Static79.method1400(Static122.aClass19_16);
    Static413.A_LINKED_LIST___47.pollLast();
  }

  @OriginalMember(owner = "client!client", name = "init", descriptor = "()V")
  @Override
  public void init() {
    if (!this.isValidHost()) {
      return;
    }

    ClientSettings.worldID = Integer.parseInt(this.getParameter("worldid"));
    ClientSettings.modewhere =
        ModeWhere.fromId(Integer.parseInt(this.getParameter("modewhere"))).orElse(ModeWhere.LIVE);
    ClientSettings.modewhat =
        ModeWhat.fromId(Integer.parseInt(this.getParameter("modewhat"))).orElse(ModeWhat.LIVE);

    try {
      ClientSettings.langID = Integer.parseInt(this.getParameter("lang"));
    } catch (
        @Pc(56)
        Exception e) {
      ClientSettings.langID = 0;
    }

    @Pc(62)
    String objecttagParameter = this.getParameter("objecttag");
    ClientSettings.hasObjectTag = objecttagParameter != null && objecttagParameter.equals("1");

    @Pc(78)
    String jsParameter = this.getParameter("js");
    ClientSettings.hasJS = jsParameter != null && jsParameter.equals("1");

    @Pc(94)
    String advertParameter = this.getParameter("advert");
    ClientSettings.hasAdvert = advertParameter != null && advertParameter.equals("1");

    @Pc(110)
    String gameId = this.getParameter("game");

    ClientSettings.modeGame = ModeGame.fromGameId(gameId).orElse(ModeGame.RUNESCAPE);

    try {
      ClientSettings.affiliateID = Integer.parseInt(this.getParameter("affid"));
    } catch (
        @Pc(129)
        Exception local129) {
      ClientSettings.affiliateID = 0;
    }

    ClientSettings.quitURL = this.getParameter("quiturl");
    ClientSettings.settings = this.getParameter("settings");

    if (ClientSettings.settings == null) {
      ClientSettings.settings = "";
    }

    @Pc(147)
    String countryParameter = this.getParameter("country");

    if (countryParameter != null) {
      try {
        ClientSettings.countryID = Integer.parseInt(countryParameter);
      } catch (
          @Pc(154)
          Exception e) {
        ClientSettings.countryID = 0;
      }
    }

    ClientSettings.colourID = Integer.parseInt(this.getParameter("colourid"));

    if (ClientSettings.colourID < 0 || Static64.aColorArray3.length <= ClientSettings.colourID) {
      ClientSettings.colourID = 0;
    }

    if (Integer.parseInt(this.getParameter("sitesettings_member")) == 1) {
      ClientSettings.aBoolean573 = true;
      ClientSettings.aBoolean423 = true;
    }

    Static6.client = this;

    if (ClientSettings.modeGame.isRunescape()) {
      ClientSettings.width = 765;
      ClientSettings.height = 503;
    } else if (ClientSettings.modeGame.isStellarDawn()) {
      ClientSettings.height = 480;
      ClientSettings.width = 640;
    }

    this.load(ClientSettings.modewhat.getId() + 32, ClientSettings.height, ClientSettings.width);
  }

  @OriginalMember(owner = "client!client", name = "g", descriptor = "(I)V")
  @Override
  protected void runGraphicsStep() {
    try {
      this.graphicsStep();
    } catch (
        @Pc(13)
        OutOfMemoryError local13) {
      if (local13.getMessage() == null || !local13.getMessage().startsWith("native")) {
        throw local13;
      }
      Static239.method3551(0);
      Static94.handleClientError(
          local13, local13.getMessage() + " (Recovered) " + this.getErrorContext());
    }
  }

  @OriginalMember(owner = "client!client", name = "a", descriptor = "(Z)V")
  @Override
  protected void method880() {}

  @OriginalMember(owner = "client!client", name = "a", descriptor = "(II)V")
  private void signalJS5ConnectionFailedWithErrorCode(@OriginalArg(1) int errorCode) {
    serverConnection = null;
    connectionInitializationMessage = null;

    js5NetQueue.connectionFailures++;
    js5NetQueue.errorCode = errorCode;
    js5ConnectionStage = 0;
  }

  @OriginalMember(owner = "client!client", name = "d", descriptor = "(I)V")
  @Override
  protected void method883() {
    @Pc(10)
    Frame frame = new Frame("Jagex");

    frame.pack();
    frame.dispose();

    method3938();

    aJs5DiskCache_3 = new Js5DiskCache(GameShell.signLink);
    js5NetQueue = new Js5NetQueue();

    if (!ClientSettings.modewhere.isLive()) {
      Static392.aByteArrayArray28 = new byte[50][];
    }

    ClientPreferences.preferences = new PreferencesImpl(GameShell.signLink);

    if (ClientSettings.modewhere.isLive()) {
      Static13.host = this.getCodeBase().getHost();
      Static133.JS5Port = 43594;
      Static11.HTTPPort = 443;
    } else if (ClientSettings.modewhere.isStagingEnvironment()) {
      Static13.host = this.getCodeBase().getHost();
      Static133.JS5Port = ClientSettings.worldID + 40000;
      Static11.HTTPPort = ClientSettings.worldID + 50000;
    } else if (ClientSettings.modewhere.isLocal()) {
      Static133.JS5Port = ClientSettings.worldID + 40000;
      Static13.host = "127.0.0.1";
      Static11.HTTPPort = ClientSettings.worldID + 50000;
    }

    Static313.anInt5435 = Static133.JS5Port;
    host = Static13.host;

    fallbackServerPort = Static11.HTTPPort;
    primaryServerPort = Static133.JS5Port;

    if (SignLink.anInt1987 == 3) {
      WorldManager.worldId = ClientSettings.worldID;
    }

    Static252.aShortArray151 =
        Static330.aShortArray196 =
            Static78.aShortArray46 = Static166.aShortArray97 = new short[256];

    if (ClientSettings.modeGame.isRunescape()) {
      Static15.aShortArrayArray1 = Static78.aShortArrayArray4;
      Static299.aShortArray179 = Static240.aShortArray251;
      Static65.anInt1369 = 16777215;
      Static317.anInt5521 = 0;
      Static434.isShiftClickEnabled = true;
      Static434.aShortArray252 = Static70.aShortArray43;
      Static26.aShortArrayArray2 = Static84.aShortArrayArray8;
    } else {
      Static26.aShortArrayArray2 = Static70.aShortArrayArray3;
      Static15.aShortArrayArray1 = Static108.aShortArrayArray6;
      Static434.aShortArray252 = Static293.aShortArray175;
      Static299.aShortArray179 = Static354.aShortArray210;
    }

    port = Static313.anInt5435;
    Static384.aClass244_1 = Static140.method2398(GameShell.canvas);
    Static420.aClass80_1 = Static376.method4882(GameShell.canvas);
    Static223.aIMouseWheel_1 = IMouseWheel.create();

    if (Static223.aIMouseWheel_1 != null) {
      Static223.aIMouseWheel_1.addListener(GameShell.canvas);
    }

    Static96.anInt1932 = SignLink.anInt1987;

    try {
      if (GameShell.signLink.cacheDataFile != null) {
        Static88.cacheDataFile = new BufferedFile(GameShell.signLink.cacheDataFile, 5200, 0);

        for (@Pc(169) int i = 0; i < 30; i++) {
          Static86.cacheIndexFiles[i] =
              new BufferedFile(GameShell.signLink.cacheIndexFiles[i], 6000, 0);
        }

        Static425.cacheMasterIndexFile =
            new BufferedFile(GameShell.signLink.cacheIndex255, 6000, 0);
        Static225.aCache_2 =
            new Cache(255, Static88.cacheDataFile, Static425.cacheMasterIndexFile, 500000);
        Static394.randomFile = new BufferedFile(GameShell.signLink.randomFile, 24, 0);

        GameShell.signLink.cacheIndex255 = null;
        GameShell.signLink.randomFile = null;
        GameShell.signLink.cacheDataFile = null;
        GameShell.signLink.cacheIndexFiles = null;
      }
    } catch (
        @Pc(227)
        IOException local227) {
      Static394.randomFile = null;
      Static88.cacheDataFile = null;
      Static225.aCache_2 = null;
      Static425.cacheMasterIndexFile = null;
    }

    if (!ClientSettings.modewhere.isLive()) {
      Static325.isFPSMonitorActive = true;
    }

    gameNameIsLoadingPleaseWaitMessage =
        (ClientSettings.modeGame.isRunescape()
                ? Static268.runescapeIsLoadingPleaseWaitLocalizedString
                : Static374.stellarDawnIsLoadingPleaseWaitLocalizedString)
            .getString(ClientSettings.langID);
  }

  @OriginalMember(owner = "client!client", name = "a", descriptor = "([BB)V")
  private void method908(@OriginalArg(0) byte[] arg0) {
    @Pc(10)
    Packet local10 = new Packet(arg0);
    while (true) {
      @Pc(18)
      int local18;
      @Pc(42)
      int local42;
      @Pc(37)
      int local37;
      label45:
      do {
        while (true) {
          while (true) {
            local18 = local10.g1();
            if (local18 == 0) {
              return;
            }
            if (local18 == 1) {
              @Pc(106)
              int[] local106 = Static382.anIntArray491 = new int[6];
              local106[0] = local10.g2();
              local106[1] = local10.g2();
              local106[2] = local10.g2();
              local106[3] = local10.g2();
              local106[4] = local10.g2();
              local106[5] = local10.g2();
            } else {
              if (local18 != 4) {
                continue label45;
              }
              local37 = local10.g1();
              Static290.anIntArray490 = new int[local37];
              for (local42 = 0; local42 < local37; local42++) {
                Static290.anIntArray490[local42] = local10.g2();
                if (Static290.anIntArray490[local42] == 65535) {
                  Static290.anIntArray490[local42] = -1;
                }
              }
            }
          }
        }
      } while (local18 != 5);
      local37 = local10.g1();
      Static171.anIntArray217 = new int[local37];
      for (local42 = 0; local42 < local37; local42++) {
        Static171.anIntArray217[local42] = local10.g2();
        if (Static171.anIntArray217[local42] == 65535) {
          Static171.anIntArray217[local42] = -1;
        }
      }
    }
  }

  @OriginalMember(owner = "client!client", name = "p", descriptor = "(I)V")
  private void loadClientAssets() {
    if (!ClientPreferences.preferences.aBoolean297) {
      for (int i = 0; i < Static190.anInt3602; i++) {
        if (Static164.aClass30Array4[i].method749() == 's'
            || Static164.aClass30Array4[i].method749() == 'S') {
          ClientPreferences.preferences.aBoolean297 = true;
          break;
        }
      }
    }

    if (anInt5 == 0) {
      Runtime local47 = Runtime.getRuntime();
      int totalUtilizedMemoryBytes = (int) ((local47.totalMemory() - local47.freeMemory()) / 1024L);
      long currentTimeInMilliseconds = MonotonicClock.getCurrentTimeInMilliseconds();

      if (firstLoadClientAssetsTimestamp == 0L) {
        firstLoadClientAssetsTimestamp = currentTimeInMilliseconds;
      }

      if (totalUtilizedMemoryBytes > 16384
          && currentTimeInMilliseconds - firstLoadClientAssetsTimestamp < 5000L) {
        if (currentTimeInMilliseconds - lastGarbageCollectionRequestTimestamp > 1000L) {
          System.gc();
          lastGarbageCollectionRequestTimestamp = currentTimeInMilliseconds;
        }

        Static24.currentLoadingBoxText = Messages.allocatingMemory.getString(ClientSettings.langID);
        Static247.anInt4590 = 5;
      } else {
        Static24.currentLoadingBoxText = Messages.allocatedMemory.getString(ClientSettings.langID);
        anInt5 = 10;
        Static247.anInt4590 = 5;
      }
    } else if (anInt5 == 10) {
      for (int i = 0; i < 4; i++) {
        Static175.aClass213Array1[i] =
            Static446.method5622(Static283.anInt5187, Static326.anInt5666);
      }

      Static24.currentLoadingBoxText = Messages.createdGameWorld.getString(ClientSettings.langID);
      Static247.anInt4590 = 10;
      anInt5 = 20;
    } else if (anInt5 == 20) {
      if (masterIndexProvider == null) {
        masterIndexProvider = new Js5MasterIndexProvider(js5NetQueue, aJs5DiskCache_3);
      }
      if (masterIndexProvider.isReady()) {
        Static395.archive0 = loadArchive(false, 0, true);
        Static324.archive1 = loadArchive(false, 1, true);
        Static74.archive2 = loadArchive(false, 2, true);
        Static256.archive3 = loadArchive(false, 3, true);
        Static67.archive4 = loadArchive(false, 4, true);
        Static49.archive5 = loadArchive(true, 5, true);
        Static46.archive6 = loadArchive(true, 6, false);
        Static357.archive7 = loadArchive(false, 7, true);
        Static293.archive8 = loadArchive(false, 8, true);
        Static196.archive9 = loadArchive(false, 9, true);
        Static88.archive10 = loadArchive(false, 10, true);
        Static284.archive11 = loadArchive(false, 11, true);
        Static197.archive12 = loadArchive(false, 12, true);
        Static209.archive13 = loadArchive(false, 13, true);
        Static312.archive14 = loadArchive(false, 14, false);
        Static350.archive15 = loadArchive(false, 15, true);
        Static424.archive16 = loadArchive(false, 16, true);
        Static208.archive17 = loadArchive(false, 17, true);
        Static381.archive18 = loadArchive(false, 18, true);
        Static391.archive19 = loadArchive(false, 19, true);
        Static388.archive20 = loadArchive(false, 20, true);
        Static55.archive21 = loadArchive(false, 21, true);
        Static64.archive22 = loadArchive(false, 22, true);
        Static163.archive23 = loadArchive(true, 23, true);
        Static66.archive24 = loadArchive(false, 24, true);
        Static154.archive25 = loadArchive(false, 25, true);
        Static24.archive26 = loadArchive(true, 26, true);
        Static417.archive27 = loadArchive(false, 27, true);
        Static19.archive28 = loadArchive(true, 28, true);
        Static366.archive29 = loadArchive(false, 29, true);
        Static24.currentLoadingBoxText =
            Messages.connectedToUpdateServer.getString(ClientSettings.langID);
        Static247.anInt4590 = 15;
        anInt5 = 30;
      } else {
        Static24.currentLoadingBoxText =
            Messages.connectingToUpdateServer.getString(ClientSettings.langID);
        Static247.anInt4590 = 12;
      }
    } else if (anInt5 == 30) {
      int percentLoaded = 0;

      for (int i = 0; i < 30; i++) {
        percentLoaded +=
            Static119.archiveDataResourceProviders[i].getDownloadPercentage()
                * ARCHIVE_FILE_SIZE_WEIGHTS[i]
                / 100;
      }

      if (percentLoaded == 100) {
        Static24.currentLoadingBoxText = Messages.loadedUpdateList.getString(ClientSettings.langID);
        Static247.anInt4590 = 20;
        Sprites.initializeSpriteIds(Static293.archive8);
        Static221.method3346(Static293.archive8);
        anInt5 = 40;
      } else {
        if (percentLoaded != 0) {
          Static24.currentLoadingBoxText =
              Messages.checkingForUpdates.getString(ClientSettings.langID) + percentLoaded + "%";
        }

        Static247.anInt4590 = 20;
      }
    } else if (anInt5 == 40) {
      if (Static19.archive28.fetchAll()) {
        this.method908(Static19.archive28.method2122(1));
        Static24.currentLoadingBoxText = Messages.loadedDefaults.getString(ClientSettings.langID);
        Static247.anInt4590 = 25;
        anInt5 = 50;
      } else {
        Static24.currentLoadingBoxText =
            Messages.loadingDefaults.getString(ClientSettings.langID)
                + Static19.archive28.method2112()
                + "%";
        Static247.anInt4590 = 25;
      }
    } else if (anInt5 == 50) {
      Static72.method1354();
      Static24.currentLoadingBoxText =
          Messages.preparedSoundEngine.getString(ClientSettings.langID);
      Static247.anInt4590 = 30;
      anInt5 = 60;
    } else if (anInt5 == 60) {
      int loadedFontCount = Fonts.getLoadedCount(Static209.archive13, Static293.archive8);
      int totalFontCount = Fonts.getTotalCount();

      if (loadedFontCount < totalFontCount) {
        Static24.currentLoadingBoxText =
            Messages.loadingCoreFonts.getString(ClientSettings.langID)
                + loadedFontCount * 100 / totalFontCount
                + "%";
        Static247.anInt4590 = 35;
      } else {
        Static24.currentLoadingBoxText = Messages.loadedCoreFonts.getString(ClientSettings.langID);
        anInt5 = 70;
        Static247.anInt4590 = 35;
      }
    } else if (anInt5 == 70) {
      int local10 = Static97.method1701(Static293.archive8);
      int local12 = Static395.method5165();
      if (local12 > local10) {
        Static24.currentLoadingBoxText =
            Messages.loadingTitleScreen.getString(ClientSettings.langID)
                + local10 * 100 / local12
                + "%";
        Static247.anInt4590 = 40;
      } else {
        Static24.currentLoadingBoxText =
            Messages.loadedTitleScreen.getString(ClientSettings.langID);
        anInt5 = 80;
        Static247.anInt4590 = 40;
      }
    } else if (anInt5 == 80) {
      if (Static24.archive26.fetchAll()) {
        Static80.anInterface7_3 =
            new Class91(Static24.archive26, Static196.archive9, Static293.archive8);
        Static24.currentLoadingBoxText = Messages.loadedTextures.getString(ClientSettings.langID);
        Static247.anInt4590 = 45;
        anInt5 = 90;
      } else {
        Static24.currentLoadingBoxText =
            Messages.loadingTextures.getString(ClientSettings.langID)
                + Static24.archive26.method2112()
                + "%";
        Static247.anInt4590 = 45;
      }
    } else if (anInt5 == 90) {
      Static24.currentLoadingBoxText = Messages.starting3dLibrary.getString(ClientSettings.langID);
      Static247.anInt4590 = 50;
      anInt5 = 95;
    } else if (anInt5 == 95) {
      if (ClientPreferences.preferences.aBoolean297) {
        ClientPreferences.preferences.anInt3442 = 0;
        ClientPreferences.preferences.anInt3447 = 1;
        ClientPreferences.preferences.anInt3440 = 0;
        ClientPreferences.preferences.anInt3445 = 0;
        ClientPreferences.preferences.anInt3434 = 0;
      }
      ClientPreferences.preferences.aBoolean297 = true;
      ClientPreferences.preferences.writeToFile(GameShell.signLink);
      Static440.method5561(false, ClientPreferences.preferences.anInt3445);
      Static24.currentLoadingBoxText = Messages.started3dLibrary.getString(ClientSettings.langID);
      Static247.anInt4590 = 55;
      anInt5 = 100;
    } else if (anInt5 == 100) {
      Static40.method696(Static122.aClass19_16, Static293.archive8, Static209.archive13);
      Static24.currentLoadingBoxText = Messages.openedTitleScreen.getString(ClientSettings.langID);
      Static247.anInt4590 = 60;
      Static187.method2932(5);
      anInt5 = 110;
    } else if (anInt5 == 110) {
      Static74.archive2.fetchAll();
      int local10 = Static74.archive2.method2112();
      Static424.archive16.fetchAll();
      local10 += Static424.archive16.method2112();
      Static208.archive17.fetchAll();
      local10 += Static208.archive17.method2112();
      Static381.archive18.fetchAll();
      local10 += Static381.archive18.method2112();
      Static391.archive19.fetchAll();
      local10 += Static391.archive19.method2112();
      Static388.archive20.fetchAll();
      local10 += Static388.archive20.method2112();
      Static55.archive21.fetchAll();
      local10 += Static55.archive21.method2112();
      Static64.archive22.fetchAll();
      local10 += Static64.archive22.method2112();
      Static66.archive24.fetchAll();
      local10 += Static66.archive24.method2112();
      Static154.archive25.fetchAll();
      local10 += Static154.archive25.method2112();
      Static417.archive27.fetchAll();
      local10 += Static417.archive27.method2112();
      Static366.archive29.fetchAll();
      local10 += Static366.archive29.method2112();
      if (local10 < 1200) {
        Static24.currentLoadingBoxText =
            Messages.loadingConfig.getString(ClientSettings.langID) + local10 / 12 + "%";
        Static247.anInt4590 = 65;
      } else {
        Static153.aClass180_1 =
            new Class180(ClientSettings.modeGame, ClientSettings.langID, Static74.archive2);
        Static222.aClass249_1 =
            new Class249(ClientSettings.modeGame, ClientSettings.langID, Static74.archive2);
        Static118.aClass172_2 =
            new Class172(
                ClientSettings.modeGame,
                ClientSettings.langID,
                Static74.archive2,
                Static293.archive8);
        Static416.aClass158_1 =
            new Class158(ClientSettings.modeGame, ClientSettings.langID, Static208.archive17);
        Static154.aClass124_2 =
            new Class124(ClientSettings.modeGame, ClientSettings.langID, Static74.archive2);
        Static234.aClass192_2 =
            new Class192(ClientSettings.modeGame, ClientSettings.langID, Static74.archive2);
        Static420.aClass109_2 =
            new Class109(
                ClientSettings.modeGame,
                ClientSettings.langID,
                Static74.archive2,
                Static357.archive7);
        Static101.aClass75_1 =
            new Class75(ClientSettings.modeGame, ClientSettings.langID, Static74.archive2);
        Static405.aClass204_1 =
            new Class204(ClientSettings.modeGame, ClientSettings.langID, Static74.archive2);
        Static267.aClass262_2 =
            new Class262(
                ClientSettings.modeGame,
                ClientSettings.langID,
                true,
                Static424.archive16,
                Static357.archive7);
        Static348.aClass182_4 =
            new Class182(
                ClientSettings.modeGame,
                ClientSettings.langID,
                Static74.archive2,
                Static293.archive8);
        Static76.aClass265_2 =
            new Class265(
                ClientSettings.modeGame,
                ClientSettings.langID,
                Static74.archive2,
                Static293.archive8);
        Static329.aClass240_1 =
            new Class240(
                ClientSettings.modeGame,
                ClientSettings.langID,
                true,
                Static381.archive18,
                Static357.archive7);
        Static444.aClass206_3 =
            new Class206(
                ClientSettings.modeGame,
                ClientSettings.langID,
                true,
                Static153.aClass180_1,
                Static391.archive19,
                Static357.archive7);
        Static426.aClass208_1 =
            new Class208(ClientSettings.modeGame, ClientSettings.langID, Static74.archive2);
        Static182.aClass55_1 =
            new Class55(
                ClientSettings.modeGame,
                ClientSettings.langID,
                Static388.archive20,
                Static395.archive0,
                Static324.archive1);
        Static296.aClass217_1 =
            new Class217(ClientSettings.modeGame, ClientSettings.langID, Static74.archive2);
        Static238.aClass226_1 =
            new Class226(ClientSettings.modeGame, ClientSettings.langID, Static74.archive2);
        Static352.aClass194_2 =
            new Class194(
                ClientSettings.modeGame,
                ClientSettings.langID,
                Static55.archive21,
                Static357.archive7);
        Static280.aClass72_1 =
            new Class72(ClientSettings.modeGame, ClientSettings.langID, Static74.archive2);
        Static186.aClass197_1 =
            new Class197(ClientSettings.modeGame, ClientSettings.langID, Static74.archive2);
        Static43.aClass93_4 =
            new Class93(ClientSettings.modeGame, ClientSettings.langID, Static74.archive2);
        Static26.aClass26_1 =
            new Class26(ClientSettings.modeGame, ClientSettings.langID, Static64.archive22);
        Static183.aClass223_1 =
            new Class223(ClientSettings.modeGame, ClientSettings.langID, Static74.archive2);
        Static442.method5586(
            Static256.archive3, Static209.archive13, Static357.archive7, Static293.archive8);
        Static165.method2730(Static366.archive29);
        Static401.aClass62_1 =
            new Class62(ClientSettings.langID, Static66.archive24, Static154.archive25);
        Static445.aClass81_2 =
            new Class81(
                ClientSettings.langID, Static66.archive24, Static154.archive25, new Class130());
        Static24.currentLoadingBoxText = Messages.loadedConfig.getString(ClientSettings.langID);
        Static247.anInt4590 = 65;
        Static38.method673();
        Static267.aClass262_2.method5562(
            !ClientPreferences.preferences.method2861(Static177.anInt2973));
        Static257.aClass114_1 = new Class114();
        Static119.method2149();
        Static378.method3227(Static417.archive27);
        Static273.method3916(Static357.archive7, Static80.anInterface7_3);
        anInt5 = 120;
      }
    } else if (anInt5 == 120) {
      int local10 = Static290.method5014(Static293.archive8);
      int local13 = Static203.method3176();
      if (local10 < local13) {
        Static24.currentLoadingBoxText =
            Messages.loadingSprites.getString(ClientSettings.langID)
                + local10 * 100 / local13
                + "%";
        Static247.anInt4590 = 70;
      } else {
        Static97.method1700(Static293.archive8, Static122.aClass19_16);
        Static324.method4387(Static429.aClass57Array18);
        Static24.currentLoadingBoxText = Messages.loadedSprites.getString(ClientSettings.langID);
        anInt5 = 130;
        Static247.anInt4590 = 70;
      }
    } else if (anInt5 == 130) {
      if (Static88.archive10.method2123("", "huffman")) {
        @Pc(1252)
        Class119 local1252 = new Class119(Static88.archive10.method2109("huffman", ""));
        Static195.method3074(local1252);
        Static24.currentLoadingBoxText = Messages.loadedWordpack.getString(ClientSettings.langID);
        Static247.anInt4590 = 75;
        anInt5 = 140;
      } else {
        Static24.currentLoadingBoxText =
            Messages.loadingWordpack.getString(ClientSettings.langID) + "0%";
        Static247.anInt4590 = 75;
      }
    } else if (anInt5 == 140) {
      if (Static256.archive3.fetchAll()) {
        Static24.currentLoadingBoxText = Messages.loadedInterfaces.getString(ClientSettings.langID);
        anInt5 = 150;
        Static247.anInt4590 = 80;
      } else {
        Static24.currentLoadingBoxText =
            Messages.loadingInterfaces.getString(ClientSettings.langID)
                + Static256.archive3.method2112()
                + "%";
        Static247.anInt4590 = 80;
      }
    } else if (anInt5 == 150) {
      if (Static197.archive12.fetchAll()) {
        Static24.currentLoadingBoxText =
            Messages.loadedInterfaceScripts.getString(ClientSettings.langID);
        anInt5 = 160;
        Static247.anInt4590 = 82;
      } else {
        Static24.currentLoadingBoxText =
            Messages.loadingInterfaceScripts.getString(ClientSettings.langID)
                + Static197.archive12.method2112()
                + "%";
        Static247.anInt4590 = 82;
      }
    } else if (anInt5 == 160) {
      if (Static209.archive13.fetchAll()) {
        Static24.currentLoadingBoxText =
            Messages.loadingAdditionalFonts.getString(ClientSettings.langID);
        anInt5 = 170;
        Static247.anInt4590 = 85;
      } else {
        Static24.currentLoadingBoxText =
            Messages.loadingAdditionalFonts.getString(ClientSettings.langID)
                + Static209.archive13.method2112()
                + "%";
        Static247.anInt4590 = 85;
      }
    } else if (anInt5 == 170) {
      if (Static163.archive23.method2103("details")) {
        Static148.method4514(
            Static163.archive23,
            Static154.aClass124_2,
            Static234.aClass192_2,
            Static267.aClass262_2,
            Static348.aClass182_4,
            Static76.aClass265_2,
            Static257.aClass114_1);
        Static24.currentLoadingBoxText = Messages.loadedWorldMap.getString(ClientSettings.langID);
        anInt5 = 180;
        Static247.anInt4590 = 89;
      } else {
        Static24.currentLoadingBoxText =
            Messages.loadingWorldMap.getString(ClientSettings.langID)
                + Static163.archive23.method2113("details")
                + "%";
        Static247.anInt4590 = 87;
      }
    } else if (anInt5 == 180) {
      Static24.currentLoadingBoxText =
          Messages.loadedWorldListData.getString(ClientSettings.langID);
      anInt5 = 190;
      Static247.anInt4590 = 90;
    } else if (anInt5 == 190) {
      Static265.aStringArray20 = new String[Static186.aClass197_1.anInt5738];
      Static22.aBooleanArray3 = new boolean[Static43.aClass93_4.anInt2890];
      Static165.anIntArray210 = new int[Static43.aClass93_4.anInt2890];
      for (int i = 0; i < Static43.aClass93_4.anInt2890; i++) {
        if (Static43.aClass93_4.method2430(i).anInt6668 == 0) {
          Static22.aBooleanArray3[i] = true;
          Static268.anInt4998++;
        }
        Static165.anIntArray210[i] = -1;
      }
      Static228.method2068();
      Static254.loginScreenGroupId = Static256.archive3.getGroupId("loginscreen");
      Static49.archive5.method2128(false);
      Static46.archive6.method2128(true);
      Static293.archive8.method2128(true);
      Static209.archive13.method2128(true);
      Static88.archive10.method2128(true);
      Static256.archive3.method2128(true);
      Static74.archive2.anInt2476 = 2;
      Static9.aBoolean10 = true;
      Static208.archive17.anInt2476 = 2;
      Static424.archive16.anInt2476 = 2;
      Static381.archive18.anInt2476 = 2;
      Static391.archive19.anInt2476 = 2;
      Static388.archive20.anInt2476 = 2;
      Static55.archive21.anInt2476 = 2;
      Static188.method4107(ClientPreferences.preferences.anInt3447, -1, -1, false);
      Static24.currentLoadingBoxText =
          Messages.loadedClientVariableData.getString(ClientSettings.langID);
      Static247.anInt4590 = 95;
      anInt5 = 200;
    } else if (anInt5 == 200) {
      Static374.method4994(true);
    }
  }

  @OriginalMember(owner = "client!client", name = "f", descriptor = "(B)V")
  private void method912() {
    Js5NetQueue.ProcessConnectionsResult result = js5NetQueue.processJS5Requests();

    if (result == Js5NetQueue.ProcessConnectionsResult.UNABLE_TO_PROCESS_REQUESTS) {
      this.js5connect();
    }
  }
}
