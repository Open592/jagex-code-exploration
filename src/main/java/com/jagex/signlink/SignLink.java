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
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.util.Hashtable;

public final class SignLink implements Runnable {

	private Interface10 anInterface10_1;

	public Class207[] aClass207Array1;

	private Class199 aClass199_4 = null;

	private Class199 aClass199_5 = null;

	public Class207 aClass207_1 = null;

	public Applet loaderApplet = null;

	private boolean aBoolean185 = false;

	public Class207 aClass207_2 = null;

	public Class207 aClass207_3 = null;

	private final String gameName;

	private final int modewhat;

	public EventQueue systemEventQueue;

	private final Thread aThread1;

	public static String systemUserHome;

	public static String systemOSName;

	public static String systemOSArch;

	public static String systemOSVersion;

	public static String javaVendor;

	public static String javaVersion;

	public static String systemOSNameLowerCase;

	public static Method aMethod1;

	public static Method aMethod2;

	public static Hashtable aHashtable1 = new Hashtable(16);

	public static final int anInt1987 = 3;

	public static volatile long aLong70 = 0L;

	public SignLink(Applet loaderApplet, int modewhat, String gameName, int arg3) throws Exception {
		this.loaderApplet = loaderApplet;
		this.gameName = gameName;
		javaVersion = "1.1";
		this.modewhat = modewhat;
		javaVendor = "Unknown";
		try {
			javaVendor = System.getProperty("java.vendor");
			javaVersion = System.getProperty("java.version");
		} catch (Exception local43) {
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
		} catch (Exception local85) {
		}
		if (systemUserHome == null) {
			systemUserHome = "~/";
		}
		try {
			this.systemEventQueue = Toolkit.getDefaultToolkit().getSystemEventQueue();
		} catch (Throwable local95) {
		}
		try {
			if (loaderApplet == null) {
				aMethod1 = Class.forName("java.awt.Component").getDeclaredMethod("setFocusTraversalKeysEnabled", Boolean.TYPE);
			} else {
				aMethod1 = loaderApplet.getClass().getMethod("setFocusTraversalKeysEnabled", Boolean.TYPE);
			}
		} catch (Exception local122) {
		}
		try {
			if (loaderApplet == null) {
				aMethod2 = Class.forName("java.awt.Container").getDeclaredMethod("setFocusCycleRoot", Boolean.TYPE);
			} else {
				aMethod2 = loaderApplet.getClass().getMethod("setFocusCycleRoot", Boolean.TYPE);
			}
		} catch (Exception local149) {
		}
		this.aBoolean185 = false;
		this.aThread1 = new Thread(this);
		this.aThread1.setPriority(10);
		this.aThread1.setDaemon(true);
		this.aThread1.start();
	}

	public Class199 method1726(int arg0, int arg1, int arg2) {
		return this.method1737((arg2 << 16) + arg0, arg1 << 16, null, 0, 6);
	}

	public Class199 method1727(Frame arg0) {
		return this.method1737(0, 0, arg0, 0, 7);
	}

	public Class199 method1728(String arg0, int arg1) {
		return this.method1737(arg1, 0, arg0, 0, 1);
	}

	private byte[] method1729(String arg0, int arg1) {
		Class199 local7 = this.method1749(arg0, 0, 0, 21);
		if (arg1 != 14) {
			this.resolveCacheFilePath(null);
		}
		return (byte[]) local7.anObject29;
	}

	public Class199 method1730(Class[] arg0, String arg1, Class arg2) {
		return this.method1737(0, 0, new Object[] { arg2, arg1, arg0 }, 0, 8);
	}

	private Class199 method1731(byte arg0) {
		return arg0 == -128 ? this.method1737(0, 0, null, arg0 + 128, 18) : null;
	}

	public void method1732() {
		synchronized (this) {
			this.aBoolean185 = true;
			this.notifyAll();
		}
		try {
			this.aThread1.join();
		} catch (InterruptedException local19) {
		}
		if (this.aClass207_3 != null) {
			try {
				this.aClass207_3.method4713();
			} catch (IOException local28) {
			}
		}
		if (this.aClass207_1 != null) {
			try {
				this.aClass207_1.method4713();
			} catch (IOException local38) {
			}
		}
		if (this.aClass207Array1 != null) {
			for (int local44 = 0; local44 < this.aClass207Array1.length; local44++) {
				if (this.aClass207Array1[local44] != null) {
					try {
						this.aClass207Array1[local44].method4713();
					} catch (IOException local58) {
					}
				}
			}
		}
		if (this.aClass207_2 != null) {
			try {
				this.aClass207_2.method4713();
			} catch (IOException local82) {
			}
		}
	}

	public File resolveCacheFilePath(String filename) {
		return resolveCacheFilePath(filename, this.modewhat, this.gameName);
	}

	public Interface10 method1734() {
		return this.anInterface10_1;
	}

	private Class199 method1735(int arg0, Component arg1, boolean arg2) {
		if (arg0 != -23993) {
			this.method1753();
		}

		return this.method1737(arg2 ? 1 : 0, 0, arg1, 0, 15);
	}

	public Class199 method1736(Class arg0) {
		return this.method1737(0, 0, arg0, 0, 20);
	}

	private Class199 method1737(int port, int arg1, Object arg2, int arg3, int arg4) {
		Class199 local3 = new Class199();
		local3.anInt5758 = port;
		local3.anObject28 = arg2;
		local3.anInt5759 = arg4;
		synchronized (this) {
			if (this.aClass199_5 == null) {
				this.aClass199_5 = this.aClass199_4 = local3;
			} else {
				this.aClass199_5.aClass199_9 = local3;
				this.aClass199_5 = local3;
			}
			this.notify();
			return local3;
		}
	}

	public Class199 method1738(String arg0) {
		return this.method1737(0, 0, arg0, 0, 12);
	}

	public Class199 method1739(int arg0) {
		return this.method1737(arg0, 0, null, 0, 3);
	}

	public void method1740(Class arg0) throws Exception {
		Class[] local12 = new Class[] { Class.forName("java.lang.Class"), Class.forName("java.lang.String") };
		Runtime local14 = Runtime.getRuntime();
		Method local25 = Class.forName("java.lang.reflect.Method").getMethod("setAccessible", Boolean.TYPE);
		Method local35;
		if (!systemOSNameLowerCase.startsWith("mac")) {
			local35 = Class.forName("java.lang.Runtime").getDeclaredMethod("loadLibrary0", local12);
			local25.invoke(local35, Boolean.TRUE);
			local35.invoke(local14, arg0, "jawt");
			local25.invoke(local35, Boolean.FALSE);
		}
		local35 = Class.forName("java.lang.Runtime").getDeclaredMethod("load0", local12);
		local25.invoke(local35, Boolean.TRUE);
		if (!systemOSNameLowerCase.startsWith("win")) {
			throw new Exception();
		}
		local35.invoke(local14, arg0, this.resolveCacheFilePath("sw3d.dll").toString());
		local25.invoke(local35, Boolean.FALSE);
	}

	public Class199 method1741(int arg0, Runnable arg1) {
		return this.method1737(arg0, 0, arg1, 0, 2);
	}

	private Class199 method1742(Transferable arg0, byte arg1) {
		return arg1 == 87 ? this.method1737(0, 0, arg0, 0, 19) : null;
	}

	public Class199 method1743(Point arg0, Component arg1, int arg2, int[] arg3, int arg4) {
		return this.method1737(arg2, arg4, new Object[] { arg1, arg3, arg0 }, 0, 17);
	}

	public Class199 method1744(String arg0) {
		return this.method1737(0, 0, arg0, 0, 16);
	}

	public Class199 method1745() {
		return this.method1737(0, 0, null, 0, 5);
	}

	public Class199 method1746(Class arg0) {
		return this.method1737(0, 0, arg0, 0, 11);
	}

	private Class199 method1747(Component arg0, boolean arg1, int arg2, int arg3) {
		if (arg1) {
			aHashtable1 = null;
		}
		Point local7 = arg0.getLocationOnScreen();
		return this.method1737(arg2 + local7.x, local7.y + arg3, null, 0, 14);
	}

	private Class199 method1749(Object arg0, int arg1, int arg2, int arg3) {
		Class199 local3 = new Class199();
		synchronized (local3) {
			local3.anInt5759 = arg3;
			local3.anInt5758 = arg2;
			local3.anObject28 = arg0;
			synchronized (this) {
				if (arg1 != 0) {
					return null;
				}
				if (this.aClass199_5 == null) {
					this.aClass199_5 = this.aClass199_4 = local3;
				} else {
					this.aClass199_5.aClass199_9 = local3;
					this.aClass199_5 = local3;
				}
				this.notify();
			}
			try {
				local3.wait();
			} catch (InterruptedException local59) {
			}
			return local3;
		}
	}

	public Class199 method1750(Class arg0, String arg1) {
		return this.method1737(0, 0, new Object[] { arg0, arg1 }, 0, 9);
	}

	public Class199 method1751(URL arg0) {
		return this.method1737(0, 0, arg0, 0, 4);
	}

	private Class199 method1752(String arg0, int arg1) {
		if (arg1 <= 71) {
			this.method1747(null, true, 35, 67);
		}
		return this.method1737(0, 0, arg0, 0, 21);
	}

	public void method1753() {
		aLong70 = Static282.method3962() + 5000L;
	}

	@Override
	public void run() {
		while (true) {
			Class199 local15;
			synchronized (this) {
				while (true) {
					if (this.aBoolean185) {
						return;
					}
					if (this.aClass199_4 != null) {
						local15 = this.aClass199_4;
						this.aClass199_4 = this.aClass199_4.aClass199_9;
						if (this.aClass199_4 == null) {
							this.aClass199_5 = null;
						}
						break;
					}
					try {
						this.wait();
					} catch (InterruptedException local31) {
					}
				}
			}
			try {
				int local41 = local15.anInt5759;
				if (local41 == 1) {
					if (aLong70 > Static282.method3962()) {
						throw new IOException();
					}
					local15.anObject29 = new Socket(InetAddress.getByName((String) local15.anObject28), local15.anInt5758);
				} else if (local41 == 2) {
					Thread local181 = new Thread((Runnable) local15.anObject28);
					local181.setDaemon(true);
					local181.start();
					local181.setPriority(local15.anInt5758);
					local15.anObject29 = local181;
				} else if (local41 == 4) {
					if (aLong70 > Static282.method3962()) {
						throw new IOException();
					}
					local15.anObject29 = new DataInputStream(((URL) local15.anObject28).openStream());
				} else {
					Object[] local107;
					if (local41 == 8) {
						local107 = (Object[]) local15.anObject28;
						local15.anObject29 = ((Class) local107[0]).getDeclaredMethod((String) local107[1], (Class[]) local107[2]);
					} else if (local41 == 9) {
						local107 = (Object[]) local15.anObject28;
						local15.anObject29 = ((Class) local107[0]).getDeclaredField((String) local107[1]);
					} else if (local41 == 18) {
						Clipboard local168 = Toolkit.getDefaultToolkit().getSystemClipboard();
						local15.anObject29 = local168.getContents(null);
					} else if (local41 == 19) {
						Transferable local152 = (Transferable) local15.anObject28;
						Clipboard local155 = Toolkit.getDefaultToolkit().getSystemClipboard();
						local155.setContents(local152, null);
					} else {
						throw new Exception("");
					}
				}
				local15.anInt5760 = 1;
			} catch (ThreadDeath local198) {
				throw local198;
			} catch (Throwable local201) {
				local15.anInt5760 = 2;
			}
			synchronized (local15) {
				local15.notify();
			}
		}
	}

	public static File resolveCacheFilePath(String filename, int modewhat, String gameName) {
		File local4 = (File) aHashtable1.get(filename);
		if (local4 != null) {
			return local4;
		}
		String[] local43 = new String[] { "c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", systemUserHome, "/tmp/", "" };
		String[] local66 = new String[] { ".jagex_cache_" + modewhat, ".file_store_" + modewhat };
		for (int local68 = 0; local68 < 2; local68++) {
			for (int local71 = 0; local71 < local66.length; local71++) {
				for (int local74 = 0; local74 < local43.length; local74++) {
					String local105 = local43[local74] + local66[local71] + "/" + (gameName == null ? "" : gameName + "/") + filename;
					RandomAccessFile local107 = null;
					try {
						File local112 = new File(local105);
						if (local68 != 0 || local112.exists()) {
							String local121 = local43[local74];
							if (local68 != 1 || local121.length() <= 0 || (new File(local121)).exists()) {
								(new File(local43[local74] + local66[local71])).mkdir();
								if (gameName != null) {
									(new File(local43[local74] + local66[local71] + "/" + gameName)).mkdir();
								}
								local107 = new RandomAccessFile(local112, "rw");
								int local185 = local107.read();
								local107.seek(0L);
								local107.write(local185);
								local107.seek(0L);
								local107.close();
								aHashtable1.put(filename, local112);
								return local112;
							}
						}
					} catch (Exception local204) {
						try {
							if (local107 != null) {
								local107.close();
							}
						} catch (Exception local212) {
						}
					}
				}
			}
		}
		throw new RuntimeException();
	}

	public boolean method1754() {
		return false;
	}
}
