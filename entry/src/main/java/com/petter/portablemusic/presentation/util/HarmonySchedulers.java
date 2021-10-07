package com.petter.portablemusic.presentation.util;

import io.reactivex.rxjava3.core.Scheduler;
import ohos.eventhandler.EventHandler;
import ohos.eventhandler.EventRunner;

public final class HarmonySchedulers {
    private static final class MainHolder {
        static final Scheduler DEFAULT
                = new HandlerScheduler(new EventHandler(EventRunner.getMainEventRunner()));
    }

    private static final Scheduler MAIN_THREAD = RxHarmonyPlugins.initMainThreadScheduler(() -> MainHolder.DEFAULT);

    public static Scheduler mainThread() {
        return RxHarmonyPlugins.onMainThreadScheduler(MAIN_THREAD);
    }
}
