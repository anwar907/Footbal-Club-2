package com.example.zhack.footballmatch

import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainPresenter ( private val view:MainView,
                      private val apiRepository: ApiRepository,
                      private val gson: Gson){
    fun getTeamList(league:String?) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository.doRequest(
                    ApiRepository.TheSportDBApi.getTeams(league)
            ), TeamResponse::class.java)


            uiThread {
                view.hideLoading()
                view.showTeamList(data.teams)
            }
        }
    }
}
