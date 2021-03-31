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

import com.github.nikolaymenzhulin.logger.Logger
import com.github.nikolaymenzhulin.logger.strategies.strategy.base.LoggerStrategy
import timber.log.Timber

/**
 * [LoggerStrategy] using [Timber] for logging.
 */
class TimberLoggerStrategy : LoggerStrategy {

    init {
        val isDebugTreePlanted: Boolean = Timber.forest().any { tree -> tree::class == Timber.DebugTree::class }
        if (!isDebugTreePlanted) Timber.plant(Timber.DebugTree())
    }

    override fun log(priority: Int, message: String, error: Throwable?, vararg args: Any) {
        Timber.tag(Logger::class.simpleName)
        Timber.log(priority, error, message, *args)
    }
}