package com.jagex.netscape.javascript;

import com.jagex.appletviewer.AppletViewer;
import com.jagex.appletviewer.AppletViewerPreferences;
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

    /**
     * TODO: Find the caller of this command and verify this.
     *
     * <p>This command is responsible for setting a flag in the appletviewer to specify if we should
     * respect the `applet_(max|min)size` settings.
     */
    if ("resizing".equals(command)
        && args != null
        && args.length > 0
        && args[0] instanceof Integer) {
      int argValue = (Integer) args[0];

      // We expect the arguments to be either 0 or 1 which represents boolean true/false. In case
      // we receive an invalid value we ignore the call.
      if (argValue != 0 && argValue != 1) {
        return null;
      }

      boolean shouldIgnoreAppletBounds = argValue != 0;

      AppletViewer.setShouldRestrictAppletSize(shouldIgnoreAppletBounds);
    }

    return null;
  }
}
