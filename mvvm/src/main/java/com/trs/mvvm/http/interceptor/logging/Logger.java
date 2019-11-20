package com.trs.mvvm.http.interceptor.logging;

import okhttp3.internal.platform.Platform;

/**
 * @author TRS
 * Create time : 2019/11/20
 * Explain :
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public interface Logger {
    void log(int level, String tag, String msg);

    Logger DEFAULT = new Logger() {
        @Override
        public void log(int level, String tag, String message) {
            Platform.get().log(level, message, null);
        }
    };
}
