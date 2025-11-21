package com.example.myimmo2.ui.location

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LocationScreen(locationViewModel: LocationViewModel = viewModel()) {

    val regions by locationViewModel.regions.collectAsState()
    val cities by locationViewModel.cities.collectAsState()
    val neighborhoods by locationViewModel.neighborhoods.collectAsState()

    var regionExpanded by remember { mutableStateOf(false) }
    var cityExpanded by remember { mutableStateOf(false) }
    var neighborhoodExpanded by remember { mutableStateOf(false) }

    var selectedRegionText by remember { mutableStateOf("") }
    var selectedCityText by remember { mutableStateOf("") }
    var selectedNeighborhoodText by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        // Region Dropdown
        ExposedDropdownMenuBox(
            expanded = regionExpanded,
            onExpandedChange = { regionExpanded = !regionExpanded }
        ) {
            OutlinedTextField(
                value = selectedRegionText,
                onValueChange = { },
                readOnly = true,
                label = { Text("Region") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = regionExpanded) },
                modifier = Modifier.menuAnchor()
            )
            ExposedDropdownMenu(
                expanded = regionExpanded,
                onDismissRequest = { regionExpanded = false }
            ) {
                regions.forEach { region ->
                    DropdownMenuItem(
                        text = { Text(region.name) },
                        onClick = {
                            selectedRegionText = region.name
                            locationViewModel.onRegionSelected(region)
                            regionExpanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // City Dropdown
        ExposedDropdownMenuBox(
            expanded = cityExpanded,
            onExpandedChange = { cityExpanded = !cityExpanded }
        ) {
            OutlinedTextField(
                value = selectedCityText,
                onValueChange = { },
                readOnly = true,
                label = { Text("City") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = cityExpanded) },
                modifier = Modifier.menuAnchor()
            )
            ExposedDropdownMenu(
                expanded = cityExpanded,
                onDismissRequest = { cityExpanded = false }
            ) {
                cities.forEach { city ->
                    DropdownMenuItem(
                        text = { Text(city.name) },
                        onClick = {
                            selectedCityText = city.name
                            locationViewModel.onCitySelected(city)
                            cityExpanded = false
                        }
                    )
                }
            }
        }
        
        Spacer(modifier = Modifier.height(8.dp))

        // Neighborhood Dropdown
        ExposedDropdownMenuBox(
            expanded = neighborhoodExpanded,
            onExpandedChange = { neighborhoodExpanded = !neighborhoodExpanded }
        ) {
            OutlinedTextField(
                value = selectedNeighborhoodText,
                onValueChange = { },
                readOnly = true,
                label = { Text("Neighborhood") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = neighborhoodExpanded) },
                modifier = Modifier.menuAnchor()
            )
            ExposedDropdownMenu(
                expanded = neighborhoodExpanded,
                onDismissRequest = { neighborhoodExpanded = false }
            ) {
                neighborhoods.forEach { neighborhood ->
                    DropdownMenuItem(
                        text = { Text(neighborhood.name) },
                        onClick = {
                            selectedNeighborhoodText = neighborhood.name
                            neighborhoodExpanded = false
                        }
                    )
                }
            }
        }
    }
}
