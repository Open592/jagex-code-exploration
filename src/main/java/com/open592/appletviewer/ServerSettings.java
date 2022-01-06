package com.open592.appletviewer;

import java.util.Hashtable;

// $FF: renamed from: app.q
final class ServerSettings {
   // $FF: renamed from: a java.util.Hashtable
   Hashtable<String, String> configValues = new Hashtable<>();
   // $FF: renamed from: b java.lang.String
   String name;
   // $FF: renamed from: c java.util.Hashtable
   Hashtable<String, String> parameters = new Hashtable<>();
   // $FF: renamed from: d java.util.Hashtable
   Hashtable<String, String> localeStrings = new Hashtable<>();

   ServerSettings(String var1) {
      this.name = var1;
   }
}
