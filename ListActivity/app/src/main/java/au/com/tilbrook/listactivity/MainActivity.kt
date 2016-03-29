package au.com.tilbrook.listactivity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.*
import android.widget.BaseAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.row_user.view.*


const val EXTRA_EDIT_USER_ID = "EXTRA_EDIT_USER_ID"

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action") {
                        Toast.makeText(view.context, "Snack Toast", Toast.LENGTH_LONG)
                                .show()
                    }
                    .show()
        }


        adapter = UserAdapter(this, Database.simpleList)

        itemList.adapter = adapter
        itemList.setOnItemClickListener { adapterView, view, pos, itemId ->
            val intent = Intent(view.context, UserProfile::class.java)
            startActivity(intent)
        }
    }

    override fun onRestart() {
        adapter.notifyDataSetChanged()
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

class UserAdapter(private val ctx: Context, private val collection: List<User>) : BaseAdapter() {
    override fun getCount(): Int = collection.size

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?:
            LayoutInflater.from(ctx).inflate(R.layout.row_user, parent, false)
        val user = getItem(position)
        view.profileImage.setImageResource(user.imageId)
        view.fullUserName.text = user.fullName
        view.titleName.text = user.title
        view.description.text = user.description

        return view
    }

    override fun getItem(position: Int): User = collection.get(position)

    override fun getItemId(position: Int): Long = 1
}

data class User(
        val firstName: String,
        val lastName: String,
        val title: String,
        val imageId: Int,
        val description: String = "") {
    val fullName = "$firstName $lastName"
    fun lazyFullName() = "$firstName $lastName"
}
