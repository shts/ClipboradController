package jp.shts.android.clipboardcontroller.dao;

import com.github.gfx.android.orma.annotation.Column;
import com.github.gfx.android.orma.annotation.PrimaryKey;
import com.github.gfx.android.orma.annotation.Table;

@Table
public class HashTagGroup {
    @PrimaryKey(autoincrement = true)
    public long id;
    @Column
    public String content;
    @Column
    public long createdTimeMillis;
    @Column
    public long updatedTimeMillis;
}
