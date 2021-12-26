package com.umang.resturantlistdemo.datasource

import android.content.Context
import com.umang.resturantlistdemo.data.RestaurantDataSource
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock

class RestaurantDataSourceTest {
    private lateinit var restaurantDataSource: RestaurantDataSource
    private var context: Context = mock()

    @Before
    fun setup() {
        restaurantDataSource = Mockito.spy(RestaurantDataSource(context)) //spy helps to mock particular methods in class
    }


    @Test
    fun getBaseListTest() {
        doReturn(responseString).`when`(restaurantDataSource).getJsonDataFromAsset()
        val list = restaurantDataSource.getBaseList()
        Assert.assertEquals(19,list?.size)
    }


}