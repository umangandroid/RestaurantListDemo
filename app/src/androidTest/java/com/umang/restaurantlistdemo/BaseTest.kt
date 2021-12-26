package com.umang.restaurantlistdemo

import android.view.View
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import com.umang.restaurantlistdemo.ui.MainActivity
import com.umang.restaurantlistdemo.ui.viewholders.SortOptionViewHolder
import com.umang.restaurantlistdemo.utils.EspressoIdlingResource
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.AllOf
import org.junit.After
import org.junit.Before

/**
 * Common Espresso methods to use in UI/Integration tests
 */
open class BaseTest {
    private fun launchActivity(): ActivityScenario<MainActivity>? {
        return ActivityScenario.launch(MainActivity::class.java)
    }

    @Before
    fun setup() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.countingIdlingResource)
        launchActivity()
    }

    @After
    fun unregisterIdlingResources() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.countingIdlingResource)

    }

    /**
     * To type characters one by one in edit text
     */
    fun fillEditText(resId: Int, text: String?) {
        Espresso.onView(ViewMatchers.withId(resId))
            .perform(ViewActions.typeText(text), ViewActions.closeSoftKeyboard())
    }

    fun clearEditTextBox(resId: Int) {
        Espresso.onView(ViewMatchers.withId(resId))
            .perform(ViewActions.clearText())
    }

    fun verifyViewWithText(text: String) {
        Espresso.onView(ViewMatchers.withText(text))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    fun clickView(id: Int) {
        Espresso.onView(ViewMatchers.withId(id))
            .perform(ViewActions.click())
    }

    /**
     * To Verify text in [RecyclerView] for particular item
     */
    fun verifyViewInList(listId: Int, itemPosition: Int, text: String?) {
        Espresso.onView(ViewMatchers.withId(listId)).perform(
            RecyclerViewActions.actionOnItemAtPosition<SortOptionViewHolder>(
                itemPosition,
                ViewActions.scrollTo()
            )
        )
            .check(
                ViewAssertions.matches(
                    ViewMatchers.hasDescendant(
                        ViewMatchers.withText(
                            text
                        )
                    )
                )
            )
    }

    /**
     * To check visibility of view in [RecyclerView] for particular item
     */
    fun verifyViewShowInList(listId: Int, itemPosition: Int, viewId: Int) {
        Espresso.onView(Matchers.allOf(ViewMatchers.isDisplayed(), ViewMatchers.withId(listId)))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    itemPosition,
                    ViewActions.scrollTo()
                )
            )
            .check(
                ViewAssertions.matches(
                    ViewMatchers.hasDescendant(
                        Matchers.allOf(
                            ViewMatchers.withId(
                                viewId
                            ), ViewMatchers.isDisplayed()
                        )
                    )
                )
            )
    }

    /**
     * To click [RecyclerView] item
     */
    fun clickOnListItemView(position: Int, view: Int, listId: Int) {
        Espresso.onView(ViewMatchers.withId(listId))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    position,
                    RecyclerViewAction.clickChildViewWithId(view)
                )
            )
    }

    fun getCountFromRecyclerView(@IdRes RecyclerViewId: Int): Int {
        val count = intArrayOf(0)
        val matcher: Matcher<View> = object : TypeSafeMatcher<View>() {
            override fun matchesSafely(item: View): Boolean {
                count[0] = (item as RecyclerView).adapter!!.itemCount
                return true
            }

            override fun describeTo(description: Description) {}
        }
        try {
            Espresso.onView(
                AllOf.allOf(
                    ViewMatchers.withId(RecyclerViewId),
                    ViewMatchers.isDisplayed()
                )
            ).check(
                ViewAssertions.matches(
                    matcher
                )
            )
        } catch (e: Exception) {
            count[0] = 0
        }
        return count[0]
    }
}