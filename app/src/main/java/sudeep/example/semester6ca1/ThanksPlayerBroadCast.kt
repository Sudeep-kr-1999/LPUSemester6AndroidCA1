package sudeep.example.semester6ca1

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import kotlin.system.exitProcess

class ThanksPlayerBroadCast:BroadcastReceiver() {
    override fun onReceive(context:Context, intent: Intent) {
        val mp=MediaPlayer.create(context,R.raw.audio);
        mp.start();
    }
}