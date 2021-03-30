package com.github.nikolaymenzhulin.logger.strategies.strategy

import com.github.nikolaymenzhulin.logger.Logger
import com.github.nikolaymenzhulin.logger.strategies.strategy.base.LoggerStrategy
import timber.log.Timber

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