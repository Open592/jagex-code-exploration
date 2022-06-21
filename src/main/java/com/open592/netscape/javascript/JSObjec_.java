package com.open592.netscape.javascript;

import com.open592.appletviewer.AppletViewer;
import com.open592.appletviewer.AppletViewerPreferences;
import java.applet.Applet;

public class JSObjec_ {
   public Object eval(String var1) {
      System.out.println(var1);
      return null;
   }

   public static JSObjec_ getWindow(Applet var0) {
      return new JSObjec_();
   }

   public Object call(String command, Object[] args) {
      System.out.println("Received command: " + command);

      if ("zap".equals(command)) {
         AppletViewerPreferences.addPreference("yes", "Member");
         AppletViewerPreferences.writePreferencesToFile();

         AppletViewer.removeadvert();
         AppletViewer.hideContainerElements();
      }

      if ("unzap".equals(command)) {
         AppletViewerPreferences.addPreference("no", "Member");
         AppletViewerPreferences.writePreferencesToFile();

         AppletViewer.readdadvert();
         AppletViewer.hideContainerElements();
      }

      if ("loggedout".equals(command)) {
         AppletViewer.showContainerElements();
      }

      if ("resizing".equals(command) && args != null && args.length > 0 && args[0] instanceof Integer) {
         AppletViewer.doresize((Integer)args[0]);
      }

      return null;
   }
}
