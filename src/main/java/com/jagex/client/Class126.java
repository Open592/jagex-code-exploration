package com.jagex.client;

import com.jagex.client.locale.LocalizedString;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ki")
public final class Class126 {

  @OriginalMember(owner = "client!ki", name = "b", descriptor = "I")
  public int anInt3914;

  @OriginalMember(owner = "client!ki", name = "c", descriptor = "I")
  public int anInt3915;

  @OriginalMember(owner = "client!ki", name = "g", descriptor = "I")
  public int anInt3919;

  static {
    new LocalizedString(
        "That player is offline, or has privacy mode enabled.",
        "Dieser Spieler ist offline oder hat den Privatsphären-Modus aktiviert.",
        "Ce joueur est déconnecté ou en mode privé.",
        "O jogador está offline ou está com o modo de privacidade ativado.");
  }

  @OriginalMember(owner = "client!ki", name = "a", descriptor = "(Lclient!iv;B)V")
  public void method3191(@OriginalArg(0) Packet arg0) {
    while (true) {
      @Pc(11)
      int local11 = arg0.g1();
      if (local11 == 0) {
        return;
      }
      this.method3194(local11, arg0);
    }
  }

  @OriginalMember(owner = "client!ki", name = "a", descriptor = "(ILclient!iv;I)V")
  private void method3194(@OriginalArg(0) int arg0, @OriginalArg(1) Packet arg1) {
    if (arg0 == 1) {
      this.anInt3914 = arg1.g2();
      this.anInt3919 = arg1.g1();
      this.anInt3915 = arg1.g1();
    }
  }
}
