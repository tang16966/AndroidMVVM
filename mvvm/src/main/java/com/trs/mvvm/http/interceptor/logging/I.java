package com.trs.mvvm.http.interceptor.logging;


import java.util.logging.Level;

import okhttp3.internal.platform.Platform;

/**
 * @author TRS
 * Create time : 2019/11/20
 * Explain :
 */
class I {

    protected I() {
        throw new UnsupportedOperationException();
    }

    static void log(int type, String tag, String msg) {
        java.util.logging.Logger logger = java.util.logging.Logger.getLogger(tag);
        switch (type) {
            case Platform.INFO:
                logger.log(Level.INFO, msg);
                break;
            default:
                logger.log(Level.WARNING, msg);
                break;
        }
    }
}
