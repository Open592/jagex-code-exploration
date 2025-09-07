package com.jagex.appletviewer;

// $FF: renamed from: app.c
final class FileMetadata {
  /*
   * infoBuffer contains the entirety of the file's metadata
   *
   * Example:
   *
   * Name: browsercontrol64.dll
   * Digest-Algorithms: MD5 SHA1
   * MD5-Digest: rX4eUziU7xfmFNGDLE0Qng==
   * SHA1-Digest: TzPoBT0MuVHZ3Q9KxHaoxQTpHu0=
   */
  // $FF: renamed from: a byte[]
  byte[] bytes;
  // $FF: renamed from: b java.lang.String
  String md5Digest;
  // $FF: renamed from: c java.lang.String
  String name;
  // $FF: renamed from: d java.lang.String
  String sha1Digest;
}
