package kotli.common.data.source.database.sqldelight

import app.cash.sqldelight.async.coroutines.awaitAsList
import app.cash.sqldelight.async.coroutines.awaitAsOne
import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.db.SqlDriver
import kotli.common.data.source.database.DatabaseSource
import kotli.common.data.source.database.model.User
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.shareIn
import kotli.common.data.source.database.sqldelight.entity.User as UserEntity

/**
 * This class represents a source for accessing the SqlDelight database.
 *
 * It provides access to all underlying DAO objects as well.
 */
class SqlDelightSource(
    private val sqlDriver: SqlDriver
) : DatabaseSource {

    private val db = flow {
        SqlDelightDb.Schema.create(sqlDriver).await()
        val database = SqlDelightDb.invoke(sqlDriver)
        emit(database)
    }.shareIn(GlobalScope, SharingStarted.Lazily, 1)

    override suspend fun getUsersLive(): Flow<List<User>> {
        val db = db.first()
        return db.userQueries.getAll().asFlow()
            .map { query -> query.awaitAsList() }
            .map { all -> all.map(::map) }
    }

    override suspend fun getUsers(limit: Int, offset: Int): List<User> {
        val db = db.first()
        val users = db.userQueries.getAllPaginated(limit.toLong(), offset.toLong()).awaitAsList()
        return users.map(::map)
    }

    override suspend fun insertUser(firstName: String, lastName: String) {
        val db = db.first()
        db.userQueries.insert(firstName, lastName)
    }

    override suspend fun deleteUser(id: Long) {
        val db = db.first()
        db.userQueries.delete(id)
    }

    override suspend fun getUsersCount(): Long {
        val db = db.first()
        return db.userQueries.count().awaitAsOne()
    }

    override suspend fun inTx(block: suspend () -> Unit) {
        db.first().transaction { block() }
    }

    private fun map(from: UserEntity): User {
        return User(
            firstName = from.firstName,
            lastName = from.lastName,
            id = from.id
        )
    }
}

