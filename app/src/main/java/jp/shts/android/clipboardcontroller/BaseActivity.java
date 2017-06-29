package jp.shts.android.clipboardcontroller;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import jp.shts.android.clipboardcontroller.di.ActivityComponent;
import jp.shts.android.clipboardcontroller.di.ActivityModule;

public class BaseActivity extends AppCompatActivity {
    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @NonNull
    public ActivityComponent getComponent() {
        if (activityComponent == null) {
            MainApplication mainApplication = (MainApplication) getApplication();
            activityComponent = mainApplication.getAppComponent().plus(new ActivityModule(this));
        }
        return activityComponent;
    }
}
