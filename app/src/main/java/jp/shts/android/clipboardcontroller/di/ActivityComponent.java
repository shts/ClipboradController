package jp.shts.android.clipboardcontroller.di;

import dagger.Subcomponent;
import jp.shts.android.clipboardcontroller.EditActivity;
import jp.shts.android.clipboardcontroller.MainActivity;
import jp.shts.android.clipboardcontroller.di.scope.ActivityScope;

@ActivityScope
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(MainActivity activity);
    void inject(EditActivity activity);
}
