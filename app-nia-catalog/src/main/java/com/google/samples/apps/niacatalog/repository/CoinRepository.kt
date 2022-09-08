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
class CoinRepository @Inject constructor(
    private val coinApi: CoinApi,
    private val coinListResponseDtoMapper: CoinResponseMapper,
) {
    suspend fun getCoinsList(salsCoinsList: String): Result<List<CoinInfoListEntryModel>> =
        try {
            Result.success(
                coinListResponseDtoMapper.toDomainList(
                    coinApi.getCoinsList(
                        salsCoinsList
                    )
                )
            )
        } catch (e: Exception) {
            Result.failure(e)
        }
}