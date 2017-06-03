package me.baleen.kotlinDagger.ui.main

import android.content.Context
import android.os.Bundle
import me.baleen.kotlinDagger.App
import me.baleen.kotlinDagger.R.layout
import me.baleen.kotlinDagger.ui.base.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity() {

  @Inject
  lateinit var context: Context

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layout.activity_main)

    App.graph.inject(this)
  }
}
