package com.x0.hatonekoe.view

import com.x0.hatonekoe.controller.MainController
import com.x0.hatonekoe.service.Constant
import tornadofx.View
import tornadofx.borderpane

class MainView: View(Constant.APP_NAME) {
    private val mainController: MainController by inject()

    override val root = borderpane {
        top(MenuBarView::class)
        center(InputBoxView::class)
        bottom(FooterView::class)
    }

    init {
    }
}
