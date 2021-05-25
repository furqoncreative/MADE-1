package com.furqoncreative.core.data.source.remote.response.recipedetail

import com.google.gson.annotations.SerializedName

data class RecipeDetail(

	@field:SerializedName("servings")
	val servings: String? = null,

	@field:SerializedName("times")
	val times: String? = null,

	@field:SerializedName("ingredient")
	val ingredient: List<String?>? = null,

	@field:SerializedName("thumb")
	val thumb: String? = null,

	@field:SerializedName("step")
	val step: List<String?>? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("dificulty")
	val dificulty: String? = null,

	@field:SerializedName("desc")
	val desc: String? = null
)