package net.odtel.unitconverter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun UnitConverterLayout(
    modifier: Modifier = Modifier,
    unitsSwitch: Boolean,
    onSwitchChange: (Boolean) -> Unit,
    temperatureValue: String,
    temperatureConverted: String,
    temperatureChanged: (String) -> Unit,
    onConverterClick: () -> Unit
) {

    var fromUnitsTemperatureLabel by remember { mutableStateOf("°C") }
    var fromUnitsLengthLabel by remember { mutableStateOf("Inches") }
    var toUnitsTemperatureLabel by remember { mutableStateOf("°C") }
    var toUnitsLengthLabel by remember { mutableStateOf("Inches") }
    var useUnitsConverterLabel by remember { mutableStateOf("From Imperial to Metric") }

    Column {
        if (unitsSwitch) {
            fromUnitsLengthLabel = "Units Inches"
            fromUnitsTemperatureLabel = "Temperature °F"
            toUnitsTemperatureLabel = "°C"
            toUnitsLengthLabel = "Meters"
            useUnitsConverterLabel = "From Imperial to Metric"
        } else {
            fromUnitsLengthLabel = "Units Meters"
            fromUnitsTemperatureLabel = "Temperature °C"

            toUnitsTemperatureLabel = "°F"
            toUnitsLengthLabel = "Feet"
            useUnitsConverterLabel = "From Metric to Imperial"
        }
        EditTextWithResult(
            value = temperatureValue,
            label = fromUnitsTemperatureLabel,
            onValueChanged = temperatureChanged,
            unitsLabel = toUnitsTemperatureLabel,
            convertedValue = temperatureConverted
        )
        EditTextWithResult(
            value = "0",
            label = fromUnitsLengthLabel,
            onValueChanged = { /*TODO*/ },
            unitsLabel = toUnitsLengthLabel
        )
        Spacer(modifier = Modifier.height(12.dp))
        Row(modifier = Modifier.padding(8.dp)) {
            Text(text = useUnitsConverterLabel, modifier = Modifier.padding(8.dp))
            Switch(
                checked = unitsSwitch,
                onCheckedChange = onSwitchChange,
                colors = SwitchDefaults.colors(
                    uncheckedThumbColor = Color.Cyan,
                    uncheckedTrackColor = Color.Cyan,
                    uncheckedBorderColor = Color.Transparent
                ),
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.End)
            )
        }

    }
}


@Composable
fun EditTextWithResult(
    modifier: Modifier = Modifier,
    value: String,
    label: String,
    unitsLabel: String,
    onValueChanged: (String) -> Unit,
    convertedValue: String = "0"
) {

    Column(modifier.padding(8.dp)) {
        OutlinedTextField(
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_tet_24),
                    contentDescription = null
                )
            },
            value = value,
            singleLine = true,
            onValueChange = onValueChanged,
            modifier = modifier
                .padding(8.dp)
                .fillMaxWidth(),
            label = { Text(label) },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            )
        )
        Text(
            text = "$convertedValue $unitsLabel", modifier = modifier
                .padding(8.dp)
                .align(Alignment.CenterHorizontally), fontSize = 24.sp, fontWeight = FontWeight.Bold
        )
    }

}


