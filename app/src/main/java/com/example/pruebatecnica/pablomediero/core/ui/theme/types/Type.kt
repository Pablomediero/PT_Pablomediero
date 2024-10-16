package com.example.pruebatecnica.pablomediero.core.ui.theme.types

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.pruebatecnica.pablomediero.core.ui.theme.PTpmedieroTheme
import com.example.pruebatecnica.pablomediero.core.ui.theme.types.PTpmedieroTypesDefaults.Typography

object PTpmedieroTypesDefaults {
    val Typography = Typography(
        bodyLarge = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.5.sp
        ),
        titleLarge = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 22.sp,
            lineHeight = 28.sp,
            letterSpacing = 0.sp
        ),
        labelSmall = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Medium,
            fontSize = 11.sp,
            lineHeight = 16.sp,
            letterSpacing = 0.5.sp
        )

    )
}
@Immutable
data class PTpmedieroTypes(
    val typography: Typography = Typography
)
internal val LocalPTpmedieroTypes = staticCompositionLocalOf { PTpmedieroTypes() }

@Preview
@Composable
private fun TypePreview() {
    Surface {
        Column {
            Text(text = "Body Large", style = PTpmedieroTheme.types.typography.bodyLarge)
            Text(text = "Title Large", style = PTpmedieroTheme.types.typography.titleLarge)
            Text(text = "Label Smalll", style = PTpmedieroTheme.types.typography.labelSmall)
        }
    }
}
