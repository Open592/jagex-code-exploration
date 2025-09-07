package com.jagex.client.env;

import java.util.Arrays;
import java.util.Optional;

public enum ModeWhat {
  LIVE("LIVE", 0),
  RC("RC", 1),
  WIP("WIP", 2);

  public static Optional<ModeWhat> fromId(int id) {
    return Arrays.stream(ModeWhat.values()).filter(modeWhat -> modeWhat.id == id).findFirst();
  }

  public static Optional<ModeWhat> fromName(String name) {
    return Arrays.stream(ModeWhat.values())
        .filter(modeWhat -> modeWhat.name.equals(name.toUpperCase()))
        .findFirst();
  }

  private final String name;
  private final int id;

  ModeWhat(String name, int id) {
    this.name = name;
    this.id = id;
  }

  public int getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  @Override
  public String toString() {
    throw new IllegalStateException();
  }
}
