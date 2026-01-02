package com.jagex.client.preferences;

import com.jagex.client.*;
import com.jagex.client.utilities.ThreadingUtilities;
import com.jagex.signlink.FileOnDisk;
import com.jagex.signlink.Message;
import com.jagex.signlink.SignLink;
import jagex3.jagmisc.jagmisc;
import java.io.IOException;

public final class PreferencesImpl extends Preferences {

  public boolean aBoolean308 = false;

  public boolean aBoolean309 = false;

  public PreferencesImpl(SignLink arg0) {
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
    FileOnDisk local129 = null;
    try {
      Message local134 = arg0.emitResolvePreferencesFileLocationMessage("");
      while (local134.status == 0) {
        ThreadingUtilities.sleepFor(1L);
      }
      if (local134.status == 1) {
        local129 = (FileOnDisk) local134.output;
        byte[] local156 = new byte[(int) local129.bufferLength()];
        int local171;
        for (int local158 = 0; local158 < local156.length; local158 += local171) {
          local171 = local129.read(local158, local156.length - local158, local156);
          if (local171 == -1) {
            throw new IOException("EOF");
          }
        }
        this.method2862(new Packet(local156));
      }
    } catch (Exception local196) {
    }
    try {
      if (local129 != null) {
        local129.close();
      }
    } catch (Exception local203) {
    }
  }

  public void method2856(SignLink arg0) {
    FileOnDisk local7 = null;
    try {
      Message local20 = arg0.emitResolvePreferencesFileLocationMessage("");
      while (local20.status == 0) {
        ThreadingUtilities.sleepFor(1L);
      }
      if (local20.status == 1) {
        local7 = (FileOnDisk) local20.output;
        Packet local40 = this.method2863();
        local7.write(0, local40.pos, local40.data);
      }
    } catch (Exception local50) {
    }
    try {
      if (local7 != null) {
        local7.close();
      }
    } catch (Exception local57) {
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

  private void method2862(Packet arg0) {
    if (arg0.data.length - arg0.pos < 1) {
      return;
    }
    int local21 = arg0.g1();
    if (local21 < 0 || local21 > 17) {
      return;
    }
    byte local42;
    if (local21 == 17) {
      local42 = 40;
    } else if (local21 == 16) {
      local42 = 38;
    } else if (local21 == 15) {
      local42 = 37;
    } else if (local21 == 14) {
      local42 = 36;
    } else if (local21 == 13) {
      local42 = 35;
    } else if (local21 == 12) {
      local42 = 34;
    } else if (local21 == 11) {
      local42 = 33;
    } else if (local21 == 10) {
      local42 = 32;
    } else if (local21 == 9) {
      local42 = 31;
    } else if (local21 == 8) {
      local42 = 30;
    } else if (local21 == 7) {
      local42 = 29;
    } else if (local21 == 6) {
      local42 = 28;
    } else if (local21 == 5) {
      local42 = 28;
    } else if (local21 == 4) {
      local42 = 24;
    } else if (local21 == 3) {
      local42 = 23;
    } else if (local21 == 2) {
      local42 = 22;
    } else if (local21 == 1) {
      local42 = 23;
    } else {
      local42 = 19;
    }
    if (arg0.data.length - arg0.pos < local42) {
      return;
    }
    super.anInt3436 = arg0.g1();
    if (super.anInt3436 < 1) {
      super.anInt3436 = 1;
    } else if (super.anInt3436 > 4) {
      super.anInt3436 = 4;
    }
    this.method2859(arg0.g1() == 1);
    super.aBoolean306 = arg0.g1() == 1;
    super.aBoolean305 = arg0.g1() == 1;
    super.aBoolean296 = arg0.g1() == 1;
    super.anInt3433 = arg0.g1() == 1 ? 1 : 0;
    super.aBoolean295 = arg0.g1() == 1;
    super.aBoolean293 = arg0.g1() == 1;
    super.aBoolean302 = arg0.g1() == 1;
    super.anInt3435 = arg0.g1();
    if (super.anInt3435 > 2) {
      super.anInt3435 = 2;
    }
    if (local21 >= 17) {
      super.anInt3430 = arg0.g1();
    }
    if (local21 < 2) {
      super.aBoolean299 = arg0.g1() == 1;
      arg0.g1();
    } else {
      super.aBoolean299 = arg0.g1() == 1;
      if (local21 >= 17) {
        super.aBoolean301 = arg0.g1() == 1;
      }
    }
    super.aBoolean294 = arg0.g1() == 1;
    super.aBoolean298 = arg0.g1() == 1;
    super.anInt3442 = arg0.g1();
    if (super.anInt3442 > 2) {
      super.anInt3442 = 2;
    }
    super.anInt3440 = super.anInt3442;
    super.aBoolean291 = arg0.g1() == 1;
    super.anInt3448 = arg0.g1();
    if (super.anInt3448 > 127) {
      super.anInt3448 = 127;
    }
    super.anInt3439 = arg0.g1();
    super.anInt3449 = arg0.g1();
    if (super.anInt3449 > 127) {
      super.anInt3449 = 127;
    }
    if (local21 >= 1) {
      super.anInt3431 = arg0.g2();
      super.anInt3450 = arg0.g2();
    }
    if (local21 >= 3 && local21 < 6) {
      arg0.g1();
    }
    int local474;
    if (local21 >= 4) {
      local474 = arg0.g1();
      if (local474 < 0 || local474 > 2) {
        local474 = 0;
      }
      if (Static70.anInt1503 < 96) {
        local474 = 0;
      }
      Static157.setParticles(local474);
    }
    if (local21 >= 5) {
      super.anInt3428 = arg0.g4();
    }
    local474 = 0;
    if (local21 >= 6) {
      super.anInt3447 = local474 = arg0.g1();
    }
    if (super.anInt3447 != 1 && super.anInt3447 != 2) {
      super.anInt3447 = 2;
    }
    if (local21 >= 7) {
      super.aBoolean297 = arg0.g1() == 1;
    }
    if (local21 >= 8) {
      super.aBoolean303 = arg0.g1() == 1;
    }
    if (local21 >= 9) {
      super.anInt3434 = arg0.g1();
    }
    if (super.anInt3434 < 0 || super.anInt3434 > Static53.method898(Static70.anInt1503)) {
      super.anInt3434 = 0;
    }
    if (local21 >= 10) {
      super.aBoolean300 = arg0.g1() != 0;
    }
    if (local21 >= 11) {
      super.aBoolean304 = arg0.g1() != 0;
    }
    if (local21 >= 12) {
      super.anInt3433 = arg0.g1();
    }
    if (super.anInt3433 < 0 || super.anInt3433 > 2) {
      super.anInt3433 = 1;
    }
    if (local21 >= 13) {
      super.aBoolean289 = arg0.g1() == 1;
    }
    if (local21 >= 14) {
      super.anInt3445 = arg0.g1();
    } else if (local474 == 0) {
      super.anInt3445 = 2;
    } else {
      super.anInt3445 = 1;
    }
    if (super.anInt3445 < 0 || super.anInt3445 > 3) {
      super.anInt3445 = 2;
    }
    if (local21 >= 15) {
      super.anInt3437 = arg0.g1();
      if (super.anInt3437 < 0 || super.anInt3437 > 4) {
        super.anInt3437 = Static249.anInt4622 == 1 ? 2 : 4;
      }
    }
    if (local21 >= 16) {
      super.aBoolean307 = arg0.g1() == 1;
      try {
        if (jagmisc.getTotalPhysicalMemory() <= 268435456L) {
          super.aBoolean307 = false;
        }
      } catch (Throwable local736) {
      }
    }
    if (local21 < 17 && super.anInt3445 == 0) {
      super.anInt3445 = 2;
    }
  }

  public Packet method2863() {
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
