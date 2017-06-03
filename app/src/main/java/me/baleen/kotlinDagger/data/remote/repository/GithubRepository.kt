package me.baleen.kotlinDagger.data.remote.repository

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import me.baleen.kotlinDagger.data.model.UrlRes
import me.baleen.kotlinDagger.data.remote.service.GithubApiService
import retrofit2.Retrofit
import javax.inject.Inject

class GithubRepository @Inject constructor(retrofit: Retrofit) : GithubApiService {

  var service = retrofit.create(GithubApiService::class.java)

  override fun getUrlList(): Observable<UrlRes> {
    return service.getUrlList().subscribeOn(Schedulers.newThread())
  }
}