package com.example.mvvmnisargdemo.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmnisargdemo.R
import com.example.mvvmnisargdemo.data.db.AppDatabase
import com.example.mvvmnisargdemo.data.db.entities.User
import com.example.mvvmnisargdemo.data.network.MyApi
import com.example.mvvmnisargdemo.data.network.NetworkConnectionInterceptor
import com.example.mvvmnisargdemo.data.repositories.UserRepository
import com.example.mvvmnisargdemo.databinding.ActivityLoginBinding
import com.example.mvvmnisargdemo.ui.home.HomeActivity
import com.example.mvvmnisargdemo.util.hide
import com.example.mvvmnisargdemo.util.show
import com.example.mvvmnisargdemo.util.snackbar
import kotlinx.android.synthetic.main.activity_login.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class LoginActivity : AppCompatActivity(), AuthListener, KodeinAware {

    override val kodein by kodein()
    private val factory: AuthViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityLoginBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_login)
        val viewModel = ViewModelProvider(this, factory).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel

        viewModel.authListener = this

        viewModel.getLoggedInUser().observe(this, Observer { user ->
            if (user != null){
                Intent(this, HomeActivity::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }
            }
        })
    }

    override fun onStarted() {
        progress_bar.show()
    }

    override fun onSuccess(user: User?) {
        progress_bar.hide()
    }

    override fun onFailure(message: String) {
        progress_bar.hide()
        root_layout.snackbar(message)
    }
}
