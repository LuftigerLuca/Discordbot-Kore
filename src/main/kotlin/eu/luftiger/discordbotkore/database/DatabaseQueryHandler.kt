package eu.luftiger.discordbotkore.database

import javax.sql.DataSource

abstract class DatabaseQueryHandler(dataSource: DataSource) {
    private val connection = dataSource.connection
}