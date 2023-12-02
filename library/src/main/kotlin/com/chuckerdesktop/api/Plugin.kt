package com.chuckerdesktop.api

import androidx.compose.ui.window.ApplicationScope
import io.ktor.client.plugins.api.*

class ChuckerDesktopPluginConfig {
    var applicationScope: ApplicationScope? = null
}

val ChuckerDesktopPlugin: ClientPlugin<ChuckerDesktopPluginConfig> = createClientPlugin(
    "ChuckerDesktopPlugin",
    ::ChuckerDesktopPluginConfig
) {
    //todo
}