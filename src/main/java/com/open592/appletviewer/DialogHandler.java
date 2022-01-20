package com.open592.appletviewer;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

// $FF: renamed from: app.j
final class DialogHandler implements ActionListener, WindowListener {
   // $FF: renamed from: a int
   private int field_78;
   // $FF: renamed from: b java.awt.List
   private final List field_79;
   // $FF: renamed from: c java.awt.Dialog
   private final Dialog field_80;

   public final void windowClosed(WindowEvent var1) {
   }

   public final void windowDeactivated(WindowEvent var1) {
   }

   public final void windowClosing(WindowEvent var1) {
      this.method_37();
   }

   DialogHandler(String title) {
      super();
      Panel var2 = new Panel();
      this.field_79 = new List();
      var2.setLayout(new BorderLayout());
      var2.add(this.field_79, "Center");
      Panel var3 = new Panel();
      var3.setLayout(new GridLayout(1, 2));
      var2.add(var3, "South");
      Button var4 = new Button(AppletViewer.getLocaleString("ok"));
      var4.setActionCommand("ok");
      var4.addActionListener(this);
      Button var5 = new Button(AppletViewer.getLocaleString("cancel"));
      var5.setActionCommand("cancel");
      var5.addActionListener(this);
      var3.add(var4);
      var3.add(var5);
      this.field_80 = new Dialog(AppletViewer.frame, title, true);
      this.field_80.addWindowListener(this);
      this.field_80.setSize(200, 150);
      this.field_80.add(var2);
   }

   public final void actionPerformed(ActionEvent var1) {
      if (!var1.getActionCommand().equals("ok")) {
         this.method_37();
         return;
      }

      this.field_78 = this.field_79.getSelectedIndex();
      this.field_80.setVisible(false);
   }

   // $FF: renamed from: a (boolean, java.lang.String[]) void
   final void method_35(String[] var2) {
      this.field_79.removeAll();

      int var3 = 0;

      while(~var2.length < ~var3) {
         String var4 = var2[var3];
         if (var4 != null) {
            this.field_79.add(var4);
         }

         ++var3;
      }
   }

   public final void windowDeiconified(WindowEvent var1) {
   }

   public final void windowOpened(WindowEvent var1) {
   }

   // $FF: renamed from: a (byte) int
   final int method_36() {
      this.field_80.setLocationRelativeTo(AppletViewer.frame);
      this.field_80.setVisible(true);
      return this.field_78;
   }

   // $FF: renamed from: a (int) void
   private final void method_37() {
      this.field_78 = -1;
      this.field_80.setVisible(false);
   }

   public final void windowActivated(WindowEvent var1) {
   }

   public final void windowIconified(WindowEvent var1) {
   }
}
