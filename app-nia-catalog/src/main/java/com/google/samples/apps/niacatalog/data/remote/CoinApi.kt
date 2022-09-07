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

package com.google.samples.apps.niacatalog.data.remote

import com.google.samples.apps.niacatalog.data.responsemodels.CoinListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CoinApi {



    @GET("coins/markets")
    suspend fun getCoinsList(
        @Query("ids")
        id: String? = null,
        @Query("vs_currency")
        vs_currency: String? = "usd",
        @Query("order")
        order: String? = "market_cap_desc",
        @Query("per_page")
        per_page:Int? = 100,
        @Query("page")
        page: Int? = 1,
        @Query("sparkline")
        sparkline: Boolean = false

    ): Response<List<CoinListResponse>>


}