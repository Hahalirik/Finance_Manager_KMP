package com.example.myapplication_123654.android.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.myapplication_123654.android.R

sealed class AppScreen(
    var route: String,
    @StringRes val nameResource: Int,
    val icon: ImageVector
) {
    object AuthScreen: AppScreen("authScreen", R.string.screen_auth, Icons.Default.Person)
    object RegistrationScreen: AppScreen("registrationScreen", R.string.screen_registration, Icons.Default.Report)
    object TransactionScreen: AppScreen("transactionScreen", R.string.screen_transaction, Icons.Default.Money)
    object TransactionEditorScreen: AppScreen("transactionEditorScreen", R.string.screen_transaction_editor, Icons.Default.EditOff)
    object QrScreen: AppScreen("qrScreen", R.string.screen_qr, Icons.Default.QrCode)
    object SettingsScreen: AppScreen("settingsScreen", R.string.screen_settings, Icons.Default.Settings)

    companion object{
        fun getAll() = listOf(
            AuthScreen,
            RegistrationScreen,
            TransactionScreen,
            TransactionEditorScreen,
            QrScreen,
            SettingsScreen
        )
    }

}
