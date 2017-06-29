package jp.shts.android.clipboardcontroller.di;

import android.support.v7.app.AppCompatActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    final AppCompatActivity activity;

    public ActivityModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    AppCompatActivity activity() {
        return activity;
    }
}
