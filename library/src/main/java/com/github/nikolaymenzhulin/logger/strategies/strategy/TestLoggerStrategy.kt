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