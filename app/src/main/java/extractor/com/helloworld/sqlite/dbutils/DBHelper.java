package extractor.com.helloworld.sqlite.dbutils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "CURSODB.db";

    public static final String TABELA_CONTATOS = "CONTATOS";
    public static final String CONTATOS_COLUNA_ID = "ID";
    public static final String CONTATOS_COLUNA_NOME = "NOME";
    public static final String CONTATOS_COLUNA_EMAIL = "EMAIL";
    public static final String CONTATOS_COLUNA_RUA = "RUA";
    public static final String CONTATOS_COLUNA_CIDADE = "CIDADE";
    public static final String CONTATOS_COLUNA_TELEFONE = "TELEFONE";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public SQLiteDatabase getDataBase(){
        return this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuilder CRIA_TABELA_CONTATOS = new StringBuilder();
        CRIA_TABELA_CONTATOS.append("CREATE TABLE ").append(TABELA_CONTATOS);
        CRIA_TABELA_CONTATOS.append(" (").append(CONTATOS_COLUNA_ID).append(" INTEGER PRIMARY KEY, ");
        CRIA_TABELA_CONTATOS.append(CONTATOS_COLUNA_NOME).append(" TEXT, ");
        CRIA_TABELA_CONTATOS.append(CONTATOS_COLUNA_EMAIL).append(" TEXT, ");
        CRIA_TABELA_CONTATOS.append(CONTATOS_COLUNA_RUA).append(" TEXT, ");
        CRIA_TABELA_CONTATOS.append(CONTATOS_COLUNA_CIDADE).append(" TEXT, ");
        CRIA_TABELA_CONTATOS.append(CONTATOS_COLUNA_TELEFONE).append(" TEXT)");

        db.execSQL(CRIA_TABELA_CONTATOS.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_CONTATOS);
        onCreate(db);
    }
}
