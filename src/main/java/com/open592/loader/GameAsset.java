package com.open592.loader;

// $FF: renamed from: b
public class GameAsset {
    // $FF: renamed from: a java.lang.String[]
    public String[] loadingStatusContent;
    // $FF: renamed from: b int
    public int field_1;
    // $FF: renamed from: c int
    public int field_2;
    // $FF: renamed from: d java.lang.String
    public String field_3;
    // $FF: renamed from: e java.lang.String
    public String field_4;
    // $FF: renamed from: f int[]
    public int[] sha1Hash;

    public GameAsset(String var1, String var2, String[] var3, int var4, int var5, int[] var6) {
        try {
            this.sha1Hash = var6;
            this.field_4 = var2;
            this.loadingStatusContent = var3;
            this.field_3 = var1;
            this.field_1 = var5;
            this.field_2 = var4;
        } catch (RuntimeException var8) {
            throw LoaderRuntimeException.create(var8, "b.<init>(" + (var1 != null ? "{...}" : "null") + ',' + (var2 != null ? "{...}" : "null") + ',' + (var3 != null ? "{...}" : "null") + ',' + var4 + ',' + var5 + ',' + (var6 != null ? "{...}" : "null") + ')');
        }
    }
}
