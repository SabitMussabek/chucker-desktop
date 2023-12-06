package com.chuckerdesktop.api

import androidx.compose.ui.window.awaitApplication
import com.chuckerdesktop.internal.ui.MainScreen
import io.ktor.client.plugins.api.*
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class ChuckerDesktopPluginConfig {
    //todo add RetentionManager
}

val ChuckerDesktopPlugin: ClientPlugin<ChuckerDesktopPluginConfig> = createClientPlugin(
    "ChuckerDesktopPlugin",
    ::ChuckerDesktopPluginConfig
) {
    MainScope().launch {
        awaitApplication {
            MainScreen(client)
        }
    }
}