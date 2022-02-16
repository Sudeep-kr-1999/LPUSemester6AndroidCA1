package sudeep.example.semester6ca1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import androidx.core.widget.addTextChangedListener

class HomeScreen : AppCompatActivity() {
    lateinit var name: EditText;
    lateinit var registrationNumber: EditText
    lateinit var parentSection: EditText
    lateinit var section: EditText
    lateinit var rollNumber: EditText
    lateinit var feedback: EditText
    lateinit var feedbackProgress: ProgressBar
    lateinit var submitBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)
        name = findViewById(R.id.name)
        registrationNumber = findViewById(R.id.registrationNumber)
        parentSection = findViewById(R.id.parentSection)
        section = findViewById(R.id.section)
        rollNumber = findViewById(R.id.rollNumber)
        feedback = findViewById(R.id.feedback)
        feedbackProgress = findViewById(R.id.feedbackProgress)
        submitBtn = findViewById(R.id.submitFeedback)


        feedback.addTextChangedListener {
            val i = feedback.length();
            feedbackProgress.progress = i;
        }
        submitBtn.setOnClickListener {
            val enteredName = name.text.toString();
            val enteredRegistrationNo = registrationNumber.text.toString();
            val enteredParentSection = parentSection.text.toString();
            val enteredSection = section.text.toString();
            val enteredRollNumber = rollNumber.text.toString();
            val enteredFeedback = feedback.text.toString();
            val i = Intent(this, ConfirmationPage::class.java);
            i.putExtra("Name", enteredName);
            i.putExtra("RegistrationNumber", enteredRegistrationNo);
            i.putExtra("ParentSection", enteredParentSection);
            i.putExtra("Section", enteredSection);
            i.putExtra("RollNumber", enteredRollNumber);
            i.putExtra("Feedback", enteredFeedback);
            startActivity(i);
        }


    }
}