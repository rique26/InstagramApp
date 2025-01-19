package co.tiagoaguiar.course.instagram.common.extension

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import co.tiagoaguiar.course.instagram.R

fun Activity.hideKeyboard() {
  val imm: InputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager

  var view: View? = currentFocus
  if (view == null) {
    view = View(this)
  }

  imm.hideSoftInputFromWindow(view.windowToken, 0)
}


fun Activity.animationEnd(callback: () -> Unit) : AnimatorListenerAdapter {
  return object : AnimatorListenerAdapter() {
    override fun onAnimationEnd(animation: Animator?) {
      callback.invoke()
    }
  }
}


fun AppCompatActivity.replaceFragment(@IdRes id: Int, fragment: Fragment) {
  val prev = supportFragmentManager.findFragmentByTag(fragment.javaClass.name) // PASSAR UM NOME da CLASSE

  supportFragmentManager.beginTransaction().apply {
    replace(id, fragment, fragment.javaClass.name) // PASSAR UM NOME da CLASSE COMO TAG
    if (prev == null) {
      addToBackStack(fragment.javaClass.name) // ADICIONA O NOME PARA A PROXIMA INTERAÇÃO
    }
    commit()
  }

  hideKeyboard()
}