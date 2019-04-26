package latihan.android.com.latihan17.view

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import latihan.android.com.latihan17.R

class MainClass: AppCompatActivity() {
    private lateinit var navogationController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainlayout)

        navogationController = findNavController(R.id.navigationHost)
        NavigationUI.setupActionBarWithNavController(this, navogationController)
    }
    override fun onSupportNavigateUp() = navogationController.navigateUp()
}
