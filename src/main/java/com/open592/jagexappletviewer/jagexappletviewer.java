package com.open592.jagexappletviewer;

import com.open592.appletviewer.AppletViewer;

public class jagexappletviewer {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Invalid arguments");
            System.exit(0);
        }

        AppletViewer.start(args[0]);
    }
}