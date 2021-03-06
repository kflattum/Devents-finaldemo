package com.dartmouth.kd.devents;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import java.util.ArrayList;

/**
 *
 * CLASS INCLUDES FILTERING ALGORITHM
 *
 * Created by kathrynflattum on 2/25/18.
 */

public class CampusEventDbHelper extends SQLiteOpenHelper {
    // Database name string
    public static final String DATABASE_NAME = "CampusEventsDB";
    // Two tables- one to store all events and one to store MyDEvents
    private static final String TABLE_EVENT_ENTRIES = "EVENTS";
    private static final String TABLE_DEVENTS = "DEVENTS";
    private SQLiteDatabase dbObj;
    // Version code
    private static final int DATABASE_VERSION = 1;

    // Table schema, column names
    public static final String KEY_ROWID = "_id";
    public static final String KEY_TITLE = "Title";
    public static final String KEY_DATE = "Date";
    public static final String KEY_START = "Start";
    public static final String KEY_END = "End";
    public static final String KEY_LOCATION = "Location";
    public static final String KEY_DESCRIPTION = "Description";
    public static final String KEY_URL = "URL";
    public static final String KEY_LATITUDE = "Latitude";
    public static final String KEY_LONGITUDE = "Longitude";
    public static final String KEY_FOOD = "Food";
    public static final String KEY_MAJOR = "Major";
    public static final String KEY_EVENT_TYPE = "EventType";
    public static final String KEY_PROGRAM_TYPE = "ProgramType";
    public static final String KEY_YEAR = "Year";
    public static final String KEY_GREEK_SOCIETY = "GreekSociety";
    public static final String KEY_GENDER = "Gender";

    // SQL query to create the table for the first time
    // Data types are defined below
    private static final String CREATE_TABLE_ENTRIES = "CREATE TABLE IF NOT EXISTS "
            + TABLE_EVENT_ENTRIES
            + "("
            + KEY_ROWID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + KEY_TITLE
            + " TEXT, "
            + KEY_DATE
            + " DATETIME, "
            + KEY_START
            + " DATETIME, "
            + KEY_END
            + " DATETIME, "
            + KEY_LOCATION
            + " TEXT, "
            + KEY_DESCRIPTION
            + " TEXT, "
            + KEY_URL
            + " TEXT, "
            + KEY_LATITUDE
            + " DOUBLE, "
            + KEY_LONGITUDE
            + " DOUBLE, "
            + KEY_FOOD
            + " INT, "
            + KEY_EVENT_TYPE
            + " INT, "
            + KEY_PROGRAM_TYPE
            + " INT, "
            + KEY_YEAR
            + " INT, "
            + KEY_MAJOR
            + " INT, "
            + KEY_GREEK_SOCIETY
            + " INT, "
            + KEY_GENDER
            + " INT "
            + ");";

    private static final String CREATE_TABLE_DEVENTS = "CREATE TABLE IF NOT EXISTS "
            + TABLE_DEVENTS
            + "("
            + KEY_ROWID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + KEY_TITLE
            + " TEXT, "
            + KEY_DATE
            + " DATETIME, "
            + KEY_START
            + " DATETIME, "
            + KEY_END
            + " DATETIME, "
            + KEY_LOCATION
            + " TEXT, "
            + KEY_DESCRIPTION
            + " TEXT, "
            + KEY_URL
            + " TEXT, "
            + KEY_LATITUDE
            + " DOUBLE, "
            + KEY_LONGITUDE
            + " DOUBLE, "
            + KEY_FOOD
            + " INT, "
            + KEY_EVENT_TYPE
            + " INT, "
            + KEY_PROGRAM_TYPE
            + " INT, "
            + KEY_YEAR
            + " INT, "
            + KEY_MAJOR
            + " INT, "
            + KEY_GREEK_SOCIETY
            + " INT, "
            + KEY_GENDER
            + " INT "
            + ");";

    private static final String[] mColumnList = new String[]{KEY_ROWID,
            KEY_TITLE, KEY_DATE, KEY_START, KEY_END,
            KEY_LOCATION, KEY_DESCRIPTION, KEY_URL, KEY_LATITUDE, KEY_LONGITUDE, KEY_FOOD, KEY_EVENT_TYPE,
            KEY_PROGRAM_TYPE, KEY_YEAR, KEY_MAJOR, KEY_GREEK_SOCIETY, KEY_GENDER};

    public CampusEventDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_ENTRIES);
        db.execSQL(CREATE_TABLE_DEVENTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

    }

    public void deleteAllEvents() {
        SQLiteDatabase dbObj = getWritableDatabase();
        dbObj.delete(CampusEventDbHelper.TABLE_EVENT_ENTRIES, null, null);
        dbObj.delete(CampusEventDbHelper.TABLE_DEVENTS, null, null);
    }

    // Insert a item given each column value
    public long insertEntry(CampusEvent event) {

        ContentValues value = new ContentValues();

        value.put(KEY_TITLE, event.getTitle());

        value.put(KEY_DATE, event.getstrDate());
        value.put(KEY_START, event.getstrStart());
        value.put(KEY_END, event.getstrEnd());

        value.put(KEY_LOCATION, event.getLocation());
        value.put(KEY_DESCRIPTION, event.getDescription());
        value.put(KEY_URL, event.getURL());
        value.put(KEY_LATITUDE, event.getLatitude());
        value.put(KEY_LONGITUDE, event.getLongitude());
        value.put(KEY_FOOD, event.getFood());
        value.put(KEY_EVENT_TYPE, event.getEventType());
        value.put(KEY_PROGRAM_TYPE, event.getProgramType());
        value.put(KEY_YEAR, event.getYear());
        value.put(KEY_MAJOR, event.getMajor());
        value.put(KEY_GENDER, event.getGender());
        value.put(KEY_GREEK_SOCIETY, event.getGreekSociety());
        dbObj = getWritableDatabase();
        long id = dbObj.insert(TABLE_EVENT_ENTRIES, null, value);
        dbObj.close();
        return id;
    }


    // Insert a item given each column value
    public long insertEntry2(CampusEvent event) {

        ContentValues value = new ContentValues();

        value.put(KEY_TITLE, event.getTitle());

        value.put(KEY_DATE, event.getstrDate());
        value.put(KEY_START, event.getstrStart());
        value.put(KEY_END, event.getstrEnd());
        value.put(KEY_LOCATION, event.getLocation());
        value.put(KEY_DESCRIPTION, event.getDescription());
        value.put(KEY_URL, event.getURL());
        value.put(KEY_LATITUDE, event.getLatitude());
        value.put(KEY_LONGITUDE, event.getLongitude());
        value.put(KEY_FOOD, event.getFood());
        value.put(KEY_EVENT_TYPE, event.getEventType());
        value.put(KEY_PROGRAM_TYPE, event.getProgramType());
        value.put(KEY_YEAR, event.getYear());
        value.put(KEY_MAJOR, event.getMajor());
        value.put(KEY_GENDER, event.getGender());
        value.put(KEY_GREEK_SOCIETY, event.getGreekSociety());
        dbObj = getWritableDatabase();
        long id = dbObj.insert(TABLE_DEVENTS, null, value);
        dbObj.close();
        return id;
    }
    // Remove a entry by giving its index
    public void removeEvent(long rowIndex) {
        SQLiteDatabase dbObj = getWritableDatabase();
        dbObj.delete(TABLE_EVENT_ENTRIES, KEY_ROWID + "=" + rowIndex, null);
        dbObj.close();
    }

    // Query a specific entry by its index. Return a cursor having each column
    // value
    public CampusEvent fetchEventByIndex(long rowId) throws SQLException {
        SQLiteDatabase dbObj = getReadableDatabase();
        CampusEvent event = null;

        Cursor cursor = dbObj.query(true, TABLE_EVENT_ENTRIES, mColumnList,
                KEY_ROWID + "=" + rowId, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            event = cursorToEvent(cursor);
        }

        cursor.close();
        dbObj.close();

        return event;
    }

    public CampusEvent fetchEventByIndex2(long rowId) throws SQLException {
        SQLiteDatabase dbObj = getReadableDatabase();
        CampusEvent event = null;

        Cursor cursor = dbObj.query(true, TABLE_DEVENTS, mColumnList,
                KEY_ROWID + "=" + rowId, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            event = cursorToEvent(cursor);
        }

        cursor.close();
        dbObj.close();

        return event;
    }

    // Query the entire table, return all rows
    public ArrayList<CampusEvent> fetchEvents() {
        SQLiteDatabase dbObj = getReadableDatabase();
        ArrayList<CampusEvent> entryList = new ArrayList<CampusEvent>();

        Cursor cursor = dbObj.query(TABLE_EVENT_ENTRIES, mColumnList, null,
                null, null, null, null);

        while (cursor.moveToNext()) {
            CampusEvent event = cursorToEvent(cursor);
            entryList.add(event);
        }

        cursor.close();
        dbObj.close();

        return entryList;
    }

    // Query the entire table, return all rows
    public ArrayList<CampusEvent> fetchEvents2() {
        SQLiteDatabase dbObj = getReadableDatabase();
        ArrayList<CampusEvent> entryList = new ArrayList<CampusEvent>();

        Cursor cursor = dbObj.query(TABLE_DEVENTS, mColumnList, null,
                null, null, null, null);

        while (cursor.moveToNext()) {
            CampusEvent event = cursorToEvent(cursor);
            entryList.add(event);
        }

        cursor.close();
        dbObj.close();

        return entryList;
    }

    private CampusEvent cursorToEvent(Cursor cursor) {
        CampusEvent event = new CampusEvent();
        event.setmId(cursor.getLong(cursor.getColumnIndex(KEY_ROWID)));

        event.setTitle(cursor.getString(cursor.getColumnIndex(KEY_TITLE)));

        event.setstrStart(cursor.getString(cursor.getColumnIndex(KEY_START)));
        event.setstrDate(cursor.getString(cursor.getColumnIndex(KEY_DATE)));
        event.setstrEnd(cursor.getString(cursor.getColumnIndex(KEY_END)));
        event.setLocation(cursor.getString(cursor.getColumnIndex(KEY_LOCATION)));
        event.setDescription(cursor.getString(cursor.getColumnIndex(KEY_DESCRIPTION)));
        event.setURL(cursor.getString(cursor.getColumnIndex(KEY_URL)));
        event.setLatitude(cursor.getDouble(cursor.getColumnIndex(KEY_LATITUDE)));
        event.setLongitude(cursor.getDouble(cursor.getColumnIndex(KEY_LONGITUDE)));
        event.setFood(cursor.getInt(cursor.getColumnIndex(KEY_FOOD)));
        event.setMajor(cursor.getInt(cursor.getColumnIndex(KEY_MAJOR)));
        event.setEventType(cursor.getInt(cursor.getColumnIndex(KEY_EVENT_TYPE)));
        event.setProgramType(cursor.getInt(cursor.getColumnIndex(KEY_PROGRAM_TYPE)));
        event.setYear(cursor.getInt(cursor.getColumnIndex(KEY_YEAR)));
        event.setGreekSociety(cursor.getInt(cursor.getColumnIndex(KEY_GREEK_SOCIETY)));
        event.setGender(cursor.getInt(cursor.getColumnIndex(KEY_GENDER)));
        return event;
    }



    /*
    *Below is the filtering algorithm for showing relevant events
    * Written by KF
     */
    public ArrayList<CampusEvent> eventListFilter (ArrayList<CampusEvent> campusEvents, Filters filter) {
        ArrayList<CampusEvent> newList = new ArrayList<CampusEvent>();
        //if all the filters are zero, return original list
        Log.d(Globals.TAGG, "Showing what the filters are");

        if (filter == null) {
            Log.d(Globals.TAGG, "All filters are null");
            return campusEvents;
        } else {
            if (filter.getfFood() == 0 && filter.getfEventType() == 0 && filter.getfProgramType() == 0 && filter.getfGender() == 0 && filter.getfGreekSociety() == 0 && filter.getfMajor() == 0 && filter.getfYear() == 0) {
                return campusEvents;
            }
            if (filter.getfFood() != 0) {
                for (CampusEvent event : campusEvents) {
                    int scaleval = filter.getfFood() - 1;
                    if (event.getFood() == scaleval) {
                        newList.add(event);
                    }
                }
            }
            if (filter.getfEventType() != 0) {
                for (CampusEvent event : campusEvents) {
                    int scaleval = filter.getfEventType() - 1;
                    if (event.getEventType() == scaleval) {
                        newList.add(event);
                    }
                }
            }

            if (filter.getfProgramType() != 0) {
                for (CampusEvent event : campusEvents) {
                    if (event.getProgramType() == filter.getfProgramType()) {
                        newList.add(event);
                    }
                }
            }

            if (filter.getfYear() != 0) {
                for (CampusEvent event : campusEvents) {
                    if (event.getYear() == filter.getfYear()) {
                        newList.add(event);
                    }
                }
            }

            if (filter.getfMajor() != 0) {
                for (CampusEvent event : campusEvents) {
                    if (event.getMajor() == filter.getfMajor()) {
                        newList.add(event);
                    }
                }
            }

            if (filter.getfGender() != 0) {
                for (CampusEvent event : campusEvents) {
                    if (event.getGender() == filter.getfGender()) {
                        newList.add(event);
                    }
                }
            }

            if (filter.getfGreekSociety() != 0) {
                for (CampusEvent event : campusEvents) {
                    if (event.getGreekSociety() == filter.getfGreekSociety()) {
                        newList.add(event);
                    }
                }
            }

            return newList;
        }
    }

}
