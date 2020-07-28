package com.kcb.android.tourismguide.viewmodel.culinary

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kcb.android.tourismguide.parcelable.CulinaryParcelable
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.TextHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONArray
import java.lang.Exception

class CulinaryViewModel : ViewModel() {
    val listCulinary = MutableLiveData<ArrayList<CulinaryParcelable>>()

    fun setCulinary(){
        val listItem = ArrayList<CulinaryParcelable>()
        val url = "https://thawing-anchorage-78445.herokuapp.com/api/kuliner/"

        val client = AsyncHttpClient()
        client.get(url, object : TextHttpResponseHandler() {
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: String?
            ) {
                try {
                    val result = responseBody
                    val list = JSONArray(result)
                    for (i in 0 until list.length()){
                        val temp = CulinaryParcelable()
                        val listObject = list.getJSONObject(i)
                        temp.id = listObject.getString("id")
                        temp.title = listObject.getString("fullname")
                        temp.description = listObject.getString("desc")
                        temp.address = listObject.getString("alamat")
                        temp.timeOpen = listObject.getString("jam_buka")
                        temp.timeClose = listObject.getString("jam_tutup")
                        temp.price = listObject.getString("harga")
                        temp.photo = listObject.getString("images")
                        listItem.add(temp)
                    }
                    listCulinary.postValue(listItem)

                }catch (e: Exception){
                    Log.d("Exception", e.message.toString())
                }
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: String?,
                error: Throwable?
            ) {
                Log.d("onFailure", error?.message.toString())
            }
        })
    }
    fun getCulinary(): LiveData<ArrayList<CulinaryParcelable>> {
        return listCulinary
    }
}