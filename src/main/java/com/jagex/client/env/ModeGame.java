package com.jagex.client.env;

import com.jagex.client.LocalizedString;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

import javax.swing.text.html.Option;
import java.util.Optional;

@OriginalClass("client!jk")
public enum ModeGame {
	RUNESCAPE("runescape", 0),
	STELLAR_DAWN("stellardawn", 1);

	private final String name;
	private final int id;

	static {
		new LocalizedString("Attempting to join channel...", "Chatraum wird betreten...", "Tentative de connexion au canal...", "Tentando acessar canal...");
	}

	public static Optional<ModeGame> fromGameId(String input) {
		/**
		 * GameId can be in one of two formats:
		 *
		 * "game0"
		 * or
		 * "0"
		 *
		 * We try to deduce the format before resolving the GameWhat value
		 */
		String gameId = input.startsWith("game")
			? String.valueOf(input.charAt(input.length() - 1))
			: input;

		switch (gameId) {
			case "0": return Optional.of(ModeGame.RUNESCAPE);
			case "1": return Optional.of(ModeGame.STELLAR_DAWN);
			default: return Optional.empty();
		}
	}

	@OriginalMember(owner = "client!jk", name = "<init>", descriptor = "(Ljava/lang/String;I)V")
	ModeGame(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public int getId() {
		return this.id;
	}

	public boolean isRunescape() {
		return this == RUNESCAPE;
	}

	public boolean isStellarDawn() {
		return this == STELLAR_DAWN;
	}

	@OriginalMember(owner = "client!jk", name = "toString", descriptor = "()Ljava/lang/String;")
	@Override
	public String toString() {
		throw new IllegalStateException();
	}
}
