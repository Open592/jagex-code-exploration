package com.jagex.client;

import com.jagex.client.display.FullScreenWindow;
import com.jagex.client.env.ModeGame;
import com.jagex.client.env.ModeWhat;
import com.jagex.client.env.ModeWhere;
import com.jagex.client.jagex3.jagmisc.jagmisc;
import com.jagex.client.js5.*;
import com.jagex.client.utilities.ThreadingUtilities;
import com.jagex.signlink.Message;
import com.jagex.signlink.MonotonicClock;
import com.jagex.signlink.SignLink;
import java.awt.Container;
import java.awt.Frame;
import java.awt.Insets;
import java.awt.Rectangle;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Optional;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!client")
public final class client extends GameShell {

	@OriginalMember(owner = "client!fg", name = "d", descriptor = "Lclient!gk;")
	public static final LocalizedString allocatingMemoryLocalizedString = new LocalizedString("Allocating memory", "Speicher wird zugewiesen.", "Mémoire en cours d'attribution", "Alocando memória");

	@OriginalMember(owner = "client!ba", name = "D", descriptor = "Lclient!gk;")
	public static final LocalizedString allocatedMemoryLocalizedString = new LocalizedString("Allocated memory", "Zugewiesener Speicher.", "Mémoire attribuée", "Memória alocada");

	@OriginalMember(owner = "client!hp", name = "ab", descriptor = "Lclient!gk;")
	public static final LocalizedString createdGameWorldLocalizedString = new LocalizedString("Created gameworld", "Spielwelt erstellt.", "Monde de jeu créé", "Universo de jogo criado");

	@OriginalMember(owner = "client!qc", name = "h", descriptor = "Lclient!gk;")
	public static final LocalizedString connectedToUpdateServerLocalizedString = new LocalizedString("Connected to update server", "Verbindung zum Update-Server hergestellt.", "Connecté au serveur de mise à jour", "Conectado ao servidor de atualização");

	@OriginalMember(owner = "client!bm", name = "q", descriptor = "Lclient!gk;")
	public static final LocalizedString connectingToUpdateServerLocalizedString = new LocalizedString("Connecting to update server", "Verbindung mit Update-Server...", "Connexion au serveur de mise à jour en cours", "Conectando ao servidor de atualização");

	@OriginalMember(owner = "client!rb", name = "i", descriptor = "Lclient!gk;")
	public static final LocalizedString loadedUpdateListLocalizedString = new LocalizedString("Loaded update list", "Update-Liste geladen.", "Liste des mises à jour chargée", "Lista de atualizações carregada");

	@OriginalMember(owner = "client!eq", name = "I", descriptor = "Lclient!gk;")
	public static final LocalizedString checkingForUpdatesLocalizedString = new LocalizedString("Checking for updates - ", "Suche nach Updates - ", "Vérification des mises à jour - ", "Verificando atualizações - ");

	@OriginalMember(owner = "client!up", name = "e", descriptor = "Lclient!gk;")
	public static final LocalizedString loadedDefaultsLocalizedString = new LocalizedString("Loaded defaults", "Standardeinstellungen geladen", "Paramètres par défaut chargés", "Padrões carregados");

	@OriginalMember(owner = "client!ch", name = "g", descriptor = "Lclient!gk;")
	public static final LocalizedString loadingDefaultsLocalizedString = new LocalizedString("Loading defaults - ", "Lade Standardeinstellungen - ", "Chargement des paramètres par défaut - ", "Carregando padrões - ");

	@OriginalMember(owner = "client!pn", name = "i", descriptor = "Lclient!gk;")
	public static final LocalizedString preparedSoundEngineLocalizedString = new LocalizedString("Prepared sound engine", "Musik-Engine vorbereitet.", "Moteur son préparé", "Mecanismo de som preparado");

	@OriginalMember(owner = "client!ib", name = "i", descriptor = "Lclient!gk;")
	public static final LocalizedString loadingCoreFontsLocalizedString = new LocalizedString("Loading core fonts - ", "Lade Schriftarten - ", "Chargement des polices - ", "Carregando fontes principais - ");

	@OriginalMember(owner = "client!c", name = "a", descriptor = "Lclient!gk;")
	public static final LocalizedString loadedCoreFontsLocalizedString = new LocalizedString("Loaded core fonts", "Schriftarten geladen", "Polices chargées", "Fontes principais carregadas");

	@OriginalMember(owner = "client!sj", name = "e", descriptor = "Lclient!gk;")
	public static final LocalizedString loadingTitleScreenLocalizedString = new LocalizedString("Loading title screen - ", "Lade Titelbild - ", "Chargement de l'écran-titre - ", "Carregando tela título - ");

	@OriginalMember(owner = "client!sj", name = "b", descriptor = "Lclient!gk;")
	public static final LocalizedString loadedTitleScreenLocalizedString = new LocalizedString("Loaded title screen", "Titelbild geladen.", "Écran-titre chargé", "Tela título carregada");

	@OriginalMember(owner = "client!bw", name = "k", descriptor = "Lclient!gk;")
	public static final LocalizedString loadedTexturesLocalizedString = new LocalizedString("Loaded textures", "Texturen geladen.", "Textures chargées", "Texturas carregadas");

	@OriginalMember(owner = "client!ip", name = "lc", descriptor = "Lclient!gk;")
	public static final LocalizedString loadingTexturesLocalizedText = new LocalizedString("Loading textures - ", "Lade Texturen - ", "Chargement des textures - ", "Carregando texturas - ");

	@OriginalMember(owner = "client!mg", name = "h", descriptor = "Lclient!gk;")
	public static final LocalizedString starting3dLibraryLocalizedString = new LocalizedString("Starting 3d Library", "Starte 3D-Softwarebibliothek.", "Démarrage de la librairie 3D", "Iniciando biblioteca 3D");

	@OriginalMember(owner = "client!ss", name = "J", descriptor = "Lclient!gk;")
	public static final LocalizedString started3dLibraryLocalizedString = new LocalizedString("Started 3d Library", "3D-Softwarebibliothek gestartet.", "Librairie 3D démarrée", "Biblioteca 3D iniciada");

	@OriginalMember(owner = "client!ou", name = "l", descriptor = "Lclient!gk;")
	public static final LocalizedString openedTitleScreenLocalizedString = new LocalizedString("Opened title screen", "Titelbild geöffnet.", "Écran-titre ouvert", "Tela título aberta");

	@OriginalMember(owner = "client!av", name = "D", descriptor = "Lclient!gk;")
	public static final LocalizedString loadingConfigLocalizedString = new LocalizedString("Loading config - ", "Lade Konfiguration - ", "Chargement des fichiers config - ", "Carregando config - ");

	@OriginalMember(owner = "client!gm", name = "F", descriptor = "Lclient!gk;")
	public static final LocalizedString loadedConfigLocalizedString = new LocalizedString("Loaded config", "Konfig geladen.", "Fichiers config chargés", "Config carregada");

	@OriginalMember(owner = "client!md", name = "b", descriptor = "Lclient!gk;")
	public static final LocalizedString loadingSpritesLocalizedString = new LocalizedString("Loading sprites - ", "Lade Sprites - ", "Chargement des sprites - ", "Carregando sprites - ");

	@OriginalMember(owner = "client!tr", name = "c", descriptor = "Lclient!gk;")
	public static final LocalizedString loadedSpritesLocalizedString = new LocalizedString("Loaded sprites", "Sprites geladen.", "Sprites chargés", "Sprites carregados");

	@OriginalMember(owner = "client!ab", name = "o", descriptor = "Lclient!gk;")
	public static final LocalizedString loadedWordpackLocalizedString = new LocalizedString("Loaded wordpack", "Wordpack geladen.", "Module texte chargé", "Pacote de palavras carregado");

	@OriginalMember(owner = "client!ct", name = "d", descriptor = "Lclient!gk;")
	public static final LocalizedString loadingWordpackLocalizedString = new LocalizedString("Loading wordpack - ", "Lade Wordpack - ", "Chargement du module texte - ", "Carregando pacote de palavras - ");

	@OriginalMember(owner = "client!td", name = "d", descriptor = "Lclient!gk;")
	public static final LocalizedString loadedInterfacesLocalizedString = new LocalizedString("Loaded interfaces", "Benutzeroberfläche geladen.", "Interfaces chargées", "Interfaces carregadas");

	@OriginalMember(owner = "client!st", name = "l", descriptor = "Lclient!gk;")
	public static final LocalizedString loadingInterfacesLocalizedString = new LocalizedString("Loading interfaces - ", "Lade Benutzeroberfläche - ", "Chargement des interfaces - ", "Carregando interfaces - ");

	@OriginalMember(owner = "client!ud", name = "f", descriptor = "Lclient!gk;")
	public static final LocalizedString loadedInterfaceScriptsLocalizedString = new LocalizedString("Loaded interface scripts", "Interface-Skripte geladen", "Interfaces chargées", "Interfaces carregadas");

	@OriginalMember(owner = "client!eo", name = "j", descriptor = "Lclient!gk;")
	public static final LocalizedString loadingInterfaceScriptsLocalizedString = new LocalizedString("Loading interface scripts - ", "Lade Interface-Skripte - ", "Chargement des interfaces - ", "Carregando interfaces - ");

	@OriginalMember(owner = "client!ts", name = "r", descriptor = "Lclient!gk;")
	public static final LocalizedString loadingAdditionalFontsLocalizedString = new LocalizedString("Loading additional fonts - ", "Lade Zusatzschriftarten - ", "Chargement de polices secondaires - ", "Carregando fontes principais - ");

	@OriginalMember(owner = "client!nf", name = "v", descriptor = "Lclient!gk;")
	public static final LocalizedString loadedWorldMapLocalizedString = new LocalizedString("Loaded world map", "Weltkarte geladen", "Mappemonde chargée", "Mapa-múndi carregado");

	@OriginalMember(owner = "client!np", name = "H", descriptor = "Lclient!gk;")
	public static final LocalizedString loadingWorldMapLocalizedString = new LocalizedString("Loading world map - ", "Lade Weltkarte - ", "Chargement de la mappemonde - ", "Carregando mapa-múndi - ");

	@OriginalMember(owner = "client!od", name = "F", descriptor = "Lclient!gk;")
	public static final LocalizedString loadingWorldListDataLocalizedString = new LocalizedString("Loading world list data", "Lade Liste der Welten", "Chargement de la liste des serveurs", "Carregando dados da lista de mundos");

	@OriginalMember(owner = "client!ft", name = "J", descriptor = "Lclient!gk;")
	public static final LocalizedString loadedWorldListDataLocalizedString = new LocalizedString("Loaded world list data", "Liste der Welten geladen", "Liste des serveurs chargée", "Dados da lista de mundos carregados");

	@OriginalMember(owner = "client!cu", name = "n", descriptor = "Lclient!gk;")
	public static final LocalizedString loadedClientVariableDataLocalizedString = new LocalizedString("Loaded client variable data", "Client-Variablen geladen", "Variables du client chargées", "As variáveis do sistema foram carregadas");

	@OriginalMember(owner = "client!md", name = "e", descriptor = "Lclient!al;")
	public static ServerConnection serverConnection;

	@OriginalMember(owner = "client!dt", name = "c", descriptor = "I")
	public static int js5ConnectionStage = 0;

	@OriginalMember(owner = "client!nf", name = "V", descriptor = "Lclient!vn;")
	public static Js5NetQueue js5NetQueue;

	@OriginalMember(owner = "client!tl", name = "w", descriptor = "Lclient!vl;")
	public static Js5DiskCache aJs5DiskCache_3;

	@OriginalMember(owner = "client!pu", name = "k", descriptor = "I")
	public static int previousJS5ConnectionAttepts = 0;

	@OriginalMember(owner = "client!bi", name = "B", descriptor = "Lclient!qt;")
	public static Message connectionInitializationMessage;

	@OriginalMember(owner = "client!a", name = "g", descriptor = "I")
	public static int anInt5 = 0;

	@OriginalMember(owner = "client!qj", name = "m", descriptor = "J")
	public static long connectionInitializationTimestamp;

	@OriginalMember(owner = "client!pr", name = "g", descriptor = "I")
	public static int primaryServerPort;

	@OriginalMember(owner = "client!er", name = "C", descriptor = "I")
	public static int fallbackServerPort;

	@OriginalMember(owner = "client!ts", name = "q", descriptor = "I")
	public static int connectionRetrySkipIterations = 0;

	@OriginalMember(owner = "client!un", name = "w", descriptor = "I")
	public static int port;

	@OriginalMember(owner = "client!qc", name = "c", descriptor = "Ljava/lang/String;")
	public static String host;

	@OriginalMember(owner = "client!qk", name = "c", descriptor = "J")
	public static long lastGarbageCollectionRequestTimestamp = 0L;

	@OriginalMember(owner = "client!av", name = "S", descriptor = "J")
	public static long firstLoadClientAssetsTimestamp = 0L;
	@OriginalMember(owner = "client!ba", name = "C", descriptor = "I")
	public static int gameLogicStepCount = 0;

	@OriginalMember(owner = "client!client", name = "main", descriptor = "([Ljava/lang/String;)V")
	public static void main(@OriginalArg(0) String[] arguments) {
		try {
			if (arguments.length != 4) {
				handleInvalidCommandArguments("argument count");
			}

			ClientSettings.worldID = Integer.parseInt(arguments[0]);
			ClientSettings.modewhere = ModeWhere.LOCAL;

			Optional<ModeWhat> modeWhatFromArguments = ModeWhat.fromName(arguments[1]);

			if (modeWhatFromArguments.isPresent()) {
				ClientSettings.modewhat = modeWhatFromArguments.get();
			} else {
				handleInvalidCommandArguments("modewhat");
			}

			ClientSettings.langID = Static73.method1357(arguments[2]);

			if (ClientSettings.langID == -1) {
				if (arguments[2].equals("english")) {
					ClientSettings.langID = 0;
				} else if (arguments[2].equals("german")) {
					ClientSettings.langID = 1;
				} else {
					handleInvalidCommandArguments("language");
				}
			}

			ClientSettings.hasJS = false;
			ClientSettings.hasObjectTag = false;

			Optional<ModeGame> gameWhatFromArguments = ModeGame.fromGameId(arguments[3]);

			if (gameWhatFromArguments.isPresent()) {
				ClientSettings.modeGame = gameWhatFromArguments.get();
			} else {
				handleInvalidCommandArguments("game");
			}

			ClientSettings.aBoolean573 = true;
			ClientSettings.aBoolean423 = true;
			ClientSettings.settings = "";
			ClientSettings.countryID = 0;
			ClientSettings.affiliateID = 0;
			ClientSettings.colourID = ClientSettings.modeGame.getId();

			@Pc(130) client local130 = new client();
			Static6.client = local130;
			local130.method885(ClientSettings.modeGame.getName(), ClientSettings.modewhat.getId() + 32);
			GameShell.frame.setLocation(40, 40);
		} catch (@Pc(153) Exception local153) {
			Static94.handleClientError(local153, null);
		}
	}

	@OriginalMember(owner = "client!pn", name = "a", descriptor = "(Ljava/lang/String;B)V")
	public static void handleInvalidCommandArguments(@OriginalArg(0) String error) {
		System.out.println("Bad " + error + ", Usage: worldid, <live/rc/wip>, <english/german>, <game0/game1>");

		System.exit(1);
	}

	@OriginalMember(owner = "client!cc", name = "a", descriptor = "(Z)V")
	public static void method3938() {
		if (GameShell.fullScreenFrame != null) {
			return;
		}

		@Pc(13) Container container;
		if (GameShell.frame == null) {
			container = GameShell.signLink.hostApplet;
		} else {
			container = GameShell.frame;
		}
		Static425.anInt7000 = container.getSize().width;
		Static17.anInt222 = container.getSize().height;
		@Pc(31) Insets local31;
		if (GameShell.frame == container) {
			local31 = GameShell.frame.getInsets();
			Static425.anInt7000 -= local31.left + local31.right;
			Static17.anInt222 -= local31.bottom + local31.top;
		}
		if (Static450.method5664() == 1) {
			Static302.height = ClientSettings.height;
			Static141.width = ClientSettings.width;
			Static230.xPOS = (Static425.anInt7000 - ClientSettings.width) / 2;
			Static303.yPOS = 0;
		} else if (Static70.anInt1503 < 96 && Static177.anInt2973 == 0) {
			@Pc(100) int local100 = Static425.anInt7000 > 1024 ? 1024 : Static425.anInt7000;
			Static141.width = local100;
			@Pc(109) int local109 = Static17.anInt222 <= 768 ? Static17.anInt222 : 768;
			Static230.xPOS = (Static425.anInt7000 - local100) / 2;
			Static302.height = local109;
			Static303.yPOS = 0;
		} else {
			Static302.height = Static17.anInt222;
			Static141.width = Static425.anInt7000;
			Static303.yPOS = 0;
			Static230.xPOS = 0;
		}
		if (!ClientSettings.modewhere.isLive()) {
			@Pc(132) boolean local132;
			if (Static141.width < 1024 && Static302.height < 768) {
				local132 = true;
			} else {
				local132 = false;
			}
		}
		GameShell.canvas.setSize(Static141.width, Static302.height);
		if (Static122.aClass19_16 != null) {
			Static122.aClass19_16.method4272(GameShell.canvas);
		}
		if (container == GameShell.frame) {
			local31 = GameShell.frame.getInsets();
			GameShell.canvas.setLocation(Static230.xPOS + local31.left, local31.top - -Static303.yPOS);
		} else {
			GameShell.canvas.setLocation(Static230.xPOS, Static303.yPOS);
		}
		if (Static334.anInt5766 != -1) {
			Static327.method4422(true);
		}
		Static348.method4697();
	}

	@OriginalMember(owner = "client!oi", name = "a", descriptor = "(I)V")
	public static void method3510() {
		if (Static405.anInt6682 == 0) {
			return;
		}
		try {
			if (++anInt970 > 1500) {
				if (Static125.aServerConnection_5 != null) {
					Static125.aServerConnection_5.shutdown();
					Static125.aServerConnection_5 = null;
				}
				if (Static239.anInt4518 >= 1) {
					Static296.anInt5302 = -5;
					Static405.anInt6682 = 0;
					return;
				}
				if (Static313.anInt5435 == Static133.JS5Port) {
					Static313.anInt5435 = Static11.HTTPPort;
				} else {
					Static313.anInt5435 = Static133.JS5Port;
				}
				Static239.anInt4518++;
				anInt970 = 0;
				Static405.anInt6682 = 1;
			}
			if (Static405.anInt6682 == 1) {
				Static36.aClass199_3 = GameShell.signLink.emitConnectionInitializationMessage(Static13.host, Static313.anInt5435);
				Static405.anInt6682 = 2;
			}
			@Pc(118) int local118;
			if (Static405.anInt6682 == 2) {
				if (Static36.aClass199_3.status == 2) {
					throw new IOException();
				}
				if (Static36.aClass199_3.status != 1) {
					return;
				}
				Static125.aServerConnection_5 = new ServerConnection((Socket) Static36.aClass199_3.output, GameShell.signLink);
				Static36.aClass199_3 = null;
				Static125.aServerConnection_5.write(Static3.aClass4_Sub12_Sub1_5.pos, Static3.aClass4_Sub12_Sub1_5.data);
				Static329.method4427();
				local118 = Static125.aServerConnection_5.readByteFromServer();
				Static329.method4427();
				if (local118 != 101) {
					Static296.anInt5302 = local118;
					Static405.anInt6682 = 0;
					Static125.aServerConnection_5.shutdown();
					Static125.aServerConnection_5 = null;
					return;
				}
				Static405.anInt6682 = 3;
			}
			if (Static405.anInt6682 == 3 && Static125.aServerConnection_5.getEstimatedBytesAvailable() >= 2) {
				local118 = Static125.aServerConnection_5.readByteFromServer() << 8 | Static125.aServerConnection_5.readByteFromServer();
				Static162.method5279(local118);
				if (Static56.anInt1028 == -1) {
					Static405.anInt6682 = 0;
					Static296.anInt5302 = 6;
					Static125.aServerConnection_5.shutdown();
					Static125.aServerConnection_5 = null;
				} else {
					Static405.anInt6682 = 0;
					Static125.aServerConnection_5.shutdown();
					Static125.aServerConnection_5 = null;
					Static445.method5617();
				}
			}
		} catch (@Pc(188) IOException local188) {
			if (Static125.aServerConnection_5 != null) {
				Static125.aServerConnection_5.shutdown();
				Static125.aServerConnection_5 = null;
			}
			if (Static239.anInt4518 >= 1) {
				Static405.anInt6682 = 0;
				Static296.anInt5302 = -4;
			} else {
				Static405.anInt6682 = 1;
				anInt970 = 0;
				Static239.anInt4518++;
				if (Static133.JS5Port == Static313.anInt5435) {
					Static313.anInt5435 = Static11.HTTPPort;
				} else {
					Static313.anInt5435 = Static133.JS5Port;
				}
			}
		}
	}

	@OriginalMember(owner = "client!wa", name = "a", descriptor = "(I)V")
	public static void method4042() {
		if (Static188.anInt5353 > 1) {
			Static308.anInt5413 = Static325.anInt5640;
			Static188.anInt5353--;
		}

		if (Static95.anInt1910 > 0) {
			Static95.anInt1910--;
		}

		if (Static22.aBoolean38) {
			Static22.aBoolean38 = false;
			Static165.method2731();

			return;
		}

		if (!Static234.aBoolean411) {
			Static314.method4198();
		}

		for (@Pc(38) int local38 = 0; local38 < 100 && method4188(); local38++) {
		}

		if (Static403.anInt6667 != 30) {
			return;
		}

		Static321.method4336(Static251.aClass215_54.method4926(), Static3.aClass4_Sub12_Sub1_5);

		if (Static178.aClass4_Sub42_2 == null) {
			if (Static419.aLong212 <= MonotonicClock.getCurrentTimeInMilliseconds()) {
				Static178.aClass4_Sub42_2 = Static402.aClass256_1.method5479(host);
			}
		} else if (Static178.aClass4_Sub42_2.anInt6883 != -1) {
			Static429.method5476(Static27.aClass215_7);
			Static3.aClass4_Sub12_Sub1_5.p2(Static178.aClass4_Sub42_2.anInt6883);
			Static178.aClass4_Sub42_2 = null;
			Static419.aLong212 = MonotonicClock.getCurrentTimeInMilliseconds() + 30000L;
		}

		@Pc(99) Node_Sub5 local99 = (Node_Sub5) Static413.aClass183_47.method4140();
		@Pc(119) int local119;
		@Pc(140) int local140;
		@Pc(159) int local159;
		@Pc(175) boolean local175;
		@Pc(227) int local227;
		@Pc(234) int local234;
		@Pc(246) int local246;

		if (local99 != null || MonotonicClock.getCurrentTimeInMilliseconds() - 2000L > Static292.aLong177) {
			@Pc(116) boolean local116 = false;
			local119 = Static3.aClass4_Sub12_Sub1_5.pos;

			for (@Pc(124) Node_Sub5 local124 = (Node_Sub5) Static348.aClass183_42.method4140(); local124 != null && Static3.aClass4_Sub12_Sub1_5.pos - local119 < 240; local124 = (Node_Sub5) Static348.aClass183_42.method4144()) {
				local124.popSelf();
				local140 = local124.method519();
				if (local140 < 0) {
					local140 = 0;
				} else if (local140 > 65534) {
					local140 = 65534;
				}
				local159 = local124.method518();
				if (local159 < 0) {
					local159 = 0;
				} else if (local159 > 65534) {
					local159 = 65534;
				}
				local175 = false;
				if (local124.method519() == -1 && local124.method518() == -1) {
					local140 = -1;
					local175 = true;
					local159 = -1;
				}
				if (local159 != Static452.anInt7358 || local140 != Static410.anInt6734) {
					if (!local116) {
						Static429.method5476(Static266.aClass215_62);
						Static3.aClass4_Sub12_Sub1_5.p1(0);
						local116 = true;
						local119 = Static3.aClass4_Sub12_Sub1_5.pos;
					}
					local227 = local159 - Static452.anInt7358;
					Static452.anInt7358 = local159;
					local234 = local140 - Static410.anInt6734;
					Static410.anInt6734 = local140;
					local246 = (int) ((local124.method516() - Static292.aLong177) / 20L);
					if (local246 < 8 && local227 >= -32 && local227 <= 31 && local234 >= -32 && local234 <= 31) {
						local234 += 32;
						local227 += 32;
						Static3.aClass4_Sub12_Sub1_5.p2(local234 + (local246 << 12) + (local227 << 6));
					} else if (local246 < 32 && local227 >= -128 && local227 <= 127 && local234 >= -128 && local234 <= 127) {
						Static3.aClass4_Sub12_Sub1_5.p1(local246 + 128);
						local227 += 128;
						local234 += 128;
						Static3.aClass4_Sub12_Sub1_5.p2(local234 + (local227 << 8));
					} else if (local246 >= 32) {
						Static3.aClass4_Sub12_Sub1_5.p2(local246 + 57344);
						if (local175) {
							Static3.aClass4_Sub12_Sub1_5.p4(Integer.MIN_VALUE);
						} else {
							Static3.aClass4_Sub12_Sub1_5.p4(local140 << 16 | local159);
						}
					} else {
						Static3.aClass4_Sub12_Sub1_5.p1(local246 + 192);
						if (local175) {
							Static3.aClass4_Sub12_Sub1_5.p4(Integer.MIN_VALUE);
						} else {
							Static3.aClass4_Sub12_Sub1_5.p4(local140 << 16 | local159);
						}
					}
					Static292.aLong177 = local124.method516();
				}
			}
			if (local116) {
				Static3.aClass4_Sub12_Sub1_5.pSize1(Static3.aClass4_Sub12_Sub1_5.pos - local119);
			}
		}
		@Pc(416) int local416;
		@Pc(463) int local463;
		if (local99 != null) {
			@Pc(402) long local402 = (local99.method516() - Static259.aLong160) / 50L;
			if (local402 > 32767L) {
				local402 = 32767L;
			}
			Static259.aLong160 = local99.method516();
			local416 = local99.method519();
			if (local416 < 0) {
				local416 = 0;
			} else if (local416 > 65535) {
				local416 = 65535;
			}
			local140 = local99.method518();
			if (local140 < 0) {
				local140 = 0;
			} else if (local140 > 65535) {
				local140 = 65535;
			}
			@Pc(447) byte local447 = 0;
			if (local99.method515() == 2) {
				local447 = 1;
			}
			local463 = (int) local402;
			Static429.method5476(Static226.aClass215_47);
			Static3.aClass4_Sub12_Sub1_5.p4(local416 << 16 | local140);
			Static3.aClass4_Sub12_Sub1_5.p2_alt2(local463 | local447 << 15);
		}
		@Pc(489) int local489;
		if (Static190.anInt3602 > 0) {
			local489 = 0;
			for (local119 = 0; local119 < Static190.anInt3602; local119++) {
				if (Static164.aClass30Array4[local119].method741()) {
					local489++;
				}
			}
			if (local489 > 0) {
				Static429.method5476(Static224.aClass215_44);
				if (local489 > 75) {
					local489 = 75;
				}
				Static3.aClass4_Sub12_Sub1_5.p1(local489 * 3);
				for (local416 = 0; local416 < Static190.anInt3602; local416++) {
					@Pc(537) Class30 local537 = Static164.aClass30Array4[local416];
					if (local537.method741()) {
						@Pc(550) long local550 = (local537.method742() - Static256.aLong156) / 50L;
						Static256.aLong156 = local537.method742();
						if (local550 > 65535L) {
							local550 = 65535L;
						}
						Static3.aClass4_Sub12_Sub1_5.p1(local537.method746());
						Static3.aClass4_Sub12_Sub1_5.p2((int) local550);
					}
				}
			}
		}
		if (Static324.anInt5626 > 0) {
			Static324.anInt5626--;
		}
		if (Static251.aBoolean429 && Static324.anInt5626 <= 0) {
			Static251.aBoolean429 = false;
			Static324.anInt5626 = 20;
			Static429.method5476(Static253.aClass215_57);
			Static3.aClass4_Sub12_Sub1_5.p2_alt2((int) Static368.aFloat192 >> 3);
			Static3.aClass4_Sub12_Sub1_5.p2_alt3((int) Static164.aFloat142 >> 3);
		}
		if (Static265.aBoolean457 && !Static41.aBoolean74) {
			Static41.aBoolean74 = true;
			Static429.method5476(Static44.aClass215_9);
			Static3.aClass4_Sub12_Sub1_5.p1(1);
		}
		if (!Static265.aBoolean457 && Static41.aBoolean74) {
			Static41.aBoolean74 = false;
			Static429.method5476(Static44.aClass215_9);
			Static3.aClass4_Sub12_Sub1_5.p1(0);
		}
		if (!Static249.aBoolean425) {
			Static429.method5476(Static197.aClass215_39);
			Static3.aClass4_Sub12_Sub1_5.p1(0);
			local489 = Static3.aClass4_Sub12_Sub1_5.pos;
			@Pc(692) Packet local692 = Static323.aClass50_Sub1_1.method2863();
			Static3.aClass4_Sub12_Sub1_5.pArrayBuffer(local692.data, local692.pos);
			Static3.aClass4_Sub12_Sub1_5.pSize1(Static3.aClass4_Sub12_Sub1_5.pos - local489);
			Static249.aBoolean425 = true;
		}
		if (Static202.aClass164ArrayArrayArray5 != null) {
			if (Static111.anInt2386 == 2) {
				Static329.method4430();
			} else if (Static111.anInt2386 == 3) {
				Static294.method514();
			}
		}
		if (Static308.aBoolean487) {
			Static308.aBoolean487 = false;
		} else {
			Static380.aFloat195 /= 2.0F;
		}
		if (Static32.aBoolean63) {
			Static32.aBoolean63 = false;
		} else {
			Static50.aFloat28 /= 2.0F;
		}
		Static255.method3687();
		if (Static403.anInt6667 != 30) {
			return;
		}
		Static248.method3623();
		Static80.method1433();
		Static412.method5294();
		Static177.method2527();
		Static410.anInt6735++;
		if (Static410.anInt6735 > 750) {
			Static165.method2731();
			return;
		}
		Static229.method3458();
		method884();
		Static108.method2009();
		for (local489 = Static257.aClass114_1.method2832(true); local489 != -1; local489 = Static257.aClass114_1.method2832(false)) {
			Static277.method3934(local489);
			Static8.anIntArray7[Static292.anInt5255++ & 0x1F] = local489;
		}
		@Pc(840) Class247 local840;
		for (@Pc(815) SecondaryNode_Sub1_Sub11 local815 = Static92.method1614(); local815 != null; local815 = Static92.method1614()) {
			local416 = local815.method2606();
			local140 = local815.method2609();
			if (local416 == 1) {
				Static165.anIntArray210[local140] = local815.anInt3083;
				Static135.aBoolean256 |= Static22.aBooleanArray3[local140];
				Static143.anIntArray184[Static314.anInt5473++ & 0x1F] = local140;
			} else if (local416 == 2) {
				Static265.aStringArray20[local140] = local815.aString32;
				Static277.anIntArray337[Static218.anInt4042++ & 0x1F] = local140;
			} else if (local416 == 3) {
				local840 = Static392.method5121(local140);
				if (!local815.aString32.equals(local840.aString67)) {
					local840.aString67 = local815.aString32;
					Static63.method1142(local840);
				}
			} else if (local416 == 4) {
				local840 = Static392.method5121(local140);
				local463 = local815.anInt3083;
				local227 = local815.anInt3082;
				local234 = local815.anInt3079;
				if (local463 != local840.anInt6796 || local840.anInt6781 != local227 || local234 != local840.anInt6848) {
					local840.anInt6781 = local227;
					local840.anInt6848 = local234;
					local840.anInt6796 = local463;
					Static63.method1142(local840);
				}
			} else if (local416 == 5) {
				local840 = Static392.method5121(local140);
				if (local815.anInt3083 != local840.anInt6788 || local815.anInt3083 == -1) {
					local840.anInt6815 = 0;
					local840.anInt6829 = 0;
					local840.anInt6783 = 1;
					local840.anInt6788 = local815.anInt3083;
					Static63.method1142(local840);
				}
			} else if (local416 == 6) {
				local159 = local815.anInt3083;
				local463 = local159 >> 10 & 0x1F;
				local227 = local159 >> 5 & 0x1F;
				local234 = local159 & 0x1F;
				local246 = (local234 << 3) + (local227 << 11) + (local463 << 19);
				@Pc(937) Class247 local937 = Static392.method5121(local140);
				if (local937.anInt6772 != local246) {
					local937.anInt6772 = local246;
					Static63.method1142(local937);
				}
			} else if (local416 == 7) {
				local840 = Static392.method5121(local140);
				local175 = local815.anInt3083 == 1;
				if (local175 != local840.aBoolean616) {
					local840.aBoolean616 = local175;
					Static63.method1142(local840);
				}
			} else if (local416 == 8) {
				local840 = Static392.method5121(local140);
				if (local840.anInt6844 != local815.anInt3083 || local840.anInt6858 != local815.anInt3082 || local815.anInt3079 != local840.anInt6857) {
					local840.anInt6857 = local815.anInt3079;
					local840.anInt6858 = local815.anInt3082;
					local840.anInt6844 = local815.anInt3083;
					if (local840.anInt6779 != -1) {
						if (local840.anInt6822 > 0) {
							local840.anInt6857 = local840.anInt6857 * 32 / local840.anInt6822;
						} else if (local840.anInt6816 > 0) {
							local840.anInt6857 = local840.anInt6857 * 32 / local840.anInt6816;
						}
					}
					Static63.method1142(local840);
				}
			} else if (local416 == 9) {
				local840 = Static392.method5121(local140);
				if (local840.anInt6779 != local815.anInt3083 || local840.anInt6832 != local815.anInt3082) {
					local840.anInt6832 = local815.anInt3082;
					local840.anInt6779 = local815.anInt3083;
					Static63.method1142(local840);
				}
			} else if (local416 == 10) {
				local840 = Static392.method5121(local140);
				if (local840.anInt6814 != local815.anInt3083 || local840.anInt6826 != local815.anInt3082 || local840.anInt6843 != local815.anInt3079) {
					local840.anInt6814 = local815.anInt3083;
					local840.anInt6826 = local815.anInt3082;
					local840.anInt6843 = local815.anInt3079;
					Static63.method1142(local840);
				}
			} else if (local416 == 11) {
				local840 = Static392.method5121(local140);
				local840.aByte79 = 0;
				local840.anInt6836 = local840.anInt6804 = local815.anInt3083;
				local840.aByte81 = 0;
				local840.anInt6859 = local840.anInt6808 = local815.anInt3082;
				Static63.method1142(local840);
			} else if (local416 == 12) {
				local840 = Static392.method5121(local140);
				local463 = local815.anInt3083;
				if (local840 != null && local840.anInt6840 == 0) {
					if (local463 > local840.anInt6834 - local840.anInt6805) {
						local463 = local840.anInt6834 - local840.anInt6805;
					}
					if (local463 < 0) {
						local463 = 0;
					}
					if (local840.anInt6849 != local463) {
						local840.anInt6849 = local463;
						Static63.method1142(local840);
					}
				}
			} else if (local416 == 14) {
				local840 = Static392.method5121(local140);
				local840.lb = local815.anInt3083;
			} else if (local416 == 15) {
				Static60.anInt1094 = local815.anInt3082;
				Static350.aBoolean556 = true;
				Static343.anInt771 = local815.anInt3083;
			} else if (local416 == 16) {
				local840 = Static392.method5121(local140);
				local840.anInt6791 = local815.anInt3083;
			}
		}
		Static176.anInt3414++;
		if (Static85.anInt1764 != 0) {
			Static216.anInt4014 += 20;
			if (Static216.anInt4014 >= 400) {
				Static85.anInt1764 = 0;
			}
		}
		if (Static378.aClass247_8 != null) {
			Static91.anInt1087++;
			if (Static91.anInt1087 >= 15) {
				Static63.method1142(Static378.aClass247_8);
				Static378.aClass247_8 = null;
			}
		}
		Static81.aClass247_2 = null;
		Static232.aClass247_9 = null;
		Static361.aBoolean570 = false;
		Static390.aBoolean584 = false;
		Static361.method4870(-1, null, -1);
		Static40.method697(null, -1, -1);
		if (!Static341.aBoolean599) {
			Static157.anInt3147 = -1;
		}
		Static164.method3582();
		Static325.anInt5640++;
		if (Static219.aBoolean588) {
			Static429.method5476(Static372.aClass215_84);
			Static3.aClass4_Sub12_Sub1_5.p4_alt2(Static445.anInt7274 | Static263.anInt4958 << 14 | Static155.anInt3644 << 28);
			Static219.aBoolean588 = false;
		}
		while (true) {
			@Pc(1462) Node_Sub34 local1462;
			@Pc(1467) Class247 local1467;
			do {
				local1462 = (Node_Sub34) Static237.aClass183_52.method4136();
				if (local1462 == null) {
					while (true) {
						do {
							local1462 = (Node_Sub34) Static39.aClass183_3.method4136();
							if (local1462 == null) {
								while (true) {
									do {
										local1462 = (Node_Sub34) Static291.aClass183_35.method4136();
										if (local1462 == null) {
											if (Static81.aClass247_2 == null) {
												Static64.anInt1367 = 0;
											}
											if (Static281.aClass247_12 != null) {
												Static1.method3();
											}
											if (Static104.anInt2252 > 0 && Static384.aClass244_1.method5489(82) && Static384.aClass244_1.method5489(81) && Static430.anInt3862 != 0) {
												local416 = Static1.aClass16_Sub1_Sub5_Sub1_1.aByte82 - Static430.anInt3862;
												if (local416 < 0) {
													local416 = 0;
												} else if (local416 > 3) {
													local416 = 3;
												}
												Static200.method3168(local416, Static86.anInt1771 + Static1.aClass16_Sub1_Sub5_Sub1_1.anIntArray427[0], Static1.aClass16_Sub1_Sub5_Sub1_1.anIntArray426[0] + Static180.anInt3453);
											}
											Static41.method730();
											for (local416 = 0; local416 < 5; local416++) {
												@Pc(1675) int local1675 = Static390.anIntArray486[local416]++;
											}
											if (Static135.aBoolean256 && Static174.aLong119 < MonotonicClock.getCurrentTimeInMilliseconds() - 60000L) {
												Static316.method4216();
											}
											Static200.anInt3873++;
											if (Static200.anInt3873 > 500) {
												Static200.anInt3873 = 0;
												local140 = (int) (Math.random() * 8.0D);
												if ((local140 & 0x1) == 1) {
													Static217.anInt4024 += Static105.anInt2326;
												}
												if ((local140 & 0x4) == 4) {
													Static273.anInt5119 += Static268.anInt5006;
												}
												if ((local140 & 0x2) == 2) {
													Static323.anInt5620 += Static195.anInt3714;
												}
											}
											if (Static217.anInt4024 < -50) {
												Static105.anInt2326 = 2;
											}
											if (Static323.anInt5620 < -55) {
												Static195.anInt3714 = 2;
											}
											if (Static217.anInt4024 > 50) {
												Static105.anInt2326 = -2;
											}
											if (Static323.anInt5620 > 55) {
												Static195.anInt3714 = -2;
											}
											if (Static273.anInt5119 < -40) {
												Static268.anInt5006 = 1;
											}
											Static74.anInt1528++;
											if (Static273.anInt5119 > 40) {
												Static268.anInt5006 = -1;
											}
											if (Static74.anInt1528 > 500) {
												Static74.anInt1528 = 0;
												local140 = (int) (Math.random() * 8.0D);
												if ((local140 & 0x2) == 2) {
													Static110.anInt2374 += Static110.anInt2369;
												}
												if ((local140 & 0x1) == 1) {
													Static175.anInt3399 += Static400.anInt6628;
												}
											}
											if (Static175.anInt3399 < -60) {
												Static400.anInt6628 = 2;
											}
											if (Static175.anInt3399 > 60) {
												Static400.anInt6628 = -2;
											}
											if (Static110.anInt2374 < -20) {
												Static110.anInt2369 = 1;
											}
											if (Static110.anInt2374 > 10) {
												Static110.anInt2369 = -1;
											}
											Static162.anInt6744++;
											if (Static162.anInt6744 > 50) {
												Static429.method5476(Static14.aClass215_2);
											}
											if (Static83.aBoolean159) {
												Static374.method4996();
												Static83.aBoolean159 = false;
											}
											try {
												if (Static125.aServerConnection_5 != null && Static3.aClass4_Sub12_Sub1_5.pos > 0) {
													Static60.anInt1097 += Static3.aClass4_Sub12_Sub1_5.pos;
													Static125.aServerConnection_5.write(Static3.aClass4_Sub12_Sub1_5.pos, Static3.aClass4_Sub12_Sub1_5.data);
													Static3.aClass4_Sub12_Sub1_5.pos = 0;
													Static162.anInt6744 = 0;
													return;
												}
												return;
											} catch (@Pc(1884) IOException local1884) {
												Static165.method2731();
												return;
											}
										}
										local1467 = local1462.aClass247_15;
										if (local1467.anInt6865 < 0) {
											break;
										}
										local840 = Static392.method5121(local1467.anInt6850);
									} while (local840 == null || local840.aClass247Array2 == null || local1467.anInt6865 >= local840.aClass247Array2.length || local1467 != local840.aClass247Array2[local1467.anInt6865]);
									Static271.method3894(local1462);
								}
							}
							local1467 = local1462.aClass247_15;
							if (local1467.anInt6865 < 0) {
								break;
							}
							local840 = Static392.method5121(local1467.anInt6850);
						} while (local840 == null || local840.aClass247Array2 == null || local1467.anInt6865 >= local840.aClass247Array2.length || local840.aClass247Array2[local1467.anInt6865] != local1467);
						Static271.method3894(local1462);
					}
				}
				local1467 = local1462.aClass247_15;
				if (local1467.anInt6865 < 0) {
					break;
				}
				local840 = Static392.method5121(local1467.anInt6850);
			} while (local840 == null || local840.aClass247Array2 == null || local840.aClass247Array2.length <= local1467.anInt6865 || local1467 != local840.aClass247Array2[local1467.anInt6865]);
			Static271.method3894(local1462);
		}
	}

	@OriginalMember(owner = "client!vk", name = "f", descriptor = "(I)V")
	public static void method5430() {
		if (Static238.anInt4506 == 0 || Static238.anInt4506 == 5) {
			return;
		}
		try {
			if (++Static64.anInt1366 > 2000) {
				if (Static125.aServerConnection_5 != null) {
					Static125.aServerConnection_5.shutdown();
					Static125.aServerConnection_5 = null;
				}
				if (Static212.anInt3932 >= 1) {
					Static238.anInt4506 = 0;
					Static296.anInt5302 = -5;
					return;
				}
				Static238.anInt4506 = 1;
				Static212.anInt3932++;
				if (primaryServerPort == port) {
					port = fallbackServerPort;
				} else {
					port = primaryServerPort;
				}
				Static64.anInt1366 = 0;
			}
			if (Static238.anInt4506 == 1) {
				Static36.aClass199_3 = GameShell.signLink.emitConnectionInitializationMessage(host, port);
				Static238.anInt4506 = 2;
			}
			@Pc(112) int local112;
			if (Static238.anInt4506 == 2) {
				if (Static36.aClass199_3.status == 2) {
					throw new IOException();
				}
				if (Static36.aClass199_3.status != 1) {
					return;
				}
				Static125.aServerConnection_5 = new ServerConnection((Socket) Static36.aClass199_3.output, GameShell.signLink);
				Static36.aClass199_3 = null;
				@Pc(102) long local102 = Static286.aLong174 = Static96.method1684(Static2.aString1);
				Static3.aClass4_Sub12_Sub1_5.pos = 0;
				local112 = (int) (local102 >> 16 & 0x1FL);
				Static3.aClass4_Sub12_Sub1_5.p1(Class60.aClass60_1.anInt1812);
				Static3.aClass4_Sub12_Sub1_5.p1(local112);
				Static125.aServerConnection_5.write(2, Static3.aClass4_Sub12_Sub1_5.data);
				Static329.method4427();
				@Pc(134) int local134 = Static125.aServerConnection_5.readByteFromServer();
				Static329.method4427();
				if (local134 != 0) {
					Static238.anInt4506 = 0;
					Static296.anInt5302 = local134;
					Static125.aServerConnection_5.shutdown();
					Static125.aServerConnection_5 = null;
					return;
				}
				Static238.anInt4506 = 3;
			}
			if (Static238.anInt4506 == 3) {
				if (Static125.aServerConnection_5.getEstimatedBytesAvailable() < 8) {
					return;
				}
				Static125.aServerConnection_5.readBytesFromServer(0, 8, Static146.aClass4_Sub12_Sub1_3.data);
				Static146.aClass4_Sub12_Sub1_3.pos = 0;
				Static309.aLong183 = Static146.aClass4_Sub12_Sub1_3.g8();
				@Pc(185) Packet local185 = new Packet(70);
				@Pc(188) int[] local188 = new int[] { (int) (Math.random() * 9.9999999E7D), (int) (Math.random() * 9.9999999E7D), (int) (Static309.aLong183 >> 32), (int) Static309.aLong183 };
				local185.p1(10);
				local185.p4(local188[0]);
				local185.p4(local188[1]);
				local185.p4(local188[2]);
				local185.p4(local188[3]);
				local185.p8(Static96.method1684(Static2.aString1));
				local185.pjstr(Static297.aString52);
				local185.rsaEncrypt(Static85.aBigInteger1, Static309.aBigInteger2);
				Static3.aClass4_Sub12_Sub1_5.pos = 0;
				if (Static403.anInt6667 == 40) {
					Static3.aClass4_Sub12_Sub1_5.p1(Class60.aClass60_5.anInt1812);
				} else {
					Static3.aClass4_Sub12_Sub1_5.p1(Class60.aClass60_3.anInt1812);
				}
				Static3.aClass4_Sub12_Sub1_5.p2(0);
				local112 = Static3.aClass4_Sub12_Sub1_5.pos;
				Static3.aClass4_Sub12_Sub1_5.p4(592);
				Static3.aClass4_Sub12_Sub1_5.p1(Static161.anInt3177);
				Static3.aClass4_Sub12_Sub1_5.p1(Static450.method5664());
				Static3.aClass4_Sub12_Sub1_5.p2(Static141.width);
				Static3.aClass4_Sub12_Sub1_5.p2(Static302.height);
				Static3.aClass4_Sub12_Sub1_5.p1(Static323.aClass50_Sub1_1.anInt3440);
				Static82.method1471(Static3.aClass4_Sub12_Sub1_5);
				Static3.aClass4_Sub12_Sub1_5.pjstr(ClientSettings.settings);
				Static3.aClass4_Sub12_Sub1_5.p4(ClientSettings.affiliateID);
				@Pc(323) Packet local323 = Static323.aClass50_Sub1_1.method2863();
				Static3.aClass4_Sub12_Sub1_5.p1(local323.pos);
				Static3.aClass4_Sub12_Sub1_5.pArrayBuffer(local323.data, local323.pos);
				Static249.aBoolean425 = true;
				Static3.aClass4_Sub12_Sub1_5.p2(Static183.anInt3512);
				Static3.aClass4_Sub12_Sub1_5.p4(Static395.aClass76_92.method2111());
				Static3.aClass4_Sub12_Sub1_5.p4(Static324.aClass76_69.method2111());
				Static3.aClass4_Sub12_Sub1_5.p4(Static74.aClass76_20.method2111());
				Static3.aClass4_Sub12_Sub1_5.p4(Static256.aClass76_50.method2111());
				Static3.aClass4_Sub12_Sub1_5.p4(Static67.aClass76_19.method2111());
				Static3.aClass4_Sub12_Sub1_5.p4(Static49.aClass76_27.method2111());
				Static3.aClass4_Sub12_Sub1_5.p4(Static46.aClass76_54.method2111());
				Static3.aClass4_Sub12_Sub1_5.p4(Static357.aClass76_82.method2111());
				Static3.aClass4_Sub12_Sub1_5.p4(Static293.aClass76_60.method2111());
				Static3.aClass4_Sub12_Sub1_5.p4(Static196.aClass76_44.method2111());
				Static3.aClass4_Sub12_Sub1_5.p4(Static88.aClass76_23.method2111());
				Static3.aClass4_Sub12_Sub1_5.p4(Static284.aClass76_55.method2111());
				Static3.aClass4_Sub12_Sub1_5.p4(Static197.aClass76_45.method2111());
				Static3.aClass4_Sub12_Sub1_5.p4(Static209.aClass76_48.method2111());
				Static3.aClass4_Sub12_Sub1_5.p4(Static312.aClass76_66.method2111());
				Static3.aClass4_Sub12_Sub1_5.p4(Static350.aClass76_79.method2111());
				Static3.aClass4_Sub12_Sub1_5.p4(Static424.aClass76_99.method2111());
				Static3.aClass4_Sub12_Sub1_5.p4(Static208.aClass76_29.method2111());
				Static3.aClass4_Sub12_Sub1_5.p4(Static381.aClass76_87.method2111());
				Static3.aClass4_Sub12_Sub1_5.p4(Static391.aClass76_91.method2111());
				Static3.aClass4_Sub12_Sub1_5.p4(Static388.aClass76_90.method2111());
				Static3.aClass4_Sub12_Sub1_5.p4(Static55.aClass76_16.method2111());
				Static3.aClass4_Sub12_Sub1_5.p4(Static64.aClass76_17.method2111());
				Static3.aClass4_Sub12_Sub1_5.p4(Static163.aClass76_39.method2111());
				Static3.aClass4_Sub12_Sub1_5.p4(Static66.aClass76_70.method2111());
				Static3.aClass4_Sub12_Sub1_5.p4(Static154.aClass76_11.method2111());
				Static3.aClass4_Sub12_Sub1_5.p4(Static24.aClass76_61.method2111());
				Static3.aClass4_Sub12_Sub1_5.p4(Static417.aClass76_98.method2111());
				Static3.aClass4_Sub12_Sub1_5.p4(Static19.aClass76_2.method2111());
				Static3.aClass4_Sub12_Sub1_5.p4(Static366.aClass76_83.method2111());
				Static3.aClass4_Sub12_Sub1_5.pArrayBuffer(local185.data, local185.pos);
				Static3.aClass4_Sub12_Sub1_5.pSize2(Static3.aClass4_Sub12_Sub1_5.pos - local112);
				Static125.aServerConnection_5.write(Static3.aClass4_Sub12_Sub1_5.pos, Static3.aClass4_Sub12_Sub1_5.data);
				Static3.aClass4_Sub12_Sub1_5.initializeIsaacRandom(local188);
				for (@Pc(551) int local551 = 0; local551 < 4; local551++) {
					local188[local551] += 50;
				}
				Static146.aClass4_Sub12_Sub1_3.initializeIsaacRandom(local188);
				Static238.anInt4506 = 4;
			}
			if (Static238.anInt4506 == 4) {
				if (Static125.aServerConnection_5.getEstimatedBytesAvailable() < 1) {
					return;
				}
				@Pc(585) int local585 = Static125.aServerConnection_5.readByteFromServer();
				if (local585 == 21) {
					Static238.anInt4506 = 7;
				} else if (local585 == 29) {
					Static238.anInt4506 = 11;
				} else if (local585 == 1) {
					Static238.anInt4506 = 5;
					Static296.anInt5302 = local585;
					return;
				} else if (local585 == 2) {
					Static238.anInt4506 = 8;
				} else if (local585 == 15) {
					Static454.anInt4075 = -2;
					Static238.anInt4506 = 12;
				} else if (local585 == 23 && Static212.anInt3932 < 1) {
					Static64.anInt1366 = 0;
					Static238.anInt4506 = 1;
					Static212.anInt3932++;
					Static125.aServerConnection_5.shutdown();
					Static125.aServerConnection_5 = null;
					return;
				} else {
					Static238.anInt4506 = 0;
					Static296.anInt5302 = local585;
					Static125.aServerConnection_5.shutdown();
					Static125.aServerConnection_5 = null;
					return;
				}
			}
			if (Static238.anInt4506 == 6) {
				Static3.aClass4_Sub12_Sub1_5.pos = 0;
				Static3.aClass4_Sub12_Sub1_5.method1133(Class60.aClass60_4.anInt1812);
				Static125.aServerConnection_5.write(Static3.aClass4_Sub12_Sub1_5.pos, Static3.aClass4_Sub12_Sub1_5.data);
				Static238.anInt4506 = 4;
			} else if (Static238.anInt4506 == 7) {
				if (Static125.aServerConnection_5.getEstimatedBytesAvailable() >= 1) {
					Static175.anInt3398 = (Static125.aServerConnection_5.readByteFromServer() + 3) * 60;
					Static296.anInt5302 = 21;
					Static238.anInt4506 = 0;
					Static125.aServerConnection_5.shutdown();
					Static125.aServerConnection_5 = null;
				}
			} else if (Static238.anInt4506 != 11) {
				if (Static238.anInt4506 == 8) {
					if (Static125.aServerConnection_5.getEstimatedBytesAvailable() < 13) {
						return;
					}
					Static125.aServerConnection_5.readBytesFromServer(0, 13, Static146.aClass4_Sub12_Sub1_3.data);
					Static146.aClass4_Sub12_Sub1_3.pos = 0;
					Static104.anInt2252 = Static146.aClass4_Sub12_Sub1_3.g1();
					Static123.anInt6262 = Static146.aClass4_Sub12_Sub1_3.g1();
					Static109.aBoolean628 = Static146.aClass4_Sub12_Sub1_3.g1() == 1;
					Static396.aBoolean443 = Static146.aClass4_Sub12_Sub1_3.g1() == 1;
					Static436.aBoolean668 = Static146.aClass4_Sub12_Sub1_3.g1() == 1;
					Static308.aBoolean486 = Static146.aClass4_Sub12_Sub1_3.g1() == 1;
					Static207.anInt5452 = Static146.aClass4_Sub12_Sub1_3.g2();
					ClientSettings.aBoolean423 = Static146.aClass4_Sub12_Sub1_3.g1() == 1;
					Static325.aBoolean506 = Static146.aClass4_Sub12_Sub1_3.g1() == 1;
					Static267.aClass262_2.method5564(Static325.aBoolean506);
					Static444.aClass206_3.method4704(Static325.aBoolean506);
					Static329.aClass240_1.method5230(Static325.aBoolean506);
					if (Static109.aBoolean628 && !Static436.aBoolean668 || ClientSettings.aBoolean423) {
						try {
							Static458.callJavaScriptMethod(GameShell.signLink.hostApplet, "zap");
						} catch (@Pc(880) Throwable local880) {
							if (ClientSettings.hasAdvert) {
								try {
									GameShell.signLink.hostApplet.getAppletContext().showDocument(new URL(GameShell.signLink.hostApplet.getCodeBase(), "blank.ws"), "tbi");
								} catch (@Pc(896) Exception local896) {
								}
							}
						}
					} else {
						try {
							Static458.callJavaScriptMethod(GameShell.signLink.hostApplet, "unzap");
						} catch (@Pc(870) Throwable local870) {
						}
					}
					if (ClientSettings.modewhere.isLive()) {
						try {
							Static458.callJavaScriptMethod(GameShell.signLink.hostApplet, "loggedin");
						} catch (@Pc(908) Throwable local908) {
						}
					}
					Static238.anInt4506 = 10;
				}
				if (Static238.anInt4506 == 10) {
					if (Static146.aClass4_Sub12_Sub1_3.method1141()) {
						if (Static125.aServerConnection_5.getEstimatedBytesAvailable() < 1) {
							return;
						}
						Static125.aServerConnection_5.readBytesFromServer(Static146.aClass4_Sub12_Sub1_3.pos + 2, 1, Static146.aClass4_Sub12_Sub1_3.data);
					}
					Static300.aClass22_246 = Static149.method2553()[Static146.aClass4_Sub12_Sub1_3.method1140()];
					Static454.anInt4075 = Static146.aClass4_Sub12_Sub1_3.g2();
					Static238.anInt4506 = 9;
				}
				@Pc(970) int local970;
				if (Static238.anInt4506 == 9) {
					if (Static125.aServerConnection_5.getEstimatedBytesAvailable() >= Static454.anInt4075) {
						Static125.aServerConnection_5.readBytesFromServer(0, Static454.anInt4075, Static146.aClass4_Sub12_Sub1_3.data);
						Static146.aClass4_Sub12_Sub1_3.pos = 0;
						local970 = Static454.anInt4075;
						Static238.anInt4506 = 0;
						Static296.anInt5302 = 2;
						Static167.method2736();
						Static391.method5117(Static146.aClass4_Sub12_Sub1_3);
						Static169.anInt3265 = -1;
						Static230.method3470();
						if (local970 != Static146.aClass4_Sub12_Sub1_3.pos) {
							throw new RuntimeException("lswp pos:" + Static146.aClass4_Sub12_Sub1_3.pos + " psize:" + local970);
						}
						Static300.aClass22_246 = null;
					}
				} else if (Static238.anInt4506 == 12) {
					if (Static454.anInt4075 == -2) {
						if (Static125.aServerConnection_5.getEstimatedBytesAvailable() < 2) {
							return;
						}
						Static125.aServerConnection_5.readBytesFromServer(0, 2, Static146.aClass4_Sub12_Sub1_3.data);
						Static146.aClass4_Sub12_Sub1_3.pos = 0;
						Static454.anInt4075 = Static146.aClass4_Sub12_Sub1_3.g2();
					}
					if (Static125.aServerConnection_5.getEstimatedBytesAvailable() >= Static454.anInt4075) {
						Static125.aServerConnection_5.readBytesFromServer(0, Static454.anInt4075, Static146.aClass4_Sub12_Sub1_3.data);
						Static146.aClass4_Sub12_Sub1_3.pos = 0;
						local970 = Static454.anInt4075;
						Static238.anInt4506 = 0;
						Static296.anInt5302 = 15;
						Static297.method4069();
						Static391.method5117(Static146.aClass4_Sub12_Sub1_3);
						if (local970 != Static146.aClass4_Sub12_Sub1_3.pos) {
							throw new RuntimeException("lswpr pos:" + Static146.aClass4_Sub12_Sub1_3.pos + " psize:" + local970);
						}
						Static300.aClass22_246 = null;
					}
				}
			} else if (Static125.aServerConnection_5.getEstimatedBytesAvailable() >= 1) {
				Static299.anInt5328 = Static125.aServerConnection_5.readByteFromServer();
				Static238.anInt4506 = 0;
				Static296.anInt5302 = 29;
				Static125.aServerConnection_5.shutdown();
				Static125.aServerConnection_5 = null;
			}
		} catch (@Pc(1095) IOException local1095) {
			if (Static125.aServerConnection_5 != null) {
				Static125.aServerConnection_5.shutdown();
				Static125.aServerConnection_5 = null;
			}
			if (Static212.anInt3932 >= 1) {
				Static296.anInt5302 = -4;
				Static238.anInt4506 = 0;
			} else {
				if (primaryServerPort == port) {
					port = fallbackServerPort;
				} else {
					port = primaryServerPort;
				}
				Static238.anInt4506 = 1;
				Static212.anInt3932++;
				Static64.anInt1366 = 0;
			}
		}
	}

	@OriginalMember(owner = "client!kv", name = "e", descriptor = "(B)V")
	public static void method3275() {
		Static299.method4087(false);
		Static100.anInt2020 = 0;
		@Pc(12) boolean local12 = true;
		for (@Pc(14) int local14 = 0; local14 < Static386.aByteArrayArray15.length; local14++) {
			if (Static225.anIntArray291[local14] != -1 && Static386.aByteArrayArray15[local14] == null) {
				Static386.aByteArrayArray15[local14] = Static49.aClass76_27.method2104(0, Static225.anIntArray291[local14]);
				if (Static386.aByteArrayArray15[local14] == null) {
					Static100.anInt2020++;
					local12 = false;
				}
			}
			if (Static346.anIntArray418[local14] != -1 && Static247.aByteArrayArray16[local14] == null) {
				Static247.aByteArrayArray16[local14] = Static49.aClass76_27.method2121(Static346.anIntArray418[local14], 0, Static376.anIntArrayArray50[local14]);
				if (Static247.aByteArrayArray16[local14] == null) {
					Static100.anInt2020++;
					local12 = false;
				}
			}
			if (Static95.anIntArray155[local14] != -1 && Static435.aByteArrayArray30[local14] == null) {
				Static435.aByteArrayArray30[local14] = Static49.aClass76_27.method2104(0, Static95.anIntArray155[local14]);
				if (Static435.aByteArrayArray30[local14] == null) {
					Static100.anInt2020++;
					local12 = false;
				}
			}
			if (Static189.anIntArray236[local14] != -1 && Static193.aByteArrayArray13[local14] == null) {
				Static193.aByteArrayArray13[local14] = Static49.aClass76_27.method2104(0, Static189.anIntArray236[local14]);
				if (Static193.aByteArrayArray13[local14] == null) {
					Static100.anInt2020++;
					local12 = false;
				}
			}
			if (Static175.anIntArray222 != null && Static34.aByteArrayArray1[local14] == null && Static175.anIntArray222[local14] != -1) {
				Static34.aByteArrayArray1[local14] = Static49.aClass76_27.method2121(Static175.anIntArray222[local14], 0, Static376.anIntArrayArray50[local14]);
				if (Static34.aByteArrayArray1[local14] == null) {
					Static100.anInt2020++;
					local12 = false;
				}
			}
		}
		if (Static292.aClass195_2 == null) {
			if (Static197.aClass4_Sub1_Sub5_2 == null || !Static163.aClass76_39.method2107(Static197.aClass4_Sub1_Sub5_2.aString16 + "_staticelements")) {
				Static292.aClass195_2 = new Class195(0);
			} else if (Static163.aClass76_39.method2103(Static197.aClass4_Sub1_Sub5_2.aString16 + "_staticelements")) {
				Static292.aClass195_2 = Static380.method5018(Static163.aClass76_39, Static197.aClass4_Sub1_Sub5_2.aString16 + "_staticelements", Static325.aBoolean506);
			} else {
				local12 = false;
				Static100.anInt2020++;
			}
		}
		if (!local12) {
			Static51.anInt883 = 1;
			return;
		}
		local12 = true;
		Static275.anInt5144 = 0;
		@Pc(266) int local266;
		@Pc(276) int local276;
		for (@Pc(248) int local248 = 0; local248 < Static386.aByteArrayArray15.length; local248++) {
			@Pc(254) byte[] local254 = Static247.aByteArrayArray16[local248];
			if (local254 != null) {
				local266 = (Static308.anIntArray372[local248] >> 8) * 64 - Static180.anInt3453;
				local276 = (Static308.anIntArray372[local248] & 0xFF) * 64 - Static86.anInt1771;
				if (Static448.anInt7307 != 0) {
					local266 = 10;
					local276 = 10;
				}
				local12 &= Static361.method4871(Static326.anInt5666, local266, Static283.anInt5187, local254, local276);
			}
			local254 = Static193.aByteArrayArray13[local248];
			if (local254 != null) {
				local266 = (Static308.anIntArray372[local248] >> 8) * 64 - Static180.anInt3453;
				local276 = (Static308.anIntArray372[local248] & 0xFF) * 64 - Static86.anInt1771;
				if (Static448.anInt7307 != 0) {
					local266 = 10;
					local276 = 10;
				}
				local12 &= Static361.method4871(Static326.anInt5666, local266, Static283.anInt5187, local254, local276);
			}
		}
		if (!local12) {
			Static51.anInt883 = 2;
			return;
		}
		if (Static51.anInt883 != 0) {
			Static436.method5519(true, Static439.A_LOCALIZED_STRING___148.getLocalizedString(ClientSettings.langID) + "<br>(100%)", Static207.aClass46_9);
		}
		Static159.method2701();
		Static409.method5485();
		@Pc(386) boolean local386 = false;
		if (Static122.aClass19_16.method4261() && Static323.aClass50_Sub1_1.aBoolean294) {
			for (local266 = 0; local266 < Static386.aByteArrayArray15.length; local266++) {
				if (Static193.aByteArrayArray13[local266] != null || Static435.aByteArrayArray30[local266] != null) {
					local386 = true;
					break;
				}
			}
		}
		if (Static323.aClass50_Sub1_1.aBoolean298) {
			local266 = Static149.anIntArray189[Static140.anInt2845];
		} else {
			local266 = Static164.anIntArray302[Static140.anInt2845];
		}
		if (Static122.aClass19_16.method4286()) {
			local266++;
		}
		Static253.method3677(Static326.anInt5666, Static283.anInt5187, local266, local386, Static122.aClass19_16.method4260() > 0);
		for (local276 = 0; local276 < 4; local276++) {
			Static175.aClass213Array1[local276].method4851();
		}
		Static241.method3555();
		Static388.method5094(false);
		Static265.method3816();
		Static10.aClass242_1 = null;
		Static159.method2701();
		System.gc();
		Static299.method4087(true);
		Static261.method3788();
		Static63.anInt1262 = Static323.aClass50_Sub1_1.method2850(Static177.anInt2973);
		Static41.aBoolean75 = Static70.anInt1503 >= 96;
		Static321.aBoolean498 = Static323.aClass50_Sub1_1.aBoolean294;
		Static242.aBoolean418 = Static323.aClass50_Sub1_1.method2854(Static177.anInt2973);
		Static147.aBoolean263 = !Static323.aClass50_Sub1_1.aBoolean293;
		Static259.anInt4877 = Static323.aClass50_Sub1_1.method2861(Static177.anInt2973) ? -1 : Static317.anInt5523;
		Static436.aBoolean667 = Static323.aClass50_Sub1_1.aBoolean307;
		Static54.aBoolean93 = Static177.anInt2973 == 1 || Static323.aClass50_Sub1_1.aBoolean289;
		Static67.aClass266_Sub1_1 = new Class266_Sub1(4, Static326.anInt5666, Static283.anInt5187, false);
		if (Static448.anInt7307 == 0) {
			Static235.method3523(Static67.aClass266_Sub1_1, Static386.aByteArrayArray15);
		} else {
			Static259.method3757(Static67.aClass266_Sub1_1, Static386.aByteArrayArray15);
		}
		Static7.method4194(Static326.anInt5666 >> 4, Static283.anInt5187 >> 4);
		Static248.method3623();
		if (local386) {
			Static86.method1547(true);
			Static143.aClass266_Sub1_2 = new Class266_Sub1(1, Static326.anInt5666, Static283.anInt5187, true);
			if (Static448.anInt7307 == 0) {
				Static235.method3523(Static143.aClass266_Sub1_2, Static435.aByteArrayArray30);
				Static299.method4087(true);
			} else {
				Static259.method3757(Static143.aClass266_Sub1_2, Static435.aByteArrayArray30);
				Static299.method4087(true);
			}
			Static143.aClass266_Sub1_2.method5633(Static67.aClass266_Sub1_1.anIntArrayArrayArray15[0]);
			Static143.aClass266_Sub1_2.method5635(null, null, Static122.aClass19_16);
			Static86.method1547(false);
		}
		Static67.aClass266_Sub1_1.method5635(local386 ? Static143.aClass266_Sub1_2.anIntArrayArrayArray15 : null, Static175.aClass213Array1, Static122.aClass19_16);
		if (Static448.anInt7307 == 0) {
			Static299.method4087(true);
			Static344.method4655(Static67.aClass266_Sub1_1, Static247.aByteArrayArray16);
			if (Static34.aByteArrayArray1 != null) {
				Static194.method3044();
			}
		} else {
			Static299.method4087(true);
			Static390.method4993(Static67.aClass266_Sub1_1, Static247.aByteArrayArray16);
		}
		Static409.method5485();
		Static299.method4087(true);
		Static67.aClass266_Sub1_1.method5636(null, local386 ? Static285.aClass65Array3[0] : null, Static122.aClass19_16);
		Static67.aClass266_Sub1_1.method5651(Static122.aClass19_16);
		Static299.method4087(true);
		if (local386) {
			Static86.method1547(true);
			Static299.method4087(true);
			if (Static448.anInt7307 == 0) {
				Static344.method4655(Static143.aClass266_Sub1_2, Static193.aByteArrayArray13);
			} else {
				Static390.method4993(Static143.aClass266_Sub1_2, Static193.aByteArrayArray13);
			}
			Static409.method5485();
			Static299.method4087(true);
			Static143.aClass266_Sub1_2.method5636(Static67.aClass65Array1[0], null, Static122.aClass19_16);
			Static143.aClass266_Sub1_2.method5651(Static122.aClass19_16);
			Static299.method4087(true);
			Static86.method1547(false);
		}
		Static270.method3866();
		@Pc(729) int local729 = Static67.aClass266_Sub1_1.anInt7311;
		if (local729 > Static263.anInt4963) {
			local729 = Static263.anInt4963;
		}
		if (Static263.anInt4963 - 1 > local729) {
			local729 = Static263.anInt4963 - 1;
		}
		if (Static323.aClass50_Sub1_1.method2861(Static177.anInt2973)) {
			method882(0);
		} else {
			method882(local729);
		}
		@Pc(766) int local766;
		@Pc(770) int local770;
		for (@Pc(762) int local762 = 0; local762 < 4; local762++) {
			for (local766 = 0; local766 < Static326.anInt5666; local766++) {
				for (local770 = 0; local770 < Static283.anInt5187; local770++) {
					Static443.method5595(local762, local766, local770);
				}
			}
		}
		Static215.method3238();
		Static159.method2701();
		Static1.method1();
		Static409.method5485();
		Static199.aBoolean362 = false;
		Static317.method4231();
		if (GameShell.frame != null && Static125.aServerConnection_5 != null && Static403.anInt6667 == 25) {
			Static429.method5476(Static427.aClass215_94);
			Static3.aClass4_Sub12_Sub1_5.p4(1057001181);
		}
		if (Static448.anInt7307 == 0) {
			local766 = (Static169.anInt3265 - (Static326.anInt5666 >> 4)) / 8;
			local770 = (Static169.anInt3265 + (Static326.anInt5666 >> 4)) / 8;
			@Pc(856) int local856 = (Static453.anInt7373 - (Static283.anInt5187 >> 4)) / 8;
			@Pc(864) int local864 = (Static453.anInt7373 + (Static283.anInt5187 >> 4)) / 8;
			for (@Pc(868) int local868 = local766 - 1; local868 <= local770 + 1; local868++) {
				for (@Pc(874) int local874 = local856 - 1; local874 <= local864 + 1; local874++) {
					if (local766 > local868 || local770 < local868 || local874 < local856 || local864 < local874) {
						Static49.aClass76_27.method2126("m" + local868 + "_" + local874);
						Static49.aClass76_27.method2126("l" + local868 + "_" + local874);
					}
				}
			}
		}
		if (Static403.anInt6667 == 28) {
			Static187.method2932(10);
		} else {
			Static187.method2932(30);
			if (Static125.aServerConnection_5 != null) {
				Static429.method5476(Static412.aClass215_90);
			}
		}
		Static126.method2262();
		Static159.method2701();
		GameShell.method3660();
	}

	@OriginalMember(owner = "client!tn", name = "a", descriptor = "(Z)V")
	public static void method5090() {
		if (Static354.anInt6183 == 0) {
			return;
		}
		try {
			if (++Static348.anInt5976 > 2000) {
				if (Static125.aServerConnection_5 != null) {
					Static125.aServerConnection_5.shutdown();
					Static125.aServerConnection_5 = null;
				}
				if (Static119.anInt2524 >= 1) {
					Static354.anInt6183 = 0;
					Static249.anInt4623 = -5;
					return;
				}
				Static354.anInt6183 = 1;
				Static348.anInt5976 = 0;
				if (primaryServerPort == port) {
					port = fallbackServerPort;
				} else {
					port = primaryServerPort;
				}
				Static119.anInt2524++;
			}
			if (Static354.anInt6183 == 1) {
				Static36.aClass199_3 = GameShell.signLink.emitConnectionInitializationMessage(host, port);
				Static354.anInt6183 = 2;
			}
			@Pc(120) int local120;
			if (Static354.anInt6183 == 2) {
				if (Static36.aClass199_3.status == 2) {
					throw new IOException();
				}
				if (Static36.aClass199_3.status != 1) {
					return;
				}
				Static125.aServerConnection_5 = new ServerConnection((Socket) Static36.aClass199_3.output, GameShell.signLink);
				Static36.aClass199_3 = null;
				Static125.aServerConnection_5.write(Static3.aClass4_Sub12_Sub1_5.pos, Static3.aClass4_Sub12_Sub1_5.data);
				Static329.method4427();
				local120 = Static125.aServerConnection_5.readByteFromServer();
				Static329.method4427();
				if (local120 != 21) {
					Static249.anInt4623 = local120;
					Static354.anInt6183 = 0;
					Static125.aServerConnection_5.shutdown();
					Static125.aServerConnection_5 = null;
					return;
				}
				Static354.anInt6183 = 3;
			}
			if (Static354.anInt6183 == 3) {
				if (Static125.aServerConnection_5.getEstimatedBytesAvailable() < 1) {
					return;
				}
				Static206.aStringArray16 = new String[Static125.aServerConnection_5.readByteFromServer()];
				Static354.anInt6183 = 4;
			}
			if (Static354.anInt6183 == 4 && Static125.aServerConnection_5.getEstimatedBytesAvailable() >= Static206.aStringArray16.length * 8) {
				Static146.aClass4_Sub12_Sub1_3.pos = 0;
				Static125.aServerConnection_5.readBytesFromServer(0, Static206.aStringArray16.length * 8, Static146.aClass4_Sub12_Sub1_3.data);
				for (local120 = 0; local120 < Static206.aStringArray16.length; local120++) {
					Static206.aStringArray16[local120] = Static44.method763(Static146.aClass4_Sub12_Sub1_3.g8());
				}
				Static249.anInt4623 = 21;
				Static354.anInt6183 = 0;
				Static125.aServerConnection_5.shutdown();
				Static125.aServerConnection_5 = null;
			}
		} catch (@Pc(214) IOException local214) {
			if (Static125.aServerConnection_5 != null) {
				Static125.aServerConnection_5.shutdown();
				Static125.aServerConnection_5 = null;
			}
			if (Static119.anInt2524 >= 1) {
				Static354.anInt6183 = 0;
				Static249.anInt4623 = -4;
			} else {
				Static354.anInt6183 = 1;
				if (port == primaryServerPort) {
					port = fallbackServerPort;
				} else {
					port = primaryServerPort;
				}
				Static119.anInt2524++;
				Static348.anInt5976 = 0;
			}
		}
	}

	@OriginalMember(owner = "client!kj", name = "b", descriptor = "(Z)Z")
	public static boolean method4188() {
		try {
			return method2816();
		} catch (@Pc(14) IOException local14) {
			Static165.method2731();
			return true;
		} catch (@Pc(19) Exception local19) {
			@Pc(77) String local77 = "T2 - " + (Static300.aClass22_246 == null ? -1 : Static300.aClass22_246.method527()) + "," + (Static380.aClass22_294 == null ? -1 : Static380.aClass22_294.method527()) + "," + (Static316.aClass22_257 == null ? -1 : Static316.aClass22_257.method527()) + " - " + Static454.anInt4075 + "," + (Static1.aClass16_Sub1_Sub5_Sub1_1.anIntArray426[0] + Static180.anInt3453) + "," + (Static86.anInt1771 + Static1.aClass16_Sub1_Sub5_Sub1_1.anIntArray427[0]) + " - ";
			for (@Pc(79) int local79 = 0; local79 < Static454.anInt4075 && local79 < 50; local79++) {
				local77 = local77 + Static146.aClass4_Sub12_Sub1_3.data[local79] + ",";
			}
			Static94.handleClientError(local19, local77);
			Static251.method3639();
			return true;
		}
	}

	@OriginalMember(owner = "client!is", name = "a", descriptor = "(I)Z")
	public static boolean method2816() throws IOException {
		if (Static125.aServerConnection_5 == null) {
			return false;
		}
		@Pc(13) int local13 = Static125.aServerConnection_5.getEstimatedBytesAvailable();
		if (local13 == 0) {
			return false;
		}
		@Pc(70) int local70;
		if (Static300.aClass22_246 == null) {
			if (Static330.aBoolean513) {
				Static125.aServerConnection_5.readBytesFromServer(0, 1, Static146.aClass4_Sub12_Sub1_3.data);
				local13--;
				Static330.aBoolean513 = false;
				Static138.anInt2826++;
			}
			Static146.aClass4_Sub12_Sub1_3.pos = 0;
			if (Static146.aClass4_Sub12_Sub1_3.method1141()) {
				if (local13 == 0) {
					return false;
				}
				local13--;
				Static125.aServerConnection_5.readBytesFromServer(1, 1, Static146.aClass4_Sub12_Sub1_3.data);
				Static138.anInt2826++;
			}
			Static330.aBoolean513 = true;
			@Pc(66) Class22[] local66 = Static149.method2553();
			local70 = Static146.aClass4_Sub12_Sub1_3.method1140();
			if (local70 < 0 || local70 >= local66.length) {
				throw new IOException("invo:" + local70 + " ip:" + Static146.aClass4_Sub12_Sub1_3.pos);
			}
			Static300.aClass22_246 = local66[local70];
			Static454.anInt4075 = Static300.aClass22_246.anInt468;
		}
		if (Static454.anInt4075 == -1) {
			if (local13 <= 0) {
				return false;
			}
			Static125.aServerConnection_5.readBytesFromServer(0, 1, Static146.aClass4_Sub12_Sub1_3.data);
			local13--;
			Static138.anInt2826++;
			Static454.anInt4075 = Static146.aClass4_Sub12_Sub1_3.data[0] & 0xFF;
		}
		if (Static454.anInt4075 == -2) {
			if (local13 <= 1) {
				return false;
			}
			Static125.aServerConnection_5.readBytesFromServer(0, 2, Static146.aClass4_Sub12_Sub1_3.data);
			Static146.aClass4_Sub12_Sub1_3.pos = 0;
			local13 -= 2;
			Static454.anInt4075 = Static146.aClass4_Sub12_Sub1_3.g2();
			Static138.anInt2826 += 2;
		}
		if (local13 < Static454.anInt4075) {
			return false;
		}
		Static146.aClass4_Sub12_Sub1_3.pos = 0;
		Static125.aServerConnection_5.readBytesFromServer(0, Static454.anInt4075, Static146.aClass4_Sub12_Sub1_3.data);
		Static316.aClass22_257 = Static380.aClass22_294;
		Static138.anInt2826 += Static454.anInt4075;
		Static410.anInt6735 = 0;
		Static380.aClass22_294 = Static35.aClass22_42;
		Static35.aClass22_42 = Static300.aClass22_246;
		if (Static48.aClass22_53 == Static300.aClass22_246) {
			method2572(Static435.aClass21_17);
			Static300.aClass22_246 = null;
			return true;
		}
		@Pc(212) String local212;
		@Pc(206) boolean local206;
		@Pc(210) String local210;
		@Pc(224) int local224;
		@Pc(228) int local228;
		@Pc(251) String local251;
		@Pc(230) boolean local230;
		if (Static300.aClass22_246 == Static143.aClass22_125) {
			local206 = Static146.aClass4_Sub12_Sub1_3.g1() == 1;
			local210 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
			local212 = local210;
			if (local206) {
				local212 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
			}
			local224 = Static146.aClass4_Sub12_Sub1_3.g1();
			local228 = Static146.aClass4_Sub12_Sub1_3.g2();
			local230 = false;
			if (local224 <= 1 && Static239.method3549(local212)) {
				local230 = true;
			}
			if (!local230 && Static65.anInt1373 == 0) {
				local251 = Static445.aClass81_2.method2258(local228).method234(Static146.aClass4_Sub12_Sub1_3);
				if (local224 == 2) {
					Static426.method5438(local228, "<img=1>" + local212, local251, null, 0, "<img=1>" + local210, 25);
				} else if (local224 == 1) {
					Static426.method5438(local228, "<img=0>" + local212, local251, null, 0, "<img=0>" + local210, 25);
				} else {
					Static426.method5438(local228, local212, local251, null, 0, local210, 25);
				}
			}
			Static300.aClass22_246 = null;
			return true;
		}
		@Pc(327) int local327;
		@Pc(335) int local335;
		if (Static300.aClass22_246 == Static7.aClass22_254) {
			local327 = Static146.aClass4_Sub12_Sub1_3.g4_alt2();
			local70 = Static146.aClass4_Sub12_Sub1_3.g2();
			local335 = Static146.aClass4_Sub12_Sub1_3.g2();
			if (Static326.method4415(local70)) {
				Static243.method3562(local327, local335);
			}
			Static300.aClass22_246 = null;
			return true;
		} else if (Static300.aClass22_246 == Static223.aClass22_191) {
			local327 = Static146.aClass4_Sub12_Sub1_3.g2();
			local210 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
			@Pc(366) Object[] local366 = new Object[local210.length() + 1];
			for (local224 = local210.length() - 1; local224 >= 0; local224--) {
				if (local210.charAt(local224) == 's') {
					local366[local224 + 1] = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
				} else {
					local366[local224 + 1] = Integer.valueOf(Static146.aClass4_Sub12_Sub1_3.g4());
				}
			}
			local366[0] = Integer.valueOf(Static146.aClass4_Sub12_Sub1_3.g4());
			if (Static326.method4415(local327)) {
				@Pc(421) Node_Sub34 local421 = new Node_Sub34();
				local421.anObjectArray4 = local366;
				Static271.method3894(local421);
			}
			Static300.aClass22_246 = null;
			return true;
		} else if (Static296.aClass22_241 == Static300.aClass22_246) {
			method2572(Static309.aClass21_13);
			Static300.aClass22_246 = null;
			return true;
		} else if (Static195.aClass22_167 == Static300.aClass22_246) {
			Static230.method3470();
			Static300.aClass22_246 = null;
			return false;
		} else if (Static352.aClass22_282 == Static300.aClass22_246) {
			local327 = Static146.aClass4_Sub12_Sub1_3.g1_alt1();
			local70 = Static146.aClass4_Sub12_Sub1_3.g1();
			local335 = Static146.aClass4_Sub12_Sub1_3.g2_alt2();
			if (local335 == 65535) {
				local335 = -1;
			}
			Static427.method5456(local335, local70, local327);
			Static300.aClass22_246 = null;
			return true;
		} else if (Static239.aClass22_203 == Static300.aClass22_246) {
			local327 = Static146.aClass4_Sub12_Sub1_3.g3();
			local70 = Static146.aClass4_Sub12_Sub1_3.g2_alt3();
			if (local70 == 65535) {
				local70 = -1;
			}
			local335 = Static146.aClass4_Sub12_Sub1_3.g1();
			Static411.method5274(local335, local327, local70);
			Static300.aClass22_246 = null;
			return true;
		} else {
			@Pc(535) String local535;
			if (Static300.aClass22_246 == Static352.aClass22_281) {
				local327 = Static146.aClass4_Sub12_Sub1_3.g1_alt3();
				local70 = Static146.aClass4_Sub12_Sub1_3.g1_alt2();
				local335 = Static146.aClass4_Sub12_Sub1_3.g2_alt2();
				if (local335 == 65535) {
					local335 = -1;
				}
				local535 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
				if (local327 >= 1 && local327 <= 8) {
					if (local535.equalsIgnoreCase("null")) {
						local535 = null;
					}
					Static349.aStringArray29[local327 - 1] = local535;
					Static272.anIntArray333[local327 - 1] = local335;
					Static217.aBooleanArray13[local327 - 1] = local70 == 0;
				}
				Static300.aClass22_246 = null;
				return true;
			} else if (Static424.aClass22_319 == Static300.aClass22_246) {
				local327 = Static146.aClass4_Sub12_Sub1_3.g1();
				local70 = local327 >> 5;
				local335 = local327 & 0x1F;
				if (local335 == 0) {
					Static306.aClass38Array1[local70] = null;
					Static300.aClass22_246 = null;
					return true;
				}
				@Pc(610) Class38 local610 = new Class38();
				local610.anInt891 = local335;
				local610.anInt886 = Static146.aClass4_Sub12_Sub1_3.g1();
				if (local610.anInt886 >= 0 && local610.anInt886 < Static59.aClass57Array3.length) {
					if (local610.anInt891 == 1 || local610.anInt891 == 10) {
						local610.anInt885 = Static146.aClass4_Sub12_Sub1_3.g2();
						Static146.aClass4_Sub12_Sub1_3.pos += 6;
					} else if (local610.anInt891 >= 2 && local610.anInt891 <= 6) {
						if (local610.anInt891 == 2) {
							local610.anInt894 = 64;
							local610.anInt892 = 64;
						}
						if (local610.anInt891 == 3) {
							local610.anInt894 = 64;
							local610.anInt892 = 0;
						}
						if (local610.anInt891 == 4) {
							local610.anInt894 = 64;
							local610.anInt892 = 128;
						}
						if (local610.anInt891 == 5) {
							local610.anInt894 = 0;
							local610.anInt892 = 64;
						}
						if (local610.anInt891 == 6) {
							local610.anInt894 = 128;
							local610.anInt892 = 64;
						}
						local610.anInt891 = 2;
						local610.anInt887 = Static146.aClass4_Sub12_Sub1_3.g1();
						local610.anInt892 += Static146.aClass4_Sub12_Sub1_3.g2() - Static180.anInt3453 << 7;
						local610.anInt894 += Static146.aClass4_Sub12_Sub1_3.g2() - Static86.anInt1771 << 7;
						local610.anInt895 = Static146.aClass4_Sub12_Sub1_3.g1();
						local610.anInt889 = Static146.aClass4_Sub12_Sub1_3.g2();
					}
					local610.anInt888 = Static146.aClass4_Sub12_Sub1_3.g2();
					if (local610.anInt888 == 65535) {
						local610.anInt888 = -1;
					}
					Static306.aClass38Array1[local70] = local610;
				}
				Static300.aClass22_246 = null;
				return true;
			} else if (Static300.aClass22_246 == Static75.aClass22_73) {
				local327 = Static146.aClass4_Sub12_Sub1_3.g2();
				local70 = Static146.aClass4_Sub12_Sub1_3.g2_alt1();
				local335 = Static146.aClass4_Sub12_Sub1_3.g2_alt2();
				if (Static326.method4415(local327)) {
					Static227.method3451(local335, local70);
				}
				Static300.aClass22_246 = null;
				return true;
			} else {
				@Pc(813) String local813;
				if (Static300.aClass22_246 == Static41.aClass22_45) {
					local813 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
					local70 = Static146.aClass4_Sub12_Sub1_3.g2();
					local212 = Static445.aClass81_2.method2258(local70).method234(Static146.aClass4_Sub12_Sub1_3);
					Static426.method5438(local70, local813, local212, null, 0, local813, 19);
					Static300.aClass22_246 = null;
					return true;
				} else if (Static278.aClass22_232 == Static300.aClass22_246) {
					local327 = Static146.aClass4_Sub12_Sub1_3.g2_alt2();
					local70 = Static146.aClass4_Sub12_Sub1_3.g2_alt1();
					local335 = Static146.aClass4_Sub12_Sub1_3.g4_alt1();
					if (Static326.method4415(local327)) {
						Static316.method4221(local70, local335);
					}
					Static300.aClass22_246 = null;
					return true;
				} else if (Static300.aClass22_246 == Static434.aClass22_336) {
					Static14.anInt189 = Static146.aClass4_Sub12_Sub1_3.g1_alt1();
					Static412.anInt6765 = Static146.aClass4_Sub12_Sub1_3.g1_alt2();
					Static300.aClass22_246 = null;
					return true;
				} else if (Static300.aClass22_246 == Static324.aClass22_261) {
					if (Static334.anInt5766 != -1) {
						Static310.method4165(Static334.anInt5766, 0);
					}
					Static300.aClass22_246 = null;
					return true;
				} else if (Static331.aClass22_268 == Static300.aClass22_246) {
					local327 = Static146.aClass4_Sub12_Sub1_3.g2_alt3();
					local70 = Static146.aClass4_Sub12_Sub1_3.g4_alt1();
					Static257.aClass114_1.method2828(local70, local327);
					Static300.aClass22_246 = null;
					return true;
				} else if (Static49.aClass22_98 == Static300.aClass22_246) {
					Static251.method3639();
					Static300.aClass22_246 = null;
					return false;
				} else if (Static261.aClass22_218 == Static300.aClass22_246) {
					local327 = Static146.aClass4_Sub12_Sub1_3.g1();
					local70 = Static146.aClass4_Sub12_Sub1_3.g1_alt2();
					if (local327 == 255) {
						local70 = -1;
						local327 = -1;
					}
					Static442.method5573(local327, local70);
					Static300.aClass22_246 = null;
					return true;
				} else if (Static300.aClass22_246 == Static376.aClass22_286) {
					local327 = Static146.aClass4_Sub12_Sub1_3.g4_alt1();
					local70 = Static146.aClass4_Sub12_Sub1_3.g1_alt1();
					local335 = Static146.aClass4_Sub12_Sub1_3.g1_alt3();
					Static160.anIntArray207[local70] = local327;
					Static395.anIntArray502[local70] = local335;
					Static198.anIntArray258[local70] = 1;
					local224 = Static117.anIntArray167[local70] - 1;
					for (local228 = 0; local228 < local224; local228++) {
						if (local327 >= Class126.anIntArray260[local228]) {
							Static198.anIntArray258[local70] = local228 + 2;
						}
					}
					Static39.anIntArray40[Static346.anInt5948++ & 0x1F] = local70;
					Static300.aClass22_246 = null;
					return true;
				} else if (Static300.aClass22_246 == Static135.aClass22_120) {
					local327 = Static146.aClass4_Sub12_Sub1_3.g4_alt3();
					local70 = Static146.aClass4_Sub12_Sub1_3.g2();
					if (Static326.method4415(local70)) {
						Static54.method914(3, local327, -1, -1);
					}
					Static300.aClass22_246 = null;
					return true;
				} else if (Static300.aClass22_246 == Static254.aClass22_209) {
					local327 = Static146.aClass4_Sub12_Sub1_3.g1();
					local70 = Static146.aClass4_Sub12_Sub1_3.g2_alt1();
					local335 = Static146.aClass4_Sub12_Sub1_3.g2_alt1();
					if (Static326.method4415(local70)) {
						if (local327 == 2) {
							Static436.method5520();
						}
						Static334.anInt5766 = local335;
						Static426.method5439(local335);
						Static327.method4422(false);
						Static271.method3897(Static334.anInt5766);
						for (local224 = 0; local224 < 100; local224++) {
							Static416.aBooleanArray21[local224] = true;
						}
					}
					Static300.aClass22_246 = null;
					return true;
				} else if (Static119.aClass22_106 == Static300.aClass22_246) {
					local327 = Static146.aClass4_Sub12_Sub1_3.g4_alt2();
					local70 = Static146.aClass4_Sub12_Sub1_3.g4();
					local335 = Static146.aClass4_Sub12_Sub1_3.g2();
					local224 = Static146.aClass4_Sub12_Sub1_3.g2_alt2();
					if (Static326.method4415(local335)) {
						Static54.method914(5, local327, local224, local70);
					}
					Static300.aClass22_246 = null;
					return true;
				} else {
					@Pc(1190) int local1190;
					if (Static401.aClass22_302 == Static300.aClass22_246) {
						local327 = Static146.aClass4_Sub12_Sub1_3.g2();
						local70 = Static146.aClass4_Sub12_Sub1_3.g2();
						local335 = Static146.aClass4_Sub12_Sub1_3.g2();
						local224 = Static146.aClass4_Sub12_Sub1_3.g2();
						if (Static326.method4415(local327) && Static297.aClass247ArrayArray2[local70] != null) {
							for (local228 = local335; local228 < local224; local228++) {
								local1190 = Static146.aClass4_Sub12_Sub1_3.g3();
								if (local228 < Static297.aClass247ArrayArray2[local70].length && Static297.aClass247ArrayArray2[local70][local228] != null) {
									Static297.aClass247ArrayArray2[local70][local228].anInt6819 = local1190;
								}
							}
						}
						Static300.aClass22_246 = null;
						return true;
					}
					@Pc(1252) long local1252;
					@Pc(1257) long local1257;
					@Pc(1267) int local1267;
					@Pc(1263) int local1263;
					@Pc(1277) int local1277;
					if (Static300.aClass22_246 == Static26.aClass22_32) {
						local206 = Static146.aClass4_Sub12_Sub1_3.g1() == 1;
						local210 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
						local212 = local210;
						if (local206) {
							local212 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
						}
						local1252 = Static146.aClass4_Sub12_Sub1_3.g2();
						local1257 = Static146.aClass4_Sub12_Sub1_3.g3();
						local1263 = Static146.aClass4_Sub12_Sub1_3.g1();
						local1267 = Static146.aClass4_Sub12_Sub1_3.g2();
						@Pc(1273) long local1273 = local1257 + (local1252 << 32);
						@Pc(1275) boolean local1275 = false;
						local1277 = 0;
						while (true) {
							if (local1277 >= 100) {
								if (local1263 <= 1 && Static239.method3549(local212)) {
									local1275 = true;
								}
								break;
							}
							if (Static270.aLongArray7[local1277] == local1273) {
								local1275 = true;
								break;
							}
							local1277++;
						}
						if (!local1275 && Static65.anInt1373 == 0) {
							Static270.aLongArray7[Static407.anInt6719] = local1273;
							Static407.anInt6719 = (Static407.anInt6719 + 1) % 100;
							@Pc(1324) String local1324 = Static445.aClass81_2.method2258(local1267).method234(Static146.aClass4_Sub12_Sub1_3);
							if (local1263 == 2) {
								Static426.method5438(local1267, "<img=1>" + local212, local1324, null, 0, "<img=1>" + local210, 18);
							} else if (local1263 == 1) {
								Static426.method5438(local1267, "<img=0>" + local212, local1324, null, 0, "<img=0>" + local210, 18);
							} else {
								Static426.method5438(local1267, local212, local1324, null, 0, local210, 18);
							}
						}
						Static300.aClass22_246 = null;
						return true;
					}
					@Pc(1411) boolean local1411;
					if (Static300.aClass22_246 == Static115.aClass22_102) {
						local327 = Static146.aClass4_Sub12_Sub1_3.g2();
						local70 = Static146.aClass4_Sub12_Sub1_3.g1();
						local1411 = (local70 & 0x1) == 1;
						while (Static454.anInt4075 > Static146.aClass4_Sub12_Sub1_3.pos) {
							local224 = Static146.aClass4_Sub12_Sub1_3.gSmart1Or2();
							local228 = Static146.aClass4_Sub12_Sub1_3.g2();
							local1190 = 0;
							if (local228 != 0) {
								local1190 = Static146.aClass4_Sub12_Sub1_3.g1();
								if (local1190 == 255) {
									local1190 = Static146.aClass4_Sub12_Sub1_3.g4();
								}
							}
							Static153.method2603(local224, local228 - 1, local327, local1190, local1411);
						}
						Static393.anIntArray500[Static140.anInt2841++ & 0x1F] = local327;
						Static300.aClass22_246 = null;
						return true;
					} else if (Static187.aClass22_159 == Static300.aClass22_246) {
						if (GameShell.fullScreenFrame != null) {
							Static188.method4107(Static323.aClass50_Sub1_1.anInt3447, -1, -1, false);
						}
						@Pc(1483) byte[] local1483 = new byte[Static454.anInt4075];
						Static146.aClass4_Sub12_Sub1_3.method1132(Static454.anInt4075, local1483);
						local210 = CP1252StringTools.CP1252ToUTF8(local1483, Static454.anInt4075, 0);
						Static275.method3929(GameShell.signLink, local210, Static177.anInt2973 == 1, true);
						Static300.aClass22_246 = null;
						return true;
					} else if (Static300.aClass22_246 == Static329.aClass22_264) {
						method2572(Static133.aClass21_8);
						Static300.aClass22_246 = null;
						return true;
					} else if (Static300.aClass22_246 == Static189.aClass22_160) {
						local327 = Static146.aClass4_Sub12_Sub1_3.g4_alt2();
						local70 = Static146.aClass4_Sub12_Sub1_3.g2_alt1();
						Static257.aClass114_1.method2830(local70, local327);
						Static300.aClass22_246 = null;
						return true;
					} else {
						@Pc(1576) Node_Sub43 local1576;
						if (Static302.aClass22_247 == Static300.aClass22_246) {
							local327 = Static146.aClass4_Sub12_Sub1_3.g1_alt3();
							local70 = Static146.aClass4_Sub12_Sub1_3.g2_alt2();
							local335 = Static146.aClass4_Sub12_Sub1_3.g4();
							local224 = Static146.aClass4_Sub12_Sub1_3.g2_alt1();
							if (Static326.method4415(local70)) {
								local1576 = (Node_Sub43) Static325.aHashMap_29.get((long) local335);
								if (local1576 != null) {
									Static90.method1606(local224 != local1576.anInt6979, local1576, false);
								}
								Static300.method4092(local224, local327, false, local335);
							}
							Static300.aClass22_246 = null;
							return true;
						} else if (Static311.aClass22_252 == Static300.aClass22_246) {
							method2572(Static146.aClass21_2);
							Static300.aClass22_246 = null;
							return true;
						} else if (Static265.aClass22_223 == Static300.aClass22_246) {
							local327 = Static146.aClass4_Sub12_Sub1_3.g2_alt2();
							local70 = Static146.aClass4_Sub12_Sub1_3.g2s_alt2();
							local335 = Static146.aClass4_Sub12_Sub1_3.g4_alt3();
							if (Static326.method4415(local327)) {
								Static112.method2033(local70, local335);
							}
							Static300.aClass22_246 = null;
							return true;
						} else if (Static431.aClass22_324 == Static300.aClass22_246) {
							local327 = Static146.aClass4_Sub12_Sub1_3.g2();
							local70 = Static146.aClass4_Sub12_Sub1_3.g1_alt3();
							local1411 = (local70 & 0x1) == 1;
							Static150.method2573(local327, local1411);
							Static393.anIntArray500[Static140.anInt2841++ & 0x1F] = local327;
							Static300.aClass22_246 = null;
							return true;
						} else {
							@Pc(1747) String local1747;
							if (Static422.aClass22_312 == Static300.aClass22_246) {
								local206 = Static146.aClass4_Sub12_Sub1_3.g1() == 1;
								local210 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
								local212 = local210;
								if (local206) {
									local212 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
								}
								local224 = Static146.aClass4_Sub12_Sub1_3.g1();
								@Pc(1713) boolean local1713 = false;
								if (local224 <= 1) {
									if (Static109.aBoolean628 && !Static396.aBoolean443 || Static308.aBoolean486) {
										local1713 = true;
									} else if (local224 <= 1 && Static239.method3549(local212)) {
										local1713 = true;
									}
								}
								if (!local1713 && Static65.anInt1373 == 0) {
									local1747 = Static22.method297(Static261.method3776(Static146.aClass4_Sub12_Sub1_3));
									if (local224 == 2) {
										Static426.method5438(-1, "<img=1>" + local212, local1747, null, 0, "<img=1>" + local210, 24);
									} else if (local224 == 1) {
										Static426.method5438(-1, "<img=0>" + local212, local1747, null, 0, "<img=0>" + local210, 24);
									} else {
										Static426.method5438(-1, local212, local1747, null, 0, local210, 24);
									}
								}
								Static300.aClass22_246 = null;
								return true;
							} else if (Static300.aClass22_246 == Static245.aClass22_205) {
								method2572(Static183.aClass21_12);
								Static300.aClass22_246 = null;
								return true;
							} else {
								@Pc(2080) String local2080;
								@Pc(1858) boolean local1858;
								@Pc(2152) boolean local2152;
								if (Static233.aClass22_195 == Static300.aClass22_246) {
									while (Static146.aClass4_Sub12_Sub1_3.pos < Static454.anInt4075) {
										local206 = Static146.aClass4_Sub12_Sub1_3.g1() == 1;
										local210 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
										local212 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
										local224 = Static146.aClass4_Sub12_Sub1_3.g2();
										local228 = Static146.aClass4_Sub12_Sub1_3.g1();
										local1747 = "";
										local1858 = false;
										if (local224 > 0) {
											local1747 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
											local1858 = Static146.aClass4_Sub12_Sub1_3.g1() == 1;
										}
										for (local1263 = 0; local1263 < Static49.anInt2346; local1263++) {
											if (local206) {
												if (local212.equals(Static194.aStringArray14[local1263])) {
													Static194.aStringArray14[local1263] = local210;
													local210 = null;
													Static57.aStringArray6[local1263] = local212;
													break;
												}
											} else if (local210.equals(Static194.aStringArray14[local1263])) {
												if (Static71.anIntArray536[local1263] != local224) {
													Static71.anIntArray536[local1263] = local224;
													if (local224 > 0) {
														Static128.method2268(0, 5, local210 + Static138.A_LOCALIZED_STRING___54.getLocalizedString(ClientSettings.langID), "", "");
													}
													if (local224 == 0) {
														Static128.method2268(0, 5, local210 + Static371.A_LOCALIZED_STRING___125.getLocalizedString(ClientSettings.langID), "", "");
													}
												}
												Static57.aStringArray6[local1263] = local212;
												Static433.aStringArray38[local1263] = local1747;
												Static280.anIntArray339[local1263] = local228;
												local210 = null;
												Static424.aBooleanArray23[local1263] = local1858;
												break;
											}
										}
										if (local210 != null && Static49.anInt2346 < 200) {
											Static194.aStringArray14[Static49.anInt2346] = local210;
											Static57.aStringArray6[Static49.anInt2346] = local212;
											Static71.anIntArray536[Static49.anInt2346] = local224;
											Static433.aStringArray38[Static49.anInt2346] = local1747;
											Static280.anIntArray339[Static49.anInt2346] = local228;
											Static424.aBooleanArray23[Static49.anInt2346] = local1858;
											Static49.anInt2346++;
										}
									}
									Static376.anInt6277 = 2;
									Static244.anInt3027 = Static325.anInt5640;
									local70 = Static49.anInt2346;
									while (local70 > 0) {
										local70--;
										local206 = true;
										for (local335 = 0; local335 < local70; local335++) {
											if (Static71.anIntArray536[local335] != Static56.anInt1028 && Static56.anInt1028 == Static71.anIntArray536[local335 + 1] || Static71.anIntArray536[local335] == 0 && Static71.anIntArray536[local335 + 1] != 0) {
												local224 = Static71.anIntArray536[local335];
												Static71.anIntArray536[local335] = Static71.anIntArray536[local335 + 1];
												Static71.anIntArray536[local335 + 1] = local224;
												local2080 = Static433.aStringArray38[local335];
												Static433.aStringArray38[local335] = Static433.aStringArray38[local335 + 1];
												Static433.aStringArray38[local335 + 1] = local2080;
												local1747 = Static194.aStringArray14[local335];
												Static194.aStringArray14[local335] = Static194.aStringArray14[local335 + 1];
												Static194.aStringArray14[local335 + 1] = local1747;
												local251 = Static57.aStringArray6[local335];
												Static57.aStringArray6[local335] = Static57.aStringArray6[local335 + 1];
												Static57.aStringArray6[local335 + 1] = local251;
												local1263 = Static280.anIntArray339[local335];
												Static280.anIntArray339[local335] = Static280.anIntArray339[local335 + 1];
												Static280.anIntArray339[local335 + 1] = local1263;
												local2152 = Static424.aBooleanArray23[local335];
												Static424.aBooleanArray23[local335] = Static424.aBooleanArray23[local335 + 1];
												Static424.aBooleanArray23[local335 + 1] = local2152;
												local206 = false;
											}
										}
										if (local206) {
											break;
										}
									}
									Static300.aClass22_246 = null;
									return true;
								} else if (Static300.aClass22_246 == Static423.aClass22_317) {
									local327 = Static146.aClass4_Sub12_Sub1_3.g2_alt1();
									if (local327 == 65535) {
										local327 = -1;
									}
									local70 = Static146.aClass4_Sub12_Sub1_3.g4();
									local335 = Static146.aClass4_Sub12_Sub1_3.g2_alt2();
									if (Static326.method4415(local335)) {
										Static79.method1399(local327, local70);
									}
									Static300.aClass22_246 = null;
									return true;
								} else if (Static236.aClass22_200 == Static300.aClass22_246) {
									Static189.method2942(Static146.aClass4_Sub12_Sub1_3, Static454.anInt4075);
									Static300.aClass22_246 = null;
									return true;
								} else if (Static300.aClass22_246 == Static12.aClass22_17) {
									local327 = Static146.aClass4_Sub12_Sub1_3.g2();
									local70 = Static146.aClass4_Sub12_Sub1_3.g1();
									Static257.aClass114_1.method2828(local70, local327);
									Static300.aClass22_246 = null;
									return true;
								} else {
									@Pc(2311) long local2311;
									@Pc(2329) Node_Sub33 local2329;
									@Pc(2317) Node_Sub33 local2317;
									if (Static421.aClass22_311 == Static300.aClass22_246) {
										local327 = Static146.aClass4_Sub12_Sub1_3.g2_alt3();
										if (local327 == 65535) {
											local327 = -1;
										}
										local70 = Static146.aClass4_Sub12_Sub1_3.g4_alt3();
										local335 = Static146.aClass4_Sub12_Sub1_3.g2();
										local224 = Static146.aClass4_Sub12_Sub1_3.g4();
										local228 = Static146.aClass4_Sub12_Sub1_3.g2_alt1();
										if (local228 == 65535) {
											local228 = -1;
										}
										if (Static326.method4415(local335)) {
											for (local1190 = local327; local1190 <= local228; local1190++) {
												local2311 = ((long) local224 << 32) + (long) local1190;
												local2317 = (Node_Sub33) Static211.A_HASH_MAP___18.get(local2311);
												if (local2317 != null) {
													local2329 = new Node_Sub33(local70, local2317.anInt5110);
													local2317.popSelf();
												} else if (local1190 == -1) {
													local2329 = new Node_Sub33(local70, Static392.method5121(local224).aClass4_Sub33_2.anInt5110);
												} else {
													local2329 = new Node_Sub33(local70, -1);
												}
												Static211.A_HASH_MAP___18.set(local2311, local2329);
											}
										}
										Static300.aClass22_246 = null;
										return true;
									} else if (Static107.aClass22_96 == Static300.aClass22_246) {
										Static154.anInt813 = Static146.aClass4_Sub12_Sub1_3.g1s_alt3() << 3;
										Static385.anInt6487 = Static146.aClass4_Sub12_Sub1_3.g1s() << 3;
										Static113.anInt2426 = Static146.aClass4_Sub12_Sub1_3.g1_alt2();
										Static300.aClass22_246 = null;
										return true;
									} else if (Static406.aClass22_306 == Static300.aClass22_246) {
										Static17.anInt223 = Static146.aClass4_Sub12_Sub1_3.g2s();
										Static308.anInt5413 = Static325.anInt5640;
										Static300.aClass22_246 = null;
										return true;
									} else if (Static300.aClass22_246 == Static178.aClass22_152) {
										local327 = Static146.aClass4_Sub12_Sub1_3.g1_alt3();
										local70 = Static146.aClass4_Sub12_Sub1_3.g2_alt3();
										if (Static326.method4415(local70)) {
											Static268.anInt4991 = local327;
										}
										Static300.aClass22_246 = null;
										return true;
									} else {
										@Pc(2473) int local2473;
										@Pc(2494) int local2494;
										@Pc(2648) int local2648;
										@Pc(3138) int local3138;
										if (Static372.aClass22_290 == Static300.aClass22_246) {
											local327 = Static146.aClass4_Sub12_Sub1_3.g2_alt1();
											local70 = Static146.aClass4_Sub12_Sub1_3.g2_alt2();
											local335 = Static146.aClass4_Sub12_Sub1_3.g4_alt3();
											local224 = Static146.aClass4_Sub12_Sub1_3.g2_alt2();
											local228 = Static146.aClass4_Sub12_Sub1_3.g1_alt1();
											local230 = (local228 & 0x80) != 0;
											if (local335 >> 30 == 0) {
												@Pc(2515) Class161 local2515;
												@Pc(2573) Class138 local2573;
												@Pc(2520) Class161 local2520;
												@Pc(2535) Class138 local2535;
												@Pc(2541) Class138 local2541;
												if (local335 >> 29 != 0) {
													local2473 = local335 & 0xFFFF;
													@Pc(2477) Class16_Sub1_Sub5_Sub2 local2477 = Static143.aClass16_Sub1_Sub5_Sub2Array1[local2473];
													if (local2477 != null) {
														if (local70 == 65535) {
															local70 = -1;
														}
														local2152 = true;
														local2494 = local230 ? local2477.anInt6045 : local2477.anInt6029;
														if (local70 != -1 && local2494 != -1) {
															if (local70 == local2494) {
																local2515 = Static352.aClass194_2.method4421(local70);
																if (local2515.aBoolean459 && local2515.anInt5002 != -1) {
																	local2573 = Static182.aClass55_1.method1397(local2515.anInt5002);
																	local1277 = local2573.anInt4406;
																	if (local1277 == 0 || local1277 == 2) {
																		local2152 = false;
																	} else if (local1277 == 1) {
																		local2152 = true;
																	}
																}
															} else {
																local2515 = Static352.aClass194_2.method4421(local70);
																local2520 = Static352.aClass194_2.method4421(local2494);
																if (local2515.anInt5002 != -1 && local2520.anInt5002 != -1) {
																	local2535 = Static182.aClass55_1.method1397(local2515.anInt5002);
																	local2541 = Static182.aClass55_1.method1397(local2520.anInt5002);
																	if (local2541.anInt4413 > local2535.anInt4413) {
																		local2152 = false;
																	}
																}
															}
														}
														if (local2152) {
															if (local230) {
																local2477.anInt6022 = 0;
																local2477.anInt6066 = local327 + gameLogicStepCount;
																local2477.anInt6053 = local224;
																local2477.anInt6069 = 1;
																local2477.anInt6062 = 0;
																local2477.anInt6056 = local228 & 0x7;
																local2477.anInt6045 = local70;
																if (local2477.anInt6066 > gameLogicStepCount) {
																	local2477.anInt6022 = -1;
																}
																if (local2477.anInt6045 != -1 && gameLogicStepCount == local2477.anInt6066) {
																	local2648 = Static352.aClass194_2.method4421(local2477.anInt6045).anInt5002;
																	if (local2648 != -1) {
																		local2573 = Static182.aClass55_1.method1397(local2648);
																		if (local2573 != null && local2573.anIntArray295 != null) {
																			Static15.method156(local2477.anInt6893, 0, local2477.aByte82, local2477.anInt6892, local2573, false);
																		}
																	}
																}
															} else {
																local2477.anInt6014 = local224;
																local2477.anInt6027 = 0;
																local2477.anInt6083 = 1;
																local2477.anInt6029 = local70;
																local2477.anInt6017 = local228 & 0x7;
																local2477.anInt6057 = local327 + gameLogicStepCount;
																local2477.anInt6033 = 0;
																if (local2477.anInt6057 > gameLogicStepCount) {
																	local2477.anInt6027 = -1;
																}
																if (local2477.anInt6029 != -1 && gameLogicStepCount == local2477.anInt6057) {
																	local2648 = Static352.aClass194_2.method4421(local2477.anInt6029).anInt5002;
																	if (local2648 != -1) {
																		local2573 = Static182.aClass55_1.method1397(local2648);
																		if (local2573 != null && local2573.anIntArray295 != null) {
																			Static15.method156(local2477.anInt6893, 0, local2477.aByte82, local2477.anInt6892, local2573, false);
																		}
																	}
																}
															}
														}
													}
												} else if (local335 >> 28 != 0) {
													local2473 = local335 & 0xFFFF;
													@Pc(2773) Class16_Sub1_Sub5_Sub1 local2773;
													if (Static207.anInt5452 == local2473) {
														local2773 = Static1.aClass16_Sub1_Sub5_Sub1_1;
													} else {
														local2773 = Static267.aClass16_Sub1_Sub5_Sub1Array1[local2473];
													}
													if (local2773 != null) {
														if (local70 == 65535) {
															local70 = -1;
														}
														local2152 = true;
														local2494 = local230 ? local2773.anInt6045 : local2773.anInt6029;
														if (local70 != -1 && local2494 != -1) {
															if (local70 == local2494) {
																local2515 = Static352.aClass194_2.method4421(local70);
																if (local2515.aBoolean459 && local2515.anInt5002 != -1) {
																	local2573 = Static182.aClass55_1.method1397(local2515.anInt5002);
																	local1277 = local2573.anInt4406;
																	if (local1277 == 0 || local1277 == 2) {
																		local2152 = false;
																	} else if (local1277 == 1) {
																		local2152 = true;
																	}
																}
															} else {
																local2515 = Static352.aClass194_2.method4421(local70);
																local2520 = Static352.aClass194_2.method4421(local2494);
																if (local2515.anInt5002 != -1 && local2520.anInt5002 != -1) {
																	local2535 = Static182.aClass55_1.method1397(local2515.anInt5002);
																	local2541 = Static182.aClass55_1.method1397(local2520.anInt5002);
																	if (local2541.anInt4413 > local2535.anInt4413) {
																		local2152 = false;
																	}
																}
															}
														}
														if (local2152) {
															if (local230) {
																local2773.anInt6056 = local228 & 0x7;
																local2773.anInt6045 = local70;
																local2773.anInt6053 = local224;
																local2773.anInt6069 = 1;
																local2773.anInt6066 = local327 + gameLogicStepCount;
																local2773.anInt6022 = 0;
																local2773.anInt6062 = 0;
																if (local2773.anInt6045 == 65535) {
																	local2773.anInt6045 = -1;
																}
																if (local2773.anInt6066 > gameLogicStepCount) {
																	local2773.anInt6022 = -1;
																}
																if (local2773.anInt6045 != -1 && local2773.anInt6066 == gameLogicStepCount) {
																	local2648 = Static352.aClass194_2.method4421(local2773.anInt6045).anInt5002;
																	if (local2648 != -1) {
																		local2573 = Static182.aClass55_1.method1397(local2648);
																		if (local2573 != null && local2573.anIntArray295 != null) {
																			Static15.method156(local2773.anInt6893, 0, local2773.aByte82, local2773.anInt6892, local2573, local2773 == Static1.aClass16_Sub1_Sub5_Sub1_1);
																		}
																	}
																}
															} else {
																local2773.anInt6017 = local228 & 0x7;
																local2773.anInt6033 = 0;
																local2773.anInt6014 = local224;
																local2773.anInt6083 = 1;
																local2773.anInt6029 = local70;
																local2773.anInt6057 = gameLogicStepCount + local327;
																local2773.anInt6027 = 0;
																if (local2773.anInt6029 == 65535) {
																	local2773.anInt6029 = -1;
																}
																if (local2773.anInt6057 > gameLogicStepCount) {
																	local2773.anInt6027 = -1;
																}
																if (local2773.anInt6029 != -1 && local2773.anInt6057 == gameLogicStepCount) {
																	local2648 = Static352.aClass194_2.method4421(local2773.anInt6029).anInt5002;
																	if (local2648 != -1) {
																		local2573 = Static182.aClass55_1.method1397(local2648);
																		if (local2573 != null && local2573.anIntArray295 != null) {
																			Static15.method156(local2773.anInt6893, 0, local2773.aByte82, local2773.anInt6892, local2573, Static1.aClass16_Sub1_Sub5_Sub1_1 == local2773);
																		}
																	}
																}
															}
														}
													}
												}
											} else {
												local2473 = local335 >> 28 & 0x3;
												local1263 = (local335 >> 14 & 0x3FFF) - Static180.anInt3453;
												local1267 = (local335 & 0x3FFF) - Static86.anInt1771;
												if (local1263 >= 0 && local1267 >= 0 && Static326.anInt5666 > local1263 && Static283.anInt5187 > local1267) {
													local2494 = local1263 * 128 + 64;
													local2648 = local1267 * 128 + 64;
													local3138 = local2473;
													if (local2473 < 3 && Static378.method3229(local1263, local1267)) {
														local3138 = local2473 + 1;
													}
													@Pc(3173) Class16_Sub1_Sub2 local3173 = new Class16_Sub1_Sub2(local70, 0, gameLogicStepCount, local2473, local3138, local2494, Static13.method135(local2494, local2473, local2648) - local224, local2648, local1263, local1263, local1267, local1267, local228);
													Static292.aClass183_36.method4137(new SecondaryNode_Sub1_Sub10(local3173));
												}
											}
											Static300.aClass22_246 = null;
											return true;
										} else if (Static300.aClass22_246 == Static390.aClass22_292) {
											local327 = Static146.aClass4_Sub12_Sub1_3.g2();
											local70 = Static146.aClass4_Sub12_Sub1_3.g1();
											local1411 = (local70 & 0x1) == 1;
											Static171.method2796(local327, local1411);
											local224 = Static146.aClass4_Sub12_Sub1_3.g2();
											for (local228 = 0; local228 < local224; local228++) {
												local1190 = Static146.aClass4_Sub12_Sub1_3.g1_alt3();
												if (local1190 == 255) {
													local1190 = Static146.aClass4_Sub12_Sub1_3.g4_alt1();
												}
												local2473 = Static146.aClass4_Sub12_Sub1_3.g2();
												Static153.method2603(local228, local2473 - 1, local327, local1190, local1411);
											}
											Static393.anIntArray500[Static140.anInt2841++ & 0x1F] = local327;
											Static300.aClass22_246 = null;
											return true;
										} else if (Static300.aClass22_246 == Static409.aClass22_325) {
											local813 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
											local210 = Static22.method297(Static261.method3776(Static146.aClass4_Sub12_Sub1_3));
											Static128.method2268(0, 6, local210, local813, local813);
											Static300.aClass22_246 = null;
											return true;
										} else if (Static300.aClass22_246 == Static302.aClass22_248) {
											local327 = Static146.aClass4_Sub12_Sub1_3.g2_alt1();
											local70 = Static146.aClass4_Sub12_Sub1_3.g2_alt2();
											if (local70 == 65535) {
												local70 = -1;
											}
											local335 = Static146.aClass4_Sub12_Sub1_3.g4();
											local224 = Static146.aClass4_Sub12_Sub1_3.g4_alt2();
											if (Static326.method4415(local327)) {
												Static119.method2150(local224, local335, local70);
												@Pc(3326) Class211 local3326 = Static444.aClass206_3.method4703(local70);
												Static94.method1652(local224, local3326.anInt6122, local3326.anInt6133, local3326.anInt6137);
												Static67.method1274(local3326.anInt6152, local3326.lb, local224, local3326.anInt6135);
											}
											Static300.aClass22_246 = null;
											return true;
										} else if (Static300.aClass22_246 == Static184.aClass22_157) {
											local327 = Static146.aClass4_Sub12_Sub1_3.g2_alt1();
											local70 = Static146.aClass4_Sub12_Sub1_3.g2_alt3();
											local335 = Static146.aClass4_Sub12_Sub1_3.g2();
											local224 = Static146.aClass4_Sub12_Sub1_3.g2_alt2();
											local228 = Static146.aClass4_Sub12_Sub1_3.g4_alt2();
											if (Static326.method4415(local224)) {
												Static54.method914(7, local228, local70 | local335 << 16, local327);
											}
											Static300.aClass22_246 = null;
											return true;
										} else if (Static300.aClass22_246 == Static8.aClass22_11) {
											local327 = Static146.aClass4_Sub12_Sub1_3.g2_alt2();
											local70 = Static146.aClass4_Sub12_Sub1_3.g2_alt2();
											local335 = Static146.aClass4_Sub12_Sub1_3.g4();
											local224 = Static146.aClass4_Sub12_Sub1_3.g2_alt1();
											local228 = Static146.aClass4_Sub12_Sub1_3.g2();
											if (Static326.method4415(local327)) {
												Static94.method1652(local335, local228, local224, local70);
											}
											Static300.aClass22_246 = null;
											return true;
										} else if (Static300.aClass22_246 == Static105.aClass22_94) {
											Static124.method2241(true);
											Static300.aClass22_246 = null;
											return true;
										} else if (Static24.aClass22_245 == Static300.aClass22_246) {
											local327 = Static146.aClass4_Sub12_Sub1_3.g2();
											@Pc(3451) byte local3451 = Static146.aClass4_Sub12_Sub1_3.g1s_alt2();
											Static257.aClass114_1.method2830(local327, local3451);
											Static300.aClass22_246 = null;
											return true;
										} else if (Static146.aClass22_23 == Static300.aClass22_246) {
											local327 = Static146.aClass4_Sub12_Sub1_3.g1();
											if (Static146.aClass4_Sub12_Sub1_3.g1() == 0) {
												Static408.aClass28Array1[local327] = new Class28();
											} else {
												Static146.aClass4_Sub12_Sub1_3.pos--;
												Static408.aClass28Array1[local327] = new Class28(Static146.aClass4_Sub12_Sub1_3);
											}
											Static246.anInt4589 = Static325.anInt5640;
											Static300.aClass22_246 = null;
											return true;
										} else if (Static300.aClass22_246 == Static172.aClass22_150) {
											local206 = Static146.aClass4_Sub12_Sub1_3.g1() == 1;
											local210 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
											local212 = local210;
											if (local206) {
												local212 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
											}
											local1252 = Static146.aClass4_Sub12_Sub1_3.g2();
											local1257 = Static146.aClass4_Sub12_Sub1_3.g3();
											local1263 = Static146.aClass4_Sub12_Sub1_3.g1();
											@Pc(3544) long local3544 = (local1252 << 32) + local1257;
											@Pc(3546) boolean local3546 = false;
											local3138 = 0;
											while (true) {
												if (local3138 >= 100) {
													if (local1263 <= 1) {
														if (Static109.aBoolean628 && !Static396.aBoolean443 || Static308.aBoolean486) {
															local3546 = true;
														} else if (Static239.method3549(local212)) {
															local3546 = true;
														}
													}
													break;
												}
												if (local3544 == Static270.aLongArray7[local3138]) {
													local3546 = true;
													break;
												}
												local3138++;
											}
											if (!local3546 && Static65.anInt1373 == 0) {
												Static270.aLongArray7[Static407.anInt6719] = local3544;
												Static407.anInt6719 = (Static407.anInt6719 + 1) % 100;
												@Pc(3605) String local3605 = Static22.method297(Static261.method3776(Static146.aClass4_Sub12_Sub1_3));
												if (local1263 == 2) {
													Static426.method5438(-1, "<img=1>" + local212, local3605, null, 0, "<img=1>" + local210, 7);
												} else if (local1263 == 1) {
													Static426.method5438(-1, "<img=0>" + local212, local3605, null, 0, "<img=0>" + local210, 7);
												} else {
													Static426.method5438(-1, local212, local3605, null, 0, local210, 3);
												}
											}
											Static300.aClass22_246 = null;
											return true;
										} else if (Static257.aClass22_212 == Static300.aClass22_246) {
											local327 = Static146.aClass4_Sub12_Sub1_3.g2_alt1();
											local70 = Static146.aClass4_Sub12_Sub1_3.g1_alt1();
											local335 = Static146.aClass4_Sub12_Sub1_3.g2_alt1();
											@Pc(3691) Class16_Sub1_Sub5_Sub2 local3691 = Static143.aClass16_Sub1_Sub5_Sub2Array1[local327];
											if (local3691 != null) {
												Static33.method632(local335, local70, local3691);
											}
											Static300.aClass22_246 = null;
											return true;
										} else if (Static74.aClass22_72 == Static300.aClass22_246) {
											Static413.anInt6823 = Static146.aClass4_Sub12_Sub1_3.g1();
											for (local327 = 0; local327 < Static413.anInt6823; local327++) {
												Static326.aStringArray27[local327] = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
												Static102.aStringArray7[local327] = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
												if (Static102.aStringArray7[local327].equals("")) {
													Static102.aStringArray7[local327] = Static326.aStringArray27[local327];
												}
												Static315.aStringArray26[local327] = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
												Static141.aStringArray11[local327] = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
												if (Static141.aStringArray11[local327].equals("")) {
													Static141.aStringArray11[local327] = Static315.aStringArray26[local327];
												}
												Static414.aBooleanArray20[local327] = false;
											}
											Static300.aClass22_246 = null;
											Static244.anInt3027 = Static325.anInt5640;
											return true;
										} else {
											@Pc(3817) long local3817;
											if (Static435.aClass22_328 == Static300.aClass22_246) {
												local206 = Static146.aClass4_Sub12_Sub1_3.g1() == 1;
												local210 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
												local212 = local210;
												if (local206) {
													local212 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
												}
												local1252 = Static146.aClass4_Sub12_Sub1_3.g8();
												local1257 = Static146.aClass4_Sub12_Sub1_3.g2();
												local3817 = Static146.aClass4_Sub12_Sub1_3.g3();
												local2494 = Static146.aClass4_Sub12_Sub1_3.g1();
												local2648 = Static146.aClass4_Sub12_Sub1_3.g2();
												@Pc(3832) long local3832 = (local1257 << 32) + local3817;
												@Pc(3834) boolean local3834 = false;
												@Pc(3836) int local3836 = 0;
												while (true) {
													if (local3836 >= 100) {
														if (local2494 <= 1 && Static239.method3549(local212)) {
															local3834 = true;
														}
														break;
													}
													if (Static270.aLongArray7[local3836] == local3832) {
														local3834 = true;
														break;
													}
													local3836++;
												}
												if (!local3834 && Static65.anInt1373 == 0) {
													Static270.aLongArray7[Static407.anInt6719] = local3832;
													Static407.anInt6719 = (Static407.anInt6719 + 1) % 100;
													@Pc(3889) String local3889 = Static445.aClass81_2.method2258(local2648).method234(Static146.aClass4_Sub12_Sub1_3);
													if (local2494 == 2) {
														Static426.method5438(local2648, "<img=1>" + local212, local3889, Static45.method766(local1252), 0, "<img=1>" + local210, 20);
													} else if (local2494 == 1) {
														Static426.method5438(local2648, "<img=0>" + local212, local3889, Static45.method766(local1252), 0, "<img=0>" + local210, 20);
													} else {
														Static426.method5438(local2648, local212, local3889, Static45.method766(local1252), 0, local210, 20);
													}
												}
												Static300.aClass22_246 = null;
												return true;
											} else if (Static399.aClass22_300 == Static300.aClass22_246) {
												for (local327 = 0; local327 < Static267.aClass16_Sub1_Sub5_Sub1Array1.length; local327++) {
													if (Static267.aClass16_Sub1_Sub5_Sub1Array1[local327] != null) {
														Static267.aClass16_Sub1_Sub5_Sub1Array1[local327].anInt6021 = -1;
													}
												}
												for (local70 = 0; local70 < Static143.aClass16_Sub1_Sub5_Sub2Array1.length; local70++) {
													if (Static143.aClass16_Sub1_Sub5_Sub2Array1[local70] != null) {
														Static143.aClass16_Sub1_Sub5_Sub2Array1[local70].anInt6021 = -1;
													}
												}
												Static300.aClass22_246 = null;
												return true;
											} else if (Static310.aClass22_251 == Static300.aClass22_246) {
												local327 = Static146.aClass4_Sub12_Sub1_3.g2();
												if (Static326.method4415(local327)) {
													Static54.method913();
												}
												Static300.aClass22_246 = null;
												return true;
											} else {
												@Pc(4235) Class15 local4235;
												if (Static4.aClass22_277 == Static300.aClass22_246) {
													Static381.anInt6418 = Static325.anInt5640;
													if (Static454.anInt4075 == 0) {
														Static221.aString39 = null;
														Static300.aClass22_246 = null;
														aClass15Array2 = null;
														Static290.anInt6410 = 0;
														Static395.aString63 = null;
														return true;
													}
													Static395.aString63 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
													local206 = Static146.aClass4_Sub12_Sub1_3.g1() == 1;
													if (local206) {
														Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
													}
													@Pc(4078) long local4078 = Static146.aClass4_Sub12_Sub1_3.g8();
													Static221.aString39 = Static44.method763(local4078);
													Static446.aByte103 = Static146.aClass4_Sub12_Sub1_3.g1s();
													local224 = Static146.aClass4_Sub12_Sub1_3.g1();
													if (local224 == 255) {
														Static300.aClass22_246 = null;
														return true;
													}
													Static290.anInt6410 = local224;
													@Pc(4104) Class15[] local4104 = new Class15[100];
													for (local1190 = 0; local1190 < Static290.anInt6410; local1190++) {
														local4104[local1190] = new Class15();
														local4104[local1190].aString8 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
														local206 = Static146.aClass4_Sub12_Sub1_3.g1() == 1;
														if (local206) {
															local4104[local1190].aString7 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
														} else {
															local4104[local1190].aString7 = local4104[local1190].aString8;
														}
														local4104[local1190].aString6 = Static123.method4868(local4104[local1190].aString7);
														local4104[local1190].anInt272 = Static146.aClass4_Sub12_Sub1_3.g2();
														local4104[local1190].aByte1 = Static146.aClass4_Sub12_Sub1_3.g1s();
														local4104[local1190].aString5 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
														if (local4104[local1190].aString7.equals(Static1.aClass16_Sub1_Sub5_Sub1_1.aString44)) {
															Static160.aByte18 = local4104[local1190].aByte1;
														}
													}
													local1267 = Static290.anInt6410;
													while (local1267 > 0) {
														local1858 = true;
														local1267--;
														for (local2494 = 0; local2494 < local1267; local2494++) {
															if (local4104[local2494].aString6.compareTo(local4104[local2494 + 1].aString6) > 0) {
																local4235 = local4104[local2494];
																local4104[local2494] = local4104[local2494 + 1];
																local1858 = false;
																local4104[local2494 + 1] = local4235;
															}
														}
														if (local1858) {
															break;
														}
													}
													aClass15Array2 = local4104;
													Static300.aClass22_246 = null;
													return true;
												} else if (Static406.aClass22_307 == Static300.aClass22_246) {
													Static257.aClass114_1.method2829();
													Static292.anInt5255 += 32;
													Static300.aClass22_246 = null;
													return true;
												} else if (Static300.aClass22_246 == Static233.aClass22_196) {
													local327 = Static146.aClass4_Sub12_Sub1_3.g2_alt1();
													local70 = Static146.aClass4_Sub12_Sub1_3.g2_alt3();
													if (local70 == 65535) {
														local70 = -1;
													}
													local335 = Static146.aClass4_Sub12_Sub1_3.g4_alt3();
													if (Static326.method4415(local327)) {
														Static54.method914(1, local335, local70, -1);
													}
													Static300.aClass22_246 = null;
													return true;
												} else if (Static300.aClass22_246 == Static433.aClass22_327) {
													local327 = Static146.aClass4_Sub12_Sub1_3.g4();
													local70 = Static146.aClass4_Sub12_Sub1_3.g2_alt2();
													if (Static326.method4415(local70)) {
														Static54.method914(5, local327, Static207.anInt5452, 0);
													}
													Static300.aClass22_246 = null;
													return true;
												} else if (Static300.aClass22_246 == Static199.aClass22_173) {
													local327 = Static146.aClass4_Sub12_Sub1_3.g2();
													local70 = Static146.aClass4_Sub12_Sub1_3.g1();
													local335 = Static146.aClass4_Sub12_Sub1_3.g1();
													local224 = Static146.aClass4_Sub12_Sub1_3.g2() << 0;
													local228 = Static146.aClass4_Sub12_Sub1_3.g1();
													local1190 = Static146.aClass4_Sub12_Sub1_3.g1();
													if (Static326.method4415(local327)) {
														Static313.method4175(local1190, local224, local335, local228, local70);
													}
													Static300.aClass22_246 = null;
													return true;
												} else if (Static300.aClass22_246 == Static423.aClass22_316) {
													Static300.aClass22_246 = null;
													Static244.anInt3027 = Static325.anInt5640;
													Static376.anInt6277 = 1;
													return true;
												} else if (Static421.aClass22_310 == Static300.aClass22_246) {
													local327 = Static146.aClass4_Sub12_Sub1_3.g1();
													@Pc(4427) boolean local4427 = (local327 & 0x1) == 1;
													local212 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
													local535 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
													if (local535.equals("")) {
														local535 = local212;
													}
													local2080 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
													local1747 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
													if (local1747.equals("")) {
														local1747 = local2080;
													}
													if (local4427) {
														for (local2473 = 0; local2473 < Static413.anInt6823; local2473++) {
															if (Static102.aStringArray7[local2473].equals(local1747)) {
																Static326.aStringArray27[local2473] = local212;
																Static102.aStringArray7[local2473] = local535;
																Static315.aStringArray26[local2473] = local2080;
																Static141.aStringArray11[local2473] = local1747;
																break;
															}
														}
													} else {
														Static326.aStringArray27[Static413.anInt6823] = local212;
														Static102.aStringArray7[Static413.anInt6823] = local535;
														Static315.aStringArray26[Static413.anInt6823] = local2080;
														Static141.aStringArray11[Static413.anInt6823] = local1747;
														Static414.aBooleanArray20[Static413.anInt6823] = (local327 & 0x2) == 2;
														Static413.anInt6823++;
													}
													Static300.aClass22_246 = null;
													Static244.anInt3027 = Static325.anInt5640;
													return true;
												} else if (Static300.aClass22_246 == Static27.aClass22_33) {
													Static92.anInt1847 = Static146.aClass4_Sub12_Sub1_3.g1();
													Static300.aClass22_246 = null;
													Static308.anInt5413 = Static325.anInt5640;
													return true;
												} else if (Static300.aClass22_246 == Static167.aClass22_144) {
													Static188.anInt5353 = Static146.aClass4_Sub12_Sub1_3.g2() * 30;
													Static300.aClass22_246 = null;
													Static308.anInt5413 = Static325.anInt5640;
													return true;
												} else if (Static82.aClass22_80 == Static300.aClass22_246) {
													local813 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
													local70 = Static146.aClass4_Sub12_Sub1_3.g2();
													local335 = Static146.aClass4_Sub12_Sub1_3.g4_alt3();
													if (Static326.method4415(local70)) {
														Static79.method1398(local813, local335);
													}
													Static300.aClass22_246 = null;
													return true;
												} else if (Static300.aClass22_246 == Static164.aClass22_204) {
													method2572(Static294.aClass21_4);
													Static300.aClass22_246 = null;
													return true;
												} else if (Static169.aClass22_146 == Static300.aClass22_246) {
													local327 = Static146.aClass4_Sub12_Sub1_3.g2_alt2();
													local210 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
													local335 = Static146.aClass4_Sub12_Sub1_3.g2();
													if (Static326.method4415(local335)) {
														Static244.method2569(local210, local327);
													}
													Static300.aClass22_246 = null;
													return true;
												} else if (Static131.aClass22_117 == Static300.aClass22_246) {
													local327 = Static146.aClass4_Sub12_Sub1_3.g4();
													local70 = Static146.aClass4_Sub12_Sub1_3.g2();
													local335 = Static146.aClass4_Sub12_Sub1_3.g2_alt1();
													if (Static326.method4415(local335)) {
														Static14.method145(local327, local70);
													}
													Static300.aClass22_246 = null;
													return true;
												} else if (Static43.aClass22_332 == Static300.aClass22_246) {
													Static211.method3203();
													Static300.aClass22_246 = null;
													return false;
												} else if (Static300.aClass22_246 == Static3.aClass22_185) {
													local327 = Static146.aClass4_Sub12_Sub1_3.g2();
													local70 = Static146.aClass4_Sub12_Sub1_3.g4_alt3();
													local335 = Static146.aClass4_Sub12_Sub1_3.g2_alt2();
													if (Static326.method4415(local327)) {
														Static164.method3585(local335, local70);
													}
													Static300.aClass22_246 = null;
													return true;
												} else if (Static300.aClass22_246 == Static230.aClass22_194) {
													Static154.anInt813 = Static146.aClass4_Sub12_Sub1_3.g1s_alt3() << 3;
													Static385.anInt6487 = Static146.aClass4_Sub12_Sub1_3.g1s() << 3;
													Static113.anInt2426 = Static146.aClass4_Sub12_Sub1_3.g1_alt2();
													while (Static454.anInt4075 > Static146.aClass4_Sub12_Sub1_3.pos) {
														@Pc(4723) Class21 local4723 = Static448.method5650()[Static146.aClass4_Sub12_Sub1_3.g1()];
														method2572(local4723);
													}
													Static300.aClass22_246 = null;
													return true;
												} else if (Static300.aClass22_246 == Static262.aClass22_219) {
													Static184.anInt3532 = Static146.aClass4_Sub12_Sub1_3.g1();
													Static300.aClass22_246 = null;
													return true;
												} else if (Static300.aClass22_246 == Static422.aClass22_313) {
													method2572(Static38.aClass21_6);
													Static300.aClass22_246 = null;
													return true;
												} else if (Static300.aClass22_246 == Static154.aClass22_51) {
													local327 = Static146.aClass4_Sub12_Sub1_3.g2();
													if (Static326.method4415(local327)) {
														Static100.method1773();
													}
													Static300.aClass22_246 = null;
													return true;
												} else if (Static194.aClass22_164 == Static300.aClass22_246) {
													local327 = Static146.aClass4_Sub12_Sub1_3.gts_alt3();
													local70 = Static146.aClass4_Sub12_Sub1_3.g4();
													local335 = Static146.aClass4_Sub12_Sub1_3.gts_alt3();
													local224 = Static146.aClass4_Sub12_Sub1_3.g2_alt3();
													if (Static326.method4415(local224)) {
														Static400.method5189(local70, local335, local327);
													}
													Static300.aClass22_246 = null;
													return true;
												} else if (Static300.aClass22_246 == Static234.aClass22_199) {
													local327 = Static146.aClass4_Sub12_Sub1_3.g2();
													if (local327 == 65535) {
														local327 = -1;
													}
													local70 = Static146.aClass4_Sub12_Sub1_3.g1();
													local335 = Static146.aClass4_Sub12_Sub1_3.g2();
													local224 = Static146.aClass4_Sub12_Sub1_3.g1();
													Static187.method2934(local327, local70, local224, local335);
													Static300.aClass22_246 = null;
													return true;
												} else if (Static300.aClass22_246 == Static60.aClass22_63) {
													method2572(Static410.aClass21_15);
													Static300.aClass22_246 = null;
													return true;
												} else if (Static332.aClass22_269 == Static300.aClass22_246) {
													method2572(Static35.aClass21_5);
													Static300.aClass22_246 = null;
													return true;
												} else if (Static45.aClass22_49 == Static300.aClass22_246) {
													local327 = Static146.aClass4_Sub12_Sub1_3.g2();
													local70 = Static146.aClass4_Sub12_Sub1_3.g1();
													local335 = Static146.aClass4_Sub12_Sub1_3.g1();
													local224 = Static146.aClass4_Sub12_Sub1_3.g2() << 0;
													local228 = Static146.aClass4_Sub12_Sub1_3.g1();
													local1190 = Static146.aClass4_Sub12_Sub1_3.g1();
													if (Static326.method4415(local327)) {
														Static245.method3596(local224, true, local1190, local335, local70, local228);
													}
													Static300.aClass22_246 = null;
													return true;
												} else if (Static300.aClass22_246 == Static149.aClass22_129) {
													local327 = Static146.aClass4_Sub12_Sub1_3.g2();
													if (local327 == 65535) {
														local327 = -1;
													}
													local70 = Static146.aClass4_Sub12_Sub1_3.g1();
													local335 = Static146.aClass4_Sub12_Sub1_3.g2();
													local224 = Static146.aClass4_Sub12_Sub1_3.g1();
													Static273.method3912(local70, local335, local327, local224);
													Static300.aClass22_246 = null;
													return true;
												} else if (Static300.aClass22_246 == Static287.aClass22_236) {
													method2572(Static183.aClass21_11);
													Static300.aClass22_246 = null;
													return true;
												} else if (Static72.aClass22_71 == Static300.aClass22_246) {
													Static124.method2241(false);
													Static300.aClass22_246 = null;
													return true;
												} else if (Static320.aClass22_263 == Static300.aClass22_246) {
													local327 = Static146.aClass4_Sub12_Sub1_3.g1_alt3();
													local70 = Static146.aClass4_Sub12_Sub1_3.g4_alt3();
													local335 = Static146.aClass4_Sub12_Sub1_3.g2_alt2();
													if (Static326.method4415(local335)) {
														Static255.method3686(local327, local70);
													}
													Static300.aClass22_246 = null;
													return true;
												} else if (Static443.aClass22_331 == Static300.aClass22_246) {
													local813 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
													local1411 = Static146.aClass4_Sub12_Sub1_3.g1() == 1;
													if (local1411) {
														local210 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
													} else {
														local210 = local813;
													}
													local224 = Static146.aClass4_Sub12_Sub1_3.g2();
													@Pc(5040) byte local5040 = Static146.aClass4_Sub12_Sub1_3.g1s();
													local230 = false;
													if (local5040 == -128) {
														local230 = true;
													}
													if (local230) {
														if (Static290.anInt6410 == 0) {
															Static300.aClass22_246 = null;
															return true;
														}
														for (local2473 = 0; Static290.anInt6410 > local2473 && (!aClass15Array2[local2473].aString7.equals(local210) || aClass15Array2[local2473].anInt272 != local224); local2473++) {
														}
														if (local2473 < Static290.anInt6410) {
															while (local2473 < Static290.anInt6410 - 1) {
																aClass15Array2[local2473] = aClass15Array2[local2473 + 1];
																local2473++;
															}
															Static290.anInt6410--;
															aClass15Array2[Static290.anInt6410] = null;
														}
													} else {
														local251 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
														local4235 = new Class15();
														local4235.aString8 = local813;
														local4235.aString7 = local210;
														local4235.aString6 = Static123.method4868(local4235.aString7);
														local4235.aByte1 = local5040;
														local4235.anInt272 = local224;
														local4235.aString5 = local251;
														for (local1267 = Static290.anInt6410 - 1; local1267 >= 0; local1267--) {
															local2494 = aClass15Array2[local1267].aString6.compareTo(local4235.aString6);
															if (local2494 == 0) {
																aClass15Array2[local1267].anInt272 = local224;
																aClass15Array2[local1267].aByte1 = local5040;
																aClass15Array2[local1267].aString5 = local251;
																if (local210.equals(Static1.aClass16_Sub1_Sub5_Sub1_1.aString44)) {
																	Static160.aByte18 = local5040;
																}
																Static381.anInt6418 = Static325.anInt5640;
																Static300.aClass22_246 = null;
																return true;
															}
															if (local2494 < 0) {
																break;
															}
														}
														if (Static290.anInt6410 >= aClass15Array2.length) {
															Static300.aClass22_246 = null;
															return true;
														}
														for (local2494 = Static290.anInt6410 - 1; local2494 > local1267; local2494--) {
															aClass15Array2[local2494 + 1] = aClass15Array2[local2494];
														}
														if (Static290.anInt6410 == 0) {
															aClass15Array2 = new Class15[100];
														}
														aClass15Array2[local1267 + 1] = local4235;
														Static290.anInt6410++;
														if (local210.equals(Static1.aClass16_Sub1_Sub5_Sub1_1.aString44)) {
															Static160.aByte18 = local5040;
														}
													}
													Static300.aClass22_246 = null;
													Static381.anInt6418 = Static325.anInt5640;
													return true;
												} else if (Static300.aClass22_246 == Static1.aClass22_1) {
													method2572(Static405.aClass21_14);
													Static300.aClass22_246 = null;
													return true;
												} else if (Static300.aClass22_246 == Static201.aClass22_273) {
													method2572(Static179.aClass21_10);
													Static300.aClass22_246 = null;
													return true;
												} else if (Static214.aClass22_178 == Static300.aClass22_246) {
													local327 = Static146.aClass4_Sub12_Sub1_3.g2();
													if (local327 == 65535) {
														local327 = -1;
													}
													local70 = Static146.aClass4_Sub12_Sub1_3.g2_alt2();
													local335 = Static146.aClass4_Sub12_Sub1_3.g4_alt1();
													local224 = Static146.aClass4_Sub12_Sub1_3.g2_alt1();
													local228 = Static146.aClass4_Sub12_Sub1_3.g2();
													if (local228 == 65535) {
														local228 = -1;
													}
													if (Static326.method4415(local70)) {
														for (local1190 = local228; local1190 <= local327; local1190++) {
															local2311 = ((long) local335 << 32) + ((long) local1190);
															local2317 = (Node_Sub33) Static211.A_HASH_MAP___18.get(local2311);
															if (local2317 != null) {
																local2329 = new Node_Sub33(local2317.anInt5105, local224);
																local2317.popSelf();
															} else if (local1190 == -1) {
																local2329 = new Node_Sub33(Static392.method5121(local335).aClass4_Sub33_2.anInt5105, local224);
															} else {
																local2329 = new Node_Sub33(0, local224);
															}
															Static211.A_HASH_MAP___18.set(local2311, local2329);
														}
													}
													Static300.aClass22_246 = null;
													return true;
												} else if (Static300.aClass22_246 == Static379.aClass22_293) {
													local327 = Static146.aClass4_Sub12_Sub1_3.g2_alt2();
													local210 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
													local335 = Static146.aClass4_Sub12_Sub1_3.g2_alt2();
													if (Static326.method4415(local327)) {
														Static244.method2569(local210, local335);
													}
													Static300.aClass22_246 = null;
													return true;
												} else if (Static277.aClass22_231 == Static300.aClass22_246) {
													Static439.dropSettingsCookie(Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8());
													Static300.aClass22_246 = null;
													return true;
												} else if (Static207.aClass22_253 == Static300.aClass22_246) {
													Static113.anInt2426 = Static146.aClass4_Sub12_Sub1_3.g1_alt2();
													Static154.anInt813 = Static146.aClass4_Sub12_Sub1_3.g1s_alt3() << 3;
													Static385.anInt6487 = Static146.aClass4_Sub12_Sub1_3.g1s_alt2() << 3;
													for (@Pc(5469) Node_Sub18 local5469 = (Node_Sub18) Static440.aHashMap_40.head(); local5469 != null; local5469 = (Node_Sub18) Static440.aHashMap_40.next()) {
														local70 = (int) (local5469.hashKey & 0x3FFFL);
														local335 = (int) (local5469.hashKey >> 14 & 0x3FFFL);
														local224 = (int) (local5469.hashKey >> 28 & 0x3L);
														if (local224 == Static113.anInt2426 && local70 >= Static154.anInt813 && Static154.anInt813 + 8 > local70 && Static385.anInt6487 <= local335 && Static385.anInt6487 + 8 > local335) {
															local5469.popSelf();
															Static443.method5595(Static113.anInt2426, local70, local335);
														}
													}
													for (@Pc(5544) Node_Sub9 local5544 = (Node_Sub9) Static115.aClass183_15.method4140(); local5544 != null; local5544 = (Node_Sub9) Static115.aClass183_15.method4144()) {
														if (Static154.anInt813 <= local5544.anInt793 && Static154.anInt813 + 8 > local5544.anInt793 && local5544.anInt790 >= Static385.anInt6487 && Static385.anInt6487 + 8 > local5544.anInt790 && Static113.anInt2426 == local5544.anInt800) {
															local5544.anInt796 = 0;
														}
													}
													Static300.aClass22_246 = null;
													return true;
												} else if (Static300.aClass22_246 == Static106.aClass22_95) {
													local327 = Static146.aClass4_Sub12_Sub1_3.g4_alt1();
													local70 = Static146.aClass4_Sub12_Sub1_3.g2();
													local335 = Static146.aClass4_Sub12_Sub1_3.g2_alt2();
													if (local335 == 65535) {
														local335 = -1;
													}
													if (Static326.method4415(local70)) {
														Static54.method914(2, local327, local335, -1);
													}
													Static300.aClass22_246 = null;
													return true;
												} else if (Static42.aClass22_46 == Static300.aClass22_246) {
													local327 = Static146.aClass4_Sub12_Sub1_3.gSmart1Or2();
													local70 = Static146.aClass4_Sub12_Sub1_3.g4();
													local335 = Static146.aClass4_Sub12_Sub1_3.g1();
													local535 = "";
													local2080 = local535;
													if ((local335 & 0x1) != 0) {
														local535 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
														if ((local335 & 0x2) == 0) {
															local2080 = local535;
														} else {
															local2080 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
														}
													}
													local1747 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
													if (local327 == 99) {
														Static441.method5568(local1747);
													} else if (local2080.equals("") || !Static239.method3549(local2080)) {
														Static128.method2268(local70, local327, local1747, local535, local2080);
													} else {
														Static300.aClass22_246 = null;
														return true;
													}
													Static300.aClass22_246 = null;
													return true;
												} else if (Static300.aClass22_246 == Static369.aClass22_287) {
													Static413.method5301();
													Static300.aClass22_246 = null;
													return true;
												} else if (Static330.aClass22_266 == Static300.aClass22_246) {
													method2572(Static106.aClass21_7);
													Static300.aClass22_246 = null;
													return true;
												} else if (Static300.aClass22_246 == Static225.aClass22_192) {
													local327 = Static146.aClass4_Sub12_Sub1_3.g2();
													local70 = Static146.aClass4_Sub12_Sub1_3.g4();
													if (Static326.method4415(local327)) {
														@Pc(5751) Node_Sub43 local5751 = (Node_Sub43) Static325.aHashMap_29.get((long) local70);
														if (local5751 != null) {
															Static90.method1606(true, local5751, false);
														}
														if (Static304.aClass247_16 != null) {
															Static63.method1142(Static304.aClass247_16);
															Static304.aClass247_16 = null;
														}
													}
													Static300.aClass22_246 = null;
													return true;
												} else if (Static300.aClass22_246 == Static345.aClass22_278) {
													local327 = Static146.aClass4_Sub12_Sub1_3.g1_alt2();
													local70 = local327 >> 2;
													local335 = local327 & 0x3;
													local224 = Static201.anIntArray410[local70];
													local228 = Static146.aClass4_Sub12_Sub1_3.g4_alt1();
													local1190 = local228 >> 28 & 0x3;
													local2473 = local228 >> 14 & 0x3FFF;
													local1263 = local228 & 0x3FFF;
													local1267 = Static146.aClass4_Sub12_Sub1_3.g2_alt1();
													@Pc(5820) int local5820 = local1263 - Static86.anInt1771;
													if (local1267 == 65535) {
														local1267 = -1;
													}
													local2473 -= Static180.anInt3453;
													Static297.method4071(local1190, local335, local1267, local224, local70, local2473, local5820);
													Static300.aClass22_246 = null;
													return true;
												} else if (Static272.aClass22_230 == Static300.aClass22_246) {
													local327 = Static146.aClass4_Sub12_Sub1_3.g2();
													local70 = Static146.aClass4_Sub12_Sub1_3.g1();
													local335 = Static146.aClass4_Sub12_Sub1_3.g1();
													local224 = Static146.aClass4_Sub12_Sub1_3.g1();
													local228 = Static146.aClass4_Sub12_Sub1_3.g1();
													local1190 = Static146.aClass4_Sub12_Sub1_3.g2();
													if (Static326.method4415(local327)) {
														Static342.aBooleanArray17[local70] = true;
														Static105.anIntArray161[local70] = local335;
														Static41.anIntArray46[local70] = local224;
														Static61.anIntArray65[local70] = local228;
														Static390.anIntArray486[local70] = local1190;
													}
													Static300.aClass22_246 = null;
													return true;
												} else if (Static300.aClass22_246 == Static210.aClass22_175) {
													method2572(Static420.aClass21_16);
													Static300.aClass22_246 = null;
													return true;
												} else if (Static300.aClass22_246 == Static399.aClass22_301) {
													Static167.aString35 = Static454.anInt4075 > 2 ? Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8() : Static190.A_LOCALIZED_STRING___76.getLocalizedString(ClientSettings.langID);
													Static220.anInt4097 = Static454.anInt4075 > 0 ? Static146.aClass4_Sub12_Sub1_3.g2() : -1;
													Static300.aClass22_246 = null;
													if (Static220.anInt4097 == 65535) {
														Static220.anInt4097 = -1;
													}
													return true;
												} else if (Static287.aClass22_235 == Static300.aClass22_246) {
													local327 = Static146.aClass4_Sub12_Sub1_3.g4();
													Static216.aClass199_7 = GameShell.signLink.emitReverseIPLookupMessage(local327);
													Static300.aClass22_246 = null;
													return true;
												} else if (Static452.aClass22_335 == Static300.aClass22_246) {
													Static186.aClass104_2 = Static2.method6(Static146.aClass4_Sub12_Sub1_3.g1());
													Static300.aClass22_246 = null;
													return true;
												} else if (Static305.aClass22_249 == Static300.aClass22_246) {
													Static95.method1665(Static146.aClass4_Sub12_Sub1_3, Static454.anInt4075, GameShell.signLink);
													Static300.aClass22_246 = null;
													return true;
												} else if (Static300.aClass22_246 == Static279.aClass22_330) {
													local327 = Static146.aClass4_Sub12_Sub1_3.g2_alt3();
													local70 = Static146.aClass4_Sub12_Sub1_3.g2();
													@Pc(6007) byte local6007 = Static146.aClass4_Sub12_Sub1_3.g1s_alt3();
													if (Static326.method4415(local327)) {
														Static316.method4221(local70, local6007);
													}
													Static300.aClass22_246 = null;
													return true;
												} else if (Static11.aClass22_16 == Static300.aClass22_246) {
													Static146.aClass4_Sub12_Sub1_3.pos += 28;
													if (Static146.aClass4_Sub12_Sub1_3.method2500()) {
														Static157.method2669(Static146.aClass4_Sub12_Sub1_3, Static146.aClass4_Sub12_Sub1_3.pos - 28);
													}
													Static300.aClass22_246 = null;
													return true;
												} else if (Static396.aClass22_214 == Static300.aClass22_246) {
													local327 = Static146.aClass4_Sub12_Sub1_3.g2_alt3();
													local70 = Static146.aClass4_Sub12_Sub1_3.g2_alt3();
													local335 = Static146.aClass4_Sub12_Sub1_3.g4();
													local224 = Static146.aClass4_Sub12_Sub1_3.g2_alt3();
													if (Static326.method4415(local327)) {
														Static303.method4114(local335, local70 + (local224 << 16));
													}
													Static300.aClass22_246 = null;
													return true;
												} else if (Static300.aClass22_246 == Static113.aClass22_101) {
													method2572(Static152.aClass21_9);
													Static300.aClass22_246 = null;
													return true;
												} else if (Static300.aClass22_246 == Static360.aClass22_284) {
													local327 = Static146.aClass4_Sub12_Sub1_3.g4_alt1();
													local70 = Static146.aClass4_Sub12_Sub1_3.g4_alt3();
													local335 = Static146.aClass4_Sub12_Sub1_3.g2_alt1();
													if (Static326.method4415(local335)) {
														@Pc(6126) Node_Sub43 local6126 = (Node_Sub43) Static325.aHashMap_29.get((long) local70);
														local1576 = (Node_Sub43) Static325.aHashMap_29.get((long) local327);
														if (local1576 != null) {
															Static90.method1606(local6126 == null || local1576.anInt6979 != local6126.anInt6979, local1576, false);
														}
														if (local6126 != null) {
															local6126.popSelf();
															Static325.aHashMap_29.set((long) local327, local6126);
														}
														@Pc(6164) Class247 local6164 = Static392.method5121(local70);
														if (local6164 != null) {
															Static63.method1142(local6164);
														}
														local6164 = Static392.method5121(local327);
														if (local6164 != null) {
															Static63.method1142(local6164);
															Static374.method4998(local6164, true);
														}
														if (Static334.anInt5766 != -1) {
															Static310.method4165(Static334.anInt5766, 1);
														}
													}
													Static300.aClass22_246 = null;
													return true;
												} else if (Static433.aClass22_326 == Static300.aClass22_246) {
													local206 = Static146.aClass4_Sub12_Sub1_3.g1() == 1;
													local210 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
													local212 = local210;
													if (local206) {
														local212 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
													}
													local1252 = Static146.aClass4_Sub12_Sub1_3.g8();
													local1257 = Static146.aClass4_Sub12_Sub1_3.g2();
													local3817 = Static146.aClass4_Sub12_Sub1_3.g3();
													local2494 = Static146.aClass4_Sub12_Sub1_3.g1();
													@Pc(6247) long local6247 = (local1257 << 32) + local3817;
													@Pc(6249) boolean local6249 = false;
													@Pc(6251) int local6251 = 0;
													while (true) {
														if (local6251 >= 100) {
															if (local2494 <= 1) {
																if (Static109.aBoolean628 && !Static396.aBoolean443 || Static308.aBoolean486) {
																	local6249 = true;
																} else if (Static239.method3549(local212)) {
																	local6249 = true;
																}
															}
															break;
														}
														if (local6247 == Static270.aLongArray7[local6251]) {
															local6249 = true;
															break;
														}
														local6251++;
													}
													if (!local6249 && Static65.anInt1373 == 0) {
														Static270.aLongArray7[Static407.anInt6719] = local6247;
														Static407.anInt6719 = (Static407.anInt6719 + 1) % 100;
														@Pc(6311) String local6311 = Static22.method297(Static261.method3776(Static146.aClass4_Sub12_Sub1_3));
														if (local2494 == 2 || local2494 == 3) {
															Static426.method5438(-1, "<img=1>" + local212, local6311, Static45.method766(local1252), 0, "<img=1>" + local210, 9);
														} else if (local2494 == 1) {
															Static426.method5438(-1, "<img=0>" + local212, local6311, Static45.method766(local1252), 0, "<img=0>" + local210, 9);
														} else {
															Static426.method5438(-1, local212, local6311, Static45.method766(local1252), 0, local210, 9);
														}
													}
													Static300.aClass22_246 = null;
													return true;
												} else {
													Static94.handleClientError(null, "T1 - " + (Static300.aClass22_246 == null ? -1 : Static300.aClass22_246.method527()) + "," + (Static380.aClass22_294 == null ? -1 : Static380.aClass22_294.method527()) + "," + (Static316.aClass22_257 == null ? -1 : Static316.aClass22_257.method527()) + " - " + Static454.anInt4075);
													Static251.method3639();
													return true;
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}

	@OriginalMember(owner = "client!nh", name = "f", descriptor = "(I)V")
	public static void method3806() {
		if (!areModeratorPrivilegesAvailable()) {
			return;
		}
		if (Static102.aStringArray8 == null) {
			Static19.method198();
		}
		Static69.aBoolean292 = true;
		Static259.anInt4882 = 0;
		try {
			Static348.aClipboard1 = Static6.client.getToolkit().getSystemClipboard();
		} catch (@Pc(16) Exception local16) {
		}
	}

	@OriginalMember(owner = "client!vi", name = "b", descriptor = "(Z)Z")
	public static boolean areModeratorPrivilegesAvailable() {
		return !ClientSettings.modewhere.isLive() || Static104.anInt2252 >= 2;
	}

	@OriginalMember(owner = "client!mh", name = "a", descriptor = "(ILclient!bf;)V")
	public static void method2572(@OriginalArg(1) Class21 arg0) {
		@Pc(12) int local12;
		@Pc(16) int local16;
		if (Static435.aClass21_17 == arg0) {
			local12 = Static146.aClass4_Sub12_Sub1_3.g2();
			local16 = Static146.aClass4_Sub12_Sub1_3.g1();
			Static267.aClass262_2.method5560(local12).method4590(local16);
			return;
		}
		@Pc(40) int local40;
		@Pc(49) int local49;
		@Pc(55) int local55;
		if (Static133.aClass21_8 == arg0) {
			local12 = Static146.aClass4_Sub12_Sub1_3.g2_alt1();
			local16 = Static146.aClass4_Sub12_Sub1_3.g2_alt2();
			local40 = Static146.aClass4_Sub12_Sub1_3.g1();
			local49 = Static154.anInt813 + (local40 >> 4 & 0x7);
			local55 = Static385.anInt6487 + (local40 & 0x7);
			if (local49 >= 0 && local55 >= 0 && local49 < Static326.anInt5666 && Static283.anInt5187 > local55) {
				Static28.method528(new Node_Sub45(local16, local12), local49, local55, Static113.anInt2426);
				Static443.method5595(Static113.anInt2426, local49, local55);
			}
			return;
		}
		@Pc(126) int local126;
		if (arg0 == Static179.aClass21_10) {
			Static146.aClass4_Sub12_Sub1_3.g1();
			local12 = Static146.aClass4_Sub12_Sub1_3.g1();
			local16 = Static154.anInt813 + (local12 >> 4 & 0x7);
			local40 = (local12 & 0x7) + Static385.anInt6487;
			local49 = Static146.aClass4_Sub12_Sub1_3.g2();
			local55 = Static146.aClass4_Sub12_Sub1_3.g1();
			local126 = Static146.aClass4_Sub12_Sub1_3.g3();
			@Pc(130) String local130 = Static146.aClass4_Sub12_Sub1_3.gStringCP1252ToUTF8();
			Static212.method3207(local126, local49, Static113.anInt2426, local16, local40, local55, local130);
			return;
		}
		@Pc(186) int local186;
		@Pc(190) int local190;
		@Pc(196) int local196;
		@Pc(202) int local202;
		@Pc(206) int local206;
		@Pc(210) int local210;
		@Pc(214) int local214;
		@Pc(223) int local223;
		@Pc(309) Class16_Sub1_Sub3 local309;
		if (Static294.aClass21_4 == arg0) {
			local12 = Static146.aClass4_Sub12_Sub1_3.g1();
			@Pc(155) boolean local155 = (local12 & 0x80) != 0;
			local40 = (local12 >> 3 & 0x7) + Static154.anInt813;
			local49 = (local12 & 0x7) + Static385.anInt6487;
			local55 = Static146.aClass4_Sub12_Sub1_3.g1s() + local40;
			local126 = local49 + Static146.aClass4_Sub12_Sub1_3.g1s();
			local186 = Static146.aClass4_Sub12_Sub1_3.g2s();
			local190 = Static146.aClass4_Sub12_Sub1_3.g2();
			local196 = Static146.aClass4_Sub12_Sub1_3.g1() * 4;
			local202 = Static146.aClass4_Sub12_Sub1_3.g1() * 4;
			local206 = Static146.aClass4_Sub12_Sub1_3.g2();
			local210 = Static146.aClass4_Sub12_Sub1_3.g2();
			local214 = Static146.aClass4_Sub12_Sub1_3.g1();
			if (local214 == 255) {
				local214 = -1;
			}
			local223 = Static146.aClass4_Sub12_Sub1_3.g1();
			if (local40 >= 0 && local49 >= 0 && Static326.anInt5666 > local40 && Static283.anInt5187 > local49 && local55 >= 0 && local126 >= 0 && Static326.anInt5666 > local55 && local126 < Static283.anInt5187 && local190 != 65535) {
				local40 = local40 * 128 + 64;
				local126 = local126 * 128 + 64;
				local196 <<= 0x0;
				local49 = local49 * 128 + 64;
				local55 = local55 * 128 + 64;
				local202 <<= 0x0;
				local309 = new Class16_Sub1_Sub3(local190, Static113.anInt2426, local40, local49, local196, local206 + gameLogicStepCount, local210 + gameLogicStepCount, local214, local223, local186, local202, local155);
				local309.method2197(gameLogicStepCount + local206, local55, Static13.method135(local55, Static113.anInt2426, local126) - local202, local126);
				Static27.aClass183_2.method4137(new SecondaryNode_Sub1_Sub7(local309));
			}
		} else if (Static420.aClass21_16 == arg0) {
			local12 = Static146.aClass4_Sub12_Sub1_3.g2_alt3();
			local16 = Static146.aClass4_Sub12_Sub1_3.g1_alt2();
			local40 = (local16 >> 4 & 0x7) + Static154.anInt813;
			local49 = Static385.anInt6487 + (local16 & 0x7);
			if (local40 >= 0 && local49 >= 0 && Static326.anInt5666 > local40 && local49 < Static283.anInt5187) {
				@Pc(395) Node_Sub18 local395 = (Node_Sub18) Static440.aHashMap_40.get((long) (Static113.anInt2426 << 28 | local49 << 14 | local40));
				if (local395 != null) {
					for (@Pc(403) Node_Sub45 local403 = (Node_Sub45) local395.aClass183_14.method4140(); local403 != null; local403 = (Node_Sub45) local395.aClass183_14.method4144()) {
						if (local403.anInt7355 == (local12 & 0x7FFF)) {
							local403.popSelf();
							break;
						}
					}
					if (local395.aClass183_14.method4147()) {
						local395.popSelf();
					}
					Static443.method5595(Static113.anInt2426, local40, local49);
				}
			}
		} else if (arg0 == Static183.aClass21_11) {
			local12 = Static146.aClass4_Sub12_Sub1_3.g2_alt2();
			@Pc(453) byte local453 = Static146.aClass4_Sub12_Sub1_3.g1s_alt2();
			local40 = Static146.aClass4_Sub12_Sub1_3.g1_alt2();
			local49 = local40 >> 2;
			local55 = local40 & 0x3;
			local126 = Static146.aClass4_Sub12_Sub1_3.g1_alt1();
			local186 = Static154.anInt813 + (local126 >> 4 & 0x7);
			local190 = (local126 & 0x7) + Static385.anInt6487;
			@Pc(488) byte local488 = Static146.aClass4_Sub12_Sub1_3.g1s_alt1();
			local202 = Static146.aClass4_Sub12_Sub1_3.g2s_alt1();
			@Pc(496) byte local496 = Static146.aClass4_Sub12_Sub1_3.g1s_alt2();
			local210 = Static146.aClass4_Sub12_Sub1_3.g2_alt3();
			local214 = Static146.aClass4_Sub12_Sub1_3.g2_alt3();
			@Pc(508) byte local508 = Static146.aClass4_Sub12_Sub1_3.g1s_alt2();
			if (!Static122.aClass19_16.method4243()) {
				Static208.method2249(local186, local12, local55, local496, local453, local202, local508, Static113.anInt2426, local488, local190, local214, local210, local49);
			}
		} else if (arg0 == Static405.aClass21_14) {
			local12 = Static146.aClass4_Sub12_Sub1_3.g1_alt1();
			local16 = local12 >> 2;
			local40 = local12 & 0x3;
			local49 = Static201.anIntArray410[local16];
			local55 = Static146.aClass4_Sub12_Sub1_3.g1_alt3();
			local126 = Static154.anInt813 + (local55 >> 4 & 0x7);
			local186 = (local55 & 0x7) + Static385.anInt6487;
			if (Static178.method2845(Static448.anInt7307) || local126 >= 0 && local186 >= 0 && Static326.anInt5666 > local126 && local186 < Static283.anInt5187) {
				Static145.method2449(local126, local16, -1, local49, local186, Static113.anInt2426, local40);
			}
		} else {
			@Pc(635) boolean local635;
			if (arg0 == Static38.aClass21_6) {
				local12 = Static146.aClass4_Sub12_Sub1_3.g1();
				local16 = Static154.anInt813 * 2 + (local12 >> 4 & 0xF);
				local40 = Static385.anInt6487 * 2 + (local12 & 0xF);
				local635 = Static146.aClass4_Sub12_Sub1_3.g1() != 0;
				local55 = Static146.aClass4_Sub12_Sub1_3.g1s() + local16;
				local126 = local40 + Static146.aClass4_Sub12_Sub1_3.g1s();
				local186 = Static146.aClass4_Sub12_Sub1_3.g2s();
				local190 = Static146.aClass4_Sub12_Sub1_3.g2s();
				local196 = Static146.aClass4_Sub12_Sub1_3.g2();
				@Pc(664) byte local664 = Static146.aClass4_Sub12_Sub1_3.g1s();
				local206 = Static146.aClass4_Sub12_Sub1_3.g1() * 4;
				local210 = Static146.aClass4_Sub12_Sub1_3.g2();
				local214 = Static146.aClass4_Sub12_Sub1_3.g2();
				local223 = Static146.aClass4_Sub12_Sub1_3.g1();
				if (local223 == 255) {
					local223 = -1;
				}
				@Pc(693) int local693 = Static146.aClass4_Sub12_Sub1_3.g1();
				if (local16 >= 0 && local40 >= 0 && local16 < Static326.anInt5666 * 2 && Static326.anInt5666 * 2 > local40 && local55 >= 0 && local126 >= 0 && local55 < Static283.anInt5187 * 2 && Static283.anInt5187 * 2 > local126 && local196 != 65535) {
					local55 = local55 * 64;
					local40 = local40 * 64;
					local126 = local126 * 64;
					local202 = local664 << 0;
					local206 <<= 0x0;
					local16 *= 64;
					if (local186 != 0) {
						@Pc(782) int local782;
						@Pc(793) Class16_Sub1_Sub5 local793;
						@Pc(772) int local772;
						@Pc(776) int local776;
						if (local186 < 0) {
							local772 = -local186 - 1;
							local776 = local772 & 0x7FF;
							local782 = local772 >> 11 & 0xF;
							if (Static207.anInt5452 == local776) {
								local793 = Static1.aClass16_Sub1_Sub5_Sub1_1;
							} else {
								local793 = Static267.aClass16_Sub1_Sub5_Sub1Array1[local776];
							}
						} else {
							local772 = local186 - 1;
							local782 = local772 >> 11 & 0xF;
							local776 = local772 & 0x7FF;
							local793 = Static143.aClass16_Sub1_Sub5_Sub2Array1[local776];
						}
						if (local793 != null) {
							@Pc(823) Class151 local823 = local793.method4757();
							if (local823.anIntArrayArray38 != null && local823.anIntArrayArray38[local782] != null) {
								local776 = local823.anIntArrayArray38[local782][0];
								@Pc(845) int local845 = local823.anIntArrayArray38[local782][2];
								@Pc(850) int local850 = local793.aClass35_7.method811();
								@Pc(854) int local854 = Class50_Sub1.anIntArray225[local850];
								@Pc(858) int local858 = Class50_Sub1.anIntArray224[local850];
								@Pc(868) int local868 = local845 * local854 + local776 * local858 >> 15;
								@Pc(878) int local878 = local845 * local858 - local854 * local776 >> 15;
								local16 += local868;
								local202 -= local823.anIntArrayArray38[local782][1];
								local40 += local878;
							}
						}
					}
					@Pc(918) Class16_Sub1_Sub3 local918 = new Class16_Sub1_Sub3(local196, Static113.anInt2426, local16, local40, local202, gameLogicStepCount + local210, local214 - -gameLogicStepCount, local223, local693, local190, local206, local635);
					local918.method2197(local210 + gameLogicStepCount, local55, Static13.method135(local55, Static113.anInt2426, local126) - local206, local126);
					Static27.aClass183_2.method4137(new SecondaryNode_Sub1_Sub7(local918));
				}
			} else if (arg0 == Static152.aClass21_9) {
				local12 = Static146.aClass4_Sub12_Sub1_3.g1();
				local16 = (local12 >> 4 & 0x7) + Static154.anInt813;
				local40 = Static385.anInt6487 + (local12 & 0x7);
				local49 = Static146.aClass4_Sub12_Sub1_3.g2();
				if (local49 == 65535) {
					local49 = -1;
				}
				local55 = Static146.aClass4_Sub12_Sub1_3.g1();
				local126 = local55 >> 4 & 0xF;
				local186 = local55 & 0x7;
				local190 = Static146.aClass4_Sub12_Sub1_3.g1();
				local196 = Static146.aClass4_Sub12_Sub1_3.g1();
				if (local16 >= 0 && local40 >= 0 && local16 < Static326.anInt5666 && Static283.anInt5187 > local40) {
					local202 = local126 + 1;
					if (Static1.aClass16_Sub1_Sub5_Sub1_1.anIntArray426[0] >= local16 - local202 && local202 + local16 >= Static1.aClass16_Sub1_Sub5_Sub1_1.anIntArray426[0] && local40 - local202 <= Static1.aClass16_Sub1_Sub5_Sub1_1.anIntArray427[0] && local40 + local202 >= Static1.aClass16_Sub1_Sub5_Sub1_1.anIntArray427[0]) {
						Static412.method5292(local196, local49, local190, local186, local126 + (local16 << 16) + (Static113.anInt2426 << 24) + (local40 << 8));
					}
				}
			} else if (arg0 == Static183.aClass21_12) {
				local12 = Static146.aClass4_Sub12_Sub1_3.g1();
				local16 = (local12 >> 4 & 0x7) + Static154.anInt813;
				local40 = (local12 & 0x7) + Static385.anInt6487;
				local49 = Static146.aClass4_Sub12_Sub1_3.g2();
				local55 = Static146.aClass4_Sub12_Sub1_3.g1();
				local126 = Static146.aClass4_Sub12_Sub1_3.g2();
				local186 = Static146.aClass4_Sub12_Sub1_3.g1();
				if (local16 >= 0 && local40 >= 0 && Static326.anInt5666 > local16 && Static283.anInt5187 > local40) {
					local190 = local16 * 128 + 64;
					local196 = local40 * 128 + 64;
					local202 = Static113.anInt2426;
					if (local202 < 3 && Static378.method3229(local16, local40)) {
						local202++;
					}
					@Pc(1186) Class16_Sub1_Sub2 local1186 = new Class16_Sub1_Sub2(local49, local126, gameLogicStepCount, Static113.anInt2426, local202, local190, Static13.method135(local190, Static113.anInt2426, local196) - local55, local196, local16, local16, local40, local40, local186);
					Static292.aClass183_36.method4137(new SecondaryNode_Sub1_Sub10(local1186));
				}
			} else if (Static106.aClass21_7 == arg0) {
				local12 = Static146.aClass4_Sub12_Sub1_3.g1();
				local16 = (local12 >> 4 & 0x7) + Static154.anInt813;
				local40 = Static385.anInt6487 + (local12 & 0x7);
				local49 = Static146.aClass4_Sub12_Sub1_3.g2();
				local55 = Static146.aClass4_Sub12_Sub1_3.g2();
				local126 = Static146.aClass4_Sub12_Sub1_3.g2();
				if (Static440.aHashMap_40 != null && local16 >= 0 && local40 >= 0 && Static326.anInt5666 > local16 && local40 < Static283.anInt5187) {
					@Pc(1265) Node_Sub18 local1265 = (Node_Sub18) Static440.aHashMap_40.get((long) (local16 | local40 << 14 | Static113.anInt2426 << 28));
					if (local1265 != null) {
						for (@Pc(1273) Node_Sub45 local1273 = (Node_Sub45) local1265.aClass183_14.method4140(); local1273 != null; local1273 = (Node_Sub45) local1265.aClass183_14.method4144()) {
							if (local1273.anInt7355 == (local49 & 0x7FFF) && local55 == local1273.anInt7356) {
								local1273.popSelf();
								local1273.anInt7356 = local126;
								Static28.method528(local1273, local16, local40, Static113.anInt2426);
								break;
							}
						}
						Static443.method5595(Static113.anInt2426, local16, local40);
					}
				}
			} else if (Static146.aClass21_2 == arg0) {
				local12 = Static146.aClass4_Sub12_Sub1_3.g1_alt3();
				local16 = local12 >> 2;
				local40 = local12 & 0x3;
				local49 = Static201.anIntArray410[local16];
				local55 = Static146.aClass4_Sub12_Sub1_3.g2_alt2();
				local126 = Static146.aClass4_Sub12_Sub1_3.g1_alt1();
				local186 = (local126 >> 4 & 0x7) + Static154.anInt813;
				local190 = Static385.anInt6487 + (local126 & 0x7);
				if (Static178.method2845(Static448.anInt7307) || local186 >= 0 && local190 >= 0 && Static326.anInt5666 > local186 && local190 < Static283.anInt5187) {
					Static145.method2449(local186, local16, local55, local49, local190, Static113.anInt2426, local40);
				}
			} else if (arg0 == Static35.aClass21_5) {
				local12 = Static146.aClass4_Sub12_Sub1_3.g2();
				if (local12 == 65535) {
					local12 = -1;
				}
				local16 = Static146.aClass4_Sub12_Sub1_3.g1_alt2();
				local40 = (local16 >> 4 & 0x7) + Static154.anInt813;
				local49 = Static385.anInt6487 + (local16 & 0x7);
				local55 = Static146.aClass4_Sub12_Sub1_3.g1_alt2();
				local126 = local55 >> 2;
				local186 = local55 & 0x3;
				local190 = Static201.anIntArray410[local126];
				Static297.method4071(Static113.anInt2426, local186, local12, local190, local126, local40, local49);
			} else if (Static410.aClass21_15 == arg0) {
				local12 = Static146.aClass4_Sub12_Sub1_3.g2();
				local16 = Static146.aClass4_Sub12_Sub1_3.g2();
				local40 = Static146.aClass4_Sub12_Sub1_3.g1_alt3();
				local49 = Static154.anInt813 + (local40 >> 4 & 0x7);
				local55 = (local40 & 0x7) + Static385.anInt6487;
				local126 = Static146.aClass4_Sub12_Sub1_3.g2_alt1();
				if (local49 >= 0 && local55 >= 0 && Static326.anInt5666 > local49 && Static283.anInt5187 > local55 && local16 != Static207.anInt5452) {
					Static28.method528(new Node_Sub45(local12, local126), local49, local55, Static113.anInt2426);
					Static443.method5595(Static113.anInt2426, local49, local55);
				}
			} else if (Static309.aClass21_13 == arg0) {
				local12 = Static146.aClass4_Sub12_Sub1_3.g1();
				local16 = (local12 >> 4 & 0xF) + Static154.anInt813 * 2;
				local40 = (local12 & 0xF) + Static385.anInt6487 * 2;
				local635 = Static146.aClass4_Sub12_Sub1_3.g1() != 0;
				local55 = Static146.aClass4_Sub12_Sub1_3.g1s() + local16;
				local126 = Static146.aClass4_Sub12_Sub1_3.g1s() + local40;
				local186 = Static146.aClass4_Sub12_Sub1_3.g2s();
				local190 = Static146.aClass4_Sub12_Sub1_3.g2();
				local196 = Static146.aClass4_Sub12_Sub1_3.g1() * 4;
				local202 = Static146.aClass4_Sub12_Sub1_3.g1() * 4;
				local206 = Static146.aClass4_Sub12_Sub1_3.g2();
				local210 = Static146.aClass4_Sub12_Sub1_3.g2();
				local214 = Static146.aClass4_Sub12_Sub1_3.g1();
				if (local214 == 255) {
					local214 = -1;
				}
				local223 = Static146.aClass4_Sub12_Sub1_3.g1();
				if (local16 >= 0 && local40 >= 0 && local16 < Static326.anInt5666 * 2 && local40 < Static326.anInt5666 * 2 && local55 >= 0 && local126 >= 0 && local55 < Static283.anInt5187 * 2 && local126 < Static283.anInt5187 * 2 && local190 != 65535) {
					local126 *= 64;
					local202 <<= 0x0;
					local40 = local40 * 64;
					local16 *= 64;
					local55 *= 64;
					local196 <<= 0x0;
					local309 = new Class16_Sub1_Sub3(local190, Static113.anInt2426, local16, local40, local196, gameLogicStepCount + local206, local210 - -gameLogicStepCount, local214, local223, local186, local202, local635);
					local309.method2197(local206 + gameLogicStepCount, local55, Static13.method135(local55, Static113.anInt2426, local126) - local202, local126);
					Static27.aClass183_2.method4137(new SecondaryNode_Sub1_Sub7(local309));
				}
			} else {
				Static94.handleClientError(null, "T3 - " + arg0);
				Static251.method3639();
			}
		}
	}

	@OriginalMember(owner = "client!hp", name = "d", descriptor = "(I)J")
	public static long method2607() {
		return aFrameTimer_1.method2252();
	}

	@OriginalMember(owner = "client!client", name = "i", descriptor = "(I)V")
	private void js5connect() {
		if (js5NetQueue.js5ConnectAttempts > previousJS5ConnectionAttepts) {
			connectionRetrySkipIterations = (js5NetQueue.js5ConnectAttempts * 50 - 50) * 5;

			if (port == primaryServerPort) {
				port = fallbackServerPort;
			} else {
				port = primaryServerPort;
			}

			if (connectionRetrySkipIterations > 3000) {
				connectionRetrySkipIterations = 3000;
			}

			if (js5NetQueue.js5ConnectAttempts >= 2 && js5NetQueue.errorCode == 6) {
				this.handleGameError("js5connect_outofdate");

				Static403.anInt6667 = 1000;

				return;
			}

			if (js5NetQueue.js5ConnectAttempts >= 4 && js5NetQueue.errorCode == -1) {
				this.handleGameError("js5crc");

				Static403.anInt6667 = 1000;

				return;
			}

			if (js5NetQueue.js5ConnectAttempts >= 4 && (Static403.anInt6667 == 0 || Static403.anInt6667 == 5)) {
				if (js5NetQueue.errorCode == 7 || js5NetQueue.errorCode == 9) {
					this.handleGameError("js5connect_full");
				} else if (js5NetQueue.errorCode <= 0) {
					this.handleGameError("js5io");
				} else {
					this.handleGameError("js5connect");
				}

				Static403.anInt6667 = 1000;

				return;
			}
		}

		previousJS5ConnectionAttepts = js5NetQueue.js5ConnectAttempts;

		if (connectionRetrySkipIterations > 0) {
			connectionRetrySkipIterations--;
			return;
		}

		try {
			if (js5ConnectionStage == 0) {
				connectionInitializationMessage = GameShell.signLink.emitConnectionInitializationMessage(host, port);

				js5ConnectionStage++;
			}

			if (js5ConnectionStage == 1) {
				if (connectionInitializationMessage.status == 2) {
					this.signalJS5ConnectionFailedWithErrorCode(1000);

					return;
				}
				if (connectionInitializationMessage.status == 1) {
					js5ConnectionStage++;
				}
			}

			if (js5ConnectionStage == 2) {
				serverConnection = new ServerConnection((Socket) connectionInitializationMessage.output, GameShell.signLink);

				@Pc(194) Packet connectionInitializationPacket = new Packet(5);
				connectionInitializationPacket.p1(Class60.aClass60_2.anInt1812);
				connectionInitializationPacket.p4(592);

				serverConnection.write(5, connectionInitializationPacket.data);

				js5ConnectionStage++;

				connectionInitializationTimestamp = MonotonicClock.getCurrentTimeInMilliseconds();
			}

			if (js5ConnectionStage == 3) {
				if (Static403.anInt6667 == 0 || Static403.anInt6667 == 5 || serverConnection.getEstimatedBytesAvailable() > 0) {
					@Pc(259) int response = serverConnection.readByteFromServer();

					if (response != 0) {
						this.signalJS5ConnectionFailedWithErrorCode(response);

						return;
					}

					js5ConnectionStage++;
				} else if (MonotonicClock.getCurrentTimeInMilliseconds() - connectionInitializationTimestamp > 30000L) {
					this.signalJS5ConnectionFailedWithErrorCode(1001);

					return;
				}
			}

			if (js5ConnectionStage == 4) {
				@Pc(293) boolean local293 = Static403.anInt6667 == 5 || Static403.anInt6667 == 10 || Static403.anInt6667 == 28;

				js5NetQueue.init(serverConnection, !local293);

				connectionInitializationMessage = null;
				js5ConnectionStage = 0;
				serverConnection = null;
			}
		} catch (@Pc(312) IOException e) {
			this.signalJS5ConnectionFailedWithErrorCode(1002);
		}
	}

	@OriginalMember(owner = "client!client", name = "e", descriptor = "(I)V")
	@Override
	protected void method886() {
		if (Static135.aBoolean256) {
			Static316.method4216();
		}

		if (Static122.aClass19_16 != null) {
			Static122.aClass19_16.method4267();
		}

		if (GameShell.fullScreenFrame != null) {
			FullScreenWindow.exitFullScreenMode(GameShell.signLink, GameShell.fullScreenFrame);
			GameShell.fullScreenFrame = null;
		}

		if (Static125.aServerConnection_5 != null) {
			Static125.aServerConnection_5.shutdown();
			Static125.aServerConnection_5 = null;
		}

		if (Static223.aClass14_1 != null) {
			Static223.aClass14_1.method213(GameShell.canvas);
		}

		Static223.aClass14_1 = null;

		Static64.method1241();
		js5NetQueue.shutdown();
		aJs5DiskCache_3.method5433();

		if (Static402.aClass256_1 != null) {
			Static402.aClass256_1.method5475();
			Static402.aClass256_1 = null;
		}
	}

	@OriginalMember(owner = "client!client", name = "j", descriptor = "(I)V")
	private void graphicsStep() {
		if (Static403.anInt6667 == 1000) {
			return;
		}
		@Pc(19) long local19 = method2607() / 1000000L - Static153.aLong107;
		Static153.aLong107 = method2607() / 1000000L;
		@Pc(27) boolean local27 = Static303.method4111();
		if (local27 && Static436.aBoolean666 && Static424.aClass49_2 != null) {
			Static424.aClass49_2.method2064();
		}
		if (Static403.anInt6667 == 30 || Static403.anInt6667 == 10) {
			if (Static453.aLong223 != 0L && MonotonicClock.getCurrentTimeInMilliseconds() > Static453.aLong223) {
				Static188.method4107(Static450.method5664(), Static323.aClass50_Sub1_1.anInt3450, Static323.aClass50_Sub1_1.anInt3431, false);
			} else if (!Static122.aClass19_16.method4258() && Static84.aBoolean383) {
				Static349.method4711();
			}
		}
		@Pc(98) int local98;
		@Pc(102) int local102;
		if (GameShell.fullScreenFrame == null) {
			@Pc(89) Container local89;
			if (GameShell.frame == null) {
				local89 = GameShell.signLink.hostApplet;
			} else {
				local89 = GameShell.frame;
			}
			local98 = local89.getSize().width;
			local102 = local89.getSize().height;
			if (local89 == GameShell.frame) {
				@Pc(108) Insets local108 = GameShell.frame.getInsets();
				local102 -= local108.bottom + local108.top;
				local98 -= local108.left + local108.right;
			}
			if (local98 != Static425.anInt7000 || Static17.anInt222 != local102) {
				if (Static122.aClass19_16 == null || Static122.aClass19_16.method4245()) {
					method3938();
				} else {
					Static17.anInt222 = local102;
					Static425.anInt7000 = local98;
				}
				Static453.aLong223 = MonotonicClock.getCurrentTimeInMilliseconds() + 500L;
			}
		}
		if (GameShell.fullScreenFrame != null && !Static265.aBoolean457 && (Static403.anInt6667 == 30 || Static403.anInt6667 == 10)) {
			Static188.method4107(Static323.aClass50_Sub1_1.anInt3447, -1, -1, false);
		}
		@Pc(176) boolean local176 = false;
		if (GameShell.aBoolean189) {
			GameShell.aBoolean189 = false;
			local176 = true;
		}
		if (local176) {
			Static348.method4697();
		}
		if (Static122.aClass19_16 != null && Static122.aClass19_16.method4258() || Static450.method5664() != 1) {
			Static369.method4940();
		}
		if (Static403.anInt6667 == 0) {
			GameShell.initializeClientLoadingBox(Static171.aColorArray5[ClientSettings.colourID], Static164.aColorArray6[ClientSettings.colourID], Static64.aColorArray3[ClientSettings.colourID], Static247.anInt4590, local176, Static24.aString53);
		} else if (Static403.anInt6667 == 5) {
			Static260.method3773(Static164.aColorArray6[ClientSettings.colourID].getRGB(), local176 | Static122.aClass19_16.method4258(), Static64.aColorArray3[ClientSettings.colourID].getRGB(), Static171.aColorArray5[ClientSettings.colourID].getRGB(), Static331.aClass46_10, Static122.aClass19_16);
		} else if (Static403.anInt6667 == 10) {
			Static298.method4085();
		} else if (Static403.anInt6667 == 25 || Static403.anInt6667 == 28) {
			if (Static51.anInt883 == 1) {
				if (Static100.anInt2020 > Static26.anInt448) {
					Static26.anInt448 = Static100.anInt2020;
				}
				local98 = (Static26.anInt448 - Static100.anInt2020) * 50 / Static26.anInt448;
				Static436.method5519(true, Static439.A_LOCALIZED_STRING___148.getLocalizedString(ClientSettings.langID) + "<br>(" + local98 + "%)", Static207.aClass46_9);
			} else if (Static51.anInt883 == 2) {
				if (Static444.anInt7298 < Static275.anInt5144) {
					Static444.anInt7298 = Static275.anInt5144;
				}
				local98 = (Static444.anInt7298 - Static275.anInt5144) * 50 / Static444.anInt7298 + 50;
				Static436.method5519(true, Static439.A_LOCALIZED_STRING___148.getLocalizedString(ClientSettings.langID) + "<br>(" + local98 + "%)", Static207.aClass46_9);
			} else {
				Static436.method5519(true, Static439.A_LOCALIZED_STRING___148.getLocalizedString(ClientSettings.langID), Static207.aClass46_9);
			}
		} else if (Static403.anInt6667 == 30) {
			Static45.method764(local19);
		} else if (Static403.anInt6667 == 40) {
			Static436.method5519(true, Static444.A_LOCALIZED_STRING___150.getLocalizedString(ClientSettings.langID) + "<br>" + Static168.A_LOCALIZED_STRING___69.getLocalizedString(ClientSettings.langID), Static207.aClass46_9);
		}
		if (Static293.anInt5286 == 3) {
			for (local98 = 0; local98 < Static229.anInt4407; local98++) {
				@Pc(394) Rectangle local394 = Node_Sub6_Sub23.aRectangleArray1[local98];
				if (Static65.aBooleanArray9[local98]) {
					Static122.aClass19_16.method4293(local394.x, local394.width, local394.y, -1996553985, local394.height);
				} else if (Static263.aBooleanArray15[local98]) {
					Static122.aClass19_16.method4293(local394.x, local394.width, local394.y, -1996554240, local394.height);
				}
			}
		}
		if (Static426.method5440()) {
			Static433.method5498(Static122.aClass19_16);
		}
		if ((Static403.anInt6667 == 30 || Static403.anInt6667 == 10) && Static293.anInt5286 == 0 && Static450.method5664() == 1 && !local176 && SignLink.javaVersion.equals("1.1")) {
			local98 = 0;
			for (local102 = 0; local102 < Static229.anInt4407; local102++) {
				if (Static263.aBooleanArray15[local102]) {
					Static263.aBooleanArray15[local102] = false;
					Static367.aRectangleArray2[local98++] = Node_Sub6_Sub23.aRectangleArray1[local102];
				}
			}
			Static122.aClass19_16.method4290(Static367.aRectangleArray2, local98);
		} else if (Static403.anInt6667 != 0) {
			Static122.aClass19_16.method4247();
			for (local98 = 0; local98 < Static229.anInt4407; local98++) {
				Static263.aBooleanArray15[local98] = false;
			}
		}
		if (Static323.aClass50_Sub1_1.anInt3437 == 0) {
			ThreadingUtilities.sleepFor(15L);
		} else if (Static323.aClass50_Sub1_1.anInt3437 == 1) {
			ThreadingUtilities.sleepFor(10L);
		} else if (Static323.aClass50_Sub1_1.anInt3437 == 2) {
			ThreadingUtilities.sleepFor(5L);
		} else if (Static323.aClass50_Sub1_1.anInt3437 == 3) {
			ThreadingUtilities.sleepFor(2L);
		}
		if (Static9.aBoolean10) {
			Static198.method3117();
		}
		if (Static323.aClass50_Sub1_1.aBoolean297 && Static403.anInt6667 == 10 && Static334.anInt5766 != -1) {
			Static323.aClass50_Sub1_1.aBoolean297 = false;
			Static323.aClass50_Sub1_1.method2856(GameShell.signLink);
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(B)V")
	@Override
	protected void runGameLogicStep() {
		try {
			this.gameLogicStep();
		} catch (OutOfMemoryError e) {
			if (e.getMessage() == null || !e.getMessage().startsWith("native")) {
				throw e;
			}

			Static239.method3551(0);

			Static94.handleClientError(e, e.getMessage() + " (Recovered) " + this.getErrorContext());
		}
	}

	@OriginalMember(owner = "client!client", name = "e", descriptor = "(B)Ljava/lang/String;")
	@Override
	protected String getErrorContext() {
		@Pc(5) String local5 = null;
		try {
			local5 = "[1)" + Static180.anInt3453 + "," + Static86.anInt1771 + "," + Static326.anInt5666 + "," + Static283.anInt5187 + "|";
			if (Static1.aClass16_Sub1_Sub5_Sub1_1 != null) {
				local5 = local5 + "2)" + Static263.anInt4963 + "," + (Static180.anInt3453 + Static1.aClass16_Sub1_Sub5_Sub1_1.anIntArray426[0]) + "," + (Static1.aClass16_Sub1_Sub5_Sub1_1.anIntArray427[0] + Static86.anInt1771) + "|";
			}
			local5 = local5 + "3)" + Static177.anInt2973 + "|4)" + Static323.aClass50_Sub1_1.anInt3440 + "|5)" + Static450.method5664() + "|6)" + Static141.width + "," + Static302.height + "|";
			local5 = local5 + "7)" + Static323.aClass50_Sub1_1.method2854(Static177.anInt2973) + "|";
			local5 = local5 + "8)" + Static323.aClass50_Sub1_1.method2850(Static177.anInt2973) + "|";
			local5 = local5 + "9)" + Static323.aClass50_Sub1_1.aBoolean294 + "|";
			local5 = local5 + "10)" + Static323.aClass50_Sub1_1.aBoolean307 + "|";
			local5 = local5 + "11)" + Static323.aClass50_Sub1_1.aBoolean300 + "|";
			local5 = local5 + "12)" + Static323.aClass50_Sub1_1.method2861(Static177.anInt2973) + "|";
			local5 = local5 + "13)" + Static70.anInt1503 + "|";
			try {
				local5 = local5 + "|15)" + jagmisc.getTotalPhysicalMemory();
			} catch (@Pc(212) Throwable local212) {
			}
			local5 = local5 + "]";
		} catch (@Pc(223) Throwable local223) {
		}
		return local5;
	}

	@OriginalMember(owner = "client!client", name = "l", descriptor = "(I)V")
	private void method897() {
		Static176.anInt3414++;
		Static361.method4870(-1, null, -1);
		Static40.method697(null, -1, -1);
		Static164.method3582();
		Static325.anInt5640++;
		for (@Pc(31) int local31 = 0; local31 < 32768; local31++) {
			@Pc(37) Class16_Sub1_Sub5_Sub2 local37 = Static143.aClass16_Sub1_Sub5_Sub2Array1[local31];
			if (local37 != null) {
				@Pc(43) byte local43 = local37.aClass264_1.aByte99;
				if ((local43 & 0x1) != 0) {
					@Pc(51) int local51 = local37.method4751();
					@Pc(78) int local78;
					if ((local43 & 0x2) != 0 && local37.anInt6086 == 0 && Math.random() * 1000.0D < 10.0D) {
						local78 = (int) Math.round(Math.random() * 10.0D - 5.0D);
						@Pc(86) int local86 = (int) Math.round(Math.random() * 10.0D - 5.0D);
						if (local78 != 0 || local86 != 0) {
							@Pc(101) int local101 = local37.anIntArray426[0] + local78;
							if (local101 < 0) {
								local101 = 0;
							} else if (Static326.anInt5666 - local51 - 1 < local101) {
								local101 = Static326.anInt5666 - local51 - 1;
							}
							@Pc(136) int local136 = local37.anIntArray427[0] + local86;
							if (local136 < 0) {
								local136 = 0;
							} else if (local136 > Static283.anInt5187 - local51 - 1) {
								local136 = Static283.anInt5187 - local51 - 1;
							}
							@Pc(183) int local183 = Static6.method49(Static175.aClass213Array1[local37.aByte82], local37.anIntArray426[0], local101, local51, local136, local51, 0, Static33.anIntArray36, 0, true, Static392.anIntArray498, local37.anIntArray427[0], local51, -1);
							if (local183 > 0) {
								if (local183 > 9) {
									local183 = 9;
								}
								for (@Pc(195) int local195 = 0; local195 < local183; local195++) {
									local37.anIntArray426[local195] = Static392.anIntArray498[local183 - local195 - 1];
									local37.anIntArray427[local195] = Static33.anIntArray36[local183 - local195 - 1];
									local37.aByteArray84[local195] = 1;
								}
								local37.anInt6086 = local183;
							}
						}
					}
					Static395.method5163(true, local37);
					local78 = Static141.method2424(local37);
					Static447.method5628(local37, Static249.anInt4620, Static82.anInt1655, local78);
					Static371.method4959(local37);
				}
			}
		}
		if (Static238.anInt4506 == 0 && Static354.anInt6183 == 0) {
			if (Static111.anInt2386 == 2) {
				Static329.method4430();
			} else {
				Static294.method514();
			}
			if (Static163.anInt3197 >> 7 < 14 || Static326.anInt5666 - 14 <= Static163.anInt3197 >> 7 || Static145.anInt2906 >> 7 < 14 || Static145.anInt2906 >> 7 >= Static283.anInt5187 - 14) {
				Static63.method1134();
			}
		}
		while (true) {
			@Pc(311) Node_Sub34 local311;
			@Pc(316) Class247 local316;
			@Pc(327) Class247 local327;
			do {
				local311 = (Node_Sub34) Static237.aClass183_52.method4136();
				if (local311 == null) {
					while (true) {
						do {
							local311 = (Node_Sub34) Static39.aClass183_3.method4136();
							if (local311 == null) {
								while (true) {
									do {
										local311 = (Node_Sub34) Static291.aClass183_35.method4136();
										if (local311 == null) {
											if (Static281.aClass247_12 != null) {
												Static1.method3();
											}
											if (gameLogicStepCount % 1500 == 0) {
												Static343.method744();
											}
											Static375.method4999();
											if (Static135.aBoolean256 && MonotonicClock.getCurrentTimeInMilliseconds() - 60000L > Static174.aLong119) {
												Static316.method4216();
												return;
											}
											return;
										}
										local316 = local311.aClass247_15;
										if (local316.anInt6865 < 0) {
											break;
										}
										local327 = Static392.method5121(local316.anInt6850);
									} while (local327 == null || local327.aClass247Array2 == null || local316.anInt6865 >= local327.aClass247Array2.length || local316 != local327.aClass247Array2[local316.anInt6865]);
									Static271.method3894(local311);
								}
							}
							local316 = local311.aClass247_15;
							if (local316.anInt6865 < 0) {
								break;
							}
							local327 = Static392.method5121(local316.anInt6850);
						} while (local327 == null || local327.aClass247Array2 == null || local327.aClass247Array2.length <= local316.anInt6865 || local316 != local327.aClass247Array2[local316.anInt6865]);
						Static271.method3894(local311);
					}
				}
				local316 = local311.aClass247_15;
				if (local316.anInt6865 < 0) {
					break;
				}
				local327 = Static392.method5121(local316.anInt6850);
			} while (local327 == null || local327.aClass247Array2 == null || local327.aClass247Array2.length <= local316.anInt6865 || local327.aClass247Array2[local316.anInt6865] != local316);
			Static271.method3894(local311);
		}
	}

	@OriginalMember(owner = "client!client", name = "m", descriptor = "(I)V")
	private void gameLogicStep() {
		if (Static403.anInt6667 == 1000) {
			return;
		}

		gameLogicStepCount++;

		if (gameLogicStepCount % 1000 == 1) {
			@Pc(24) GregorianCalendar gregorianCalendar = new GregorianCalendar();
			Static239.randomSeed = gregorianCalendar.get(Calendar.HOUR_OF_DAY) * 600 + gregorianCalendar.get(Calendar.MINUTE) * 10 + gregorianCalendar.get(Calendar.SECOND) / 6;
			Static325.random.setSeed(Static239.randomSeed);
		}
		if (gameLogicStepCount % 50 == 0) {
			Static449.anInt7316 = Static60.anInt1097;
			Static55.anInt1020 = Static138.anInt2826;
			Static60.anInt1097 = 0;
			Static138.anInt2826 = 0;
		}
		this.method912();
		if (Static94.aClass159_1 != null) {
			Static94.aClass159_1.method3819();
		}
		Static225.method3438();
		Static384.aClass244_1.method5487();
		Static420.aClass80_1.method2236();
		if (Static223.aClass14_1 != null) {
			@Pc(85) int local85 = Static223.aClass14_1.method212();
			Static430.anInt3862 = local85;
		}
		if (Static122.aClass19_16 != null) {
			Static122.aClass19_16.method4246((int) MonotonicClock.getCurrentTimeInMilliseconds());
		}
		Static201.method4605();
		Static190.anInt3602 = 0;
		for (@Pc(106) Class30 local106 = Static384.aClass244_1.method5483(); local106 != null && Static190.anInt3602 < 128; local106 = Static384.aClass244_1.method5483()) {
			if (local106.method745() != 1) {
				@Pc(119) char local119 = local106.method749();
				if (!areModeratorPrivilegesAvailable() || local119 != '`' && local119 != '§') {
					Static164.aClass30Array4[Static190.anInt3602] = local106;
					Static190.anInt3602++;
				} else if (Static426.method5440()) {
					Static433.method5500();
				} else {
					method3806();
				}
			}
		}
		for (@Pc(168) Node_Sub5 local168 = Static420.aClass80_1.method2232(); local168 != null; local168 = Static420.aClass80_1.method2232()) {
			@Pc(174) int local174 = local168.method515();
			if (local174 == -1) {
				Static348.aClass183_42.method4137(local168);
			} else if (Static105.method1981(local174)) {
				Static413.aClass183_47.method4137(local168);
			}
			if (Static413.aClass183_47.method4148() > 10) {
				Static413.aClass183_47.method4136();
			}
		}
		if (Static426.method5440()) {
			Static213.method3223();
		}
		if (Static403.anInt6667 == 0) {
			this.loadClientAssets();
			GameShell.method3660();
		} else if (Static403.anInt6667 == 5) {
			this.loadClientAssets();
			GameShell.method3660();
		} else if (Static403.anInt6667 == 25 || Static403.anInt6667 == 28) {
			method3275();
		}
		if (Static403.anInt6667 == 10) {
			this.method897();
			method5090();
			method3510();
			method5430();
		} else if (Static403.anInt6667 == 30) {
			method4042();
		} else if (Static403.anInt6667 == 40) {
			method5430();
			if (Static296.anInt5302 != -3 && Static296.anInt5302 != 2 && Static296.anInt5302 != 15) {
				Static251.method3639();
			}
		}
		Static79.method1400(Static122.aClass19_16);
		Static413.aClass183_47.method4136();
	}

	@OriginalMember(owner = "client!client", name = "init", descriptor = "()V")
	@Override
	public void init() {
		if (!this.isValidHost()) {
			return;
		}

		ClientSettings.worldID = Integer.parseInt(this.getParameter("worldid"));
		ClientSettings.modewhere = ModeWhere.fromId(Integer.parseInt(this.getParameter("modewhere"))).orElse(ModeWhere.LIVE);
		ClientSettings.modewhat = ModeWhat.fromId(Integer.parseInt(this.getParameter("modewhat"))).orElse(ModeWhat.LIVE);

		try {
			ClientSettings.langID = Integer.parseInt(this.getParameter("lang"));
		} catch (@Pc(56) Exception e) {
			ClientSettings.langID = 0;
		}

		@Pc(62) String objecttagParameter = this.getParameter("objecttag");
        ClientSettings.hasObjectTag = objecttagParameter != null && objecttagParameter.equals("1");

		@Pc(78) String jsParameter = this.getParameter("js");
        ClientSettings.hasJS = jsParameter != null && jsParameter.equals("1");

		@Pc(94) String advertParameter = this.getParameter("advert");
        ClientSettings.hasAdvert = advertParameter != null && advertParameter.equals("1");

		@Pc(110) String gameId = this.getParameter("game");

		ClientSettings.modeGame = ModeGame.fromGameId(gameId).orElse(ModeGame.RUNESCAPE);

		try {
			ClientSettings.affiliateID = Integer.parseInt(this.getParameter("affid"));
		} catch (@Pc(129) Exception local129) {
			ClientSettings.affiliateID = 0;
		}

		ClientSettings.quitURL = this.getParameter("quiturl");
		ClientSettings.settings = this.getParameter("settings");

		if (ClientSettings.settings == null) {
			ClientSettings.settings = "";
		}

		@Pc(147) String countryParameter = this.getParameter("country");

		if (countryParameter != null) {
			try {
				ClientSettings.countryID = Integer.parseInt(countryParameter);
			} catch (@Pc(154) Exception e) {
				ClientSettings.countryID = 0;
			}
		}

		ClientSettings.colourID = Integer.parseInt(this.getParameter("colourid"));

		if (ClientSettings.colourID < 0 || Static64.aColorArray3.length <= ClientSettings.colourID) {
			ClientSettings.colourID = 0;
		}

		if (Integer.parseInt(this.getParameter("sitesettings_member")) == 1) {
			ClientSettings.aBoolean573 = true;
			ClientSettings.aBoolean423 = true;
		}

		Static6.client = this;

		if (ClientSettings.modeGame.isRunescape()) {
			ClientSettings.width = 765;
			ClientSettings.height = 503;
		} else if (ClientSettings.modeGame.isStellarDawn()) {
			ClientSettings.height = 480;
			ClientSettings.width = 640;
		}

		this.load(ClientSettings.modewhat.getId() + 32, ClientSettings.height, ClientSettings.width);
	}

	@OriginalMember(owner = "client!client", name = "g", descriptor = "(I)V")
	@Override
	protected void runGraphicsStep() {
		try {
			this.graphicsStep();
		} catch (@Pc(13) OutOfMemoryError local13) {
			if (local13.getMessage() == null || !local13.getMessage().startsWith("native")) {
				throw local13;
			}
			Static239.method3551(0);
			Static94.handleClientError(local13, local13.getMessage() + " (Recovered) " + this.getErrorContext());
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(Z)V")
	@Override
	protected void method880() {
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(II)V")
	private void signalJS5ConnectionFailedWithErrorCode(@OriginalArg(1) int errorCode) {
		serverConnection = null;
		connectionInitializationMessage = null;

		js5NetQueue.js5ConnectAttempts++;
		js5NetQueue.errorCode = errorCode;
		js5ConnectionStage = 0;
	}

	@OriginalMember(owner = "client!client", name = "d", descriptor = "(I)V")
	@Override
	protected void method883() {
		@Pc(10) Frame frame = new Frame("Jagex");

		frame.pack();
		frame.dispose();

		method3938();

		aJs5DiskCache_3 = new Js5DiskCache(GameShell.signLink);
		js5NetQueue = new Js5NetQueue();

		if (!ClientSettings.modewhere.isLive()) {
			Static392.aByteArrayArray28 = new byte[50][];
		}

		Static323.aClass50_Sub1_1 = new Class50_Sub1(GameShell.signLink);

		if (ClientSettings.modewhere.isLive()) {
			Static13.host = this.getCodeBase().getHost();
			Static133.JS5Port = 43594;
			Static11.HTTPPort = 443;
		} else if (ClientSettings.modewhere.isStagingEnvironment()) {
			Static13.host = this.getCodeBase().getHost();
			Static133.JS5Port = ClientSettings.worldID + 40000;
			Static11.HTTPPort = ClientSettings.worldID + 50000;
		} else if (ClientSettings.modewhere.isLocal()) {
			Static133.JS5Port = ClientSettings.worldID + 40000;
			Static13.host = "127.0.0.1";
			Static11.HTTPPort = ClientSettings.worldID + 50000;
		}

		Static313.anInt5435 = Static133.JS5Port;
		host = Static13.host;

		fallbackServerPort = Static11.HTTPPort;
		primaryServerPort = Static133.JS5Port;

		if (SignLink.anInt1987 == 3) {
			Static56.anInt1028 = ClientSettings.worldID;
		}

		Static252.aShortArray151 = Static330.aShortArray196 = Static78.aShortArray46 = Static166.aShortArray97 = new short[256];

		if (ClientSettings.modeGame.isRunescape()) {
			Static15.aShortArrayArray1 = Static78.aShortArrayArray4;
			Static299.aShortArray179 = Static240.aShortArray251;
			Static65.anInt1369 = 16777215;
			Static317.anInt5521 = 0;
			Static434.isShiftClickEnabled = true;
			Static434.aShortArray252 = Static70.aShortArray43;
			Static26.aShortArrayArray2 = Static84.aShortArrayArray8;
		} else {
			Static26.aShortArrayArray2 = Static70.aShortArrayArray3;
			Static15.aShortArrayArray1 = Static108.aShortArrayArray6;
			Static434.aShortArray252 = Static293.aShortArray175;
			Static299.aShortArray179 = Static354.aShortArray210;
		}

		port = Static313.anInt5435;
		Static384.aClass244_1 = Static140.method2398(GameShell.canvas);
		Static420.aClass80_1 = Static376.method4882(GameShell.canvas);
		Static223.aClass14_1 = Static328.method4424();

		if (Static223.aClass14_1 != null) {
			Static223.aClass14_1.method209(GameShell.canvas);
		}

		Static96.anInt1932 = SignLink.anInt1987;

		try {
			if (GameShell.signLink.cacheDataFile != null) {
				Static88.aClass139_1 = new Class139(GameShell.signLink.cacheDataFile, 5200, 0);

				for (@Pc(169) int i = 0; i < 30; i++) {
					Static86.aClass139Array1[i] = new Class139(GameShell.signLink.cacheArchiveFiles[i], 6000, 0);
				}

				Static425.aClass139_5 = new Class139(GameShell.signLink.cacheIndex255, 6000, 0);
				Static225.aClass222_2 = new Class222(255, Static88.aClass139_1, Static425.aClass139_5, 500000);
				Static394.aClass139_4 = new Class139(GameShell.signLink.randomFile, 24, 0);
				GameShell.signLink.cacheIndex255 = null;
				GameShell.signLink.randomFile = null;
				GameShell.signLink.cacheDataFile = null;
				GameShell.signLink.cacheArchiveFiles = null;
			}
		} catch (@Pc(227) IOException local227) {
			Static394.aClass139_4 = null;
			Static88.aClass139_1 = null;
			Static225.aClass222_2 = null;
			Static425.aClass139_5 = null;
		}

		if (!ClientSettings.modewhere.isLive()) {
			Static325.isFPSMonitorActive = true;
		}

		gameNameIsLoadingPleaseWaitMessage = (
			ClientSettings.modeGame.isRunescape()
				? Static268.runescapeIsLoadingPleaseWaitLocalizedString
				: Static374.stellarDawnIsLoadingPleaseWaitLocalizedString
		).getLocalizedString(ClientSettings.langID);
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "([BB)V")
	private void method908(@OriginalArg(0) byte[] arg0) {
		@Pc(10) Packet local10 = new Packet(arg0);
		while (true) {
			@Pc(18) int local18;
			@Pc(42) int local42;
			@Pc(37) int local37;
			label45: do {
				while (true) {
					while (true) {
						local18 = local10.g1();
						if (local18 == 0) {
							return;
						}
						if (local18 == 1) {
							@Pc(106) int[] local106 = Static382.anIntArray491 = new int[6];
							local106[0] = local10.g2();
							local106[1] = local10.g2();
							local106[2] = local10.g2();
							local106[3] = local10.g2();
							local106[4] = local10.g2();
							local106[5] = local10.g2();
						} else {
							if (local18 != 4) {
								continue label45;
							}
							local37 = local10.g1();
							Static290.anIntArray490 = new int[local37];
							for (local42 = 0; local42 < local37; local42++) {
								Static290.anIntArray490[local42] = local10.g2();
								if (Static290.anIntArray490[local42] == 65535) {
									Static290.anIntArray490[local42] = -1;
								}
							}
						}
					}
				}
			} while (local18 != 5);
			local37 = local10.g1();
			Static171.anIntArray217 = new int[local37];
			for (local42 = 0; local42 < local37; local42++) {
				Static171.anIntArray217[local42] = local10.g2();
				if (Static171.anIntArray217[local42] == 65535) {
					Static171.anIntArray217[local42] = -1;
				}
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "p", descriptor = "(I)V")
	private void loadClientAssets() {
		@Pc(10) int local10;
		if (!Static323.aClass50_Sub1_1.aBoolean297) {
			for (local10 = 0; local10 < Static190.anInt3602; local10++) {
				if (Static164.aClass30Array4[local10].method749() == 's' || Static164.aClass30Array4[local10].method749() == 'S') {
					Static323.aClass50_Sub1_1.aBoolean297 = true;
					break;
				}
			}
		}

		if (anInt5 == 0) {
			Runtime local47 = Runtime.getRuntime();
			int totalUtilizedMemoryBytes = (int) ((local47.totalMemory() - local47.freeMemory()) / 1024L);
			long currentTimeInMilliseconds = MonotonicClock.getCurrentTimeInMilliseconds();

			if (firstLoadClientAssetsTimestamp == 0L) {
				firstLoadClientAssetsTimestamp = currentTimeInMilliseconds;
			}

			if (totalUtilizedMemoryBytes > 16384 && currentTimeInMilliseconds - firstLoadClientAssetsTimestamp < 5000L) {
				if (currentTimeInMilliseconds - lastGarbageCollectionRequestTimestamp > 1000L) {
					System.gc();
					lastGarbageCollectionRequestTimestamp = currentTimeInMilliseconds;
				}

				Static24.aString53 = allocatingMemoryLocalizedString.getLocalizedString(ClientSettings.langID);
				Static247.anInt4590 = 5;
			} else {
				Static24.aString53 = allocatedMemoryLocalizedString.getLocalizedString(ClientSettings.langID);
				anInt5 = 10;
				Static247.anInt4590 = 5;
			}
		} else if (anInt5 == 10) {
			for (int i = 0; i < 4; i++) {
				Static175.aClass213Array1[i] = Static446.method5622(Static283.anInt5187, Static326.anInt5666);
			}

			Static24.aString53 = createdGameWorldLocalizedString.getLocalizedString(ClientSettings.langID);
			Static247.anInt4590 = 10;
			anInt5 = 20;
		} else if (anInt5 == 20) {
			if (Static94.aClass159_1 == null) {
				Static94.aClass159_1 = new Class159(js5NetQueue, aJs5DiskCache_3);
			}
			if (Static94.aClass159_1.isReady()) {
				Static395.aClass76_92 = Static265.method3820(false, 0, true);
				Static324.aClass76_69 = Static265.method3820(false, 1, true);
				Static74.aClass76_20 = Static265.method3820(false, 2, true);
				Static256.aClass76_50 = Static265.method3820(false, 3, true);
				Static67.aClass76_19 = Static265.method3820(false, 4, true);
				Static49.aClass76_27 = Static265.method3820(true, 5, true);
				Static46.aClass76_54 = Static265.method3820(true, 6, false);
				Static357.aClass76_82 = Static265.method3820(false, 7, true);
				Static293.aClass76_60 = Static265.method3820(false, 8, true);
				Static196.aClass76_44 = Static265.method3820(false, 9, true);
				Static88.aClass76_23 = Static265.method3820(false, 10, true);
				Static284.aClass76_55 = Static265.method3820(false, 11, true);
				Static197.aClass76_45 = Static265.method3820(false, 12, true);
				Static209.aClass76_48 = Static265.method3820(false, 13, true);
				Static312.aClass76_66 = Static265.method3820(false, 14, false);
				Static350.aClass76_79 = Static265.method3820(false, 15, true);
				Static424.aClass76_99 = Static265.method3820(false, 16, true);
				Static208.aClass76_29 = Static265.method3820(false, 17, true);
				Static381.aClass76_87 = Static265.method3820(false, 18, true);
				Static391.aClass76_91 = Static265.method3820(false, 19, true);
				Static388.aClass76_90 = Static265.method3820(false, 20, true);
				Static55.aClass76_16 = Static265.method3820(false, 21, true);
				Static64.aClass76_17 = Static265.method3820(false, 22, true);
				Static163.aClass76_39 = Static265.method3820(true, 23, true);
				Static66.aClass76_70 = Static265.method3820(false, 24, true);
				Static154.aClass76_11 = Static265.method3820(false, 25, true);
				Static24.aClass76_61 = Static265.method3820(true, 26, true);
				Static417.aClass76_98 = Static265.method3820(false, 27, true);
				Static19.aClass76_2 = Static265.method3820(true, 28, true);
				Static366.aClass76_83 = Static265.method3820(false, 29, true);
				Static24.aString53 = connectedToUpdateServerLocalizedString.getLocalizedString(ClientSettings.langID);
				Static247.anInt4590 = 15;
				anInt5 = 30;
			} else {
				Static24.aString53 = connectingToUpdateServerLocalizedString.getLocalizedString(ClientSettings.langID);
				Static247.anInt4590 = 12;
			}
		} else if (anInt5 == 30) {
			local10 = 0;
			for (int i = 0; i < 30; i++) {
				local10 += Static119.aClass143_Sub1Array1[i].method3525() * Static251.anIntArray307[i] / 100;
			}
			if (local10 == 100) {
				Static24.aString53 = loadedUpdateListLocalizedString.getLocalizedString(ClientSettings.langID);
				Static247.anInt4590 = 20;
				Static138.method2373(Static293.aClass76_60);
				Static221.method3346(Static293.aClass76_60);
				anInt5 = 40;
			} else {
				if (local10 != 0) {
					Static24.aString53 = checkingForUpdatesLocalizedString.getLocalizedString(ClientSettings.langID) + local10 + "%";
				}
				Static247.anInt4590 = 20;
			}
		} else if (anInt5 == 40) {
			if (Static19.aClass76_2.method2116()) {
				this.method908(Static19.aClass76_2.method2122(1));
				Static24.aString53 = loadedDefaultsLocalizedString.getLocalizedString(ClientSettings.langID);
				Static247.anInt4590 = 25;
				anInt5 = 50;
			} else {
				Static24.aString53 = loadingDefaultsLocalizedString.getLocalizedString(ClientSettings.langID) + Static19.aClass76_2.method2112() + "%";
				Static247.anInt4590 = 25;
			}
		} else if (anInt5 == 50) {
			Static72.method1354();
			Static24.aString53 = preparedSoundEngineLocalizedString.getLocalizedString(ClientSettings.langID);
			Static247.anInt4590 = 30;
			anInt5 = 60;
		} else if (anInt5 == 60) {
			local10 = Static444.method5632(Static209.aClass76_48, Static293.aClass76_60);
			int local11 = Static454.method3302();
			if (local10 < local11) {
				Static24.aString53 = loadingCoreFontsLocalizedString.getLocalizedString(ClientSettings.langID) + local10 * 100 / local11 + "%";
				Static247.anInt4590 = 35;
			} else {
				Static24.aString53 = loadedCoreFontsLocalizedString.getLocalizedString(ClientSettings.langID);
				anInt5 = 70;
				Static247.anInt4590 = 35;
			}
		} else if (anInt5 == 70) {
			local10 = Static97.method1701(Static293.aClass76_60);
			int local12 = Static395.method5165();
			if (local12 > local10) {
				Static24.aString53 = loadingTitleScreenLocalizedString.getLocalizedString(ClientSettings.langID) + local10 * 100 / local12 + "%";
				Static247.anInt4590 = 40;
			} else {
				Static24.aString53 = loadedTitleScreenLocalizedString.getLocalizedString(ClientSettings.langID);
				anInt5 = 80;
				Static247.anInt4590 = 40;
			}
		} else if (anInt5 == 80) {
			if (Static24.aClass76_61.method2116()) {
				Static80.anInterface7_3 = new Class91(Static24.aClass76_61, Static196.aClass76_44, Static293.aClass76_60);
				Static24.aString53 = loadedTexturesLocalizedString.getLocalizedString(ClientSettings.langID);
				Static247.anInt4590 = 45;
				anInt5 = 90;
			} else {
				Static24.aString53 = loadingTexturesLocalizedText.getLocalizedString(ClientSettings.langID) + Static24.aClass76_61.method2112() + "%";
				Static247.anInt4590 = 45;
			}
		} else if (anInt5 == 90) {
			Static24.aString53 = starting3dLibraryLocalizedString.getLocalizedString(ClientSettings.langID);
			Static247.anInt4590 = 50;
			anInt5 = 95;
		} else if (anInt5 == 95) {
			if (Static323.aClass50_Sub1_1.aBoolean297) {
				Static323.aClass50_Sub1_1.anInt3442 = 0;
				Static323.aClass50_Sub1_1.anInt3447 = 1;
				Static323.aClass50_Sub1_1.anInt3440 = 0;
				Static323.aClass50_Sub1_1.anInt3445 = 0;
				Static323.aClass50_Sub1_1.anInt3434 = 0;
			}
			Static323.aClass50_Sub1_1.aBoolean297 = true;
			Static323.aClass50_Sub1_1.method2856(GameShell.signLink);
			Static440.method5561(false, Static323.aClass50_Sub1_1.anInt3445);
			Static24.aString53 = started3dLibraryLocalizedString.getLocalizedString(ClientSettings.langID);
			Static247.anInt4590 = 55;
			anInt5 = 100;
		} else if (anInt5 == 100) {
			Static40.method696(Static122.aClass19_16, Static293.aClass76_60, Static209.aClass76_48);
			Static24.aString53 = openedTitleScreenLocalizedString.getLocalizedString(ClientSettings.langID);
			Static247.anInt4590 = 60;
			Static187.method2932(5);
			anInt5 = 110;
		} else if (anInt5 == 110) {
			Static74.aClass76_20.method2116();
			local10 = Static74.aClass76_20.method2112();
			Static424.aClass76_99.method2116();
			local10 += Static424.aClass76_99.method2112();
			Static208.aClass76_29.method2116();
			local10 += Static208.aClass76_29.method2112();
			Static381.aClass76_87.method2116();
			local10 += Static381.aClass76_87.method2112();
			Static391.aClass76_91.method2116();
			local10 += Static391.aClass76_91.method2112();
			Static388.aClass76_90.method2116();
			local10 += Static388.aClass76_90.method2112();
			Static55.aClass76_16.method2116();
			local10 += Static55.aClass76_16.method2112();
			Static64.aClass76_17.method2116();
			local10 += Static64.aClass76_17.method2112();
			Static66.aClass76_70.method2116();
			local10 += Static66.aClass76_70.method2112();
			Static154.aClass76_11.method2116();
			local10 += Static154.aClass76_11.method2112();
			Static417.aClass76_98.method2116();
			local10 += Static417.aClass76_98.method2112();
			Static366.aClass76_83.method2116();
			local10 += Static366.aClass76_83.method2112();
			if (local10 < 1200) {
				Static24.aString53 = loadingConfigLocalizedString.getLocalizedString(ClientSettings.langID) + local10 / 12 + "%";
				Static247.anInt4590 = 65;
			} else {
				Static153.aClass180_1 = new Class180(ClientSettings.modeGame, ClientSettings.langID, Static74.aClass76_20);
				Static222.aClass249_1 = new Class249(ClientSettings.modeGame, ClientSettings.langID, Static74.aClass76_20);
				Static118.aClass172_2 = new Class172(ClientSettings.modeGame, ClientSettings.langID, Static74.aClass76_20, Static293.aClass76_60);
				Static416.aClass158_1 = new Class158(ClientSettings.modeGame, ClientSettings.langID, Static208.aClass76_29);
				Static154.aClass124_2 = new Class124(ClientSettings.modeGame, ClientSettings.langID, Static74.aClass76_20);
				Static234.aClass192_2 = new Class192(ClientSettings.modeGame, ClientSettings.langID, Static74.aClass76_20);
				Static420.aClass109_2 = new Class109(ClientSettings.modeGame, ClientSettings.langID, Static74.aClass76_20, Static357.aClass76_82);
				Static101.aClass75_1 = new Class75(ClientSettings.modeGame, ClientSettings.langID, Static74.aClass76_20);
				Static405.aClass204_1 = new Class204(ClientSettings.modeGame, ClientSettings.langID, Static74.aClass76_20);
				Static267.aClass262_2 = new Class262(ClientSettings.modeGame, ClientSettings.langID, true, Static424.aClass76_99, Static357.aClass76_82);
				Static348.aClass182_4 = new Class182(ClientSettings.modeGame, ClientSettings.langID, Static74.aClass76_20, Static293.aClass76_60);
				Static76.aClass265_2 = new Class265(ClientSettings.modeGame, ClientSettings.langID, Static74.aClass76_20, Static293.aClass76_60);
				Static329.aClass240_1 = new Class240(ClientSettings.modeGame, ClientSettings.langID, true, Static381.aClass76_87, Static357.aClass76_82);
				Static444.aClass206_3 = new Class206(ClientSettings.modeGame, ClientSettings.langID, true, Static153.aClass180_1, Static391.aClass76_91, Static357.aClass76_82);
				Static426.aClass208_1 = new Class208(ClientSettings.modeGame, ClientSettings.langID, Static74.aClass76_20);
				Static182.aClass55_1 = new Class55(ClientSettings.modeGame, ClientSettings.langID, Static388.aClass76_90, Static395.aClass76_92, Static324.aClass76_69);
				Static296.aClass217_1 = new Class217(ClientSettings.modeGame, ClientSettings.langID, Static74.aClass76_20);
				Static238.aClass226_1 = new Class226(ClientSettings.modeGame, ClientSettings.langID, Static74.aClass76_20);
				Static352.aClass194_2 = new Class194(ClientSettings.modeGame, ClientSettings.langID, Static55.aClass76_16, Static357.aClass76_82);
				Static280.aClass72_1 = new Class72(ClientSettings.modeGame, ClientSettings.langID, Static74.aClass76_20);
				Static186.aClass197_1 = new Class197(ClientSettings.modeGame, ClientSettings.langID, Static74.aClass76_20);
				Static43.aClass93_4 = new Class93(ClientSettings.modeGame, ClientSettings.langID, Static74.aClass76_20);
				Static26.aClass26_1 = new Class26(ClientSettings.modeGame, ClientSettings.langID, Static64.aClass76_17);
				Static183.aClass223_1 = new Class223(ClientSettings.modeGame, ClientSettings.langID, Static74.aClass76_20);
				Static442.method5586(Static256.aClass76_50, Static209.aClass76_48, Static357.aClass76_82, Static293.aClass76_60);
				Static165.method2730(Static366.aClass76_83);
				Static401.aClass62_1 = new Class62(ClientSettings.langID, Static66.aClass76_70, Static154.aClass76_11);
				Static445.aClass81_2 = new Class81(ClientSettings.langID, Static66.aClass76_70, Static154.aClass76_11, new Class130());
				Static24.aString53 = loadedConfigLocalizedString.getLocalizedString(ClientSettings.langID);
				Static247.anInt4590 = 65;
				Static38.method673();
				Static267.aClass262_2.method5562(!Static323.aClass50_Sub1_1.method2861(Static177.anInt2973));
				Static257.aClass114_1 = new Class114();
				Static119.method2149();
				Static378.method3227(Static417.aClass76_98);
				Static273.method3916(Static357.aClass76_82, Static80.anInterface7_3);
				anInt5 = 120;
			}
		} else if (anInt5 == 120) {
			local10 = Static290.method5014(Static293.aClass76_60);
			int local13 = Static203.method3176();
			if (local10 < local13) {
				Static24.aString53 = loadingSpritesLocalizedString.getLocalizedString(ClientSettings.langID) + local10 * 100 / local13 + "%";
				Static247.anInt4590 = 70;
			} else {
				Static97.method1700(Static293.aClass76_60, Static122.aClass19_16);
				Static324.method4387(Static429.aClass57Array18);
				Static24.aString53 = loadedSpritesLocalizedString.getLocalizedString(ClientSettings.langID);
				anInt5 = 130;
				Static247.anInt4590 = 70;
			}
		} else if (anInt5 == 130) {
			if (Static88.aClass76_23.method2123("", "huffman")) {
				@Pc(1252) Class119 local1252 = new Class119(Static88.aClass76_23.method2109("huffman", ""));
				Static195.method3074(local1252);
				Static24.aString53 = loadedWordpackLocalizedString.getLocalizedString(ClientSettings.langID);
				Static247.anInt4590 = 75;
				anInt5 = 140;
			} else {
				Static24.aString53 = loadingWordpackLocalizedString.getLocalizedString(ClientSettings.langID) + "0%";
				Static247.anInt4590 = 75;
			}
		} else if (anInt5 == 140) {
			if (Static256.aClass76_50.method2116()) {
				Static24.aString53 = loadedInterfacesLocalizedString.getLocalizedString(ClientSettings.langID);
				anInt5 = 150;
				Static247.anInt4590 = 80;
			} else {
				Static24.aString53 = loadingInterfacesLocalizedString.getLocalizedString(ClientSettings.langID) + Static256.aClass76_50.method2112() + "%";
				Static247.anInt4590 = 80;
			}
		} else if (anInt5 == 150) {
			if (Static197.aClass76_45.method2116()) {
				Static24.aString53 = loadedInterfaceScriptsLocalizedString.getLocalizedString(ClientSettings.langID);
				anInt5 = 160;
				Static247.anInt4590 = 82;
			} else {
				Static24.aString53 = loadingInterfaceScriptsLocalizedString.getLocalizedString(ClientSettings.langID) + Static197.aClass76_45.method2112() + "%";
				Static247.anInt4590 = 82;
			}
		} else if (anInt5 == 160) {
			if (Static209.aClass76_48.method2116()) {
				Static24.aString53 = loadingAdditionalFontsLocalizedString.getLocalizedString(ClientSettings.langID);
				anInt5 = 170;
				Static247.anInt4590 = 85;
			} else {
				Static24.aString53 = loadingAdditionalFontsLocalizedString.getLocalizedString(ClientSettings.langID) + Static209.aClass76_48.method2112() + "%";
				Static247.anInt4590 = 85;
			}
		} else if (anInt5 == 170) {
			if (Static163.aClass76_39.method2103("details")) {
				Static148.method4514(Static163.aClass76_39, Static154.aClass124_2, Static234.aClass192_2, Static267.aClass262_2, Static348.aClass182_4, Static76.aClass265_2, Static257.aClass114_1);
				Static24.aString53 = loadedWorldMapLocalizedString.getLocalizedString(ClientSettings.langID);
				anInt5 = 180;
				Static247.anInt4590 = 89;
			} else {
				Static24.aString53 = loadingWorldMapLocalizedString.getLocalizedString(ClientSettings.langID) + Static163.aClass76_39.method2113("details") + "%";
				Static247.anInt4590 = 87;
			}
		} else if (anInt5 == 180) {
			local10 = Static112.method2035();
			if (local10 == -1) {
				Static24.aString53 = loadingWorldListDataLocalizedString.getLocalizedString(ClientSettings.langID);
				Static247.anInt4590 = 90;
			} else if (local10 == 7 || local10 == 9) {
				this.handleGameError("worldlistfull");
				Static187.method2932(1000);
			} else if (Static94.aBoolean176) {
				Static24.aString53 = loadedWorldListDataLocalizedString.getLocalizedString(ClientSettings.langID);
				anInt5 = 190;
				Static247.anInt4590 = 90;
			} else {
				this.handleGameError("worldlistio_" + local10);
				Static187.method2932(1000);
			}
		} else if (anInt5 == 190) {
			Static265.aStringArray20 = new String[Static186.aClass197_1.anInt5738];
			Static22.aBooleanArray3 = new boolean[Static43.aClass93_4.anInt2890];
			Static165.anIntArray210 = new int[Static43.aClass93_4.anInt2890];
			for (local10 = 0; local10 < Static43.aClass93_4.anInt2890; local10++) {
				if (Static43.aClass93_4.method2430(local10).anInt6668 == 0) {
					Static22.aBooleanArray3[local10] = true;
					Static268.anInt4998++;
				}
				Static165.anIntArray210[local10] = -1;
			}
			Static228.method2068();
			Static254.anInt4755 = Static256.aClass76_50.method2099("loginscreen");
			Static49.aClass76_27.method2128(false);
			Static46.aClass76_54.method2128(true);
			Static293.aClass76_60.method2128(true);
			Static209.aClass76_48.method2128(true);
			Static88.aClass76_23.method2128(true);
			Static256.aClass76_50.method2128(true);
			Static74.aClass76_20.anInt2476 = 2;
			Static9.aBoolean10 = true;
			Static208.aClass76_29.anInt2476 = 2;
			Static424.aClass76_99.anInt2476 = 2;
			Static381.aClass76_87.anInt2476 = 2;
			Static391.aClass76_91.anInt2476 = 2;
			Static388.aClass76_90.anInt2476 = 2;
			Static55.aClass76_16.anInt2476 = 2;
			Static188.method4107(Static323.aClass50_Sub1_1.anInt3447, -1, -1, false);
			Static24.aString53 = loadedClientVariableDataLocalizedString.getLocalizedString(ClientSettings.langID);
			Static247.anInt4590 = 95;
			anInt5 = 200;
		} else if (anInt5 == 200) {
			Static374.method4994(true);
		}
	}

	@OriginalMember(owner = "client!client", name = "f", descriptor = "(B)V")
	private void method912() {
		Js5NetQueue.ProcessConnectionsResult result = js5NetQueue.processJS5Requests();

		if (result == Js5NetQueue.ProcessConnectionsResult.UNABLE_TO_PROCESS_REQUESTS) {
			this.js5connect();
		}
	}
}
