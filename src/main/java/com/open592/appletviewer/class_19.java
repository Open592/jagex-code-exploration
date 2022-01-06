package com.open592.appletviewer;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

// $FF: renamed from: app.d
final class class_19 {
   // $FF: renamed from: a java.awt.Dialog
   static Dialog field_83;
   // $FF: renamed from: b java.awt.Button
   private static Button field_84;

   // $FF: renamed from: a (java.lang.String, java.lang.String, byte, java.lang.String) void
   private static final void method_38(String var0, String var1, byte var2, String var3) {
      int var10 = AppletViewerPreferences.field_91;
      field_83 = new Dialog(AppletViewer.field_35, var1, true);
      int var4 = 0;
      int var5 = -1;

      do {
         ++var4;
         var5 = var3.indexOf(10, 1 + var5);
      } while(var5 >= 0);

      String[] var6 = new String[var4];
      Panel var7 = new Panel();
      var7.setLayout(new GridLayout(var4, 1));
      var5 = -1;
      var4 = 0;

      int var8;
      do {
         var8 = var5 + 1;
         var5 = var3.indexOf(10, var5 + 1);
         if (~var5 > -1) {
            var6[var4++] = var3.substring(var8);
            if (var10 == 0) {
               continue;
            }
         }

         var6[var4++] = var3.substring(var8, var5);
      } while(var5 >= 0);

      var8 = 0;

      while(~var8 > ~var6.length) {
         Label var9 = new Label(var6[var8], 1);
         var7.add(var9);
         ++var8;
         if (var10 != 0) {
            break;
         }
      }

      field_83.add(var7, "Center");
      field_84 = new Button(var0);
      Panel var11 = new Panel();
      var11.setLayout(new FlowLayout(1));
      var11.add(field_84);
      field_83.add(var11, "South");
      field_83.setResizable(false);
      if (var2 == 47) {
         field_83.setSize(500, 100);
         field_83.setLocationRelativeTo(AppletViewer.field_35);
      }
   }

   // $FF: renamed from: a (java.lang.String, byte) void
   static final void method_39(String var0, byte var1) {
      method_38(AppletViewer.getLocaleString("ok", 0), AppletViewer.getLocaleString("message", 0), (byte)47, var0);
      field_84.addActionListener(new class_2());
      int var2 = 108 / ((var1 - 54) / 58);
      field_83.setVisible(true);
   }

   // $FF: renamed from: a (byte, java.lang.String) void
   static final void method_40(byte var0, String var1) {
      class_9.method_28(true);
      method_38(AppletViewer.getLocaleString("quit", 0), AppletViewer.getLocaleString("error", 0), var0, var1);
      field_83.addWindowListener(class_12.method_32(17407));
      field_84.addActionListener(class_12.method_32(17407));
      field_83.setVisible(true);
   }
}
