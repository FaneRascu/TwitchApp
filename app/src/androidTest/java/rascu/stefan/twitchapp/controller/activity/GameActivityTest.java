package rascu.stefan.twitchapp.controller.activity;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import rascu.stefan.twitchapp.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class GameActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void gameActivityTest() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.buttonTopGames), withText("Top Games"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.constraint.ConstraintLayout")),
                                        0),
                                3),
                        isDisplayed()));
        appCompatButton.perform(click());

//        ViewInteraction recyclerView = onView(
//                allOf(withId(R.id.gamesRecyclerView),
//                        childAtPosition(
//                                withId(R.id.swipeLayout),
//                                0)));
//        recyclerView.perform(actionOnItemAtPosition(0, click()));
//
//        ViewInteraction appCompatButton2 = onView(
//                allOf(withId(R.id.buttonTopGames), withText("Top Games"),
//                        childAtPosition(
//                                childAtPosition(
//                                        withClassName(is("android.support.constraint.ConstraintLayout")),
//                                        0),
//                                3),
//                        isDisplayed()));
//        appCompatButton2.perform(click());
//
//        ViewInteraction linearLayout = onView(
//                allOf(childAtPosition(
//                        childAtPosition(
//                                IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
//                                0),
//                        1),
//                        isDisplayed()));
//        linearLayout.check(matches(isDisplayed()));
//
//        ViewInteraction textView = onView(
//                allOf(withId(R.id.nameTextView), withText("Dota 2"),
//                        childAtPosition(
//                                childAtPosition(
//                                        IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class),
//                                        1),
//                                0),
//                        isDisplayed()));
//        textView.check(matches(withText("Dota 2")));
//
//        ViewInteraction textView2 = onView(
//                allOf(withId(R.id.positionTextView), withText("Position: 1"),
//                        childAtPosition(
//                                childAtPosition(
//                                        IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class),
//                                        1),
//                                1),
//                        isDisplayed()));
//        textView2.check(matches(withText("Position: 1")));
//
//        ViewInteraction imageView = onView(
//                allOf(withId(R.id.contentImageView),
//                        childAtPosition(
//                                childAtPosition(
//                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
//                                        0),
//                                0),
//                        isDisplayed()));
//        imageView.check(matches(isDisplayed()));
//
//        ViewInteraction frameLayout = onView(
//                allOf(childAtPosition(
//                        allOf(withId(R.id.gamesRecyclerView),
//                                childAtPosition(
//                                        withId(R.id.swipeLayout),
//                                        0)),
//                        0),
//                        isDisplayed()));
//        frameLayout.check(matches(isDisplayed()));
//
//        ViewInteraction frameLayout2 = onView(
//                allOf(childAtPosition(
//                        allOf(withId(R.id.gamesRecyclerView),
//                                childAtPosition(
//                                        withId(R.id.swipeLayout),
//                                        0)),
//                        0),
//                        isDisplayed()));
//        frameLayout2.check(matches(isDisplayed()));
//
//        ViewInteraction recyclerView2 = onView(
//                allOf(withId(R.id.gamesRecyclerView),
//                        childAtPosition(
//                                withId(R.id.swipeLayout),
//                                0)));
//        recyclerView2.perform(actionOnItemAtPosition(2, click()));
//
//        ViewInteraction imageView2 = onView(
//                allOf(withId(R.id.contentImageView),
//                        childAtPosition(
//                                allOf(withId(R.id.mainContent),
//                                        childAtPosition(
//                                                withId(R.id.scrollViewContent),
//                                                0)),
//                                0),
//                        isDisplayed()));
//        imageView2.check(matches(isDisplayed()));
//
//        ViewInteraction textView3 = onView(
//                allOf(withId(R.id.nameTextView), withText("World of Warcraft"),
//                        childAtPosition(
//                                allOf(withId(R.id.mainContent),
//                                        childAtPosition(
//                                                withId(R.id.scrollViewContent),
//                                                0)),
//                                1),
//                        isDisplayed()));
//        textView3.check(matches(withText("World of Warcraft")));
//
//        ViewInteraction textView4 = onView(
//                allOf(withId(R.id.viewerTextView), withText("Number of viewers: 111207"),
//                        childAtPosition(
//                                allOf(withId(R.id.mainContent),
//                                        childAtPosition(
//                                                withId(R.id.scrollViewContent),
//                                                0)),
//                                3),
//                        isDisplayed()));
//        textView4.check(matches(withText("Number of viewers: 111207")));
//
//        ViewInteraction textView5 = onView(
//                allOf(withId(R.id.channelTextView), withText("Number of active channels: 3326"),
//                        childAtPosition(
//                                allOf(withId(R.id.mainContent),
//                                        childAtPosition(
//                                                withId(R.id.scrollViewContent),
//                                                0)),
//                                2),
//                        isDisplayed()));
//        textView5.check(matches(withText("Number of active channels: 3326")));
//
//        ViewInteraction textView6 = onView(
//                allOf(withId(R.id.positionTextView), withText("Position: 3"),
//                        childAtPosition(
//                                allOf(withId(R.id.mainContent),
//                                        childAtPosition(
//                                                withId(R.id.scrollViewContent),
//                                                0)),
//                                4),
//                        isDisplayed()));
//        textView6.check(matches(withText("Position: 3")));

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
