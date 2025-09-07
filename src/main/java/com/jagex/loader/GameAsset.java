package com.jagex.loader;

// $FF: renamed from: b
public class GameAsset {
  // $FF: renamed from: a java.lang.String[]
  public String[] loadingStatusContent;
  // $FF: renamed from: b int
  public int compressedSize;
  // $FF: renamed from: c int
  public int uncompressedSize;
  // $FF: renamed from: d java.lang.String
  public String localFilename;
  // $FF: renamed from: e java.lang.String
  public String remoteFilename;
  // $FF: renamed from: f int[]
  public int[] sha1Bytes;

  public GameAsset(
      String localFilename,
      String remoteFilename,
      String[] loadingStatusContent,
      int uncompressedSize,
      int compressedSize,
      int[] sha1Bytes) {
    try {
      this.localFilename = localFilename;
      this.remoteFilename = remoteFilename;
      this.loadingStatusContent = loadingStatusContent;
      this.uncompressedSize = uncompressedSize;
      this.compressedSize = compressedSize;
      this.sha1Bytes = sha1Bytes;
    } catch (RuntimeException e) {
      throw LoaderRuntimeException.create(
          e,
          "b.<init>("
              + (localFilename != null ? "{...}" : "null")
              + ','
              + (remoteFilename != null ? "{...}" : "null")
              + ','
              + (loadingStatusContent != null ? "{...}" : "null")
              + ','
              + uncompressedSize
              + ','
              + compressedSize
              + ','
              + (sha1Bytes != null ? "{...}" : "null")
              + ')');
    }
  }
}
