package com.kcb.android.tourismguide.parcelable

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TourParcelable (
    var id: String? = null,
    var title: String? = null,
    var description: String? = null,
    var photo: String? = null,
    var timeOpen: String? = null,
    var timeClose: String? = null,
    var price: String? = null,
    var address: String? = null
): Parcelable