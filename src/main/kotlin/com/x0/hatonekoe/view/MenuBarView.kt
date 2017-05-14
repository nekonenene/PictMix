package com.x0.hatonekoe.view

import com.x0.hatonekoe.controller.MenuBarController
import com.x0.hatonekoe.service.FileService
import javafx.application.Platform
import javafx.scene.input.KeyCombination
import tornadofx.*

class MenuBarView: View() {
    val menuBarController: MenuBarController by inject()

    override val root = menubar {
        useMaxWidth = true
        paddingVertical = 3
        paddingHorizontal = 4

        menu("File") {
            item("New", KeyCombination.valueOf("Shortcut+N")) {
                action {
                }
            }
            item("Open", KeyCombination.valueOf("Shortcut+O")) {
                action {
                    FileService.openFile()
                }
            }
            item("Save", KeyCombination.valueOf("Shortcut+S")) {
                action {
                }
            }
            item("Save as new file", KeyCombination.valueOf("Shortcut+W")) {
                action {
                }
            }
            item("Quit", KeyCombination.valueOf("Shortcut+Q")) {
                action {
                    Platform.exit()
                }
            }
        }
    }
}
