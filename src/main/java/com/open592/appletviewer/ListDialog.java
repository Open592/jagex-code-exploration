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
final class ListDialog implements ActionListener, WindowListener {
   // $FF: renamed from: a int
   private int selectedIndex;
   // $FF: renamed from: b java.awt.List
   private final List list;
   // $FF: renamed from: c java.awt.Dialog
   private final Dialog dialog;
   private final String OK_ACTION_COMMAND = "ok";

   public void windowClosed(WindowEvent var1) {
   }

   public void windowDeactivated(WindowEvent var1) {
   }

   public void windowClosing(WindowEvent event) {
      this.cancel();
   }

   ListDialog(String title) {
      super();

      this.list = new List();

      Panel container = new Panel();
      container.setLayout(new BorderLayout());
      container.add(this.list, "Center");

      Panel buttonContainer = new Panel();
      buttonContainer.setLayout(new GridLayout(1, 2));
      container.add(buttonContainer, "South");

      Button okButton = new Button(AppletViewer.getLocaleString("ok"));
      okButton.setActionCommand(this.OK_ACTION_COMMAND);
      okButton.addActionListener(this);
      Button cancelButton = new Button(AppletViewer.getLocaleString("cancel"));
      String CANCEL_ACTION_COMMAND = "cancel";
      cancelButton.setActionCommand(CANCEL_ACTION_COMMAND);
      cancelButton.addActionListener(this);
      buttonContainer.add(okButton);
      buttonContainer.add(cancelButton);

      this.dialog = new Dialog(AppletViewer.frame, title, true);
      this.dialog.addWindowListener(this);
      this.dialog.setSize(200, 150);
      this.dialog.add(container);
   }

   public void actionPerformed(ActionEvent event) {
      if (!event.getActionCommand().equals(this.OK_ACTION_COMMAND)) {
         this.cancel();

         return;
      }

      this.selectedIndex = this.list.getSelectedIndex();
      this.dialog.setVisible(false);
   }

   // $FF: renamed from: a (boolean, java.lang.String[]) void
   void initializeList(String[] listItems) {
      this.list.removeAll();

      for (String listItem : listItems) {
         if (listItem != null) {
            this.list.add(listItem);
         }
      }
   }

   public void windowDeiconified(WindowEvent event) {
   }

   public void windowOpened(WindowEvent event) {
   }

   // $FF: renamed from: a (byte) int
   int prompt() {
      this.dialog.setLocationRelativeTo(AppletViewer.frame);
      this.dialog.setVisible(true);

      return this.selectedIndex;
   }

   // $FF: renamed from: a (int) void
   private void cancel() {
      this.selectedIndex = -1;
      this.dialog.setVisible(false);
   }

   public void windowActivated(WindowEvent event) {
   }

   public void windowIconified(WindowEvent event) {
   }
}
