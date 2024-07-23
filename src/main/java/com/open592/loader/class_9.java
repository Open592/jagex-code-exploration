package com.open592.loader;

import java.security.AllPermission;
import java.security.CodeSource;
import java.security.Permissions;
import java.security.ProtectionDomain;
import java.security.cert.Certificate;
import java.util.Hashtable;

// $FF: renamed from: h
public final class class_9 extends ClassLoader implements class_0 {
    // $FF: renamed from: a java.util.Hashtable
    private Hashtable field_42;
    // $FF: renamed from: b java.security.ProtectionDomain
    private ProtectionDomain field_43;
    // $FF: renamed from: c unpack
    private final Unpack unpacker;

    // $FF: renamed from: a (java.lang.String, int, java.lang.Class) void
    public void method_0(String var1, int var2, Class var3) {
        try {
            this.field_42.put(var1, var3);
        } catch (RuntimeException var5) {
            throw LoaderRuntimeException.create(var5, "h.A(" + (var1 != null ? "{...}" : "null") + ',' + var2 + ',' + (var3 != null ? "{...}" : "null") + ')');
        }
    }

    public class_9(Unpack unpacker) {
        super();
        this.field_42 = new Hashtable();

        try {
            this.unpacker = unpacker;
            CodeSource var2 = new CodeSource(null, (Certificate[]) null);
            Permissions var3 = new Permissions();
            var3.add(new AllPermission());
            this.field_43 = new ProtectionDomain(var2, var3);
        } catch (RuntimeException var5) {
            throw LoaderRuntimeException.create(var5, "h.<init>(" + (unpacker != null ? "{...}" : "null") + ')');
        }
    }

    public synchronized Class loadClass(String var1, boolean var2) throws ClassNotFoundException {
        try {
            Class var3 = (Class) this.field_42.get(var1);
            if (null != var3) {
                return var3;
            } else {
                byte[] var4 = this.unpacker.getEntry(var1);
                if (null == var4) {
                    return super.findSystemClass(var1);
                } else {
                    var3 = this.defineClass(var1, var4, 0, var4.length, this.field_43);
                    if (var2) {
                        this.resolveClass(var3);
                    }

                    this.field_42.put(var1, var3);
                    return var3;
                }
            }
        } catch (RuntimeException var5) {
            throw LoaderRuntimeException.create(var5, "h.loadClass(" + (var1 != null ? "{...}" : "null") + ',' + var2 + ')');
        }
    }
}
