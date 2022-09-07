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

package com.google.samples.apps.niacatalog.data.responsemodels

import com.google.samples.apps.niacatalog.data.models.CoinInfoListEntryModel
import com.google.samples.apps.niacatalog.data.remote.DomainMapper
import retrofit2.Response

class CoinResponseMapper: DomainMapper<Coin, CoinInfoListEntryModel> {
    override fun mapToDomainModel(model: Coin): CoinInfoListEntryModel {
        return CoinInfoListEntryModel(
            id = model.id,
            name = model.name,
            symbol = model.symbol,
            currentPrice = model.currentPrice,
            image = model.image,
            lastUpdated = model.lastUpdated,
            marketCap = model.marketCap,
            priceChangePercentage24h = model.priceChangePercentage24h,
            priceChange24h = model.priceChange24h,
            roi = model.roi

        )
    }

    fun toDomainList(initial: Response<List<Coin>>): List<CoinInfoListEntryModel> {
        return initial.body()?.map { mapToDomainModel(it) } ?: listOf()
    }


}