package jp.shts.android.clipboardcontroller;

import android.app.Application;

import jp.shts.android.clipboardcontroller.di.AppComponent;
import jp.shts.android.clipboardcontroller.di.AppModule;
import jp.shts.android.clipboardcontroller.di.DaggerAppComponent;

public class MainApplication extends Application {
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this)).build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
