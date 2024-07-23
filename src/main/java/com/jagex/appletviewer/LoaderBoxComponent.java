package com.jagex.appletviewer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

// $FF: renamed from: app.i
final class LoaderBoxComponent extends Component {
   // $FF: renamed from: a java.awt.Font
   private Font loadingTextFont;
   // $FF: renamed from: b java.awt.Dialog
   private static Dialog loaderBoxDialog;
   // $FF: renamed from: c int
   private int currentProgress = 0;
   // $FF: renamed from: d java.awt.Color
   private final Color redColor = new Color(140, 11, 1);
   // $FF: renamed from: e java.lang.String
   private String currentLoadingText;
   // $FF: renamed from: f app.i
   private static LoaderBoxComponent classInstance;
   // $FF: renamed from: g java.awt.FontMetrics
   private FontMetrics loadingTextFontMetrics;

   // $FF: renamed from: a (int, byte) void
   static void updateProgress(int progress) {
      if (classInstance != null) {
         if (progress > 100) {
            progress = 100;
         }

         classInstance.currentProgress = progress;
         classInstance.repaint();
      }
   }

   // $FF: renamed from: a (int) void
   static void setVisible() {
      loaderBoxDialog.setLocationRelativeTo(AppletViewer.frame);
      loaderBoxDialog.setVisible(true);
   }

   // $FF: renamed from: b (int) void
   static void paint() {
      classInstance.paint(classInstance.getGraphics());
   }

   // $FF: renamed from: a (boolean) void
   static void setHidden() {
      if (loaderBoxDialog != null) {
         loaderBoxDialog.setVisible(false);
      }
   }

   // $FF: renamed from: a (boolean, java.lang.String) void
   static void setLoadingText(String loadingText) {
      classInstance.currentLoadingText = loadingText;
      classInstance.repaint();
   }

   public void paint(Graphics graphics) {
      try {
         if (graphics == null) {

            this.repaint();

            return;
         }

         graphics.setColor(Color.black);
         graphics.fillRect(0, 0, this.getSize().width, this.getSize().height);
         graphics.setColor(this.redColor);
         graphics.drawRect(this.getSize().width / 2 - 152, this.getSize().height / 2 - 18, 303, 33);
         graphics.fillRect((this.getSize().width / 2) - 150, (this.getSize().height / 2) - 16, this.currentProgress * 300 / 100, 30);
         String loaderBoxContent = this.currentLoadingText + " - " + this.currentProgress + "%";
         graphics.setFont(this.loadingTextFont);
         graphics.setColor(Color.white);
         graphics.drawString(loaderBoxContent, (this.getSize().width - this.loadingTextFontMetrics.stringWidth(loaderBoxContent)) / 2, 4 + this.getSize().height / 2);
      } catch (Exception ignored) {
      }

   }

   private LoaderBoxComponent(String initialLoadingText) {
      this.currentLoadingText = initialLoadingText;
   }

   // $FF: renamed from: c (int) void
   static void initialize() {
      classInstance = new LoaderBoxComponent(AppletViewer.getLocaleString("loaderbox_initial"));
      classInstance.loadingTextFont = new Font("Helvetica", Font.BOLD, 13);
      classInstance.loadingTextFontMetrics = classInstance.getFontMetrics(classInstance.loadingTextFont);
      loaderBoxDialog = new Dialog(AppletViewer.frame, "Jagex Ltd.", false);
      loaderBoxDialog.add(classInstance);
      loaderBoxDialog.addWindowListener(TerminateHandler.initialize());
      loaderBoxDialog.setResizable(false);
      loaderBoxDialog.setSize(320, 100);
   }
}
