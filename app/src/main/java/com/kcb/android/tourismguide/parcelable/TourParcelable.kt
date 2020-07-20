package com.kcb.android.tourismguide.parcelable

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TourParcelable (
    var title: String,
    var description: String,
    var photo: String,
    var timeOpen: String,
    var timeClose: String,
    var price: String,
    var address: String
): Parcelable