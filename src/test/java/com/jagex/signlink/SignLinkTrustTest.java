package com.jagex.signlink;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import sun.misc.Unsafe;

class SignLinkTrustTest {
  @Test
  void defaultAndExplicitModesAreChosenAtJvmStartup() throws Exception {
    String classpath =
        Paths.get(SignLink.class.getProtectionDomain().getCodeSource().getLocation().toURI())
            + File.pathSeparator
            + Paths.get(
                SignLinkTrustTest.class.getProtectionDomain().getCodeSource().getLocation().toURI());
    for (String mode : new String[] {"default", "1", "3", "4"}) {
      List<String> command = new ArrayList<>();
      command.add(Paths.get(System.getProperty("java.home"), "bin", "java").toString());
      if (!mode.equals("default")) {
        command.add("-Dcom.open592.signlink.mode=" + mode);
      }
      command.add("-cp");
      command.add(classpath);
      command.add(Probe.class.getName());
      command.add(mode.equals("default") ? "3" : mode);
      Process process = new ProcessBuilder(command).redirectErrorStream(true).start();
      try {
        assertTrue(process.waitFor(15, TimeUnit.SECONDS), "probe timed out: " + mode);
        assertEquals(
            0,
            process.exitValue(),
            new String(process.getInputStream().readAllBytes(), StandardCharsets.UTF_8));
      } finally {
        if (process.isAlive()) {
          process.destroyForcibly();
        }
      }
    }
  }

  public static class Probe {
    public static void main(String[] args) throws Exception {
      int expected = Integer.parseInt(args[0]);
      if (SignLink.anInt1987 != expected) {
        throw new AssertionError("wrong startup mode");
      }
      // Allocate capability fixtures without opening windows, caches, threads or natives.
      Field field = Unsafe.class.getDeclaredField("theUnsafe");
      field.setAccessible(true);
      Unsafe unsafe = (Unsafe) field.get(null);
      SignLink signlink = (SignLink) unsafe.allocateInstance(SignLink.class);
      if (signlink.isFullScreenModeSupported()) {
        throw new AssertionError("no display capability");
      }
      Field manager = SignLink.class.getDeclaredField("fullScreenManager");
      manager.setAccessible(true);
      manager.set(signlink, unsafe.allocateInstance(FullScreenManager.class));
      if (signlink.isFullScreenModeSupported() != (expected != 3)) {
        throw new AssertionError(
            "unsigned mode must remain disabled; opt-in mode requires capability");
      }
    }
  }
}
