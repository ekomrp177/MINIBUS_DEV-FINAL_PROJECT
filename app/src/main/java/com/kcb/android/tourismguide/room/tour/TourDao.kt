package com.kcb.android.tourismguide.room.tour

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kcb.android.tourismguide.parcelable.TourParcelable


@Dao
interface TourDao {
    @Query("SELECT * from tourTable")
    fun getAll(): List<TourParcelable>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(tourParcelable: TourParcelable)

    @Query("DELETE FROM tourTable WHERE title = :title")
    fun delete(title: String?)
}