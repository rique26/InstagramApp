package co.tiagoaguiar.course.instagram.profile.view

import android.os.Bundle
import android.view.*
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.tiagoaguiar.course.instagram.R
import co.tiagoaguiar.course.instagram.common.base.BaseFragment
import co.tiagoaguiar.course.instagram.common.base.DependencyInjector
import co.tiagoaguiar.course.instagram.databinding.FragmentProfileBinding
import co.tiagoaguiar.course.instagram.profile.Profile
import co.tiagoaguiar.course.instagram.profile.presentation.ProfilePresenter

class ProfileFragment : BaseFragment<FragmentProfileBinding, Profile.Presenter> (
  R.layout.fragment_profile,
  FragmentProfileBinding::bind
), Profile.View {

  override lateinit var presenter: Profile.Presenter

  private val adapter = PostAdapter()

  override fun setupPresenter() {
    val repository = DependencyInjector.profileRepository()
    presenter = ProfilePresenter(this, repository)
  }

  override fun setupViews() {
    binding?.profileRv?.layoutManager = GridLayoutManager(requireContext(), 3)
    binding?.profileRv?.adapter = adapter

  }

  override fun getMenu(): Int {
    return R.menu.menu_profile
  }

}