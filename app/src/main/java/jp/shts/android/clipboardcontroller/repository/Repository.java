package jp.shts.android.clipboardcontroller.repository;

import android.support.annotation.NonNull;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

interface Repository<T> {

    Single<List<T>> all();

    public Completable save(T t);

    public Single<Integer> delete(@NonNull T t);

    public boolean isExist(long id);
}
