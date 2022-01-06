package com.open592.appletviewer;

import java.applet.Applet;
import java.applet.AppletContext;
import java.applet.AppletStub;
import java.applet.AudioClip;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.InvalidParameterException;
import java.util.Enumeration;
import java.util.Iterator;

// $FF: renamed from: app.a
final class class_17 implements AppletStub, AppletContext {
   public final void showDocument(URL var1) {
      if (AppletViewer.isDebug) {
         System.out.println("showdocument url:" + var1);
      }

      class_3.showurl(var1.toString(), (String)null);
   }

   public final AudioClip getAudioClip(URL var1) {
      throw new UnsupportedOperationException();
   }

   public final InputStream getStream(String var1) {
      throw new UnsupportedOperationException();
   }

   public final Iterator getStreamKeys() {
      throw new UnsupportedOperationException();
   }

   public final Image getImage(URL var1) {
      throw new UnsupportedOperationException();
   }

   public final void setStream(String var1, InputStream var2) throws IOException {
      throw new UnsupportedOperationException();
   }

   public final boolean isActive() {
      return true;
   }

   public final String getParameter(String var1) {
      String var2 = AppletViewer.getParameter(0, var1);
      if (AppletViewer.isDebug && var2 == null) {
         if ("force64mb".equals(var1)) {
            System.out.println("Returning false for force64mb");
            return "false";
         }

         System.out.println("Unavailable param:" + var1);
      }

      return var2;
   }

   public final Applet getApplet(String var1) {
      throw new UnsupportedOperationException();
   }

   public final void showDocument(URL var1, String var2) {
      if (AppletViewer.isDebug) {
         System.out.println("showdocument url:" + var1 + " target:" + var2);
      }

      class_3.showurl(var1.toString(), var2);
   }

   public final void showStatus(String var1) {
      throw new UnsupportedOperationException();
   }

   public final void appletResize(int var1, int var2) {
   }

   public final Enumeration getApplets() {
      throw new UnsupportedOperationException();
   }

   public class_17() {
   }

   public final URL getDocumentBase() {
      try {
         return new URL(AppletViewer.getConfigValue((byte)115, "codebase"));
      } catch (MalformedURLException var2) {
         throw new InvalidParameterException();
      }
   }

   public final URL getCodeBase() {
      try {
         return new URL(AppletViewer.getConfigValue((byte)-58, "codebase"));
      } catch (MalformedURLException var2) {
         throw new InvalidParameterException();
      }
   }

   public final AppletContext getAppletContext() {
      return this;
   }
}
