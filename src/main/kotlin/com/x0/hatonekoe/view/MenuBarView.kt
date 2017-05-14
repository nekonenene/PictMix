package com.x0.hatonekoe.view

import com.x0.hatonekoe.controller.MenuBarController
import com.x0.hatonekoe.service.FileService
import javafx.application.Platform
import javafx.scene.input.KeyCombination
import tornadofx.*
import java.util.*

class MenuBarView: View() {
    val localeFile: ResourceBundle = ResourceBundle.getBundle("locale")
    val menuBarController: MenuBarController by inject()

    override val root = menubar {
        useMaxWidth = true
        paddingVertical = 3
        paddingHorizontal = 4

        menu(localeFile["menu.file"]) {
            item(localeFile["menu.new"], KeyCombination.valueOf("Shortcut+N")) {
                action {
                }
            }
            item(localeFile["menu.open"], KeyCombination.valueOf("Shortcut+O")) {
                action {
                    FileService.openFile()
                }
            }
            item(localeFile["menu.save"], KeyCombination.valueOf("Shortcut+S")) {
                action {
                }
            }
            item(localeFile["menu.save_as"], KeyCombination.valueOf("Shortcut+W")) {
                action {
                }
            }
            item(localeFile["menu.quit"], KeyCombination.valueOf("Shortcut+Q")) {
                action {
                    Platform.exit()
                }
            }
        }
    }
}
