package com.jagex.client;

import java.awt.Component;
import org.openrs2.deob.annotation.OriginalArg;

public abstract class IMouseWheel {

  public static IMouseWheel create() {
    try {
      return (IMouseWheel)
          Class.forName("com.jagex.client.JavaMouseWheel").getDeclaredConstructor().newInstance();
    } catch (Throwable ignored) {
      return null;
    }
  }

  public abstract void addListener(@OriginalArg(1) Component arg0);

  public abstract int getWheelRotation();

  public abstract void removeListener(@OriginalArg(0) Component arg0);
}
