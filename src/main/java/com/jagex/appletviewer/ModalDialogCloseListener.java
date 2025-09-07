package com.jagex.appletviewer;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// $FF: renamed from: app.p
final class ModalDialogCloseListener implements ActionListener {
  // $FF: renamed from: a java.awt.Dialog
  private final Dialog modalDialog;

  ModalDialogCloseListener() {
    this.modalDialog = ModalDialog.dialog;
  }

  public void actionPerformed(ActionEvent event) {
    this.modalDialog.setVisible(false);
  }
}
