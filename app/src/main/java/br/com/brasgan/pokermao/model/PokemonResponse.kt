package br.com.brasgan.pokermao.model

import okhttp3.Call
import retrofit2.http.GET
import retrofit2.http.Query

data class PokemonResponse(
 val content: List<Pokemon>
)
