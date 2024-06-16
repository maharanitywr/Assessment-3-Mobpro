package org.d3if3086.assessment3.model

data class Review(
    val review_id: Int,
    val user_email: String,
    val nama_tempat: String,
    val rating: String,
    val deskripsi: String,
    val image_id: String,
    val delete_hash: String,
    val created_at: String
)

data class ReviewCreate(
    val user_email: String,
    val nama_tempat: String,
    val deskripsi: String,
    val rating: String,
    val image_id: String,
    val delete_hash: String
)