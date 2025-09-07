package com.jagex.client;

import com.jagex.client.utilities.ThreadingUtilities;
import com.jagex.signlink.FileOnDisk;
import com.jagex.signlink.Message;
import java.io.IOException;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static228 {

  @OriginalMember(owner = "client!ln", name = "u", descriptor = "Lclient!l;")
  public static Class57 aClass57_11;

  @OriginalMember(owner = "client!ln", name = "m", descriptor = "Lclient!sl;")
  public static final Class215 aClass215_29 = new Class215(54, 12);

  @OriginalMember(owner = "client!ln", name = "r", descriptor = "Lclient!sl;")
  public static final Class215 aClass215_30 = new Class215(5, 5);

  @OriginalMember(owner = "client!ln", name = "b", descriptor = "(B)V")
  public static void method2068() {
    @Pc(11)
    FileOnDisk local11 = null;
    try {
      @Pc(16)
      Message local16 = GameShell.signLink.emitResolvePreferencesFileLocationMessage("2");
      while (local16.status == 0) {
        ThreadingUtilities.sleepFor(1L);
      }
      if (local16.status == 1) {
        local11 = (FileOnDisk) local16.output;
        @Pc(38)
        byte[] local38 = new byte[(int) local11.bufferLength()];
        @Pc(53)
        int local53;
        for (@Pc(40) int local40 = 0; local40 < local38.length; local40 += local53) {
          local53 = local11.read(local40, local38.length - local40, local38);
          if (local53 == -1) {
            throw new IOException("EOF");
          }
        }
        Static360.method4864(new Packet(local38));
      }
    } catch (
        @Pc(82)
        Exception local82) {
    }
    try {
      if (local11 != null) {
        local11.close();
      }
    } catch (
        @Pc(89)
        Exception local89) {
    }
  }
}
