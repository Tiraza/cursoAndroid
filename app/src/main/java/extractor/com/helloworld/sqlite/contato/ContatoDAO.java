package extractor.com.helloworld.sqlite.contato;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import extractor.com.helloworld.sqlite.dbutils.DBHelper;

public class ContatoDAO {

    private SQLiteDatabase db;
    private Context context;

    public ContatoDAO(Context context) {
        this.context = context;
        db = new DBHelper(context).getDataBase();
    }

    public Boolean inserirContato(Contato contato){
        ContentValues contentValues = getContent(contato);
        db.insert(DBHelper.TABELA_CONTATOS, null, contentValues);
        return true;
    }

    public Boolean updateContato(Contato contato){
        ContentValues contentValues = getContent(contato);
        db.update(DBHelper.TABELA_CONTATOS, contentValues, "ID = ?", new String[] {contato.getId().toString()});
        return true;
    }

    public Integer deleteContato(Integer id){
        return db.delete(DBHelper.TABELA_CONTATOS, "ID = ?", new String[] {id.toString()});
    }

    public Contato getContatoPorID(Integer id){
        StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM ").append(DBHelper.TABELA_CONTATOS);
        query.append(" WHERE ").append(DBHelper.CONTATOS_COLUNA_ID).append(" = ").append(id.toString());

        Cursor cursor = db.rawQuery(query.toString(), null);
        cursor.moveToFirst();

        Contato contato = preecherContatoPorCursor(cursor);

        if(!cursor.isClosed()){
            cursor.close();
        }

        return contato;
    }

    public ArrayList<Contato> getContatos(){
        ArrayList<Contato> contatos = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM " + DBHelper.TABELA_CONTATOS, null);
        cursor.moveToFirst();

        Contato contato;
        while(!cursor.isAfterLast()){
            contato = preecherContatoPorCursor(cursor);
            contatos.add(contato);
            cursor.moveToNext();
        }

        if(!cursor.isClosed()){
            cursor.close();
        }
        return contatos;
    }

    private ContentValues getContent(Contato contato){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.CONTATOS_COLUNA_NOME, contato.getNome());
        contentValues.put(DBHelper.CONTATOS_COLUNA_TELEFONE, contato.getTelefone());
        contentValues.put(DBHelper.CONTATOS_COLUNA_EMAIL, contato.getEmail());
        contentValues.put(DBHelper.CONTATOS_COLUNA_RUA, contato.getRua());
        contentValues.put(DBHelper.CONTATOS_COLUNA_CIDADE, contato.getCidade());
        return contentValues;
    }

    private Contato preecherContatoPorCursor(Cursor cursor){
        Contato contato = new Contato();
        contato.setId(cursor.getInt(0));
        contato.setNome(cursor.getString(1));
        contato.setEmail(cursor.getString(2));
        contato.setRua(cursor.getString(3));
        contato.setCidade(cursor.getString(4));
        contato.setTelefone(cursor.getString(5));
        return contato;
    }
}
