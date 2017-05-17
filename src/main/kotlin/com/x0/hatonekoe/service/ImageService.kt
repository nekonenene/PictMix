package com.x0.hatonekoe.service

import org.bytedeco.javacpp.opencv_core.*
import org.bytedeco.javacpp.opencv_imgcodecs.*
import org.bytedeco.javacpp.opencv_imgproc.*
import java.io.File

object ImageService {
    /**
     * Open a file
     */
    fun addImage(file: File) {
        val originalImage: Mat = imread(file.absolutePath, IMREAD_UNCHANGED)

        val imasLogoFile = File("imas_logo.png")
        val imasLogoImage: Mat = imread(imasLogoFile.absolutePath, IMREAD_UNCHANGED)

        val originalImageWidth: Double = originalImage.size().width().toDouble()
        val logoImageWidth: Double = imasLogoImage.size().width().toDouble()
        val imasLogoResizeRatio: Double = originalImageWidth / logoImageWidth / 2.0

        resize(imasLogoImage, imasLogoImage, Size(), imasLogoResizeRatio, imasLogoResizeRatio, INTER_LINEAR)

        val ctr = Point2f(originalImage.cols().toFloat(), originalImage.rows().toFloat())
        val mat: Mat = getRotationMatrix2D(ctr, 0.0, 1.0)

        warpAffine(imasLogoImage, originalImage, mat, originalImage.size(), CV_INTER_LINEAR, BORDER_TRANSPARENT, null)

        imwrite(file.parent + "/" + removeExtension(file) + "_imas.png", originalImage)
    }

    fun removeExtension(file: File): String {
        val fileName = file.name
        val index = fileName.lastIndexOf('.')

        if (index != -1) {
            return fileName.substring(0, index)
        } else {
            // return original file name if doesn't have an extension
            return fileName
        }
    }
}
