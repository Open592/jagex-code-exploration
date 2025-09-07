package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!bo")
public final class Class25 {

  @OriginalMember(owner = "client!bo", name = "g", descriptor = "Lclient!vu;")
  private Node aNode_33;

  @OriginalMember(owner = "client!bo", name = "h", descriptor = "I")
  private int anInt626 = 0;

  @OriginalMember(owner = "client!bo", name = "d", descriptor = "Lclient!ib;")
  private final HashMap aHashMap_5;

  @OriginalMember(owner = "client!bo", name = "<init>", descriptor = "(Lclient!ib;)V")
  public Class25(@OriginalArg(0) HashMap arg0) {
    this.aHashMap_5 = arg0;
  }

  @OriginalMember(owner = "client!bo", name = "a", descriptor = "(Z)Lclient!vu;")
  public Node method640() {
    @Pc(30)
    Node local30;
    if (this.anInt626 > 0 && this.aNode_33 != this.aHashMap_5.buckets[this.anInt626 - 1]) {
      local30 = this.aNode_33;
      this.aNode_33 = local30.previous;
      return local30;
    }
    while (this.anInt626 < this.aHashMap_5.bucketCount) {
      local30 = this.aHashMap_5.buckets[this.anInt626++].previous;
      if (this.aHashMap_5.buckets[this.anInt626 - 1] != local30) {
        this.aNode_33 = local30.previous;
        return local30;
      }
    }
    return null;
  }

  @OriginalMember(owner = "client!bo", name = "a", descriptor = "(I)Lclient!vu;")
  public Node method641() {
    this.anInt626 = 0;
    return this.method640();
  }
}
