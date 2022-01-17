package com.open592.appletviewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// $FF: renamed from: app.g
final class class_11 implements ActionListener {
    public void actionPerformed(ActionEvent var1) {
        label30: {
            int var2 = var1.getID();
            if (var2 != 0) {
                if (-2 != ~var2) {
                    return;
                }

                break label30;
            }

            if (-1 < ~AppletViewer.method_23()) {
                return;
            }

            ModalDialog.displayMessage(AppletViewer.getLocaleString("changes_on_restart"));

            return;
        }

        AppletViewer.getAvailableServerList();
    }
}
