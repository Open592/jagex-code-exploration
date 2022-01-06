package com.open592.appletviewer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

// $FF: renamed from: app.i
final class class_9 extends Component {
   // $FF: renamed from: a java.awt.Font
   private Font field_56;
   // $FF: renamed from: b java.awt.Dialog
   private static Dialog field_57;
   // $FF: renamed from: c int
   private int field_58 = 0;
   // $FF: renamed from: d java.awt.Color
   private Color field_59 = new Color(140, 11, 1);
   // $FF: renamed from: e java.lang.String
   private String field_60 = "Loading...";
   // $FF: renamed from: f app.i
   private static class_9 field_61;
   // $FF: renamed from: g java.awt.FontMetrics
   private FontMetrics field_62;

   // $FF: renamed from: a (int, byte) void
   static final void method_25(int var0, byte var1) {
      if (null != field_61) {
         if (-101 > ~var0) {
            var0 = 100;
         }

         field_61.field_58 = var0;
         int var2 = 70 % ((-20 - var1) / 62);
         field_61.repaint();
      }
   }

   // $FF: renamed from: a (int) void
   static final void method_26(int var0) {
      if (var0 <= 97) {
         field_57 = (Dialog)null;
      }

      field_57.setLocationRelativeTo(AppletViewer.field_35);
      field_57.setVisible(true);
   }

   // $FF: renamed from: b (int) void
   static final void method_27(int var0) {
      if (var0 > -6) {
         field_61 = (class_9)null;
      }

      field_61.paint(field_61.getGraphics());
   }

   // $FF: renamed from: a (boolean) void
   static final void method_28(boolean var0) {
      if (null != field_57) {
         field_57.setVisible(false);
      }

      if (!var0) {
         method_29(false, (String)null);
      }

   }

   // $FF: renamed from: a (boolean, java.lang.String) void
   static final void method_29(boolean var0, String var1) {
      field_61.field_60 = var1;
      field_61.repaint();
      if (var0) {
         method_27(-101);
      }

   }

   public final void paint(Graphics var1) {
      try {
         if (null == var1) {
            this.repaint();
            if (AppletViewerPreferences.field_91 == 0) {
               return;
            }
         }

         var1.setColor(Color.black);
         var1.fillRect(0, 0, this.getSize().width, this.getSize().height);
         var1.setColor(this.field_59);
         var1.drawRect(this.getSize().width / 2 - 152, this.getSize().height / 2 + -18, 303, 33);
         var1.fillRect(-152 + this.getSize().width / 2 - -2, -18 + (this.getSize().height / 2 - -2), this.field_58 * 303 / 100 - 3, 30);
         String var2 = this.field_60 + " - " + this.field_58 + "%";
         var1.setFont(this.field_56);
         var1.setColor(Color.white);
         var1.drawString(var2, (this.getSize().width + -this.field_62.stringWidth(var2)) / 2, 4 + this.getSize().height / 2);
      } catch (Exception var3) {
      }

   }

   private class_9(String var1) {
      this.field_60 = var1;
   }

   // $FF: renamed from: c (int) void
   static final void method_30(int var0) {
      field_61 = new class_9(AppletViewer.getLocaleString("loaderbox_initial", 0));
      field_61.field_56 = new Font("Helvetica", 1, 13);
      field_61.field_62 = field_61.getFontMetrics(field_61.field_56);
      field_57 = new Dialog(AppletViewer.field_35, "Jagex Ltd.", false);
      field_57.add(field_61);
      field_57.addWindowListener(class_12.method_32(var0 + 17087));
      field_57.setResizable(false);
      field_57.setSize(var0, 100);
   }
}
