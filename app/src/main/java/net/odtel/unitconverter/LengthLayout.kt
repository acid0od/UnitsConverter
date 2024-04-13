package net.odtel.unitconverter

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties

//import androidx.compose.material3.DropdownMenuItem
//import androidx.compose.material3.ExposedDropdownMenuBox
//import androidx.compose.material3.ExposedDropdownMenuDefaults
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextField
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LengthLayout(
    modifier: Modifier = Modifier,
    lengthValue: String,
    onLengthChange: (String) -> Unit
) {
    val options = listOf(
        "Fathom ftm",
        "Meters m",
        "Feet ft",
        "Yards yd",
        "Miles mi",
        "Kilometers km",
        "Nautical miles nm",
        "Inches in",
        "Centimeters cm",
        "Millimeters mm",
        "Micrometers µm",
        "Nanometers nm",
        "Picometers pm",
        "Femtometers fm",
        "Attometers am",
        "Zeptometers zm",
        "Yoctometers ym",
        "Light years ly",
        "Astronomical units au",
        "Parsecs pc",
        "Kiloparsecs kpc",
        "Megaparsecs Mpc",
        "Gigaparsecs Gpc",
        "Teraparsecs Tpc",
        "Petaparsecs Ppc",
        "Exaparsecs Epc",
        "Zettaparsecs Zpc",
        "Yottaparsecs Ypc",
        "Miles (nautical) nmi",
        "Miles (statute) mi",
        "Miles (US survey) mi",
        "Miles (Roman) mi",
        "Miles (geographical) mi",
        "Miles (international) mi",
        "Miles (land) mi",
        "Miles (statute) mi"
    )
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf(options[0]) }
    val focusManager = LocalFocusManager.current
    Column(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            TextField(
                modifier = Modifier
                    .defaultMinSize(minWidth = 30.dp)
                    .padding(horizontal = 0.dp, vertical = 0.dp),
                value = lengthValue,
                singleLine = true,
                visualTransformation = VisualTransformation.None,
                onValueChange = onLengthChange,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(onDone = {
                    focusManager.clearFocus()
                }),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.1f),
                    unfocusedContainerColor = MaterialTheme.colorScheme.background.copy(alpha = 0.5f),
                    focusedIndicatorColor = Color.Black,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent

                ),
                suffix = {
                    Text(text = "kg")
                }
            )
            docs()

//            val colors = TextFieldDefaults.colors()
//
//            val interactionSource = remember { MutableInteractionSource() }
//            val isPressed: Boolean by interactionSource.collectIsPressedAsState()
//            LaunchedEffect(isPressed){
//                if (isPressed) {
//                    expanded = !expanded
//                }
//            }
//            BasicTextField(
//                value = lengthValue,
//                onValueChange = onLengthChange,
//                textStyle = MaterialTheme.typography.labelMedium,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .background(
//                        color = MaterialTheme.colorScheme.background.copy(alpha = 0.5f),
//                        shape = RoundedCornerShape(8.dp)
//                    ),
//                enabled = true,
//                singleLine = true
//            ) {
//                TextFieldDefaults.DecorationBox(
//                    value = lengthValue,
//                    innerTextField = it,
//                    singleLine = true,
//                    enabled = true,
//                    visualTransformation = VisualTransformation.None,
//                    label = { Text(text = "label") },
//                    trailingIcon = {
//                        IconButton(onClick = { }) {
//                            Icon(imageVector = Icons.Filled.Clear, contentDescription = "Clear")
//                        }
//                    },
//                    placeholder = { /* ... */ },
//                    interactionSource = interactionSource,
//                    // change the start padding
//                    contentPadding = TextFieldDefaults.textFieldWithoutLabelPadding(
//                        start = 4.dp
//                    )
//                )
//            }

//            OutlinedTextField(
//                value = lengthValue,
//                onValueChange = onLengthChange,
//                singleLine = true,
//                keyboardOptions = KeyboardOptions.Default.copy(
//                    keyboardType = KeyboardType.Number,
//                    imeAction = ImeAction.Done
//                ),
//                modifier = Modifier
//                    .padding(6.dp)
//                    .height(30.dp)
//                    .defaultMinSize(minWidth = 80.dp, minHeight = 20.dp)
//            )


// We want to react on tap/press on TextField to show menu
//            ExposedDropdownMenuBox(
//                expanded = expanded,
//                onExpandedChange = { expanded = !expanded },
//            ) {
//                Row(verticalAlignment = Alignment.Bottom) {
//                    TextField(
//                        modifier = Modifier
//                            .padding(horizontal = 2.dp, vertical = 2.dp),
//                        value = selectedOptionText,
//                        singleLine = true,
//                        onValueChange = {},
//                        suffix = {
//                            ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
//                        }
//                    )
////                    Box(modifier = Modifier
////                        .menuAnchor()
////                        .wrapContentSize()
////                        .fillMaxWidth()
////                        .padding(horizontal = 2.dp, vertical = 2.dp),
////                        contentAlignment = Alignment.CenterStart
////                    ) {
////
////                        Text(
////                            text = selectedOptionText,
////                        )
////                    }
////                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
//                }
//                ExposedDropdownMenu(
//                    modifier = Modifier
//                        .padding(8.dp)
//                        .fillMaxWidth(),
//                    expanded = expanded,
//                    onDismissRequest = { expanded = false },
//                ) {
//                    options.forEach { chronoUnit ->
//                        DropdownMenuItem(
//                            text = { Text(text = chronoUnit) },
//                            onClick = {
//                                selectedOptionText = chronoUnit
//                                expanded = false
//                            },
//                            contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
//                        )
//                    }
//                }
//            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun docs() {
    val options =
        listOf(
            "Fathom ftm",
            "Meters m",
            "Feet ft",
            "Yards yd",
            "Miles mi",
            "Kilometers km",
            "Nautical miles nm",
            "Inches in",
            "Centimeters cm",
            "Millimeters mm",
            "Micrometers µm",
            "Nanometers nm",
            "Picometers pm",
            "Femtometers fm",
            "Attometers am",
            "Zeptometers zm",
            "Yoctometers ym",
            "Light years ly",
            "Astronomical units au",
            "Parsecs pc",
            "Kiloparsecs kpc",
            "Megaparsecs Mpc",
            "Gigaparsecs Gpc",
            "Teraparsecs Tpc",
            "Petaparsecs Ppc",
            "Exaparsecs Epc",
            "Zettaparsecs Zpc",
            "Yottaparsecs Ypc",
            "Miles (nautical) nmi",
            "Miles (statute) mi",
            "Miles (US survey) mi",
            "Miles (Roman) mi",
            "Miles (geographical) mi",
            "Miles (international) mi",
            "Miles (land) mi",
            "Miles (statute) mi"
        )
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf("") }
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
    ) {
        TextField(
            // The `menuAnchor` modifier must be passed to the text field for correctness.
            modifier = Modifier
                .menuAnchor()
                .clickable { expanded = true },
            value = selectedOptionText,
            enabled = false,
            readOnly = true,
            onValueChange = { },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            colors = ExposedDropdownMenuDefaults.textFieldColors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                disabledTextColor = MaterialTheme.colorScheme.outline,
                disabledIndicatorColor = Color.Transparent
            ),
        )
        // filter options based on text field value
        val filteringOptions = options.filter { it.contains(selectedOptionText, ignoreCase = true) }

        DropdownMenu(
            modifier = Modifier
                .background(Color.White)
                .exposedDropdownSize(true),
            properties = PopupProperties(focusable = false),
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            options.forEach { selectionOption ->
                DropdownMenuItem(
                    text = { Text(selectionOption) },
                    onClick = {
                        selectedOptionText = selectionOption
                        expanded = false
                    },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                )
            }
        }

    }
}