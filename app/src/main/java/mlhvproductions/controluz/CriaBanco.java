package mlhvproductions.controluz;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Date;

public class CriaBanco extends SQLiteOpenHelper {
        private static final String NOME_BANCO = "banco.db";
        public static final String TABELA = "luzes";
        public static final String ID = "_id";
        public static final String TITULO = "titulo";
        public static final String DATA = "data";
        private static final int VERSAO = 1;

    public CriaBanco(Context context){
        super(context, NOME_BANCO,null,VERSAO);
    }


        @Override
        public void onCreate(SQLiteDatabase db) {
            String sql = "CREATE TABLE"+TABELA+"("
                    + ID + " integer primary key autoincrement,"
                    + TITULO + " text,"
                    + DATA + " text,"
                    +")";
            db.execSQL(sql);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS" + TABELA);
            onCreate(db);
        }
    }

