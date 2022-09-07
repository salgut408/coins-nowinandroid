/*
 * Copyright 2022 The Android Open Source Project
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.google.samples.apps.niacatalog.ui.coinlist

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.samples.apps.niacatalog.data.models.CoinInfoListEntryModel
import com.google.samples.apps.niacatalog.repository.CoinRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val repository: CoinRepository
) : ViewModel() {
    var coinList = mutableStateOf<List<CoinInfoListEntryModel>>(listOf())
    var fakeCoinList = mutableStateOf<List<CoinInfoListEntryModel>>(listOf())
    var loadError = mutableStateOf("")
    var isLoading = mutableStateOf(false)
    var shouldBeDisplayed = mutableStateOf(false)

    init {
        loadCoinsList()
    }

    fun loadCoinsList() = viewModelScope.launch {
        val result = repository.getCoinsList()
        coinList.value = result
    }

    fun loadSampleList() {
        viewModelScope.launch {
            val result = repository.getSampleCoinList()
            fakeCoinList.value = result
        }
    }
}