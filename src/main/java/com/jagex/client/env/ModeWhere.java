package com.jagex.client.env;

import java.util.Arrays;
import java.util.Optional;

public enum ModeWhere {
    LIVE("LIVE", 0),
    WTRC("WTRC", 1),
    WTQA("WTQA", 2),
    WTWIP("WTWIP", 3),
    WTI("WTI", 5),
    LOCAL("LOCAL", 4);

    public static Optional<ModeWhere> fromName(String name) {
        return Arrays.stream(ModeWhere.values())
                .filter(modeWhere -> modeWhere.name.equals(name))
                .findFirst();
    }

    public static Optional<ModeWhere> fromId(int id) {
        return Arrays.stream(ModeWhere.values())
                .filter(modeWhere -> modeWhere.id == id)
                .findFirst();
    }

    private final String name;
    private final int id;

    ModeWhere(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public boolean isStagingEnvironment() {
        return this == WTRC
                || this == WTQA
                || this == WTWIP
                || this == WTI;
    }

    public boolean isLive() {
        return this == LIVE;
    }

    public boolean isLocal() {
        return this == LOCAL;
    }

    @Override
    public String toString() {
        throw new IllegalStateException();
    }
}
