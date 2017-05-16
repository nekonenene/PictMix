package com.x0.hatonekoe.view

import com.x0.hatonekoe.controller.MainController
import com.x0.hatonekoe.service.Constant
import tornadofx.View
import tornadofx.borderpane
import tornadofx.style

class MainView: View(Constant.APP_NAME) {
    private val mainController: MainController by inject()

    override val root = borderpane {
        style {
            fontFamily = "YuGothic" // Windows は "Yu Gothic"
        }

        top(MenuBarView::class)
        center(FormView::class)
        bottom(FooterView::class)
    }

    init {
    }
}
