package com.jagex.appletviewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// $FF: renamed from: app.g
final class ToolbarButtonHandler implements ActionListener {
    public void actionPerformed(ActionEvent event) {
        int buttonID = event.getID();

        if (buttonID == 0) {
            if (AppletViewer.selectPreferredLanguageHandler() != -1) {
                ModalDialog.displayMessage(AppletViewer.getLocaleString("changes_on_restart"));
            }

            return;
        }

        if (buttonID == 1) {
            AppletViewer.selectPreferredServerHandler();
        }
    }
}
