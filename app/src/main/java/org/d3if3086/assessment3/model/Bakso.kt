package org.d3if3086.assessment3.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bakso")
data class Bakso(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val nama: String,
    val alamat: String,
    val review: String,
    val tanggal: String
)
