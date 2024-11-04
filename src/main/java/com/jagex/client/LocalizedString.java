package com.jagex.client;

public final class LocalizedString {
	private final String[] strings;

	public LocalizedString(String english, String german, String french, String portuguese) {
		this.strings = new String[] {
			english,
			german,
			french,
			portuguese
		};
	}

	public String getLocalizedString(int languageId) {
		return this.strings[languageId];
	}

	@Override
	public String toString() {
		throw new IllegalStateException();
	}
}
