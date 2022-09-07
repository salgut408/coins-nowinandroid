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

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest.Builder
import com.google.samples.apps.niacatalog.R

import com.google.samples.apps.niacatalog.data.models.CoinInfoListEntryModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomCoinItem(coin: CoinInfoListEntryModel) {

    Spacer(modifier = Modifier.width(16.dp))

    Card(
        modifier = Modifier
            .padding(vertical = 4.dp, horizontal = 8.dp)
            .shadow(5.dp, RoundedCornerShape(10.dp))
            .clip(RoundedCornerShape(10.dp))
    ) {
        Row(
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxWidth()
                .padding(16.dp),


            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column() {
                val painter = rememberAsyncImagePainter(
                    model = Builder(LocalContext.current)
                        .data(coin.image)
                        .size(50)

                        .build()
                )
                if (painter.state is AsyncImagePainter.State.Success) {

                }
                Image(
                    painter = painter,
                    contentDescription = coin.name,
                    modifier = Modifier
                        .size(50.dp)

                )

            }
            Column(modifier = Modifier.align(Alignment.CenterVertically)) {
                Text(
                    modifier = Modifier.background(Color.White),
                    text = "${coin.name}",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodyLarge

                    )
                Text(
                    modifier = Modifier.background(Color.White),
                    text = "${coin.symbol}",
                    color = Color.Black,
                    style = MaterialTheme.typography.bodySmall


                )
            }
//            Column() {
//                Text(
//                    text = "${coin.symbol}",
//                    color = Color.Black,
//                )
//            }

            Column() {
                Text(
                    text = stringResource(R.string.dollar_sign) +"${coin.currentPrice}",
                    color = Color.Black,

                )
            }

        }
    }


}