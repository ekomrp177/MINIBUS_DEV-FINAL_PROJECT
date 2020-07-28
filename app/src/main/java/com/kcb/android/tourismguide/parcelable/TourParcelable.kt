package com.kcb.android.tourismguide.parcelable

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "tourTable")
data class TourParcelable(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var idDB: Int? = null,
    @ColumnInfo(name = "idAPI") var id: String? = null,
    @ColumnInfo(name = "title") var title: String? = null,
    @ColumnInfo(name = "description") var description: String? = null,
    @ColumnInfo(name = "photo") var photo: String? = null,
    @ColumnInfo(name = "timeOpen") var timeOpen: String? = null,
    @ColumnInfo(name = "timeClose") var timeClose: String? = null,
    @ColumnInfo(name = "price") var price: String? = null,
    @ColumnInfo(name = "address") var address: String? = null
): Parcelable