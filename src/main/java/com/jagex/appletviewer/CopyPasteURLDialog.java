package com.jagex.appletviewer;

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
final class CopyPasteURLDialog extends WindowAdapter implements ActionListener {
  // $FF: renamed from: a java.awt.Dialog
  private final Dialog dialog;

  public void actionPerformed(ActionEvent ignored) {
    this.dialog.setVisible(false);
  }

  public void windowClosing(WindowEvent ignored) {
    this.dialog.setVisible(false);
  }

  CopyPasteURLDialog(String URL) {
    super();

    this.dialog = new Dialog(AppletViewer.frame, AppletViewer.getLocaleString("information"), true);

    TextArea textArea = new TextArea();
    textArea.setText(AppletViewer.getLocaleString("copy_paste_url") + ":\n" + URL);
    textArea.setEditable(false);

    this.dialog.add(textArea);

    Button acknowledgeButton = new Button(AppletViewer.getLocaleString("ok"));
    acknowledgeButton.addActionListener(this);

    Panel buttonPanel = new Panel();
    buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    buttonPanel.add(acknowledgeButton);

    this.dialog.addWindowListener(this);
    this.dialog.add(buttonPanel, "South");
    this.dialog.setResizable(false);
    this.dialog.setSize(400, 150);
    this.dialog.setLocationRelativeTo(AppletViewer.frame);
    this.dialog.setVisible(true);
  }
}
