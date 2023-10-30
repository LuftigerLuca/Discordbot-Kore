package eu.luftiger.discordbotkore.configuration

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.registerKotlinModule

abstract class ConfigurationHandler {

    private val objectMapper = ObjectMapper(YAMLFactory()).registerKotlinModule()
    abstract fun loadConfiguration() : Unit
}