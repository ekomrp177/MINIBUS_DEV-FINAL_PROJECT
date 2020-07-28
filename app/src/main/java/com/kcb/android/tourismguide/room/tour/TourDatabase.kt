package com.kcb.android.tourismguide.room.tour

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kcb.android.tourismguide.parcelable.TourParcelable

@Database(entities = [TourParcelable::class], version = 1)
abstract class TourDatabase: RoomDatabase() {
    abstract fun tourDao(): TourDao

    companion object{
        @Volatile
        private var INSTANCE : TourDatabase? = null

        fun getInstance(context: Context): TourDatabase? {
            if (INSTANCE == null){
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                    TourDatabase::class.java, "TourDB.db").build()
                }
            }
            return INSTANCE
        }
        fun destroyInstance(){
            INSTANCE = null
        }
    }
}