package com.lottolike.jaery.lotto.ui.getnumber;

import com.lottolike.jaery.lotto.data.userlottodata.UserLottoData;
import com.lottolike.jaery.lotto.data.userlottodata.source.UserLottoDataRepository;
import com.lottolike.jaery.lotto.data.userlottodata.source.local.LottoDBHelper;
import com.lottolike.jaery.lotto.data.util.LottoUtil;

import java.util.ArrayList;

public class GetNumberPresenter implements GetNumberContract.Presenter {
    private GetNumberContract.View view;
    private UserLottoDataRepository repository;

    private ArrayList<Integer> selectedNumber;

    public GetNumberPresenter(GetNumberContract.View view, UserLottoDataRepository repository) {
        this.view = view;
        this.repository = repository;
        selectedNumber = new ArrayList<>();
    }

    @Override
    public void numberSaveButtonClick() {
        if (selectedNumberCheck()) {
            insertLottoNumber(selectedNumber);
            view.showSaveSuccess();
        } else {
            view.showSaveError();
        }
    }

    @Override
    public void recommendButtonClick() {
        selectedNumber = LottoUtil.INSTANCE.getRecommendLotto();
        view.showRecommendView(selectedNumber);
    }

    @Override
    public void selfNumberButtonClick(int value) {
        Integer newValue = value;

        if (selectedNumber.contains(newValue)) {
            selectedNumber.remove(newValue);
        } else {
            if (selectedNumber.size() == 6) {
                view.showSaveError();
            } else {
                selectedNumber.add(newValue);
            }
        }
        view.clearSelectedNumber();
        view.showRecommendView(selectedNumber);
    }

    @Override
    public void clearButtonClick() {
        selectedNumber.clear();
        view.clearSelectedNumber();
    }


    @Override
    public void start() {

    }

    private boolean selectedNumberCheck() {
        return selectedNumber.size() == 6;
    }

    private void insertLottoNumber(ArrayList<Integer> number) {

        String userNumber = number.toString();
        userNumber = userNumber.substring(1, userNumber.length() - 1);
        UserLottoData userLottoData = new UserLottoData(userNumber);

        repository.insertUserLottoData(userLottoData);
    }
}
