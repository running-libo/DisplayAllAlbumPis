package com.example.displayanbum

import android.content.Context
import android.provider.MediaStore
import android.util.Log

object MediaFileLoader {

    fun loadMediaFile(context: Context) {
        var contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        val projection = arrayOf(
            MediaStore.Images.ImageColumns.DATA,
            MediaStore.Images.ImageColumns.BUCKET_DISPLAY_NAME
        )
        var cursor = context.contentResolver.query(contentUri, projection, null, null, null)
        if (cursor == null) {
            return
        }
        while (cursor.moveToNext()) {
            var pathColumn = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA)
            var path = cursor.getString(pathColumn)
            var nameColumn = cursor.getColumnIndex(MediaStore.Images.ImageColumns.BUCKET_DISPLAY_NAME)
            var displayName = cursor.getColumnName(nameColumn)

            Log.i("minfo", path + "--" + displayName)
        }
    }
}