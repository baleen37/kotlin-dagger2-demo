package me.baleen.kotlinDagger.di.module

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import me.baleen.kotlinDagger.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit.SECONDS
import javax.inject.Singleton

@Module
class NetModule {

  @Provides
  @Singleton
  fun provideOkHttpClient(): OkHttpClient {
    val builder = OkHttpClient.Builder()

    builder.connectTimeout(60, SECONDS)
        .readTimeout(60, SECONDS)

    return builder.build()
  }

  @Provides
  @Singleton
  fun provideRetrofit(gsonConverterFactory: GsonConverterFactory,
      rxJava2CallAdapterFactory: RxJava2CallAdapterFactory,
      okHttpClient: OkHttpClient): Retrofit {

    return Retrofit.Builder()
        .addConverterFactory(gsonConverterFactory)
        .addCallAdapterFactory(rxJava2CallAdapterFactory)
        .baseUrl(Constants.URL.GITHUB_URL)
        .client(okHttpClient)
        .build()
  }

  @Provides
  @Singleton
  fun provideRxjavaCallAdapterFactory(): RxJava2CallAdapterFactory {
    return RxJava2CallAdapterFactory.create()
  }

  @Provides
  @Singleton
  fun provideGsonConverterFactory(): GsonConverterFactory {
    return GsonConverterFactory.create(Gson())
  }
}


