package id.erwinka.madesubmission1.listfilm

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ListFilmModel(
    val title: String,
    val description: String,
    val poster: Int,
    val releaseDate: String,
    val runningTime: String,
    val distributedBy: String
) : Parcelable