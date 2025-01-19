package co.tiagoaguiar.course.instagram.profile.presentation

import co.tiagoaguiar.course.instagram.profile.Profile
import co.tiagoaguiar.course.instagram.profile.data.ProfileRepository

class ProfilePresenter (
    private var view: Profile.View?,
    private val repository: ProfileRepository
) : Profile.Presenter{




    override fun onDestroy() {
        view = null
    }

}