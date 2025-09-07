package com.jagex.appletviewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// $FF: renamed from: app.f
final class TerminateHandler extends WindowAdapter implements ActionListener {
  // $FF: renamed from: a app.f
  private static TerminateHandler classInstance;

  public final void windowClosing(WindowEvent event) {
    AppletViewer.quit();
  }

  public final void actionPerformed(ActionEvent event) {
    AppletViewer.quit();
  }

  private TerminateHandler() {}

  // $FF: renamed from: a (int) app.f
  static TerminateHandler initialize() {
    if (classInstance == null) {
      classInstance = new TerminateHandler();
    }

    return classInstance;
  }
}
