package com.open592.appletviewer;

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
        return switch (languageID) {
            case 0 -> Optional.of(ENGLISH);
            case 1 -> Optional.of(GERMAN);
            case 2 -> Optional.of(FRENCH);
            case 3 -> Optional.of(BRAZILIAN_PORTUGUESE);
            default -> Optional.empty();
        };
    }

    public static Optional<Language> fromISO3LanguageID(String languageID) {
        return switch (languageID) {
            case "eng" -> Optional.of(ENGLISH);
            case "ger", "deu" -> Optional.of(GERMAN);
            case "fre", "fra" -> Optional.of(FRENCH);
            case "por" -> Optional.of(BRAZILIAN_PORTUGUESE);
            default -> Optional.empty();
        };
    }

    public static Optional<Language> fromISO3CountryID(String countryID) {
        return switch (countryID) {
            case "GB", "US" -> Optional.of(ENGLISH);
            case "DE" -> Optional.of(GERMAN);
            case "FR" -> Optional.of(FRENCH);
            case "BR" -> Optional.of(BRAZILIAN_PORTUGUESE);
            default -> Optional.empty();
        };
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
