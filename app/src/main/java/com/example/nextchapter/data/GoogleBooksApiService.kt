package com.example.nextchapter.data

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


    private val BASE_URL = "https://www.googleapis.com/books/v1/volumes"

    private  val API_KEY =

    //retrofit Instance

    private val retrofit: Retrofit =
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build()


    //Api Interface
    //Crete the Api instance
    val googleService: GoogleBooksApiService = retrofit.create(GoogleBooksApiService::class.java)

    interface GoogleBooksApiService {
        @GET("volumes")
        suspend fun searchBooks(
            @Query("q") query: String,
            @Query("key") apiKey: String = API_KEY
        ): BookResponse
    }


