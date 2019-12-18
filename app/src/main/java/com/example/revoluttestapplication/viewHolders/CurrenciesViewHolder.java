package com.example.revoluttestapplication.viewHolders;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.revoluttestapplication.R;


/**
 * a view holder used in rates recycler view custom adapter
 * stores and recycles views as they are scrolled off screen
 *
 * @author moeidheidari
 * @version 1.0
 */

public class CurrenciesViewHolder extends RecyclerView.ViewHolder {

    EditText Currency_Converter_EditText_Item;
    TextView Currency_Converter_RateTextView_Item;
    ImageView currensies_list_item_flag;

    CurrenciesViewHolder(View itemView)
    {
        super(itemView);
        Currency_Converter_EditText_Item = itemView.findViewById(R.id.Currency_Converter_EditText_Item);
        Currency_Converter_RateTextView_Item=itemView.findViewById(R.id.Currency_Converter_RateTextView_Item);
        currensies_list_item_flag=itemView.findViewById(R.id.currensies_list_item_flag);
    }


}
