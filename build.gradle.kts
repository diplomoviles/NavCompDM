// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    //Aquí solamente cargamos los plugins a usar
    //a nivel del proyecto, pero todavía no los aplicamos
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.androidx.navigation.safeargs) apply false
    alias(libs.plugins.kotlin.parcelize) apply false
}