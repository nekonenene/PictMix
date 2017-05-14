package com.x0.hatonekoe.view

import javafx.geometry.Pos
import javafx.scene.control.TextField
import tornadofx.*

class InputBoxView: View() {
    var field1: TextField by singleAssign()
    var field2: TextField by singleAssign()

    override val root = form {
        alignment = Pos.CENTER

        fieldset {
            alignment = Pos.TOP_LEFT

            field("Picture A") {
                field1 = textfield()

                button("Push!") {
                    action {
                        println("pushed A")
                    }
                }
            }

            field("Picture B") {
                field2 = textfield()

                button("Push!") {
                    action {
                        println("pushed B")
                    }
                }
            }
        }

        button("Create!") {
            action {
                println("creating now...")
            }
        }
    }
}
