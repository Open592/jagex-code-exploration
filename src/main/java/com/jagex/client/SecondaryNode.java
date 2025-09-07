package com.jagex.client;

import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!ac")
public class SecondaryNode extends Node {

  @OriginalMember(owner = "client!ac", name = "o", descriptor = "J")
  public long secondaryValue;

  @OriginalMember(owner = "client!ac", name = "r", descriptor = "Lclient!ac;")
  public SecondaryNode secondaryPrevious;

  @OriginalMember(owner = "client!ac", name = "s", descriptor = "Lclient!ac;")
  public SecondaryNode secondaryNext;

  @OriginalMember(owner = "client!ac", name = "c", descriptor = "(B)V")
  public final void secondaryPopSelf() {
    if (this.secondaryNext != null) {
      this.secondaryNext.secondaryPrevious = this.secondaryPrevious;
      this.secondaryPrevious.secondaryNext = this.secondaryNext;
      this.secondaryPrevious = null;
      this.secondaryNext = null;
    }
  }

  @OriginalMember(owner = "client!ac", name = "a", descriptor = "(Z)Z")
  public final boolean secondaryHasNext() {
    return this.secondaryNext != null;
  }
}
