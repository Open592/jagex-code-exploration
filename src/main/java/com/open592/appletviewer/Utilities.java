package com.open592.appletviewer;

import java.util.Base64;

// $FF: renamed from: app.s
final class Utilities {
   // $FF: renamed from: a (int, byte[]) java.lang.String
   static String byteArrayToBase64String(byte[] byteArray) {
      Base64.Encoder encoder = Base64.getEncoder();

      return encoder.encodeToString(byteArray);
   }
}
