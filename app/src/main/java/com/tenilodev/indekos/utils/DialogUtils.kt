package com.tenilodev.indekos.utils

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog
import com.tenilodev.indekos.R

/**
 * Created by azisa on 1/23/2018.
 */
class DialogUtils {

    companion object {


        fun showInfoDialog(context : Context, title : String?, message : String?, onOkClick: () -> Unit? = {}) {
            AlertDialog.Builder(context)
                    .setTitle(title)
                    .setMessage(message)
                    .setPositiveButton("OK", DialogInterface.OnClickListener { dialogInterface, i ->
                        dialogInterface.dismiss()
                        onOkClick.invoke()
                    })
                    .create().show()
        }

        fun showConfirmDialog(context: Context, title: String?, message: String?, onYesClick : () -> Unit? = {}){
            AlertDialog.Builder(context)
                    .setTitle(title)
                    .setMessage(message)
                    .setPositiveButton(R.string.yes, DialogInterface.OnClickListener { dialogInterface, i ->
                        dialogInterface.dismiss()
                        onYesClick.invoke()
                    })
                    .setNegativeButton(R.string.cancel, DialogInterface.OnClickListener { dialogInterface, i ->
                        dialogInterface.dismiss()
                    })
                    .create().show()
        }

    }

}