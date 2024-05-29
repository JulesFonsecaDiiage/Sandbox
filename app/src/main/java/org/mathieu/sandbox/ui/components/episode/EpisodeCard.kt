package org.mathieu.sandbox.ui.components.episode

import android.content.Context
import android.media.MediaPlayer
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.mathieu.sandbox.R


@Composable
fun EpisodeCard(
    date: String,
    name: String,
    onClick: () -> Unit = { }
) {
    val context: Context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(4.dp)
            .clickable(onClick = {
                if (onClick != { }){
                    launchVibrationAndSound(context)
                    onClick.invoke()
                }
            })
    ) {
        Text(
            text = date,
            modifier = Modifier.padding(8.dp,0.dp,0.dp,0.dp),
        )
        Text(
            text = name,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(8.dp,0.dp,0.dp,0.dp)
        )
    }
}

/**
 * Launches a vibration and a sound.
 * @param context The context to use.
 */
private fun launchVibrationAndSound(context: Context) {
    val vibrator = context.getSystemService(Vibrator::class.java)
    vibrator?.vibrate(
        VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE)
    )

    val soundsList = listOf(
        R.raw.eventsound,
        R.raw.eventsound2,
        R.raw.eventsound3,
        R.raw.eventsound4,
        R.raw.eventsound5
    )
    val mediaPlayer = MediaPlayer.create(context, soundsList.random())
    mediaPlayer.start()
}

@Preview
@Composable
fun Preview() {
    EpisodeCard(
        date = "2021-10-10",
        name = "Episode 1"
    )
}