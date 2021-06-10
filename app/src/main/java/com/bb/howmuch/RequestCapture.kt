package com.bb.howmuch

import android.graphics.Bitmap
import android.os.Environment
import android.view.View
import java.io.File
import java.io.FileOutputStream

//import androidx.test.core.app.ApplicationProvider.getApplicationContext


fun Request_Capture(view: View?, title: String) {
    if (view == null) { //Null Point Exception ERROR 방지
        println("::::ERROR:::: view == NULL")
        return
    }

    /* 캡쳐 파일 저장 */view.buildDrawingCache() //캐시 비트 맵 만들기
    val bitmap: Bitmap = view.getDrawingCache()
    val fos: FileOutputStream

    /* 저장할 폴더 Setting */
    val uploadFolder: File =
        Environment.getExternalStoragePublicDirectory("/DCIM/Camera/") //저장 경로 (File Type형 변수)
    if (!uploadFolder.exists()) { //만약 경로에 폴더가 없다면
        uploadFolder.mkdir() //폴더 생성
    }

    /* 파일 저장 */
    val Str_Path: String = Environment.getExternalStorageDirectory().getAbsolutePath()
        .toString() + "/DCIM/Camera/" //저장 경로 (String Type 변수)
    try {
        fos = FileOutputStream("$Str_Path$title.jpg") // 경로 + 제목 + .jpg로 FileOutputStream Setting
        bitmap.compress(Bitmap.CompressFormat.JPEG, 80, fos)
    } catch (e: Exception) {
        e.printStackTrace()
    }

//    //캡쳐 파일 미디어 스캔 (https://hongdroid.tistory.com/7)
//    val ms: MediaScanner = MediaScanner.newInstance(ApplicationProvider.getApplicationContext())
//    try { // TODO : 미디어 스캔
//        ms.mediaScanning("$Str_Path$title.jpg")
//    } catch (e: Exception) {
//        e.printStackTrace()
//        println("::::ERROR:::: $e")
//    }
} //End Function
