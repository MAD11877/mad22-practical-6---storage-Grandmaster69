package sg.edu.np.mad.madpractical;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    public DBHandler(Context c)
    {
        super(c, "users.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE User (name TEXT, description TEXT, id INTEGER, followed INTEGER)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS User");
        onCreate(sqLiteDatabase);
    }

    public void insertUser(User u)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Integer i = 0;
        if (u.Followed == true) {
            i = 1;
        }
        db.execSQL("INSERT INTO User VALUES(\"" + u.Name + "\",\"" + u.Description + "\",\"" + u.Id + "\",\"" + i + "\")");
        db.close();
    }

    public ArrayList<User> getUsers()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<User> userList = new ArrayList<>();
        Cursor c = db.rawQuery("select * from user", null);
        while(c.moveToNext()) {
            String name = c.getString(0);
            String desc = c.getString(1);
            Integer id = c.getInt(2);
            Integer f = c.getInt(3);
            Boolean followed;
            if (f == 1) {
                followed = true;
            } else {
                followed = false;
            }
            User user = new User(name, desc, id, followed);
            userList.add(user);
        }
        db.close();
        return userList;
    }

    public void updateUser(User u)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Integer i = 0;
        if(u.Followed == true){
            i = 1;
        }
        db.execSQL("UPDATE User SET Followed = \""+ i +"\" " +  "WHERE Id = \""+ u.Id +"\"");
        db.close();
    }
}