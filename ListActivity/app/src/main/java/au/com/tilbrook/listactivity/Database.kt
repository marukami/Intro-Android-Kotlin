package au.com.tilbrook.listactivity

/**
 * Created by Mitchell Tilbrook on 29/03/16.
 */
object Database {
    var simpleList = arrayListOf(
            User(firstName = "Richard", lastName = "Banks", title = "ORGANIZER",
                    imageId = R.drawable.richard),
            User("James", "Crisp", "CO-ORGANIZER", imageId = R.drawable.james),
            User("Ken", "McCormack", "Event ORGANIZER", imageId = R.drawable.ken,
                    description = "Lead developer at ThoughtWorks, background in growing object-oriented software using automated tests - TDD, XP and .NET")
    )
}