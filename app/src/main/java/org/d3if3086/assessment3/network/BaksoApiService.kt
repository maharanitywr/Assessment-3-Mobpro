package org.d3if3086.assessment3.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.d3if3086.assessment3.model.MessageResponse
import org.d3if3086.assessment3.model.Review
import org.d3if3086.assessment3.model.ReviewCreate
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

private const val BASE_URL = "https://baso-review.vercel.app/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface BaksoApiService {
    @POST("reviews/")
    suspend fun addData(
        @Body data: ReviewCreate
    ): MessageResponse

    @GET("reviews/")
    suspend fun getAllData(
        @Query("email") email: String,
    ): List<Review>

    @DELETE("reviews/{review_id}")
    suspend fun deleteData(
        @Path("review_id") id: Int,
        @Query("email") email: String
    ): MessageResponse
}

object BaksoApi {
    val service: BaksoApiService by lazy {
        retrofit.create(BaksoApiService::class.java)
    }
}

enum class ApiStatus { LOADING, SUCCESS, FAILED }