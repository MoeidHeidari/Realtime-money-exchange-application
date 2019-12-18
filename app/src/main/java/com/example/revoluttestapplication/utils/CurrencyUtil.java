package com.example.revoluttestapplication.utils;

import com.example.revoluttestapplication.R;

/**
 * Currency is dedicated to manage the operations and utilities of currencies
 *
 * @author moeidheidari
 * @version 1.0
 */

public class CurrencyUtil
{

    /**
     * this method gets a string as currency code and returns the flag drawable associated with the given currence code
     *
     * @param CurrencyCode
     * @return Locale
     */
    public static int getCountryCodeFromCurrencyCode(String CurrencyCode) {
        switch (CurrencyCode)
        {
            case "AUD":
                    return R.drawable.flag_au;
            case "BGN":
                return R.drawable.flag_bg;
            case "BRL":
                return R.drawable.flag_br;
            case "CAD":
                return R.drawable.flag_ca;
            case "CHF":
                return R.drawable.flag_ch;
            case "CNY":
                return R.drawable.flag_cn;
            case "CZK":
                return R.drawable.flag_cz;
            case "DKK":
                return R.drawable.flag_dk;
            case "GBP":
                return R.drawable.flag_gb;
            case "HKD":
                return R.drawable.flag_hk;
            case "HRK":
                return R.drawable.flag_hr;
            case "HUF":
                return R.drawable.flag_hu;
            case "IDR":
                return R.drawable.flag_id;
            case "ILS":
                return R.drawable.flag_il;
            case "INR":
                return R.drawable.flag_in;
            case "ISK":
                return R.drawable.flag_is;
            case "JPY":
                return R.drawable.flag_jp;
            case "KRW":
                return R.drawable.flag_kr;
            case "MXN":
                return R.drawable.flag_mx;
            case "MYR":
                return R.drawable.flag_my;
            case "NOK":
                return R.drawable.flag_no;
            case "NZD":
                return R.drawable.flag_nz;
            case "PHP":
                return R.drawable.flag_ph;
            case "PLN":
                return R.drawable.flag_pl;
            case "RON":
                return R.drawable.flag_ro;
            case "RUB":
                return R.drawable.flag_ru;
            case "SEK":
                return R.drawable.flag_se;
            case "SGD":
                return R.drawable.flag_sg;
            case "THB":
                return R.drawable.flag_th;
            case "TRY":
                return R.drawable.flag_tr;
            case "USD":
                return R.drawable.flag_us;
            case "ZAR":
                return R.drawable.flag_za;
            default:
                return 0;

        }

    }
}
