package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!um")
public final class Class241 {

	@OriginalMember(owner = "client!um", name = "c", descriptor = "[Lclient!pl;")
	private final Class184[] aClass184Array1 = new Class184[10];

	@OriginalMember(owner = "client!um", name = "a", descriptor = "I")
	private int anInt6706;

	@OriginalMember(owner = "client!um", name = "b", descriptor = "I")
	private int anInt6707;

	@OriginalMember(owner = "client!um", name = "<init>", descriptor = "(Lclient!iv;)V")
	public Class241(@OriginalArg(0) Packet arg0) {
		for (@Pc(7) int local7 = 0; local7 < 10; local7++) {
			@Pc(12) int local12 = arg0.g1();
			if (local12 != 0) {
				arg0.pos--;
				this.aClass184Array1[local7] = new Class184();
				this.aClass184Array1[local7].method4150(arg0);
			}
		}
		this.anInt6706 = arg0.g2();
		this.anInt6707 = arg0.g2();
	}

	@OriginalMember(owner = "client!um", name = "<init>", descriptor = "()V")
	private Class241() {
	}

	@OriginalMember(owner = "client!um", name = "a", descriptor = "()[B")
	private byte[] method5243() {
		@Pc(1) int local1 = 0;
		for (@Pc(3) int local3 = 0; local3 < 10; local3++) {
			if (this.aClass184Array1[local3] != null && this.aClass184Array1[local3].anInt5406 + this.aClass184Array1[local3].anInt5408 > local1) {
				local1 = this.aClass184Array1[local3].anInt5406 + this.aClass184Array1[local3].anInt5408;
			}
		}
		if (local1 == 0) {
			return new byte[0];
		}
		@Pc(49) int local49 = local1 * 22050 / 1000;
		@Pc(52) byte[] local52 = new byte[local49];
		for (@Pc(54) int local54 = 0; local54 < 10; local54++) {
			if (this.aClass184Array1[local54] != null) {
				@Pc(70) int local70 = this.aClass184Array1[local54].anInt5406 * 22050 / 1000;
				@Pc(80) int local80 = this.aClass184Array1[local54].anInt5408 * 22050 / 1000;
				@Pc(92) int[] local92 = this.aClass184Array1[local54].method4152(local70, this.aClass184Array1[local54].anInt5406);
				for (@Pc(94) int local94 = 0; local94 < local70; local94++) {
					@Pc(107) int local107 = local52[local94 + local80] + (local92[local94] >> 8);
					if ((local107 + 128 & 0xFFFFFF00) != 0) {
						local107 = local107 >> 31 ^ 0x7F;
					}
					local52[local94 + local80] = (byte) local107;
				}
			}
		}
		return local52;
	}

	@OriginalMember(owner = "client!um", name = "b", descriptor = "()Lclient!js;")
	public Node_Sub4_Sub1 method5245() {
		@Pc(2) byte[] local2 = this.method5243();
		return new Node_Sub4_Sub1(22050, local2, this.anInt6706 * 22050 / 1000, this.anInt6707 * 22050 / 1000);
	}

	@OriginalMember(owner = "client!um", name = "c", descriptor = "()I")
	public int method5246() {
		@Pc(1) int local1 = 9999999;
		for (@Pc(3) int local3 = 0; local3 < 10; local3++) {
			if (this.aClass184Array1[local3] != null && this.aClass184Array1[local3].anInt5408 / 20 < local1) {
				local1 = this.aClass184Array1[local3].anInt5408 / 20;
			}
		}
		if (this.anInt6706 < this.anInt6707 && this.anInt6706 / 20 < local1) {
			local1 = this.anInt6706 / 20;
		}
		if (local1 == 9999999 || local1 == 0) {
			return 0;
		}
		for (@Pc(55) int local55 = 0; local55 < 10; local55++) {
			if (this.aClass184Array1[local55] != null) {
				this.aClass184Array1[local55].anInt5408 -= local1 * 20;
			}
		}
		if (this.anInt6706 < this.anInt6707) {
			this.anInt6706 -= local1 * 20;
			this.anInt6707 -= local1 * 20;
		}
		return local1;
	}
}
