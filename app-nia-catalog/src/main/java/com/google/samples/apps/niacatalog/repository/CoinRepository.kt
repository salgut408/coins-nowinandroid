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
import com.google.samples.apps.niacatalog.data.responsemodels.ResponseMapper
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class CoinRepository @Inject constructor (
    private val coinApi: CoinApi,
    private val coinListResponseDtoMapper: ResponseMapper,
    ) {

    suspend fun getCoinsList(): List<CoinInfoListEntryModel>{
        val result = try {
            coinApi.getCoinsList("solana,bitcoin,dogecoin,shitcoin,mex,astronaut")
        } catch (e: Exception) {
            Log.i("tag", e.message.toString())
            return listOf(CoinInfoListEntryModel("Returned error ", "Error", "error fromapi","no", 12.3,))
        }
        return coinListResponseDtoMapper.toDomainList2(result)
    }

    suspend fun getSampleCoinList(): List<CoinInfoListEntryModel> {
        return listOf(
            CoinInfoListEntryModel(
                currentPrice = 12.4,
                id = "id",
                image = "image",
                lastUpdated = null,

                name = "sample",
                priceChange24h = null,
                priceChangePercentage24h = null,
                roi = null,
                symbol = "sym"
            )
        )
    }


}