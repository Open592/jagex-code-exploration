package com.open592.appletviewer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.StringTokenizer;

// $FF: renamed from: app.v
final class class_0 extends Component implements MouseListener, MouseMotionListener {
   // $FF: renamed from: a java.awt.Color
   private static Color field_0 = new Color(12410);
   // $FF: renamed from: b app.k[][]
   private class_15[][] field_1;
   // $FF: renamed from: c java.awt.Color
   private static Color field_2 = new Color(16777215);
   // $FF: renamed from: d java.awt.Color
   private static Color field_3 = new Color(16765440);
   // $FF: renamed from: e app.e[]
   private class_18[] field_4;

   public final void mouseEntered(MouseEvent var1) {
   }

   public final void mouseExited(MouseEvent var1) {
   }

   public final void mouseDragged(MouseEvent var1) {
   }

   public final void mousePressed(MouseEvent var1) {
      Point var2 = var1.getPoint();
      int var3 = 0;

      while(~this.field_4.length < ~var3) {
         if (this.field_4[var3].field_81.contains(var2)) {
            class_3.showurl(this.field_4[var3].field_82, null);
         }

         ++var3;
      }

   }

   public final void mouseReleased(MouseEvent var1) {
   }

   public final void paint(Graphics var1) {
      int var2 = this.getWidth();
      FontMetrics var3 = var1.getFontMetrics();
      int var4 = var3.getHeight();
      int var5 = var4;
      if (this.field_1 != null) {
         int var6 = 0;

         while(~this.field_1.length < ~var6) {
            class_15[] var7 = this.field_1[var6];
            int var8 = 0;
            int var9 = 0;

            while(var9 < var7.length) {
               var8 += var3.stringWidth(var7[var9].field_77);
               ++var9;
            }

            var9 = (var2 + -var8) / 2;
            int var10 = 0;

            while(~var7.length < ~var10) {
               class_15 var11;
               int var12;
               label32: {
                  var11 = var7[var10];
                  var12 = var3.stringWidth(var11.field_77);
                  class_18 var13 = var11.field_76;
                  if (var13 == null) {
                     var1.setColor(field_2);
                     break label32;
                  }

                  var1.setColor(field_3);
                  Rectangle var14 = var13.field_81;
                  var14.y = -var4 + var5;
                  var14.x = var9;
                  var14.width = var12;
                  var14.height = var4;
               }

               var1.drawString(var11.field_77, var9, var5);
               var9 += var12;
               ++var10;
            }

            var5 += var4;
            ++var6;
         }
      }
   }

   public final void mouseClicked(MouseEvent var1) {
   }

   public final void mouseMoved(MouseEvent var1) {
      Point var2 = var1.getPoint();
      int var3 = 0;

      while(~this.field_4.length < ~var3) {
         if (this.field_4[var3].field_81.contains(var2)) {
            this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            return;
         }

         ++var3;
      }

      this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
   }

   // $FF: renamed from: a (byte, java.lang.String) void
   private final void method_0(byte var1, String var2) {
      if (null != var2) {
         StringTokenizer var3 = new StringTokenizer(var2, "\\");
         int var4 = -94 / ((var1 - -11) / 55);
         this.field_1 = new class_15[var3.countTokens()][];
         class_15[] var5 = new class_15[100];
         int var6 = 0;

         while(var3.hasMoreTokens()) {
            int var7 = 0;
            String var8 = var3.nextToken();

            do {
               int var9 = var8.indexOf(91);
               if (0 > var9) {
                  var5[var7++] = new class_15(var8);
                  break;
               }

               if (var9 > 0) {
                  var5[var7++] = new class_15(var8.substring(0, var9));
                  var8 = var8.substring(var9);
               }

               int var10 = var8.indexOf(34);
               if (var10 < 0) {
                  break;
               }

               int var11 = var8.indexOf(34, var10 - -1);
               if (0 > var11) {
                  break;
               }

               int var12 = var8.indexOf(93);
               if (0 > var12) {
                  break;
               }

               String var13 = var8.substring(1 + var10, var11);
               String var14 = var8.substring(var11 - -1, var12).trim();
               var5[var7++] = new class_15(var14, var13);
               if (1 + var12 >= var8.length()) {
                  break;
               }

               var8 = var8.substring(var12 - -1);
            } while(true);

            this.field_1[var6] = new class_15[var7];
            System.arraycopy(var5, 0, this.field_1[var6], 0, var7);
            ++var6;
         }

      }
   }

   class_0(String var1) {
      super();
      this.field_1 = (class_15[][])null;
      this.setBackground(field_0);
      this.addMouseListener(this);
      this.addMouseMotionListener(this);
      this.method_0((byte)-111, var1);
      if (null != this.field_1) {
         int var2 = 0;
         int var3 = 0;

         while(var3 < this.field_1.length) {
            class_15[] var4 = this.field_1[var3];
            int var5 = 0;

            while(var4.length > var5) {
               if (var4[var5].field_76 != null) {
                  ++var2;
               }

               ++var5;
            }

            ++var3;
         }

         this.field_4 = new class_18[var2];
         var3 = 0;
         int var8 = 0;

         while(var8 < this.field_1.length) {
            class_15[] var9 = this.field_1[var8];
            int var6 = 0;

            while(~var9.length < ~var6) {
               if (var9[var6].field_76 != null) {
                  this.field_4[var3++] = var9[var6].field_76;
               }

               ++var6;
            }

            ++var8;
         }
      }
   }
}
