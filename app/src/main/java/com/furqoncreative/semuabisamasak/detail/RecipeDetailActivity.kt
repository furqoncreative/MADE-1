package com.furqoncreative.semuabisamasak.detail

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.dicoding.tourismapp.core.data.Resource
import com.furqoncreative.core.domain.model.recipes.Recipes
import com.furqoncreative.semuabisamasak.R
import com.furqoncreative.semuabisamasak.databinding.ActivityRecipeDetailBinding
import org.koin.android.viewmodel.ext.android.viewModel

class RecipeDetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private val viewModel: RecipeDetailViewModel by viewModel()
    private lateinit var binding: ActivityRecipeDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.ivBack.setOnClickListener {
            onBackPressed()
        }
        setRecipeData()
    }

    fun setRecipeData() {
        val data = intent.getParcelableExtra<Recipes>(EXTRA_DATA)
        if (data != null) {
            data.key?.let {
                viewModel.recipe(it).observe(this) { resource ->
                    if (resource != null) {

                        when (resource) {
                            is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                            is Resource.Success -> {
                                binding.progressBar.visibility = View.GONE
                                val recipe = resource.data
                                if (recipe != null) {
                                    with(binding) {
                                        Glide.with(applicationContext)
                                            .load(recipe.thumb)
                                            .into(ivRecipeThumbnail)
                                        tvRecipeDesc.text = recipe.desc
                                        tvRecipeDificulty.text = recipe.dificulty
                                        tvRecipeName.text = recipe.title
                                        tvRecipeTime.text = recipe.times
                                        tvRecipePortion.text = recipe.servings
                                    }
                                }
                            }
                            is Resource.Error -> {
                                binding.progressBar.visibility = View.GONE
                                binding.viewError.root.visibility = View.VISIBLE
                                binding.viewError.tvError.text =
                                    resource.message ?: getString(R.string.something_wrong)
                                Log.e("TAG", "setRecipesData: ${resource.message}")

                            }
                        }
                    }
                }
            }
        }


    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}