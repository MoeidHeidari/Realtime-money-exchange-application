package com.example.revoluttestapplication.viewHolders.CallBacks;

import com.example.revoluttestapplication.data.network.dataModels.CurrenciesApiResponseModel;

/**
 *
 * @author moeidheidari
 * @version 1.0
 */

public interface CurrenciesOnClickListener
{
    void onClick(CurrenciesApiResponseModel.Rate item);
}
