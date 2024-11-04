package com.jagex.client;

import com.jagex.signlink.Message;
import com.jagex.signlink.SignLink;
import com.jagex.signlink.MonotonicClock;
import com.jagex.client.jagex3.jagmisc.jagmisc;
import java.applet.Applet;
import java.applet.AppletContext;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.lang.reflect.Method;
import java.net.URL;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!o")
public abstract class GameShell extends Applet implements Runnable, FocusListener, WindowListener {

	@OriginalMember(owner = "client!o", name = "x", descriptor = "Lclient!gn;")
	public static final Class84 aClass84_4 = new Class84();

	@OriginalMember(owner = "client!o", name = "N", descriptor = "Lclient!pn;")
	public static final Class186 aClass186_3 = new Class186("", 14);

	@OriginalMember(owner = "client!hd", name = "g", descriptor = "[J")
	public static final long[] aLongArray6 = new long[32];

	@OriginalMember(owner = "client!rm", name = "a", descriptor = "[J")
	public static final long[] aLongArray8 = new long[32];

	@OriginalMember(owner = "client!o", name = "O", descriptor = "[Lclient!at;")
	public static Class15[] aClass15Array2;

	@OriginalMember(owner = "client!o", name = "Q", descriptor = "F")
	public static float aFloat30;

	@OriginalMember(owner = "client!o", name = "P", descriptor = "I")
	public static int anInt970 = 0;

	@OriginalMember(owner = "client!eb", name = "g", descriptor = "J")
	public static volatile long aLong59 = 0L;

	@OriginalMember(owner = "client!nh", name = "G", descriptor = "Z")
	public static boolean isRunningModernJavaVersion = false;

	@OriginalMember(owner = "client!ir", name = "c", descriptor = "J")
	public static long timeToShutdown = 0L;

	@OriginalMember(owner = "client!cw", name = "Lb", descriptor = "Lclient!kk;")
	public static FrameTimer aFrameTimer_1;

	@OriginalMember(owner = "client!wa", name = "f", descriptor = "Lclient!o;")
	public static GameShell instance = null;

	/**
	 * Defaults to 50 FPS
	 */
	@OriginalMember(owner = "client!mg", name = "i", descriptor = "I")
	public static int frameTimeInMilliseconds = 20;

	@OriginalMember(owner = "client!kp", name = "J", descriptor = "I")
	public static int framesPerSecond = 0;

	@OriginalMember(owner = "client!ur", name = "f", descriptor = "I")
	public static int anInt6741;

	@OriginalMember(owner = "client!au", name = "K", descriptor = "I")
	public static int anInt290;

	@OriginalMember(owner = "client!ul", name = "H", descriptor = "I")
	public static int anInt6705;

	@OriginalMember(owner = "client!wt", name = "o", descriptor = "I")
	public static int graphicsStepCount = 500;

	@OriginalMember(owner = "client!ev", name = "G", descriptor = "Z")
	public static volatile boolean aBoolean189 = true;

	@OriginalMember(owner = "client!nt", name = "m", descriptor = "Ljava/awt/Canvas;")
	public static Canvas canvas;

	@OriginalMember(owner = "client!ll", name = "j", descriptor = "Ljava/awt/Frame;")
	public static Frame aFrame1;

	@OriginalMember(owner = "client!tf", name = "h", descriptor = "Ljava/awt/Font;")
	public static Font helveticaBoldFont;

	@OriginalMember(owner = "client!gl", name = "H", descriptor = "Ljava/lang/String;")
	public static String gameNameIsLoadingPleaseWaitMessage = null;

	@OriginalMember(owner = "client!o", name = "S", descriptor = "I")
	private static int anInt972;

	@OriginalMember(owner = "client!o", name = "T", descriptor = "I")
	private static int anInt973;

	@OriginalMember(owner = "client!o", name = "U", descriptor = "Z")
	private static boolean aBoolean90;

	@OriginalMember(owner = "client!o", name = "V", descriptor = "Z")
	private static boolean aBoolean91;

	@OriginalMember(owner = "client!o", name = "a", descriptor = "Z")
	private boolean handledGameError = false;

	@OriginalMember(owner = "client!o", name = "f", descriptor = "Z")
	private boolean jagMiscNativeLibraryLoaded = false;

	@OriginalMember(owner = "client!o", name = "providesignlink", descriptor = "(Lclient!et;)V")
	public static void providesignlink(@OriginalArg(0) SignLink arg0) {
		Static206.signLink = arg0;
		Static386.signLink = arg0;
	}

	@OriginalMember(owner = "client!o", name = "a", descriptor = "()V")
	public static void method873() {
		for (@Pc(1) int local1 = 0; local1 < Static1.anInt6; local1++) {
			@Pc(6) Class16_Sub1 local6 = Static427.aClass16_Sub1Array3[local1];
			Static190.method2978(local6);
			Static427.aClass16_Sub1Array3[local1] = null;
		}
		Static1.anInt6 = 0;
	}

	@OriginalMember(owner = "client!o", name = "a", descriptor = "(IFIII[FIIFII)V")
	public static void method875(@OriginalArg(0) int arg0, @OriginalArg(1) float arg1, @OriginalArg(2) int arg2, @OriginalArg(4) int arg3, @OriginalArg(5) float[] arg4, @OriginalArg(6) int arg5, @OriginalArg(7) int arg6, @OriginalArg(8) float arg7, @OriginalArg(9) int arg8, @OriginalArg(10) int arg9) {
		@Pc(5) int local5 = arg3 - arg2;
		@Pc(13) int local13 = arg5 - arg6;
		@Pc(17) int local17 = arg0 - arg9;
		@Pc(38) float local38 = (float) local17 * arg4[2] + (float) local5 * arg4[1] + arg4[0] * (float) local13;
		@Pc(59) float local59 = arg4[3] * (float) local13 + (float) local5 * arg4[4] + arg4[5] * (float) local17;
		@Pc(80) float local80 = arg4[7] * (float) local5 + (float) local13 * arg4[6] + arg4[8] * (float) local17;
		@Pc(91) float local91 = (float) Math.atan2((double) local38, (double) local80) / 6.2831855F + 0.5F;
		if (arg7 != 1.0F) {
			local91 *= arg7;
		}
		@Pc(105) float local105 = arg1 + local59 + 0.5F;
		@Pc(112) float local112;
		if (arg8 == 1) {
			local112 = local91;
			local91 = -local105;
			local105 = local112;
		} else if (arg8 == 2) {
			local91 = -local91;
			local105 = -local105;
		} else if (arg8 == 3) {
			local112 = local91;
			local91 = local105;
			local105 = -local112;
		}
		Static244.aFloat102 = local105;
		Static403.aFloat211 = local91;
	}

	@OriginalMember(owner = "client!o", name = "a", descriptor = "(IIBIZI)V")
	public static void method878(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(3) int arg2, @OriginalArg(4) boolean arg3, @OriginalArg(5) int arg4) {
		if (arg1 < 1) {
			arg1 = 1;
		}
		if (arg4 < 1) {
			arg4 = 1;
		}
		@Pc(21) int local21 = arg4 - 334;
		if (local21 < 0) {
			local21 = 0;
		} else if (local21 > 100) {
			local21 = 100;
		}
		@Pc(43) int local43 = (Static128.aShort24 - Static298.aShort67) * local21 / 100 + Static298.aShort67;
		if (Static291.aShort66 > local43) {
			local43 = Static291.aShort66;
		} else if (local43 > Static110.aShort18) {
			local43 = Static110.aShort18;
		}
		@Pc(69) int local69 = arg4 * 512 * local43 / (arg1 * 334);
		@Pc(106) int local106;
		@Pc(112) int local112;
		@Pc(81) short local81;
		if (Static113.aShort19 > local69) {
			local81 = Static113.aShort19;
			local43 = arg1 * local81 * 334 / (arg4 * 512);
			if (local43 > Static110.aShort18) {
				local43 = Static110.aShort18;
				local106 = arg4 * local43 * 512 / (local81 * 334);
				local112 = (arg1 - local106) / 2;
				if (arg3) {
					Static122.aClass19_16.e();
					Static122.aClass19_16.method4293(arg2, local112, arg0, -16777216, arg4);
					Static122.aClass19_16.method4293(arg2 + arg1 - local112, local112, arg0, -16777216, arg4);
				}
				arg2 += local112;
				arg1 -= local112 * 2;
			}
		} else if (Static409.aShort100 < local69) {
			local81 = Static409.aShort100;
			local43 = local81 * 334 * arg1 / (arg4 * 512);
			if (local43 < Static291.aShort66) {
				local43 = Static291.aShort66;
				local106 = local81 * 334 * arg1 / (local43 * 512);
				local112 = (arg4 - local106) / 2;
				if (arg3) {
					Static122.aClass19_16.e();
					Static122.aClass19_16.method4293(arg2, arg1, arg0, -16777216, local112);
					Static122.aClass19_16.method4293(arg2, arg1, arg4 + arg0 - local112, -16777216, local112);
				}
				arg4 -= local112 * 2;
				arg0 += local112;
			}
		}
		Static219.anInt6458 = local43 * arg4 / 334;
		Static120.anInt2574 = arg0;
		Static119.anInt2527 = (short) arg4;
		Static329.anInt5685 = (short) arg1;
		Static120.anInt2600 = arg2;
	}

	@OriginalMember(owner = "client!o", name = "a", descriptor = "(BI[B)I")
	public static int method879(@OriginalArg(1) int arg0, @OriginalArg(2) byte[] arg1) {
		return CRC32Checksum.calculateChecksum(arg1, arg0, 0);
	}

	@OriginalMember(owner = "client!o", name = "c", descriptor = "(I)V")
	public static void method882(@OriginalArg(0) int arg0) {
		Static358.anInt6251 = arg0;
		for (@Pc(3) int local3 = 0; local3 < Static422.anInt6945; local3++) {
			for (@Pc(6) int local6 = 0; local6 < Static171.anInt3361; local6++) {
				if (Static202.aClass164ArrayArrayArray5[arg0][local3][local6] == null) {
					Static202.aClass164ArrayArrayArray5[arg0][local3][local6] = new Class164(arg0, local3, local6);
				}
			}
		}
	}

	@OriginalMember(owner = "client!o", name = "d", descriptor = "(B)V")
	public static void method884() {
		for (@Pc(11) int local11 = 0; local11 < Static12.anInt163; local11++) {
			@Pc(17) int local17 = Static342.anIntArray412[local11];
			@Pc(21) Class16_Sub1_Sub5_Sub2 local21 = Static143.aClass16_Sub1_Sub5_Sub2Array1[local17];
			if (local21 != null) {
				Static44.method761(local21.aClass264_1.anInt7201, local21);
			}
		}
	}

	@OriginalMember(owner = "client!o", name = "a", descriptor = "(IB)V")
	public static void method889(@OriginalArg(0) int arg0) {
		Static314.anInt5475 = arg0;
		Static182.aClass68_19.method1777();
	}

	@OriginalMember(owner = "client!mg", name = "a", descriptor = "(IIIIIIII)V")
	public static void method3558(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(5) int arg4, @OriginalArg(6) int arg5, @OriginalArg(7) int arg6) {
		@Pc(12) int local12 = 0;
		@Pc(14) int local14 = arg1;
		@Pc(16) int local16 = 0;
		@Pc(21) int local21 = arg2 - arg4;
		@Pc(25) int local25 = arg1 - arg4;
		@Pc(29) int local29 = arg2 * arg2;
		@Pc(33) int local33 = arg1 * arg1;
		@Pc(37) int local37 = local21 * local21;
		@Pc(41) int local41 = local25 * local25;
		@Pc(45) int local45 = local33 << 1;
		@Pc(49) int local49 = local29 << 1;
		@Pc(53) int local53 = local41 << 1;
		@Pc(57) int local57 = local37 << 1;
		@Pc(61) int local61 = arg1 << 1;
		@Pc(65) int local65 = local25 << 1;
		@Pc(75) int local75 = local29 * (1 - local61) + local45;
		@Pc(84) int local84 = local33 - (local61 - 1) * local49;
		@Pc(93) int local93 = local53 + (1 - local65) * local37;
		@Pc(101) int local101 = local41 - local57 * (local65 - 1);
		@Pc(105) int local105 = local29 << 2;
		@Pc(109) int local109 = local33 << 2;
		@Pc(113) int local113 = local37 << 2;
		@Pc(117) int local117 = local41 << 2;
		@Pc(121) int local121 = local45 * 3;
		@Pc(127) int local127 = local49 * (local61 - 3);
		@Pc(131) int local131 = local53 * 3;
		@Pc(137) int local137 = (local65 - 3) * local57;
		@Pc(139) int local139 = local109;
		@Pc(145) int local145 = (arg1 - 1) * local105;
		@Pc(147) int local147 = local117;
		@Pc(153) int local153 = (local25 - 1) * local113;
		@Pc(157) int[] local157 = Static96.anIntArrayArray21[arg0];
		Static251.method3640(arg5 - arg2, arg3, arg5 - local21, local157);
		Static251.method3640(arg5 - local21, arg6, arg5 + local21, local157);
		Static251.method3640(arg5 + local21, arg3, arg5 + arg2, local157);
		while (local14 > 0) {
			@Pc(205) boolean local205 = local25 >= local14;
			if (local75 < 0) {
				while (local75 < 0) {
					local84 += local139;
					local75 += local121;
					local139 += local109;
					local12++;
					local121 += local109;
				}
			}
			if (local205) {
				if (local93 < 0) {
					while (local93 < 0) {
						local101 += local147;
						local93 += local131;
						local147 += local117;
						local131 += local117;
						local16++;
					}
				}
				if (local101 < 0) {
					local101 += local147;
					local93 += local131;
					local147 += local117;
					local131 += local117;
					local16++;
				}
				local93 += -local153;
				local101 += -local137;
				local137 -= local113;
				local153 -= local113;
			}
			if (local84 < 0) {
				local84 += local139;
				local75 += local121;
				local139 += local109;
				local12++;
				local121 += local109;
			}
			local84 += -local127;
			local75 += -local145;
			local145 -= local105;
			local127 -= local105;
			local14--;
			@Pc(342) int local342 = arg0 - local14;
			@Pc(346) int local346 = local14 + arg0;
			@Pc(350) int local350 = local12 + arg5;
			@Pc(354) int local354 = arg5 - local12;
			if (local205) {
				@Pc(378) int local378 = arg5 + local16;
				@Pc(383) int local383 = arg5 - local16;
				Static251.method3640(local354, arg3, local383, Static96.anIntArrayArray21[local342]);
				Static251.method3640(local383, arg6, local378, Static96.anIntArrayArray21[local342]);
				Static251.method3640(local378, arg3, local350, Static96.anIntArrayArray21[local342]);
				Static251.method3640(local354, arg3, local383, Static96.anIntArrayArray21[local346]);
				Static251.method3640(local383, arg6, local378, Static96.anIntArrayArray21[local346]);
				Static251.method3640(local378, arg3, local350, Static96.anIntArrayArray21[local346]);
			} else {
				Static251.method3640(local354, arg3, local350, Static96.anIntArrayArray21[local342]);
				Static251.method3640(local354, arg3, local350, Static96.anIntArrayArray21[local346]);
			}
		}
	}

	@OriginalMember(owner = "client!al", name = "a", descriptor = "(IB)V")
	public static void calculateFrameTimeFromFPS(@OriginalArg(0) int framesPerSecond) {
		frameTimeInMilliseconds = 1000 / framesPerSecond;
	}

	@OriginalMember(owner = "client!mq", name = "e", descriptor = "(B)V")
	public static void method3660() {
		aFrameTimer_1.reset();

		for (@Pc(10) int local10 = 0; local10 < 32; local10++) {
			aLongArray8[local10] = 0L;
		}

		for (@Pc(22) int local22 = 0; local22 < 32; local22++) {
			aLongArray6[local22] = 0L;
		}

		anInt6741 = 0;
	}

	public static void initializeClientLoadingBox(
		Color textColor,
		Color borderColor,
		Color progressBarColor,
		int currentProgress,
		boolean shouldDrawBackground,
		String message
	) {
		try {
			Graphics canvasGraphics = canvas.getGraphics();

			if (helveticaBoldFont == null) {
				helveticaBoldFont = new Font("Helvetica", Font.BOLD, 13);
			}

			if (shouldDrawBackground) {
				canvasGraphics.setColor(Color.black);
				canvasGraphics.fillRect(0, 0, Static141.width, Static302.height);
			}

			if (progressBarColor == null) {
				progressBarColor = new Color(140, 17, 17);
			}

			if (borderColor == null) {
				borderColor = new Color(140, 17, 17);
			}

			if (textColor == null) {
				textColor = new Color(255, 255, 255);
			}

			try {
				if (Static253.loadingBoxImage == null) {
					Static253.loadingBoxImage = canvas.createImage(304, 34);
				}

				Graphics loadingBoxImageGraphics = Static253.loadingBoxImage.getGraphics();

				loadingBoxImageGraphics.setColor(borderColor);
				loadingBoxImageGraphics.drawRect(0, 0, 303, 33);

				loadingBoxImageGraphics.setColor(progressBarColor);
				loadingBoxImageGraphics.fillRect(2, 2, currentProgress * 3, 30);

				loadingBoxImageGraphics.setColor(Color.black);
				loadingBoxImageGraphics.drawRect(1, 1, 301, 31);
				loadingBoxImageGraphics.fillRect(currentProgress * 3 + 2, 2, 300 - currentProgress * 3, 30);

				loadingBoxImageGraphics.setFont(helveticaBoldFont);
				loadingBoxImageGraphics.setColor(textColor);
				loadingBoxImageGraphics.drawString(message, (304 - message.length() * 6) / 2, 22);

				canvasGraphics.drawImage(Static253.loadingBoxImage, Static141.width / 2 - 152, Static302.height / 2 + -18, null);
			} catch (Exception e) {
				int local155 = Static141.width / 2 - 152;
				int local161 = Static302.height / 2 - 18;

				canvasGraphics.setColor(borderColor);
				canvasGraphics.drawRect(0, 0, 303, 33);

				canvasGraphics.setColor(progressBarColor);
				canvasGraphics.fillRect(local155 + 2, local161 + 2, currentProgress * 3, 30);

				canvasGraphics.setColor(Color.black);
				canvasGraphics.drawRect(local155 + 1, local161 + 1, 301, 31);
				canvasGraphics.fillRect(currentProgress * 3 + local155 + 2, local161 - -2, 300 - currentProgress * 3, 30);

				canvasGraphics.setFont(helveticaBoldFont);
				canvasGraphics.setColor(textColor);
				canvasGraphics.drawString(message, (304 - message.length() * 6) / 2 + local155, local161 - -22);
			}

			if (gameNameIsLoadingPleaseWaitMessage != null) {
				canvasGraphics.setFont(helveticaBoldFont);
				canvasGraphics.setColor(textColor);
				canvasGraphics.drawString(gameNameIsLoadingPleaseWaitMessage, Static141.width / 2 - gameNameIsLoadingPleaseWaitMessage.length() * 6 / 2, Static302.height / 2 - 26);
			}
		} catch (Exception e) {
			canvas.repaint();
		}
	}

	@OriginalMember(owner = "client!o", name = "a", descriptor = "(I)Z")
	protected final boolean isValidHost() {
		@Pc(16) String host = this.getDocumentBase().getHost().toLowerCase();

		if (host.equals("jagex.com") || host.endsWith(".jagex.com")) {
			return true;
		} else if (host.equals("runescape.com") || host.endsWith(".runescape.com")) {
			return true;
		} else if (host.equals("stellardawn.com") || host.endsWith(".stellardawn.com")) {
			return true;
		} else if (host.endsWith("127.0.0.1")) {
			return true;
		} else {
			while (!host.isEmpty() && host.charAt(host.length() - 1) >= '0' && host.charAt(host.length() - 1) <= '9') {
				host = host.substring(0, host.length() - 1);
			}

			if (host.endsWith("192.168.1.")) {
				return true;
			} else {
				this.handleGameError("invalidhost");

				return false;
			}
		}
	}

	@OriginalMember(owner = "client!o", name = "b", descriptor = "(I)V")
	private void triggerGameLogicStep() {
		@Pc(13) long currentTimeInMilliseconds = MonotonicClock.getCurrentTimeInMilliseconds();
		@Pc(17) long previousTimeInMilliseconds = aLongArray6[anInt290];

		aLongArray6[anInt290] = currentTimeInMilliseconds;

		@Pc(36) boolean local36;

		if (previousTimeInMilliseconds == 0L || previousTimeInMilliseconds >= currentTimeInMilliseconds) {
			local36 = false;
		} else {
			local36 = true;
		}

		anInt290 = anInt290 + 1 & 0x1F;

		synchronized (this) {
			Static265.aBoolean457 = Static198.isFocused;
		}

		this.runGameLogicStep();
	}

	@OriginalMember(owner = "client!o", name = "focusGained", descriptor = "(Ljava/awt/event/FocusEvent;)V")
	@Override
	public final void focusGained(@OriginalArg(0) FocusEvent arg0) {
		Static198.isFocused = true;
		aBoolean189 = true;
	}

	@OriginalMember(owner = "client!o", name = "a", descriptor = "(ILjava/lang/String;)V")
	protected final void handleGameError(@OriginalArg(1) String arg0) {
		if (this.handledGameError) {
			return;
		}

		this.handledGameError = true;

		System.out.println("error_game_" + arg0);

		try {
			Static458.callJavaScriptMethod(Static206.signLink.hostApplet, "loggedout");
		} catch (@Pc(31) Throwable ignored) {
		}

		try {
			this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + arg0 + ".ws"), "_top");
		} catch (@Pc(51) Exception ignored) {
		}
	}

	@OriginalMember(owner = "client!o", name = "a", descriptor = "(B)V")
	protected abstract void runGameLogicStep();

	@OriginalMember(owner = "client!o", name = "start", descriptor = "()V")
	@Override
	public final void start() {
		if (instance == this && !Static438.aBoolean675) {
			timeToShutdown = 0L;
		}
	}

	@OriginalMember(owner = "client!o", name = "getAppletContext", descriptor = "()Ljava/applet/AppletContext;")
	@Override
	public final AppletContext getAppletContext() {
		if (aFrame1 == null) {
			return Static206.signLink == null || Static206.signLink.hostApplet == this ? super.getAppletContext() : Static206.signLink.hostApplet.getAppletContext();
		} else {
			return null;
		}
	}

	@OriginalMember(owner = "client!o", name = "init", descriptor = "()V")
	public abstract void init();

	@OriginalMember(owner = "client!o", name = "b", descriptor = "(B)V")
	public final synchronized void method874() {
		if (canvas != null) {
			canvas.removeFocusListener(this);
			canvas.getParent().remove(canvas);
		}
		@Pc(18) Container local18;
		if (Static320.aFrame3 != null) {
			local18 = Static320.aFrame3;
		} else if (aFrame1 == null) {
			local18 = Static206.signLink.hostApplet;
		} else {
			local18 = aFrame1;
		}
		local18.setLayout(null);
		canvas = new Canvas_Sub1(this);
		local18.add(canvas);
		canvas.setSize(Static141.width, Static302.height);
		canvas.setVisible(true);
		if (local18 == aFrame1) {
			@Pc(60) Insets local60 = aFrame1.getInsets();
			canvas.setLocation(Static230.xPOS + local60.left, local60.top + Static303.yPOS);
		} else {
			canvas.setLocation(Static230.xPOS, Static303.yPOS);
		}
		canvas.addFocusListener(this);
		canvas.requestFocus();
		Static198.isFocused = true;
		Static265.aBoolean457 = true;
		aBoolean189 = true;
		Static84.aBoolean383 = false;
		aLong59 = MonotonicClock.getCurrentTimeInMilliseconds();
	}

	@OriginalMember(owner = "client!o", name = "paint", descriptor = "(Ljava/awt/Graphics;)V")
	@Override
	public final synchronized void paint(@OriginalArg(0) Graphics arg0) {
		if (instance != this || Static438.aBoolean675) {
			return;
		}
		aBoolean189 = true;
		if (isRunningModernJavaVersion && MonotonicClock.getCurrentTimeInMilliseconds() - aLong59 > 1000L) {
			@Pc(24) Rectangle local24 = arg0.getClipBounds();
			if (local24 == null || Static425.anInt7000 <= local24.width && Static17.anInt222 <= local24.height) {
				Static84.aBoolean383 = true;
			}
		}
	}

	@OriginalMember(owner = "client!o", name = "getParameter", descriptor = "(Ljava/lang/String;)Ljava/lang/String;")
	@Override
	public final String getParameter(@OriginalArg(0) String arg0) {
		if (aFrame1 == null) {
			return Static206.signLink == null || Static206.signLink.hostApplet == this ? super.getParameter(arg0) : Static206.signLink.hostApplet.getParameter(arg0);
		} else {
			return null;
		}
	}

	@OriginalMember(owner = "client!o", name = "stop", descriptor = "()V")
	@Override
	public final void stop() {
		if (instance == this && !Static438.aBoolean675) {
			timeToShutdown = MonotonicClock.getCurrentTimeInMilliseconds() + 4000L;
		}
	}

	@OriginalMember(owner = "client!o", name = "update", descriptor = "(Ljava/awt/Graphics;)V")
	@Override
	public final void update(@OriginalArg(0) Graphics arg0) {
		this.paint(arg0);
	}

	@OriginalMember(owner = "client!o", name = "windowActivated", descriptor = "(Ljava/awt/event/WindowEvent;)V")
	@Override
	public final void windowActivated(@OriginalArg(0) WindowEvent arg0) {
	}

	@OriginalMember(owner = "client!o", name = "windowDeactivated", descriptor = "(Ljava/awt/event/WindowEvent;)V")
	@Override
	public final void windowDeactivated(@OriginalArg(0) WindowEvent arg0) {
	}

	@OriginalMember(owner = "client!o", name = "a", descriptor = "(ZZ)V")
	private void shutdown(@OriginalArg(1) boolean clean) {
		synchronized (this) {
			if (Static438.aBoolean675) {
				return;
			}
			Static438.aBoolean675 = true;
		}

		if (Static206.signLink.hostApplet != null) {
			Static206.signLink.hostApplet.destroy();
		}

		try {
			this.method886();
		} catch (@Pc(33) Exception local33) {
		}

		if (this.jagMiscNativeLibraryLoaded) {
			try {
				jagmisc.quit();
			} catch (@Pc(39) Throwable local39) {
			}
			this.jagMiscNativeLibraryLoaded = false;
		}

		@Pc(48) Message local48 = Static206.signLink.emitPerformClassLoaderNativeLibrariesCleanupMessage(instance.getClass());

		while (local48.status == 0) {
			Static435.sleepFor(100L);
		}

		if (canvas != null) {
			try {
				canvas.removeFocusListener(this);
				canvas.getParent().remove(canvas);
			} catch (@Pc(75) Exception local75) {
			}
		}

		if (Static206.signLink != null) {
			try {
				Static206.signLink.shutdown();
			} catch (@Pc(83) Exception local83) {
			}
		}

		this.method880();

		if (aFrame1 != null) {
			try {
				System.exit(0);
			} catch (@Pc(93) Throwable local93) {
			}
		}

		System.out.println("Shutdown complete - clean:" + clean);
	}

	@OriginalMember(owner = "client!o", name = "c", descriptor = "(B)V")
	public final void method877() {
		if (this.jagMiscNativeLibraryLoaded) {
			return;
		}

		try {
			@Pc(22) Message local22 = Static206.signLink.emitLoadJagMiscNativesMessage(instance.getClass());

			while (local22.status == 0) {
				Static435.sleepFor(100L);
			}

			if (local22.output != null) {
				throw (Throwable) local22.output;
			}

			jagmisc.init();

			this.jagMiscNativeLibraryLoaded = true;

			aFrameTimer_1 = FrameTimer.getFrameTimer();
		} catch (@Pc(50) Throwable local50) {
		}
	}

	@OriginalMember(owner = "client!o", name = "destroy", descriptor = "()V")
	@Override
	public final void destroy() {
		if (instance == this && !Static438.aBoolean675) {
			timeToShutdown = MonotonicClock.getCurrentTimeInMilliseconds();
			Static435.sleepFor(5000L);
			Static386.signLink = null;
			this.shutdown(false);
		}
	}

	@OriginalMember(owner = "client!o", name = "focusLost", descriptor = "(Ljava/awt/event/FocusEvent;)V")
	@Override
	public final void focusLost(@OriginalArg(0) FocusEvent arg0) {
		Static198.isFocused = false;
	}

	@OriginalMember(owner = "client!o", name = "a", descriptor = "(Z)V")
	protected abstract void method880();

	@OriginalMember(owner = "client!o", name = "a", descriptor = "(IIIIB)V")
	protected final void load(@OriginalArg(1) int modewhat, @OriginalArg(2) int height, @OriginalArg(3) int width) {
		try {
			if (instance == null) {
				Static303.yPOS = 0;
				Static230.xPOS = 0;
				instance = this;
				Static302.height = height;
				Static17.anInt222 = height;
				Static13.gameVersion = 592;
				Static141.width = width;
				Static425.anInt7000 = width;

				if (Static206.signLink == null) {
					Static386.signLink = Static206.signLink = new SignLink(this, modewhat, null, 0);
				}

				@Pc(67) Message threadInitializationMessage = Static206.signLink.emitThreadInitializationMessage(1, this);

				while (threadInitializationMessage.status == 0) {
					Static435.sleepFor(10L);
				}
			} else {
				Static406.loadAttempts++;
				if (Static406.loadAttempts >= 3) {
					this.handleGameError("alreadyloaded");
				} else {
					this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
				}
			}
		} catch (@Pc(80) Throwable e) {
			Static94.handleClientError(e, null);

			this.handleGameError("crash");
		}
	}

	@OriginalMember(owner = "client!o", name = "windowClosed", descriptor = "(Ljava/awt/event/WindowEvent;)V")
	@Override
	public final void windowClosed(@OriginalArg(0) WindowEvent arg0) {
	}

	@OriginalMember(owner = "client!o", name = "d", descriptor = "(I)V")
	protected abstract void method883();

	@OriginalMember(owner = "client!o", name = "run", descriptor = "()V")
	@Override
	public final void run() {
		try {
			gameLoop: {
				if (SignLink.javaVendor != null) {
					@Pc(10) String javaVendorLowerCase = SignLink.javaVendor.toLowerCase();

					if (javaVendorLowerCase.contains("sun") || javaVendorLowerCase.contains("apple")) {
						@Pc(40) String javaVersion = SignLink.javaVersion;

						if (javaVersion.equals("1.1") || javaVersion.startsWith("1.1.") || javaVersion.equals("1.2") || javaVersion.startsWith("1.2.")) {
							this.handleGameError("wrongjava");

							break gameLoop;
						}
					} else if (javaVendorLowerCase.contains("ibm") && (SignLink.javaVersion == null || SignLink.javaVersion.equals("1.4.2"))) {
						this.handleGameError("wrongjava");

						break gameLoop;
					}
				}

				if (SignLink.javaVersion != null && SignLink.javaVersion.startsWith("1.")) {
					int versionStringPOS = 2;
					int javaOneMinorVersion = 0;

					while (SignLink.javaVersion.length() > versionStringPOS) {
						@Pc(78) char numChar = SignLink.javaVersion.charAt(versionStringPOS);

						if (numChar < '0' || numChar > '9') {
							break;
						}

						javaOneMinorVersion = javaOneMinorVersion * 10 + numChar - 48;

						versionStringPOS++;
					}

					if (javaOneMinorVersion >= 5) {
						isRunningModernJavaVersion = true;
					}
				}

				if (Static206.signLink.hostApplet != null) {
					@Pc(114) Method setFocusCycleRoot = SignLink.setFocusCycleRoot;

					if (setFocusCycleRoot != null) {
						try {
							setFocusCycleRoot.invoke(Static206.signLink.hostApplet, Boolean.TRUE);
						} catch (@Pc(129) Throwable ignored) {
						}
					}
				}

				Static324.method4384();
				Static112.method2036();
				this.method874();
				this.method883();
				aFrameTimer_1 = FrameTimer.getFrameTimer();
				this.method877();

				while (timeToShutdown == 0L || MonotonicClock.getCurrentTimeInMilliseconds() < timeToShutdown) {
					anInt6741 = aFrameTimer_1.method2253(frameTimeInMilliseconds);

					for (int i = 0; i < anInt6741; i++) {
						this.triggerGameLogicStep();
					}

					this.triggerGraphicsStep();

					Static441.waitForSystemEventQueueToDrain(Static206.signLink, canvas);
				}
			}
		} catch (@Pc(190) Throwable e) {
			Static94.handleClientError(e, this.getErrorContext());

			this.handleGameError("crash");
		}

		this.shutdown(true);
	}

	@OriginalMember(owner = "client!o", name = "a", descriptor = "(IZIIILjava/lang/String;II)V")
	protected final void method885(@OriginalArg(5) String arg0, @OriginalArg(7) int arg1) {
		try {
			Static141.width = 1024;
			Static425.anInt7000 = 1024;
			Static303.yPOS = 0;
			Static230.xPOS = 0;
			Static13.gameVersion = 592;
			Static302.height = 768;
			Static17.anInt222 = 768;
			instance = this;
			aFrame1 = new Frame();
			aFrame1.setTitle("Jagex");
			aFrame1.setResizable(true);
			aFrame1.addWindowListener(this);
			aFrame1.setVisible(true);
			aFrame1.toFront();
			@Pc(38) Insets local38 = aFrame1.getInsets();
			aFrame1.setSize(local38.right + Static425.anInt7000 + local38.left, local38.bottom + Static17.anInt222 + local38.top);
			Static386.signLink = Static206.signLink = new SignLink(null, arg1, arg0, 30);
			@Pc(70) Message local70 = Static206.signLink.emitThreadInitializationMessage(1, this);
			while (local70.status == 0) {
				Static435.sleepFor(10L);
			}
		} catch (@Pc(83) Exception local83) {
			Static94.handleClientError(local83, null);
		}
	}

	@OriginalMember(owner = "client!o", name = "e", descriptor = "(I)V")
	protected abstract void method886();

	@OriginalMember(owner = "client!o", name = "windowIconified", descriptor = "(Ljava/awt/event/WindowEvent;)V")
	@Override
	public final void windowIconified(@OriginalArg(0) WindowEvent arg0) {
	}

	@OriginalMember(owner = "client!o", name = "e", descriptor = "(B)Ljava/lang/String;")
	protected String getErrorContext() {
		return null;
	}

	@OriginalMember(owner = "client!o", name = "getDocumentBase", descriptor = "()Ljava/net/URL;")
	@Override
	public final URL getDocumentBase() {
		if (aFrame1 == null) {
			return Static206.signLink == null || Static206.signLink.hostApplet == this ? super.getDocumentBase() : Static206.signLink.hostApplet.getDocumentBase();
		} else {
			return null;
		}
	}

	@OriginalMember(owner = "client!o", name = "windowOpened", descriptor = "(Ljava/awt/event/WindowEvent;)V")
	@Override
	public final void windowOpened(@OriginalArg(0) WindowEvent arg0) {
	}

	@OriginalMember(owner = "client!o", name = "windowClosing", descriptor = "(Ljava/awt/event/WindowEvent;)V")
	@Override
	public final void windowClosing(@OriginalArg(0) WindowEvent arg0) {
		this.destroy();
	}

	@OriginalMember(owner = "client!o", name = "getCodeBase", descriptor = "()Ljava/net/URL;")
	@Override
	public final URL getCodeBase() {
		if (aFrame1 == null) {
			return Static206.signLink == null || Static206.signLink.hostApplet == this ? super.getCodeBase() : Static206.signLink.hostApplet.getCodeBase();
		} else {
			return null;
		}
	}

	@OriginalMember(owner = "client!o", name = "g", descriptor = "(I)V")
	protected abstract void runGraphicsStep();

	@OriginalMember(owner = "client!o", name = "windowDeiconified", descriptor = "(Ljava/awt/event/WindowEvent;)V")
	@Override
	public final void windowDeiconified(@OriginalArg(0) WindowEvent arg0) {
	}

	@OriginalMember(owner = "client!o", name = "h", descriptor = "(I)V")
	private void triggerGraphicsStep() {
		@Pc(10) long currentTimeInMilliseconds = MonotonicClock.getCurrentTimeInMilliseconds();
		@Pc(14) long local14 = aLongArray8[anInt6705];

		aLongArray8[anInt6705] = currentTimeInMilliseconds;

		if (local14 != 0L && currentTimeInMilliseconds > local14) {
			@Pc(38) int local38 = (int) (currentTimeInMilliseconds - local14);
			framesPerSecond = ((local38 >> 1) + 32000) / local38;
		}

		anInt6705 = anInt6705 + 1 & 0x1F;

		if (graphicsStepCount++ > 50) {
			graphicsStepCount -= 50;
			aBoolean189 = true;

			canvas.setSize(Static141.width, Static302.height);
			canvas.setVisible(true);

			if (aFrame1 != null && Static320.aFrame3 == null) {
				@Pc(86) Insets local86 = aFrame1.getInsets();
				canvas.setLocation(Static230.xPOS + local86.left, local86.top - -Static303.yPOS);
			} else {
				canvas.setLocation(Static230.xPOS, Static303.yPOS);
			}
		}

		this.runGraphicsStep();
	}
}
