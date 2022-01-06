package com.open592.appletviewer;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.OutputStream;
import java.io.PrintStream;

// $FF: renamed from: app.l
final class class_14 extends OutputStream implements WindowListener {
   // $FF: renamed from: a java.awt.TextArea
   private TextArea field_69;
   // $FF: renamed from: b java.lang.StringBuffer
   private StringBuffer field_70 = new StringBuffer(1024);
   // $FF: renamed from: c java.awt.Frame
   private Frame field_71;
   // $FF: renamed from: d java.lang.String
   private String field_72;
   // $FF: renamed from: e java.io.PrintStream
   private PrintStream field_73;
   // $FF: renamed from: f boolean
   private boolean field_74 = false;
   // $FF: renamed from: g app.l
   private static class_14 field_75;

   public final void windowIconified(WindowEvent var1) {
   }

   public final void windowOpened(WindowEvent var1) {
   }

   public final void windowClosed(WindowEvent var1) {
   }

   public final void windowClosing(WindowEvent var1) {
      this.field_71.setVisible(false);
      this.field_74 = false;
   }

   // $FF: renamed from: a (java.lang.String, int) java.io.PrintStream
   static final PrintStream method_34(String var0, int var1) {
      if (null == field_75) {
         field_75 = new class_14(var0);
      }

      if (var1 != -24134) {
         field_75 = (class_14)null;
      }

      return field_75.field_73;
   }

   public final void write(int var1) {
      synchronized(this) {
         if (var1 == 10) {
            if (!this.field_74) {
               this.field_71 = new Frame();
               this.field_71.add(this.field_69, "Center");
               this.field_71.setVisible(true);
               this.field_71.setTitle(this.field_72);
               this.field_71.setLocation(320, 240);
               this.field_71.setSize(720, 260);
               this.field_71.addWindowListener(this);
               this.field_74 = true;
            }

            this.field_70.append("\n");
            this.field_69.append(this.field_70.toString());
            this.field_70 = new StringBuffer(1024);
            if (AppletViewerPreferences.field_91 == 0) {
               return;
            }
         }

         this.field_70.append(String.valueOf((char)var1));
      }
   }

   public final void windowActivated(WindowEvent var1) {
   }

   public final void windowDeiconified(WindowEvent var1) {
   }

   public final void windowDeactivated(WindowEvent var1) {
   }

   private class_14(String var1) {
      this.field_72 = var1;
      this.field_69 = new TextArea();
      this.field_69.setEditable(false);
      this.field_73 = new PrintStream(this, true);
   }
}
