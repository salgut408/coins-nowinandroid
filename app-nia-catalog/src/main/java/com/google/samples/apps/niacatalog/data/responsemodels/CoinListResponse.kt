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

import kotlinx.serialization.SerialName
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

@Serializable
data class CoinListResponse(
    @SerialName("id"                               ) var id                           : String? = null,
    @SerialName("symbol"                           ) var symbol                       : String? = null,
    @SerialName("name"                             ) var name                         : String? = null,
    @SerialName("image"                            ) var image                        : String? = null,
    @SerialName("current_price"                    ) var currentPrice                 : Double? = null,
    @SerialName("market_cap"                       ) var marketCap                    : Float?    = null,
    @SerialName("market_cap_rank"                  ) var marketCapRank                : Int?    = null,
    @SerialName("fully_diluted_valuation"          ) var fullyDilutedValuation        : Float?    = null,
    @SerialName("total_volume"                     ) var totalVolume                  : Float?    = null,
    @SerialName("high_24h"                         ) var high24h                      : Float?    = null,
    @SerialName("low_24h"                          ) var low24h                       : Float? = null,
    @SerialName("price_change_24h"                 ) var priceChange24h               : Float? = null,
    @SerialName("price_change_percentage_24h"      ) var priceChangePercentage24h     : Float? = null,
    @SerialName("market_cap_change_24h"            ) var marketCapChange24h           : Float? = null,
    @SerialName("market_cap_change_percentage_24h" ) var marketCapChangePercentage24h : Float? = null,
    @SerialName("circulating_supply"               ) var circulatingSupply            : Float?    = null,
    @SerialName("total_supply"                     ) var totalSupply                  : Float?    = null,
    @SerialName("max_supply"                       ) var maxSupply                    : Float?    = null,
    @SerialName("ath"                              ) var ath                          : Float?    = null,
    @SerialName("ath_change_percentage"            ) var athChangePercentage          : Float? = null,
    @SerialName("ath_date"                         ) var athDate                      : String? = null,
    @SerialName("atl"                              ) var atl                          : Float? = null,
    @SerialName("atl_change_percentage"            ) var atlChangePercentage          : Float? = null,
    @SerialName("atl_date"                         ) var atlDate                      : String? = null,
    @SerialName("roi"                              ) var roi                          : String? = null,
    @SerialName("last_updated"                     ) var lastUpdated                  : String? = null
) {
}

