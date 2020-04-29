package com.example.roommvvm.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
//konfigurasi database dengan satu entitas
@Entity
data class Student (
    // Menentukan primary key dan autoGenerate (auto increment) pada variabel id
    @PrimaryKey(autoGenerate = true) var id: Int? = null,

    // Menentukan tipe data string pada variabel name
    @ColumnInfo var name: String = ""
)