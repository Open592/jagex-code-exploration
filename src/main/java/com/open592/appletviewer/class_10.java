package com.open592.appletviewer;

import java.util.Hashtable;

// $FF: renamed from: app.h
final class class_10 {
   // $FF: renamed from: a (int, boolean) void
   static final void method_31(int var0, boolean var1) {
      int var4 = class_21.field_91;
      if (var1) {
         Hashtable var2;
         label49: {
            label57: {
               label46: {
                  label55: {
                     var2 = AppletViewer.field_42;
                     var2.clear();
                     if (var0 == 0 && var4 == 0) {
                        var2.put("err_missing_config", "Missing com.jagex.config setting");
                        var2.put("err_invalid_config", "Invalid com.jagex.config setting");
                        var2.put("loading_config", "Loading configuration");
                        var2.put("err_load_config", "There was an error loading the game configuration from the website.\nIf you have a firewall, check that this program is allowed to access the Internet.");
                        var2.put("err_decode_config", "Error decoding configuration");
                        var2.put("loaderbox_initial", "Loading...");
                        var2.put("error", "Error");
                        var2.put("quit", "Quit");
                        if (var4 == 0) {
                           return;
                        }
                     } else if (~var0 != -2) {
                        if (var0 != 2 || var4 != 0) {
                           if (~var0 != -4) {
                              if (~var0 != -5) {
                                 if (~var0 != -6) {
                                    return;
                                 }
                                 break label49;
                              }
                              break label57;
                           }
                           break label46;
                        }
                        break label55;
                     }

                     var2.put("err_missing_config", "Einstellung com.jagex.config fehlt");
                     var2.put("err_invalid_config", "Einstellung com.jagex.config ist ungültig");
                     var2.put("loading_config", "Lade Konfiguration");
                     var2.put("err_load_config", "Beim Laden der Spielkonfiguration von der Website ist ein Fehler aufgetreten.\nBitte überprüfen Sie Ihre Firewall-Einstellungen.");
                     var2.put("err_decode_config", "Fehler beim Entschlüsseln der Konfiguration");
                     var2.put("loaderbox_initial", "Lade...");
                     var2.put("error", "Fehler");
                     var2.put("quit", "Beenden");
                     if (var4 == 0) {
                        return;
                     }
                  }

                  var2.put("err_missing_config", "Paramètre com.jagex.config manquant");
                  var2.put("err_invalid_config", "Paramètre com.jagex.config non valide");
                  var2.put("loading_config", "Chargement de la configuration");
                  var2.put("err_load_config", "Une erreur s'est produite lors du chargement de la configuration du jeu.\nSi un pare-feu est actif sur votre ordinateur, assurez-vous\nqu'il laisse ce programme accéder à internet.");
                  var2.put("err_decode_config", "Erreur de décodage de configuration");
                  var2.put("loaderbox_initial", "Chargement...");
                  var2.put("error", "Erreur");
                  var2.put("quit", "Quitter");
                  if (var4 == 0) {
                     return;
                  }
               }

               var2.put("err_missing_config", "Faltando configuração de com.jagex.config");
               var2.put("err_invalid_config", "Configuração inválida de com.jagex.config");
               var2.put("loading_config", "Carregando configuração");
               var2.put("err_load_config", "Houve um erro quando a configuração do jogo estava sendo carregada no site.\nSe você tiver firewall, verifique se o programa pode ter acesso à internet.");
               var2.put("err_decode_config", "Erro ao decodificar configuração");
               var2.put("loaderbox_initial", "Carregando...");
               var2.put("error", "Erro");
               var2.put("quit", "Fechar");
               if (var4 == 0) {
                  return;
               }
            }

            var2.put("err_missing_config", "Missing com.jagex.config setting");
            var2.put("err_invalid_config", "Invalid com.jagex.config setting");
            var2.put("loading_config", "Loading config");
            var2.put("err_load_config", "Error loading config");
            var2.put("err_decode_config", "Error decoding config");
            var2.put("loaderbox_initial", "Loading...");
            var2.put("error", "Error");
            var2.put("quit", "Quit");
            if (var4 == 0) {
               return;
            }
         }

         var2.put("err_missing_config", "Missing com.jagex.config setting");
         var2.put("err_invalid_config", "Invalid com.jagex.config setting");
         var2.put("loading_config", "Loading config");
         var2.put("err_load_config", "Error loading config");
         var2.put("err_decode_config", "Error decoding config");
         var2.put("loaderbox_initial", "Loading...");
         var2.put("error", "Error");
         var2.put("quit", "Quit");
      }
   }
}
