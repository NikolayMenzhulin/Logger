package com.github.nikolaymenzhulin.logger

import android.util.Log.*
import com.github.nikolaymenzhulin.logger.strategies.LoggerStrategiesList

object Logger {

    val strategies: LoggerStrategiesList = LoggerStrategiesList()

    fun v(message: String, vararg args: Any) {
        log(priority = VERBOSE, message = message, args = args)
    }

    fun v(error: Throwable?, message: String, vararg args: Any) {
        log(priority = VERBOSE, message = message, error = error, args = args)
    }

    fun d(message: String, vararg args: Any) {
        log(priority = DEBUG, message = message, args = args)
    }

    fun d(error: Throwable?, message: String, vararg args: Any) {
        log(priority = DEBUG, message = message, error = error, args = args)
    }

    fun i(message: String, vararg args: Any) {
        log(priority = INFO, message = message, args = args)
    }

    fun i(error: Throwable?, message: String, vararg args: Any) {
        log(priority = INFO, message = message, error = error, args = args)
    }

    fun w(message: String, vararg args: Any) {
        log(priority = WARN, message = message, args = args)
    }

    fun w(error: Throwable?, message: String, vararg args: Any) {
        log(priority = WARN, message = message, error = error, args = args)
    }

    fun w(error: Throwable?) {
        log(priority = WARN, error = error)
    }

    fun e(message: String, vararg args: Any) {
        log(priority = ERROR, message = message, args = args)
    }

    fun e(error: Throwable?, message: String, vararg args: Any) {
        log(priority = ERROR, message = message, error = error, args = args)
    }

    fun e(error: Throwable?) {
        log(priority = ERROR, error = error)
    }

    private fun log(priority: Int, message: String = "", error: Throwable? = null, vararg args: Any) {
        if (strategies.isEmpty()) {
            throw IllegalStateException("No one LoggerStrategy have been added for Logger")
        }
        strategies.forEach { strategy -> strategy.log(priority, message, error, *args) }
    }
}