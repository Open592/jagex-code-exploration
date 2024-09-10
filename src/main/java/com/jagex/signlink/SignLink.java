package com.jagex.signlink;

import java.applet.Applet;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.Transferable;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Vector;

public final class SignLink implements Runnable {

	private Interface10 anInterface10_1;

	private Message headMessage = null;

	private Message tailMessage = null;

	public Applet hostApplet = null;

	private boolean isShuttingDown = false;

	public FileOnDisk randomFile = null;

	public FileOnDisk cacheDataFile = null;

	public FileOnDisk cacheIndex255 = null;

	public FileOnDisk[] cacheArchiveFiles;

	private final String gameName;

	private final int modewhat;

	public EventQueue systemEventQueue;

	private final Thread thread;

	public static String systemUserHome;

	public static String systemOSName;

	public static String systemOSArch;

	public static String systemOSVersion;

	public static String javaVendor;

	public static String javaVersion;

	public static String systemOSNameLowerCase;

	public static Method setFocusTraversalKeysEnabled;

	public static Method setFocusCycleRoot;

	public static Hashtable<String, File> resolvedCacheFilePaths = new Hashtable<>(16);

	public static final int anInt1987 = 3;

	public static volatile long refuseConnectionsUntilTimestamp = 0L;

	private FullScreenManager fullScreenManager;

	private CursorManager cursorManager;

	private static void bumpAWTThreadPriority() {
		ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();

		for (ThreadGroup parent = threadGroup.getParent(); parent != null; parent = threadGroup.getParent()) {
			threadGroup = parent;
		}

		Thread[] list = new Thread[1000];

		threadGroup.enumerate(list);

		Arrays.stream(list)
				.filter(thread -> thread != null && thread.getName().startsWith("AWT"))
				.forEach(awtThread -> awtThread.setPriority(1));
	}

	private static File resolveCacheFilePath(String filename, int modewhat, String cacheSubDirectoryName) {
		File cachedFilePath = resolvedCacheFilePaths.get(filename);

		if (cachedFilePath != null) {
			return cachedFilePath;
		}

		String[] potentialParentDirectories = new String[] { "c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", systemUserHome, "/tmp/", "" };
		String[] potentialCacheDirectories = new String[] { ".jagex_cache_" + modewhat, ".file_store_" + modewhat };

		for (int cacheFindPass = 0; cacheFindPass < 2; cacheFindPass++) {
			for (String potentialCacheDirectory : potentialCacheDirectories) {
				for (String potentialParentDirectory : potentialParentDirectories) {
					String fullFilePath = potentialParentDirectory + potentialCacheDirectory + "/" + (cacheSubDirectoryName == null ? "" : cacheSubDirectoryName + "/") + filename;
					RandomAccessFile randomAccessFile = null;

					try {
						File filePath = new File(fullFilePath);

						if (cacheFindPass != 0 || filePath.exists()) {
							if (cacheFindPass != 1 || potentialParentDirectory.isEmpty() || (new File(potentialParentDirectory)).exists()) {
								(new File(potentialParentDirectory + potentialCacheDirectory)).mkdir();

								if (cacheSubDirectoryName != null) {
									(new File(potentialParentDirectory + potentialCacheDirectory + "/" + cacheSubDirectoryName)).mkdir();
								}

								randomAccessFile = new RandomAccessFile(filePath, "rw");

								int singleFileDataByte = randomAccessFile.read();

								randomAccessFile.seek(0L);
								randomAccessFile.write(singleFileDataByte );
								randomAccessFile.seek(0L);
								randomAccessFile.close();

								resolvedCacheFilePaths.put(filename, filePath);

								return filePath;
							}
						}
					} catch (Exception e) {
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

		throw new RuntimeException();
	}

	private static FileOnDisk resolvePreferencesFileLocation(String id, String gameName, int modewhat) {
		String filename;

		if (modewhat == 33) {
			filename = "jagex_" + gameName + "_preferences" + id + "_rc.dat";
		} else if (modewhat == 34) {
			filename = "jagex_" + gameName + "_preferences" + id + "_wip.dat";
		} else {
			filename = "jagex_" + gameName + "_preferences" + id + ".dat";
		}

		String[] potentialParentDirectories = new String[] {
				"c:/rscache/",
				"/rscache/",
				systemUserHome,
				"c:/windows/",
				"c:/winnt",
				"c:/",
				"/tmp/",
				"",
		};

		for (String potentialParentDirectory : potentialParentDirectories) {
			if (!potentialParentDirectory.isEmpty() || (new File(potentialParentDirectory).exists())) {
				try {
					return new FileOnDisk(new File(potentialParentDirectory, filename), "rw", 10000L);
				} catch (Exception ignored) {
				}
			}
		}

		return null;
	}

	public SignLink(Applet hostApplet, int modewhat, String gameName, int cacheArchiveCount) throws Exception {
		this.hostApplet = hostApplet;
		this.modewhat = modewhat;
		this.gameName = gameName;

		javaVendor = "Unknown";
		javaVersion = "1.1";
		try {
			javaVendor = System.getProperty("java.vendor");
			javaVersion = System.getProperty("java.version");
		} catch (Exception ignored) {
		}

		try {
			systemOSName = System.getProperty("os.name");
		} catch (Exception local48) {
			systemOSName = "Unknown";
		}

		systemOSNameLowerCase = systemOSName.toLowerCase();

		try {
			systemOSArch = System.getProperty("os.arch").toLowerCase();
		} catch (Exception local59) {
			systemOSArch = "";
		}

		try {
			systemOSVersion = System.getProperty("os.version").toLowerCase();
		} catch (Exception local67) {
			systemOSVersion = "";
		}

		try {
			systemUserHome = System.getProperty("user.home");

			if (systemUserHome != null) {
				systemUserHome = systemUserHome + "/";
			}
		} catch (Exception ignored) {
		}

		if (systemUserHome == null) {
			systemUserHome = "~/";
		}

		try {
			this.systemEventQueue = Toolkit.getDefaultToolkit().getSystemEventQueue();
		} catch (Throwable ignored) {
		}

		try {
			if (hostApplet != null) {
				setFocusTraversalKeysEnabled = hostApplet.getClass().getMethod("setFocusTraversalKeysEnabled", Boolean.TYPE);
			} else {
				setFocusTraversalKeysEnabled = Class.forName("java.awt.Component").getDeclaredMethod("setFocusTraversalKeysEnabled", Boolean.TYPE);
			}
		} catch (Exception ignored) {
		}

		try {
			if (hostApplet != null) {
				setFocusCycleRoot = hostApplet.getClass().getMethod("setFocusCycleRoot", Boolean.TYPE);
			} else {
				setFocusCycleRoot = Class.forName("java.awt.Container").getDeclaredMethod("setFocusCycleRoot", Boolean.TYPE);
			}
		} catch (Exception ignored) {
		}

		this.randomFile = new FileOnDisk(resolveCacheFilePath("random.dat", this.modewhat, null), "rw", 25L);
		this.cacheDataFile = new FileOnDisk(this.resolveCacheFilePath("main_file_cache.dat2"), "rw", 209715200L);
		this.cacheIndex255 = new FileOnDisk(this.resolveCacheFilePath("main_file_cache.idx255"), "rw", 1048576L);
		this.cacheArchiveFiles = new FileOnDisk[cacheArchiveCount];

		for (int i = 0; i < cacheArchiveCount; i++) {
			this.cacheArchiveFiles[i] = new FileOnDisk(this.resolveCacheFilePath("main_file_cache.idx" + i), "rw", 1048576L);
		}

		try {
			fullScreenManager = new FullScreenManager();
		} catch (Throwable ignored) {
		}

		try {
			cursorManager = new CursorManager();
		} catch (Throwable ignored) {
		}

		bumpAWTThreadPriority();

		this.isShuttingDown = false;
		this.thread = new Thread(this);
		this.thread.setPriority(10);
		this.thread.setDaemon(true);
		this.thread.start();
	}

	@Override
	public void run() {
		while (true) {
			Message message;

			synchronized (this) {
				while (true) {
					if (this.isShuttingDown) {
						return;
					}

					if (this.headMessage != null) {
						message = this.headMessage;
						this.headMessage = this.headMessage.next;

						if (this.headMessage == null) {
							this.tailMessage = null;
						}

						break;
					}

					try {
						this.wait();
					} catch (InterruptedException ignored) {
					}
				}
			}

			try {
				switch (message.type) {
					case Message.CONNECTION_INITIALIZATION_MESSAGE:
						performConnectionInitialization(message);

						break;
					case Message.THREAD_INITIALIZATION_MESSAGE:
						performThreadInitialization(message);

						break;
					case Message.REVERSE_IP_LOOKUP_MESSAGE:
						performReverseIPLookup(message);

						break;
					case Message.OPEN_URL_STREAM_MESSAGE:
						performOpenURLStream(message);

						break;
					case Message.GET_FULLSCREEN_DISPLAY_MODES_MESSAGE:
						performGetFullscreenDisplayModes(message);

						break;
					case Message.ENTER_FULLSCREEN_MODE_MESSAGE:
						performEnterFullscreenMode(message);

						break;
					case Message.EXIT_FULLSCREEN_MODE_MESSAGE:
						performExitFullscreenMode(message);

						break;
					case Message.GET_DECLARED_METHOD_MESSAGE:
						performGetDeclaredMethod(message);

						break;
					case Message.GET_DECLARED_FIELD_MESSAGE:
						performGetDeclaredField(message);

						break;
					case Message.PERFORM_CLASS_LOADER_NATIVE_LIBRARIES_CLEANUP_MESSAGE:
						performClassLoaderNativeLibrariesCleanup(message);

						break;
					case Message.RESOLVE_PREFERENCES_FILE_LOCATION_MESSAGE:
						performResolvePreferencesFileLocation(message);

						break;
					case Message.CUSTOM_CURSOR_MOUSE_MOVE_MESSAGE:
						performCustomCursorMouseMove(message);

						break;
					case Message.SET_CUSTOM_CURSOR_COMPONENT_MESSAGE:
						performSetCustomCursorComponent(message);

						break;
					case Message.OPEN_URL_IN_BROWSER_MESSAGE:
						performOpenURLInBrowser(message);

						break;
					case Message.SET_CUSTOM_CURSOR_MESSAGE:
						performSetCustomCursor(message);

						break;
					case Message.GET_SYSTEM_CLIPBOARD_CONTENTS_MESSAGE:
						performGetSystemClipboardContents(message);

						break;
					case Message.SET_SYSTEM_CLIPBOARD_CONTENTS_MESSAGE:
						performSetSystemClipboardContents(message);

						break;
					case Message.LOAD_JAG_MISC_NATIVES_MESSAGE:
						performLoadJagMiscNatives(message);

						break;
					default: throw new Exception();
				}

				message.status = 1;
			} catch (ThreadDeath e) {
				throw e;
			} catch (Throwable e) {
				message.status = 2;
			}

			synchronized (message) {
				message.notify();
			}
		}
	}

	public Message emitConnectionInitializationMessage(String host, int port) {
		return this.enqueueMessage(Message.CONNECTION_INITIALIZATION_MESSAGE, port, 0, host);
	}

	public Message emitThreadInitializationMessage(int priority, Runnable target) {
		return this.enqueueMessage(Message.THREAD_INITIALIZATION_MESSAGE, priority, 0, target);
	}

	public Message emitReverseIPLookupMessage(int ip) {
		return this.enqueueMessage(Message.REVERSE_IP_LOOKUP_MESSAGE, ip, 0, null);
	}

	public Message emitOpenURLStreamMessage(URL url) {
		return this.enqueueMessage(Message.OPEN_URL_STREAM_MESSAGE, 0, 0, url);
	}

	public Message emitGetFullScreenDisplayModesMessage() {
		return this.enqueueMessage(Message.GET_FULLSCREEN_DISPLAY_MODES_MESSAGE, 0, 0, null);
	}

	public Message emitEnterFullScreenModeMessage(int arg0, int arg1, int arg2) {
		return this.enqueueMessage(
			Message.ENTER_FULLSCREEN_MODE_MESSAGE,
			(arg2 << 16) + arg0,
			arg1 << 16,
			null
		);
	}

	public Message emitExitFullScreenModeMessage(Frame frame) {
		return this.enqueueMessage(Message.EXIT_FULLSCREEN_MODE_MESSAGE, 0, 0, frame);
	}

	public Message emitGetDeclaredMethodMessage(Class<?> clazz, String methodName, Class<?>[] parameterTypes) {
		return this.enqueueMessage(Message.GET_DECLARED_METHOD_MESSAGE, 0, 0, new Object[] { clazz, methodName, parameterTypes });
	}

	public Message emitGetDeclaredFieldMessage(Class<?> clazz, String fieldName) {
		return this.enqueueMessage(Message.GET_DECLARED_FIELD_MESSAGE, 0, 0, new Object[] { clazz, fieldName });
	}

	public Message emitPerformClassLoaderNativeLibrariesCleanupMessage(Class<?> fromClass) {
		return this.enqueueMessage(Message.PERFORM_CLASS_LOADER_NATIVE_LIBRARIES_CLEANUP_MESSAGE, 0, 0, fromClass);
	}

	public Message emitResolvePreferencesFileLocationMessage(String id) {
		return this.enqueueMessage(Message.RESOLVE_PREFERENCES_FILE_LOCATION_MESSAGE, 0, 0, id);
	}

	public Message emitOpenURLInBrowserMessage(String url) {
		return this.enqueueMessage(Message.OPEN_URL_IN_BROWSER_MESSAGE, 0, 0, url);
	}

	public Message emitSetCustomCursorMessage(Component component, int width, int height, int[] rgbArray, Point hotSpot) {
		return this.enqueueMessage(Message.SET_CUSTOM_CURSOR_MESSAGE, width, height, new Object[] { component, rgbArray, hotSpot });
	}

	public Message emitLoadJagMiscNativesMessage(Class<?> fromClass) {
		return this.enqueueMessage(Message.LOAD_JAG_MISC_NATIVES_MESSAGE, 0, 0, fromClass);
	}

	public void loadGlNatives(Class<?> fromClass) throws Exception {
		Runtime runtime = Runtime.getRuntime();
		Method setAccessibleMethod = Class.forName("java.lang.reflect.Method").getMethod("setAccessible", Boolean.TYPE);
		Method loadMethod;

		if (!systemOSNameLowerCase.startsWith("mac")) {
			loadMethod = Class.forName("java.lang.Runtime").getDeclaredMethod("loadLibrary0", Class.class, String.class);

			setAccessibleMethod.invoke(loadMethod, Boolean.TRUE);

			loadMethod.invoke(runtime, fromClass, "jawt");

			setAccessibleMethod.invoke(loadMethod, Boolean.FALSE);
		}

		loadMethod = Class.forName("java.lang.Runtime").getDeclaredMethod("load0", Class.class, String.class);

		setAccessibleMethod.invoke(loadMethod, Boolean.TRUE);

		if (!systemOSNameLowerCase.startsWith("win")) {
			throw new Exception();
		}

		loadMethod.invoke(runtime, fromClass, this.resolveCacheFilePath("sw3d.dll").toString());

		setAccessibleMethod.invoke(loadMethod, Boolean.FALSE);
	}

	public File resolveCacheFilePath(String filename) {
		return resolveCacheFilePath(filename, this.modewhat, this.gameName);
	}

	public void refuseConnectionForFiveSeconds() {
		refuseConnectionsUntilTimestamp = MonotonicClock.getCurrentTimeInMilliseconds() + 5000L;
	}

	public void shutdown() {
		synchronized (this) {
			this.isShuttingDown = true;
			this.notifyAll();
		}

		try {
			this.thread.join();
		} catch (InterruptedException ignored) {
		}

		if (this.cacheDataFile != null) {
			try {
				this.cacheDataFile.close();
			} catch (IOException ignored) {
			}
		}

		if (this.cacheIndex255 != null) {
			try {
				this.cacheIndex255.close();
			} catch (IOException ignored) {
			}
		}

		if (this.cacheArchiveFiles != null) {
            for (FileOnDisk cacheArchiveFile : this.cacheArchiveFiles) {
                if (cacheArchiveFile != null) {
                    try {
                        cacheArchiveFile.close();
                    } catch (IOException ignored) {
                    }
                }
            }
		}

		if (this.randomFile != null) {
			try {
				this.randomFile.close();
			} catch (IOException ignored) {
			}
		}
	}

	public Interface10 method1734() {
		return this.anInterface10_1;
	}

	private Message enqueueMessage(int type, int firstIntegerInput, int secondIntegerInput, Object genericInput) {
		Message message = new Message(type, firstIntegerInput, secondIntegerInput, genericInput);

		enqueueMessage(message);

		return message;
	}

	private void enqueueMessage(Message message) {
		synchronized (this) {
			if (this.tailMessage == null) {
				this.tailMessage = this.headMessage = message;
			} else {
				this.tailMessage.next = message;
				this.tailMessage = message;
			}

			this.notify();
		}
	}

	private Message emitCustomCursorMouseMoveMessage(Component component, int x, int y) {
		Point local7 = component.getLocationOnScreen();

		return this.enqueueMessage(Message.CUSTOM_CURSOR_MOUSE_MOVE_MESSAGE, x + local7.x, local7.y + y, null);
	}

	private Message emitSetCustomCursorComponentMessage(Component component, boolean shouldReset) {
		return this.enqueueMessage(Message.SET_CUSTOM_CURSOR_COMPONENT_MESSAGE, shouldReset ? 1 : 0, 0, component);
	}

	private Message emitGetSystemClipboardContentsMessage() {
		return this.enqueueMessage(Message.GET_SYSTEM_CLIPBOARD_CONTENTS_MESSAGE, 0, 0, null);
	}

	private Message emitSetSystemClipboardContentsMessage(Transferable contents) {
		return this.enqueueMessage(Message.SET_SYSTEM_CLIPBOARD_CONTENTS_MESSAGE, 0, 0, contents);
	}

	private void performConnectionInitialization(Message message) throws IOException {
		if (refuseConnectionsUntilTimestamp > MonotonicClock.getCurrentTimeInMilliseconds()) {
			throw new IOException();
		}

		message.output = new Socket(InetAddress.getByName((String) message.genericInput), message.firstIntegerInput);
	}

	private void performThreadInitialization(Message message) {
		Thread thread = new Thread((Runnable) message.genericInput);

		thread.setDaemon(true);
		thread.start();
		thread.setPriority(message.firstIntegerInput);

		message.output = thread;
	}

	private void performReverseIPLookup(Message message) throws IOException {
		if (refuseConnectionsUntilTimestamp > MonotonicClock.getCurrentTimeInMilliseconds()) {
			throw new IOException();
		}

		String host = ((message.firstIntegerInput >> 24) & 255) + "." +
				((message.firstIntegerInput >> 16) & 255) + "." +
				((message.firstIntegerInput >> 8) & 255) + "." +
				(message.firstIntegerInput & 255);

		message.output = InetAddress.getByName(host).getHostName();
	}

	private void performOpenURLStream(Message message) throws IOException {
		if (refuseConnectionsUntilTimestamp > MonotonicClock.getCurrentTimeInMilliseconds()) {
			throw new IOException();
		}

		message.output = new DataInputStream(((URL) message.genericInput).openStream());
	}

	private void performGetFullscreenDisplayModes(Message message) {
		message.output = fullScreenManager.getDisplayModes();
	}

	private void performEnterFullscreenMode(Message message) {
		Frame window = new Frame("Jagex Full Screen");

		message.output = window;

		window.setResizable(false);

		this.fullScreenManager.enterFullscreen(
				window,
				message.firstIntegerInput >>> 16,
				message.firstIntegerInput & 0xFFFF,
				message.secondIntegerInput >> 16,
				message.secondIntegerInput & 0xFFFF
		);
	}

	private void performExitFullscreenMode(Message message) {
		this.fullScreenManager.exitFullScreen();
	}

	private void performGetDeclaredMethod(Message message) throws NoSuchMethodException {
		Object[] input = (Object[]) message.genericInput;

		if (((Class<?>) input[0]).getClassLoader() == null) {
			throw new SecurityException();
		}

		message.output = ((Class<?>) input[0]).getDeclaredMethod((String) input[1], (Class<?>[]) input[2]);
	}

	private void performGetDeclaredField(Message message) throws NoSuchFieldException {
		Object[] input = (Object[]) message.genericInput;

		if (((Class<?>) input[0]).getClassLoader() == null) {
			throw new SecurityException();
		}

		message.output = ((Class<?>) input[0]).getDeclaredField((String) input[1]);
	}

	private void performClassLoaderNativeLibrariesCleanup(Message message)
			throws 	ClassNotFoundException,
					NoSuchFieldException,
					NoSuchMethodException,
					IllegalAccessException,
					InvocationTargetException
	{
		Field nativeLibrariesField = Class.forName("java.lang.ClassLoader").getDeclaredField("nativeLibraries");

		nativeLibrariesField.setAccessible(true);

		Vector<?> nativeLibraries = (Vector<?>) nativeLibrariesField.get(((Class<?>) message.genericInput).getClassLoader());

		for (Object library : nativeLibraries) {
			Method finalizeMethod = library.getClass().getDeclaredMethod("finalize");

			finalizeMethod.setAccessible(true);
			finalizeMethod.invoke(library);
			finalizeMethod.setAccessible(false);

			Field handleField = library.getClass().getDeclaredField("handle");
			handleField.setAccessible(true);
			handleField.set(library, 0);
			handleField.setAccessible(false);
		}

		nativeLibrariesField.setAccessible(false);
	}

	private void performResolvePreferencesFileLocation(Message message) {
		message.output = resolvePreferencesFileLocation((String) message.genericInput, gameName, modewhat);
	}

	private void performCustomCursorMouseMove(Message message) {
		int x = message.firstIntegerInput;
		int y = message.secondIntegerInput;

		this.cursorManager.mouseMove(x, y);
	}

	private void performSetCustomCursorComponent(Message message) {
		boolean shouldReset = message.firstIntegerInput != 0;
		Component component = (Component) message.genericInput;

		this.cursorManager.setComponent(shouldReset, component);
	}

	private void performOpenURLInBrowser(Message message) throws Exception {
		try {
			if (!systemOSName.startsWith("win")) {
				throw new Exception();
			}

			String url = (String) message.genericInput;

			if (!url.startsWith("http://") && !url.startsWith("https://")) {
				throw new Exception();
			}

			String validCharactersForUrl = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

			for (int i = 0; i < url.length(); i++) {
				if (validCharactersForUrl.indexOf(url.charAt(i)) < 0) {
					throw new Exception();
				}
			}

			Runtime.getRuntime().exec("cmd /c start \"j\" \"" + url + "\"");

			message.output = null;
		} catch (Exception e) {
			message.output = e;

			throw e;
		}
	}

	private void performSetCustomCursor(Message message) {
		Object[] input = (Object[]) message.genericInput;

		this.cursorManager.setCursor(
				(Component) input[0],
				message.firstIntegerInput,
				message.secondIntegerInput,
				(int[]) input[1],
				(Point) input[2]
		);
	}

	private void performGetSystemClipboardContents(Message message) {
		Clipboard systemClipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

		message.output = systemClipboard.getContents(null);
	}

	private void performSetSystemClipboardContents(Message message) {
		Transferable contents = (Transferable) message.genericInput;
		Clipboard systemClipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

		systemClipboard.setContents(contents, null);
	}

	private void performLoadJagMiscNatives(Message message) {
		try {
			Runtime runtime = Runtime.getRuntime();
			Method load0Method = Class.forName("java.lang.Runtime")
					.getDeclaredMethod("load0", Class.class, String.class);

			load0Method.setAccessible(true);

			if (systemOSName.startsWith("win")) {
				if (!systemOSArch.startsWith("amd64") && !systemOSArch.startsWith("x86_64")) {
					load0Method.invoke(runtime, message.genericInput, resolveCacheFilePath("jagmisc.dll").toString());
				} else {
					load0Method.invoke(runtime, message.genericInput, resolveCacheFilePath("jagmisc64.dll").toString());
				}
			}

			load0Method.setAccessible(false);
		} catch (Throwable e) {
			message.output = e;
		}
	}

	public boolean method1754() {
		return false;
	}
}
