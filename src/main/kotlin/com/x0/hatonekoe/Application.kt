package com.x0.hatonekoe

import com.x0.hatonekoe.service.Constant
import com.x0.hatonekoe.view.MainView
import javafx.application.Application
import javafx.stage.Stage
import tornadofx.App

fun main(args: Array<String>) {
    Application.launch(PictMixApp::class.java, *args)
}

class PictMixApp: App() {
    override val primaryView = MainView::class

    override fun start(stage: Stage) {
        super.start(stage)
        stage.isFullScreen = false
        stage.minWidth  = Constant.WINDOW_MIN_WIDTH
        stage.minHeight = Constant.WINDOW_MIN_HEIGHT

        stage.width = Constant.INITIAL_WINDOW_WIDTH
        stage.height = Constant.INITIAL_WINDOW_HEIGHT
    }

    override fun stop() {
        super.stop()
        println("finished Application")
    }
}
