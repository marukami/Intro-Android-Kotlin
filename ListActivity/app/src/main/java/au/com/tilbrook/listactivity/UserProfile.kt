package au.com.tilbrook.listactivity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_user_profile.*
import kotlinx.android.synthetic.main.content_user_profile.*



class UserProfile : AppCompatActivity() {

    private var userId: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)
        setSupportActionBar(toolbar)

        intent.getIntExtra(EXTRA_EDIT_USER_ID, userId)
        val user = Database.simpleList[userId]

        profileImage.setImageResource(user.imageId)
        firstName.setText(user.firstName)
        lastName.setText(user.lastName)
        titleName.setText(user.title)
        description.setText(user.firstName)

        saveUser.setOnClickListener {
            val user = Database.simpleList[userId].copy(
                    firstName = firstName.text.toString(),
                    lastName = lastName.text.toString(),
                    title = titleName.text.toString(),
                    description = firstName.text.toString()
            )
            Database.simpleList.set(userId, user)
            finish()
        }
    }

}
