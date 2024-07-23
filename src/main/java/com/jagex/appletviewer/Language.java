package com.jagex.appletviewer;

import java.util.Locale;
import java.util.Optional;

public enum Language {
    ENGLISH,
    GERMAN,
    FRENCH,
    BRAZILIAN_PORTUGUESE;

    public final int getID() {
        return this.ordinal();
    }

    public static Optional<Language> fromLanguageID(int languageID) {
        switch (languageID) {
            case 0: return Optional.of(ENGLISH);
            case 1: return Optional.of(GERMAN);
            case 2: return Optional.of(FRENCH);
            case 3: return Optional.of(BRAZILIAN_PORTUGUESE);
            default: return Optional.empty();
        }
    }

    public static Optional<Language> fromISO3LanguageID(String languageID) {
        switch (languageID) {
            case "eng": return Optional.of(ENGLISH);
            case "deu":
            case "ger":
                return Optional.of(GERMAN);
            case "fra":
            case "fre":
                return Optional.of(FRENCH);
            case "por": return Optional.of(BRAZILIAN_PORTUGUESE);
            default: return Optional.empty();
        }
    }

    public static Optional<Language> fromISO3CountryID(String countryID) {
        switch (countryID) {
            case "GB":
            case "US":
                return Optional.of(ENGLISH);
            case "DE": return Optional.of(GERMAN);
            case "FR": return Optional.of(FRENCH);
            case "BR": return Optional.of(BRAZILIAN_PORTUGUESE);
            default: return Optional.empty();
        }
    }

    public static Language resolveUserLanguage() {
        Locale defaultLocale = Locale.getDefault();
        String languageID = defaultLocale.getISO3Language();

        return fromISO3LanguageID(languageID).orElseGet(() -> {
            String countryID = defaultLocale.getISO3Country();

            return fromISO3CountryID(countryID).orElse(ENGLISH);
        });
    }

    public static Optional<Language> resolveFromAppletViewerPreferences() {
        AppletViewerPreferences.readPreferencesFile();
        Optional<String> languageID = AppletViewerPreferences.getPreference("Language");

        if (languageID.isPresent()) {
            try {
                return fromLanguageID(Integer.parseInt(languageID.get()));
            } catch (NumberFormatException e) {
                return Optional.empty();
            }
        } else {
            return Optional.empty();
        }
    }
}
