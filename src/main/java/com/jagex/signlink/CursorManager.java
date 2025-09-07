package com.jagex.signlink;

import java.awt.Component;
import java.awt.Point;
import java.awt.Robot;
import java.awt.image.BufferedImage;

public class CursorManager {
  private Component component;

  private final Robot robot = new Robot();

  CursorManager() throws Exception {}

  public void mouseMove(int x, int y) {
    this.robot.mouseMove(x, y);
  }

  public void setComponent(boolean shouldReset, Component component) {
    if (shouldReset) {
      component = null;
    } else if (component == null) {
      throw new NullPointerException();
    }

    if (this.component == component) {
      return;
    }

    if (this.component != null) {
      this.component.setCursor(null);
      this.component = null;
    }

    if (component != null) {
      component.setCursor(
          component
              .getToolkit()
              .createCustomCursor(
                  new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB), new Point(0, 0), null));

      this.component = component;
    }
  }

  public void setCursor(Component component, int width, int height, int[] rgbArray, Point hotSpot) {
    if (rgbArray == null) {
      component.setCursor(null);

      return;
    }

    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

    image.setRGB(0, 0, width, height, rgbArray, 0, width);
    component.setCursor(component.getToolkit().createCustomCursor(image, hotSpot, null));
  }
}
