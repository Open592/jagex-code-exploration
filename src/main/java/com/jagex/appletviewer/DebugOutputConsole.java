package com.jagex.appletviewer;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.OutputStream;
import java.io.PrintStream;

// $FF: renamed from: app.l
final class DebugOutputConsole extends OutputStream implements WindowListener {
   private static final String TITLE = "Jagex host console";
   // $FF: renamed from: a java.awt.TextArea
   private final TextArea textArea;
   // $FF: renamed from: b java.lang.StringBuffer
   private StringBuffer stringBuffer = new StringBuffer(1024);
   // $FF: renamed from: c java.awt.Frame
   private Frame frame;
   // $FF: renamed from: d java.lang.String
   private final String title;
   // $FF: renamed from: e java.io.PrintStream
   private final PrintStream printStream;
   // $FF: renamed from: f boolean
   private boolean isInitialized = false;
   // $FF: renamed from: g app.l
   private static DebugOutputConsole classInstance;

   public void windowIconified(WindowEvent event) {
   }

   public void windowOpened(WindowEvent event) {
   }

   public void windowClosed(WindowEvent event) {
   }

   public void windowClosing(WindowEvent event) {
      this.frame.setVisible(false);
      this.isInitialized = false;
   }

   // $FF: renamed from: a (java.lang.String, int) java.io.PrintStream
   static PrintStream initialize() {
      if (null == classInstance) {
         classInstance = new DebugOutputConsole(TITLE);
      }

      return classInstance.printStream;
   }

   public void write(int charCode) {
      synchronized(this) {
         if (charCode == '\n') {
            if (!this.isInitialized) {
               this.frame = new Frame();
               this.frame.add(this.textArea, "Center");
               this.frame.setVisible(true);
               this.frame.setTitle(this.title);
               this.frame.setLocation(320, 240);
               this.frame.setSize(720, 260);
               this.frame.addWindowListener(this);
               this.isInitialized = true;
            }

            this.stringBuffer.append("\n");
            this.textArea.append(this.stringBuffer.toString());
            this.stringBuffer = new StringBuffer(1024);

            return;
         }

         this.stringBuffer.append((char) charCode);
      }
   }

   public void windowActivated(WindowEvent event) {
   }

   public void windowDeiconified(WindowEvent event) {
   }

   public void windowDeactivated(WindowEvent event) {
   }

   private DebugOutputConsole(String title) {
      this.title = title;
      this.textArea = new TextArea();
      this.textArea.setEditable(false);
      this.printStream = new PrintStream(this, true);
   }
}
