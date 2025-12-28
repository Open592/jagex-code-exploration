package com.jagex.client;

import com.jagex.client.locale.LocalizedString;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!pu")
public final class Class190 {

  @OriginalMember(owner = "client!pu", name = "g", descriptor = "I")
  public int anInt5502 = 0;

  @OriginalMember(owner = "client!pu", name = "d", descriptor = "I")
  public int anInt5500 = 0;

  @OriginalMember(owner = "client!pu", name = "l", descriptor = "I")
  public int anInt5506 = 2048;

  @OriginalMember(owner = "client!pu", name = "j", descriptor = "I")
  public int anInt5504 = 2048;

  static {
    new LocalizedString(
        "Error sending message to clan chat - please try again later!",
        "Fehler beim Versenden der Nachricht - bitte versuch es später erneut.",
        "Erreur lors de l'envoi du message au canal de clan - veuillez réessayer ultérieurement.",
        "Erro ao enviar mensagem ao canal de clã. Tente de novo depois!");
  }

  @OriginalMember(owner = "client!pu", name = "a", descriptor = "(ZLclient!iv;)V")
  public void method4218(@OriginalArg(1) Packet arg0) {
    while (true) {
      @Pc(5)
      int local5 = arg0.g1();
      if (local5 == 0) {
        return;
      }
      this.method4220(local5, arg0);
    }
  }

  @OriginalMember(owner = "client!pu", name = "a", descriptor = "(IBLclient!iv;)V")
  private void method4220(@OriginalArg(0) int arg0, @OriginalArg(2) Packet arg1) {
    if (arg0 == 1) {
      this.anInt5502 = arg1.g1();
    } else if (arg0 == 2) {
      this.anInt5506 = arg1.g2();
    } else if (arg0 == 3) {
      this.anInt5504 = arg1.g2();
    } else if (arg0 == 4) {
      this.anInt5500 = arg1.g2s();
    }
  }
}
