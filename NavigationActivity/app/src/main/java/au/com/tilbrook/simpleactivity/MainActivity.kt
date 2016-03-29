package au.com.tilbrook.simpleactivity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

const val EXTRA_STRING = "SIMPLE_EXTRA_STRING"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//         val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

//        val tab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null)
                    .show()
        }

//        val showSnackEcho = findViewById(R.id.showSnackEcho) as Button
        showSnackEcho.setOnClickListener { view ->
            Snackbar.make(view, echoText.text.toString(), Snackbar.LENGTH_LONG)
                    .setAction("OK", null)
                    .show()
        }

//        val showSnackEcho = findViewById(R.id.showSnackEcho) as Button
        showToastEcho.setOnClickListener { view ->
            Toast.makeText(view.context, echoText.text.toString(), Snackbar.LENGTH_LONG)
                    .show()
        }

        startActivityBtn.setOnClickListener { view ->
            val intent = Intent(view.context, SimpleActivity::class.java)
                .putExtra(EXTRA_STRING, echoText.text.toString())
            startActivity(intent)
        }

        startCall.setOnClickListener { view ->
            val intent = Intent(Intent.ACTION_CALL)
                    .setData(Uri.parse("tel:+61400000000"))
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
