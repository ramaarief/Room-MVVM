package com.example.roommvvm.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.roommvvm.entity.Student
// Metode untuk mengakses database
@Dao
interface StudentDao {

    // Query untuk menampilkan semua data dari tabel student
    @Query("Select * from student")
    fun getAll(): List<Student>

    // Fungsi yang digunakan untuk insert data ke tabel student
    @Insert
    fun insertStudent(item: Student)
}