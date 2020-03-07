package com.waleed.mvvmsample.database

import android.os.AsyncTask
import com.waleed.mvvmsample.DatabaseOperations
import com.waleed.mvvmsample.listeners.DatabaseListener

class DatabaseOperationsTask(
    private val operation: () -> Any,
    private val operationType: DatabaseOperations,
    private val listener: DatabaseListener
) : AsyncTask<Void, Void, Any?>() {

    override fun doInBackground(vararg args: Void?): Any? {
        return operation.invoke()
    }

    override fun onPostExecute(result: Any?) {
        if (operationType == DatabaseOperations.READ) {
            if (result != null) {
                listener.onOperationSuccess(result)
            } else {
                listener.onOperationFailed()
            }
        }
    }
}