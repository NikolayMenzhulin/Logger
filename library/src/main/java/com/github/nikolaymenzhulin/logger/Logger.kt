/*
  Copyright © 2021 Nikolay Menzhulin.

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/
package com.github.nikolaymenzhulin.logger

import android.util.Log.*
import com.github.nikolaymenzhulin.logger.Logger.strategies
import com.github.nikolaymenzhulin.logger.strategies.LoggerStrategiesList
import com.github.nikolaymenzhulin.logger.strategies.strategy.base.LoggerStrategy

/**
 * Object for logging which supports different priorities and strategies.
 *
 * @property strategies list of different [LoggerStrategy] implementations which will be used for logging
 */
object Logger {

    val strategies: LoggerStrategiesList = LoggerStrategiesList()

    /**
     * Log a [VERBOSE] message with optional args.
     *
     * @param message log message
     * @param args optional message args
     */
    fun v(message: String, vararg args: Any) {
        log(priority = VERBOSE, message = message, args = args)
    }

    /**
     * Log a [VERBOSE] message with optional args and error stacktrace.
     *
     * @param message log message
     * @param args optional message args
     * @param error error for logging
     */
    fun v(error: Throwable?, message: String, vararg args: Any) {
        log(priority = VERBOSE, message = message, error = error, args = args)
    }

    /**
     * Log a [DEBUG] message with optional args.
     *
     * @param message log message
     * @param args optional message args
     */
    fun d(message: String, vararg args: Any) {
        log(priority = DEBUG, message = message, args = args)
    }

    /**
     * Log a [DEBUG] message with optional args and error stacktrace.
     *
     * @param message log message
     * @param args optional message args
     * @param error error for logging
     */
    fun d(error: Throwable?, message: String, vararg args: Any) {
        log(priority = DEBUG, message = message, error = error, args = args)
    }

    /**
     * Log a [INFO] message with optional args.
     *
     * @param message log message
     * @param args optional message args
     */
    fun i(message: String, vararg args: Any) {
        log(priority = INFO, message = message, args = args)
    }

    /**
     * Log a [INFO] message with optional args and error stacktrace.
     *
     * @param message log message
     * @param args optional message args
     * @param error error for logging
     */
    fun i(error: Throwable?, message: String, vararg args: Any) {
        log(priority = INFO, message = message, error = error, args = args)
    }

    /**
     * Log a [WARN] message with optional args.
     *
     * @param message log message
     * @param args optional message args
     */
    fun w(message: String, vararg args: Any) {
        log(priority = WARN, message = message, args = args)
    }

    /**
     * Log a [WARN] message with optional args and error stacktrace.
     *
     * @param message log message
     * @param args optional message args
     * @param error error for logging
     */
    fun w(error: Throwable?, message: String, vararg args: Any) {
        log(priority = WARN, message = message, error = error, args = args)
    }

    /**
     * Log a [WARN] with error stacktrace.
     *
     * @param error error for logging
     */
    fun w(error: Throwable?) {
        log(priority = WARN, error = error)
    }

    /**
     * Log a [ERROR] message with optional args.
     *
     * @param message log message
     * @param args optional message args
     */
    fun e(message: String, vararg args: Any) {
        log(priority = ERROR, message = message, args = args)
    }

    /**
     * Log a [ERROR] message with optional args and error stacktrace.
     *
     * @param message log message
     * @param args optional message args
     * @param error error for logging
     */
    fun e(error: Throwable?, message: String, vararg args: Any) {
        log(priority = ERROR, message = message, error = error, args = args)
    }

    /**
     * Log a [ERROR] with error stacktrace.
     *
     * @param error error for logging
     */
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