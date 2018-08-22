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
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class FeaturedStreamActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void streamsActivityTest() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.buttonTopFeaturedStreams), withText("Top Featured Streams"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.constraint.ConstraintLayout")),
                                        0),
                                1),
                        isDisplayed()));
        appCompatButton.perform(click());

//        ViewInteraction linearLayout = onView(
//                allOf(childAtPosition(
//                        childAtPosition(
//                                IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
//                                0),
//                        1),
//                        isDisplayed()));
//        linearLayout.check(matches(isDisplayed()));
//
//        ViewInteraction relativeLayout = onView(
//                allOf(childAtPosition(
//                        childAtPosition(
//                                IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
//                                0),
//                        0),
//                        isDisplayed()));
//        relativeLayout.check(matches(isDisplayed()));
//
//        ViewInteraction relativeLayout2 = onView(
//                allOf(childAtPosition(
//                        childAtPosition(
//                                IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
//                                0),
//                        0),
//                        isDisplayed()));
//        relativeLayout2.check(matches(isDisplayed()));
//
//        ViewInteraction recyclerView = onView(
//                allOf(withId(R.id.gamesRecyclerView),
//                        childAtPosition(
//                                withId(R.id.swipeLayout),
//                                0)));
//        recyclerView.perform(actionOnItemAtPosition(0, click()));
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
//        ViewInteraction scrollView = onView(
//                allOf(withId(R.id.scrollViewContent),
//                        childAtPosition(
//                                childAtPosition(
//                                        withId(android.R.id.content),
//                                        0),
//                                1),
//                        isDisplayed()));
//        scrollView.check(matches(isDisplayed()));
//
//        ViewInteraction textView3 = onView(
//                allOf(withId(R.id.nameTextView), withText("dota2ti_ru"),
//                        childAtPosition(
//                                allOf(withId(R.id.mainContent),
//                                        childAtPosition(
//                                                withId(R.id.scrollViewContent),
//                                                0)),
//                                1),
//                        isDisplayed()));
//        textView3.check(matches(withText("dota2ti_ru")));
//
//        ViewInteraction textView4 = onView(
//                allOf(withId(R.id.gameNameTextView), withText("Currently playing: Dota 2"),
//                        childAtPosition(
//                                allOf(withId(R.id.mainContent),
//                                        childAtPosition(
//                                                withId(R.id.scrollViewContent),
//                                                0)),
//                                2),
//                        isDisplayed()));
//        textView4.check(matches(withText("Currently playing: Dota 2")));
//
//        ViewInteraction textView5 = onView(
//                allOf(withId(R.id.channelTextView), withText("Number of active followers: 365562"),
//                        childAtPosition(
//                                allOf(withId(R.id.mainContent),
//                                        childAtPosition(
//                                                withId(R.id.scrollViewContent),
//                                                0)),
//                                3),
//                        isDisplayed()));
//        textView5.check(matches(withText("Number of active followers: 365562")));
//
//        ViewInteraction textView6 = onView(
//                allOf(withId(R.id.viewerTextView), withText("Number of viewers: 230630"),
//                        childAtPosition(
//                                allOf(withId(R.id.mainContent),
//                                        childAtPosition(
//                                                withId(R.id.scrollViewContent),
//                                                0)),
//                                4),
//                        isDisplayed()));
//        textView6.check(matches(withText("Number of viewers: 230630")));
//
//        ViewInteraction textView7 = onView(
//                allOf(withId(R.id.positionTextView), withText("Position: 1"),
//                        childAtPosition(
//                                allOf(withId(R.id.mainContent),
//                                        childAtPosition(
//                                                withId(R.id.scrollViewContent),
//                                                0)),
//                                5),
//                        isDisplayed()));
//        textView7.check(matches(withText("Position: 1")));
//
//        ViewInteraction textView8 = onView(
//                allOf(withId(R.id.positionTextView), withText("Position: 1"),
//                        childAtPosition(
//                                allOf(withId(R.id.mainContent),
//                                        childAtPosition(
//                                                withId(R.id.scrollViewContent),
//                                                0)),
//                                5),
//                        isDisplayed()));
//        textView8.check(matches(withText("Position: 1")));

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
