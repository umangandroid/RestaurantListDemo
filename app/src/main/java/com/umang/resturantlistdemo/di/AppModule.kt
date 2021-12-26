package com.umang.resturantlistdemo.di

import com.umang.resturantlistdemo.data.RestaurantRepository
import com.umang.resturantlistdemo.data.RestaurantRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    abstract fun bindRestaurantRepository(
        restaurantRepositoryImpl:  RestaurantRepositoryImpl
    ): RestaurantRepository


}