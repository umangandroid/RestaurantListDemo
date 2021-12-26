package com.umang.restaurantlistdemo.di

import com.umang.restaurantlistdemo.data.RestaurantRepository
import com.umang.restaurantlistdemo.data.RestaurantRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    abstract fun bindRestaurantRepository(
        restaurantRepositoryImpl:  RestaurantRepositoryImpl
    ): RestaurantRepository


}