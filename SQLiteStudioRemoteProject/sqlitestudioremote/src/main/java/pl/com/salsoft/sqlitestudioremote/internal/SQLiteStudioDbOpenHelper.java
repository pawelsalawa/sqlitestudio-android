package pl.com.salsoft.sqlitestudioremote.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by SalSoft Pawel Salawa on 08.02.15.
 */
public class SQLiteStudioDbOpenHelper extends SQLiteOpenHelper {

    private int realDbVersion;

    public SQLiteStudioDbOpenHelper(Context context, String dbPath) {
        super(context, dbPath, null, 1);
    }

    public SQLiteStudioDbOpenHelper(Context context, String dbPath, int version) {
        super(context, dbPath, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        realDbVersion = db.getVersion();
        db.setVersion(1);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        db.setVersion(realDbVersion);
    }
}
