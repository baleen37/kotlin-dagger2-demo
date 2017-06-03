package me.baleen.kotlinDagger.data.remote.service

import io.reactivex.Observable
import me.baleen.kotlinDagger.data.model.UrlRes
import retrofit2.http.GET

interface GithubApiService {

  @GET("http://api.github.com")
  fun getUrlList(): Observable<UrlRes>
}