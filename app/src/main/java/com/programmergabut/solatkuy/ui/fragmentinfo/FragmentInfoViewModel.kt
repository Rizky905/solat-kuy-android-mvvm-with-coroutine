package com.programmergabut.solatkuy.ui.fragmentinfo

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.programmergabut.solatkuy.data.Repository
import com.programmergabut.solatkuy.data.local.localentity.MsApi1
import com.programmergabut.solatkuy.data.remote.remoteentity.prayerJson.PrayerResponse
import com.programmergabut.solatkuy.util.Resource

/*
 * Created by Katili Jiwo Adi Wiyono on 25/04/20.
 */

class FragmentInfoViewModel @ViewModelInject constructor(val repository: Repository): ViewModel() {

    private var msApi1Param = MutableLiveData<MsApi1>()
    val prayerResponse : MutableLiveData<Resource<PrayerResponse>> = Transformations.switchMap(msApi1Param){
        repository.fetchPrayerApi(it)
    } as MutableLiveData<Resource<PrayerResponse>>

    /* val asmaAlHusnaApi : MutableLiveData<Resource<AsmaAlHusnaApi>> = Transformations.switchMap(msApi1Param){
        repository.fetchAsmaAlHusna()
    } as MutableLiveData<Resource<AsmaAlHusnaApi>> */

    val msApi1Local: LiveData<Resource<MsApi1>> = repository.getMsApi1()

    //Room

    /* fun fetchAsmaAlHusna(msApi1: MsApi1){
        this.msApi1Param.value = msApi1
    } */

    fun fetchPrayerApi(msApi1: MsApi1){
        this.msApi1Param.value = msApi1
    }

}