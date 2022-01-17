package com.open592.appletviewer;

// $FF: renamed from: app.o
final class class_3 implements Runnable {
   // $FF: renamed from: a java.lang.String
   private String field_10 = null;
   // $FF: renamed from: b java.lang.String
   private String field_11 = null;
   // $FF: renamed from: c app.o
   private static class_3 field_12 = null;

   // $FF: renamed from: a (boolean) void
   static final void method_1(boolean var0) {
      if (field_12 == null) {
         field_12 = new class_3();
         Thread var1 = new Thread(field_12);
         var1.setPriority(10);
         var1.setDaemon(var0);
         var1.start();
      }
   }

   public final void run() {
      while(true) {
         String var1 = null;
         String var2 = null;
         synchronized(this) {
            while(this.field_11 == null) {
               try {
                  this.wait();
               } catch (InterruptedException var7) {
               }
            }

            var2 = this.field_11;
            var1 = this.field_10;
            this.field_10 = null;
            this.field_11 = null;
         }

         try {
            if (null != var1 && var1.equals("_top") && (var2.endsWith("MAGICQUIT") || var2.contains("/quit.ws") || !var2.contains(".ws") && var2.endsWith("/"))) {
               AppletViewer.method_8();
            }

            if (!AppletViewer.field_39) {
               throw new Exception("Not windows");
            }

            if (!var2.startsWith("http://") && !var2.startsWith("https://")) {
               throw new Exception();
            }

            String var3 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";
            int var4 = 0;

            while(~var2.length() < ~var4) {
               if (var3.indexOf(var2.charAt(var4)) == -1) {
                  throw new Exception();
               }

               ++var4;
            }

            Runtime.getRuntime().exec("cmd /c start \"j\" \"" + var2 + "\"");
         } catch (Exception var10) {
            if (AppletViewer.isDebug) {
               var10.printStackTrace();
            }

            try {
               new class_6(var2);
            } catch (Exception var9) {
               if (AppletViewer.isDebug) {
                  var9.printStackTrace();
               }
            }
         }
      }
   }

   public static final void showurl(String var0, String var1) {
      synchronized(field_12) {
         field_12.field_10 = var1;
         field_12.field_11 = var0;
         field_12.notify();
      }
   }

   public class_3() {
   }
}
