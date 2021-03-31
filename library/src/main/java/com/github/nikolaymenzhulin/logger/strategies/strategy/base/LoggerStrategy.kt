package com.github.nikolaymenzhulin.logger.strategies.strategy.base

import com.github.nikolaymenzhulin.logger.Logger

/**
 * Base interface of logging strategy for [Logger].
 */
interface LoggerStrategy {

    fun log(priority: Int, message: String, error: Throwable?, vararg args: Any)
}