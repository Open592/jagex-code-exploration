package com.jagex.client.preferences;

public abstract class Preferences {

  protected boolean aBoolean299;

  protected boolean aBoolean301;

  public boolean aBoolean303;

  public int anInt3428 = 0;

  public boolean aBoolean289 = true;

  public boolean aBoolean291 = true;

  public boolean aBoolean293 = true;

  protected boolean aBoolean290 = true;

  public boolean aBoolean295 = true;

  public int anInt3433 = 1;

  public int anInt3437 = 2;

  public int anInt3442 = 0;

  public int anInt3434 = 0;

  public boolean aBoolean297 = false;

  protected int anInt3430 = 0;

  public int anInt3431 = 0;

  public boolean aBoolean296 = true;

  public int anInt3440 = 0;

  public boolean aBoolean300 = false;

  protected int anInt3435 = 2;

  public int anInt3439 = 255;

  public int anInt3436 = 3;

  public int anInt3449 = 127;

  public int anInt3447 = 2;

  public int anInt3445 = 2;

  public int anInt3450 = 0;

  public int anInt3448 = 127;

  public boolean aBoolean298 = true;

  public boolean aBoolean294 = true;

  public boolean aBoolean307 = false;

  public boolean aBoolean305 = true;

  public boolean aBoolean306 = true;

  public boolean aBoolean304 = true;

  public boolean aBoolean302 = true;

  protected Preferences() {}

  public final int method2850(int arg0) {
    return arg0 == 1 || arg0 == 3 ? this.anInt3435 : this.anInt3430;
  }

  public final void method2852(int arg0, int arg1) {
    if (arg0 == 1 || arg0 == 3) {
      this.anInt3435 = arg1;
    } else {
      this.anInt3430 = arg1;
    }
  }

  public final boolean method2854(int arg0) {
    return arg0 == 1 || arg0 == 3 ? this.aBoolean299 : this.aBoolean301;
  }

  public final void method2855(boolean arg0, int arg1) {
    if (arg1 == 1 || arg1 == 3) {
      this.aBoolean299 = arg0;
    } else {
      this.aBoolean301 = arg0;
    }
  }
}
