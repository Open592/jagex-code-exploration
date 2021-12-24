package com.open592.appletviewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// $FF: renamed from: app.g
final class class_11 implements ActionListener {
   public final void actionPerformed(ActionEvent var1) {
      label30: {
         int var4 = class_21.field_91;
         int var2 = var1.getID();
         if (var2 != 0 || var4 != 0) {
            if (-2 != ~var2) {
               return;
            }

            if (var4 == 0) {
               break label30;
            }
         }

         if (-1 < ~AppletViewer.method_23(0)) {
            return;
         }

         class_19.method_39(AppletViewer.method_19("changes_on_restart", 0), (byte)-80);
         if (var4 == 0) {
            return;
         }
      }

      AppletViewer.method_16(-14393);
   }
}
