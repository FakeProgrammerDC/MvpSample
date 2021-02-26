package com.example.mvpsample.ui.demo;

import android.util.Log;

import com.example.mvpsample.R;
import com.example.mvpsample.base.BaseResponse;
import com.example.mvpsample.bean.AdvertisingData;
import com.example.mvpsample.data.Injection;
import com.example.mvpsample.data.demo.DemoRepository;
import com.example.mvpsample.data.task.TasksRepository;
import com.example.mvpsample.network.HttpResponse;
import com.example.mvpsample.ui.tasklist.TasksContract;
import com.example.mvpsample.utils.schedulers.BaseSchedulerProvider;

import org.reactivestreams.Publisher;

import java.util.List;
import java.util.Observable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.functions.Function;

public class DemoPresenter extends DemoContract.Presenter {

    private DemoRepository mDemoRepository;

    private CompositeDisposable mCompositeDisposable;

    private BaseSchedulerProvider mSchedulerProvider;

    @Override
    public void init() {
        mDemoRepository = Injection.provideDemoRepository(mContext);
        mSchedulerProvider = Injection.providerSchedulerProvider();
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void loadData() {
//        mDemoRepository.getDemoDataList()
//                .flatMap(new Function<BaseResponse<List<AdvertisingData>>, Flowable<List<AdvertisingData>>>() {
//                    @Override
//                    public Flowable<List<AdvertisingData>> apply(BaseResponse<List<AdvertisingData>> tBaseResponse) throws Throwable {
//                        if (tBaseResponse.code==200&&tBaseResponse.data!=null){
//                            //onSuccess(tBaseResponse.data);
//                            return Flowable.fromIterable(tBaseResponse.data).toList().toFlowable();
//                        }
//                        return null;
//                    }
//                })
//                .subscribeOn(mSchedulerProvider.io())
//                .observeOn(mSchedulerProvider.ui())
//                .subscribe(dataList -> showView(dataList), throwable -> mView.showErrorView());
//        mDemoRepository.getDemoDataList()
//                .flatMap((tBaseResponse) -> {
//                    if (tBaseResponse.code == 200 && tBaseResponse.data != null) {
//                        //onSuccess(tBaseResponse.data);
//                        return Flowable.fromIterable(tBaseResponse.data).toList().toFlowable();
//                    }
//                    return null;
//                })
//                .subscribeOn(mSchedulerProvider.io())
//                .observeOn(mSchedulerProvider.ui())
//                .subscribe(dataList -> showView(dataList), throwable -> mView.showErrorView());

        mDemoRepository.getList()
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(dataList -> showView((List<AdvertisingData>) dataList), throwable -> mView.showErrorView());
    }


    private void showView(List<AdvertisingData> data) {
        mView.showView();
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unSubscribe() {

    }
}
