package com.jagex.client;

import com.jagex.client.graphics.RenderMath;
import com.jagex.client.preferences.ClientPreferences;
import com.jagex.client.protocol.OpCode;
import java.io.IOException;
import org.openrs2.deob.annotation.OriginalMember;

public final class Protocol {
  public static final OpCode A_OP_CODE___16 = new OpCode(0, 28);
  public static final OpCode A_OP_CODE___80 = new OpCode(1, -2);
  public static final OpCode A_OP_CODE___195 = new OpCode(2, -2);
  public static final OpCode A_OP_CODE___325 = new OpCode(3, -1);
  public static final OpCode A_OP_CODE___328 = new OpCode(4, -1);
  public static final OpCode A_OP_CODE___185 = new OpCode(5, 8);
  public static final OpCode A_OP_CODE___290 = new OpCode(6, 11);
  public static final OpCode A_OP_CODE___261 = new OpCode(7, 0);
  public static final OpCode A_OP_CODE___194 = new OpCode(8, -2);
  public static final OpCode A_OP_CODE___286 = new OpCode(9, 6);
  public static final OpCode A_OP_CODE___248 = new OpCode(10, 12);
  public static final OpCode A_OP_CODE___292 = new OpCode(11, -2);
  public static final OpCode A_OP_CODE___330 = new OpCode(12, 5);
  public static final OpCode A_OP_CODE___167 = new OpCode(13, -2);
  public static final OpCode A_OP_CODE___17 = new OpCode(14, 3);
  public static final OpCode A_OP_CODE___317 = new OpCode(15, 8);
  public static final OpCode A_OP_CODE___159 = new OpCode(16, -1);
  public static final OpCode A_OP_CODE___316 = new OpCode(17, 0);
  public static final OpCode A_OP_CODE___33 = new OpCode(18, 1);
  public static final OpCode A_OP_CODE___199 = new OpCode(19, 6);
  public static final OpCode A_OP_CODE___106 = new OpCode(20, 12);
  public static final OpCode A_OP_CODE___203 = new OpCode(21, 6);
  public static final OpCode A_OP_CODE___247 = new OpCode(22, 9);
  public static final OpCode A_OP_CODE___196 = new OpCode(23, 8);
  public static final OpCode A_OP_CODE___120 = new OpCode(24, 6);
  public static final OpCode A_OP_CODE___310 = new OpCode(25, -1);
  public static final OpCode A_OP_CODE___46 = new OpCode(26, -1);
  public static final OpCode A_OP_CODE___191 = new OpCode(27, -2);
  public static final OpCode A_OP_CODE___96 = new OpCode(28, 3);
  public static final OpCode A_OP_CODE___335 = new OpCode(29, 1);
  public static final OpCode A_OP_CODE___53 = new OpCode(30, 3);
  public static final OpCode A_OP_CODE___313 = new OpCode(31, 18);
  public static final OpCode A_OP_CODE___102 = new OpCode(32, -2);
  public static final OpCode A_OP_CODE___98 = new OpCode(33, 0);
  public static final OpCode A_OP_CODE___241 = new OpCode(34, 16);
  public static final OpCode A_OP_CODE___72 = new OpCode(35, -2);
  public static final OpCode A_OP_CODE___178 = new OpCode(36, 12);
  public static final OpCode A_OP_CODE___173 = new OpCode(37, 8);
  public static final OpCode A_OP_CODE___219 = new OpCode(38, 1);
  public static final OpCode A_OP_CODE___95 = new OpCode(39, 8);
  public static final OpCode A_OP_CODE___245 = new OpCode(40, 3);
  public static final OpCode A_OP_CODE___263 = new OpCode(41, 7);
  public static final OpCode A_OP_CODE___273 = new OpCode(42, -1);
  public static final OpCode A_OP_CODE___175 = new OpCode(43, 3);
  public static final OpCode A_OP_CODE___192 = new OpCode(44, 6);
  public static final OpCode A_OP_CODE___1 = new OpCode(45, 2);
  public static final OpCode A_OP_CODE___150 = new OpCode(46, -1);
  public static final OpCode A_OP_CODE___23 = new OpCode(47, 20);
  public static final OpCode A_OP_CODE___152 = new OpCode(48, 3);
  public static final OpCode A_OP_CODE___269 = new OpCode(49, 4);
  public static final OpCode A_OP_CODE___324 = new OpCode(50, 3);
  public static final OpCode A_OP_CODE___236 = new OpCode(51, 14);
  public static final OpCode A_OP_CODE___232 = new OpCode(52, 8);
  public static final OpCode A_OP_CODE___293 = new OpCode(53, -1);
  public static final OpCode A_OP_CODE___146 = new OpCode(54, -2);
  public static final OpCode A_OP_CODE___251 = new OpCode(55, 2);
  public static final OpCode A_OP_CODE___235 = new OpCode(56, 4);
  public static final OpCode A_OP_CODE___204 = new OpCode(57, 15);
  public static final OpCode A_OP_CODE___312 = new OpCode(58, -1);
  public static final OpCode A_OP_CODE___332 = new OpCode(59, -2);
  public static final OpCode A_OP_CODE___301 = new OpCode(60, -1);
  public static final OpCode A_OP_CODE___212 = new OpCode(61, 5);
  public static final OpCode A_OP_CODE___117 = new OpCode(62, 8);
  public static final OpCode A_OP_CODE___282 = new OpCode(63, 4);
  public static final OpCode A_OP_CODE___214 = new OpCode(64, 10);
  public static final OpCode A_OP_CODE___336 = new OpCode(65, 2);
  public static final OpCode A_OP_CODE___287 = new OpCode(66, 0);
  public static final OpCode A_OP_CODE___164 = new OpCode(67, 10);
  public static final OpCode A_OP_CODE___264 = new OpCode(68, 5);
  public static final OpCode A_OP_CODE___45 = new OpCode(69, -1);
  public static final OpCode A_OP_CODE___252 = new OpCode(70, 4);
  public static final OpCode A_OP_CODE___73 = new OpCode(71, 6);
  public static final OpCode A_OP_CODE___205 = new OpCode(72, 6);
  public static final OpCode A_OP_CODE___319 = new OpCode(73, 12);
  public static final OpCode A_OP_CODE___281 = new OpCode(74, -1);
  public static final OpCode A_OP_CODE___311 = new OpCode(75, 14);
  public static final OpCode A_OP_CODE___278 = new OpCode(76, 7);
  public static final OpCode A_OP_CODE___71 = new OpCode(77, -2);
  public static final OpCode A_OP_CODE___51 = new OpCode(78, 2);
  public static final OpCode A_OP_CODE___160 = new OpCode(79, 6);
  public static final OpCode A_OP_CODE___266 = new OpCode(80, 7);
  public static final OpCode A_OP_CODE___277 = new OpCode(81, -2);
  public static final OpCode A_OP_CODE___11 = new OpCode(82, 12);
  public static final OpCode A_OP_CODE___253 = new OpCode(83, 3);
  public static final OpCode A_OP_CODE___218 = new OpCode(84, 2);
  public static final OpCode A_OP_CODE___268 = new OpCode(85, 6);
  public static final OpCode A_OP_CODE___223 = new OpCode(86, 8);
  public static final OpCode A_OP_CODE___32 = new OpCode(87, -1);
  public static final OpCode A_OP_CODE___302 = new OpCode(88, -1);
  public static final OpCode A_OP_CODE___254 = new OpCode(89, 8);
  public static final OpCode A_OP_CODE___157 = new OpCode(90, 12);
  public static final OpCode A_OP_CODE___125 = new OpCode(91, -1);
  public static final OpCode A_OP_CODE___144 = new OpCode(92, 2);
  public static final OpCode A_OP_CODE___230 = new OpCode(93, 8);
  public static final OpCode A_OP_CODE___307 = new OpCode(94, 0);
  public static final OpCode A_OP_CODE___94 = new OpCode(95, -2);
  public static final OpCode A_OP_CODE___306 = new OpCode(96, 2);
  public static final OpCode A_OP_CODE___200 = new OpCode(97, -2);
  public static final OpCode A_OP_CODE___231 = new OpCode(98, -1);
  public static final OpCode A_OP_CODE___63 = new OpCode(99, 7);
  public static final OpCode A_OP_CODE___129 = new OpCode(100, 6);
  public static final OpCode A_OP_CODE___331 = new OpCode(101, -1);
  public static final OpCode A_OP_CODE___209 = new OpCode(102, 5);
  public static final OpCode A_OP_CODE___327 = new OpCode(103, 6);
  public static final OpCode A_OP_CODE___101 = new OpCode(104, 6);
  public static final OpCode A_OP_CODE___249 = new OpCode(105, -2);
  public static final OpCode A_OP_CODE___284 = new OpCode(106, 10);
  public static final OpCode A_OP_CODE___326 = new OpCode(107, -1);
  public static final OpCode A_OP_CODE___49 = new OpCode(108, 8);
  public static final OpCode A_OP_CODE___300 = new OpCode(109, 0);

  public static boolean readPacket() {
    try {
      return readPacketInternal();
    } catch (IOException local14) {
      Static165.method2731();

      return true;
    } catch (Exception local19) {
      String local77 =
          "T2 - "
              + (Static300.aOpCode_246 == null ? -1 : Static300.aOpCode_246.method527())
              + ","
              + (Static380.aOpCode_294 == null ? -1 : Static380.aOpCode_294.method527())
              + ","
              + (Static316.aOpCode_257 == null ? -1 : Static316.aOpCode_257.method527())
              + " - "
              + Static454.anInt4075
              + ","
              + (Static1.aClass16_Sub1_Sub5_Sub1_1.anIntArray426[0] + Static180.anInt3453)
              + ","
              + (Static86.anInt1771 + Static1.aClass16_Sub1_Sub5_Sub1_1.anIntArray427[0])
              + " - ";

      for (int i = 0; i < Static454.anInt4075 && i < 50; i++) {
        local77 = local77 + Static146.aClass4_Sub12_Sub1_3.data[i] + ",";
      }

      Static94.handleClientError(local19, local77);
      Static251.method3639();

      return true;
    }
  }

  private static boolean readPacketInternal() throws IOException {
    if (Static125.aServerConnection_5 == null) {
      return false;
    }

    int bytesAvailable = Static125.aServerConnection_5.getEstimatedBytesAvailable();

    if (bytesAvailable == 0) {
      return false;
    }

    int local70;

    if (Static300.aOpCode_246 == null) {
      if (Static330.aBoolean513) {
        Static125.aServerConnection_5.readBytesFromServer(
            0, 1, Static146.aClass4_Sub12_Sub1_3.data);
        bytesAvailable--;
        Static330.aBoolean513 = false;
        Static138.anInt2826++;
      }
      Static146.aClass4_Sub12_Sub1_3.pos = 0;
      if (Static146.aClass4_Sub12_Sub1_3.method1141()) {
        if (bytesAvailable == 0) {
          return false;
        }
        bytesAvailable--;
        Static125.aServerConnection_5.readBytesFromServer(
            1, 1, Static146.aClass4_Sub12_Sub1_3.data);
        Static138.anInt2826++;
      }
      Static330.aBoolean513 = true;
      OpCode[] local66 = getOpcodes();
      local70 = Static146.aClass4_Sub12_Sub1_3.readOpcode();
      if (local70 < 0 || local70 >= local66.length) {
        throw new IOException("invo:" + local70 + " ip:" + Static146.aClass4_Sub12_Sub1_3.pos);
      }
      Static300.aOpCode_246 = local66[local70];
      Static454.anInt4075 = Static300.aOpCode_246.anInt468;
    }

    if (Static454.anInt4075 == -1) {
      if (bytesAvailable <= 0) {
        return false;
      }
      Static125.aServerConnection_5.readBytesFromServer(0, 1, Static146.aClass4_Sub12_Sub1_3.data);
      bytesAvailable--;
      Static138.anInt2826++;
      Static454.anInt4075 = Static146.aClass4_Sub12_Sub1_3.data[0] & 0xFF;
    }
    if (Static454.anInt4075 == -2) {
      if (bytesAvailable <= 1) {
        return false;
      }
      Static125.aServerConnection_5.readBytesFromServer(0, 2, Static146.aClass4_Sub12_Sub1_3.data);
      Static146.aClass4_Sub12_Sub1_3.pos = 0;
      bytesAvailable -= 2;
      Static454.anInt4075 = Static146.aClass4_Sub12_Sub1_3.g2();
      Static138.anInt2826 += 2;
    }
    if (bytesAvailable < Static454.anInt4075) {
      return false;
    }
    Static146.aClass4_Sub12_Sub1_3.pos = 0;
    Static125.aServerConnection_5.readBytesFromServer(
        0, Static454.anInt4075, Static146.aClass4_Sub12_Sub1_3.data);
    Static316.aOpCode_257 = Static380.aOpCode_294;
    Static138.anInt2826 += Static454.anInt4075;
    Static410.anInt6735 = 0;
    Static380.aOpCode_294 = Static35.aOpCode_42;
    Static35.aOpCode_42 = Static300.aOpCode_246;
    if (A_OP_CODE___53 == Static300.aOpCode_246) {
      method2572(Static435.aClass21_17);
      Static300.aOpCode_246 = null;
      return true;
    }
    String local212;
    boolean local206;
    String local210;
    int local224;
    int local228;
    String local251;
    boolean local230;
    if (Static300.aOpCode_246 == A_OP_CODE___125) {
      local206 = Static146.aClass4_Sub12_Sub1_3.g1() == 1;
      local210 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
      local212 = local210;
      if (local206) {
        local212 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
      }
      local224 = Static146.aClass4_Sub12_Sub1_3.g1();
      local228 = Static146.aClass4_Sub12_Sub1_3.g2();
      local230 = false;
      if (local224 <= 1 && Static239.method3549(local212)) {
        local230 = true;
      }
      if (!local230 && Static65.anInt1373 == 0) {
        local251 =
            Static445.aClass81_2.method2258(local228).method234(Static146.aClass4_Sub12_Sub1_3);
        if (local224 == 2) {
          Static426.method5438(
              local228, "<img=1>" + local212, local251, null, 0, "<img=1>" + local210, 25);
        } else if (local224 == 1) {
          Static426.method5438(
              local228, "<img=0>" + local212, local251, null, 0, "<img=0>" + local210, 25);
        } else {
          Static426.method5438(local228, local212, local251, null, 0, local210, 25);
        }
      }
      Static300.aOpCode_246 = null;
      return true;
    }
    int local327;
    int local335;
    if (Static300.aOpCode_246 == A_OP_CODE___254) {
      local327 = Static146.aClass4_Sub12_Sub1_3.g4_alt2();
      local70 = Static146.aClass4_Sub12_Sub1_3.g2();
      local335 = Static146.aClass4_Sub12_Sub1_3.g2();
      if (Static326.method4415(local70)) {
        Static243.method3562(local327, local335);
      }
      Static300.aOpCode_246 = null;
      return true;
    } else if (Static300.aOpCode_246 == A_OP_CODE___191) {
      local327 = Static146.aClass4_Sub12_Sub1_3.g2();
      local210 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
      Object[] local366 = new Object[local210.length() + 1];
      for (local224 = local210.length() - 1; local224 >= 0; local224--) {
        if (local210.charAt(local224) == 's') {
          local366[local224 + 1] = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
        } else {
          local366[local224 + 1] = Integer.valueOf(Static146.aClass4_Sub12_Sub1_3.g4());
        }
      }
      local366[0] = Integer.valueOf(Static146.aClass4_Sub12_Sub1_3.g4());
      if (Static326.method4415(local327)) {
        Node_Sub34 local421 = new Node_Sub34();
        local421.anObjectArray4 = local366;
        Static271.method3894(local421);
      }
      Static300.aOpCode_246 = null;
      return true;
    } else if (A_OP_CODE___241 == Static300.aOpCode_246) {
      method2572(Static309.aClass21_13);
      Static300.aOpCode_246 = null;
      return true;
    } else if (A_OP_CODE___167 == Static300.aOpCode_246) {
      Static230.method3470();
      Static300.aOpCode_246 = null;
      return false;
    } else if (A_OP_CODE___282 == Static300.aOpCode_246) {
      local327 = Static146.aClass4_Sub12_Sub1_3.g1_alt1();
      local70 = Static146.aClass4_Sub12_Sub1_3.g1();
      local335 = Static146.aClass4_Sub12_Sub1_3.g2_alt2();
      if (local335 == 65535) {
        local335 = -1;
      }
      Static427.method5456(local335, local70, local327);
      Static300.aOpCode_246 = null;
      return true;
    } else if (A_OP_CODE___203 == Static300.aOpCode_246) {
      local327 = Static146.aClass4_Sub12_Sub1_3.g3();
      local70 = Static146.aClass4_Sub12_Sub1_3.g2_alt3();
      if (local70 == 65535) {
        local70 = -1;
      }
      local335 = Static146.aClass4_Sub12_Sub1_3.g1();
      Static411.method5274(local335, local327, local70);
      Static300.aOpCode_246 = null;
      return true;
    } else {
      String local535;
      if (Static300.aOpCode_246 == A_OP_CODE___281) {
        local327 = Static146.aClass4_Sub12_Sub1_3.g1_alt3();
        local70 = Static146.aClass4_Sub12_Sub1_3.g1_alt2();
        local335 = Static146.aClass4_Sub12_Sub1_3.g2_alt2();
        if (local335 == 65535) {
          local335 = -1;
        }
        local535 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
        if (local327 >= 1 && local327 <= 8) {
          if (local535.equalsIgnoreCase("null")) {
            local535 = null;
          }
          Static349.aStringArray29[local327 - 1] = local535;
          Static272.anIntArray333[local327 - 1] = local335;
          Static217.aBooleanArray13[local327 - 1] = local70 == 0;
        }
        Static300.aOpCode_246 = null;
        return true;
      } else if (A_OP_CODE___319 == Static300.aOpCode_246) {
        local327 = Static146.aClass4_Sub12_Sub1_3.g1();
        local70 = local327 >> 5;
        local335 = local327 & 0x1F;
        if (local335 == 0) {
          Static306.aClass38Array1[local70] = null;
          Static300.aOpCode_246 = null;
          return true;
        }
        Class38 local610 = new Class38();
        local610.anInt891 = local335;
        local610.anInt886 = Static146.aClass4_Sub12_Sub1_3.g1();
        if (local610.anInt886 >= 0 && local610.anInt886 < Static59.aClass57Array3.length) {
          if (local610.anInt891 == 1 || local610.anInt891 == 10) {
            local610.anInt885 = Static146.aClass4_Sub12_Sub1_3.g2();
            Static146.aClass4_Sub12_Sub1_3.pos += 6;
          } else if (local610.anInt891 >= 2 && local610.anInt891 <= 6) {
            if (local610.anInt891 == 2) {
              local610.anInt894 = 64;
              local610.anInt892 = 64;
            }
            if (local610.anInt891 == 3) {
              local610.anInt894 = 64;
              local610.anInt892 = 0;
            }
            if (local610.anInt891 == 4) {
              local610.anInt894 = 64;
              local610.anInt892 = 128;
            }
            if (local610.anInt891 == 5) {
              local610.anInt894 = 0;
              local610.anInt892 = 64;
            }
            if (local610.anInt891 == 6) {
              local610.anInt894 = 128;
              local610.anInt892 = 64;
            }
            local610.anInt891 = 2;
            local610.anInt887 = Static146.aClass4_Sub12_Sub1_3.g1();
            local610.anInt892 += Static146.aClass4_Sub12_Sub1_3.g2() - Static180.anInt3453 << 7;
            local610.anInt894 += Static146.aClass4_Sub12_Sub1_3.g2() - Static86.anInt1771 << 7;
            local610.anInt895 = Static146.aClass4_Sub12_Sub1_3.g1();
            local610.anInt889 = Static146.aClass4_Sub12_Sub1_3.g2();
          }
          local610.anInt888 = Static146.aClass4_Sub12_Sub1_3.g2();
          if (local610.anInt888 == 65535) {
            local610.anInt888 = -1;
          }
          Static306.aClass38Array1[local70] = local610;
        }
        Static300.aOpCode_246 = null;
        return true;
      } else if (Static300.aOpCode_246 == A_OP_CODE___73) {
        local327 = Static146.aClass4_Sub12_Sub1_3.g2();
        local70 = Static146.aClass4_Sub12_Sub1_3.g2_alt1();
        local335 = Static146.aClass4_Sub12_Sub1_3.g2_alt2();
        if (Static326.method4415(local327)) {
          Static227.method3451(local335, local70);
        }
        Static300.aOpCode_246 = null;
        return true;
      } else {
        String local813;
        if (Static300.aOpCode_246 == A_OP_CODE___45) {
          local813 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
          local70 = Static146.aClass4_Sub12_Sub1_3.g2();
          local212 =
              Static445.aClass81_2.method2258(local70).method234(Static146.aClass4_Sub12_Sub1_3);
          Static426.method5438(local70, local813, local212, null, 0, local813, 19);
          Static300.aOpCode_246 = null;
          return true;
        } else if (A_OP_CODE___232 == Static300.aOpCode_246) {
          local327 = Static146.aClass4_Sub12_Sub1_3.g2_alt2();
          local70 = Static146.aClass4_Sub12_Sub1_3.g2_alt1();
          local335 = Static146.aClass4_Sub12_Sub1_3.g4_alt1();
          if (Static326.method4415(local327)) {
            Static316.method4221(local70, local335);
          }
          Static300.aOpCode_246 = null;
          return true;
        } else if (Static300.aOpCode_246 == A_OP_CODE___336) {
          Static14.anInt189 = Static146.aClass4_Sub12_Sub1_3.g1_alt1();
          Static412.anInt6765 = Static146.aClass4_Sub12_Sub1_3.g1_alt2();
          Static300.aOpCode_246 = null;
          return true;
        } else if (Static300.aOpCode_246 == A_OP_CODE___261) {
          if (Static334.anInt5766 != -1) {
            Static310.method4165(Static334.anInt5766, 0);
          }
          Static300.aOpCode_246 = null;
          return true;
        } else if (A_OP_CODE___268 == Static300.aOpCode_246) {
          local327 = Static146.aClass4_Sub12_Sub1_3.g2_alt3();
          local70 = Static146.aClass4_Sub12_Sub1_3.g4_alt1();
          Static257.aClass114_1.method2828(local70, local327);
          Static300.aOpCode_246 = null;
          return true;
        } else if (A_OP_CODE___98 == Static300.aOpCode_246) {
          Static251.method3639();
          Static300.aOpCode_246 = null;
          return false;
        } else if (A_OP_CODE___218 == Static300.aOpCode_246) {
          local327 = Static146.aClass4_Sub12_Sub1_3.g1();
          local70 = Static146.aClass4_Sub12_Sub1_3.g1_alt2();
          if (local327 == 255) {
            local70 = -1;
            local327 = -1;
          }
          Static442.method5573(local327, local70);
          Static300.aOpCode_246 = null;
          return true;
        } else if (Static300.aOpCode_246 == A_OP_CODE___286) {
          local327 = Static146.aClass4_Sub12_Sub1_3.g4_alt1();
          local70 = Static146.aClass4_Sub12_Sub1_3.g1_alt1();
          local335 = Static146.aClass4_Sub12_Sub1_3.g1_alt3();
          Static160.anIntArray207[local70] = local327;
          Static395.anIntArray502[local70] = local335;
          Static198.anIntArray258[local70] = 1;
          local224 = Static117.anIntArray167[local70] - 1;
          for (local228 = 0; local228 < local224; local228++) {
            if (local327 >= Class126.anIntArray260[local228]) {
              Static198.anIntArray258[local70] = local228 + 2;
            }
          }
          Static39.anIntArray40[Static346.anInt5948++ & 0x1F] = local70;
          Static300.aOpCode_246 = null;
          return true;
        } else if (Static300.aOpCode_246 == A_OP_CODE___120) {
          local327 = Static146.aClass4_Sub12_Sub1_3.g4_alt3();
          local70 = Static146.aClass4_Sub12_Sub1_3.g2();
          if (Static326.method4415(local70)) {
            Static54.method914(3, local327, -1, -1);
          }
          Static300.aOpCode_246 = null;
          return true;
        } else if (Static300.aOpCode_246 == A_OP_CODE___209) {
          local327 = Static146.aClass4_Sub12_Sub1_3.g1();
          local70 = Static146.aClass4_Sub12_Sub1_3.g2_alt1();
          local335 = Static146.aClass4_Sub12_Sub1_3.g2_alt1();
          if (Static326.method4415(local70)) {
            if (local327 == 2) {
              Static436.method5520();
            }
            Static334.anInt5766 = local335;
            Static426.method5439(local335);
            Static327.method4422(false);
            Static271.method3897(Static334.anInt5766);
            for (local224 = 0; local224 < 100; local224++) {
              Static416.aBooleanArray21[local224] = true;
            }
          }
          Static300.aOpCode_246 = null;
          return true;
        } else if (A_OP_CODE___106 == Static300.aOpCode_246) {
          local327 = Static146.aClass4_Sub12_Sub1_3.g4_alt2();
          local70 = Static146.aClass4_Sub12_Sub1_3.g4();
          local335 = Static146.aClass4_Sub12_Sub1_3.g2();
          local224 = Static146.aClass4_Sub12_Sub1_3.g2_alt2();
          if (Static326.method4415(local335)) {
            Static54.method914(5, local327, local224, local70);
          }
          Static300.aOpCode_246 = null;
          return true;
        } else {
          int local1190;
          if (A_OP_CODE___302 == Static300.aOpCode_246) {
            local327 = Static146.aClass4_Sub12_Sub1_3.g2();
            local70 = Static146.aClass4_Sub12_Sub1_3.g2();
            local335 = Static146.aClass4_Sub12_Sub1_3.g2();
            local224 = Static146.aClass4_Sub12_Sub1_3.g2();
            if (Static326.method4415(local327) && Static297.aClass247ArrayArray2[local70] != null) {
              for (local228 = local335; local228 < local224; local228++) {
                local1190 = Static146.aClass4_Sub12_Sub1_3.g3();
                if (local228 < Static297.aClass247ArrayArray2[local70].length
                    && Static297.aClass247ArrayArray2[local70][local228] != null) {
                  Static297.aClass247ArrayArray2[local70][local228].anInt6819 = local1190;
                }
              }
            }
            Static300.aOpCode_246 = null;
            return true;
          }
          long local1252;
          long local1257;
          int local1267;
          int local1263;
          int local1277;
          if (Static300.aOpCode_246 == A_OP_CODE___32) {
            local206 = Static146.aClass4_Sub12_Sub1_3.g1() == 1;
            local210 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
            local212 = local210;
            if (local206) {
              local212 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
            }
            local1252 = Static146.aClass4_Sub12_Sub1_3.g2();
            local1257 = Static146.aClass4_Sub12_Sub1_3.g3();
            local1263 = Static146.aClass4_Sub12_Sub1_3.g1();
            local1267 = Static146.aClass4_Sub12_Sub1_3.g2();
            long local1273 = local1257 + (local1252 << 32);
            boolean local1275 = false;
            local1277 = 0;
            while (true) {
              if (local1277 >= 100) {
                if (local1263 <= 1 && Static239.method3549(local212)) {
                  local1275 = true;
                }
                break;
              }
              if (Static270.aLongArray7[local1277] == local1273) {
                local1275 = true;
                break;
              }
              local1277++;
            }
            if (!local1275 && Static65.anInt1373 == 0) {
              Static270.aLongArray7[Static407.anInt6719] = local1273;
              Static407.anInt6719 = (Static407.anInt6719 + 1) % 100;
              String local1324 =
                  Static445.aClass81_2
                      .method2258(local1267)
                      .method234(Static146.aClass4_Sub12_Sub1_3);
              if (local1263 == 2) {
                Static426.method5438(
                    local1267, "<img=1>" + local212, local1324, null, 0, "<img=1>" + local210, 18);
              } else if (local1263 == 1) {
                Static426.method5438(
                    local1267, "<img=0>" + local212, local1324, null, 0, "<img=0>" + local210, 18);
              } else {
                Static426.method5438(local1267, local212, local1324, null, 0, local210, 18);
              }
            }
            Static300.aOpCode_246 = null;
            return true;
          }
          boolean local1411;
          if (Static300.aOpCode_246 == A_OP_CODE___102) {
            local327 = Static146.aClass4_Sub12_Sub1_3.g2();
            local70 = Static146.aClass4_Sub12_Sub1_3.g1();
            local1411 = (local70 & 0x1) == 1;
            while (Static454.anInt4075 > Static146.aClass4_Sub12_Sub1_3.pos) {
              local224 = Static146.aClass4_Sub12_Sub1_3.gSmart1Or2();
              local228 = Static146.aClass4_Sub12_Sub1_3.g2();
              local1190 = 0;
              if (local228 != 0) {
                local1190 = Static146.aClass4_Sub12_Sub1_3.g1();
                if (local1190 == 255) {
                  local1190 = Static146.aClass4_Sub12_Sub1_3.g4();
                }
              }
              Static153.method2603(local224, local228 - 1, local327, local1190, local1411);
            }
            Static393.anIntArray500[Static140.anInt2841++ & 0x1F] = local327;
            Static300.aOpCode_246 = null;
            return true;
          } else if (A_OP_CODE___159 == Static300.aOpCode_246) {
            if (GameShell.fullScreenFrame != null) {
              Static188.method4107(ClientPreferences.preferences.anInt3447, -1, -1, false);
            }
            byte[] buffer = new byte[Static454.anInt4075];
            Static146.aClass4_Sub12_Sub1_3.readEncryptedBytes(buffer, Static454.anInt4075);
            local210 = CP1252StringTools.CP1252ToUTF8(buffer, Static454.anInt4075, 0);
            Static275.method3929(GameShell.signLink, local210, Static177.anInt2973 == 1, true);
            Static300.aOpCode_246 = null;
            return true;
          } else if (Static300.aOpCode_246 == A_OP_CODE___264) {
            method2572(Static133.aClass21_8);
            Static300.aOpCode_246 = null;
            return true;
          } else if (Static300.aOpCode_246 == A_OP_CODE___160) {
            local327 = Static146.aClass4_Sub12_Sub1_3.g4_alt2();
            local70 = Static146.aClass4_Sub12_Sub1_3.g2_alt1();
            Static257.aClass114_1.method2830(local70, local327);
            Static300.aOpCode_246 = null;
            return true;
          } else {
            Node_Sub43 local1576;
            if (A_OP_CODE___247 == Static300.aOpCode_246) {
              local327 = Static146.aClass4_Sub12_Sub1_3.g1_alt3();
              local70 = Static146.aClass4_Sub12_Sub1_3.g2_alt2();
              local335 = Static146.aClass4_Sub12_Sub1_3.g4();
              local224 = Static146.aClass4_Sub12_Sub1_3.g2_alt1();
              if (Static326.method4415(local70)) {
                local1576 = (Node_Sub43) Static325.aHashMap_29.get((long) local335);
                if (local1576 != null) {
                  Static90.method1606(local224 != local1576.anInt6979, local1576, false);
                }
                Static300.method4092(local224, local327, false, local335);
              }
              Static300.aOpCode_246 = null;
              return true;
            } else if (A_OP_CODE___252 == Static300.aOpCode_246) {
              method2572(Static146.aClass21_2);
              Static300.aOpCode_246 = null;
              return true;
            } else if (A_OP_CODE___223 == Static300.aOpCode_246) {
              local327 = Static146.aClass4_Sub12_Sub1_3.g2_alt2();
              local70 = Static146.aClass4_Sub12_Sub1_3.g2s_alt2();
              local335 = Static146.aClass4_Sub12_Sub1_3.g4_alt3();
              if (Static326.method4415(local327)) {
                Static112.method2033(local70, local335);
              }
              Static300.aOpCode_246 = null;
              return true;
            } else if (A_OP_CODE___324 == Static300.aOpCode_246) {
              local327 = Static146.aClass4_Sub12_Sub1_3.g2();
              local70 = Static146.aClass4_Sub12_Sub1_3.g1_alt3();
              local1411 = (local70 & 0x1) == 1;
              Static150.method2573(local327, local1411);
              Static393.anIntArray500[Static140.anInt2841++ & 0x1F] = local327;
              Static300.aOpCode_246 = null;
              return true;
            } else {
              String local1747;
              if (A_OP_CODE___312 == Static300.aOpCode_246) {
                local206 = Static146.aClass4_Sub12_Sub1_3.g1() == 1;
                local210 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
                local212 = local210;
                if (local206) {
                  local212 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
                }
                local224 = Static146.aClass4_Sub12_Sub1_3.g1();
                boolean local1713 = false;
                if (local224 <= 1) {
                  if (Static109.aBoolean628 && !Static396.aBoolean443 || Static308.aBoolean486) {
                    local1713 = true;
                  } else if (local224 <= 1 && Static239.method3549(local212)) {
                    local1713 = true;
                  }
                }
                if (!local1713 && Static65.anInt1373 == 0) {
                  local1747 =
                      Static22.method297(Static261.method3776(Static146.aClass4_Sub12_Sub1_3));
                  if (local224 == 2) {
                    Static426.method5438(
                        -1, "<img=1>" + local212, local1747, null, 0, "<img=1>" + local210, 24);
                  } else if (local224 == 1) {
                    Static426.method5438(
                        -1, "<img=0>" + local212, local1747, null, 0, "<img=0>" + local210, 24);
                  } else {
                    Static426.method5438(-1, local212, local1747, null, 0, local210, 24);
                  }
                }
                Static300.aOpCode_246 = null;
                return true;
              } else if (Static300.aOpCode_246 == A_OP_CODE___205) {
                method2572(Static183.aClass21_12);
                Static300.aOpCode_246 = null;
                return true;
              } else {
                String local2080;
                boolean local1858;
                boolean local2152;
                if (A_OP_CODE___195 == Static300.aOpCode_246) {
                  while (Static146.aClass4_Sub12_Sub1_3.pos < Static454.anInt4075) {
                    local206 = Static146.aClass4_Sub12_Sub1_3.g1() == 1;
                    local210 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
                    local212 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
                    local224 = Static146.aClass4_Sub12_Sub1_3.g2();
                    local228 = Static146.aClass4_Sub12_Sub1_3.g1();
                    local1747 = "";
                    local1858 = false;
                    if (local224 > 0) {
                      local1747 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
                      local1858 = Static146.aClass4_Sub12_Sub1_3.g1() == 1;
                    }
                    for (local1263 = 0; local1263 < Static49.anInt2346; local1263++) {
                      if (local206) {
                        if (local212.equals(Static194.aStringArray14[local1263])) {
                          Static194.aStringArray14[local1263] = local210;
                          local210 = null;
                          Static57.aStringArray6[local1263] = local212;
                          break;
                        }
                      } else if (local210.equals(Static194.aStringArray14[local1263])) {
                        if (Static71.anIntArray536[local1263] != local224) {
                          Static71.anIntArray536[local1263] = local224;
                          if (local224 > 0) {
                            Static128.method2268(
                                0,
                                5,
                                local210
                                    + Static138.A_LOCALIZED_STRING___54.getString(
                                        ClientSettings.langID),
                                "",
                                "");
                          }
                          if (local224 == 0) {
                            Static128.method2268(
                                0,
                                5,
                                local210
                                    + Static371.A_LOCALIZED_STRING___125.getString(
                                        ClientSettings.langID),
                                "",
                                "");
                          }
                        }
                        Static57.aStringArray6[local1263] = local212;
                        Static433.aStringArray38[local1263] = local1747;
                        Static280.anIntArray339[local1263] = local228;
                        local210 = null;
                        Static424.aBooleanArray23[local1263] = local1858;
                        break;
                      }
                    }
                    if (local210 != null && Static49.anInt2346 < 200) {
                      Static194.aStringArray14[Static49.anInt2346] = local210;
                      Static57.aStringArray6[Static49.anInt2346] = local212;
                      Static71.anIntArray536[Static49.anInt2346] = local224;
                      Static433.aStringArray38[Static49.anInt2346] = local1747;
                      Static280.anIntArray339[Static49.anInt2346] = local228;
                      Static424.aBooleanArray23[Static49.anInt2346] = local1858;
                      Static49.anInt2346++;
                    }
                  }
                  Static376.anInt6277 = 2;
                  Static244.anInt3027 = Static325.anInt5640;
                  local70 = Static49.anInt2346;
                  while (local70 > 0) {
                    local70--;
                    local206 = true;
                    for (local335 = 0; local335 < local70; local335++) {
                      if (Static71.anIntArray536[local335] != WorldManager.worldId
                              && WorldManager.worldId == Static71.anIntArray536[local335 + 1]
                          || Static71.anIntArray536[local335] == 0
                              && Static71.anIntArray536[local335 + 1] != 0) {
                        local224 = Static71.anIntArray536[local335];
                        Static71.anIntArray536[local335] = Static71.anIntArray536[local335 + 1];
                        Static71.anIntArray536[local335 + 1] = local224;
                        local2080 = Static433.aStringArray38[local335];
                        Static433.aStringArray38[local335] = Static433.aStringArray38[local335 + 1];
                        Static433.aStringArray38[local335 + 1] = local2080;
                        local1747 = Static194.aStringArray14[local335];
                        Static194.aStringArray14[local335] = Static194.aStringArray14[local335 + 1];
                        Static194.aStringArray14[local335 + 1] = local1747;
                        local251 = Static57.aStringArray6[local335];
                        Static57.aStringArray6[local335] = Static57.aStringArray6[local335 + 1];
                        Static57.aStringArray6[local335 + 1] = local251;
                        local1263 = Static280.anIntArray339[local335];
                        Static280.anIntArray339[local335] = Static280.anIntArray339[local335 + 1];
                        Static280.anIntArray339[local335 + 1] = local1263;
                        local2152 = Static424.aBooleanArray23[local335];
                        Static424.aBooleanArray23[local335] =
                            Static424.aBooleanArray23[local335 + 1];
                        Static424.aBooleanArray23[local335 + 1] = local2152;
                        local206 = false;
                      }
                    }
                    if (local206) {
                      break;
                    }
                  }
                  Static300.aOpCode_246 = null;
                  return true;
                } else if (Static300.aOpCode_246 == A_OP_CODE___317) {
                  local327 = Static146.aClass4_Sub12_Sub1_3.g2_alt1();
                  if (local327 == 65535) {
                    local327 = -1;
                  }
                  local70 = Static146.aClass4_Sub12_Sub1_3.g4();
                  local335 = Static146.aClass4_Sub12_Sub1_3.g2_alt2();
                  if (Static326.method4415(local335)) {
                    Static79.method1399(local327, local70);
                  }
                  Static300.aOpCode_246 = null;
                  return true;
                } else if (A_OP_CODE___200 == Static300.aOpCode_246) {
                  Static189.method2942(Static146.aClass4_Sub12_Sub1_3, Static454.anInt4075);
                  Static300.aOpCode_246 = null;
                  return true;
                } else if (Static300.aOpCode_246 == A_OP_CODE___17) {
                  local327 = Static146.aClass4_Sub12_Sub1_3.g2();
                  local70 = Static146.aClass4_Sub12_Sub1_3.g1();
                  Static257.aClass114_1.method2828(local70, local327);
                  Static300.aOpCode_246 = null;
                  return true;
                } else {
                  long local2311;
                  Node_Sub33 local2329;
                  Node_Sub33 local2317;
                  if (A_OP_CODE___311 == Static300.aOpCode_246) {
                    local327 = Static146.aClass4_Sub12_Sub1_3.g2_alt3();
                    if (local327 == 65535) {
                      local327 = -1;
                    }
                    local70 = Static146.aClass4_Sub12_Sub1_3.g4_alt3();
                    local335 = Static146.aClass4_Sub12_Sub1_3.g2();
                    local224 = Static146.aClass4_Sub12_Sub1_3.g4();
                    local228 = Static146.aClass4_Sub12_Sub1_3.g2_alt1();
                    if (local228 == 65535) {
                      local228 = -1;
                    }
                    if (Static326.method4415(local335)) {
                      for (local1190 = local327; local1190 <= local228; local1190++) {
                        local2311 = ((long) local224 << 32) + (long) local1190;
                        local2317 = (Node_Sub33) Static211.A_HASH_MAP___18.get(local2311);
                        if (local2317 != null) {
                          local2329 = new Node_Sub33(local70, local2317.anInt5110);
                          local2317.popSelf();
                        } else if (local1190 == -1) {
                          local2329 =
                              new Node_Sub33(
                                  local70,
                                  Static392.method5121(local224).aClass4_Sub33_2.anInt5110);
                        } else {
                          local2329 = new Node_Sub33(local70, -1);
                        }
                        Static211.A_HASH_MAP___18.set(local2311, local2329);
                      }
                    }
                    Static300.aOpCode_246 = null;
                    return true;
                  } else if (A_OP_CODE___96 == Static300.aOpCode_246) {
                    Static154.anInt813 = Static146.aClass4_Sub12_Sub1_3.g1s_alt3() << 3;
                    Static385.anInt6487 = Static146.aClass4_Sub12_Sub1_3.g1s() << 3;
                    Static113.anInt2426 = Static146.aClass4_Sub12_Sub1_3.g1_alt2();
                    Static300.aOpCode_246 = null;
                    return true;
                  } else if (A_OP_CODE___306 == Static300.aOpCode_246) {
                    Static17.anInt223 = Static146.aClass4_Sub12_Sub1_3.g2s();
                    Static308.anInt5413 = Static325.anInt5640;
                    Static300.aOpCode_246 = null;
                    return true;
                  } else if (Static300.aOpCode_246 == A_OP_CODE___152) {
                    local327 = Static146.aClass4_Sub12_Sub1_3.g1_alt3();
                    local70 = Static146.aClass4_Sub12_Sub1_3.g2_alt3();
                    if (Static326.method4415(local70)) {
                      Static268.anInt4991 = local327;
                    }
                    Static300.aOpCode_246 = null;
                    return true;
                  } else {
                    int local2473;
                    int local2494;
                    int local2648;
                    int local3138;
                    if (A_OP_CODE___290 == Static300.aOpCode_246) {
                      local327 = Static146.aClass4_Sub12_Sub1_3.g2_alt1();
                      local70 = Static146.aClass4_Sub12_Sub1_3.g2_alt2();
                      local335 = Static146.aClass4_Sub12_Sub1_3.g4_alt3();
                      local224 = Static146.aClass4_Sub12_Sub1_3.g2_alt2();
                      local228 = Static146.aClass4_Sub12_Sub1_3.g1_alt1();
                      local230 = (local228 & 0x80) != 0;
                      if (local335 >> 30 == 0) {
                        Class161 local2515;
                        Class138 local2573;
                        Class161 local2520;
                        Class138 local2535;
                        Class138 local2541;
                        if (local335 >> 29 != 0) {
                          local2473 = local335 & 0xFFFF;
                          Class16_Sub1_Sub5_Sub2 local2477 =
                              Static143.aClass16_Sub1_Sub5_Sub2Array1[local2473];
                          if (local2477 != null) {
                            if (local70 == 65535) {
                              local70 = -1;
                            }
                            local2152 = true;
                            local2494 = local230 ? local2477.anInt6045 : local2477.anInt6029;
                            if (local70 != -1 && local2494 != -1) {
                              if (local70 == local2494) {
                                local2515 = Static352.aClass194_2.method4421(local70);
                                if (local2515.aBoolean459 && local2515.anInt5002 != -1) {
                                  local2573 = Static182.aClass55_1.method1397(local2515.anInt5002);
                                  local1277 = local2573.anInt4406;
                                  if (local1277 == 0 || local1277 == 2) {
                                    local2152 = false;
                                  } else if (local1277 == 1) {
                                    local2152 = true;
                                  }
                                }
                              } else {
                                local2515 = Static352.aClass194_2.method4421(local70);
                                local2520 = Static352.aClass194_2.method4421(local2494);
                                if (local2515.anInt5002 != -1 && local2520.anInt5002 != -1) {
                                  local2535 = Static182.aClass55_1.method1397(local2515.anInt5002);
                                  local2541 = Static182.aClass55_1.method1397(local2520.anInt5002);
                                  if (local2541.anInt4413 > local2535.anInt4413) {
                                    local2152 = false;
                                  }
                                }
                              }
                            }
                            if (local2152) {
                              if (local230) {
                                local2477.anInt6022 = 0;
                                local2477.anInt6066 = local327 + client.gameLogicStepCount;
                                local2477.anInt6053 = local224;
                                local2477.anInt6069 = 1;
                                local2477.anInt6062 = 0;
                                local2477.anInt6056 = local228 & 0x7;
                                local2477.anInt6045 = local70;
                                if (local2477.anInt6066 > client.gameLogicStepCount) {
                                  local2477.anInt6022 = -1;
                                }
                                if (local2477.anInt6045 != -1
                                    && client.gameLogicStepCount == local2477.anInt6066) {
                                  local2648 =
                                      Static352.aClass194_2.method4421(local2477.anInt6045)
                                          .anInt5002;
                                  if (local2648 != -1) {
                                    local2573 = Static182.aClass55_1.method1397(local2648);
                                    if (local2573 != null && local2573.anIntArray295 != null) {
                                      Static15.method156(
                                          local2477.anInt6893,
                                          0,
                                          local2477.aByte82,
                                          local2477.anInt6892,
                                          local2573,
                                          false);
                                    }
                                  }
                                }
                              } else {
                                local2477.anInt6014 = local224;
                                local2477.anInt6027 = 0;
                                local2477.anInt6083 = 1;
                                local2477.anInt6029 = local70;
                                local2477.anInt6017 = local228 & 0x7;
                                local2477.anInt6057 = local327 + client.gameLogicStepCount;
                                local2477.anInt6033 = 0;
                                if (local2477.anInt6057 > client.gameLogicStepCount) {
                                  local2477.anInt6027 = -1;
                                }
                                if (local2477.anInt6029 != -1
                                    && client.gameLogicStepCount == local2477.anInt6057) {
                                  local2648 =
                                      Static352.aClass194_2.method4421(local2477.anInt6029)
                                          .anInt5002;
                                  if (local2648 != -1) {
                                    local2573 = Static182.aClass55_1.method1397(local2648);
                                    if (local2573 != null && local2573.anIntArray295 != null) {
                                      Static15.method156(
                                          local2477.anInt6893,
                                          0,
                                          local2477.aByte82,
                                          local2477.anInt6892,
                                          local2573,
                                          false);
                                    }
                                  }
                                }
                              }
                            }
                          }
                        } else if (local335 >> 28 != 0) {
                          local2473 = local335 & 0xFFFF;
                          Class16_Sub1_Sub5_Sub1 local2773;
                          if (Static207.anInt5452 == local2473) {
                            local2773 = Static1.aClass16_Sub1_Sub5_Sub1_1;
                          } else {
                            local2773 = Static267.aClass16_Sub1_Sub5_Sub1Array1[local2473];
                          }
                          if (local2773 != null) {
                            if (local70 == 65535) {
                              local70 = -1;
                            }
                            local2152 = true;
                            local2494 = local230 ? local2773.anInt6045 : local2773.anInt6029;
                            if (local70 != -1 && local2494 != -1) {
                              if (local70 == local2494) {
                                local2515 = Static352.aClass194_2.method4421(local70);
                                if (local2515.aBoolean459 && local2515.anInt5002 != -1) {
                                  local2573 = Static182.aClass55_1.method1397(local2515.anInt5002);
                                  local1277 = local2573.anInt4406;
                                  if (local1277 == 0 || local1277 == 2) {
                                    local2152 = false;
                                  } else if (local1277 == 1) {
                                    local2152 = true;
                                  }
                                }
                              } else {
                                local2515 = Static352.aClass194_2.method4421(local70);
                                local2520 = Static352.aClass194_2.method4421(local2494);
                                if (local2515.anInt5002 != -1 && local2520.anInt5002 != -1) {
                                  local2535 = Static182.aClass55_1.method1397(local2515.anInt5002);
                                  local2541 = Static182.aClass55_1.method1397(local2520.anInt5002);
                                  if (local2541.anInt4413 > local2535.anInt4413) {
                                    local2152 = false;
                                  }
                                }
                              }
                            }
                            if (local2152) {
                              if (local230) {
                                local2773.anInt6056 = local228 & 0x7;
                                local2773.anInt6045 = local70;
                                local2773.anInt6053 = local224;
                                local2773.anInt6069 = 1;
                                local2773.anInt6066 = local327 + client.gameLogicStepCount;
                                local2773.anInt6022 = 0;
                                local2773.anInt6062 = 0;
                                if (local2773.anInt6045 == 65535) {
                                  local2773.anInt6045 = -1;
                                }
                                if (local2773.anInt6066 > client.gameLogicStepCount) {
                                  local2773.anInt6022 = -1;
                                }
                                if (local2773.anInt6045 != -1
                                    && local2773.anInt6066 == client.gameLogicStepCount) {
                                  local2648 =
                                      Static352.aClass194_2.method4421(local2773.anInt6045)
                                          .anInt5002;
                                  if (local2648 != -1) {
                                    local2573 = Static182.aClass55_1.method1397(local2648);
                                    if (local2573 != null && local2573.anIntArray295 != null) {
                                      Static15.method156(
                                          local2773.anInt6893,
                                          0,
                                          local2773.aByte82,
                                          local2773.anInt6892,
                                          local2573,
                                          local2773 == Static1.aClass16_Sub1_Sub5_Sub1_1);
                                    }
                                  }
                                }
                              } else {
                                local2773.anInt6017 = local228 & 0x7;
                                local2773.anInt6033 = 0;
                                local2773.anInt6014 = local224;
                                local2773.anInt6083 = 1;
                                local2773.anInt6029 = local70;
                                local2773.anInt6057 = client.gameLogicStepCount + local327;
                                local2773.anInt6027 = 0;
                                if (local2773.anInt6029 == 65535) {
                                  local2773.anInt6029 = -1;
                                }
                                if (local2773.anInt6057 > client.gameLogicStepCount) {
                                  local2773.anInt6027 = -1;
                                }
                                if (local2773.anInt6029 != -1
                                    && local2773.anInt6057 == client.gameLogicStepCount) {
                                  local2648 =
                                      Static352.aClass194_2.method4421(local2773.anInt6029)
                                          .anInt5002;
                                  if (local2648 != -1) {
                                    local2573 = Static182.aClass55_1.method1397(local2648);
                                    if (local2573 != null && local2573.anIntArray295 != null) {
                                      Static15.method156(
                                          local2773.anInt6893,
                                          0,
                                          local2773.aByte82,
                                          local2773.anInt6892,
                                          local2573,
                                          Static1.aClass16_Sub1_Sub5_Sub1_1 == local2773);
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      } else {
                        local2473 = local335 >> 28 & 0x3;
                        local1263 = (local335 >> 14 & 0x3FFF) - Static180.anInt3453;
                        local1267 = (local335 & 0x3FFF) - Static86.anInt1771;
                        if (local1263 >= 0
                            && local1267 >= 0
                            && Static326.anInt5666 > local1263
                            && Static283.anInt5187 > local1267) {
                          local2494 = local1263 * 128 + 64;
                          local2648 = local1267 * 128 + 64;
                          local3138 = local2473;
                          if (local2473 < 3 && Static378.method3229(local1263, local1267)) {
                            local3138 = local2473 + 1;
                          }
                          Class16_Sub1_Sub2 local3173 =
                              new Class16_Sub1_Sub2(
                                  local70,
                                  0,
                                  client.gameLogicStepCount,
                                  local2473,
                                  local3138,
                                  local2494,
                                  Static13.method135(local2494, local2473, local2648) - local224,
                                  local2648,
                                  local1263,
                                  local1263,
                                  local1267,
                                  local1267,
                                  local228);
                          Static292.A_LINKED_LIST___36.addFirst(
                              new SecondaryNode_Sub1_Sub10(local3173));
                        }
                      }
                      Static300.aOpCode_246 = null;
                      return true;
                    } else if (Static300.aOpCode_246 == A_OP_CODE___292) {
                      local327 = Static146.aClass4_Sub12_Sub1_3.g2();
                      local70 = Static146.aClass4_Sub12_Sub1_3.g1();
                      local1411 = (local70 & 0x1) == 1;
                      Static171.method2796(local327, local1411);
                      local224 = Static146.aClass4_Sub12_Sub1_3.g2();
                      for (local228 = 0; local228 < local224; local228++) {
                        local1190 = Static146.aClass4_Sub12_Sub1_3.g1_alt3();
                        if (local1190 == 255) {
                          local1190 = Static146.aClass4_Sub12_Sub1_3.g4_alt1();
                        }
                        local2473 = Static146.aClass4_Sub12_Sub1_3.g2();
                        Static153.method2603(
                            local228, local2473 - 1, local327, local1190, local1411);
                      }
                      Static393.anIntArray500[Static140.anInt2841++ & 0x1F] = local327;
                      Static300.aOpCode_246 = null;
                      return true;
                    } else if (Static300.aOpCode_246 == A_OP_CODE___325) {
                      local813 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
                      local210 =
                          Static22.method297(Static261.method3776(Static146.aClass4_Sub12_Sub1_3));
                      Static128.method2268(0, 6, local210, local813, local813);
                      Static300.aOpCode_246 = null;
                      return true;
                    } else if (Static300.aOpCode_246 == A_OP_CODE___248) {
                      local327 = Static146.aClass4_Sub12_Sub1_3.g2_alt1();
                      local70 = Static146.aClass4_Sub12_Sub1_3.g2_alt2();
                      if (local70 == 65535) {
                        local70 = -1;
                      }
                      local335 = Static146.aClass4_Sub12_Sub1_3.g4();
                      local224 = Static146.aClass4_Sub12_Sub1_3.g4_alt2();
                      if (Static326.method4415(local327)) {
                        Static119.method2150(local224, local335, local70);
                        Class211 local3326 = Static444.aClass206_3.method4703(local70);
                        Static94.method1652(
                            local224,
                            local3326.anInt6122,
                            local3326.anInt6133,
                            local3326.anInt6137);
                        Static67.method1274(
                            local3326.anInt6152, local3326.lb, local224, local3326.anInt6135);
                      }
                      Static300.aOpCode_246 = null;
                      return true;
                    } else if (Static300.aOpCode_246 == A_OP_CODE___157) {
                      local327 = Static146.aClass4_Sub12_Sub1_3.g2_alt1();
                      local70 = Static146.aClass4_Sub12_Sub1_3.g2_alt3();
                      local335 = Static146.aClass4_Sub12_Sub1_3.g2();
                      local224 = Static146.aClass4_Sub12_Sub1_3.g2_alt2();
                      local228 = Static146.aClass4_Sub12_Sub1_3.g4_alt2();
                      if (Static326.method4415(local224)) {
                        Static54.method914(7, local228, local70 | local335 << 16, local327);
                      }
                      Static300.aOpCode_246 = null;
                      return true;
                    } else if (Static300.aOpCode_246 == A_OP_CODE___11) {
                      local327 = Static146.aClass4_Sub12_Sub1_3.g2_alt2();
                      local70 = Static146.aClass4_Sub12_Sub1_3.g2_alt2();
                      local335 = Static146.aClass4_Sub12_Sub1_3.g4();
                      local224 = Static146.aClass4_Sub12_Sub1_3.g2_alt1();
                      local228 = Static146.aClass4_Sub12_Sub1_3.g2();
                      if (Static326.method4415(local327)) {
                        Static94.method1652(local335, local228, local224, local70);
                      }
                      Static300.aOpCode_246 = null;
                      return true;
                    } else if (Static300.aOpCode_246 == A_OP_CODE___94) {
                      Static124.method2241(true);
                      Static300.aOpCode_246 = null;
                      return true;
                    } else if (A_OP_CODE___245 == Static300.aOpCode_246) {
                      local327 = Static146.aClass4_Sub12_Sub1_3.g2();
                      byte local3451 = Static146.aClass4_Sub12_Sub1_3.g1s_alt2();
                      Static257.aClass114_1.method2830(local327, local3451);
                      Static300.aOpCode_246 = null;
                      return true;
                    } else if (A_OP_CODE___23 == Static300.aOpCode_246) {
                      local327 = Static146.aClass4_Sub12_Sub1_3.g1();
                      if (Static146.aClass4_Sub12_Sub1_3.g1() == 0) {
                        Static408.aClass28Array1[local327] = new Class28();
                      } else {
                        Static146.aClass4_Sub12_Sub1_3.pos--;
                        Static408.aClass28Array1[local327] =
                            new Class28(Static146.aClass4_Sub12_Sub1_3);
                      }
                      Static246.anInt4589 = Static325.anInt5640;
                      Static300.aOpCode_246 = null;
                      return true;
                    } else if (Static300.aOpCode_246 == A_OP_CODE___150) {
                      local206 = Static146.aClass4_Sub12_Sub1_3.g1() == 1;
                      local210 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
                      local212 = local210;
                      if (local206) {
                        local212 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
                      }
                      local1252 = Static146.aClass4_Sub12_Sub1_3.g2();
                      local1257 = Static146.aClass4_Sub12_Sub1_3.g3();
                      local1263 = Static146.aClass4_Sub12_Sub1_3.g1();
                      long local3544 = (local1252 << 32) + local1257;
                      boolean local3546 = false;
                      local3138 = 0;
                      while (true) {
                        if (local3138 >= 100) {
                          if (local1263 <= 1) {
                            if (Static109.aBoolean628 && !Static396.aBoolean443
                                || Static308.aBoolean486) {
                              local3546 = true;
                            } else if (Static239.method3549(local212)) {
                              local3546 = true;
                            }
                          }
                          break;
                        }
                        if (local3544 == Static270.aLongArray7[local3138]) {
                          local3546 = true;
                          break;
                        }
                        local3138++;
                      }
                      if (!local3546 && Static65.anInt1373 == 0) {
                        Static270.aLongArray7[Static407.anInt6719] = local3544;
                        Static407.anInt6719 = (Static407.anInt6719 + 1) % 100;
                        String local3605 =
                            Static22.method297(
                                Static261.method3776(Static146.aClass4_Sub12_Sub1_3));
                        if (local1263 == 2) {
                          Static426.method5438(
                              -1,
                              "<img=1>" + local212,
                              local3605,
                              null,
                              0,
                              "<img=1>" + local210,
                              7);
                        } else if (local1263 == 1) {
                          Static426.method5438(
                              -1,
                              "<img=0>" + local212,
                              local3605,
                              null,
                              0,
                              "<img=0>" + local210,
                              7);
                        } else {
                          Static426.method5438(-1, local212, local3605, null, 0, local210, 3);
                        }
                      }
                      Static300.aOpCode_246 = null;
                      return true;
                    } else if (A_OP_CODE___212 == Static300.aOpCode_246) {
                      local327 = Static146.aClass4_Sub12_Sub1_3.g2_alt1();
                      local70 = Static146.aClass4_Sub12_Sub1_3.g1_alt1();
                      local335 = Static146.aClass4_Sub12_Sub1_3.g2_alt1();
                      Class16_Sub1_Sub5_Sub2 local3691 =
                          Static143.aClass16_Sub1_Sub5_Sub2Array1[local327];
                      if (local3691 != null) {
                        Static33.method632(local335, local70, local3691);
                      }
                      Static300.aOpCode_246 = null;
                      return true;
                    } else if (A_OP_CODE___72 == Static300.aOpCode_246) {
                      Static413.anInt6823 = Static146.aClass4_Sub12_Sub1_3.g1();
                      for (local327 = 0; local327 < Static413.anInt6823; local327++) {
                        Static326.aStringArray27[local327] =
                            Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
                        Static102.aStringArray7[local327] =
                            Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
                        if (Static102.aStringArray7[local327].equals("")) {
                          Static102.aStringArray7[local327] = Static326.aStringArray27[local327];
                        }
                        Static315.aStringArray26[local327] =
                            Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
                        Static141.aStringArray11[local327] =
                            Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
                        if (Static141.aStringArray11[local327].equals("")) {
                          Static141.aStringArray11[local327] = Static315.aStringArray26[local327];
                        }
                        Static414.aBooleanArray20[local327] = false;
                      }
                      Static300.aOpCode_246 = null;
                      Static244.anInt3027 = Static325.anInt5640;
                      return true;
                    } else {
                      long local3817;
                      if (A_OP_CODE___328 == Static300.aOpCode_246) {
                        local206 = Static146.aClass4_Sub12_Sub1_3.g1() == 1;
                        local210 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
                        local212 = local210;
                        if (local206) {
                          local212 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
                        }
                        local1252 = Static146.aClass4_Sub12_Sub1_3.g8();
                        local1257 = Static146.aClass4_Sub12_Sub1_3.g2();
                        local3817 = Static146.aClass4_Sub12_Sub1_3.g3();
                        local2494 = Static146.aClass4_Sub12_Sub1_3.g1();
                        local2648 = Static146.aClass4_Sub12_Sub1_3.g2();
                        long local3832 = (local1257 << 32) + local3817;
                        boolean local3834 = false;
                        int local3836 = 0;
                        while (true) {
                          if (local3836 >= 100) {
                            if (local2494 <= 1 && Static239.method3549(local212)) {
                              local3834 = true;
                            }
                            break;
                          }
                          if (Static270.aLongArray7[local3836] == local3832) {
                            local3834 = true;
                            break;
                          }
                          local3836++;
                        }
                        if (!local3834 && Static65.anInt1373 == 0) {
                          Static270.aLongArray7[Static407.anInt6719] = local3832;
                          Static407.anInt6719 = (Static407.anInt6719 + 1) % 100;
                          String local3889 =
                              Static445.aClass81_2
                                  .method2258(local2648)
                                  .method234(Static146.aClass4_Sub12_Sub1_3);
                          if (local2494 == 2) {
                            Static426.method5438(
                                local2648,
                                "<img=1>" + local212,
                                local3889,
                                Static45.method766(local1252),
                                0,
                                "<img=1>" + local210,
                                20);
                          } else if (local2494 == 1) {
                            Static426.method5438(
                                local2648,
                                "<img=0>" + local212,
                                local3889,
                                Static45.method766(local1252),
                                0,
                                "<img=0>" + local210,
                                20);
                          } else {
                            Static426.method5438(
                                local2648,
                                local212,
                                local3889,
                                Static45.method766(local1252),
                                0,
                                local210,
                                20);
                          }
                        }
                        Static300.aOpCode_246 = null;
                        return true;
                      } else if (A_OP_CODE___300 == Static300.aOpCode_246) {
                        for (local327 = 0;
                            local327 < Static267.aClass16_Sub1_Sub5_Sub1Array1.length;
                            local327++) {
                          if (Static267.aClass16_Sub1_Sub5_Sub1Array1[local327] != null) {
                            Static267.aClass16_Sub1_Sub5_Sub1Array1[local327].anInt6021 = -1;
                          }
                        }
                        for (local70 = 0;
                            local70 < Static143.aClass16_Sub1_Sub5_Sub2Array1.length;
                            local70++) {
                          if (Static143.aClass16_Sub1_Sub5_Sub2Array1[local70] != null) {
                            Static143.aClass16_Sub1_Sub5_Sub2Array1[local70].anInt6021 = -1;
                          }
                        }
                        Static300.aOpCode_246 = null;
                        return true;
                      } else if (A_OP_CODE___251 == Static300.aOpCode_246) {
                        local327 = Static146.aClass4_Sub12_Sub1_3.g2();
                        if (Static326.method4415(local327)) {
                          Static54.method913();
                        }
                        Static300.aOpCode_246 = null;
                        return true;
                      } else {
                        Class15 local4235;
                        if (A_OP_CODE___277 == Static300.aOpCode_246) {
                          Static381.anInt6418 = Static325.anInt5640;
                          if (Static454.anInt4075 == 0) {
                            Static221.aString39 = null;
                            Static300.aOpCode_246 = null;
                            GameShell.aClass15Array2 = null;
                            Static290.anInt6410 = 0;
                            Static395.aString63 = null;
                            return true;
                          }
                          Static395.aString63 =
                              Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
                          local206 = Static146.aClass4_Sub12_Sub1_3.g1() == 1;
                          if (local206) {
                            Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
                          }
                          long local4078 = Static146.aClass4_Sub12_Sub1_3.g8();
                          Static221.aString39 = Static44.method763(local4078);
                          Static446.aByte103 = Static146.aClass4_Sub12_Sub1_3.g1s();
                          local224 = Static146.aClass4_Sub12_Sub1_3.g1();
                          if (local224 == 255) {
                            Static300.aOpCode_246 = null;
                            return true;
                          }
                          Static290.anInt6410 = local224;
                          Class15[] local4104 = new Class15[100];
                          for (local1190 = 0; local1190 < Static290.anInt6410; local1190++) {
                            local4104[local1190] = new Class15();
                            local4104[local1190].aString8 =
                                Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
                            local206 = Static146.aClass4_Sub12_Sub1_3.g1() == 1;
                            if (local206) {
                              local4104[local1190].aString7 =
                                  Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
                            } else {
                              local4104[local1190].aString7 = local4104[local1190].aString8;
                            }
                            local4104[local1190].aString6 =
                                Static123.method4868(local4104[local1190].aString7);
                            local4104[local1190].anInt272 = Static146.aClass4_Sub12_Sub1_3.g2();
                            local4104[local1190].aByte1 = Static146.aClass4_Sub12_Sub1_3.g1s();
                            local4104[local1190].aString5 =
                                Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
                            if (local4104[local1190].aString7.equals(
                                Static1.aClass16_Sub1_Sub5_Sub1_1.aString44)) {
                              Static160.aByte18 = local4104[local1190].aByte1;
                            }
                          }
                          local1267 = Static290.anInt6410;
                          while (local1267 > 0) {
                            local1858 = true;
                            local1267--;
                            for (local2494 = 0; local2494 < local1267; local2494++) {
                              if (local4104[local2494].aString6.compareTo(
                                      local4104[local2494 + 1].aString6)
                                  > 0) {
                                local4235 = local4104[local2494];
                                local4104[local2494] = local4104[local2494 + 1];
                                local1858 = false;
                                local4104[local2494 + 1] = local4235;
                              }
                            }
                            if (local1858) {
                              break;
                            }
                          }
                          GameShell.aClass15Array2 = local4104;
                          Static300.aOpCode_246 = null;
                          return true;
                        } else if (A_OP_CODE___307 == Static300.aOpCode_246) {
                          Static257.aClass114_1.method2829();
                          Static292.anInt5255 += 32;
                          Static300.aOpCode_246 = null;
                          return true;
                        } else if (Static300.aOpCode_246 == A_OP_CODE___196) {
                          local327 = Static146.aClass4_Sub12_Sub1_3.g2_alt1();
                          local70 = Static146.aClass4_Sub12_Sub1_3.g2_alt3();
                          if (local70 == 65535) {
                            local70 = -1;
                          }
                          local335 = Static146.aClass4_Sub12_Sub1_3.g4_alt3();
                          if (Static326.method4415(local327)) {
                            Static54.method914(1, local335, local70, -1);
                          }
                          Static300.aOpCode_246 = null;
                          return true;
                        } else if (Static300.aOpCode_246 == A_OP_CODE___327) {
                          local327 = Static146.aClass4_Sub12_Sub1_3.g4();
                          local70 = Static146.aClass4_Sub12_Sub1_3.g2_alt2();
                          if (Static326.method4415(local70)) {
                            Static54.method914(5, local327, Static207.anInt5452, 0);
                          }
                          Static300.aOpCode_246 = null;
                          return true;
                        } else if (Static300.aOpCode_246 == A_OP_CODE___173) {
                          local327 = Static146.aClass4_Sub12_Sub1_3.g2();
                          local70 = Static146.aClass4_Sub12_Sub1_3.g1();
                          local335 = Static146.aClass4_Sub12_Sub1_3.g1();
                          local224 = Static146.aClass4_Sub12_Sub1_3.g2() << 0;
                          local228 = Static146.aClass4_Sub12_Sub1_3.g1();
                          local1190 = Static146.aClass4_Sub12_Sub1_3.g1();
                          if (Static326.method4415(local327)) {
                            Static313.method4175(local1190, local224, local335, local228, local70);
                          }
                          Static300.aOpCode_246 = null;
                          return true;
                        } else if (Static300.aOpCode_246 == A_OP_CODE___316) {
                          Static300.aOpCode_246 = null;
                          Static244.anInt3027 = Static325.anInt5640;
                          Static376.anInt6277 = 1;
                          return true;
                        } else if (A_OP_CODE___310 == Static300.aOpCode_246) {
                          local327 = Static146.aClass4_Sub12_Sub1_3.g1();
                          boolean local4427 = (local327 & 0x1) == 1;
                          local212 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
                          local535 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
                          if (local535.equals("")) {
                            local535 = local212;
                          }
                          local2080 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
                          local1747 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
                          if (local1747.equals("")) {
                            local1747 = local2080;
                          }
                          if (local4427) {
                            for (local2473 = 0; local2473 < Static413.anInt6823; local2473++) {
                              if (Static102.aStringArray7[local2473].equals(local1747)) {
                                Static326.aStringArray27[local2473] = local212;
                                Static102.aStringArray7[local2473] = local535;
                                Static315.aStringArray26[local2473] = local2080;
                                Static141.aStringArray11[local2473] = local1747;
                                break;
                              }
                            }
                          } else {
                            Static326.aStringArray27[Static413.anInt6823] = local212;
                            Static102.aStringArray7[Static413.anInt6823] = local535;
                            Static315.aStringArray26[Static413.anInt6823] = local2080;
                            Static141.aStringArray11[Static413.anInt6823] = local1747;
                            Static414.aBooleanArray20[Static413.anInt6823] = (local327 & 0x2) == 2;
                            Static413.anInt6823++;
                          }
                          Static300.aOpCode_246 = null;
                          Static244.anInt3027 = Static325.anInt5640;
                          return true;
                        } else if (Static300.aOpCode_246 == A_OP_CODE___33) {
                          Static92.anInt1847 = Static146.aClass4_Sub12_Sub1_3.g1();
                          Static300.aOpCode_246 = null;
                          Static308.anInt5413 = Static325.anInt5640;
                          return true;
                        } else if (Static300.aOpCode_246 == A_OP_CODE___144) {
                          Static188.anInt5353 = Static146.aClass4_Sub12_Sub1_3.g2() * 30;
                          Static300.aOpCode_246 = null;
                          Static308.anInt5413 = Static325.anInt5640;
                          return true;
                        } else if (A_OP_CODE___80 == Static300.aOpCode_246) {
                          local813 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
                          local70 = Static146.aClass4_Sub12_Sub1_3.g2();
                          local335 = Static146.aClass4_Sub12_Sub1_3.g4_alt3();
                          if (Static326.method4415(local70)) {
                            Static79.method1398(local813, local335);
                          }
                          Static300.aOpCode_246 = null;
                          return true;
                        } else if (Static300.aOpCode_246 == A_OP_CODE___204) {
                          method2572(Static294.aClass21_4);
                          Static300.aOpCode_246 = null;
                          return true;
                        } else if (A_OP_CODE___146 == Static300.aOpCode_246) {
                          local327 = Static146.aClass4_Sub12_Sub1_3.g2_alt2();
                          local210 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
                          local335 = Static146.aClass4_Sub12_Sub1_3.g2();
                          if (Static326.method4415(local335)) {
                            Static244.method2569(local210, local327);
                          }
                          Static300.aOpCode_246 = null;
                          return true;
                        } else if (A_OP_CODE___117 == Static300.aOpCode_246) {
                          local327 = Static146.aClass4_Sub12_Sub1_3.g4();
                          local70 = Static146.aClass4_Sub12_Sub1_3.g2();
                          local335 = Static146.aClass4_Sub12_Sub1_3.g2_alt1();
                          if (Static326.method4415(local335)) {
                            Static14.method145(local327, local70);
                          }
                          Static300.aOpCode_246 = null;
                          return true;
                        } else if (A_OP_CODE___332 == Static300.aOpCode_246) {
                          Static211.method3203();
                          Static300.aOpCode_246 = null;
                          return false;
                        } else if (Static300.aOpCode_246 == A_OP_CODE___185) {
                          local327 = Static146.aClass4_Sub12_Sub1_3.g2();
                          local70 = Static146.aClass4_Sub12_Sub1_3.g4_alt3();
                          local335 = Static146.aClass4_Sub12_Sub1_3.g2_alt2();
                          if (Static326.method4415(local327)) {
                            Static164.method3585(local335, local70);
                          }
                          Static300.aOpCode_246 = null;
                          return true;
                        } else if (Static300.aOpCode_246 == A_OP_CODE___194) {
                          Static154.anInt813 = Static146.aClass4_Sub12_Sub1_3.g1s_alt3() << 3;
                          Static385.anInt6487 = Static146.aClass4_Sub12_Sub1_3.g1s() << 3;
                          Static113.anInt2426 = Static146.aClass4_Sub12_Sub1_3.g1_alt2();
                          while (Static454.anInt4075 > Static146.aClass4_Sub12_Sub1_3.pos) {
                            Class21 local4723 =
                                Static448.method5650()[Static146.aClass4_Sub12_Sub1_3.g1()];
                            method2572(local4723);
                          }
                          Static300.aOpCode_246 = null;
                          return true;
                        } else if (Static300.aOpCode_246 == A_OP_CODE___219) {
                          Static184.anInt3532 = Static146.aClass4_Sub12_Sub1_3.g1();
                          Static300.aOpCode_246 = null;
                          return true;
                        } else if (Static300.aOpCode_246 == A_OP_CODE___313) {
                          method2572(Static38.aClass21_6);
                          Static300.aOpCode_246 = null;
                          return true;
                        } else if (Static300.aOpCode_246 == A_OP_CODE___51) {
                          local327 = Static146.aClass4_Sub12_Sub1_3.g2();
                          if (Static326.method4415(local327)) {
                            Static100.method1773();
                          }
                          Static300.aOpCode_246 = null;
                          return true;
                        } else if (A_OP_CODE___164 == Static300.aOpCode_246) {
                          local327 = Static146.aClass4_Sub12_Sub1_3.gts_alt3();
                          local70 = Static146.aClass4_Sub12_Sub1_3.g4();
                          local335 = Static146.aClass4_Sub12_Sub1_3.gts_alt3();
                          local224 = Static146.aClass4_Sub12_Sub1_3.g2_alt3();
                          if (Static326.method4415(local224)) {
                            Static400.method5189(local70, local335, local327);
                          }
                          Static300.aOpCode_246 = null;
                          return true;
                        } else if (Static300.aOpCode_246 == A_OP_CODE___199) {
                          local327 = Static146.aClass4_Sub12_Sub1_3.g2();
                          if (local327 == 65535) {
                            local327 = -1;
                          }
                          local70 = Static146.aClass4_Sub12_Sub1_3.g1();
                          local335 = Static146.aClass4_Sub12_Sub1_3.g2();
                          local224 = Static146.aClass4_Sub12_Sub1_3.g1();
                          Static187.method2934(local327, local70, local224, local335);
                          Static300.aOpCode_246 = null;
                          return true;
                        } else if (Static300.aOpCode_246 == A_OP_CODE___63) {
                          method2572(Static410.aClass21_15);
                          Static300.aOpCode_246 = null;
                          return true;
                        } else if (A_OP_CODE___269 == Static300.aOpCode_246) {
                          method2572(Static35.aClass21_5);
                          Static300.aOpCode_246 = null;
                          return true;
                        } else if (A_OP_CODE___49 == Static300.aOpCode_246) {
                          local327 = Static146.aClass4_Sub12_Sub1_3.g2();
                          local70 = Static146.aClass4_Sub12_Sub1_3.g1();
                          local335 = Static146.aClass4_Sub12_Sub1_3.g1();
                          local224 = Static146.aClass4_Sub12_Sub1_3.g2() << 0;
                          local228 = Static146.aClass4_Sub12_Sub1_3.g1();
                          local1190 = Static146.aClass4_Sub12_Sub1_3.g1();
                          if (Static326.method4415(local327)) {
                            Static245.method3596(
                                local224, true, local1190, local335, local70, local228);
                          }
                          Static300.aOpCode_246 = null;
                          return true;
                        } else if (Static300.aOpCode_246 == A_OP_CODE___129) {
                          local327 = Static146.aClass4_Sub12_Sub1_3.g2();
                          if (local327 == 65535) {
                            local327 = -1;
                          }
                          local70 = Static146.aClass4_Sub12_Sub1_3.g1();
                          local335 = Static146.aClass4_Sub12_Sub1_3.g2();
                          local224 = Static146.aClass4_Sub12_Sub1_3.g1();
                          Static273.method3912(local70, local335, local327, local224);
                          Static300.aOpCode_246 = null;
                          return true;
                        } else if (Static300.aOpCode_246 == A_OP_CODE___236) {
                          method2572(Static183.aClass21_11);
                          Static300.aOpCode_246 = null;
                          return true;
                        } else if (A_OP_CODE___71 == Static300.aOpCode_246) {
                          Static124.method2241(false);
                          Static300.aOpCode_246 = null;
                          return true;
                        } else if (A_OP_CODE___263 == Static300.aOpCode_246) {
                          local327 = Static146.aClass4_Sub12_Sub1_3.g1_alt3();
                          local70 = Static146.aClass4_Sub12_Sub1_3.g4_alt3();
                          local335 = Static146.aClass4_Sub12_Sub1_3.g2_alt2();
                          if (Static326.method4415(local335)) {
                            Static255.method3686(local327, local70);
                          }
                          Static300.aOpCode_246 = null;
                          return true;
                        } else if (A_OP_CODE___331 == Static300.aOpCode_246) {
                          local813 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
                          local1411 = Static146.aClass4_Sub12_Sub1_3.g1() == 1;
                          if (local1411) {
                            local210 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
                          } else {
                            local210 = local813;
                          }
                          local224 = Static146.aClass4_Sub12_Sub1_3.g2();
                          byte local5040 = Static146.aClass4_Sub12_Sub1_3.g1s();
                          local230 = false;
                          if (local5040 == -128) {
                            local230 = true;
                          }
                          if (local230) {
                            if (Static290.anInt6410 == 0) {
                              Static300.aOpCode_246 = null;
                              return true;
                            }
                            for (local2473 = 0;
                                Static290.anInt6410 > local2473
                                    && (!GameShell.aClass15Array2[local2473].aString7.equals(
                                            local210)
                                        || GameShell.aClass15Array2[local2473].anInt272
                                            != local224);
                                local2473++) {}
                            if (local2473 < Static290.anInt6410) {
                              while (local2473 < Static290.anInt6410 - 1) {
                                GameShell.aClass15Array2[local2473] =
                                    GameShell.aClass15Array2[local2473 + 1];
                                local2473++;
                              }
                              Static290.anInt6410--;
                              GameShell.aClass15Array2[Static290.anInt6410] = null;
                            }
                          } else {
                            local251 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
                            local4235 = new Class15();
                            local4235.aString8 = local813;
                            local4235.aString7 = local210;
                            local4235.aString6 = Static123.method4868(local4235.aString7);
                            local4235.aByte1 = local5040;
                            local4235.anInt272 = local224;
                            local4235.aString5 = local251;
                            for (local1267 = Static290.anInt6410 - 1; local1267 >= 0; local1267--) {
                              local2494 =
                                  GameShell.aClass15Array2[local1267].aString6.compareTo(
                                      local4235.aString6);
                              if (local2494 == 0) {
                                GameShell.aClass15Array2[local1267].anInt272 = local224;
                                GameShell.aClass15Array2[local1267].aByte1 = local5040;
                                GameShell.aClass15Array2[local1267].aString5 = local251;
                                if (local210.equals(Static1.aClass16_Sub1_Sub5_Sub1_1.aString44)) {
                                  Static160.aByte18 = local5040;
                                }
                                Static381.anInt6418 = Static325.anInt5640;
                                Static300.aOpCode_246 = null;
                                return true;
                              }
                              if (local2494 < 0) {
                                break;
                              }
                            }
                            if (Static290.anInt6410 >= GameShell.aClass15Array2.length) {
                              Static300.aOpCode_246 = null;
                              return true;
                            }
                            for (local2494 = Static290.anInt6410 - 1;
                                local2494 > local1267;
                                local2494--) {
                              GameShell.aClass15Array2[local2494 + 1] =
                                  GameShell.aClass15Array2[local2494];
                            }
                            if (Static290.anInt6410 == 0) {
                              GameShell.aClass15Array2 = new Class15[100];
                            }
                            GameShell.aClass15Array2[local1267 + 1] = local4235;
                            Static290.anInt6410++;
                            if (local210.equals(Static1.aClass16_Sub1_Sub5_Sub1_1.aString44)) {
                              Static160.aByte18 = local5040;
                            }
                          }
                          Static300.aOpCode_246 = null;
                          Static381.anInt6418 = Static325.anInt5640;
                          return true;
                        } else if (Static300.aOpCode_246 == A_OP_CODE___1) {
                          method2572(Static405.aClass21_14);
                          Static300.aOpCode_246 = null;
                          return true;
                        } else if (Static300.aOpCode_246 == A_OP_CODE___273) {
                          method2572(Static179.aClass21_10);
                          Static300.aOpCode_246 = null;
                          return true;
                        } else if (A_OP_CODE___178 == Static300.aOpCode_246) {
                          local327 = Static146.aClass4_Sub12_Sub1_3.g2();
                          if (local327 == 65535) {
                            local327 = -1;
                          }
                          local70 = Static146.aClass4_Sub12_Sub1_3.g2_alt2();
                          local335 = Static146.aClass4_Sub12_Sub1_3.g4_alt1();
                          local224 = Static146.aClass4_Sub12_Sub1_3.g2_alt1();
                          local228 = Static146.aClass4_Sub12_Sub1_3.g2();
                          if (local228 == 65535) {
                            local228 = -1;
                          }
                          if (Static326.method4415(local70)) {
                            for (local1190 = local228; local1190 <= local327; local1190++) {
                              local2311 = ((long) local335 << 32) + ((long) local1190);
                              local2317 = (Node_Sub33) Static211.A_HASH_MAP___18.get(local2311);
                              if (local2317 != null) {
                                local2329 = new Node_Sub33(local2317.anInt5105, local224);
                                local2317.popSelf();
                              } else if (local1190 == -1) {
                                local2329 =
                                    new Node_Sub33(
                                        Static392.method5121(local335).aClass4_Sub33_2.anInt5105,
                                        local224);
                              } else {
                                local2329 = new Node_Sub33(0, local224);
                              }
                              Static211.A_HASH_MAP___18.set(local2311, local2329);
                            }
                          }
                          Static300.aOpCode_246 = null;
                          return true;
                        } else if (Static300.aOpCode_246 == A_OP_CODE___293) {
                          local327 = Static146.aClass4_Sub12_Sub1_3.g2_alt2();
                          local210 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
                          local335 = Static146.aClass4_Sub12_Sub1_3.g2_alt2();
                          if (Static326.method4415(local327)) {
                            Static244.method2569(local210, local335);
                          }
                          Static300.aOpCode_246 = null;
                          return true;
                        } else if (A_OP_CODE___231 == Static300.aOpCode_246) {
                          Static439.dropSettingsCookie(
                              Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8());
                          Static300.aOpCode_246 = null;
                          return true;
                        } else if (A_OP_CODE___253 == Static300.aOpCode_246) {
                          Static113.anInt2426 = Static146.aClass4_Sub12_Sub1_3.g1_alt2();
                          Static154.anInt813 = Static146.aClass4_Sub12_Sub1_3.g1s_alt3() << 3;
                          Static385.anInt6487 = Static146.aClass4_Sub12_Sub1_3.g1s_alt2() << 3;
                          for (Node_Sub18 local5469 = (Node_Sub18) Static440.aHashMap_40.head();
                              local5469 != null;
                              local5469 = (Node_Sub18) Static440.aHashMap_40.next()) {
                            local70 = (int) (local5469.hashKey & 0x3FFFL);
                            local335 = (int) (local5469.hashKey >> 14 & 0x3FFFL);
                            local224 = (int) (local5469.hashKey >> 28 & 0x3L);
                            if (local224 == Static113.anInt2426
                                && local70 >= Static154.anInt813
                                && Static154.anInt813 + 8 > local70
                                && Static385.anInt6487 <= local335
                                && Static385.anInt6487 + 8 > local335) {
                              local5469.popSelf();
                              Static443.method5595(Static113.anInt2426, local70, local335);
                            }
                          }
                          for (Node_Sub9 local5544 = (Node_Sub9) Static115.aLinkedList_15.tail();
                              local5544 != null;
                              local5544 = (Node_Sub9) Static115.aLinkedList_15.previous()) {
                            if (Static154.anInt813 <= local5544.anInt793
                                && Static154.anInt813 + 8 > local5544.anInt793
                                && local5544.anInt790 >= Static385.anInt6487
                                && Static385.anInt6487 + 8 > local5544.anInt790
                                && Static113.anInt2426 == local5544.anInt800) {
                              local5544.anInt796 = 0;
                            }
                          }
                          Static300.aOpCode_246 = null;
                          return true;
                        } else if (Static300.aOpCode_246 == A_OP_CODE___95) {
                          local327 = Static146.aClass4_Sub12_Sub1_3.g4_alt1();
                          local70 = Static146.aClass4_Sub12_Sub1_3.g2();
                          local335 = Static146.aClass4_Sub12_Sub1_3.g2_alt2();
                          if (local335 == 65535) {
                            local335 = -1;
                          }
                          if (Static326.method4415(local70)) {
                            Static54.method914(2, local327, local335, -1);
                          }
                          Static300.aOpCode_246 = null;
                          return true;
                        } else if (A_OP_CODE___46 == Static300.aOpCode_246) {
                          local327 = Static146.aClass4_Sub12_Sub1_3.gSmart1Or2();
                          local70 = Static146.aClass4_Sub12_Sub1_3.g4();
                          local335 = Static146.aClass4_Sub12_Sub1_3.g1();
                          local535 = "";
                          local2080 = local535;
                          if ((local335 & 0x1) != 0) {
                            local535 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
                            if ((local335 & 0x2) == 0) {
                              local2080 = local535;
                            } else {
                              local2080 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
                            }
                          }
                          local1747 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
                          if (local327 == 99) {
                            Static441.method5568(local1747);
                          } else if (local2080.equals("") || !Static239.method3549(local2080)) {
                            Static128.method2268(local70, local327, local1747, local535, local2080);
                          } else {
                            Static300.aOpCode_246 = null;
                            return true;
                          }
                          Static300.aOpCode_246 = null;
                          return true;
                        } else if (Static300.aOpCode_246 == A_OP_CODE___287) {
                          Static413.method5301();
                          Static300.aOpCode_246 = null;
                          return true;
                        } else if (A_OP_CODE___266 == Static300.aOpCode_246) {
                          method2572(Static106.aClass21_7);
                          Static300.aOpCode_246 = null;
                          return true;
                        } else if (Static300.aOpCode_246 == A_OP_CODE___192) {
                          local327 = Static146.aClass4_Sub12_Sub1_3.g2();
                          local70 = Static146.aClass4_Sub12_Sub1_3.g4();
                          if (Static326.method4415(local327)) {
                            Node_Sub43 local5751 =
                                (Node_Sub43) Static325.aHashMap_29.get((long) local70);
                            if (local5751 != null) {
                              Static90.method1606(true, local5751, false);
                            }
                            if (Static304.aClass247_16 != null) {
                              Static63.method1142(Static304.aClass247_16);
                              Static304.aClass247_16 = null;
                            }
                          }
                          Static300.aOpCode_246 = null;
                          return true;
                        } else if (Static300.aOpCode_246 == A_OP_CODE___278) {
                          local327 = Static146.aClass4_Sub12_Sub1_3.g1_alt2();
                          local70 = local327 >> 2;
                          local335 = local327 & 0x3;
                          local224 = Static201.anIntArray410[local70];
                          local228 = Static146.aClass4_Sub12_Sub1_3.g4_alt1();
                          local1190 = local228 >> 28 & 0x3;
                          local2473 = local228 >> 14 & 0x3FFF;
                          local1263 = local228 & 0x3FFF;
                          local1267 = Static146.aClass4_Sub12_Sub1_3.g2_alt1();
                          int local5820 = local1263 - Static86.anInt1771;
                          if (local1267 == 65535) {
                            local1267 = -1;
                          }
                          local2473 -= Static180.anInt3453;
                          Static297.method4071(
                              local1190, local335, local1267, local224, local70, local2473,
                              local5820);
                          Static300.aOpCode_246 = null;
                          return true;
                        } else if (A_OP_CODE___230 == Static300.aOpCode_246) {
                          local327 = Static146.aClass4_Sub12_Sub1_3.g2();
                          local70 = Static146.aClass4_Sub12_Sub1_3.g1();
                          local335 = Static146.aClass4_Sub12_Sub1_3.g1();
                          local224 = Static146.aClass4_Sub12_Sub1_3.g1();
                          local228 = Static146.aClass4_Sub12_Sub1_3.g1();
                          local1190 = Static146.aClass4_Sub12_Sub1_3.g2();
                          if (Static326.method4415(local327)) {
                            Static342.aBooleanArray17[local70] = true;
                            Static105.anIntArray161[local70] = local335;
                            Static41.anIntArray46[local70] = local224;
                            Static61.anIntArray65[local70] = local228;
                            Static390.anIntArray486[local70] = local1190;
                          }
                          Static300.aOpCode_246 = null;
                          return true;
                        } else if (Static300.aOpCode_246 == A_OP_CODE___175) {
                          method2572(Static420.aClass21_16);
                          Static300.aOpCode_246 = null;
                          return true;
                        } else if (Static300.aOpCode_246 == A_OP_CODE___301) {
                          Static167.aString35 =
                              Static454.anInt4075 > 2
                                  ? Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8()
                                  : Static190.A_LOCALIZED_STRING___76.getString(
                                      ClientSettings.langID);
                          Static220.anInt4097 =
                              Static454.anInt4075 > 0 ? Static146.aClass4_Sub12_Sub1_3.g2() : -1;
                          Static300.aOpCode_246 = null;
                          if (Static220.anInt4097 == 65535) {
                            Static220.anInt4097 = -1;
                          }
                          return true;
                        } else if (A_OP_CODE___235 == Static300.aOpCode_246) {
                          local327 = Static146.aClass4_Sub12_Sub1_3.g4();
                          Static216.aClass199_7 =
                              GameShell.signLink.emitReverseIPLookupMessage(local327);
                          Static300.aOpCode_246 = null;
                          return true;
                        } else if (A_OP_CODE___335 == Static300.aOpCode_246) {
                          Static186.aClass104_2 =
                              Static2.method6(Static146.aClass4_Sub12_Sub1_3.g1());
                          Static300.aOpCode_246 = null;
                          return true;
                        } else if (A_OP_CODE___249 == Static300.aOpCode_246) {
                          Static95.method1665(
                              Static146.aClass4_Sub12_Sub1_3,
                              Static454.anInt4075,
                              GameShell.signLink);
                          Static300.aOpCode_246 = null;
                          return true;
                        } else if (Static300.aOpCode_246 == A_OP_CODE___330) {
                          local327 = Static146.aClass4_Sub12_Sub1_3.g2_alt3();
                          local70 = Static146.aClass4_Sub12_Sub1_3.g2();
                          byte local6007 = Static146.aClass4_Sub12_Sub1_3.g1s_alt3();
                          if (Static326.method4415(local327)) {
                            Static316.method4221(local70, local6007);
                          }
                          Static300.aOpCode_246 = null;
                          return true;
                        } else if (A_OP_CODE___16 == Static300.aOpCode_246) {
                          Static146.aClass4_Sub12_Sub1_3.pos += 28;
                          if (Static146.aClass4_Sub12_Sub1_3.method2500()) {
                            Static157.method2669(
                                Static146.aClass4_Sub12_Sub1_3,
                                Static146.aClass4_Sub12_Sub1_3.pos - 28);
                          }
                          Static300.aOpCode_246 = null;
                          return true;
                        } else if (A_OP_CODE___214 == Static300.aOpCode_246) {
                          local327 = Static146.aClass4_Sub12_Sub1_3.g2_alt3();
                          local70 = Static146.aClass4_Sub12_Sub1_3.g2_alt3();
                          local335 = Static146.aClass4_Sub12_Sub1_3.g4();
                          local224 = Static146.aClass4_Sub12_Sub1_3.g2_alt3();
                          if (Static326.method4415(local327)) {
                            Static303.method4114(local335, local70 + (local224 << 16));
                          }
                          Static300.aOpCode_246 = null;
                          return true;
                        } else if (Static300.aOpCode_246 == A_OP_CODE___101) {
                          method2572(Static152.aClass21_9);
                          Static300.aOpCode_246 = null;
                          return true;
                        } else if (Static300.aOpCode_246 == A_OP_CODE___284) {
                          local327 = Static146.aClass4_Sub12_Sub1_3.g4_alt1();
                          local70 = Static146.aClass4_Sub12_Sub1_3.g4_alt3();
                          local335 = Static146.aClass4_Sub12_Sub1_3.g2_alt1();
                          if (Static326.method4415(local335)) {
                            Node_Sub43 local6126 =
                                (Node_Sub43) Static325.aHashMap_29.get((long) local70);
                            local1576 = (Node_Sub43) Static325.aHashMap_29.get((long) local327);
                            if (local1576 != null) {
                              Static90.method1606(
                                  local6126 == null || local1576.anInt6979 != local6126.anInt6979,
                                  local1576,
                                  false);
                            }
                            if (local6126 != null) {
                              local6126.popSelf();
                              Static325.aHashMap_29.set((long) local327, local6126);
                            }
                            Class247 local6164 = Static392.method5121(local70);
                            if (local6164 != null) {
                              Static63.method1142(local6164);
                            }
                            local6164 = Static392.method5121(local327);
                            if (local6164 != null) {
                              Static63.method1142(local6164);
                              Static374.method4998(local6164, true);
                            }
                            if (Static334.anInt5766 != -1) {
                              Static310.method4165(Static334.anInt5766, 1);
                            }
                          }
                          Static300.aOpCode_246 = null;
                          return true;
                        } else if (A_OP_CODE___326 == Static300.aOpCode_246) {
                          local206 = Static146.aClass4_Sub12_Sub1_3.g1() == 1;
                          local210 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
                          local212 = local210;
                          if (local206) {
                            local212 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
                          }
                          local1252 = Static146.aClass4_Sub12_Sub1_3.g8();
                          local1257 = Static146.aClass4_Sub12_Sub1_3.g2();
                          local3817 = Static146.aClass4_Sub12_Sub1_3.g3();
                          local2494 = Static146.aClass4_Sub12_Sub1_3.g1();
                          long local6247 = (local1257 << 32) + local3817;
                          boolean local6249 = false;
                          int local6251 = 0;
                          while (true) {
                            if (local6251 >= 100) {
                              if (local2494 <= 1) {
                                if (Static109.aBoolean628 && !Static396.aBoolean443
                                    || Static308.aBoolean486) {
                                  local6249 = true;
                                } else if (Static239.method3549(local212)) {
                                  local6249 = true;
                                }
                              }
                              break;
                            }
                            if (local6247 == Static270.aLongArray7[local6251]) {
                              local6249 = true;
                              break;
                            }
                            local6251++;
                          }
                          if (!local6249 && Static65.anInt1373 == 0) {
                            Static270.aLongArray7[Static407.anInt6719] = local6247;
                            Static407.anInt6719 = (Static407.anInt6719 + 1) % 100;
                            String local6311 =
                                Static22.method297(
                                    Static261.method3776(Static146.aClass4_Sub12_Sub1_3));
                            if (local2494 == 2 || local2494 == 3) {
                              Static426.method5438(
                                  -1,
                                  "<img=1>" + local212,
                                  local6311,
                                  Static45.method766(local1252),
                                  0,
                                  "<img=1>" + local210,
                                  9);
                            } else if (local2494 == 1) {
                              Static426.method5438(
                                  -1,
                                  "<img=0>" + local212,
                                  local6311,
                                  Static45.method766(local1252),
                                  0,
                                  "<img=0>" + local210,
                                  9);
                            } else {
                              Static426.method5438(
                                  -1,
                                  local212,
                                  local6311,
                                  Static45.method766(local1252),
                                  0,
                                  local210,
                                  9);
                            }
                          }
                          Static300.aOpCode_246 = null;
                          return true;
                        } else {
                          Static94.handleClientError(
                              null,
                              "T1 - "
                                  + (Static300.aOpCode_246 == null
                                      ? -1
                                      : Static300.aOpCode_246.method527())
                                  + ","
                                  + (Static380.aOpCode_294 == null
                                      ? -1
                                      : Static380.aOpCode_294.method527())
                                  + ","
                                  + (Static316.aOpCode_257 == null
                                      ? -1
                                      : Static316.aOpCode_257.method527())
                                  + " - "
                                  + Static454.anInt4075);
                          Static251.method3639();
                          return true;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  public static void method2572(Class21 arg0) {
    int local12;
    int local16;
    if (Static435.aClass21_17 == arg0) {
      local12 = Static146.aClass4_Sub12_Sub1_3.g2();
      local16 = Static146.aClass4_Sub12_Sub1_3.g1();
      Static267.aClass262_2.method5560(local12).method4590(local16);
      return;
    }
    int local40;
    int local49;
    int local55;
    if (Static133.aClass21_8 == arg0) {
      local12 = Static146.aClass4_Sub12_Sub1_3.g2_alt1();
      local16 = Static146.aClass4_Sub12_Sub1_3.g2_alt2();
      local40 = Static146.aClass4_Sub12_Sub1_3.g1();
      local49 = Static154.anInt813 + (local40 >> 4 & 0x7);
      local55 = Static385.anInt6487 + (local40 & 0x7);
      if (local49 >= 0
          && local55 >= 0
          && local49 < Static326.anInt5666
          && Static283.anInt5187 > local55) {
        Static28.method528(new Node_Sub45(local16, local12), local49, local55, Static113.anInt2426);
        Static443.method5595(Static113.anInt2426, local49, local55);
      }
      return;
    }
    int local126;
    if (arg0 == Static179.aClass21_10) {
      Static146.aClass4_Sub12_Sub1_3.g1();
      local12 = Static146.aClass4_Sub12_Sub1_3.g1();
      local16 = Static154.anInt813 + (local12 >> 4 & 0x7);
      local40 = (local12 & 0x7) + Static385.anInt6487;
      local49 = Static146.aClass4_Sub12_Sub1_3.g2();
      local55 = Static146.aClass4_Sub12_Sub1_3.g1();
      local126 = Static146.aClass4_Sub12_Sub1_3.g3();
      String local130 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
      Static212.method3207(
          local126, local49, Static113.anInt2426, local16, local40, local55, local130);
      return;
    }
    int local186;
    int local190;
    int local196;
    int local202;
    int local206;
    int local210;
    int local214;
    int local223;
    Class16_Sub1_Sub3 local309;
    if (Static294.aClass21_4 == arg0) {
      local12 = Static146.aClass4_Sub12_Sub1_3.g1();
      boolean local155 = (local12 & 0x80) != 0;
      local40 = (local12 >> 3 & 0x7) + Static154.anInt813;
      local49 = (local12 & 0x7) + Static385.anInt6487;
      local55 = Static146.aClass4_Sub12_Sub1_3.g1s() + local40;
      local126 = local49 + Static146.aClass4_Sub12_Sub1_3.g1s();
      local186 = Static146.aClass4_Sub12_Sub1_3.g2s();
      local190 = Static146.aClass4_Sub12_Sub1_3.g2();
      local196 = Static146.aClass4_Sub12_Sub1_3.g1() * 4;
      local202 = Static146.aClass4_Sub12_Sub1_3.g1() * 4;
      local206 = Static146.aClass4_Sub12_Sub1_3.g2();
      local210 = Static146.aClass4_Sub12_Sub1_3.g2();
      local214 = Static146.aClass4_Sub12_Sub1_3.g1();
      if (local214 == 255) {
        local214 = -1;
      }
      local223 = Static146.aClass4_Sub12_Sub1_3.g1();
      if (local40 >= 0
          && local49 >= 0
          && Static326.anInt5666 > local40
          && Static283.anInt5187 > local49
          && local55 >= 0
          && local126 >= 0
          && Static326.anInt5666 > local55
          && local126 < Static283.anInt5187
          && local190 != 65535) {
        local40 = local40 * 128 + 64;
        local126 = local126 * 128 + 64;
        local196 <<= 0x0;
        local49 = local49 * 128 + 64;
        local55 = local55 * 128 + 64;
        local202 <<= 0x0;
        local309 =
            new Class16_Sub1_Sub3(
                local190,
                Static113.anInt2426,
                local40,
                local49,
                local196,
                local206 + client.gameLogicStepCount,
                local210 + client.gameLogicStepCount,
                local214,
                local223,
                local186,
                local202,
                local155);
        local309.method2197(
            client.gameLogicStepCount + local206,
            local55,
            Static13.method135(local55, Static113.anInt2426, local126) - local202,
            local126);
        Static27.A_LINKED_LIST___2.addFirst(new SecondaryNode_Sub1_Sub7(local309));
      }
    } else if (Static420.aClass21_16 == arg0) {
      local12 = Static146.aClass4_Sub12_Sub1_3.g2_alt3();
      local16 = Static146.aClass4_Sub12_Sub1_3.g1_alt2();
      local40 = (local16 >> 4 & 0x7) + Static154.anInt813;
      local49 = Static385.anInt6487 + (local16 & 0x7);
      if (local40 >= 0
          && local49 >= 0
          && Static326.anInt5666 > local40
          && local49 < Static283.anInt5187) {
        Node_Sub18 local395 =
            (Node_Sub18)
                Static440.aHashMap_40.get(
                    (long) (Static113.anInt2426 << 28 | local49 << 14 | local40));
        if (local395 != null) {
          for (Node_Sub45 local403 = (Node_Sub45) local395.aLinkedList_14.tail();
              local403 != null;
              local403 = (Node_Sub45) local395.aLinkedList_14.previous()) {
            if (local403.anInt7355 == (local12 & 0x7FFF)) {
              local403.popSelf();
              break;
            }
          }
          if (local395.aLinkedList_14.isEmpty()) {
            local395.popSelf();
          }
          Static443.method5595(Static113.anInt2426, local40, local49);
        }
      }
    } else if (arg0 == Static183.aClass21_11) {
      local12 = Static146.aClass4_Sub12_Sub1_3.g2_alt2();
      byte local453 = Static146.aClass4_Sub12_Sub1_3.g1s_alt2();
      local40 = Static146.aClass4_Sub12_Sub1_3.g1_alt2();
      local49 = local40 >> 2;
      local55 = local40 & 0x3;
      local126 = Static146.aClass4_Sub12_Sub1_3.g1_alt1();
      local186 = Static154.anInt813 + (local126 >> 4 & 0x7);
      local190 = (local126 & 0x7) + Static385.anInt6487;
      byte local488 = Static146.aClass4_Sub12_Sub1_3.g1s_alt1();
      local202 = Static146.aClass4_Sub12_Sub1_3.g2s_alt1();
      byte local496 = Static146.aClass4_Sub12_Sub1_3.g1s_alt2();
      local210 = Static146.aClass4_Sub12_Sub1_3.g2_alt3();
      local214 = Static146.aClass4_Sub12_Sub1_3.g2_alt3();
      byte local508 = Static146.aClass4_Sub12_Sub1_3.g1s_alt2();
      if (!Static122.aClass19_16.method4243()) {
        Static208.method2249(
            local186,
            local12,
            local55,
            local496,
            local453,
            local202,
            local508,
            Static113.anInt2426,
            local488,
            local190,
            local214,
            local210,
            local49);
      }
    } else if (arg0 == Static405.aClass21_14) {
      local12 = Static146.aClass4_Sub12_Sub1_3.g1_alt1();
      local16 = local12 >> 2;
      local40 = local12 & 0x3;
      local49 = Static201.anIntArray410[local16];
      local55 = Static146.aClass4_Sub12_Sub1_3.g1_alt3();
      local126 = Static154.anInt813 + (local55 >> 4 & 0x7);
      local186 = (local55 & 0x7) + Static385.anInt6487;
      if (Static178.method2845(Static448.anInt7307)
          || local126 >= 0
              && local186 >= 0
              && Static326.anInt5666 > local126
              && local186 < Static283.anInt5187) {
        Static145.method2449(
            local126, local16, -1, local49, local186, Static113.anInt2426, local40);
      }
    } else {
      boolean local635;
      if (arg0 == Static38.aClass21_6) {
        local12 = Static146.aClass4_Sub12_Sub1_3.g1();
        local16 = Static154.anInt813 * 2 + (local12 >> 4 & 0xF);
        local40 = Static385.anInt6487 * 2 + (local12 & 0xF);
        local635 = Static146.aClass4_Sub12_Sub1_3.g1() != 0;
        local55 = Static146.aClass4_Sub12_Sub1_3.g1s() + local16;
        local126 = local40 + Static146.aClass4_Sub12_Sub1_3.g1s();
        local186 = Static146.aClass4_Sub12_Sub1_3.g2s();
        local190 = Static146.aClass4_Sub12_Sub1_3.g2s();
        local196 = Static146.aClass4_Sub12_Sub1_3.g2();
        byte local664 = Static146.aClass4_Sub12_Sub1_3.g1s();
        local206 = Static146.aClass4_Sub12_Sub1_3.g1() * 4;
        local210 = Static146.aClass4_Sub12_Sub1_3.g2();
        local214 = Static146.aClass4_Sub12_Sub1_3.g2();
        local223 = Static146.aClass4_Sub12_Sub1_3.g1();
        if (local223 == 255) {
          local223 = -1;
        }
        int local693 = Static146.aClass4_Sub12_Sub1_3.g1();
        if (local16 >= 0
            && local40 >= 0
            && local16 < Static326.anInt5666 * 2
            && Static326.anInt5666 * 2 > local40
            && local55 >= 0
            && local126 >= 0
            && local55 < Static283.anInt5187 * 2
            && Static283.anInt5187 * 2 > local126
            && local196 != 65535) {
          local55 = local55 * 64;
          local40 = local40 * 64;
          local126 = local126 * 64;
          local202 = local664 << 0;
          local206 <<= 0x0;
          local16 *= 64;
          if (local186 != 0) {
            int local782;
            Class16_Sub1_Sub5 local793;
            int local772;
            int local776;
            if (local186 < 0) {
              local772 = -local186 - 1;
              local776 = local772 & 0x7FF;
              local782 = local772 >> 11 & 0xF;
              if (Static207.anInt5452 == local776) {
                local793 = Static1.aClass16_Sub1_Sub5_Sub1_1;
              } else {
                local793 = Static267.aClass16_Sub1_Sub5_Sub1Array1[local776];
              }
            } else {
              local772 = local186 - 1;
              local782 = local772 >> 11 & 0xF;
              local776 = local772 & 0x7FF;
              local793 = Static143.aClass16_Sub1_Sub5_Sub2Array1[local776];
            }
            if (local793 != null) {
              Class151 local823 = local793.method4757();
              if (local823.anIntArrayArray38 != null
                  && local823.anIntArrayArray38[local782] != null) {
                local776 = local823.anIntArrayArray38[local782][0];
                int local845 = local823.anIntArrayArray38[local782][2];
                int local850 = local793.aClass35_7.method811();
                int local854 = RenderMath.SINE_TABLE[local850];
                int local858 = RenderMath.COSINE_TABLE[local850];
                int local868 = local845 * local854 + local776 * local858 >> 15;
                int local878 = local845 * local858 - local854 * local776 >> 15;
                local16 += local868;
                local202 -= local823.anIntArrayArray38[local782][1];
                local40 += local878;
              }
            }
          }
          Class16_Sub1_Sub3 local918 =
              new Class16_Sub1_Sub3(
                  local196,
                  Static113.anInt2426,
                  local16,
                  local40,
                  local202,
                  client.gameLogicStepCount + local210,
                  local214 - -client.gameLogicStepCount,
                  local223,
                  local693,
                  local190,
                  local206,
                  local635);
          local918.method2197(
              local210 + client.gameLogicStepCount,
              local55,
              Static13.method135(local55, Static113.anInt2426, local126) - local206,
              local126);
          Static27.A_LINKED_LIST___2.addFirst(new SecondaryNode_Sub1_Sub7(local918));
        }
      } else if (arg0 == Static152.aClass21_9) {
        local12 = Static146.aClass4_Sub12_Sub1_3.g1();
        local16 = (local12 >> 4 & 0x7) + Static154.anInt813;
        local40 = Static385.anInt6487 + (local12 & 0x7);
        local49 = Static146.aClass4_Sub12_Sub1_3.g2();
        if (local49 == 65535) {
          local49 = -1;
        }
        local55 = Static146.aClass4_Sub12_Sub1_3.g1();
        local126 = local55 >> 4 & 0xF;
        local186 = local55 & 0x7;
        local190 = Static146.aClass4_Sub12_Sub1_3.g1();
        local196 = Static146.aClass4_Sub12_Sub1_3.g1();
        if (local16 >= 0
            && local40 >= 0
            && local16 < Static326.anInt5666
            && Static283.anInt5187 > local40) {
          local202 = local126 + 1;
          if (Static1.aClass16_Sub1_Sub5_Sub1_1.anIntArray426[0] >= local16 - local202
              && local202 + local16 >= Static1.aClass16_Sub1_Sub5_Sub1_1.anIntArray426[0]
              && local40 - local202 <= Static1.aClass16_Sub1_Sub5_Sub1_1.anIntArray427[0]
              && local40 + local202 >= Static1.aClass16_Sub1_Sub5_Sub1_1.anIntArray427[0]) {
            Static412.method5292(
                local196,
                local49,
                local190,
                local186,
                local126 + (local16 << 16) + (Static113.anInt2426 << 24) + (local40 << 8));
          }
        }
      } else if (arg0 == Static183.aClass21_12) {
        local12 = Static146.aClass4_Sub12_Sub1_3.g1();
        local16 = (local12 >> 4 & 0x7) + Static154.anInt813;
        local40 = (local12 & 0x7) + Static385.anInt6487;
        local49 = Static146.aClass4_Sub12_Sub1_3.g2();
        local55 = Static146.aClass4_Sub12_Sub1_3.g1();
        local126 = Static146.aClass4_Sub12_Sub1_3.g2();
        local186 = Static146.aClass4_Sub12_Sub1_3.g1();
        if (local16 >= 0
            && local40 >= 0
            && Static326.anInt5666 > local16
            && Static283.anInt5187 > local40) {
          local190 = local16 * 128 + 64;
          local196 = local40 * 128 + 64;
          local202 = Static113.anInt2426;
          if (local202 < 3 && Static378.method3229(local16, local40)) {
            local202++;
          }
          Class16_Sub1_Sub2 local1186 =
              new Class16_Sub1_Sub2(
                  local49,
                  local126,
                  client.gameLogicStepCount,
                  Static113.anInt2426,
                  local202,
                  local190,
                  Static13.method135(local190, Static113.anInt2426, local196) - local55,
                  local196,
                  local16,
                  local16,
                  local40,
                  local40,
                  local186);
          Static292.A_LINKED_LIST___36.addFirst(new SecondaryNode_Sub1_Sub10(local1186));
        }
      } else if (Static106.aClass21_7 == arg0) {
        local12 = Static146.aClass4_Sub12_Sub1_3.g1();
        local16 = (local12 >> 4 & 0x7) + Static154.anInt813;
        local40 = Static385.anInt6487 + (local12 & 0x7);
        local49 = Static146.aClass4_Sub12_Sub1_3.g2();
        local55 = Static146.aClass4_Sub12_Sub1_3.g2();
        local126 = Static146.aClass4_Sub12_Sub1_3.g2();
        if (Static440.aHashMap_40 != null
            && local16 >= 0
            && local40 >= 0
            && Static326.anInt5666 > local16
            && local40 < Static283.anInt5187) {
          Node_Sub18 local1265 =
              (Node_Sub18)
                  Static440.aHashMap_40.get(
                      (long) (local16 | local40 << 14 | Static113.anInt2426 << 28));
          if (local1265 != null) {
            for (Node_Sub45 local1273 = (Node_Sub45) local1265.aLinkedList_14.tail();
                local1273 != null;
                local1273 = (Node_Sub45) local1265.aLinkedList_14.previous()) {
              if (local1273.anInt7355 == (local49 & 0x7FFF) && local55 == local1273.anInt7356) {
                local1273.popSelf();
                local1273.anInt7356 = local126;
                Static28.method528(local1273, local16, local40, Static113.anInt2426);
                break;
              }
            }
            Static443.method5595(Static113.anInt2426, local16, local40);
          }
        }
      } else if (Static146.aClass21_2 == arg0) {
        local12 = Static146.aClass4_Sub12_Sub1_3.g1_alt3();
        local16 = local12 >> 2;
        local40 = local12 & 0x3;
        local49 = Static201.anIntArray410[local16];
        local55 = Static146.aClass4_Sub12_Sub1_3.g2_alt2();
        local126 = Static146.aClass4_Sub12_Sub1_3.g1_alt1();
        local186 = (local126 >> 4 & 0x7) + Static154.anInt813;
        local190 = Static385.anInt6487 + (local126 & 0x7);
        if (Static178.method2845(Static448.anInt7307)
            || local186 >= 0
                && local190 >= 0
                && Static326.anInt5666 > local186
                && local190 < Static283.anInt5187) {
          Static145.method2449(
              local186, local16, local55, local49, local190, Static113.anInt2426, local40);
        }
      } else if (arg0 == Static35.aClass21_5) {
        local12 = Static146.aClass4_Sub12_Sub1_3.g2();
        if (local12 == 65535) {
          local12 = -1;
        }
        local16 = Static146.aClass4_Sub12_Sub1_3.g1_alt2();
        local40 = (local16 >> 4 & 0x7) + Static154.anInt813;
        local49 = Static385.anInt6487 + (local16 & 0x7);
        local55 = Static146.aClass4_Sub12_Sub1_3.g1_alt2();
        local126 = local55 >> 2;
        local186 = local55 & 0x3;
        local190 = Static201.anIntArray410[local126];
        Static297.method4071(
            Static113.anInt2426, local186, local12, local190, local126, local40, local49);
      } else if (Static410.aClass21_15 == arg0) {
        local12 = Static146.aClass4_Sub12_Sub1_3.g2();
        local16 = Static146.aClass4_Sub12_Sub1_3.g2();
        local40 = Static146.aClass4_Sub12_Sub1_3.g1_alt3();
        local49 = Static154.anInt813 + (local40 >> 4 & 0x7);
        local55 = (local40 & 0x7) + Static385.anInt6487;
        local126 = Static146.aClass4_Sub12_Sub1_3.g2_alt1();
        if (local49 >= 0
            && local55 >= 0
            && Static326.anInt5666 > local49
            && Static283.anInt5187 > local55
            && local16 != Static207.anInt5452) {
          Static28.method528(
              new Node_Sub45(local12, local126), local49, local55, Static113.anInt2426);
          Static443.method5595(Static113.anInt2426, local49, local55);
        }
      } else if (Static309.aClass21_13 == arg0) {
        local12 = Static146.aClass4_Sub12_Sub1_3.g1();
        local16 = (local12 >> 4 & 0xF) + Static154.anInt813 * 2;
        local40 = (local12 & 0xF) + Static385.anInt6487 * 2;
        local635 = Static146.aClass4_Sub12_Sub1_3.g1() != 0;
        local55 = Static146.aClass4_Sub12_Sub1_3.g1s() + local16;
        local126 = Static146.aClass4_Sub12_Sub1_3.g1s() + local40;
        local186 = Static146.aClass4_Sub12_Sub1_3.g2s();
        local190 = Static146.aClass4_Sub12_Sub1_3.g2();
        local196 = Static146.aClass4_Sub12_Sub1_3.g1() * 4;
        local202 = Static146.aClass4_Sub12_Sub1_3.g1() * 4;
        local206 = Static146.aClass4_Sub12_Sub1_3.g2();
        local210 = Static146.aClass4_Sub12_Sub1_3.g2();
        local214 = Static146.aClass4_Sub12_Sub1_3.g1();
        if (local214 == 255) {
          local214 = -1;
        }
        local223 = Static146.aClass4_Sub12_Sub1_3.g1();
        if (local16 >= 0
            && local40 >= 0
            && local16 < Static326.anInt5666 * 2
            && local40 < Static326.anInt5666 * 2
            && local55 >= 0
            && local126 >= 0
            && local55 < Static283.anInt5187 * 2
            && local126 < Static283.anInt5187 * 2
            && local190 != 65535) {
          local126 *= 64;
          local202 <<= 0x0;
          local40 = local40 * 64;
          local16 *= 64;
          local55 *= 64;
          local196 <<= 0x0;
          local309 =
              new Class16_Sub1_Sub3(
                  local190,
                  Static113.anInt2426,
                  local16,
                  local40,
                  local196,
                  client.gameLogicStepCount + local206,
                  local210 - -client.gameLogicStepCount,
                  local214,
                  local223,
                  local186,
                  local202,
                  local635);
          local309.method2197(
              local206 + client.gameLogicStepCount,
              local55,
              Static13.method135(local55, Static113.anInt2426, local126) - local202,
              local126);
          Static27.A_LINKED_LIST___2.addFirst(new SecondaryNode_Sub1_Sub7(local309));
        }
      } else {
        Static94.handleClientError(null, "T3 - " + arg0);
        Static251.method3639();
      }
    }
  }

  @OriginalMember(owner = "client!hk", name = "t", descriptor = "(I)[Lclient!bg;")
  public static OpCode[] getOpcodes() {
    return new OpCode[] {
      A_OP_CODE___16,
      A_OP_CODE___80,
      A_OP_CODE___195,
      A_OP_CODE___325,
      A_OP_CODE___328,
      A_OP_CODE___185,
      A_OP_CODE___290,
      A_OP_CODE___261,
      A_OP_CODE___194,
      A_OP_CODE___286,
      A_OP_CODE___248,
      A_OP_CODE___292,
      A_OP_CODE___330,
      A_OP_CODE___167,
      A_OP_CODE___17,
      A_OP_CODE___317,
      A_OP_CODE___159,
      A_OP_CODE___316,
      A_OP_CODE___33,
      A_OP_CODE___199,
      A_OP_CODE___106,
      A_OP_CODE___203,
      A_OP_CODE___247,
      A_OP_CODE___196,
      A_OP_CODE___120,
      A_OP_CODE___310,
      A_OP_CODE___46,
      A_OP_CODE___191,
      A_OP_CODE___96,
      A_OP_CODE___335,
      A_OP_CODE___53,
      A_OP_CODE___313,
      A_OP_CODE___102,
      A_OP_CODE___98,
      A_OP_CODE___241,
      A_OP_CODE___72,
      A_OP_CODE___178,
      A_OP_CODE___173,
      A_OP_CODE___219,
      A_OP_CODE___95,
      A_OP_CODE___245,
      A_OP_CODE___263,
      A_OP_CODE___273,
      A_OP_CODE___175,
      A_OP_CODE___192,
      A_OP_CODE___1,
      A_OP_CODE___150,
      A_OP_CODE___23,
      A_OP_CODE___152,
      A_OP_CODE___269,
      A_OP_CODE___324,
      A_OP_CODE___236,
      A_OP_CODE___232,
      A_OP_CODE___293,
      A_OP_CODE___146,
      A_OP_CODE___251,
      A_OP_CODE___235,
      A_OP_CODE___204,
      A_OP_CODE___312,
      A_OP_CODE___332,
      A_OP_CODE___301,
      A_OP_CODE___212,
      A_OP_CODE___117,
      A_OP_CODE___282,
      A_OP_CODE___214,
      A_OP_CODE___336,
      A_OP_CODE___287,
      A_OP_CODE___164,
      A_OP_CODE___264,
      A_OP_CODE___45,
      A_OP_CODE___252,
      A_OP_CODE___73,
      A_OP_CODE___205,
      A_OP_CODE___319,
      A_OP_CODE___281,
      A_OP_CODE___311,
      A_OP_CODE___278,
      A_OP_CODE___71,
      A_OP_CODE___51,
      A_OP_CODE___160,
      A_OP_CODE___266,
      A_OP_CODE___277,
      A_OP_CODE___11,
      A_OP_CODE___253,
      A_OP_CODE___218,
      A_OP_CODE___268,
      A_OP_CODE___223,
      A_OP_CODE___32,
      A_OP_CODE___302,
      A_OP_CODE___254,
      A_OP_CODE___157,
      A_OP_CODE___125,
      A_OP_CODE___144,
      A_OP_CODE___230,
      A_OP_CODE___307,
      A_OP_CODE___94,
      A_OP_CODE___306,
      A_OP_CODE___200,
      A_OP_CODE___231,
      A_OP_CODE___63,
      A_OP_CODE___129,
      A_OP_CODE___331,
      A_OP_CODE___209,
      A_OP_CODE___327,
      A_OP_CODE___101,
      A_OP_CODE___249,
      A_OP_CODE___284,
      A_OP_CODE___326,
      A_OP_CODE___49,
      A_OP_CODE___300
    };
  }
}
