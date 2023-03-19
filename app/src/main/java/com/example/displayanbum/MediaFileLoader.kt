package com.example.displayanbum

import android.content.Context
import android.provider.MediaStore

object MediaFileLoader {

    /**
     * 开启子线程加载数据
     */
    fun threadLoadData() {

    }

    fun loadMediaFile(context: Context): ArrayList<PicBean>? {
        var datas = ArrayList<PicBean>()
        var contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        val projection = arrayOf(
            MediaStore.Images.Media.DATA,
            MediaStore.Images.Media.DISPLAY_NAME
        )
        val sortOrder = MediaStore.Images.Media.DATE_TAKEN + " DESC " //倒序排列
        var cursor = context.contentResolver.query(contentUri, projection, null, null, sortOrder)
        if (cursor == null) {
            return datas
        }
        while (cursor.moveToNext()) {
            var pathColumn = cursor.getColumnIndex(projection[0])
            var path = cursor.getString(pathColumn)
            var nameColumn = cursor.getColumnIndex(projection[1])
            var displayName = cursor.getString(nameColumn)

            var picBean = PicBean(path, displayName)
            datas.add(picBean)
        }
        return datas
    }
}