package com.jagex.client.js5;

import com.jagex.client.*;
import java.util.Arrays;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!fs")
public final class Js5 {

  @OriginalMember(owner = "client!v", name = "i", descriptor = "Z")
  private static final boolean SHOULD_THROW_EXCEPTION = false;

  @OriginalMember(owner = "client!fs", name = "c", descriptor = "[[Ljava/lang/Object;")
  private Object[][] anObjectArrayArray1;

  @OriginalMember(owner = "client!fs", name = "G", descriptor = "[Ljava/lang/Object;")
  private Object[] anObjectArray3;

  @OriginalMember(owner = "client!fs", name = "K", descriptor = "Lclient!rt;")
  private Js5Index index = null;

  @OriginalMember(owner = "client!fs", name = "l", descriptor = "I")
  public int anInt2476;

  @OriginalMember(owner = "client!fs", name = "u", descriptor = "Z")
  private final boolean aBoolean230;

  @OriginalMember(owner = "client!fs", name = "F", descriptor = "Lclient!oi;")
  private final Js5ResourceProvider resourceProvider;

  @OriginalMember(owner = "client!fs", name = "<init>", descriptor = "(Lclient!oi;ZI)V")
  public Js5(Js5ResourceProvider resourceProvider, boolean arg1, int arg2) {
    this.anInt2476 = arg2;
    this.aBoolean230 = arg1;
    this.resourceProvider = resourceProvider;
  }

  @OriginalMember(owner = "client!fs", name = "a", descriptor = "(Z)Z")
  private boolean method2097() {
    if (this.index == null) {
      this.index = this.resourceProvider.fetchIndex();

      if (this.index == null) {
        return false;
      }

      this.anObjectArray3 = new Object[this.index.anInt6112];
      this.anObjectArrayArray1 = new Object[this.index.anInt6112][];
    }

    return true;
  }

  @OriginalMember(owner = "client!fs", name = "a", descriptor = "(IBI)Z")
  public boolean method2098(int arg0, int arg1) {
    if (!this.method2127(arg1, arg0)) {
      return false;
    } else if (this.anObjectArrayArray1[arg1] != null
        && this.anObjectArrayArray1[arg1][arg0] != null) {
      return true;
    } else if (this.anObjectArray3[arg1] == null) {
      this.method2119(arg1);

      return this.anObjectArray3[arg1] != null;
    } else {
      return true;
    }
  }

  @OriginalMember(owner = "client!fs", name = "a", descriptor = "(Ljava/lang/String;B)I")
  public int method2099(String arg0) {
    if (this.method2097()) {
      String local20 = arg0.toLowerCase();
      int local29 = this.index.aClass235_1.method5174(Static269.method3854(local20));

      return this.method2106(local29) ? local29 : -1;
    } else {
      return -1;
    }
  }

  @OriginalMember(owner = "client!fs", name = "a", descriptor = "(B)I")
  public int method2100() {
    return this.method2097() ? this.index.anIntArray433.length : -1;
  }

  @OriginalMember(owner = "client!fs", name = "a", descriptor = "(II)Z")
  public boolean method2101(int arg0) {
    if (!this.method2106(arg0)) {
      return false;
    } else if (this.anObjectArray3[arg0] == null) {
      this.method2119(arg0);
      return this.anObjectArray3[arg0] != null;
    } else {
      return true;
    }
  }

  @OriginalMember(owner = "client!fs", name = "b", descriptor = "(B)V")
  public void method2102() {
    if (this.anObjectArray3 != null) {
      Arrays.fill(this.anObjectArray3, null);
    }
  }

  @OriginalMember(owner = "client!fs", name = "a", descriptor = "(ILjava/lang/String;)Z")
  public boolean method2103(String arg0) {
    if (this.method2097()) {
      String local17 = arg0.toLowerCase();
      int local26 = this.index.aClass235_1.method5174(Static269.method3854(local17));

      return this.method2101(local26);
    } else {
      return false;
    }
  }

  @OriginalMember(owner = "client!fs", name = "a", descriptor = "(III)[B")
  public byte[] method2104(int arg0, int arg1) {
    return this.method2121(arg1, arg0, null);
  }

  @OriginalMember(owner = "client!fs", name = "b", descriptor = "(II)I")
  private int method2105(int arg0) {
    if (this.method2106(arg0)) {
      return this.anObjectArray3[arg0] == null
          ? this.resourceProvider.getDownloadPercentage(arg0)
          : 100;
    } else {
      return 0;
    }
  }

  @OriginalMember(owner = "client!fs", name = "c", descriptor = "(II)Z")
  private boolean method2106(int arg0) {
    if (!this.method2097()) {
      return false;
    } else if (arg0 >= 0
        && arg0 < this.index.anIntArray433.length
        && this.index.anIntArray433[arg0] != 0) {
      return true;
    } else if (SHOULD_THROW_EXCEPTION) {
      throw new IllegalArgumentException(Integer.toString(arg0));
    } else {
      return false;
    }
  }

  @OriginalMember(owner = "client!fs", name = "a", descriptor = "(Ljava/lang/String;I)Z")
  public boolean method2107(String arg0) {
    if (this.method2097()) {
      String local12 = arg0.toLowerCase();
      int local21 = this.index.aClass235_1.method5174(Static269.method3854(local12));

      return local21 >= 0;
    } else {
      return false;
    }
  }

  @OriginalMember(owner = "client!fs", name = "d", descriptor = "(II)I")
  public int method2108(int arg0) {
    return this.method2106(arg0) ? this.index.anIntArray433[arg0] : 0;
  }

  @OriginalMember(
      owner = "client!fs",
      name = "a",
      descriptor = "(Ljava/lang/String;ZLjava/lang/String;)[B")
  public byte[] method2109(String arg0, String arg1) {
    if (!this.method2097()) {
      return null;
    }

    String local18 = arg0.toLowerCase();
    String local21 = arg1.toLowerCase();
    int local30 = this.index.aClass235_1.method5174(Static269.method3854(local18));

    if (this.method2106(local30)) {
      int local48 = this.index.aClass235Array1[local30].method5174(Static269.method3854(local21));

      return this.method2104(local48, local30);
    } else {
      return null;
    }
  }

  @OriginalMember(owner = "client!fs", name = "c", descriptor = "(B)I")
  public int method2111() {
    if (!this.method2097()) {
      throw new IllegalStateException("");
    }

    return this.index.checksum;
  }

  @OriginalMember(owner = "client!fs", name = "b", descriptor = "(Z)I")
  public int method2112() {
    if (!this.method2097()) {
      return 0;
    }

    int local18 = 0;
    int local20 = 0;

    for (int i = 0; i < this.anObjectArray3.length; i++) {
      if (this.index.anIntArray428[i] > 0) {
        local18 += 100;
        local20 += this.method2105(i);
      }
    }

    if (local18 == 0) {
      return 100;
    } else {
      return local20 * 100 / local18;
    }
  }

  @OriginalMember(owner = "client!fs", name = "b", descriptor = "(Ljava/lang/String;B)I")
  public int method2113(String arg0) {
    if (this.method2097()) {
      String local17 = arg0.toLowerCase();
      int local26 = this.index.aClass235_1.method5174(Static269.method3854(local17));

      return this.method2105(local26);
    } else {
      return 0;
    }
  }

  @OriginalMember(owner = "client!fs", name = "a", descriptor = "(III[I)Z")
  private boolean method2114(int arg0, int arg1, int[] arg2) {
    if (!this.method2106(arg0)) {
      return false;
    } else if (this.anObjectArray3[arg0] == null) {
      return false;
    } else {
      int local25 = this.index.anIntArray428[arg0];
      int[] local31 = this.index.anIntArrayArray46[arg0];

      if (this.anObjectArrayArray1[arg0] == null) {
        this.anObjectArrayArray1[arg0] = new Object[this.index.anIntArray433[arg0]];
      }

      Object[] local51 = this.anObjectArrayArray1[arg0];
      boolean local53 = true;

      for (int i = 0; i < local25; i++) {
        int local63;

        if (local31 == null) {
          local63 = i;
        } else {
          local63 = local31[i];
        }

        if (local51[local63] == null) {
          local53 = false;
          break;
        }
      }

      if (local53) {
        return true;
      }

      byte[] local122;
      if (arg2 == null || arg2[0] == 0 && arg2[1] == 0 && arg2[2] == 0 && arg2[3] == 0) {
        local122 = Static366.method4930(false, this.anObjectArray3[arg0]);
      } else {
        local122 = Static366.method4930(true, this.anObjectArray3[arg0]);

        Packet local127 = new Packet(local122);

        local127.tinyKeyDecrypt(local127.data.length, arg2);
      }

      byte[] local149;
      try {
        local149 = Js5Compression.uncompress(local122);
      } catch (RuntimeException e) {
        throw Static350.method4724(
            e,
            "T3 - "
                + (arg2 != null)
                + ","
                + arg0
                + ","
                + local122.length
                + ","
                + CRC32Checksum.calculateChecksum(local122.length, local122)
                + ","
                + CRC32Checksum.calculateChecksum(local122.length - 2, local122)
                + ","
                + this.index.anIntArray430[arg0]
                + ","
                + this.index.checksum);
      }

      if (this.aBoolean230) {
        this.anObjectArray3[arg0] = null;
      }

      int local228;
      if (local25 > 1) {
        int local235;
        Packet local248;
        int local252;
        int local257;
        int local261;
        int local263;
        int local275;
        int local325;
        int local327;

        if (this.anInt2476 == 2) {
          local228 = local149.length;
          int local230 = local228 - 1;
          local235 = local149[local230] & 0xFF;
          int local243 = local230 - local25 * local235 * 4;
          local248 = new Packet(local149);
          int local250 = 0;
          local252 = 0;
          local248.pos = local243;
          for (local257 = 0; local257 < local235; local257++) {
            local261 = 0;
            for (local263 = 0; local263 < local25; local263++) {
              local261 += local248.g4();
              if (local31 == null) {
                local275 = local263;
              } else {
                local275 = local31[local263];
              }
              if (arg1 == local275) {
                local250 += local261;
                local252 = local275;
              }
            }
          }

          if (local250 == 0) {
            return true;
          }

          byte[] local312 = new byte[local250];
          local248.pos = local243;
          local250 = 0;
          local263 = 0;
          for (local275 = 0; local275 < local235; local275++) {
            local325 = 0;
            for (local327 = 0; local327 < local25; local327++) {
              local325 += local248.g4();
              int local339;
              if (local31 == null) {
                local339 = local327;
              } else {
                local339 = local31[local327];
              }
              if (arg1 == local339) {
                Static459.method3330(local149, local263, local312, local250, local325);
                local250 += local325;
              }
              local263 += local325;
            }
          }
          local51[local252] = local312;
        } else {
          local228 = local149.length;
          local228--;
          local235 = local149[local228] & 0xFF;
          local228 -= local25 * local235 * 4;
          local248 = new Packet(local149);
          int[] local410 = new int[local25];
          local248.pos = local228;
          for (local252 = 0; local252 < local235; local252++) {
            local257 = 0;
            for (local261 = 0; local261 < local25; local261++) {
              local257 += local248.g4();
              local410[local261] += local257;
            }
          }
          byte[][] local451 = new byte[local25][];
          for (local261 = 0; local261 < local25; local261++) {
            local451[local261] = new byte[local410[local261]];
            local410[local261] = 0;
          }
          local248.pos = local228;
          local263 = 0;
          for (local275 = 0; local275 < local235; local275++) {
            local325 = 0;
            for (local327 = 0; local327 < local25; local327++) {
              local325 += local248.g4();
              Static459.method3330(
                  local149, local263, local451[local327], local410[local327], local325);
              local263 += local325;
              local410[local327] += local325;
            }
          }
          for (local325 = 0; local325 < local25; local325++) {
            if (local31 == null) {
              local327 = local325;
            } else {
              local327 = local31[local325];
            }
            if (this.anInt2476 == 0) {
              local51[local327] =
                  ByteBufferBufferedBytes.attemptToBufferIfRequired(local451[local325]);
            } else {
              local51[local327] = local451[local325];
            }
          }
        }
      } else {
        if (local31 == null) {
          local228 = 0;
        } else {
          local228 = local31[0];
        }
        if (this.anInt2476 == 0) {
          local51[local228] = ByteBufferBufferedBytes.attemptToBufferIfRequired(local149);
        } else {
          local51[local228] = local149;
        }
      }
      return true;
    }
  }

  @OriginalMember(owner = "client!fs", name = "e", descriptor = "(II)V")
  public void method2115(int arg0) {
    if (this.method2106(arg0) && this.anObjectArrayArray1 != null) {
      this.anObjectArrayArray1[arg0] = null;
    }
  }

  @OriginalMember(owner = "client!fs", name = "b", descriptor = "(I)Z")
  public boolean method2116() {
    if (!this.method2097()) {
      return false;
    }

    boolean local13 = true;

    for (int i = 0; i < this.index.anIntArray431.length; i++) {
      int local23 = this.index.anIntArray431[i];

      if (this.anObjectArray3[local23] == null) {
        this.method2119(local23);

        if (this.anObjectArray3[local23] == null) {
          local13 = false;
        }
      }
    }

    return local13;
  }

  @OriginalMember(owner = "client!fs", name = "f", descriptor = "(II)I")
  public int method2117(int arg0) {
    if (this.method2097()) {
      int local16 = this.index.aClass235_1.method5174(arg0);

      return this.method2106(local16) ? local16 : -1;
    } else {
      return -1;
    }
  }

  @OriginalMember(owner = "client!fs", name = "c", descriptor = "(I)V")
  public void method2118() {
    if (this.anObjectArrayArray1 != null) {
      Arrays.fill(this.anObjectArrayArray1, null);
    }
  }

  @OriginalMember(owner = "client!fs", name = "g", descriptor = "(II)V")
  private void method2119(int arg0) {
    if (this.aBoolean230) {
      this.anObjectArray3[arg0] = this.resourceProvider.method3516(arg0);
    } else {
      this.anObjectArray3[arg0] =
          ByteBufferBufferedBytes.attemptToBufferIfRequired(this.resourceProvider.method3516(arg0));
    }
  }

  @OriginalMember(owner = "client!fs", name = "a", descriptor = "(BI)V")
  private void method2120(int arg0) {
    this.resourceProvider.method3512(arg0);
  }

  @OriginalMember(owner = "client!fs", name = "a", descriptor = "(II[IB)[B")
  public byte[] method2121(int arg0, int arg1, int[] arg2) {
    if (!this.method2127(arg0, arg1)) {
      return null;
    }

    if (this.anObjectArrayArray1[arg0] == null || this.anObjectArrayArray1[arg0][arg1] == null) {
      boolean local30 = this.method2114(arg0, arg1, arg2);

      if (!local30) {
        this.method2119(arg0);

        local30 = this.method2114(arg0, arg1, arg2);

        if (!local30) {
          return null;
        }
      }
    }

    byte[] local57 = Static366.method4930(false, this.anObjectArrayArray1[arg0][arg1]);

    if (this.anInt2476 == 1) {
      this.anObjectArrayArray1[arg0][arg1] = null;

      if (this.index.anIntArray433[arg0] == 1) {
        this.anObjectArrayArray1[arg0] = null;
      }
    } else if (this.anInt2476 == 2) {
      this.anObjectArrayArray1[arg0] = null;
    }

    return local57;
  }

  @OriginalMember(owner = "client!fs", name = "h", descriptor = "(II)[B")
  public byte[] method2122(int arg0) {
    if (!this.method2097()) {
      return null;
    } else if (this.index.anIntArray433.length == 1) {
      return this.method2104(arg0, 0);
    } else if (!this.method2106(arg0)) {
      return null;
    } else if (this.index.anIntArray433[arg0] == 1) {
      return this.method2104(0, arg0);
    } else {
      throw new RuntimeException();
    }
  }

  @OriginalMember(
      owner = "client!fs",
      name = "a",
      descriptor = "(ILjava/lang/String;Ljava/lang/String;)Z")
  public boolean method2123(String arg0, String arg1) {
    if (!this.method2097()) {
      return false;
    }

    String local21 = arg1.toLowerCase();
    String local24 = arg0.toLowerCase();
    int local33 = this.index.aClass235_1.method5174(Static269.method3854(local21));

    if (this.method2106(local33)) {
      int local51 = this.index.aClass235Array1[local33].method5174(Static269.method3854(local24));
      return this.method2098(local51, local33);
    } else {
      return false;
    }
  }

  @OriginalMember(owner = "client!fs", name = "i", descriptor = "(II)[I")
  public int[] method2124(int arg0) {
    if (!this.method2106(arg0)) {
      return null;
    }

    int[] local27 = this.index.anIntArrayArray46[arg0];

    if (local27 == null) {
      local27 = new int[this.index.anIntArray428[arg0]];
      int local38 = 0;
      while (local27.length > local38) {
        local27[local38] = local38++;
      }
    }

    return local27;
  }

  @OriginalMember(owner = "client!fs", name = "j", descriptor = "(II)Z")
  public boolean method2125(int arg0) {
    if (!this.method2097()) {
      return false;
    } else if (this.index.anIntArray433.length == 1) {
      return this.method2098(arg0, 0);
    } else if (!this.method2106(arg0)) {
      return false;
    } else if (this.index.anIntArray433[arg0] == 1) {
      return this.method2098(0, arg0);
    } else {
      throw new RuntimeException();
    }
  }

  @OriginalMember(owner = "client!fs", name = "b", descriptor = "(ILjava/lang/String;)V")
  public void method2126(String arg0) {
    if (this.method2097()) {
      String local11 = arg0.toLowerCase();
      int local28 = this.index.aClass235_1.method5174(Static269.method3854(local11));

      this.method2120(local28);
    }
  }

  @OriginalMember(owner = "client!fs", name = "a", descriptor = "(BII)Z")
  private boolean method2127(int arg0, int arg1) {
    if (!this.method2097()) {
      return false;
    } else if (arg0 >= 0
        && arg1 >= 0
        && this.index.anIntArray433.length > arg0
        && this.index.anIntArray433[arg0] > arg1) {
      return true;
    } else if (SHOULD_THROW_EXCEPTION) {
      throw new IllegalArgumentException(arg0 + "," + arg1);
    } else {
      return false;
    }
  }

  @OriginalMember(owner = "client!fs", name = "a", descriptor = "(ZIZ)V")
  public void method2128(boolean arg0) {
    if (!this.method2097()) {
      return;
    }

    this.index.anIntArrayArray47 = null;
    this.index.aClass235Array1 = null;

    if (arg0) {
      this.index.anIntArray432 = null;
      this.index.aClass235_1 = null;
    }
  }
}
