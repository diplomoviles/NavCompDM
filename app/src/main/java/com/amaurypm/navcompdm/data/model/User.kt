package com.amaurypm.navcompdm.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var name: String?,
    var mobile: String?
): Parcelable