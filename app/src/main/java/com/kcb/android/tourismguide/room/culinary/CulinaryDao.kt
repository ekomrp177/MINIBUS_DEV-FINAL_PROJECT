package com.kcb.android.tourismguide.room.culinary

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.kcb.android.tourismguide.parcelable.CulinaryParcelable

@Dao
interface CulinaryDao {
    @Query("SELECT * from culinaryTable")
    fun getAll(): List<CulinaryParcelable>

    @Insert(onConflict = REPLACE)
    fun insert(culinaryParcelable: CulinaryParcelable)

    @Query("DELETE FROM culinaryTable WHERE title = :title")
    fun delete(title: String?)
}