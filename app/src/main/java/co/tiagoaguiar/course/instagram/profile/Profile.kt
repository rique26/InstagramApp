package co.tiagoaguiar.course.instagram.profile

import co.tiagoaguiar.course.instagram.common.base.BasePresenter
import co.tiagoaguiar.course.instagram.common.base.BaseView

interface Profile {

    interface Presenter : BasePresenter{}

    interface View : BaseView<Presenter>{

    }
}