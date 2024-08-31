package com.jagex.client;

import java.awt.Color;
import java.util.Calendar;
import java.util.Date;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static171 {

	@OriginalMember(owner = "client!ip", name = "sc", descriptor = "I")
	public static int anInt3361;

	@OriginalMember(owner = "client!ip", name = "vc", descriptor = "[I")
	public static int[] anIntArray217;

	@OriginalMember(owner = "client!ip", name = "lc", descriptor = "Lclient!gk;")
	public static final Class83 aClass83_71 = new Class83("Loading textures - ", "Lade Texturen - ", "Chargement des textures - ", "Carregando texturas - ");

	@OriginalMember(owner = "client!ip", name = "xc", descriptor = "[Ljava/awt/Color;")
	public static final Color[] aColorArray5 = new Color[] { new Color(16777215), new Color(16777215) };

	@OriginalMember(owner = "client!ip", name = "a", descriptor = "(IIZ)V")
	public static void method2796(@OriginalArg(0) int arg0, @OriginalArg(2) boolean arg1) {
		@Pc(10) LinkedEntry_Sub25 local10 = Static175.method2834(arg1, arg0);
		if (local10 != null) {
			for (@Pc(15) int local15 = 0; local15 < local10.anIntArray230.length; local15++) {
				local10.anIntArray230[local15] = -1;
				local10.anIntArray229[local15] = 0;
			}
		}
	}

	@OriginalMember(owner = "client!ip", name = "a", descriptor = "(JI)Ljava/lang/String;")
	public static String timestampToDateString(@OriginalArg(0) long timestamp) {
		Static253.GMTCalendar.setTime(new Date(timestamp));

		@Pc(18) int dayOfWeek = Static253.GMTCalendar.get(Calendar.DAY_OF_WEEK);
		@Pc(22) int dayOfMonth = Static253.GMTCalendar.get(Calendar.DAY_OF_MONTH);
		@Pc(26) int monthString = Static253.GMTCalendar.get(Calendar.MONTH);
		@Pc(30) int year = Static253.GMTCalendar.get(Calendar.YEAR);
		@Pc(34) int hour = Static253.GMTCalendar.get(Calendar.HOUR_OF_DAY);
		@Pc(38) int minute = Static253.GMTCalendar.get(Calendar.MINUTE);
		@Pc(42) int second = Static253.GMTCalendar.get(Calendar.SECOND);

		// Thu, 06-Jan-2011 18:45:20 GMT
        return Static37.DAYS_OF_WEEK[dayOfWeek - 1] +
                ", " +
                (dayOfMonth / 10 + dayOfMonth % 10) +
                "-" +
                Static280.SHORT_MONTH_NAMES[monthString] +
                "-" +
                year +
                " " +
                (hour / 10 + hour % 10) +
                ":" +
                (minute / 10 + minute % 10) +
                ":" +
                (second / 10 + second % 10) +
                " GMT";
	}
}
