package com.lottolike.jaery.lotto.lotto.adapter.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lottolike.jaery.lotto.R;


public class LottoInfoViewHolder extends RecyclerView.ViewHolder {

    public TextView times;
    public TextView time;

    public LottoInfoViewHolder(@NonNull View itemView) {
        super(itemView);

        times = itemView.findViewById(R.id.what_drwn0_times);
        time = itemView.findViewById(R.id.what_drwn0_time);

    }
}