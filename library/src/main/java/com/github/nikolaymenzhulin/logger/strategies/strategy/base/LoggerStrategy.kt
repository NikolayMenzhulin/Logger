package com.github.nikolaymenzhulin.logger.strategies.strategy.base

interface LoggerStrategy {

    fun log(priority: Int, message: String, error: Throwable?, vararg args: Any)
}