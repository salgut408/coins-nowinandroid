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

package com.google.samples.apps.niacatalog.repository

import android.util.Log
import com.google.samples.apps.niacatalog.data.models.CoinInfoListEntryModel
import com.google.samples.apps.niacatalog.data.remote.CoinApi
import com.google.samples.apps.niacatalog.data.responsemodels.CoinResponseMapper
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class CoinRepository @Inject constructor (
    private val coinApi: CoinApi,
    private val coinListResponseDtoMapper: CoinResponseMapper,
    ) {

    suspend fun getCoinsList(): List<CoinInfoListEntryModel>{
        val result = try {
            coinApi.getCoinsList("bitcoin")
        } catch (e: Exception) {
            Log.i("tag", e.message.toString())
            return listOf(CoinInfoListEntryModel("Returned error ", "Error", "error fromapi","no", ))
        }
        return coinListResponseDtoMapper.toDomainList(result)
    }

    suspend fun getCoinsList2(salsCoinsList: String): Result<List<CoinInfoListEntryModel>> {
        return Result.success(coinListResponseDtoMapper.toDomainList(coinApi.getCoinsList(salsCoinsList)))
            .onSuccess {}
            .onFailure { return Result.failure(it) }
    }
}