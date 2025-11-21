package com.example.myimmo2.ui.location

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myimmo2.data.model.City
import com.example.myimmo2.data.model.Neighborhood
import com.example.myimmo2.data.model.Region
import com.example.myimmo2.data.repository.LocationRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LocationViewModel : ViewModel() {

    private val locationRepository = LocationRepository()

    private val _regions = MutableStateFlow<List<Region>>(emptyList())
    val regions = _regions.asStateFlow()

    private val _cities = MutableStateFlow<List<City>>(emptyList())
    val cities = _cities.asStateFlow()

    private val _neighborhoods = MutableStateFlow<List<Neighborhood>>(emptyList())
    val neighborhoods = _neighborhoods.asStateFlow()

    private val _selectedRegion = MutableStateFlow<Region?>(null)
    val selectedRegion = _selectedRegion.asStateFlow()

    private val _selectedCity = MutableStateFlow<City?>(null)
    val selectedCity = _selectedCity.asStateFlow()

    init {
        loadRegions()
    }

    private fun loadRegions() {
        viewModelScope.launch {
            try {
                _regions.value = locationRepository.getRegions()
            } catch (e: Exception) {
                // Handle error
            }
        }
    }

    fun onRegionSelected(region: Region) {
        _selectedRegion.value = region
        loadCities(region.id)
    }

    private fun loadCities(regionId: String) {
        viewModelScope.launch {
            try {
                _cities.value = locationRepository.getCities(regionId)
            } catch (e: Exception) {
                // Handle error
            }
        }
    }

    fun onCitySelected(city: City) {
        _selectedCity.value = city
        loadNeighborhoods(city.id)
    }

    private fun loadNeighborhoods(cityId: String) {
        viewModelScope.launch {
            try {
                _neighborhoods.value = locationRepository.getNeighborhoods(cityId)
            } catch (e: Exception) {
                // Handle error
            }
        }
    }

    fun addCity(cityName: String, regionId: String) {
        viewModelScope.launch {
            try {
                locationRepository.addCity(cityName, regionId)
                loadCities(regionId) // Refresh the list
            } catch (e: Exception) {
                // Handle error
            }
        }
    }

    fun addNeighborhood(neighborhoodName: String, cityId: String) {
        viewModelScope.launch {
            try {
                locationRepository.addNeighborhood(neighborhoodName, cityId)
                loadNeighborhoods(cityId) // Refresh the list
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}
