package com.jagex.client.js5;

import com.jagex.client.BufferedFile;
import com.jagex.client.Static166;
import java.io.EOFException;
import java.io.IOException;

public final class Cache {
  private final BufferedFile cacheIndexFile;
  private final BufferedFile cacheDataFile;
  private final int maxLength;
  private final int archiveNumber;

  public Cache(
      int archiveNumber, BufferedFile cacheDataFile, BufferedFile cacheIndexFile, int maxLength) {
    this.cacheIndexFile = cacheIndexFile;
    this.cacheDataFile = cacheDataFile;
    this.archiveNumber = archiveNumber;
    // Was originally given a redundant default of 65000
    this.maxLength = maxLength;
  }

  @Override
  public String toString() {
    return "Cache:" + this.archiveNumber;
  }

  public byte[] read(int group) {
    synchronized (this.cacheDataFile) {
      try {
        if (this.cacheIndexFile.length() < (group * 6L + 6)) {
          return null;
        }

        this.cacheIndexFile.seek(group * 6L);
        this.cacheIndexFile.method3471(0, 6, Static166.aByteArray37);

        int length =
            (Static166.aByteArray37[2] & 0xFF)
                + (((Static166.aByteArray37[0] & 0xFF) << 16)
                    + ((Static166.aByteArray37[1] & 0xFF) << 8));
        int block =
            ((Static166.aByteArray37[3] & 0xFF) << 16)
                + ((Static166.aByteArray37[4] & 0xFF) << 8)
                + (Static166.aByteArray37[5] & 0xFF);

        if (length > this.maxLength) {
          return null;
        }

        if (block > 0 && (long) block <= this.cacheDataFile.length() / 520L) {
          byte[] local137 = new byte[length];
          int local139 = 0;
          int local147 = 0;

          while (local139 < length) {
            if (block == 0) {
              return null;
            }

            this.cacheDataFile.seek((long) (block * 520L));

            int local170 = length - local139;

            if (local170 > 512) {
              local170 = 512;
            }

            this.cacheDataFile.method3471(0, local170 + 8, Static166.aByteArray37);

            int local201 =
                ((Static166.aByteArray37[0] & 0xFF) << 8) + (Static166.aByteArray37[1] & 0xFF);
            int local215 =
                (Static166.aByteArray37[3] & 0xFF) + ((Static166.aByteArray37[2] & 0xFF) << 8);
            int local237 =
                ((Static166.aByteArray37[5] & 0xFF) << 8)
                    + ((Static166.aByteArray37[4] & 0xFF) << 16)
                    + (Static166.aByteArray37[6] & 0xFF);
            int local243 = Static166.aByteArray37[7] & 0xFF;

            if (group == local201 && local147 == local215 && this.archiveNumber == local243) {
              if ((long) local237 <= this.cacheDataFile.length() / 520L) {
                for (int i = 0; i < local170; i++) {
                  local137[local139++] = Static166.aByteArray37[i + 8];
                }

                local147++;
                block = local237;

                continue;
              }

              return null;
            }

            return null;
          }

          return local137;
        } else {
          return null;
        }
      } catch (IOException ignored) {
        return null;
      }
    }
  }

  public boolean write(byte[] arg0, int arg1, int arg2) {
    synchronized (this.cacheDataFile) {
      if (arg2 < 0 || arg2 > this.maxLength) {
        throw new IllegalArgumentException();
      }

      boolean local35 = this.method4983(arg1, arg0, arg2, true);

      if (!local35) {
        local35 = this.method4983(arg1, arg0, arg2, false);
      }

      return local35;
    }
  }

  private boolean method4983(int group, byte[] arg1, int arg2, boolean arg3) {
    synchronized (this.cacheDataFile) {
      try {
        int local67;
        if (arg3) {
          if ((group * 6L + 6) > this.cacheIndexFile.length()) {
            return false;
          }
          this.cacheIndexFile.seek((long) (group * 6L));
          this.cacheIndexFile.method3471(0, 6, Static166.aByteArray37);
          local67 =
              ((Static166.aByteArray37[4] & 0xFF) << 8)
                  + (Static166.aByteArray37[3] << 16 & 0xFF0000)
                  + (Static166.aByteArray37[5] & 0xFF);
          if (local67 <= 0 || this.cacheDataFile.length() / 520L < (long) local67) {
            return false;
          }
        } else {
          local67 = (int) ((this.cacheDataFile.length() + 519L) / 520L);
          if (local67 == 0) {
            local67 = 1;
          }
        }
        Static166.aByteArray37[3] = (byte) (local67 >> 16);
        Static166.aByteArray37[5] = (byte) local67;
        Static166.aByteArray37[2] = (byte) arg2;
        Static166.aByteArray37[0] = (byte) (arg2 >> 16);
        Static166.aByteArray37[4] = (byte) (local67 >> 8);
        Static166.aByteArray37[1] = (byte) (arg2 >> 8);
        this.cacheIndexFile.seek((long) (group * 6L));
        this.cacheIndexFile.method3464(0, Static166.aByteArray37, 6);
        int local163 = 0;
        int local165 = 0;
        while (arg2 > local163) {
          int local169 = 0;
          int local204;
          if (arg3) {
            this.cacheDataFile.seek((long) (local67 * 520L));
            try {
              this.cacheDataFile.method3471(0, 8, Static166.aByteArray37);
            } catch (EOFException local188) {
              return true;
            }
            local204 =
                (Static166.aByteArray37[1] & 0xFF) + ((Static166.aByteArray37[0] & 0xFF) << 8);
            local169 =
                ((Static166.aByteArray37[4] & 0xFF) << 16)
                    + ((Static166.aByteArray37[5] & 0xFF) << 8)
                    + (Static166.aByteArray37[6] & 0xFF);
            int local242 =
                ((Static166.aByteArray37[2] & 0xFF) << 8) + (Static166.aByteArray37[3] & 0xFF);
            int local248 = Static166.aByteArray37[7] & 0xFF;
            if (group != local204 || local242 != local165 || this.archiveNumber != local248) {
              return false;
            }
            if ((long) local169 > this.cacheDataFile.length() / 520L) {
              return false;
            }
          }
          if (local169 == 0) {
            arg3 = false;
            local169 = (int) ((this.cacheDataFile.length() + 519L) / 520L);
            if (local169 == 0) {
              local169++;
            }
            if (local67 == local169) {
              local169++;
            }
          }
          Static166.aByteArray37[1] = (byte) group;
          Static166.aByteArray37[2] = (byte) (local165 >> 8);
          Static166.aByteArray37[0] = (byte) (group >> 8);
          Static166.aByteArray37[3] = (byte) local165;
          if (arg2 - local163 <= 512) {
            local169 = 0;
          }
          Static166.aByteArray37[7] = (byte) this.archiveNumber;
          Static166.aByteArray37[5] = (byte) (local169 >> 8);
          Static166.aByteArray37[4] = (byte) (local169 >> 16);
          Static166.aByteArray37[6] = (byte) local169;
          this.cacheDataFile.seek((long) (local67 * 520L));
          this.cacheDataFile.method3464(0, Static166.aByteArray37, 8);
          local204 = arg2 - local163;
          if (local204 > 512) {
            local204 = 512;
          }
          this.cacheDataFile.method3464(local163, arg1, local204);
          local165++;
          local163 += local204;
          local67 = local169;
        }
        return true;
      } catch (IOException ignored) {
        return false;
      }
    }
  }
}
