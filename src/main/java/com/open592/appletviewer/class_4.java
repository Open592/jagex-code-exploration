package com.open592.appletviewer;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

// $FF: renamed from: app.n
final class class_4 extends Canvas implements MouseListener, MouseMotionListener {
   // $FF: renamed from: a int
   private int field_13 = 0;
   // $FF: renamed from: b java.awt.event.ActionListener
   private ActionListener field_14;
   // $FF: renamed from: c java.lang.String[]
   private String[] field_15 = new String[10];
   // $FF: renamed from: d int[]
   private int[] field_16 = null;
   // $FF: renamed from: e int
   private int field_17 = 0;
   // $FF: renamed from: f int
   private int field_18 = -1;

   public final void mouseDragged(MouseEvent var1) {
      int var4 = AppletViewerPreferences.field_91;
      this.field_13 = var1.getX();
      var1.getY();
      int var2 = this.field_18;
      if (null != this.field_16) {
         this.field_18 = -1;
         int var3 = 0;

         while(var3 < -1 + this.field_16.length) {
            if (this.field_16[var3] <= this.field_13 && ~(this.field_13 - -10) > ~this.field_16[1 + var3]) {
               this.field_18 = var3;
               if (var4 == 0) {
                  break;
               }
            }

            ++var3;
            if (var4 != 0) {
               break;
            }
         }

         if (~this.field_18 != ~var2) {
            this.repaint();
         }
      }

   }

   // $FF: renamed from: a (java.lang.String, boolean) void
   final void method_2(String var1, boolean var2) {
      if (~this.field_17 <= ~this.field_15.length) {
         String[] var3 = new String[5 + this.field_15.length];
         System.arraycopy(this.field_15, 0, var3, 0, this.field_15.length);
         this.field_15 = var3;
      }

      this.field_15[this.field_17++] = var1;
      if (var2) {
         this.mousePressed((MouseEvent)null);
      }

   }

   public final void mouseReleased(MouseEvent var1) {
      int var4 = AppletViewerPreferences.field_91;
      this.field_13 = var1.getX();
      var1.getY();
      int var2 = this.field_18;
      if (this.field_16 != null) {
         this.field_18 = -1;
         int var3 = 0;

         while(-1 + this.field_16.length > var3) {
            if (this.field_16[var3] <= this.field_13 && ~this.field_16[1 + var3] < ~(this.field_13 + 10)) {
               this.field_18 = var3;
               if (var4 == 0) {
                  break;
               }
            }

            ++var3;
            if (var4 != 0) {
               break;
            }
         }

         if (~var2 != ~this.field_18) {
            this.repaint();
         }
      }

   }

   public final void update(Graphics var1) {
      this.paint(var1);
   }

   public final void mousePressed(MouseEvent var1) {
      int var4 = AppletViewerPreferences.field_91;
      this.field_13 = var1.getX();
      var1.getY();
      int var2 = this.field_18;
      if (null != this.field_16) {
         this.field_18 = -1;
         int var3 = 0;

         while(-1 + this.field_16.length > var3) {
            if (~this.field_16[var3] >= ~this.field_13 && this.field_16[var3 + 1] > this.field_13 + 10) {
               this.field_18 = -1;
               this.field_13 = 0;
               this.repaint();
               this.field_14.actionPerformed(new ActionEvent(this, var3, ""));
               if (var4 == 0) {
                  break;
               }
            }

            ++var3;
            if (var4 != 0) {
               break;
            }
         }

         if (~this.field_18 != ~var2) {
            this.repaint();
         }
      }

   }

   public final void mouseExited(MouseEvent var1) {
      this.field_13 = 0;
      this.field_18 = -1;
      this.repaint();
   }

   public final void mouseClicked(MouseEvent var1) {
   }

   public final void paint(Graphics var1) {
      int var9 = AppletViewerPreferences.field_91;
      int var2 = this.getWidth();
      int var3 = this.getHeight();
      var1.setColor(Color.BLACK);
      var1.fillRect(0, 0, var2, var3);
      var1.setFont(this.getFont());
      FontMetrics var4 = var1.getFontMetrics();
      int var5 = 10;
      int var6 = var4.getAscent() + (-var4.getHeight() + var3) / 2;
      if (null == this.field_16 || ~(this.field_17 + 1) != ~this.field_16.length) {
         this.field_16 = new int[1 + this.field_17];
      }

      int var7 = 0;

      while(~var7 > ~this.field_17) {
         int var8;
         label38: {
            var8 = var5;
            this.field_16[var7] = var5;
            var5 += var4.stringWidth(this.field_15[var7]);
            if (~this.field_13 > ~var8 || var5 <= this.field_13) {
               var1.setColor(this.getForeground());
               if (var9 == 0) {
                  break label38;
               }
            }

            var1.setColor(Color.YELLOW);
         }

         var1.drawString(this.field_15[var7], var8, var6);
         var5 += 10;
         ++var7;
         if (var9 != 0) {
            break;
         }
      }

      this.field_16[this.field_17] = var5;
   }

   public final void mouseMoved(MouseEvent var1) {
      int var4 = AppletViewerPreferences.field_91;
      this.field_13 = var1.getX();
      var1.getY();
      int var2 = this.field_18;
      if (null != this.field_16) {
         this.field_18 = -1;
         int var3 = 0;

         while(~var3 > ~(this.field_16.length - 1)) {
            if (this.field_13 >= this.field_16[var3] && ~this.field_16[var3 - -1] < ~(10 + this.field_13)) {
               this.field_18 = var3;
               if (var4 == 0) {
                  break;
               }
            }

            ++var3;
            if (var4 != 0) {
               break;
            }
         }

         if (this.field_18 != var2) {
            this.repaint();
         }
      }

   }

   public final void mouseEntered(MouseEvent var1) {
   }

   class_4(ActionListener var1) {
      this.field_14 = var1;
      this.addMouseListener(this);
      this.addMouseMotionListener(this);
   }
}
