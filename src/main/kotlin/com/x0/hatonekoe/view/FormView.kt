package com.x0.hatonekoe.view

import com.x0.hatonekoe.service.ImageService
import javafx.geometry.Pos
import tornadofx.*
import java.io.File

class FormView : View() {
    override val root = form {
        val input1 = FilePathInputView("Picture A")

        alignment = Pos.CENTER

        fieldset {
            alignment = Pos.TOP_LEFT


            this += input1
            this += FilePathInputView("Picture B")
        }

        button("Create!") {
            action {
                val file = File(input1.filePathField.text)
                ImageService.overlayImage(file)
            }
        }
    }
}
