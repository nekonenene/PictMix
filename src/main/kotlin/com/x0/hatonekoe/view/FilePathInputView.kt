package com.x0.hatonekoe.view

import com.x0.hatonekoe.service.FileService
import javafx.scene.control.TextField
import javafx.scene.input.TransferMode
import tornadofx.*
import java.io.File
import java.util.*

class FilePathInputView(fieldName: String = ""): View() {
    val localeFile: ResourceBundle = ResourceBundle.getBundle("locale")
    var filePathField: TextField by singleAssign()

    override val root = field(fieldName) {
        filePathField = textfield {
        }

        button(localeFile["button.select"]) {
            action {
                val file: File? = FileService.chooseOneFile(FileChooserMode.Single)
                filePathField.text = file?.absolutePath
            }
        }

        setOnDragOver { event ->
            run {
                val dragBoard = event.dragboard

                if (dragBoard.hasFiles()) {
                    // Change the mouse cursor
                    event.acceptTransferModes(TransferMode.COPY)
                }
            }
        }

        setOnDragDropped { event ->
            run {
                val dragBoard = event.dragboard

                if (dragBoard.files.size > 0) {
                    val file: File = dragBoard.files.first()
                    filePathField.text = file.absolutePath

                    event.isDropCompleted = true
                    return@run
                }
                event.isDropCompleted = false
            }
        }
    }

    init {
    }
}
