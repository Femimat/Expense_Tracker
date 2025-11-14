package com.example.expensetracker.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Light Theme Colors
private val LightPrimary = Color(0xFF4C9AFF)
private val LightOnPrimary = Color.White
private val LightBackground = Color(0xFFF5F5F5)
private val LightSurface = Color.White
private val LightOnSurface = Color(0xFF1E1E1E)
private val LightSecondary = Color(0xFF6C757D)
private val LightOnSecondary = Color.White
private val LightError = Color(0xFFFF5252)
private val LightOnError = Color.White

// Dark Theme Colors
private val DarkPrimary = Color(0xFF4C9AFF)
private val DarkOnPrimary = Color.White
private val DarkBackground = Color(0xFF121212)
private val DarkSurface = Color(0xFF1E1E1E)
private val DarkOnSurface = Color.White
private val DarkSecondary = Color(0xFF6C757D)
private val DarkOnSecondary = Color.White
private val DarkError = Color(0xFFFF5252)
private val DarkOnError = Color.White


// Custom colors for app-specific usage
object AppColors {
    // Light theme colors
    val lightCardBackground = Color.White
    val lightDivider = Color(0xFFE0E0E0)
    val lightTextPrimary = Color(0xFF1E1E1E)
    val lightTextSecondary = Color(0xFF6C757D)
    val lightIncomeColor = Color(0xFF4CAF50)
    val lightExpenseColor = Color(0xFFFF5252)
    val lightTransferColor = Color(0xFF4C9AFF)

    // Dark theme colors
    val darkCardBackground = Color(0xFF2D2D2D)
    val darkDivider = Color(0xFF3D3D3D)
    val darkTextPrimary = Color.White
    val darkTextSecondary = Color(0xFF9E9E9E)
    val darkIncomeColor = Color(0xFF66BB6A)
    val darkExpenseColor = Color(0xFFFF5252)
    val darkTransferColor = Color(0xFF4C9AFF)
}

private val LightColorScheme = lightColorScheme(
    primary = LightPrimary,
    onPrimary = LightOnPrimary,
    secondary = LightSecondary,
    onSecondary = LightOnSecondary,
    background = LightBackground,
    onBackground = LightOnSurface,
    surface = LightSurface,
    onSurface = LightOnSurface,
    error = LightError,
    onError = LightOnError
)

private val DarkColorScheme = darkColorScheme(
    primary = DarkPrimary,
    onPrimary = DarkOnPrimary,
    secondary = DarkSecondary,
    onSecondary = DarkOnSecondary,
    background = DarkBackground,
    onBackground = DarkOnSurface,
    surface = DarkSurface,
    onSurface = DarkOnSurface,
    error = DarkError,
    onError = DarkOnError
)

@Composable
fun ExpenseTrackerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

@Composable
fun getTextPrimaryColor(): Color {
    return if (isSystemInDarkTheme()) {
        AppColors.darkTextPrimary
    } else {
        AppColors.lightTextPrimary
    }
}

@Composable
fun getTextSecondaryColor(): Color {
    return if (isSystemInDarkTheme()) {
        AppColors.darkTextSecondary
    } else {
        AppColors.lightTextSecondary
    }
}

@Composable
fun getDividerColor(): Color {
    return if (isSystemInDarkTheme()) {
        AppColors.darkTextSecondary
    } else {
        AppColors.lightTextSecondary
    }
}

@Composable
fun getIncomeColor(): Color {
    return if (isSystemInDarkTheme()) {
        AppColors.darkIncomeColor
    } else {
        AppColors.lightIncomeColor
    }
}

@Composable
fun getExpenseColor(): Color {
    return if (isSystemInDarkTheme()) {
        AppColors.darkExpenseColor
    } else {
        AppColors.lightExpenseColor
    }
}