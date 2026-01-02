package com.jagex.client.preferences;

import com.jagex.client.*;
import com.jagex.client.utilities.ThreadingUtilities;
import com.jagex.signlink.FileOnDisk;
import com.jagex.signlink.Message;
import com.jagex.signlink.SignLink;
import jagex3.jagmisc.jagmisc;
import java.io.IOException;

public final class PreferencesImpl extends Preferences {
  private static int getPreferencesLength(int version) {
    byte len;

    if (version == 17) {
      len = 40;
    } else if (version == 16) {
      len = 38;
    } else if (version == 15) {
      len = 37;
    } else if (version == 14) {
      len = 36;
    } else if (version == 13) {
      len = 35;
    } else if (version == 12) {
      len = 34;
    } else if (version == 11) {
      len = 33;
    } else if (version == 10) {
      len = 32;
    } else if (version == 9) {
      len = 31;
    } else if (version == 8) {
      len = 30;
    } else if (version == 7) {
      len = 29;
    } else if (version == 6) {
      len = 28;
    } else if (version == 5) {
      len = 28;
    } else if (version == 4) {
      len = 24;
    } else if (version == 3) {
      len = 23;
    } else if (version == 2) {
      len = 22;
    } else if (version == 1) {
      len = 23;
    } else {
      len = 19;
    }

    return len;
  }

  public boolean aBoolean308 = false;

  public boolean aBoolean309 = false;

  public PreferencesImpl(SignLink signLink) {
    super.anInt3436 = 3;
    this.method2859(true);
    super.aBoolean295 = true;
    super.aBoolean293 = true;
    super.anInt3439 = 255;
    super.aBoolean305 = true;
    super.anInt3435 = 2;
    super.anInt3450 = 0;
    super.aBoolean306 = true;
    super.anInt3449 = 127;
    super.aBoolean298 = true;
    super.anInt3431 = 0;
    super.anInt3448 = 127;
    super.aBoolean296 = true;
    super.aBoolean294 = true;
    super.anInt3440 = 0;
    super.anInt3442 = 0;
    super.anInt3430 = 0;
    super.aBoolean299 = true;
    super.aBoolean291 = true;
    super.aBoolean301 = false;
    super.aBoolean302 = true;
    super.anInt3433 = 1;
    if (Static70.anInt1503 >= 96) {
      Static157.setParticles(2);
    } else {
      Static157.setParticles(0);
    }
    super.anInt3434 = 0;
    super.aBoolean303 = false;
    super.aBoolean289 = true;
    super.aBoolean304 = true;
    super.anInt3447 = 2;
    super.aBoolean297 = false;
    super.anInt3445 = 2;
    super.anInt3437 = Static249.anInt4622 == 1 ? 2 : 4;
    super.anInt3428 = 0;
    super.aBoolean300 = false;

    FileOnDisk preferencesFile = null;

    try {
      Message findPreferencesFileMessage = signLink.emitResolvePreferencesFileLocationMessage("");

      while (findPreferencesFileMessage.status == 0) {
        ThreadingUtilities.sleepFor(1L);
      }

      if (findPreferencesFileMessage.status == 1) {
        preferencesFile = (FileOnDisk) findPreferencesFileMessage.output;
        byte[] bytes = new byte[(int) preferencesFile.bufferLength()];
        int bytesRead;

        for (int pos = 0; pos < bytes.length; pos += bytesRead) {
          bytesRead = preferencesFile.read(pos, bytes.length - pos, bytes);

          if (bytesRead == -1) {
            throw new IOException("EOF");
          }
        }

        this.readFromBuffer(new Packet(bytes));
      }
    } catch (Exception ignored) {
    }

    try {
      if (preferencesFile != null) {
        preferencesFile.close();
      }
    } catch (Exception ignored) {
    }
  }

  public void writeToFile(SignLink signLink) {
    FileOnDisk preferencesFile = null;

    try {
      Message findPreferencesFileMessage = signLink.emitResolvePreferencesFileLocationMessage("");

      while (findPreferencesFileMessage.status == 0) {
        ThreadingUtilities.sleepFor(1L);
      }

      if (findPreferencesFileMessage.status == 1) {
        preferencesFile = (FileOnDisk) findPreferencesFileMessage.output;

        Packet encodedPreferences = this.encodePreferences();

        preferencesFile.write(0, encodedPreferences.pos, encodedPreferences.data);
      }
    } catch (Exception ignored) {
    }

    try {
      if (preferencesFile != null) {
        preferencesFile.close();
      }
    } catch (Exception ignored) {
    }
  }

  public boolean method2857(int arg0) {
    return arg0 == 0 ? super.aBoolean290 : true;
  }

  public int method2858(int arg0) {
    if (this.aBoolean309) {
      return 0;
    } else if (this.method2861(arg0)) {
      return super.aBoolean306 ? 2 : 1;
    } else {
      return 1;
    }
  }

  public void method2859(boolean arg0) {
    super.aBoolean290 = arg0;
    if (Static267.aClass262_2 != null) {
      Static267.aClass262_2.method5562(!this.method2861(Static177.anInt2973));
    }
  }

  public boolean method2861(int arg0) {
    return arg0 == 0 && !this.aBoolean308 ? super.aBoolean290 : true;
  }

  private void readFromBuffer(Packet buffer) {
    if (buffer.data.length - buffer.pos < 1) {
      return;
    }

    int version = buffer.g1();

    if (version < 0 || version > 17) {
      return;
    }

    int len = getPreferencesLength(version);

    if (buffer.data.length - buffer.pos < len) {
      return;
    }

    super.anInt3436 = buffer.g1();
    if (super.anInt3436 < 1) {
      super.anInt3436 = 1;
    } else if (super.anInt3436 > 4) {
      super.anInt3436 = 4;
    }
    this.method2859(buffer.g1() == 1);
    super.aBoolean306 = buffer.g1() == 1;
    super.aBoolean305 = buffer.g1() == 1;
    super.aBoolean296 = buffer.g1() == 1;
    super.anInt3433 = buffer.g1() == 1 ? 1 : 0;
    super.aBoolean295 = buffer.g1() == 1;
    super.aBoolean293 = buffer.g1() == 1;
    super.aBoolean302 = buffer.g1() == 1;
    super.anInt3435 = buffer.g1();
    if (super.anInt3435 > 2) {
      super.anInt3435 = 2;
    }
    if (version >= 17) {
      super.anInt3430 = buffer.g1();
    }
    if (version < 2) {
      super.aBoolean299 = buffer.g1() == 1;
      buffer.g1();
    } else {
      super.aBoolean299 = buffer.g1() == 1;
      if (version >= 17) {
        super.aBoolean301 = buffer.g1() == 1;
      }
    }
    super.aBoolean294 = buffer.g1() == 1;
    super.aBoolean298 = buffer.g1() == 1;
    super.anInt3442 = buffer.g1();
    if (super.anInt3442 > 2) {
      super.anInt3442 = 2;
    }
    super.anInt3440 = super.anInt3442;
    super.aBoolean291 = buffer.g1() == 1;
    super.anInt3448 = buffer.g1();
    if (super.anInt3448 > 127) {
      super.anInt3448 = 127;
    }
    super.anInt3439 = buffer.g1();
    super.anInt3449 = buffer.g1();
    if (super.anInt3449 > 127) {
      super.anInt3449 = 127;
    }
    if (version >= 1) {
      super.anInt3431 = buffer.g2();
      super.anInt3450 = buffer.g2();
    }
    if (version >= 3 && version < 6) {
      buffer.g1();
    }
    int local474;
    if (version >= 4) {
      local474 = buffer.g1();
      if (local474 < 0 || local474 > 2) {
        local474 = 0;
      }
      if (Static70.anInt1503 < 96) {
        local474 = 0;
      }
      Static157.setParticles(local474);
    }
    if (version >= 5) {
      super.anInt3428 = buffer.g4();
    }
    local474 = 0;
    if (version >= 6) {
      super.anInt3447 = local474 = buffer.g1();
    }
    if (super.anInt3447 != 1 && super.anInt3447 != 2) {
      super.anInt3447 = 2;
    }
    if (version >= 7) {
      super.aBoolean297 = buffer.g1() == 1;
    }
    if (version >= 8) {
      super.aBoolean303 = buffer.g1() == 1;
    }
    if (version >= 9) {
      super.anInt3434 = buffer.g1();
    }
    if (super.anInt3434 < 0 || super.anInt3434 > Static53.method898(Static70.anInt1503)) {
      super.anInt3434 = 0;
    }
    if (version >= 10) {
      super.aBoolean300 = buffer.g1() != 0;
    }
    if (version >= 11) {
      super.aBoolean304 = buffer.g1() != 0;
    }
    if (version >= 12) {
      super.anInt3433 = buffer.g1();
    }
    if (super.anInt3433 < 0 || super.anInt3433 > 2) {
      super.anInt3433 = 1;
    }
    if (version >= 13) {
      super.aBoolean289 = buffer.g1() == 1;
    }
    if (version >= 14) {
      super.anInt3445 = buffer.g1();
    } else if (local474 == 0) {
      super.anInt3445 = 2;
    } else {
      super.anInt3445 = 1;
    }
    if (super.anInt3445 < 0 || super.anInt3445 > 3) {
      super.anInt3445 = 2;
    }
    if (version >= 15) {
      super.anInt3437 = buffer.g1();
      if (super.anInt3437 < 0 || super.anInt3437 > 4) {
        super.anInt3437 = Static249.anInt4622 == 1 ? 2 : 4;
      }
    }
    if (version >= 16) {
      super.aBoolean307 = buffer.g1() == 1;

      try {
        if (jagmisc.getTotalPhysicalMemory() <= 268435456L) {
          super.aBoolean307 = false;
        }
      } catch (Throwable ignored) {
      }
    }

    if (version < 17 && super.anInt3445 == 0) {
      super.anInt3445 = 2;
    }
  }

  public Packet encodePreferences() {
    Packet local8 = new Packet(41);
    local8.p1(17);
    local8.p1(super.anInt3436);
    local8.p1(super.aBoolean290 ? 1 : 0);
    local8.p1(super.aBoolean306 ? 1 : 0);
    local8.p1(super.aBoolean305 ? 1 : 0);
    local8.p1(super.aBoolean296 ? 1 : 0);
    local8.p1(0);
    local8.p1(super.aBoolean295 ? 1 : 0);
    local8.p1(super.aBoolean293 ? 1 : 0);
    local8.p1(super.aBoolean302 ? 1 : 0);
    local8.p1(super.anInt3435);
    local8.p1(super.anInt3430);
    local8.p1(super.aBoolean299 ? 1 : 0);
    local8.p1(super.aBoolean301 ? 1 : 0);
    local8.p1(super.aBoolean294 ? 1 : 0);
    local8.p1(super.aBoolean298 ? 1 : 0);
    local8.p1(super.anInt3442);
    local8.p1(super.aBoolean291 ? 1 : 0);
    local8.p1(super.anInt3448);
    local8.p1(super.anInt3439);
    local8.p1(super.anInt3449);
    local8.p2(super.anInt3431);
    local8.p2(super.anInt3450);
    local8.p1(Static218.getParticles());
    local8.p4(super.anInt3428);
    local8.p1(super.anInt3447);
    local8.p1(super.aBoolean297 ? 1 : 0);
    local8.p1(super.aBoolean303 ? 1 : 0);
    local8.p1(super.anInt3434);
    local8.p1(super.aBoolean300 ? 1 : 0);
    local8.p1(super.aBoolean304 ? 1 : 0);
    local8.p1(super.anInt3433);
    local8.p1(super.aBoolean289 ? 1 : 0);
    local8.p1(super.anInt3445);
    local8.p1(super.anInt3437);
    local8.p1(super.aBoolean307 ? 1 : 0);
    return local8;
  }
}
