package com.open592.appletviewer;

// $FF: renamed from: app.s
final class class_7 {
   // $FF: renamed from: a char[]
   private static char[] field_23 = new char[64];
   // $FF: renamed from: b char[]
   private static char[] field_24;
   // $FF: renamed from: c int[]
   private static int[] field_25;

   // $FF: renamed from: a (int, byte[]) java.lang.String
   static final String method_6(int var0, byte[] var1) {
      if (var0 != 0) {
         method_7(false, (byte[])null, 82, -101);
      }

      return method_7(false, var1, var1.length, 0);
   }

   // $FF: renamed from: a (boolean, byte[], int, int) java.lang.String
   private static final String method_7(boolean var0, byte[] var1, int var2, int var3) {
      int var9 = class_21.field_91;
      if (var0) {
         return (String)null;
      } else {
         StringBuffer var4 = new StringBuffer();
         int var5 = var3;

         while(var2 + var3 > var5) {
            label29: {
               int var6 = 255 & var1[var5];
               var4.append(field_23[var6 >>> -991034302]);
               if (var5 < -1 + var2) {
                  label26: {
                     int var7 = var1[var5 - -1] & 255;
                     var4.append(field_23[var7 >>> 143911876 | (3 & var6) << 131897348]);
                     if (-2 + var2 > var5) {
                        int var8 = 255 & var1[var5 + 2];
                        var4.append(field_23[(15 & var7) << 802114978 | var8 >>> 1619422598]).append(field_23[63 & var8]);
                        if (var9 == 0) {
                           break label26;
                        }
                     }

                     var4.append(field_23[60 & var7 << -806335646]).append("=");
                  }

                  if (var9 == 0) {
                     break label29;
                  }
               }

               var4.append(field_23[(3 & var6) << 1989800772]).append("==");
            }

            var5 += 3;
            if (var9 != 0) {
               break;
            }
         }

         return var4.toString();
      }
   }

   static {
      int var0;
      for(var0 = 0; 26 > var0; ++var0) {
         field_23[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field_23[var0] = (char)(-26 + var0 + 97);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field_23[var0] = (char)(48 + var0 - 52);
      }

      field_23[63] = '/';
      field_23[62] = '+';
      field_24 = new char[64];

      for(var0 = 0; 26 > var0; ++var0) {
         field_24[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; ~var0 > -53; ++var0) {
         field_24[var0] = (char)(71 + var0);
      }

      for(var0 = 52; 62 > var0; ++var0) {
         field_24[var0] = (char)(var0 + -4);
      }

      field_24[62] = '*';
      field_24[63] = '-';
      field_25 = new int[128];

      for(var0 = 0; var0 < field_25.length; ++var0) {
         field_25[var0] = -1;
      }

      for(var0 = 65; -91 <= ~var0; ++var0) {
         field_25[var0] = -65 + var0;
      }

      for(var0 = 97; ~var0 >= -123; ++var0) {
         field_25[var0] = -97 + var0 + 26;
      }

      for(var0 = 48; 57 >= var0; ++var0) {
         field_25[var0] = 52 + -48 + var0;
      }

      field_25[45] = field_25[47] = 63;
      field_25[42] = field_25[43] = 62;
   }
}
