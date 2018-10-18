package com.example.zhack.footballmatch

import java.net.URL

class ApiRepository {

    fun doRequest(url: String): String {
        return URL(url).readText()
    }

    object TheSportDBApi {
        fun getTeams(league: String?): String {
            return BuildConfig.BASE_URL +
                    "api/v1/json/${BuildConfig.TSDB_API_KEY}" +
                    "/search_all_teams.php?l=" + league

        }
    }
}