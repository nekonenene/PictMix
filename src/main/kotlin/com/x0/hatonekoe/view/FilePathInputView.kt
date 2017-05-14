package com.x0.hatonekoe.view

import javafx.scene.input.TransferMode
import tornadofx.*
import java.io.File

class FilePathInputView(fieldName: String = ""): View() {
    override val root = field(fieldName) {
        textfield {
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
                        this@textfield.text = file.absolutePath

                        event.isDropCompleted = true
                        return@run
                    }
                    event.isDropCompleted = false
                }
            }
        }

        button("Select") {
            action {
                println("Open the dialog...")
            }
        }
    }

    init {
        println("Create " + this::class.simpleName)
    }
}
