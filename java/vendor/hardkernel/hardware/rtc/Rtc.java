package vendor.hardkernel.hardware.rtc;

import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import vendor.hardkernel.hardware.rtc.IRtcManager;
import vendor.hardkernel.hardware.rtc.internal.RtcManager;

public final class Rtc {
    private static final String TAG = "Rtc";

    private static Rtc sRtc;
    private IRtcManager mRtcManager;

    private Rtc() {
        Log.d(TAG, "Rtc init");
        mRtcManager = IRtcManager.Stub.asInterface(ServiceManager.getService(RtcManager.Descriptor));
    }

    public static Rtc getInstance() {
        synchronized (Rtc.class) {
            if (sRtc == null) {
                sRtc = new Rtc();
            }
            return sRtc;
        }
    }

    public String getTime() {
        String time = "";
        try {
            time = mRtcManager.getTime();
        } catch (RemoteException e) {
            Log.d(TAG, "Remote Exception!!");
        }
        return time;
    }

    public boolean setRtcWakeup(long secs, boolean enable) {
        try {
            if (enable) {
                mRtcManager.setRtcWakeup(secs);
            } else {
                mRtcManager.setRtcWakeup(0);
            }
            return true;
        } catch (RemoteException e) {
            Log.d(TAG, "Remote Exception!!");
            return false;
        }
    }
}
