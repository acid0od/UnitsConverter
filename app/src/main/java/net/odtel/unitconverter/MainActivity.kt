package net.odtel.unitconverter

import android.health.connect.datatypes.units.Temperature
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import net.odtel.unitconverter.ui.theme.UnitConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RunningConverter(modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}

@Composable
fun RunningConverter(modifier: Modifier = Modifier) {
    var unitsSwitch by remember { mutableStateOf(true) }
    var temperatureValue by remember { mutableStateOf("0") }
    val temperatureConverted = convertTemperature(temperatureValue, unitsSwitch)
//    UnitConverterLayout(modifier = modifier,
//        unitsSwitch = unitsSwitch,
//        onSwitchChange = { unitsSwitch = it },
//        temperatureValue = temperatureValue,
//        temperatureChanged = { temperatureValue = it },
//        temperatureConverted = temperatureConverted,
//        onConverterClick = {  })

    LengthLayout(modifier = modifier, lengthValue = temperatureValue, onLengthChange = { temperatureValue = it })
}


fun convertTemperature(value: String, isMetric: Boolean): String {
    if (value.isEmpty()) return ""

    return if (isMetric) {
        ((value.toDouble() - 32) * 5 / 9).toString()
    } else {
        (value.toDouble() * 9 / 5 + 32).toString()
    }
}