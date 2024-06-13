package org.d3if3086.assessment3.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.d3if3086.assessment3.model.ReviewTempat
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://raw.githubusercontent.com/" +
        "indraazimi/mobpro1-compose/static-api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface BaksoApiService {
    @GET("static-api.json")
    suspend fun getApiBakso(): List<ReviewTempat>
}

object BaksoApi {
    val service: BaksoApiService by lazy {
        retrofit.create(BaksoApiService::class.java)
    }

    fun getBaksoUrl(imageId: String): String {
        return "$BASE_URL$imageId.jpg"
    }

    enum class ApiStatus { LOADING, SUCCESS, FAILED }
}