package netscape.javascript;

import app.appletviewer;
import app.class_21;
import java.applet.Applet;

public class JSObjec_ {
   public Object eval(String var1) {
      System.out.println(var1);
      return null;
   }

   public static JSObjec_ getWindow(Applet var0) {
      return new JSObjec_();
   }

   public Object call(String var1, Object[] var2) {
      System.out.println("Received command: " + var1);
      if ("zap".equals(var1)) {
         class_21.method_43("yes", (byte)93, "Member");
         class_21.method_44(true);
         appletviewer.removeadvert();
         appletviewer.method_18(123);
      }

      if ("unzap".equals(var1)) {
         class_21.method_43("no", (byte)-79, "Member");
         class_21.method_44(true);
         appletviewer.readdadvert();
         appletviewer.method_18(122);
      }

      if ("loggedout".equals(var1)) {
         appletviewer.method_14(4443);
      }

      if ("resizing".equals(var1) && var2 != null && var2.length > 0 && var2[0] instanceof Integer) {
         appletviewer.doresize((Integer)var2[0]);
      }

      return null;
   }
}
