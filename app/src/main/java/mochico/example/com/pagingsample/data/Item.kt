package mochico.example.com.pagingsample.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Item (@PrimaryKey(autoGenerate = true) val id: Int, val name: String)