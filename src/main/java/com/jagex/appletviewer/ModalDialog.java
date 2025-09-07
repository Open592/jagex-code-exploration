package com.jagex.appletviewer;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.util.ArrayList;
import java.util.List;

// $FF: renamed from: app.d
final class ModalDialog {
  // $FF: renamed from: a java.awt.Dialog
  static Dialog dialog;
  // $FF: renamed from: b java.awt.Button
  private static Button button;

  // $FF: renamed from: a (java.lang.String, java.lang.String, byte, java.lang.String) void
  private static void display(String buttonText, String title, String message) {
    dialog = new Dialog(AppletViewer.frame, title, true);

    int startingPOS = 0;
    int newLinePOS = -1;
    List<String> messageLines = new ArrayList<>();

    do {
      newLinePOS = message.indexOf('\n', newLinePOS + 1);

      if (newLinePOS < 0) {
        // If there are no more new lines to be found, add the rest of the string
        messageLines.add(message.substring(Math.max(startingPOS, 0)));
      } else {
        messageLines.add(message.substring(startingPOS, newLinePOS));
      }

      startingPOS = newLinePOS + 1;
    } while (newLinePOS >= 0);

    Panel messagePanel = new Panel();

    messagePanel.setLayout(new GridLayout(messageLines.size(), 1));
    messageLines.forEach(
        (messageLine) -> {
          Label messageLineLabel = new Label(messageLine, Label.CENTER);

          messagePanel.add(messageLineLabel);
        });

    dialog.add(messagePanel, "Center");
    button = new Button(buttonText);
    Panel panel = new Panel();
    panel.setLayout(new FlowLayout(FlowLayout.CENTER));
    panel.add(button);
    dialog.add(panel, "South");
    dialog.setResizable(false);
    dialog.setSize(500, 100);
    dialog.setLocationRelativeTo(AppletViewer.frame);
  }

  // $FF: renamed from: a (java.lang.String, byte) void
  static void displayMessage(String message) {
    display(AppletViewer.getLocaleString("ok"), AppletViewer.getLocaleString("message"), message);
    button.addActionListener(new ModalDialogCloseListener());
    dialog.setVisible(true);
  }

  // $FF: renamed from: a (byte, java.lang.String) void
  static void displayErrorMessage(String message) {
    LoaderBoxComponent.setHidden();
    display(AppletViewer.getLocaleString("quit"), AppletViewer.getLocaleString("error"), message);
    dialog.addWindowListener(TerminateHandler.initialize());
    button.addActionListener(TerminateHandler.initialize());
    dialog.setVisible(true);
  }
}
