package br.com.brasgan.pokermao.view.list

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import br.com.brasgan.pokermao.R
import br.com.brasgan.pokermao.model.Pokemon
import br.com.brasgan.pokermao.repository.PokemonRepository
import kotlinx.android.synthetic.main.include_loading.*
import org.koin.android.viewmodel.ext.android.viewModel

class ListPokemonsViewModel (val pokemonRepository: PokemonRepository) : ViewModel() {
 val messageError: MutableLiveData<String> = MutableLiveData()
 val pokemons: MutableLiveData<List<Pokemon>> = MutableLiveData()
 val isLoading: MutableLiveData<Boolean> = MutableLiveData()
 fun getPokemons() {
 isLoading.value = true
 pokemonRepository.getPokemons(
 150, "number,asc", {
 pokemons.value = it
 messageError.value = ""
 isLoading.value = false
 }, {
 pokemons.value = emptyList()
 messageError.value = it?.message
 isLoading.value = false
 }
 )
 }
}