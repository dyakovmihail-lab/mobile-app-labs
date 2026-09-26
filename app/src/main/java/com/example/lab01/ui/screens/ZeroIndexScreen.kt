package com.example.lab01.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab01.domain.ZeroIndexFinder
import com.example.lab01.ui.theme.MyApplicationTheme


@Composable
fun ZeroIndexScreen(modifier: Modifier = Modifier) {

    var input by remember { mutableStateOf("") }
    var output by remember { mutableStateOf("") }

    val finder = ZeroIndexFinder()


    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        OutlinedTextField(
            value = input,
            onValueChange = {
                input = it
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("Введите числа через пробел")
            }
        )


        Button(
            onClick = {

                val numbers = input
                    .split(" ")
                    .filter { it.isNotEmpty() }
                    .map { it.toInt() }


                val result = finder.findZeroIndexes(numbers)


                output = result.toString()

            },
            modifier = Modifier.fillMaxWidth()
        ) {

            Text("Найти индексы нулей")

        }


        OutlinedTextField(
            value = output,
            onValueChange = {},
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("Индексы элементов со значением 0")
            },
            minLines = 2
        )

    }
}


@Preview(showBackground = true)
@Composable
fun ZeroIndexScreenPreview() {

    MyApplicationTheme {

        ZeroIndexScreen()

    }

}