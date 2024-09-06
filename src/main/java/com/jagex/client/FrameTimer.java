package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!kk")
public abstract class FrameTimer {

	static {
		new Class83("Unable to send message - player unavailable.", "Deine Nachricht konnte nicht verschickt werden,", "Impossible d'envoyer un message - joueur indisponible.", "Não foi possível enviar a mensagem. O jogador não está disponível.");
	}

	@OriginalMember(owner = "client!rc", name = "f", descriptor = "(I)Lclient!kk;")
	public static FrameTimer getFrameTimer() {
		try {
			return new JagMiscNanosecondFrameTimer();
		} catch (@Pc(15) Throwable local15) {
			try {
				return new SystemNanosecondFrameTimer();
			} catch (@Pc(21) Throwable local21) {
				return new SystemMillisecondFrameTimer();
			}
		}
	}

	@OriginalMember(owner = "client!kk", name = "a", descriptor = "(B)V")
	public abstract void reset();

	@OriginalMember(owner = "client!kk", name = "c", descriptor = "(B)J")
	public abstract long method2252();

	@OriginalMember(owner = "client!kk", name = "a", descriptor = "(ZI)I")
	public abstract int method2253(@OriginalArg(1) int frameTimeInMilliseconds);
}
