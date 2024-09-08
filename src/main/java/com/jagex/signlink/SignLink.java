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
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.util.Hashtable;
import java.util.Vector;

public final class SignLink implements Runnable {

	private Interface10 anInterface10_1;

	public FileOnDisk[] aFileOnDiskArray1;

	private Message headMessage = null;

	private Message tailMessage = null;

	public FileOnDisk aFileOnDisk_1 = null;

	public Applet hostApplet = null;

	private boolean isShuttingDown = false;

	public FileOnDisk aFileOnDisk_2 = null;

	public FileOnDisk aFileOnDisk_3 = null;

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

	public SignLink(Applet hostApplet, int modewhat, String gameName, int arg3) throws Exception {
		this.hostApplet = hostApplet;
		this.gameName = gameName;
		javaVersion = "1.1";
		this.modewhat = modewhat;
		javaVendor = "Unknown";

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
			if (hostApplet == null) {
				setFocusTraversalKeysEnabled = Class.forName("java.awt.Component").getDeclaredMethod("setFocusTraversalKeysEnabled", Boolean.TYPE);
			} else {
				setFocusTraversalKeysEnabled = hostApplet.getClass().getMethod("setFocusTraversalKeysEnabled", Boolean.TYPE);
			}
		} catch (Exception ignored) {
		}

		try {
			if (hostApplet == null) {
				setFocusCycleRoot = Class.forName("java.awt.Container").getDeclaredMethod("setFocusCycleRoot", Boolean.TYPE);
			} else {
				setFocusCycleRoot = hostApplet.getClass().getMethod("setFocusCycleRoot", Boolean.TYPE);
			}
		} catch (Exception ignored) {
		}

		try {
			fullScreenManager = new FullScreenManager();
		} catch (Throwable ignored) {
		}

		this.isShuttingDown = false;
		this.thread = new Thread(this);
		this.thread.setPriority(10);
		this.thread.setDaemon(true);
		this.thread.start();
	}

	public Message method1726(int arg0, int arg1, int arg2) {
		return this.emitMessage(
			(arg2 << 16) + arg0,
			arg1 << 16,
			null,
			0,
			6
		);
	}

	public Message method1727(Frame arg0) {
		return this.emitMessage(0, 0, arg0, 0, 7);
	}

	public Message emitConnectionInitializationMessage(String host, int port) {
		return this.emitMessage(port, 0, host, 0, 1);
	}

	private byte[] method1729(String arg0, int arg1) {
		Message local7 = this.method1749(arg0, 0, 0, 21);
		if (arg1 != 14) {
			this.resolveCacheFilePath(null);
		}
		return (byte[]) local7.output;
	}

	public Message method1730(Class[] arg0, String arg1, Class arg2) {
		return this.emitMessage(0, 0, new Object[] { arg2, arg1, arg0 }, 0, 8);
	}

	private Message method1731(byte arg0) {
		return arg0 == -128 ? this.emitMessage(0, 0, null, arg0 + 128, 18) : null;
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

		if (this.aFileOnDisk_3 != null) {
			try {
				this.aFileOnDisk_3.close();
			} catch (IOException ignored) {
			}
		}

		if (this.aFileOnDisk_1 != null) {
			try {
				this.aFileOnDisk_1.close();
			} catch (IOException ignored) {
			}
		}

		if (this.aFileOnDiskArray1 != null) {
            for (FileOnDisk fileOnDisk : this.aFileOnDiskArray1) {
                if (fileOnDisk != null) {
                    try {
                        fileOnDisk.close();
                    } catch (IOException ignored) {
                    }
                }
            }
		}

		if (this.aFileOnDisk_2 != null) {
			try {
				this.aFileOnDisk_2.close();
			} catch (IOException ignored) {
			}
		}
	}

	public File resolveCacheFilePath(String filename) {
		return resolveCacheFilePath(filename, this.modewhat, this.gameName);
	}

	public Interface10 method1734() {
		return this.anInterface10_1;
	}

	private Message method1735(int arg0, Component arg1, boolean arg2) {
		if (arg0 != -23993) {
			this.refuseConnectionForFiveSeconds();
		}

		return this.emitMessage(arg2 ? 1 : 0, 0, arg1, 0, 15);
	}

	public Message method1736(Class arg0) {
		return this.emitMessage(0, 0, arg0, 0, 20);
	}

	private Message emitMessage(int firstIntegerInput, int secondIntegerInput, Object genericInput, int arg3, int messageType) {
		Message message = new Message();

		message.firstIntegerInput = firstIntegerInput;
		message.secondIntegerInput = secondIntegerInput;
		message.genericInput = genericInput;
		message.type = messageType;

		synchronized (this) {
			if (this.tailMessage == null) {
				this.tailMessage = this.headMessage = message;
			} else {
				this.tailMessage.next = message;
				this.tailMessage = message;
			}

			this.notify();

			return message;
		}
	}

	public Message method1738(String arg0) {
		return this.emitMessage(0, 0, arg0, 0, 12);
	}

	public Message method1739(int arg0) {
		return this.emitMessage(arg0, 0, null, 0, 3);
	}

	public void method1740(Class arg0) throws Exception {
		Class[] parameterTypes = new Class[] {
				Class.forName("java.lang.Class"),
				Class.forName("java.lang.String")
		};
		Runtime runtime = Runtime.getRuntime();
		Method setAccessible = Class.forName("java.lang.reflect.Method").getMethod("setAccessible", Boolean.TYPE);
		Method loadMethod;

		if (!systemOSNameLowerCase.startsWith("mac")) {
			loadMethod = Class.forName("java.lang.Runtime").getDeclaredMethod("loadLibrary0", parameterTypes);
			setAccessible.invoke(loadMethod, Boolean.TRUE);
			loadMethod.invoke(runtime, arg0, "jawt");
			setAccessible.invoke(loadMethod, Boolean.FALSE);
		}

		loadMethod = Class.forName("java.lang.Runtime").getDeclaredMethod("load0", parameterTypes);
		setAccessible.invoke(loadMethod, Boolean.TRUE);

		if (!systemOSNameLowerCase.startsWith("win")) {
			throw new Exception();
		}

		loadMethod.invoke(runtime, arg0, this.resolveCacheFilePath("sw3d.dll").toString());
		setAccessible.invoke(loadMethod, Boolean.FALSE);
	}

	public Message emitThreadInitializationMessage(int arg0, Runnable target) {
		return this.emitMessage(arg0, 0, target, 0, 2);
	}

	private Message method1742(Transferable arg0, byte arg1) {
		return arg1 == 87 ? this.emitMessage(0, 0, arg0, 0, 19) : null;
	}

	public Message method1743(Point arg0, Component arg1, int arg2, int[] arg3, int arg4) {
		return this.emitMessage(arg2, arg4, new Object[] { arg1, arg3, arg0 }, 0, 17);
	}

	public Message method1744(String arg0) {
		return this.emitMessage(0, 0, arg0, 0, 16);
	}

	public Message method1745() {
		return this.emitMessage(0, 0, null, 0, 5);
	}

	public Message method1746(Class arg0) {
		return this.emitMessage(0, 0, arg0, 0, 11);
	}

	private Message method1747(Component arg0, boolean arg1, int arg2, int arg3) {
		if (arg1) {
			resolvedCacheFilePaths = null;
		}
		Point local7 = arg0.getLocationOnScreen();
		return this.emitMessage(arg2 + local7.x, local7.y + arg3, null, 0, 14);
	}

	private Message method1749(Object genericInput, int arg1, int integerInput, int messageType) {
		Message message = new Message();

		synchronized (message) {
			message.type = messageType;
			message.firstIntegerInput = integerInput;
			message.genericInput = genericInput;

			synchronized (this) {
				if (arg1 != 0) {
					return null;
				}

				if (this.tailMessage == null) {
					this.tailMessage = this.headMessage = message;
				} else {
					this.tailMessage.next = message;
					this.tailMessage = message;
				}

				this.notify();
			}

			try {
				message.wait();
			} catch (InterruptedException ignored) {
			}

			return message;
		}
	}

	public Message method1750(Class arg0, String arg1) {
		return this.emitMessage(0, 0, new Object[] { arg0, arg1 }, 0, 9);
	}

	public Message emitOpenURLConnectionMessage(URL url) {
		return this.emitMessage(0, 0, url, 0, 4);
	}

	private Message method1752(String arg0, int arg1) {
		if (arg1 <= 71) {
			this.method1747(null, true, 35, 67);
		}
		return this.emitMessage(0, 0, arg0, 0, 21);
	}

	public void refuseConnectionForFiveSeconds() {
		refuseConnectionsUntilTimestamp = MonotonicClock.getCurrentTimeInMilliseconds() + 5000L;
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
				int messageType = message.type;

				if (messageType == 1) {
					if (refuseConnectionsUntilTimestamp > MonotonicClock.getCurrentTimeInMilliseconds()) {
						throw new IOException();
					}

					message.output = new Socket(InetAddress.getByName((String) message.genericInput), message.firstIntegerInput);
				} else if (messageType == 2) {
					Thread thread = new Thread((Runnable) message.genericInput);

					thread.setDaemon(true);
					thread.start();
					thread.setPriority(message.firstIntegerInput);

					message.output = thread;
				} else if (messageType == 3) {
					if (refuseConnectionsUntilTimestamp > MonotonicClock.getCurrentTimeInMilliseconds()) {
						throw new IOException();
					}

					String host = ((message.firstIntegerInput >> 24) & 255) + "." +
                            ((message.firstIntegerInput >> 16) & 255) + "." +
                            ((message.firstIntegerInput >> 8) & 255) + "." +
                            (message.firstIntegerInput & 255);
					message.output = InetAddress.getByName(host).getHostName();
				} else if (messageType == 4) {
					if (refuseConnectionsUntilTimestamp > MonotonicClock.getCurrentTimeInMilliseconds()) {
						throw new IOException();
					}

					message.output = new DataInputStream(((URL) message.genericInput).openStream());
				} else if (messageType == 5) {
					message.output = fullScreenManager.getDisplayModes();
				} else if (messageType == 6) {
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
				} else if (messageType == 7) {
					this.fullScreenManager.exitFullScreen();
				} else if (messageType == 8) {
					Object[] input = (Object[]) message.genericInput;

					if (((Class<?>) input[0]).getClassLoader() == null) {
						throw new SecurityException();
					}

					message.output = ((Class<?>) input[0]).getDeclaredMethod((String) input[1], (Class[]) input[2]);
				} else if (messageType == 9) {
					Object[] input = (Object[]) message.genericInput;

					if (((Class<?>) input[0]).getClassLoader() == null) {
						throw new SecurityException();
					}

					message.output = ((Class<?>) input[0]).getDeclaredField((String) input[1]);
				} else if (messageType == 11) {
					Field nativeLibrariesField = Class.forName("java.lang.ClassLoader").getDeclaredField("nativeLibraries");

					nativeLibrariesField.setAccessible(true);

					Vector nativeLibraries = (Vector) nativeLibrariesField.get(((Class) message.genericInput).getClassLoader());

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
				} else if (messageType == 12) {
                    message.output = resolvePreferencesFile((String) message.genericInput, gameName, modewhat);
				} else if (messageType == 18) {
					Clipboard systemClipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

					message.output = systemClipboard.getContents(null);
				} else if (messageType == 19) {
					Transferable contents = (Transferable) message.genericInput;
					Clipboard systemClipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

					systemClipboard.setContents(contents, null);
				} else if (messageType == 21) {
					if (refuseConnectionsUntilTimestamp > MonotonicClock.getCurrentTimeInMilliseconds()) {
						throw new IOException();
					}

					message.output = InetAddress.getByName((String) message.genericInput).getAddress();

				} else {
					throw new Exception();
				}

				message.status = 1;
			} catch (ThreadDeath local198) {
				throw local198;
			} catch (Throwable local201) {
				message.status = 2;
			}
			synchronized (message) {
				message.notify();
			}
		}
	}

	public static File resolveCacheFilePath(String filename, int modewhat, String gameName) {
		File cachedFilePath = resolvedCacheFilePaths.get(filename);

		if (cachedFilePath != null) {
			return cachedFilePath;
		}

		String[] potentialParentDirectories = new String[] { "c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", systemUserHome, "/tmp/", "" };
		String[] potentialCacheDirectories = new String[] { ".jagex_cache_" + modewhat, ".file_store_" + modewhat };

		for (int i = 0; i < 2; i++) {
            for (String potentialCacheDirectory : potentialCacheDirectories) {
                for (String potentialParentDirectory : potentialParentDirectories) {
                    String local105 = potentialParentDirectory + potentialCacheDirectory + "/" + (gameName == null ? "" : gameName + "/") + filename;
                    RandomAccessFile local107 = null;

                    try {
                        File local112 = new File(local105);

                        if (i != 0 || local112.exists()) {
                            if (i != 1 || potentialParentDirectory.length() <= 0 || (new File(potentialParentDirectory)).exists()) {
                                (new File(potentialParentDirectory + potentialCacheDirectory)).mkdir();

                                if (gameName != null) {
                                    (new File(potentialParentDirectory + potentialCacheDirectory + "/" + gameName)).mkdir();
                                }

                                local107 = new RandomAccessFile(local112, "rw");
                                int local185 = local107.read();
                                local107.seek(0L);
                                local107.write(local185);
                                local107.seek(0L);
                                local107.close();
                                resolvedCacheFilePaths.put(filename, local112);

                                return local112;
                            }
                        }
                    } catch (Exception e) {
                        try {
                            if (local107 != null) {
                                local107.close();
                            }
                        } catch (Exception ignored) {
                        }
                    }
                }
            }
		}
		throw new RuntimeException();
	}

	private static FileOnDisk resolvePreferencesFile(String id, String gameName, int modewhat) {
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

	public boolean method1754() {
		return false;
	}
}
