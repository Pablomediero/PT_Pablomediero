package com.example.pruebatecnica.pablomediero.core.ui.theme.icons

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import com.example.pruebatecnica.pablomediero.R
import com.example.pruebatecnica.pablomediero.core.ui.theme.icons.PTpmedieroIconsDefaults.IconArrowBack
import com.example.pruebatecnica.pablomediero.core.ui.theme.icons.PTpmedieroIconsDefaults.IconArrowRight
import com.example.pruebatecnica.pablomediero.core.ui.theme.icons.PTpmedieroIconsDefaults.IconDateRegister
import com.example.pruebatecnica.pablomediero.core.ui.theme.icons.PTpmedieroIconsDefaults.IconEdit
import com.example.pruebatecnica.pablomediero.core.ui.theme.icons.PTpmedieroIconsDefaults.IconMoreActions
import com.example.pruebatecnica.pablomediero.core.ui.theme.icons.PTpmedieroIconsDefaults.IconPerson
import com.example.pruebatecnica.pablomediero.core.ui.theme.icons.PTpmedieroIconsDefaults.IconPersonEmail
import com.example.pruebatecnica.pablomediero.core.ui.theme.icons.PTpmedieroIconsDefaults.IconPersonGender
import com.example.pruebatecnica.pablomediero.core.ui.theme.icons.PTpmedieroIconsDefaults.IconPhone
import com.example.pruebatecnica.pablomediero.core.ui.theme.icons.PTpmedieroIconsDefaults.IconPhoto

private object PTpmedieroIconsDefaults{
    val IconArrowBack = R.drawable.ic_arrow_back
    val IconArrowRight = R.drawable.ic_arrow_right
    val IconMoreActions = R.drawable.ic_more_actions
    val IconPerson = R.drawable.ic_person
    val IconPersonEmail = R.drawable.ic_person_email
    val IconPersonGender = R.drawable.ic_person_gender
    val IconDateRegister = R.drawable.ic_date_register
    val IconPhone = R.drawable.ic_phone
    val IconPhoto = R.drawable.ic_photo
    val IconEdit = R.drawable.ic_edit

}

@Immutable
data class PTpmedieroIcons(
    @DrawableRes val iconArrowBack: Int = IconArrowBack,
    @DrawableRes val iconArrowRight: Int = IconArrowRight,
    @DrawableRes val iconMoreActions: Int = IconMoreActions,
    @DrawableRes val iconPerson: Int = IconPerson,
    @DrawableRes val iconPersonEmail: Int = IconPersonEmail,
    @DrawableRes val iconPersonGender: Int =IconPersonGender,
    @DrawableRes val iconDateRegister: Int = IconDateRegister,
    @DrawableRes val iconPhone: Int = IconPhone,
    @DrawableRes val iconPhoto: Int = IconPhoto,
    @DrawableRes val iconEdit: Int = IconEdit
)

internal val LocalPTpmedieroIcons = staticCompositionLocalOf { PTpmedieroIcons() }
