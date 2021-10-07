package com.petter.portablemusic.presentation.util;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import ohos.eventhandler.EventHandler;
import ohos.eventhandler.InnerEvent;

import java.util.concurrent.TimeUnit;

final class HandlerScheduler extends Scheduler {
    private final EventHandler handler;

    HandlerScheduler(EventHandler handler) {
        this.handler = handler;
    }

    @Override
    public @NonNull Disposable scheduleDirect(@NonNull Runnable run, long delay, @NonNull TimeUnit unit) {
        if (run == null) throw new NullPointerException("run == null");
        if (unit == null) throw new NullPointerException("unit == null");

        run = RxJavaPlugins.onSchedule(run);
        ScheduledRunnable scheduled = new ScheduledRunnable(handler, run);
        InnerEvent innerEvent = InnerEvent.get(run);
        handler.sendEvent(innerEvent, unit.toMillis(delay));
        return scheduled;
    }

    @Override
    public @NonNull Worker createWorker() {
        return new HandlerWorker(handler);
    }

    private static final class HandlerWorker extends Worker {
        private final EventHandler handler;

        private volatile boolean disposed;

        private HandlerWorker(EventHandler handler) {
            this.handler = handler;
        }

        @Override
        public @NonNull Disposable schedule(@NonNull Runnable run, long delay, @NonNull TimeUnit unit) {
            if (run == null) throw new NullPointerException("run == null");
            if (unit == null) throw new NullPointerException("unit == null");

            if (disposed) {
                return Disposable.disposed();
            }
            run = RxJavaPlugins.onSchedule(run);

            ScheduledRunnable scheduled = new ScheduledRunnable(handler, run);

            InnerEvent innerEvent = InnerEvent.get(run);

            handler.sendEvent(innerEvent, unit.toMillis(delay));

            if (disposed) {
                handler.removeTask(scheduled);
                return Disposable.disposed();
            }
            return scheduled;
        }

        @Override
        public void dispose() {
            disposed = true;
            handler.removeAllEvent();
        }

        @Override
        public boolean isDisposed() {
            return disposed;
        }
    }

    private static final class ScheduledRunnable implements Runnable, Disposable {

        private final EventHandler handler;
        private final Runnable delegate;

        private volatile boolean disposed;

        private ScheduledRunnable(EventHandler handler, Runnable delegate) {
            this.handler = handler;
            this.delegate = delegate;
        }

        @Override
        public void dispose() {
            handler.removeTask(this);
            disposed = true;
        }

        @Override
        public boolean isDisposed() {
            return disposed;
        }

        @Override
        public void run() {
            try {
                delegate.run();
            } catch (Throwable t) {
                RxJavaPlugins.onError(t);
            }
        }
    }
}
