package com.open592.appletviewer;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// $FF: renamed from: app.t
final class class_6 extends WindowAdapter implements ActionListener {
   // $FF: renamed from: a java.awt.Dialog
   private Dialog field_22;

   public final void actionPerformed(ActionEvent var1) {
      this.field_22.setVisible(false);
   }

   public final void windowClosing(WindowEvent var1) {
      this.field_22.setVisible(false);
   }

   class_6(String var1) {
      super();
      int var5 = AppletViewerPreferences.field_91;
      this.field_22 = new Dialog(AppletViewer.field_35, AppletViewer.getLocaleString("information", 0), true);
      TextArea var2 = new TextArea();
      var2.setText(AppletViewer.getLocaleString("copy_paste_url", 0) + ":\n" + var1);
      var2.setEditable(false);
      this.field_22.add(var2);
      Button var3 = new Button(AppletViewer.getLocaleString("ok", 0));
      var3.addActionListener(this);
      Panel var4 = new Panel();
      var4.setLayout(new FlowLayout(1));
      var4.add(var3);
      this.field_22.addWindowListener(this);
      this.field_22.add(var4, "South");
      this.field_22.setResizable(false);
      this.field_22.setSize(400, 150);
      this.field_22.setLocationRelativeTo(AppletViewer.field_35);
      this.field_22.setVisible(true);
      if (AppletViewer.field_52) {
         ++var5;
         AppletViewerPreferences.field_91 = var5;
      }

   }
}
