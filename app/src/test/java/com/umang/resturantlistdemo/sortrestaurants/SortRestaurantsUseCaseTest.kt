package com.umang.resturantlistdemo.sortrestaurants

import com.umang.resturantlistdemo.datasource.FakeRepository
import com.umang.resturantlistdemo.domain.model.SortOption
import com.umang.resturantlistdemo.domain.usecase.SortRestaurantsUseCase
import com.umang.resturantlistdemo.ui.viewmodels.SearchRestaurantsViewModel
import com.umang.resturantlistdemo.utils.*
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 *  Unit test implementation for [SortRestaurantsUseCase]
 *  Verify results received from RestaurantDataSource with sort applied with restaurant status and sort option
 */
class SortRestaurantsUseCaseTest {

    private lateinit var sortRestaurantsUseCase: SortRestaurantsUseCase

    @Before
    fun setupUseCase(){
        sortRestaurantsUseCase = SortRestaurantsUseCase(FakeRepository())
    }

    @Test
    fun sortRestaurantsByAvgRating(){
        runBlocking {
            val results = sortRestaurantsUseCase.sortAndFormatList(SortOption("Average Rating",
                RATING_AVERAGE,true))
            Assert.assertEquals(19,results?.size)

            //verify open values
            Assert.assertEquals("Tanoshii Sushi",results?.get(0)?.name)
            Assert.assertEquals(OPEN,results?.get(0)?.status)
            Assert.assertEquals("Average Rating : 4.5",results?.get(0)?.selectedSort)

            Assert.assertEquals("Sushi One",results?.get(5)?.name)
            Assert.assertEquals(OPEN,results?.get(5)?.status)
            Assert.assertEquals("Average Rating : 4.0",results?.get(5)?.selectedSort)

            Assert.assertEquals("Lunchpakketdienst",results?.get(6)?.name)
            Assert.assertEquals(OPEN,results?.get(6)?.status)
            Assert.assertEquals("Average Rating : 3.5",results?.get(6)?.selectedSort)

            //verify order ahead values
            Assert.assertEquals("Yvonne's Vispaleis",results?.get(8)?.name)
            Assert.assertEquals(ORDER_AHEAD,results?.get(8)?.status)
            Assert.assertEquals("Average Rating : 5.0",results?.get(8)?.selectedSort)

            Assert.assertEquals("Lale Restaurant & Snackbar",results?.get(14)?.name)
            Assert.assertEquals(ORDER_AHEAD,results?.get(14)?.status)
            Assert.assertEquals("Average Rating : 0.0",results?.get(14)?.selectedSort)

            //verify closed values
            Assert.assertEquals("Tandoori Express",results?.get(15)?.name)
            Assert.assertEquals(CLOSED,results?.get(15)?.status)
            Assert.assertEquals("Average Rating : 4.5",results?.get(15)?.selectedSort)

            Assert.assertEquals("Zenzai Sushi",results?.get(18)?.name)
            Assert.assertEquals(CLOSED,results?.get(18)?.status)
            Assert.assertEquals("Average Rating : 4.0",results?.get(18)?.selectedSort)

        }
    }

    @Test
    fun sortRestaurantsByBestMatch() {
        runBlocking {
            val results = sortRestaurantsUseCase.sortAndFormatList(
                SortOption(
                    "Best Match",
                    BEST_MATCH, true
                )
            )
            val resultOpen = results?.find { it.status == OPEN }
            Assert.assertEquals("Lunchpakketdienst",resultOpen?.name)
            Assert.assertEquals("Best Match : 306.0",resultOpen?.selectedSort)

            val resultOrderAhead = results?.find { it.status == ORDER_AHEAD }
            Assert.assertEquals("Lale Restaurant & Snackbar",resultOrderAhead?.name)
            Assert.assertEquals("Best Match : 305.0",resultOrderAhead?.selectedSort)

            val resultsClosed = results?.find { it.status == CLOSED }
            Assert.assertEquals("Zenzai Sushi",resultsClosed?.name)
            Assert.assertEquals("Best Match : 13.0",resultsClosed?.selectedSort)
        }
    }
}