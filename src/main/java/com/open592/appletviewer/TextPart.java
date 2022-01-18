package com.open592.appletviewer;

// $FF: renamed from: app.k
final class TextPart {
   // $FF: renamed from: a app.e
   TextURL URL = null;
   // $FF: renamed from: b java.lang.String
   String title;

   TextPart(String var1) {
      this.title = var1;
   }

   TextPart(String title, String URL) {
      this.title = title;
      this.URL = new TextURL(URL);
   }
}
