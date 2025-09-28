package com.jagex.client.jaggl.memory;

public final class NativeStream {

  private int c;

  private int d;

  private final byte[] a;

  private final NativeBuffer b;

  public static native int floatToRawIntBits(float arg0);

  private static native byte getLSB(int arg0);

  public static boolean c() {
    return getLSB(-65536) == -1;
  }

  private NativeStream(NativeBuffer arg0, int arg1) {
    this.a = new byte[arg1];
    this.b = arg0;
  }

  public NativeStream(NativeBuffer arg0) {
    this(arg0, arg0.d < 4096 ? arg0.d : 4096);
  }

  public int a() {
    return this.d + this.c;
  }

  public void b() {
    if (this.d > 0) {
      this.b.a(this.a, this.c, this.d);
      this.c += this.d;
      this.d = 0;
    }
  }

  public void a(float arg0) {
    if (this.a.length <= this.d + 3) {
      this.b();
    }
    int local12 = floatToRawIntBits(arg0);
    this.a[this.d++] = (byte) (local12 >> 24);
    this.a[this.d++] = (byte) (local12 >> 16);
    this.a[this.d++] = (byte) (local12 >> 8);
    this.a[this.d++] = (byte) local12;
  }

  public void a(int arg0) {
    this.b();
    this.c = arg0;
  }

  public void b(float arg0) {
    if (this.a.length <= this.d + 3) {
      this.b();
    }
    int local12 = floatToRawIntBits(arg0);
    this.a[this.d++] = (byte) local12;
    this.a[this.d++] = (byte) (local12 >> 8);
    this.a[this.d++] = (byte) (local12 >> 16);
    this.a[this.d++] = (byte) (local12 >> 24);
  }

  public void b(int arg0) {
    if (this.a.length <= this.d) {
      this.b();
    }
    this.a[this.d++] = (byte) arg0;
  }
}
