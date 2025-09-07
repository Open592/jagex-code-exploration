package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!ie")
public abstract class Class105 {

  static {
    new LocalizedString(
        "Unable to add name - system busy.",
        "Der Name konnte nicht hinzugefügt werden, das System ist derzeit ausgelastet.",
        "Impossible d'ajouter un nom - système occupé.",
        "Não foi possível adicionar o nome. O sistema está ocupado.");
  }

  @OriginalMember(owner = "client!ie", name = "a", descriptor = "(Lclient!mh;I)Lclient!mh;")
  public abstract SecondaryNode_Sub1_Sub9 method5276(@OriginalArg(0) SecondaryNode_Sub1_Sub9 arg0);
}
