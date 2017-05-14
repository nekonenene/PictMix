package com.x0.hatonekoe.view

import javafx.geometry.Pos
import tornadofx.*

class FormView : View() {
    override val root = form {
        alignment = Pos.CENTER

        fieldset {
            alignment = Pos.TOP_LEFT

            this += FilePathInputView("Picture A")
            this += FilePathInputView("Picture B")
        }

        button("Create!") {
            action {
                println("creating now...")
            }
        }
    }
}
