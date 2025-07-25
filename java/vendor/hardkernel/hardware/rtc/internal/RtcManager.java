/*
 *    Copyright (c) 2025 Sangchul Go <luke.go@hardkernel.com>
 *
 *    OdroidThings is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU Lesser General Public License as
 *    published by the Free Software Foundation, either version 3 of the
 *    License, or (at your option) any later version.
 *
 *    OdroidThings is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU Lesser General Public License for more details.
 *
 *    You should have received a copy of the GNU Lesser General Public
 *    License along with OdroidThings.
 *    If not, see <http://www.gnu.org/licenses/>.
 */

package vendor.hardkernel.hardware.rtc.internal;

import vendor.hardkernel.hardware.rtc.IRtcManager;

/**
 * @hide
 */
public class RtcManager extends IRtcManager.Stub {
    static final String TAG = "RtcManager";
    public static final String Descriptor = "rtc";

    @Override
    public long getTime() {
        return native_getTime();
    }

    @Override
    public void setRtcWakeup(long secs) {
        native_setRtcWakeup(secs);
    }

    private native long native_getTime();
    private native void native_setRtcWakeup(long secs);
}
