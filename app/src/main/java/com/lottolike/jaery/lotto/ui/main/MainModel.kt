package com.lottolike.jaery.lotto.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import com.lottolike.jaery.lotto.lotto.domain.LottoNumberInfo
import com.lottolike.jaery.lotto.lotto.util.LottoUtil

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainModel {
    var _lottoNumbers : MutableLiveData<String> = MutableLiveData()
    var _lottoRound : MutableLiveData<Int> = MutableLiveData()
    var _lottoRoundDate : MutableLiveData<String> = MutableLiveData()
    var _recommendLotto : MutableLiveData<ArrayList<Int>> = MutableLiveData()

    var lottoNumbers : LiveData<String> = _lottoNumbers
    var lottoRound : LiveData<Int> = _lottoRound
    var lottoRoundDate : LiveData<String> = _lottoRoundDate
    var recommendLotto : LiveData<ArrayList<Int>> = _recommendLotto

    public fun changeLottoInfo() {
        CoroutineScope(Dispatchers.Main).launch {
            val info : LottoNumberInfo = LottoUtil.getLottoNumberInfo()

            _lottoRound.postValue(info.round)
            _lottoNumbers.postValue(info.numbers)

            val date : String = LottoUtil.getLottoRoundDate()
            _lottoRoundDate.postValue(date)

        }
    }

    public fun changeRecommendLotto() {
        val recommendLottoNumber = LottoUtil.getRecommendLotto()
        _recommendLotto.postValue(recommendLottoNumber)
    }
}