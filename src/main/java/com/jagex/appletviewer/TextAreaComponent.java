package com.jagex.appletviewer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.StringTokenizer;

// $FF: renamed from: app.v
final class TextAreaComponent extends Component implements MouseListener, MouseMotionListener {
  // $FF: renamed from: a java.awt.Color
  private static final Color backgroundColor = new Color(12410);
  // $FF: renamed from: b app.k[][]
  private TextPart[][] paragraphs;
  // $FF: renamed from: c java.awt.Color
  private static final Color textColor = new Color(16777215);
  // $FF: renamed from: d java.awt.Color
  private static final Color linkColor = new Color(16765440);
  // $FF: renamed from: e app.e[]
  private TextURL[] urls;

  public final void mouseEntered(MouseEvent var1) {}

  public final void mouseExited(MouseEvent var1) {}

  public final void mouseDragged(MouseEvent var1) {}

  public final void mousePressed(MouseEvent event) {
    Point mousePOS = event.getPoint();

    for (TextURL url : this.urls) {
      if (url.container.contains(mousePOS)) {
        URLViewer.showurl(url.URL, null);
      }
    }
  }

  public void mouseReleased(MouseEvent var1) {}

  public void paint(Graphics context) {
    int width = this.getWidth();
    FontMetrics fontMetrics = context.getFontMetrics();
    int fontHeight = fontMetrics.getHeight();
    int yPOS = fontHeight;

    if (this.paragraphs != null) {
      for (TextPart[] paragraph : this.paragraphs) {
        int paragraphWidth = 0;

        for (TextPart textPart : paragraph) {
          paragraphWidth += fontMetrics.stringWidth(textPart.title);
        }

        int xPOS = (width - paragraphWidth) / 2;

        for (TextPart textPart : paragraph) {
          int stringWidth = fontMetrics.stringWidth(textPart.title);

          setTextColor:
          {
            if (textPart.URL == null) {
              context.setColor(textColor);
              break setTextColor;
            }

            context.setColor(linkColor);
            Rectangle urlContainer = textPart.URL.container;
            urlContainer.y = -fontHeight + yPOS;
            urlContainer.x = xPOS;
            urlContainer.width = stringWidth;
            urlContainer.height = fontHeight;
          }

          context.drawString(textPart.title, xPOS, yPOS);
          xPOS += stringWidth;
        }

        yPOS += fontHeight;
      }
    }
  }

  public void mouseClicked(MouseEvent var1) {}

  public void mouseMoved(MouseEvent event) {
    Point mousePOS = event.getPoint();

    for (TextURL url : this.urls) {
      if (url.container.contains(mousePOS)) {
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        return;
      }
    }

    this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  // $FF: renamed from: a (byte, java.lang.String) void
  private void parseText(String text) {
    if (text == null) {
      return;
    }

    StringTokenizer var3 = new StringTokenizer(text, "\\");
    this.paragraphs = new TextPart[var3.countTokens()][];
    TextPart[] links = new TextPart[100];
    int var6 = 0;

    while (var3.hasMoreTokens()) {
      int linkCount = 0;
      String var8 = var3.nextToken();

      do {
        int startLinkPOS = var8.indexOf("[");
        if (0 > startLinkPOS) {
          links[linkCount++] = new TextPart(var8);
          break;
        }

        if (startLinkPOS > 0) {
          links[linkCount++] = new TextPart(var8.substring(0, startLinkPOS));
          var8 = var8.substring(startLinkPOS);
        }

        int startURLPOS = var8.indexOf("\"");
        if (startURLPOS < 0) {
          break;
        }

        int endURLPOS = var8.indexOf("\"", startURLPOS - -1);
        if (0 > endURLPOS) {
          break;
        }

        int endLinkPOS = var8.indexOf("]");
        if (0 > endLinkPOS) {
          break;
        }

        String URL = var8.substring(1 + startURLPOS, endURLPOS);
        String title = var8.substring(endURLPOS - -1, endLinkPOS).trim();
        links[linkCount++] = new TextPart(title, URL);
        if (1 + endLinkPOS >= var8.length()) {
          break;
        }

        var8 = var8.substring(endLinkPOS - -1);
      } while (true);

      this.paragraphs[var6] = new TextPart[linkCount];
      System.arraycopy(links, 0, this.paragraphs[var6], 0, linkCount);
      ++var6;
    }
  }

  TextAreaComponent(String text) {
    super();
    this.paragraphs = null;
    this.setBackground(backgroundColor);
    this.addMouseListener(this);
    this.addMouseMotionListener(this);
    this.parseText(text);
    if (null != this.paragraphs) {
      int var2 = 0;
      int var3 = 0;

      while (var3 < this.paragraphs.length) {
        TextPart[] var4 = this.paragraphs[var3];
        int var5 = 0;

        while (var4.length > var5) {
          if (var4[var5].URL != null) {
            ++var2;
          }

          ++var5;
        }

        ++var3;
      }

      this.urls = new TextURL[var2];
      var3 = 0;
      int var8 = 0;

      while (var8 < this.paragraphs.length) {
        TextPart[] var9 = this.paragraphs[var8];
        int var6 = 0;

        while (~var9.length < ~var6) {
          if (var9[var6].URL != null) {
            this.urls[var3++] = var9[var6].URL;
          }

          ++var6;
        }

        ++var8;
      }
    }
  }
}
