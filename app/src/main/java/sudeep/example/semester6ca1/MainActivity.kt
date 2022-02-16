package sudeep.example.semester6ca1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ProgressBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val progressBar=findViewById<ProgressBar>(R.id.progressBar);

        progressBar.visibility= View.VISIBLE;
//        it worked like set timeout
        Handler(Looper.getMainLooper()).postDelayed({
            progressBar.visibility=View.INVISIBLE;
            val i=Intent(this,HomeScreen::class.java)
            startActivity(i);
            finish();
        },5000);
    }
}