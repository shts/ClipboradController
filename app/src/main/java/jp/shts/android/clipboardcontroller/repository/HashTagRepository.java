package jp.shts.android.clipboardcontroller.repository;

import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import jp.shts.android.clipboardcontroller.dao.HashTag;
import jp.shts.android.clipboardcontroller.dao.HashTag_Relation;
import jp.shts.android.clipboardcontroller.dao.OrmaDatabase;

public class HashTagRepository implements Repository<HashTag> {
    private OrmaDatabase orma;

    @Inject
    public HashTagRepository(OrmaDatabase orma) {
        this.orma = orma;
    }

    private HashTag_Relation hashTagRelation() {
        return orma.relationOfHashTag();
    }

    @Override
    public Single<List<HashTag>> all() {
        return hashTagRelation().selector().executeAsObservable().toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Completable save(HashTag hashTag) {
        return orma.transactionAsCompletable(() -> hashTagRelation().upsert(hashTag));
    }

    @Override
    public Single<Integer> delete(@NonNull HashTag hashTag) {
        return hashTagRelation().deleter().idEq(hashTag.id).executeAsSingle()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public boolean isExist(long id) {
        return !hashTagRelation().selector().idEq(id).isEmpty();
    }
}
