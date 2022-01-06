package com.open592.appletviewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// $FF: renamed from: app.f
final class class_12 extends WindowAdapter implements ActionListener {
   // $FF: renamed from: a app.f
   private static class_12 field_63;

   public final void windowClosing(WindowEvent var1) {
      AppletViewer.method_8();
   }

   public final void actionPerformed(ActionEvent var1) {
      AppletViewer.method_8();
   }

   private class_12() {
   }

   // $FF: renamed from: a (int) app.f
   static final class_12 method_32(int var0) {
      if (field_63 == null) {
         field_63 = new class_12();
      }

      return var0 != 17407 ? (class_12)null : field_63;
   }
}
