package com.open592.appletviewer;

import java.util.Hashtable;

// $FF: renamed from: app.h
final class InitialLocaleStrings {
   // $FF: renamed from: a (int, boolean) void
   static void initialize(Language language) {
       switch (language) {
           case ENGLISH: {
               AppletViewer.localeStrings.put("err_missing_config", "Missing com.jagex.config setting");
               AppletViewer.localeStrings.put("err_invalid_config", "Invalid com.jagex.config setting");
               AppletViewer.localeStrings.put("loading_config", "Loading configuration");
               AppletViewer.localeStrings.put("err_load_config", "There was an error loading the game configuration from the website.\nIf you have a firewall, check that this program is allowed to access the Internet.");
               AppletViewer.localeStrings.put("err_decode_config", "Error decoding configuration");
               AppletViewer.localeStrings.put("loaderbox_initial", "Loading...");
               AppletViewer.localeStrings.put("error", "Error");
               AppletViewer.localeStrings.put("quit", "Quit");

               break;
           }
           case FRENCH: {
               AppletViewer.localeStrings.put("err_missing_config", "Paramètre com.jagex.config manquant");
               AppletViewer.localeStrings.put("err_invalid_config", "Paramètre com.jagex.config non valide");
               AppletViewer.localeStrings.put("loading_config", "Chargement de la configuration");
               AppletViewer.localeStrings.put("err_load_config", "Une erreur s'est produite lors du chargement de la configuration du jeu.\nSi un pare-feu est actif sur votre ordinateur, assurez-vous\nqu'il laisse ce programme accéder à internet.");
               AppletViewer.localeStrings.put("err_decode_config", "Erreur de décodage de configuration");
               AppletViewer.localeStrings.put("loaderbox_initial", "Chargement...");
               AppletViewer.localeStrings.put("error", "Erreur");
               AppletViewer.localeStrings.put("quit", "Quitter");

               break;
           }
           case GERMAN: {
               AppletViewer.localeStrings.put("err_missing_config", "Einstellung com.jagex.config fehlt");
               AppletViewer.localeStrings.put("err_invalid_config", "Einstellung com.jagex.config ist ungültig");
               AppletViewer.localeStrings.put("loading_config", "Lade Konfiguration");
               AppletViewer.localeStrings.put("err_load_config", "Beim Laden der Spielkonfiguration von der Website ist ein Fehler aufgetreten.\nBitte überprüfen Sie Ihre Firewall-Einstellungen.");
               AppletViewer.localeStrings.put("err_decode_config", "Fehler beim Entschlüsseln der Konfiguration");
               AppletViewer.localeStrings.put("loaderbox_initial", "Lade...");
               AppletViewer.localeStrings.put("error", "Fehler");
               AppletViewer.localeStrings.put("quit", "Beenden");

               break;
           }
           case BRAZILIAN_PORTUGUESE: {
               AppletViewer.localeStrings.put("err_missing_config", "Faltando configuração de com.jagex.config");
               AppletViewer.localeStrings.put("err_invalid_config", "Configuração inválida de com.jagex.config");
               AppletViewer.localeStrings.put("loading_config", "Carregando configuração");
               AppletViewer.localeStrings.put("err_load_config", "Houve um erro quando a configuração do jogo estava sendo carregada no site.\nSe você tiver firewall, verifique se o programa pode ter acesso à internet.");
               AppletViewer.localeStrings.put("err_decode_config", "Erro ao decodificar configuração");
               AppletViewer.localeStrings.put("loaderbox_initial", "Carregando...");
               AppletViewer.localeStrings.put("error", "Erro");
               AppletViewer.localeStrings.put("quit", "Fechar");

               break;
           }
       }
   }
}
