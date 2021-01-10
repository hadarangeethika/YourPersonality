package itpdm.project.yourpersonality1.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import  itpdm.project.yourpersonality1.Question;

import java.util.ArrayList;
import java.util.List;

import static itpdm.project.yourpersonality1.data.QuizContract.MovieEntry.KEY_EID;
import static itpdm.project.yourpersonality1.data.QuizContract.MovieEntry.KEY_EQUES;
import static itpdm.project.yourpersonality1.data.QuizContract.MovieEntry.KEY_MID;
import static itpdm.project.yourpersonality1.data.QuizContract.MovieEntry.KEY_MQUES;
import static itpdm.project.yourpersonality1.data.QuizContract.MovieEntry.KEY_NID;
import static itpdm.project.yourpersonality1.data.QuizContract.MovieEntry.KEY_NQUES;
import static itpdm.project.yourpersonality1.data.QuizContract.MovieEntry.KEY_TID;
import static itpdm.project.yourpersonality1.data.QuizContract.MovieEntry.KEY_TQUES;
import static itpdm.project.yourpersonality1.data.QuizContract.MovieEntry.TABLE_ENERGY;
import static itpdm.project.yourpersonality1.data.QuizContract.MovieEntry.TABLE_MIND;
import static itpdm.project.yourpersonality1.data.QuizContract.MovieEntry.TABLE_NATURE;
import static itpdm.project.yourpersonality1.data.QuizContract.MovieEntry.TABLE_RESULTS;
import static itpdm.project.yourpersonality1.data.QuizContract.MovieEntry.TABLE_TACTICS;


public class DbHelper extends SQLiteOpenHelper {
	private static final int DATABASE_VERSION = 1;
	// Database Name
	private static final String DATABASE_NAME = "YourPersonality";
	// tasks table name

	private SQLiteDatabase dbase;
	public DbHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		dbase=db;

		db.execSQL("create Table users(username TEXT primary key, password TEXT) ");

		String msql = "CREATE TABLE IF NOT EXISTS " + TABLE_MIND + " ( "
				+ KEY_MID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ KEY_MQUES + " TEXT)";
		db.execSQL(msql);

		String esql = "CREATE TABLE IF NOT EXISTS " + TABLE_ENERGY + " ( "
				+ KEY_EID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ KEY_EQUES + " TEXT)";
		db.execSQL(esql);


		String nsql = "CREATE TABLE IF NOT EXISTS " + TABLE_NATURE + " ( "
				+ KEY_NID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ KEY_NQUES + " TEXT)";
		db.execSQL(nsql);


		String tsql = "CREATE TABLE IF NOT EXISTS " + TABLE_TACTICS + " ( "
				+ KEY_TID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ KEY_TQUES + " TEXT)";
		db.execSQL(tsql);

		String rsql = "CREATE TABLE IF NOT EXISTS " + TABLE_RESULTS +
				" ( id INTEGER PRIMARY KEY AUTOINCREMENT, result TEXT)";
		db.execSQL(rsql);



		addMindQuestions();
		addEnergyQuestions();
		addNatureQuestions();
		addTacticsQuestions();

	}

	//inserting user details to the database
	public Boolean insertUser(String username, String password){
		SQLiteDatabase database = this.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put("username", username);
		contentValues.put("password", password);
		long ins = database.insert("users",null,contentValues);
		if (ins==-1)
			return false;
		else
			return true;
	}

	//checking if the username exists
	public Boolean checkUsername(String username){
		SQLiteDatabase database = this.getWritableDatabase();
		//Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_USER + " WHERE " + KEY_USERNAME + " =? ",new String[]{username});
		Cursor cursor = database.rawQuery("Select * from users where username = ?",new String[] {username});
		if (cursor.getCount()>0)
			return true;
		else
			return false;
	}

	//checking the username and password to login
	public Boolean checkUsernamePassword(String username, String password){
		SQLiteDatabase db = this.getWritableDatabase();
		//Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_USER + " WHERE " + KEY_USERNAME + " =? AND " + KEY_PASSWORD + " =? ",new String[]{username,password});
		Cursor cursor = db.rawQuery("Select * from users where username = ? and password = ?",new String[] {username,password});
		if (cursor.getCount()>0)
			return true;
		else
			return false;
	}

	private void addMindQuestions() {
		Question m1 = new Question("1.You feel less energized after spending time with a group of people.");
		this.addMindQuestion(m1);
		Question m2 = new Question("2.If someone does not respond to your e-mail quickly, you start wondering if you said something wrong.");
		this.addMindQuestion(m2);
		Question m3 = new Question("3.If the room is full, you stay closer to the walls, avoiding the center.");
		this.addMindQuestion(m3);
		Question m4=new Question("4.You feel very anxious in a stressful situation.");
		this.addMindQuestion(m4);
		Question m5=new Question("5.You do not usually initiate conversations.");
		this.addMindQuestion(m5);
		Question m6=new Question("6.You usually find it difficult to relax when talking in front of many people.");
		this.addMindQuestion(m6);
		Question m7=new Question("7.An interesting book or a video game is often better than a social event.");
		this.addMindQuestion(m7);
		Question m8=new Question("8.You find it difficult to introduce yourself to other people.");
		this.addMindQuestion(m8);

	}
	private void addEnergyQuestions() {
		Question e1 = new Question("9.You stick to the traditional way of performing common tasks.");
		this.addEnergyQuestion(e1);
		Question e2 = new Question("10.You find it easy to stay to stay relaxed even when there is some pressure.");
		this.addEnergyQuestion(e2);
		Question e3 = new Question("11.You do not care for people who make themselves the center of attention.");
		this.addEnergyQuestion(e3);
		Question e4=new Question("12.Generally speaking, you rely  more on your experience than your imagination.");
		this.addEnergyQuestion(e4);
		Question e5=new Question("13.You often contemplate the reasons for human existence.");
		this.addEnergyQuestion(e5);
		Question e6=new Question("14.You usually get along better with people who are realistic.");
		this.addEnergyQuestion(e6);
		Question e7=new Question("15.You rarely do something out of sheer curiosity.");
		this.addEnergyQuestion(e7);
		Question e8=new Question("16.You would consider yourself a practical person.");
		this.addEnergyQuestion(e8);

	}
	private void addNatureQuestions() {
		Question n1 = new Question("17.It is often difficult for you to relate to other people's feelings.");
		this.addNatureQuestion(n1);
		Question n2 = new Question("18.You see yourself as very emotionally stable.");
		this.addNatureQuestion(n2);
		Question n3 = new Question("19.Winning a debate matters less to you than making sure no on gets upset.");
		this.addNatureQuestion(n3);
		Question n4=new Question("20.Your mood can change very quickly.");
		this.addNatureQuestion(n4);
		Question n5=new Question("21.You are more likely to offer emotional support than suggest ways to deal with the problem.");
		this.addNatureQuestion(n5);
		Question n6=new Question("22.You think that everyone's views should be respected regardless of facts.");
		this.addNatureQuestion(n6);
		Question n7=new Question("23.You consider yourself more practical than creative.");
		this.addNatureQuestion(n7);
		Question n8=new Question("24.You often spend time exploring unrealistic and impractical yet intriguing ideas.");
		this.addNatureQuestion(n8);

	}
	private void addTacticsQuestions() {
		Question t1 = new Question("25.When you take a trip, you prefer to just go without making a schedule.");
		this.addTacticsQuestion(t1);
		Question t2 = new Question("26.You are more of a natural improviser than a careful planner.");
		this.addTacticsQuestion(t2);
		Question t3 = new Question("27.You frequently misplace your things.");
		this.addTacticsQuestion(t3);
		Question t4 = new Question("28.You would rather improvise than spend time coming up with a detailed plan.");
		this.addTacticsQuestion(t4);
		Question t5 = new Question("29.The idea of making a to-do list for the weekend stresses you out.");
		this.addTacticsQuestion(t5);
		Question t6 = new Question("30.You find it hard to start working and tend to lose focus.");
		this.addTacticsQuestion(t6);
		Question t7 = new Question("31.Developing a plan and sticking to it is not an important part of a project.");
		this.addTacticsQuestion(t7);
		Question t8 = new Question("32.Your travel plans are not usually well thought out.");
		this.addTacticsQuestion(t8);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
		// Drop older table if existed
		db.execSQL("drop Table if exists users");
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_MIND);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_ENERGY);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NATURE);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_TACTICS);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_RESULTS);
		// Create tables again
		onCreate(db);
	}
	// Adding new question
	public void addMindQuestion(Question quest) {
		//SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_MQUES, quest.getQUESTION());


		// Inserting Row
		dbase.insert(TABLE_MIND, null, values);

	}

	public void addEnergyQuestion(Question questE) {
		//SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_EQUES, questE.getQUESTION());
		// Inserting Row
		dbase.insert(TABLE_ENERGY, null, values);

	}

	public void addNatureQuestion(Question questN) {
		//SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_NQUES, questN.getQUESTION());
		// Inserting Row
		dbase.insert(TABLE_NATURE, null, values);

	}

		public void addTacticsQuestion(Question questT) {
			//SQLiteDatabase db = this.getWritableDatabase();
			ContentValues values = new ContentValues();
			values.put(KEY_TQUES, questT.getQUESTION());
			// Inserting Row
			dbase.insert(TABLE_TACTICS, null, values);

		}

	//save user's answers to the database
	public boolean addResult(String result ){

		//get writable database
		SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
		//create content values

		ContentValues contentValues=new ContentValues();
		contentValues.put("result",result);
		//Add values int db
		sqLiteDatabase.insert(TABLE_RESULTS,null,contentValues);
		return true;

	}


	public List<Question> getAllMindQuestions() {
		List<Question> mindQList = new ArrayList<Question>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_MIND;
		dbase=this.getReadableDatabase();
		Cursor cursor = dbase.rawQuery(selectQuery, null);
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Question mindq = new Question();
				mindq.setID(cursor.getInt(0));
				mindq.setQUESTION(cursor.getString(1));

				mindQList.add(mindq);
			} while (cursor.moveToNext());
		}
		// return quest list
		return mindQList;
	}


	public List<Question> getAllEnergyQuestions() {
		List<Question> energyQList = new ArrayList<Question>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_ENERGY;
		dbase=this.getReadableDatabase();
		Cursor cursor = dbase.rawQuery(selectQuery, null);
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Question energyq = new Question();
				energyq.setID(cursor.getInt(0));
				energyq.setQUESTION(cursor.getString(1));
				energyQList.add(energyq);
			} while (cursor.moveToNext());
		}
		// return quest list
		return energyQList;
	}


	public List<Question> getAllNatureQuestions() {
		List<Question> natureQList = new ArrayList<Question>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_NATURE;
		dbase=this.getReadableDatabase();
		Cursor cursor = dbase.rawQuery(selectQuery, null);
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Question natureq = new Question();
				natureq.setID(cursor.getInt(0));
				natureq.setQUESTION(cursor.getString(1));
				natureQList.add(natureq);
			} while (cursor.moveToNext());
		}
		// return quest list
		return natureQList;
	}


	public List<Question> getAllTacticsQuestions() {
		List<Question> tacticsQList = new ArrayList<Question>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_TACTICS;
		dbase=this.getReadableDatabase();
		Cursor cursor = dbase.rawQuery(selectQuery, null);
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Question tacticsq = new Question();
				tacticsq.setID(cursor.getInt(0));
				tacticsq.setQUESTION(cursor.getString(1));
				tacticsQList.add(tacticsq);
			} while (cursor.moveToNext());
		}
		// return quest list
		return tacticsQList;
	}

	//display saved answers of the user
	public ArrayList getAllResults(){
		//Get readable database
		SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
		ArrayList<String> arrayList=new ArrayList<String>();
		//Create cursor to select all values
		Cursor cursor=sqLiteDatabase.rawQuery("select * from "+TABLE_RESULTS,null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()){
			arrayList.add(cursor.getString(cursor.getColumnIndex("result")));
			cursor.moveToNext();
		}
		return arrayList;
	}



}
