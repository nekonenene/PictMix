package com.x0.hatonekoe.service

import javafx.stage.FileChooser
import tornadofx.FileChooserMode
import tornadofx.chooseFile
import java.io.File

object FileService {
    private val allFilter = FileChooser.ExtensionFilter("All files (*.*)", "*.*")

    /**
     * Open a file
     */
    fun openFile(targetFile: File? = null) {
        val file: File

        if (targetFile == null) {
            // If the user didn't select, then finish this method.
            file = chooseOneFile(FileChooserMode.Single) ?: return
        } else {
            file = targetFile
        }

        try {
            println(file.name)
        } catch (e: Exception) {
            println(e)
        }
    }

    /**
     * Open the dialog to choose a file
     *
     * @param mode: Use FileChooserMode.Single or FileChooserMode.Save
     */
    fun chooseOneFile(mode: FileChooserMode): File? {
        val fileList = chooseFile(null, arrayOf(allFilter), mode)

        val file =
            if (fileList.isEmpty()) {
                null
            } else {
                fileList.first()
            }

        return file
    }

    /**
     * Display the readable file size
     *
     * @param fileSizeByte: File size (byte)
     * @return Display the size with the unit for the byte
     */
    fun displayFileSize(fileSizeByte: Long): String {
        var displaySize = fileSizeByte
        var counter = 0

        while (true) {
            if (displaySize < 1_000 || counter > 2) {
                when (counter) {
                    0 -> return "$displaySize byte"
                    1 -> return "$displaySize KB"
                    2 -> return "$displaySize MB"
                    else -> return "$displaySize GB"
                }
            } else {
                ++counter
                displaySize /= 1_000
            }
        }
    }
}
