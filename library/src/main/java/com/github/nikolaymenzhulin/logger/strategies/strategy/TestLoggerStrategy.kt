package com.github.nikolaymenzhulin.logger.strategies.strategy

import android.util.Log.ERROR
import com.github.nikolaymenzhulin.logger.strategies.strategy.base.LoggerStrategy
import java.io.PrintStream

/**
 * [LoggerStrategy] using [PrintStream] for logging.
 * It is supposed to be used in testing.
 */
class TestLoggerStrategy : LoggerStrategy {

    override fun log(priority: Int, message: String, error: Throwable?, vararg args: Any) {
        val logStream: PrintStream = if (priority < ERROR) System.out else System.err
        logStream.println(message.formatMessageIfNeed(*args))
        error?.let { logStream.println(error.stackTraceToString()) }
    }

    private fun String.formatMessageIfNeed(vararg args: Any): String =
            if (args.isNotEmpty()) String.format(this, *args) else this
}