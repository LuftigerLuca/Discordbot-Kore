package eu.luftiger.discordbotkore.database

import java.util.logging.Logger
import javax.sql.DataSource

object DatabaseSetup {

    fun initDatabase(logger: Logger, dataSource: DataSource) : Boolean{
        var setup : String? = null

        val inputStream = this.javaClass.classLoader.getResourceAsStream("setup.sql")
        if (inputStream != null) {
            setup = String(inputStream.readAllBytes())
        }
        if(setup == null) return false

        val queries = setup.split(";")
        val connection = dataSource.connection
        connection.autoCommit = false

        for (query in queries) {
            if(query.isBlank()) continue
            val statement = connection.prepareStatement(query)
            statement.execute()
        }
        connection.commit()

        return true
    }
}