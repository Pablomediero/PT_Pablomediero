package com.example.pruebatecnica.pablomediero.core.ui.annotations

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

@Preview(
    name = "DARK MODE - ESP",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES,
    locale = "es",
    device = Devices.NEXUS_5
)
@Preview(
    name = "LIGHT MODE - ESP",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO,
    locale = "es",
    device = Devices.NEXUS_5
)@Preview(
    name = "DARK MODE - EN",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES,
    locale = "en",
    device = Devices.NEXUS_5
)
@Preview(
    name = "LIGHT MODE - EN",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO,
    locale = "en",
    device = Devices.NEXUS_5
)
annotation class ThemePreviews