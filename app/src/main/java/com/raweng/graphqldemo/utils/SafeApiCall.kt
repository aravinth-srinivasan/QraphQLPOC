package com.raweng.graphqldemo.utils
import com.apollographql.apollo.api.Response
import java.lang.Exception

abstract class SafeApiRequest {

    suspend fun <T : Any> apiRequest(call: suspend () -> Response<T>): Resource<T> {
        try {
            val response = call.invoke()
            return if (response.data!=null) {
                Resource.Success(response.data!!)
            }else{
                Resource.Error("")
            }

            /*else {
                val error = response.errorBody()?.string()
                val message = StringBuilder()
                error?.let {
                    try {
                        message.append(JSONObject(it).getString("message"))
                        return Resource.Error(message.toString())
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    message.append("\n")
                }
                message.append("Error Code: ${response.code()}")
                return Resource.Error(message.toString())*/
                //throw ApiException(message.toString())

        }catch (e:Exception){
            e.printStackTrace()
            return Resource.Error(e.message.toString())
        }

    }

}