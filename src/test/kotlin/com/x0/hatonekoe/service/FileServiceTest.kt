package com.x0.hatonekoe.service

import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder
import java.io.File
import kotlin.test.assertEquals

class FileServiceTest {
    @Rule @JvmField
    val temporaryFolder = TemporaryFolder()

    @Test
    fun getFileNameWithoutExtensionTest() {
        var file: File
        file = temporaryFolder.newFile("test.txt")
        assertEquals("test", FileService.getFileNameWithoutExtension(file))
        file = temporaryFolder.newFile("test.")
        assertEquals("test", FileService.getFileNameWithoutExtension(file))
        file = temporaryFolder.newFile("test.txt.jpg")
        assertEquals("test.txt", FileService.getFileNameWithoutExtension(file))
        file = temporaryFolder.newFile("non_extension")
        assertEquals("non_extension", FileService.getFileNameWithoutExtension(file))
    }

    @Test
    fun displayFileSizeTest() {
        assertEquals("3 byte", FileService.displayFileSize(3))
        assertEquals("3 KB", FileService.displayFileSize(3_000))
        assertEquals("3 MB", FileService.displayFileSize(3_000_000))
        assertEquals("3 GB", FileService.displayFileSize(3_000_000_000))
        assertEquals("3000 GB", FileService.displayFileSize(3_000_000_000_000))
        assertEquals("1234 GB", FileService.displayFileSize(1_234_567_890_000))
    }
}
