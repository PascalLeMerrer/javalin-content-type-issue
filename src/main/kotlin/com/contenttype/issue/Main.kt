package com.contenttype.issue

import io.javalin.ApiBuilder.get
import io.javalin.Javalin
import io.javalin.LogLevel


fun main(args: Array<String>) {
    val port = 7000

    val app = Javalin.create().apply {
        disableStartupBanner() // remove the javalin startup banner from logs
        enableCorsForOrigin("*") // enables cors for the specified origin(s)
        enableDynamicGzip() // gzip response (if client accepts gzip and response is more than 1500 bytes)
        enableStaticFiles("/public")
        port(port)
        error(404) { ctx -> ctx.json("not found") }
        exception(Exception::class.java) { e, _ -> e.printStackTrace() }
    }.requestLogLevel(LogLevel.EXTENSIVE).start()

    app.routes {
        get("/") { ctx -> ctx.redirect("/index.html") }
    }
}
