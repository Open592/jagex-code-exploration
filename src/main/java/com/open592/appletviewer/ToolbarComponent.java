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
final class ToolbarComponent extends Canvas implements MouseListener, MouseMotionListener {
   // $FF: renamed from: a int
   private int field_13 = 0;
   // $FF: renamed from: b java.awt.event.ActionListener
   private ActionListener buttonHandler;
   // $FF: renamed from: c java.lang.String[]
   private String[] buttons = new String[10];
   // $FF: renamed from: d int[]
   private int[] field_16 = null;
   // $FF: renamed from: e int
   private int buttonCount = 0;
   // $FF: renamed from: f int
   private int field_18 = -1;

   public final void mouseDragged(MouseEvent var1) {
      this.field_13 = var1.getX();
      var1.getY();
      int var2 = this.field_18;
      if (null != this.field_16) {
         this.field_18 = -1;
         int var3 = 0;

         while(var3 < -1 + this.field_16.length) {
            if (this.field_16[var3] <= this.field_13 && ~(this.field_13 - -10) > ~this.field_16[1 + var3]) {
               this.field_18 = var3;
               break;
            }

            ++var3;
         }

         if (~this.field_18 != ~var2) {
            this.repaint();
         }
      }

   }

   // $FF: renamed from: a (java.lang.String, boolean) void
   void addButton(String title) {
      if (this.buttonCount >= this.buttons.length) {
         String[] resizedArray = new String[5 + this.buttons.length];

         System.arraycopy(this.buttons, 0, resizedArray, 0, this.buttons.length);

         this.buttons = resizedArray;
      }

      this.buttons[this.buttonCount++] = title;
   }

   public final void mouseReleased(MouseEvent var1) {
      this.field_13 = var1.getX();
      var1.getY();
      int var2 = this.field_18;
      if (this.field_16 != null) {
         this.field_18 = -1;
         int var3 = 0;

         while(-1 + this.field_16.length > var3) {
            if (this.field_16[var3] <= this.field_13 && ~this.field_16[1 + var3] < ~(this.field_13 + 10)) {
               this.field_18 = var3;
               break;
            }

            ++var3;
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
      this.field_13 = var1.getX();
      var1.getY();
      int var2 = this.field_18;
      if (null != this.field_16) {
         this.field_18 = -1;
         int var3 = 0;

         while(-1 + this.field_16.length > var3) {
            if (~this.field_16[var3] >= ~this.field_13 && this.field_16[var3 + 1] > this.field_13 + 10) {
               this.field_13 = 0;
               this.repaint();
               this.buttonHandler.actionPerformed(new ActionEvent(this, var3, ""));
               break;
            }

            ++var3;
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
      int var2 = this.getWidth();
      int var3 = this.getHeight();
      var1.setColor(Color.BLACK);
      var1.fillRect(0, 0, var2, var3);
      var1.setFont(this.getFont());
      FontMetrics var4 = var1.getFontMetrics();
      int var5 = 10;
      int var6 = var4.getAscent() + (-var4.getHeight() + var3) / 2;
      if (null == this.field_16 || ~(this.buttonCount + 1) != ~this.field_16.length) {
         this.field_16 = new int[1 + this.buttonCount];
      }

      int var7 = 0;

      while(~var7 > ~this.buttonCount) {
         int var8;
         label38: {
            var8 = var5;
            this.field_16[var7] = var5;
            var5 += var4.stringWidth(this.buttons[var7]);
            if (~this.field_13 > ~var8 || var5 <= this.field_13) {
               var1.setColor(this.getForeground());
               break label38;
            }

            var1.setColor(Color.YELLOW);
         }

         var1.drawString(this.buttons[var7], var8, var6);
         var5 += 10;
         ++var7;
      }

      this.field_16[this.buttonCount] = var5;
   }

   public final void mouseMoved(MouseEvent var1) {
      this.field_13 = var1.getX();
      var1.getY();
      int var2 = this.field_18;
      if (null != this.field_16) {
         this.field_18 = -1;
         int var3 = 0;

         while(~var3 > -this.field_16.length) {
            if (this.field_13 >= this.field_16[var3] && ~this.field_16[var3 - -1] < ~(10 + this.field_13)) {
               this.field_18 = var3;
               break;
            }

            ++var3;
         }

         if (this.field_18 != var2) {
            this.repaint();
         }
      }

   }

   public final void mouseEntered(MouseEvent var1) {
   }

   ToolbarComponent(ActionListener toolbarButtonHandler) {
      this.buttonHandler = toolbarButtonHandler;
      this.addMouseListener(this);
      this.addMouseMotionListener(this);
   }
}
