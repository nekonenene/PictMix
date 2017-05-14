package com.x0.hatonekoe.service

import org.junit.Test
import kotlin.test.assertEquals

class FileServiceTest {
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
