package jp.shts.android.clipboardcontroller;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import jp.shts.android.clipboardcontroller.dao.OrmaDatabase;

public class MainActivity extends BaseActivity {

    @Inject
    CompositeDisposable disposable;

    @Inject
    OrmaDatabase ormaDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getComponent().inject(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(view -> startActivity(EditActivity.createIntent(this)));
    }

    @Override
    protected void onDestroy() {
        disposable.dispose();
        super.onDestroy();
    }
}
