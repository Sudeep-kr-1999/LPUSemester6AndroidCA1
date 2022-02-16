package sudeep.example.semester6ca1

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast

class ConfirmationPage : AppCompatActivity() {
    lateinit var nameConfirm: TextView
    lateinit var registrationConfirm: TextView
    lateinit var parentSectionConfirm: TextView
    lateinit var sectionConfirm: TextView
    lateinit var rollnumberConfirm: TextView
    lateinit var feedbackConfirm: TextView
    lateinit var name: String;
    lateinit var registrationNumber: String;
    lateinit var parentSection: String;
    lateinit var section: String;
    lateinit var rollNumber: String;
    lateinit var feedback: String;
    lateinit var courseRating: RatingBar;
    lateinit var submitRating: Button;
    var jobScheduler: JobScheduler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation_page)
        nameConfirm = findViewById(R.id.name_confirm);
        registrationConfirm = findViewById(R.id.registration_confirm);
        parentSectionConfirm = findViewById(R.id.parentSection_confirm);
        sectionConfirm = findViewById(R.id.SectionConfirm);
        rollnumberConfirm = findViewById(R.id.RollNumber_confirm);
        feedbackConfirm = findViewById(R.id.feedback_confirm);
        courseRating = findViewById(R.id.courseRating);
        submitRating = findViewById(R.id.btnRatingSubmit);

        val intentBundle: Bundle? = intent.extras;
        name = intentBundle?.get("Name").toString();
        registrationNumber = intentBundle?.get("RegistrationNumber").toString();
        parentSection = intentBundle?.get("ParentSection").toString();
        section = intentBundle?.get("Section").toString();
        rollNumber = intentBundle?.get("RollNumber").toString();
        feedback = intentBundle?.get("Feedback").toString();
        nameConfirm.text = name;
        registrationConfirm.text = registrationNumber;
        parentSectionConfirm.text = parentSection;
        sectionConfirm.text = section;
        rollnumberConfirm.text = rollNumber;
        feedbackConfirm.text = feedback;

        submitRating.setOnClickListener {
            val totalStars = courseRating.numStars;
            val rating = courseRating.rating;
            Toast.makeText(this, "Rating captured ${rating}/${totalStars}", Toast.LENGTH_LONG)
                .show();
            jobScheduler = getSystemService(JOB_SCHEDULER_SERVICE) as JobScheduler
            val componentName = ComponentName(this, MyJobService::class.java)
            val builder = JobInfo.Builder(123, componentName);
            builder.setMinimumLatency(1000)
            builder.setOverrideDeadline(3000)
            builder.setPersisted(true)
            builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
            builder.setRequiresCharging(false)
            jobScheduler!!.schedule(builder.build())
        }
    }
}