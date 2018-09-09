package com.tenilodev.indekos.utils

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by azisa on 3/11/2018.
 */
class TextUtils {

    companion object {
        fun formatMoney(money : String, periode : String) : String {
            val kursIndonesia = DecimalFormat.getCurrencyInstance() as DecimalFormat
            val formatRp = DecimalFormatSymbols()

            formatRp.currencySymbol = ""
            formatRp.monetaryDecimalSeparator = ','
            formatRp.groupingSeparator = '.'

            //System.out.println(cleanString);

            kursIndonesia.decimalFormatSymbols = formatRp
            kursIndonesia.maximumFractionDigits = 0

            val format = String.format("Rp %s %s", kursIndonesia.format(java.lang.Double.parseDouble(money)),periode)
            return format
        }

        fun formatDate(date : Date?) : String {
            val dateFormat = SimpleDateFormat("dd-MM-yyyy")
            val format = dateFormat.format(date)
            return format
        }
    }

}