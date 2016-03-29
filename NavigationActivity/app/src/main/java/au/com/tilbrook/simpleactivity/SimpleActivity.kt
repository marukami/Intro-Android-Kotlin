package au.com.tilbrook.simpleactivity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.content_simple.*

class SimpleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple)
        val toolbar = findViewById(R.id.toolbar) as Toolbar?
        setSupportActionBar(toolbar)

        extraText.text = intent.extras.getString(EXTRA_STRING)

        closeBtn.setOnClickListener { view ->
            finish()
        }
    }

}
