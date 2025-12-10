package jaggl.memory;

public final class NativeHeap {

  private long peer;

  private final int a;

  private boolean b;

  public NativeHeap(int arg0) {
    this.a = arg0;
    this.allocateHeap(this.a);
    this.b = true;
  }

  private native void deallocateHeap();

  public NativeBuffer a(int arg0) {
    if (!this.b) {
      throw new IllegalStateException();
    }
    return new NativeBuffer(this, this.allocateBuffer(arg0), arg0);
  }

  private synchronized native int allocateBuffer(int arg0);

  public synchronized native void put(int arg0, byte[] arg1, int arg2, int arg3);

  @Override
  public synchronized void finalize() throws Throwable {
    super.finalize();
    this.b();
  }

  private synchronized native void get(int arg0, byte[] arg1, int arg2, int arg3);

  public synchronized boolean a() {
    return this.b;
  }

  public synchronized native long getBufferAddress(int arg0);

  public synchronized void b() {
    if (this.b) {
      this.deallocateHeap();
    }
    this.b = false;
  }

  public synchronized native void deallocateBuffer(int arg0);

  private native void allocateHeap(int arg0);
}
