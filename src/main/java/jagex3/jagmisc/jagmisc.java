package jagex3.jagmisc;

public final class jagmisc {

  public static native long nanoTime();

  public static int ping(byte arg0, byte arg1, byte arg2, byte arg3, long arg4) throws Throwable {
    int local6 = ping0(arg0, arg1, arg2, arg3, arg4);
    if (local6 < 0) {
      throw new Exception(String.valueOf(local6));
    }
    return local6;
  }

  private static native int ping0(byte arg0, byte arg1, byte arg2, byte arg3, long arg4);

  private static native void Quit0();

  public static native boolean init();

  public static void quit() {
    Quit0();
  }

  public static native long getAvailablePhysicalMemory();

  public static native long getTotalPhysicalMemory();

  private jagmisc() {}
}
