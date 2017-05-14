package com.x0.hatonekoe.view

import com.x0.hatonekoe.controller.FooterController
import javafx.geometry.Pos
import tornadofx.*

class FooterView: View() {
    private val footerController: FooterController by inject()

    override val root = hbox {
        alignment = Pos.CENTER_RIGHT

        label {
            useMaxWidth = true
            paddingHorizontal = 8
            paddingVertical = 6

            text = "This is the footer."
        }
    }
}
