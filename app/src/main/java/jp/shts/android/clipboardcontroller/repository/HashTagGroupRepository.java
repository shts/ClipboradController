package jp.shts.android.clipboardcontroller.repository;

import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import jp.shts.android.clipboardcontroller.dao.HashTagGroup;
import jp.shts.android.clipboardcontroller.dao.HashTagGroup_Relation;
import jp.shts.android.clipboardcontroller.dao.OrmaDatabase;

public class HashTagGroupRepository implements Repository<HashTagGroup> {

    private OrmaDatabase orma;

    @Inject
    HashTagGroupRepository(OrmaDatabase orma) {
        this.orma = orma;
    }

    private HashTagGroup_Relation hashTagGroupRelation() {
        return orma.relationOfHashTagGroup();
    }

    @Override
    public Single<List<HashTagGroup>> all() {
        return hashTagGroupRelation().selector().executeAsObservable().toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Completable save(HashTagGroup hashTagGroup) {
        return orma.transactionAsCompletable(() -> hashTagGroupRelation().upsert(hashTagGroup));
    }

    @Override
    public Single<Integer> delete(@NonNull HashTagGroup hashTagGroup) {
        return hashTagGroupRelation().deleter().idEq(hashTagGroup.id).executeAsSingle()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public boolean isExist(long id) {
        return !hashTagGroupRelation().selector().idEq(id).isEmpty();
    }
}
