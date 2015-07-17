package com.perkdev.lessontracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBAdapter {
	
	// -- Database constants
	public static final String DATABASE_NAME = "lesson_tracker";
	public static final int DATABASE_VERSION = 1;
	
	
	// -- Student Table Definitions
	public static final String STUDENT_ID = "id";
	public static final String STUDENT_FNAME = "firstName";
	public static final String STUDENT_LNAME = "lastName";
	public static final String STUDENT_PNAME = "preferredName";
	public static final String STUDENT_ADDRESS = "streetAddress";
	public static final String STUDENT_CITY = "city";
	public static final String STUDENT_STATE = "state";
	public static final String STUDENT_ZIP = "zip";
	public static final String STUDENT_PHONE = "phone";
	public static final String STUDENT_PARENTNAME = "parentName";
	public static final String STUDENT_PARENTPHONE = "parentPhone";
	public static final String STUDENT_BIRTHDATE = "birthDate";
	
	
	private static final String TABLE_STUDENT = "student";
	
	private static final String STUDENT_TABLE_CREATE = "create table if not exists " + TABLE_STUDENT + " (id integer primary key autoincrement, "
	+ "firstName VARCHAR not null, lastName VARCHAR not null, preferredName VARCHAR not null, birthDate DATE null, "
	+ "address VARCHAR not null, city VARCHAR not null, state chat(2) not null, zip char(10) not null, phone char(14), "
	+ "parentName VARCHAR not null, parentPhone not null);";
	
	// -- Appointment Table Definition
	public static final String APPOINTMENT_ID = "id";
	public static final String APPOINTMENT_DATE = "date";
	public static final String APPOINTMENT_START = "startTime";
	public static final String APPOINTMENT_END = "endTime";
	public static final String APPOINTMENT_STATUS = "status";
		

	private static final String TABLE_APPOINTMENT = "appointment";
	
	private static final String APPOINTMENT_TABLE_CREATE = "create table if not exists " + TABLE_APPOINTMENT + " (id integer primary key autoincrement, "
			+ "date TEXT not null, startTime TEXT not null, endTime TEXT not null, status int not null);";
	
	
	// -- Payment Table Definition
	private static final String PAYMENT_ID = "id";
	private static final String PAYMENT_AMOUNT = "amount";
	private static final String PAYMENT_TYPE = "type";
	private static final String PAYMENT_DATE = "date";
	private static final String PAYMENT_CHECKNUMBER = "checkNum";
	private static final String PAYMENT_NOTES = "notes";
	
	private static final String TABLE_PAYMENT = "payment";
	private static final String PAYMENT_TABLE_CREATE = "create table if not exists " + TABLE_PAYMENT + " (id integer primary key autoincrement, "
			+ "amount REAL not null, type INTEGER not null, date TEXT not null, checkNum TEXT null, notes TEXT null);";
	
	// -- XRef Table for Student and Appointment relationship
	private static final String APPOINTMENT_XREF_ID = "appointmentId";
	private static final String STUDENT_XREF_ID = "studentId";
	
	private static final String TABLE_APPOINTMENT_STUDENT_XREF = "appointment_student_xref";
	private static final String APPOINTMENT_STUDENT_TABLE_CREATE = "create table if not exists " + TABLE_APPOINTMENT_STUDENT_XREF  + " appointment_student_xref (appointmentId integer not null, "
			+ "studentId int not null);";
	
	// -- XRef Table for Student and Payment relationship
	private static final String PAYMENT_XREF_ID = "paymentId";
	
	
	private static final String TABLE_PAYMENT_STUDENT_XREF = "payment_student_xref";
	private static final String PAYMENT_STUDENT_TABLE_CREATE = "create table if not exists " + TABLE_PAYMENT_STUDENT_XREF  + "  (paymentId integer not null, "
			+ "studentId int not null);";

	
	private final Context context;
	
	private DatabaseHelper DBHelper;
	private SQLiteDatabase db;
	
	
	public DBAdapter(Context ctx)
	{
		this.context = ctx;
		
		DBHelper = new DatabaseHelper(context);
	}
	private static class DatabaseHelper extends SQLiteOpenHelper
	{
		DatabaseHelper(Context context)
		{
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(android.database.sqlite.SQLiteDatabase db) {
			try
			{
			 db.execSQL(STUDENT_TABLE_CREATE);
			 db.execSQL(APPOINTMENT_TABLE_CREATE);
			 db.execSQL(APPOINTMENT_STUDENT_TABLE_CREATE);
			 db.execSQL(PAYMENT_TABLE_CREATE);
			 db.execSQL(PAYMENT_STUDENT_TABLE_CREATE);
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			
			
		}

		@Override
		public void onUpgrade(android.database.sqlite.SQLiteDatabase arg0,
				int arg1, int arg2) {
			// TODO Auto-generated method stub
			
		}
	}
}
	
	
	
	
	
	