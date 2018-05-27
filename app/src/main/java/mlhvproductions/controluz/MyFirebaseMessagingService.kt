package mlhvproductions.controluz

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.support.v4.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import org.json.JSONException

class MyFirebaseMessagingService : FirebaseMessagingService() {

    internal var intent: Intent? = null
    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        send(remoteMessage)
    }

    @Throws(JSONException::class)
    internal fun send(remoteMessage: RemoteMessage?) {
        intent = Intent(this, MainActivity::class.java)
        intent!!.putExtra("title", remoteMessage!!.notification!!.title)
        intent!!.putExtra("body", remoteMessage.notification!!.body)
        val inboxStyle = NotificationCompat.InboxStyle()
        val uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        intent!!.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT)
        val notificationBuilder = NotificationCompat.Builder(this)
        notificationBuilder.setSmallIcon(R.mipmap.ic_launcher)
        notificationBuilder.setSound(uri)
        notificationBuilder.setStyle(inboxStyle)
        notificationBuilder.setContentText(remoteMessage.notification!!.body)
        notificationBuilder.setContentTitle(remoteMessage.notification!!.title)
        notificationBuilder.setAutoCancel(true)
        notificationBuilder.setContentIntent(pendingIntent)
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(System.currentTimeMillis().toInt(), notificationBuilder.build())
    }
}