package eu.luftiger.discordbotkore.database

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource
import com.mysql.cj.jdbc.MysqlDataSource
import java.sql.SQLException
import javax.sql.DataSource

object DataSourceProvider {

    fun initMySQLDataSource(username: String, password: String, host: String, port: String, database: String) : DataSource {
        val dataSource : MysqlDataSource = MysqlConnectionPoolDataSource()
        dataSource.setURL("jdbc:mysql://${username}:${password}@${host}:${port}/${database}")
        testDataSource(dataSource)
        return dataSource
    }

    @Throws(SQLException::class)
    fun testDataSource(dataSource: DataSource) : Boolean{
        val connection = dataSource.connection
        if(!connection.isValid(1000)) throw SQLException("Could not connect to database!")
        return true
    }
}