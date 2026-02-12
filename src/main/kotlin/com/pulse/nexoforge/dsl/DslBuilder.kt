package com.pulse.nexoforge.dsl

/**
 * Base interface for all DSL builders
 */
interface DslBuilder<T> {
    /**
     * @return Built configuration data
     */
    fun build(): T
}


interface SingleDslBuilder : DslBuilder<Map<String, Any>>
interface ListDslBuilder : DslBuilder<List<Map<String, Any>>>
