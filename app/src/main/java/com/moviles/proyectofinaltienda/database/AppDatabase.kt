package com.moviles.proyectofinaltienda.database

import androidx.room.Database
import androidx.room.RoomDatabase

const val  DATABASE_VERSION=1
const val TABLE_ARTICLES ="articulos"
const val DATABASE_NAME = "appdatabase.sqlite"
@Database(entities = [ArticleEntity::class],
    version = DATABASE_VERSION

)
abstract class AppDatabase: RoomDatabase() {
    abstract fun articleDao(): ArticleDao
}