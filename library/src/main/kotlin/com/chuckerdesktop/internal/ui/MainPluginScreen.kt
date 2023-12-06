package com.chuckerdesktop.internal.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.res.useResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.ApplicationScope
import androidx.compose.ui.window.Tray
import androidx.compose.ui.window.Window
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.statement.*
import kotlinx.coroutines.launch

@Composable
internal fun ApplicationScope.MainPluginScreen(client: HttpClient) {
    var isVisible by remember { mutableStateOf(false) }

    Window(
        title = "Chucker desktop",
        visible = isVisible,
        onCloseRequest = { isVisible = false },
//      icon = BitmapPainter(useResource("icons/umag_logo.ico", ::loadImageBitmap)) todo
    ) {
        val coroutineScope = rememberCoroutineScope()
        val logs = remember { mutableStateListOf<AnnotatedString>() }
        val listState = rememberLazyListState()

        LaunchedEffect(isVisible) {
            if (isVisible)
                coroutineScope.launch {
                    if (listState.layoutInfo.totalItemsCount > 0)
                        listState.animateScrollToItem(index = listState.layoutInfo.totalItemsCount)
                }
        }
        LaunchedEffect(true) {
            client.plugin(HttpSend).intercept { request ->
                //todo add request logs
                val call = execute(request)
                val response = call.response

                logs.add(
                    buildAnnotatedString {
                        append(
                            """ 
                                HttpClient: RESPONSE: ${response.status.value}
                                METHOD: ${response.request.method}
                                FROM: 
                            """.trimIndent()
                        )
                        withStyle(
                            style = SpanStyle(
                                color = Color.Blue,
                                textDecoration = TextDecoration.Underline
                            )
                        ) { append(request.url.build().toString() + "\n") }
                        append(
                            """
                                COMMON HEADERS
                                ${response.headers["client-status"]?.let { "-> client-status: $it" }}
                                ${response.headers["connection"]?.let { "-> connection: $it" }}
                                ${response.headers["content-type"]?.let { "-> content-type: $it" }}
                                ${response.headers["date"]?.let { "-> date: $it" }}
                                ${response.headers["server"]?.let { "-> server: $it" }}
                                ${response.headers["transfer-encoding"]?.let { "-> transfer-encoding: $it" }}
                                ${response.headers["vary"]?.let { "-> vary:  $it" }}
                                BODY Content-Type: ${response.headers["Content-Type"]}
                                BODY START
                                    ${response.body<String>()}
                                BODY END
                            """.trimIndent()
                        )
                    }
                )
                coroutineScope.launch {
                    if (listState.layoutInfo.totalItemsCount > 0)
                        listState.animateScrollToItem(index = listState.layoutInfo.totalItemsCount)
                }
                call
            }
        }


        LazyColumn(
            state = listState,
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0XFF1e1f22))
                .padding(start = 16.dp, top = 16.dp)
        ) {
            items(logs) {
                SelectionContainer() {
                    Text(
                        text = it,
//                                style = UmagTextStyles.FONT_PRIMARY_MEDIUM_16,
                        color = Color(0XFFc8ccd0),
                    )
                }
                Spacer(Modifier.height(24.dp))
            }
        }
    }

    if (!isVisible) {
        Tray(
            icon = BitmapPainter(useResource("icons/umag_logo.ico", ::loadImageBitmap)),
            tooltip = "Umag",
            onAction = { isVisible = true },
            menu = {
                Item("Exit", onClick = ::exitApplication)
            },
        )
    }
}