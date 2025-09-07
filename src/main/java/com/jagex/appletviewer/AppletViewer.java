package com.jagex.appletviewer;

import com.jagex.loader.loader;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.*;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Optional;
import nativeadvert.browsercontrol;

public final class AppletViewer implements ComponentListener {
  // $FF: renamed from: a app.j
  private static ListDialog serverSelectionDialog;
  // $FF: renamed from: b app.j
  private static ListDialog languageSelectionDialog;
  // $FF: renamed from: c app.n
  private static ToolbarComponent toolbarComponent;
  // $FF: renamed from: d java.util.Hashtable
  private static final Hashtable<String, String> configurationItems = new Hashtable<>();
  // $FF: renamed from: e java.applet.Applet
  private static Applet applet;
  // $FF: renamed from: f java.awt.Canvas
  private static Canvas advertComponent;
  // $FF: renamed from: g java.awt.Frame
  static Frame frame;
  // $FF: renamed from: h boolean
  private static boolean is64Bit;
  // $FF: renamed from: i java.awt.Panel
  private static Panel innerContainer;
  // $FF: renamed from: j java.awt.Component
  private static Component termsAndConditionsTextArea;
  // $FF: renamed from: k boolean
  static boolean isWindows;
  // $FF: renamed from: l boolean
  static boolean isDebug = false;
  // $FF: renamed from: m java.util.Hashtable
  private static final Hashtable<String, String> params = new Hashtable<>();
  // $FF: renamed from: n java.util.Hashtable
  static Hashtable<String, String> localeStrings = new Hashtable<>();
  // $FF: renamed from: p app.q[]
  private static ServerSettings[] serverSettingsList = null;
  // $FF: renamed from: q int[]
  private static int[] languageIDs;
  // $FF: renamed from: r java.io.File
  private static File javConfigFile = null;
  // $FF: renamed from: s app.q
  private static ServerSettings currentServerSettings = null;
  // $FF: renamed from: u boolean
  private static boolean shouldRestrictAppletSize = true;
  // $FF: renamed from: v java.lang.String
  private static String javConfigURL = null;
  private static final float TOTAL_EXPECTED_BYTES = 58988.0F;
  // $FF: renamed from: w float
  private static float totalReceivedBytes = 0.0F;

  public void componentMoved(ComponentEvent var1) {}

  // $FF: renamed from: a (byte) void
  static void quit() {
    if (browsercontrol.iscreated()) {
      browsercontrol.destroy();
    }

    System.exit(0);
  }

  // $FF: renamed from: a (java.lang.String, int, java.io.File) java.io.BufferedReader
  private static BufferedReader fetchJavConfig(String URL, File file) throws IOException {
    if (URL != null) {
      return new BufferedReader(new InputStreamReader((new URL(URL)).openStream()));
    }

    if (file != null) {
      return new BufferedReader(new FileReader(file));
    }

    return null;
  }

  public static void removeadvert() {
    if (advertComponent != null) {
      if (browsercontrol.iscreated()) {
        browsercontrol.destroy();
      }

      innerContainer.remove(advertComponent);
      advertComponent = null;
      setComponentBounds();
    }
  }

  // $FF: renamed from: a (byte, java.lang.String) void
  public static void start(String gameName) {
    isDebug = Boolean.getBoolean("com.jagex.debug");

    if (isDebug) {
      boolean showHostConsole = Boolean.getBoolean("com.jagex.hostConsole");

      if (showHostConsole) {
        System.setErr(DebugOutputConsole.initialize());
        System.setOut(DebugOutputConsole.initialize());
      }

      System.out.println("release #7");
      System.out.println("java.version = " + System.getProperty("java.version"));
      System.out.println("os.name = " + System.getProperty("os.name"));
      System.out.println("os.arch = " + System.getProperty("os.arch"));
    }

    Language language =
        Language.resolveFromAppletViewerPreferences()
            .orElseGet(
                () -> {
                  Language userLanguage = Language.resolveUserLanguage();

                  AppletViewerPreferences.addPreference(
                      Integer.toString(userLanguage.getID()), "Language");
                  AppletViewerPreferences.writePreferencesToFile();

                  return userLanguage;
                });

    String javConfigURL;

    InitialLocaleStrings.initialize(language);
    frame = new Frame();
    File gameDirectory =
        new File((new File(System.getProperty("user.dir"))).getParentFile(), gameName);
    File iconFile = new File(gameDirectory, "jagexappletviewer.png");
    System.out.println("Trying to load icon file: " + iconFile.getAbsolutePath());
    if (iconFile.exists()) {
      Image iconImage = Toolkit.getDefaultToolkit().getImage(iconFile.getAbsolutePath());
      if (iconImage != null) {
        frame.setIconImage(iconImage);
      }
    }

    LoaderBoxComponent.initialize();
    LoaderBoxComponent.setVisible();
    LoaderBoxComponent.setLoadingText(getLocaleString("loading_config"));
    javConfigURL = System.getProperty("com.jagex.config");
    String configFileName = System.getProperty("com.jagex.configfile");
    if (null == javConfigURL) {
      if (null == configFileName) {
        ModalDialog.displayErrorMessage(getLocaleString("err_missing_config"));
      }

      javConfigFile = new File(gameDirectory, configFileName);
    }

    if (javConfigURL != null) {
      AppletViewer.javConfigURL = resolveConfigURLTemplate(javConfigURL);
      System.out.println("Config URL is " + AppletViewer.javConfigURL);
    }

    readJavConfig(language);

    String requiredAppletViewerVersionString = getConfigValue("viewerversion");
    if (requiredAppletViewerVersionString != null) {
      try {
        int requiredAppletViewerVersion = Integer.parseInt(requiredAppletViewerVersionString);
        if (requiredAppletViewerVersion > 100) {
          ModalDialog.displayMessage(getLocaleString("new_version"));
        }
      } catch (NumberFormatException ignored) {
      }
    }

    int modewhat = 32 + Integer.parseInt(getParameter("modewhat"));
    String cacheSubdir = getConfigValue("cachesubdir");
    String codebaseURL = getConfigValue("codebase");
    String osName = System.getProperty("os.name").toLowerCase();
    String osArch = System.getProperty("os.arch").toLowerCase();
    isWindows = osName.startsWith("win");
    is64Bit = isWindows && osArch.startsWith("amd64") || osArch.startsWith("x86_64");
    String homeDirectory = null;

    try {
      homeDirectory = System.getProperty("user.home");
      if (null != homeDirectory) {
        homeDirectory = homeDirectory + "/";
      }
    } catch (Exception ignored) {
    }

    LoaderBoxComponent.setLoadingText(getLocaleString("loading_app_resources"));
    if (homeDirectory == null) {
      homeDirectory = "~/";
    }

    File browserControlFile = null;

    byte[] remoteFileBuffer;
    try {
      byte[] fileBytes;
      if (is64Bit) {
        remoteFileBuffer =
            fetchRemoteFileToBuffer(codebaseURL, getConfigValue("browsercontrol_win_amd64_jar"));
        browserControlFile =
            locateFileLocation(modewhat, "browsercontrol64.dll", homeDirectory, cacheSubdir);
        System.out.printf("Attempting to validate %s", "browser");
        fileBytes =
            (new SignedFileValidator(remoteFileBuffer)).validateFile("browsercontrol64.dll");
        if (null == fileBytes && !AppletViewer.isDebug) {
          browserControlFile = null;
          ModalDialog.displayErrorMessage(getLocaleString("err_verify_bc64"));
        }

        writeBytesToCacheFile(fileBytes, browserControlFile);
      } else if (isWindows) {
        remoteFileBuffer =
            fetchRemoteFileToBuffer(codebaseURL, getConfigValue("browsercontrol_win_x86_jar"));
        browserControlFile =
            locateFileLocation(modewhat, "browsercontrol.dll", homeDirectory, cacheSubdir);
        fileBytes = (new SignedFileValidator(remoteFileBuffer)).validateFile("browsercontrol.dll");
        if (fileBytes == null && !AppletViewer.isDebug) {
          browserControlFile = null;
          ModalDialog.displayErrorMessage(getLocaleString("err_verify_bc"));
        }

        writeBytesToCacheFile(fileBytes, browserControlFile);
        if (isDebug) {
          System.out.println("dlldata : " + remoteFileBuffer.length);
        }
      }
    } catch (Exception var30) {
      if (isDebug) {
        var30.printStackTrace();
      }

      ModalDialog.displayErrorMessage(getLocaleString("err_load_bc"));
    }

    LoaderBoxComponent.setLoadingText(getLocaleString("loading_app"));

    if (isWindows || isDebug) {
      PatchedClassLoader.initialize();
    }

    try {
      remoteFileBuffer = fetchRemoteFileToBuffer(codebaseURL, getConfigValue("loader_jar"));
      RemoteClassLoader classLoader = new RemoteClassLoader(remoteFileBuffer);
      if (isDebug) {
        System.out.println("loader_jar : " + remoteFileBuffer.length);
        applet = new loader();
      } else {
        applet = (Applet) classLoader.loadClass("loader").getDeclaredConstructor().newInstance();
      }
    } catch (Exception var29) {
      if (isDebug) {
        var29.printStackTrace();
      }

      ModalDialog.displayErrorMessage(getLocaleString("err_target_applet"));
    }

    LoaderBoxComponent.setHidden();
    URLViewer.initialize();
    frame.setTitle(getConfigValue("title"));
    int advertHeight = isWindows ? Integer.parseInt(getConfigValue("advert_height")) : 0;
    int preferredWidth = Integer.parseInt(getConfigValue("window_preferredwidth"));
    int preferredHeight = Integer.parseInt(getConfigValue("window_preferredheight"));
    Insets frameInsets = frame.getInsets();
    frame.setSize(
        frameInsets.right + preferredWidth + frameInsets.left,
        frameInsets.bottom + preferredHeight + (advertHeight + frameInsets.top + 40));
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    innerContainer = new Panel();
    innerContainer.setBackground(Color.black);
    innerContainer.setLayout(null);
    frame.setLayout(new BorderLayout());
    frame.add(innerContainer, "Center");

    Optional<String> isMemberPreference = AppletViewerPreferences.getPreference("Member");
    boolean isMember = isMemberPreference.isPresent() && isMemberPreference.get().equals("yes");
    if (isWindows && !isMember) {
      advertComponent = new Canvas();
      innerContainer.add(advertComponent);
    }

    innerContainer.add(applet);
    toolbarComponent = new ToolbarComponent(new ToolbarButtonHandler());
    toolbarComponent.setBackground(Color.BLACK);
    toolbarComponent.setForeground(Color.GRAY);
    toolbarComponent.addButton(getLocaleString("language"));
    if (null != serverSettingsList && serverSettingsList.length > 1) {
      toolbarComponent.addButton(getLocaleString("switchserver"));
    }

    toolbarComponent.setFont(new Font("SansSerif", Font.PLAIN, 10));
    innerContainer.add(toolbarComponent);
    termsAndConditionsTextArea = new TextAreaComponent(getLocaleString("tandc"));
    innerContainer.add(termsAndConditionsTextArea);
    frame.doLayout();
    setComponentBounds();
    if (isWindows) {
      try {
        System.load(browserControlFile.toString());
      } catch (Throwable var26) {
        if (isDebug) {
          var26.printStackTrace();
        }

        ModalDialog.displayErrorMessage(getLocaleString("err_create_advertising"));
        return;
      }
    }

    if (isWindows && !isMember) {
      while (!advertComponent.isDisplayable() || !advertComponent.isShowing()) {
        try {
          Thread.sleep(100L);
        } catch (Exception ignored) {
        }
      }

      try {
        browsercontrol.create(advertComponent, getConfigValue("adverturl"));
        browsercontrol.resize(advertComponent.getSize().width, advertComponent.getSize().height);
      } catch (Throwable var27) {
        if (isDebug) {
          var27.printStackTrace();
        }

        ModalDialog.displayErrorMessage(getLocaleString("err_create_advertising"));
        return;
      }
    }

    frame.addWindowListener(TerminateHandler.initialize());
    innerContainer.addComponentListener(new AppletViewer());
    applet.setStub(new AppletEnvironment());
    applet.init();
    applet.start();
  }

  public void componentHidden(ComponentEvent var1) {}

  // $FF: renamed from: a (app.q, int) void
  private static void restartWithNewServerSettings(ServerSettings serverSettings) {
    if (serverSettings == null) {
      return;
    }

    LoaderBoxComponent.setLoadingText(getLocaleString("loading_app"));
    LoaderBoxComponent.updateProgress(0);
    LoaderBoxComponent.setVisible();
    LoaderBoxComponent.paint();

    if (applet != null) {
      if (termsAndConditionsTextArea.isVisible()) {
        termsAndConditionsTextArea.setVisible(false);
        setComponentBounds();
      }

      applet.stop();
      LoaderBoxComponent.updateProgress(25);
      LoaderBoxComponent.paint();
      applet.destroy();
      innerContainer.remove(applet);
      applet = null;
      innerContainer.remove(termsAndConditionsTextArea);
    }

    currentServerSettings = serverSettings;
    LoaderBoxComponent.updateProgress(50);
    LoaderBoxComponent.paint();

    if (isWindows || isDebug) {
      PatchedClassLoader.initialize();
    }

    try {
      String var2 = getConfigValue("codebase");
      byte[] remoteFileBuffer = fetchRemoteFileToBuffer(var2, getConfigValue("loader_jar"));
      LoaderBoxComponent.updateProgress(75);
      LoaderBoxComponent.paint();
      RemoteClassLoader classLoader = new RemoteClassLoader(remoteFileBuffer);
      applet = (Applet) classLoader.loadClass("loader").getDeclaredConstructor().newInstance();

      if (isDebug) {
        System.out.println("loader_jar : " + remoteFileBuffer.length);
      }

      LoaderBoxComponent.setHidden();
    } catch (Exception var5) {
      if (isDebug) {
        var5.printStackTrace();
      }

      LoaderBoxComponent.setHidden();
      ModalDialog.displayErrorMessage(getLocaleString("err_target_applet"));
    }

    innerContainer.add(applet);
    termsAndConditionsTextArea = new TextAreaComponent(getLocaleString("tandc"));
    innerContainer.add(termsAndConditionsTextArea);
    shouldRestrictAppletSize = true;
    setComponentBounds();
    applet.setStub(new AppletEnvironment());
    applet.init();
    applet.start();
  }

  // $FF: renamed from: b (byte) void
  private static void setComponentBounds() {
    if (applet != null) {
      int toolbarHeight = toolbarComponent.isVisible() ? ToolbarComponent.TOOLBAR_HEIGHT : 0;
      int advertHeight =
          advertComponent != null ? Integer.parseInt(getConfigValue("advert_height")) : 0;
      int termsAndConditionsHeight = termsAndConditionsTextArea.isVisible() ? 40 : 0;
      int appletMinWidth = Integer.parseInt(getConfigValue("applet_minwidth"));
      int appletMinHeight = Integer.parseInt(getConfigValue("applet_minheight"));
      int appletMaxWidth = Integer.parseInt(getConfigValue("applet_maxwidth"));
      int appletMaxHeight = Integer.parseInt(getConfigValue("applet_maxheight"));
      Dimension containerSize = innerContainer.getSize();
      Insets containerInsets = innerContainer.getInsets();
      int containerWidth = containerSize.width - (containerInsets.right + containerInsets.left);
      int containerHeight = containerSize.height - (containerInsets.top + containerInsets.bottom);
      int appletWidth = Math.max(containerWidth, appletMinWidth);
      int appletHeight =
          containerHeight - (toolbarHeight + advertHeight + termsAndConditionsHeight);
      appletHeight = Math.max(appletMinHeight, appletHeight);

      if (shouldRestrictAppletSize) {
        appletHeight = Math.min(appletMaxHeight, appletHeight);
        appletWidth = Math.min(appletMaxWidth, appletWidth);
      }

      containerWidth = Math.max(appletMinWidth, containerWidth);

      toolbarComponent.setBounds((containerWidth - appletWidth) / 2, 0, appletWidth, toolbarHeight);

      if (advertComponent != null) {
        advertComponent.setBounds(
            (containerWidth - appletWidth) / 2, toolbarHeight, appletWidth, advertHeight);
      }

      applet.setBounds(
          (containerWidth - appletWidth) / 2,
          advertHeight + toolbarHeight,
          appletWidth,
          appletHeight);

      termsAndConditionsTextArea.setBounds(
          (containerWidth - appletWidth) / 2,
          appletHeight + advertHeight + toolbarHeight,
          appletWidth,
          termsAndConditionsHeight);

      if (advertComponent != null && browsercontrol.iscreated()) {
        browsercontrol.resize(advertComponent.getSize().width, advertComponent.getSize().height);
      }

      frame.repaint();
    }
  }

  // $FF: renamed from: a (java.lang.String, int, java.lang.String) byte[]
  private static byte[] fetchRemoteFileToBuffer(String codebaseURL, String filename) {
    byte[] buffer = new byte[300000];
    int currentBufferPOS = 0;

    try {
      InputStream inputStream = (new URL(codebaseURL + filename)).openStream();

      while (currentBufferPOS < buffer.length) {
        int bytesRead =
            inputStream.read(buffer, currentBufferPOS, buffer.length - currentBufferPOS);
        if (bytesRead < 0) {
          break;
        }

        currentBufferPOS += bytesRead;
        totalReceivedBytes += (float) bytesRead;

        int currentProgress = (int) (100.0F * (totalReceivedBytes / TOTAL_EXPECTED_BYTES));

        LoaderBoxComponent.updateProgress(currentProgress);
      }

      inputStream.close();
    } catch (Exception e) {
      if (isDebug) {
        e.printStackTrace();
      }

      ModalDialog.displayErrorMessage(getLocaleString("err_downloading") + ": " + filename);
    }

    byte[] resultingBuffer = new byte[currentBufferPOS];
    System.arraycopy(buffer, 0, resultingBuffer, 0, currentBufferPOS);

    return resultingBuffer;
  }

  // $FF: renamed from: a (int, java.lang.String) java.lang.String
  static String getParameter(String name) {
    if (currentServerSettings != null) {
      String var2 = currentServerSettings.parameters.get(name);
      if (var2 != null) {
        return var2;
      }
    }

    System.out.println("Using root param for: " + name);
    return params.get(name);
  }

  // $FF: renamed from: b (int) void
  static void selectPreferredServerHandler() {
    String serverListURL = getConfigValue("serverlist");
    ServerSettings[] enabledServers = serverSettingsList;
    int enabledServerCount = serverSettingsList.length;

    /*
     * If the server includes a server list param we will use it to determine which servers are available
     * to show in the list
     */
    if (serverListURL != null) {
      enabledServers = new ServerSettings[serverSettingsList.length];
      enabledServerCount = 0;

      try {
        BufferedReader serverList = fetchJavConfig(serverListURL, null);

        label67:
        do {
          // [SeverName, (Bool)isEnabled]
          String[] serverListPair;
          do {
            String line;
            do {
              line = serverList.readLine();

              if (line == null) {
                break label67;
              }

              line = line.trim();
            } while (line.startsWith("//"));

            serverListPair = line.split(",");
          } while (serverListPair.length < 2);

          if (serverListPair[1].trim().equalsIgnoreCase("true")) {
            String serverName = serverListPair[0].trim();
            int index = 0;

            while (serverSettingsList.length > index) {
              if (serverSettingsList[index].name.equals(serverName)) {
                enabledServers[enabledServerCount++] = serverSettingsList[index];
              }

              ++index;
            }
          }
        } while (true);

        serverList.close();
      } catch (IOException var10) {
        enabledServerCount = serverSettingsList.length;
        enabledServers = serverSettingsList;
      }
    }

    String[] serverNameList = new String[enabledServerCount];
    int currentIndex = 0;

    while (currentIndex < enabledServerCount) {
      serverNameList[currentIndex] = enabledServers[currentIndex].configValues.get("servername");
      ++currentIndex;
    }

    serverSelectionDialog.initializeList(serverNameList);

    int selectedIndex = serverSelectionDialog.prompt();

    if (selectedIndex > -1 && selectedIndex < enabledServers.length) {
      restartWithNewServerSettings(enabledServers[selectedIndex]);
    }
  }

  // $FF: renamed from: a (int, java.lang.String, java.lang.String, java.lang.String, int)
  // java.io.File
  private static File locateFileLocation(
      int modewhat, String fileName, String userHome, String cacheSubdirName) {
    String[] potentialParentDirectories =
        new String[] {
          "c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", userHome, "/tmp/", ""
        };
    String[] potentialCacheDirectoryNames =
        new String[] {".jagex_cache_" + modewhat, ".file_store_" + modewhat};

    // We need to complete two passes
    // On the first pass we will attempt to find an existing file
    // On the second pass we will attempt to find an available directory
    for (int cacheFindPass = 0; cacheFindPass < 2; ++cacheFindPass) {
      for (String potentialCacheDirectoryName : potentialCacheDirectoryNames) {
        for (String potentialParentDirectory : potentialParentDirectories) {
          String fullFilePath =
              potentialParentDirectory
                  + potentialCacheDirectoryName
                  + "/"
                  + (cacheSubdirName != null ? cacheSubdirName + "/" : "")
                  + fileName;
          RandomAccessFile randomAccessFile = null;

          root:
          {
            startLogic:
            {
              File file;
              checkForExistingFile:
              {
                try {
                  file = new File(fullFilePath);
                  if (cacheFindPass != 0 || file.exists()) {
                    break checkForExistingFile;
                  }
                } catch (Exception var20) {
                  break startLogic;
                }

                break root;
              }

              checkForPossibleParentDirectory:
              {
                try {
                  if (cacheFindPass != 1
                      || 0 >= potentialParentDirectory.length()
                      || (new File(potentialParentDirectory)).exists()) {
                    break checkForPossibleParentDirectory;
                  }
                } catch (Exception var19) {
                  break startLogic;
                }

                break root;
              }

              try {
                (new File(potentialParentDirectory + potentialCacheDirectoryName)).mkdir();
                if (cacheSubdirName != null) {
                  (new File(
                          potentialParentDirectory
                              + potentialCacheDirectoryName
                              + "/"
                              + cacheSubdirName))
                      .mkdir();
                }

                randomAccessFile = new RandomAccessFile(file, "rw");
                int singleFileDataByte = randomAccessFile.read();
                randomAccessFile.seek(0L);
                randomAccessFile.write(singleFileDataByte);
                randomAccessFile.seek(0L);
                randomAccessFile.close();
                return file;
              } catch (Exception ignored) {
              }
            }

            if (isDebug) {
              System.out.println("Unable to open/write: " + fullFilePath);
            }

            try {
              if (randomAccessFile != null) {
                randomAccessFile.close();
              }
            } catch (Exception ignored) {
            }
          }
        }
      }
    }

    if (!isDebug) {
      throw new RuntimeException();
    } else {
      throw new RuntimeException("Fatal - could not find ANY location for file: " + fileName);
    }
  }

  // $FF: renamed from: a (int) void
  public static void showContainerElements() {
    boolean shouldSetComponentBounds = false;

    if (!toolbarComponent.isVisible()) {
      shouldSetComponentBounds = true;

      toolbarComponent.setVisible(true);
    }

    if (!termsAndConditionsTextArea.isVisible()) {
      shouldSetComponentBounds = true;

      termsAndConditionsTextArea.setVisible(true);
    }

    if (shouldSetComponentBounds) {
      setComponentBounds();
    }
  }

  // $FF: renamed from: c (int) void
  public static void hideContainerElements() {
    boolean shouldSetComponentBounds = false;

    if (serverSettingsList == null && toolbarComponent.isVisible()) {
      toolbarComponent.setVisible(false);

      shouldSetComponentBounds = true;
    }

    if (termsAndConditionsTextArea.isVisible()) {
      termsAndConditionsTextArea.setVisible(false);

      shouldSetComponentBounds = true;
    }

    if (shouldSetComponentBounds) {
      setComponentBounds();
    }
  }

  // $FF: renamed from: a (java.lang.String, int) java.lang.String
  static String getLocaleString(String key) {
    if (null != currentServerSettings) {
      String var2 = currentServerSettings.localeStrings.get(key);
      if (var2 != null) {
        return var2;
      }
    }

    System.out.println("Using root locale string for: " + key);
    return localeStrings.get(key);
  }

  // $FF: renamed from: b (byte, java.lang.String) java.lang.String
  static String getConfigValue(String name) {
    if (null != currentServerSettings) {
      String configValue = currentServerSettings.configValues.get(name);

      if (configValue != null) {
        return configValue;
      }
    }

    System.out.println("Using root config item for: " + name);

    return configurationItems.get(name);
  }

  public void componentResized(ComponentEvent var1) {
    setComponentBounds();
  }

  // $FF: renamed from: a (byte, byte[], java.io.File) boolean
  private static void writeBytesToCacheFile(byte[] bytes, File file) {
    try {
      FileOutputStream outputStream = new FileOutputStream(file);
      outputStream.write(bytes, 0, bytes.length);
      outputStream.close();
    } catch (IOException exception) {
      if (isDebug) {
        exception.printStackTrace();
      }

      ModalDialog.displayErrorMessage(getLocaleString("err_save_file"));
    }
  }

  // $FF: renamed from: a (byte, int) boolean
  private static void readJavConfig(Language language) {
    params.clear();
    int langCount = 0;
    InitialLocaleStrings.initialize(language);
    configurationItems.clear();
    currentServerSettings = null;
    serverSettingsList = null;
    int severSettingsCount = 0;
    ServerSettings[] servers = new ServerSettings[50];

    int equalPos;
    try {
      BufferedReader configReader = fetchJavConfig(javConfigURL, javConfigFile);

      Hashtable<String, String> params = AppletViewer.params;
      Hashtable<String, String> configValues = configurationItems;
      Hashtable<String, String> localeStrings = AppletViewer.localeStrings;

      parseFile:
      do {
        String settingLine;
        do {
          do {
            settingLine = configReader.readLine();

            if (settingLine == null) {
              break parseFile;
            }

            settingLine = settingLine.trim();
          } while (settingLine.startsWith("//"));
        } while (settingLine.startsWith("#"));

        if (settingLine.startsWith("[")) {
          String serverName = settingLine.substring(1, settingLine.lastIndexOf("]"));
          ServerSettings settings = new ServerSettings(serverName);
          if (currentServerSettings == null) {
            currentServerSettings = settings;
          }

          if (severSettingsCount >= servers.length) {
            ServerSettings[] resizedServers = new ServerSettings[10 + severSettingsCount];
            System.arraycopy(servers, 0, resizedServers, 0, servers.length);
            servers = resizedServers;
          }

          servers[severSettingsCount++] = settings;
          params = settings.parameters;
          configValues = settings.configValues;
          localeStrings = settings.localeStrings;
        }

        String configKey;
        String configValue;
        if (!settingLine.startsWith("param=")) {
          if (!settingLine.startsWith("msg=")) {
            equalPos = settingLine.indexOf("=");
            if (equalPos != -1) {
              configKey = settingLine.substring(0, equalPos).trim().toLowerCase();
              configValue = settingLine.substring(1 + equalPos).trim();
              configValues.put(configKey, configValue);

              if (isDebug) {
                System.out.println("Ourconfig - variable=" + configKey + " value=" + configValue);
              }
            }

            continue;
          }

          settingLine = settingLine.substring(4);
          equalPos = settingLine.indexOf("=");
          if (~equalPos != 0) {
            configKey = settingLine.substring(0, equalPos).trim().toLowerCase();
            configValue = settingLine.substring(equalPos - -1).trim();
            if (configKey.startsWith("lang")) {
              try {
                Integer.parseInt(configKey.substring(4));
                ++langCount;
              } catch (NumberFormatException ignored) {
              }
            }

            localeStrings.put(configKey, configValue);

            if (isDebug) {
              System.out.println("Message - name=" + configKey + " text=" + configValue);
            }
          }

          continue;
        }

        settingLine = settingLine.substring(6);
        equalPos = settingLine.indexOf("=");
        if (equalPos != -1) {
          configKey = settingLine.substring(0, equalPos).trim().toLowerCase();
          configValue = settingLine.substring(1 + equalPos).trim();
          params.put(configKey, configValue);
          if (isDebug) {
            System.out.println("Innerconfig - variable=" + configKey + " value=" + configValue);
          }
        }
      } while (true);

      configReader.close();
    } catch (IOException e) {
      if (isDebug) {
        e.printStackTrace();
      }

      ModalDialog.displayErrorMessage(getLocaleString("err_load_config"));
    } catch (Exception e) {
      if (isDebug) {
        e.printStackTrace();
      }

      ModalDialog.displayErrorMessage(getLocaleString("err_decode_config"));
    }

    if (langCount > 0) {
      languageIDs = new int[langCount];
      String[] localeStringList = new String[langCount];
      int i = 0;
      Enumeration<String> localeStringKeys = localeStrings.keys();

      label136:
      do {
        while (true) {
          if (!localeStringKeys.hasMoreElements()) {
            break label136;
          }

          String localeString = localeStringKeys.nextElement();
          if (!localeString.startsWith("lang")) {
            break;
          }

          int languageID;

          try {
            // Example of expected format of `localeString`: "lang0"
            languageID = Integer.parseInt(localeString.substring(4));
          } catch (NumberFormatException var16) {
            continue;
          }

          int index = 0;

          while (i >= index) {
            /*
             * Sort the arrays by language ID
             *
             * Given languageID == 0
             * and
             * languageIDs == [1,2,3,0] // [3] is uninitialized
             *
             * The resulting array should be: [0,1,2,3]
             *
             * and localeStringList should be modified to match
             */
            if (i == index || languageID < languageIDs[index]) {
              equalPos = i;

              while (equalPos > index) {
                localeStringList[equalPos] = localeStringList[equalPos - 1];
                languageIDs[equalPos] = languageIDs[equalPos - 1];

                --equalPos;
              }

              languageIDs[index] = languageID;
              localeStringList[index] = getLocaleString(localeString);
              break;
            }

            ++index;
          }

          ++i;
          break;
        }
      } while (true);

      languageSelectionDialog = new ListDialog(getLocaleString("language"));
      languageSelectionDialog.initializeList(localeStringList);
      if (~severSettingsCount < -1) {
        serverSettingsList = new ServerSettings[severSettingsCount];
        System.arraycopy(servers, 0, serverSettingsList, 0, severSettingsCount);
        serverSelectionDialog = new ListDialog(getLocaleString("switchserver"));
      }

      if (AppletViewerPreferences.getPreference("Language").isEmpty()) {
        selectPreferredLanguageHandler();
      }
    }
  }

  // $FF: renamed from: d (int) int
  static int selectPreferredLanguageHandler() {
    int languageID = languageSelectionDialog.prompt();

    if (languageID >= 0 && languageID < languageIDs.length) {
      AppletViewerPreferences.addPreference(Integer.toString(languageIDs[languageID]), "Language");
      AppletViewerPreferences.writePreferencesToFile();
      return languageID;
    } else {
      return -1;
    }
  }

  /**
   * Set our internal flag specifying if we should respect the `applet_(max|min)size` settings.
   *
   * <p>In the case that we update this flag, make a call to `setComponentBounds()` otherwise
   * perform a no-op.
   *
   * @param shouldIgnoreAppletBounds Should we ignore the applet_(max|min)size settings?
   */
  public static void setShouldRestrictAppletSize(boolean shouldIgnoreAppletBounds) {
    if (shouldIgnoreAppletBounds) {
      if (shouldRestrictAppletSize) {
        shouldRestrictAppletSize = false;

        setComponentBounds();
      }
    } else if (!shouldRestrictAppletSize) {
      shouldRestrictAppletSize = true;

      setComponentBounds();
    }
  }

  public static void readdadvert() {
    if (isWindows && null == advertComponent) {
      advertComponent = new Canvas();
      innerContainer.add(advertComponent);
      setComponentBounds();

      while (!advertComponent.isDisplayable() || !advertComponent.isShowing()) {
        try {
          Thread.sleep(100L);
        } catch (Exception ignored) {
        }
      }

      try {
        browsercontrol.create(advertComponent, getConfigValue("adverturl"));
        browsercontrol.resize(advertComponent.getSize().width, advertComponent.getSize().height);
      } catch (Throwable var2) {
        if (isDebug) {
          var2.printStackTrace();
        }

        ModalDialog.displayErrorMessage(getLocaleString("err_create_advertising"));
      }
    }
  }

  // $FF: renamed from: b (int, java.lang.String) java.lang.String
  private static String resolveConfigURLTemplate(String template) {
    String configURL = template;

    do {
      int templateStartPos = configURL.indexOf("$(");

      if (templateStartPos == -1) {
        break;
      }

      int variableSeparatorPos = configURL.indexOf(":", templateStartPos);
      int variableEndPos = configURL.indexOf(")", variableSeparatorPos);

      if (-1 < ~variableSeparatorPos || 0 > variableEndPos) {
        break;
      }

      String variableName = configURL.substring(2 + templateStartPos, variableSeparatorPos);
      String defaultValue = configURL.substring(1 + variableSeparatorPos, variableEndPos);
      Optional<String> preferenceValue = AppletViewerPreferences.getPreference(variableName);

      if (preferenceValue.isPresent()) {
        defaultValue = preferenceValue.get();
      }

      if (variableEndPos < -1 + configURL.length()) {
        configURL =
            configURL.substring(0, templateStartPos)
                + defaultValue
                + configURL.substring(variableEndPos - -1);

        continue;
      }

      configURL = configURL.substring(0, templateStartPos) + defaultValue;
    } while (true);

    return configURL;
  }

  public final void componentShown(ComponentEvent var1) {}
}
