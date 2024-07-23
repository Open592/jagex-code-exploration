package com.jagex.appletviewer;

// $FF: renamed from: app.o
final class URLViewer implements Runnable {
   // $FF: renamed from: a java.lang.String
   private String target = null;
   // $FF: renamed from: b java.lang.String
   private String url = null;
   // $FF: renamed from: c app.o
   private static URLViewer classInstance = null;

   // $FF: renamed from: a (boolean) void
   static void initialize() {
      if (classInstance == null) {
         classInstance = new URLViewer();
         Thread thread = new Thread(classInstance);
         thread.setPriority(10);
         thread.setDaemon(true);
         thread.start();
      }
   }

   public void run() {
      while(true) {
         String target;
         String url;

         synchronized(this) {
            while(this.url == null) {
               try {
                  this.wait();
               } catch (InterruptedException ignored) {
               }
            }

            url = this.url;
            target = this.target;
            this.target = null;
            this.url = null;
         }

         try {
            if (null != target && target.equals("_top") && (url.endsWith("MAGICQUIT") || url.contains("/quit.ws") || !url.contains(".ws") && url.endsWith("/"))) {
               AppletViewer.quit();
            }

            if (!AppletViewer.isWindows) {
               throw new Exception("Not windows");
            }

            if (!url.startsWith("http://") && !url.startsWith("https://")) {
               throw new Exception();
            }

            String validChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

            for (int i = 0; i < url.length(); ++i) {
               if (validChars.indexOf(url.charAt(i)) == -1) {
                  throw new Exception();
               }
            }

            Runtime.getRuntime().exec("cmd /c start \"j\" \"" + url + "\"");
         } catch (Exception showURLException) {
            if (AppletViewer.isDebug) {
               showURLException.printStackTrace();
            }

            try {
               new CopyPasteURLDialog(url);
            } catch (Exception copyURLException) {
               if (AppletViewer.isDebug) {
                  copyURLException.printStackTrace();
               }
            }
         }
      }
   }

   public static void showurl(String url, String target) {
      synchronized(classInstance) {
         classInstance.target = target;
         classInstance.url = url;
         classInstance.notify();
      }
   }

   public URLViewer() {
   }
}
