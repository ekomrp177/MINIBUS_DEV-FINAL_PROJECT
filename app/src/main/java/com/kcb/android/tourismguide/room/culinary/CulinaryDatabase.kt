package com.kcb.android.tourismguide.room.culinary

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kcb.android.tourismguide.parcelable.CulinaryParcelable

@Database(entities = [CulinaryParcelable::class], version = 1)
abstract class CulinaryDatabase : RoomDatabase() {
    abstract fun culinaryDao(): CulinaryDao

    companion object{
        @Volatile
        private var INSTANCE : CulinaryDatabase? = null

        fun getInstance(context: Context): CulinaryDatabase? {
            if (INSTANCE == null){
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                    CulinaryDatabase::class.java, "CulinaryDB.db").build()
                }
            }
            return INSTANCE
        }
        fun destroyInstance(){
            INSTANCE = null
        }
    }
}