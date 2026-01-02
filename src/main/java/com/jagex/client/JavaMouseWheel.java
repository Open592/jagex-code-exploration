package com.jagex.client;

import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public final class JavaMouseWheel extends IMouseWheel implements MouseWheelListener {

  private int wheelRotation = 0;

  @Override
  public synchronized int getWheelRotation() {
    int res = this.wheelRotation;

    this.wheelRotation = 0;

    return res;
  }

  @Override
  public synchronized void mouseWheelMoved(MouseWheelEvent e) {
    this.wheelRotation += e.getWheelRotation();
  }

  @Override
  public void addListener(Component component) {
    component.addMouseWheelListener(this);
  }

  @Override
  public void removeListener(Component arg0) {
    arg0.removeMouseWheelListener(this);
  }
}
