package com.example.roommvvm.viewmodel

import android.app.Application
import android.graphics.Movie
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.roommvvm.data.AppDatabase
import com.example.roommvvm.entity.Student
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import timber.log.Timber

// Class yang berisi untuk mengatur data yang disimpan dalam database
class NewStudentViewModel(application: Application) : AndroidViewModel(application) {

    // Inisialisasi AppDatabase dan List data student
    private val mDb: AppDatabase? = AppDatabase.getInstance(application)
    private val allStudent = MutableLiveData<List<Student>>()

    // Fungsi untuk menyimpan data ke database
    fun storeMovie(title: String) {

        val student = Student()
        student.name = title

        // Menjalankan query pada class studentDao
        GlobalScope.launch {
            mDb?.studentDao()?.insertStudent(student)
        }
    }

    // Fungsi untuk mengambil data
    fun retrieveStudent(): LiveData<List<Student>> {

        // Mengambil data dari class studentDao
        GlobalScope.launch {
            val list = mDb?.studentDao()?.getAll()

            // Menampilkan informasi pada Log
            Timber.i("Data yang ada sejumlah {${list?.size}}")
            allStudent.postValue(list)
        }

        // Mengembalikan list data allStudent
        return allStudent
    }
}