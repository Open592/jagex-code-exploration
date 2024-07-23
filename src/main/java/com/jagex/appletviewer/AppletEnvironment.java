package com.jagex.appletviewer;

import java.applet.Applet;
import java.applet.AppletContext;
import java.applet.AppletStub;
import java.applet.AudioClip;
import java.awt.*;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.InvalidParameterException;
import java.util.Enumeration;
import java.util.Iterator;

// $FF: renamed from: app.a
final class AppletEnvironment implements AppletStub, AppletContext {
   public void showDocument(URL var1) {
      if (AppletViewer.isDebug) {
         System.out.println("showdocument url:" + var1);
      }

      URLViewer.showurl(var1.toString(), null);
   }

   public AudioClip getAudioClip(URL var1) {
      throw new UnsupportedOperationException();
   }

   public InputStream getStream(String var1) {
      throw new UnsupportedOperationException();
   }

   public Iterator getStreamKeys() {
      throw new UnsupportedOperationException();
   }

   public Image getImage(URL var1) {
      throw new UnsupportedOperationException();
   }

   public void setStream(String var1, InputStream var2) {
      throw new UnsupportedOperationException();
   }

   public boolean isActive() {
      return true;
   }

   public String getParameter(String name) {
      String result = AppletViewer.getParameter(name);

      if (AppletViewer.isDebug && result == null) {
         if ("force64mb".equals(name)) {
            System.out.println("Returning false for force64mb");
            return "false";
         }

         System.out.println("Unavailable param:" + name);
      }

      return result;
   }

   public Applet getApplet(String var1) {
      throw new UnsupportedOperationException();
   }

   public void showDocument(URL url, String target) {
      if (AppletViewer.isDebug) {
         System.out.println("showdocument url:" + url + " target:" + target);
      }

      URLViewer.showurl(url.toString(), target);
   }

   public void showStatus(String var1) {
      throw new UnsupportedOperationException();
   }

   public void appletResize(int var1, int var2) {
   }

   public Enumeration getApplets() {
      throw new UnsupportedOperationException();
   }

   public AppletEnvironment() {
   }

   public URL getDocumentBase() {
      try {
         return new URL(AppletViewer.getConfigValue("codebase"));
      } catch (MalformedURLException var2) {
         throw new InvalidParameterException();
      }
   }

   public URL getCodeBase() {
      try {
         return new URL(AppletViewer.getConfigValue("codebase"));
      } catch (MalformedURLException var2) {
         throw new InvalidParameterException();
      }
   }

   public AppletContext getAppletContext() {
      return this;
   }
}
