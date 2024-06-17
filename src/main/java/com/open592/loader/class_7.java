package com.open592.loader;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Robot;
import java.awt.image.BufferedImage;

// $FF: renamed from: f
class class_7 {
   // $FF: renamed from: a java.awt.Component
   private Component field_27;
   // $FF: renamed from: b java.awt.Robot
   private Robot field_28;

   // $FF: renamed from: a (int, byte, int) void
   void method_14(int var1, byte var2, int var3) {
      try {
         this.field_28.mouseMove(var1, var3);
         int var4 = 38 % ((32 - var2) / 39);
      } catch (RuntimeException var5) {
         throw var5;
      }
   }

   // $FF: renamed from: a (boolean, java.awt.Component, boolean) void
   void method_15(boolean var1, Component var2, boolean var3) {
      try {
         if (!var1) {
            if (null == var2) {
               throw new NullPointerException();
            }
         } else {
            var2 = null;
         }

         if (!var3) {
            if (var2 != this.field_27) {
               if (this.field_27 != null) {
                  this.field_27.setCursor((Cursor)null);
                  this.field_27 = null;
               }

               if (var2 != null) {
                  var2.setCursor(var2.getToolkit().createCustomCursor(new BufferedImage(1, 1, 2), new Point(0, 0), (String)null));
                  this.field_27 = var2;
               }

            }
         }
      } catch (RuntimeException var5) {
         throw var5;
      }
   }

   // $FF: renamed from: a (int[], int, java.awt.Component, int, byte, java.awt.Point) void
   void method_16(int[] var1, int var2, Component var3, int var4, byte var5, Point var6) {
      try {
         if (var1 == null) {
            var3.setCursor((Cursor)null);
         } else {
            BufferedImage var7 = new BufferedImage(var2, var4, 2);
            var7.setRGB(0, 0, var2, var4, var1, 0, var2);
            var3.setCursor(var3.getToolkit().createCustomCursor(var7, var6, (String)null));
         }

         if (var5 <= 77) {
            this.field_28 = (Robot)null;
         }

      } catch (RuntimeException var8) {
         throw var8;
      }
   }

   class_7() throws Exception {
      try {
         this.field_28 = new Robot();
      } catch (RuntimeException var2) {
         throw var2;
      }
   }
}
