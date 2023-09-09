package com.amaurypm.navcompdm.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Creado por Amaury Perea Matsumura el 09/09/23
 */
@Parcelize
data class User(
    var name: String,
    var mobile: String
): Parcelable
