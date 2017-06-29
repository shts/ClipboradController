package jp.shts.android.clipboardcontroller;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import jp.shts.android.clipboardcontroller.databinding.ActivityEditBinding;

public class EditActivity extends BaseActivity {

    public static Intent createIntent(@NonNull Context context) {
        return new Intent(context, EditActivity.class);
    }

    @Inject
    CompositeDisposable disposable;

    private ActivityEditBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_edit);
        getComponent().inject(this);
    }

    @Override
    protected void onDestroy() {
        disposable.dispose();
        super.onDestroy();
    }
}
