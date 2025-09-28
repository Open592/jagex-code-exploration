package com.jagex.client.jaggl.memory;

public final class NativeBuffer {

  private boolean a = true;

  private final NativeHeap c;

  private final int b;

  public final int d;

  public NativeBuffer(NativeHeap arg0, int arg1, int arg2) {
    this.c = arg0;
    this.b = arg1;
    this.d = arg2;
  }

  @Override
  public synchronized void finalize() throws Throwable {
    super.finalize();
    this.b();
  }

  public synchronized void a(byte[] arg0, int arg1, int arg2) {
    if (arg1 < 0 | !this.a() | arg0 == null | arg0.length < arg2 | this.d < arg1 + arg2) {
      throw new RuntimeException();
    }
    this.c.put(this.b, arg0, arg1, arg2);
  }

  private synchronized boolean a() {
    return this.c.a() && this.a;
  }

  private synchronized void b() {
    if (this.a()) {
      this.c.deallocateBuffer(this.b);
    }
    this.a = false;
  }

  public long c() {
    return this.c.getBufferAddress(this.b);
  }
}
