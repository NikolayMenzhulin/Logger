package com.github.nikolaymenzhulin.logger.strategies

import com.github.nikolaymenzhulin.logger.strategies.strategy.base.LoggerStrategy

/**
 * List of [LoggerStrategy]. In addition to storing strategies,
 * it also contains checking for duplicate strategies when they are added to the list.
 */
class LoggerStrategiesList(
        private val strategies: MutableList<LoggerStrategy> = mutableListOf()
) : MutableList<LoggerStrategy> by strategies {

    override fun add(element: LoggerStrategy): Boolean =
            if (!contains(element)) strategies.add(element) else false

    override fun add(index: Int, element: LoggerStrategy): Unit =
            if (!contains(element)) strategies.add(index, element) else Unit

    override fun addAll(elements: Collection<LoggerStrategy>): Boolean =
            addAllWithFiltration(elements)

    override fun addAll(index: Int, elements: Collection<LoggerStrategy>): Boolean =
            addAllWithFiltration(elements, index)

    override fun contains(element: LoggerStrategy): Boolean =
            strategies.any { strategy -> strategy::class == element::class }

    private fun addAllWithFiltration(elements: Collection<LoggerStrategy>, index: Int? = null): Boolean {
        strategies.apply {
            val filteredElements = elements.filter { !this@LoggerStrategiesList.contains(it) }
            return index?.let { index -> addAll(index, filteredElements) } ?: addAll(filteredElements)
        }
    }
}