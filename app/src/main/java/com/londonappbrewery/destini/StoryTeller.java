package com.londonappbrewery.destini;

/**
 * Created by dream on 12/13/2017.
 */

public class StoryTeller {

    private int mStoryText;
    private int mTopButtonText;
    private int mBottomButtonText;

    public StoryTeller(int storyText, int topButtonText, int bottomButtonText)
    {
        mStoryText = storyText;
        mTopButtonText = topButtonText;
        mBottomButtonText = bottomButtonText;
    }

    public int getStoryText() {
        return mStoryText;
    }

    public void setStoryText(int storyText) {
        mStoryText = storyText;
    }

    public int getTopButtonText() {
        return mTopButtonText;
    }

    public void setTopButtonText(int topButtonText) {
        mTopButtonText = topButtonText;
    }

    public int getBottomButtonText() {
        return mBottomButtonText;
    }

    public void setBottomButtonText(int bottomButtonText) {
        mBottomButtonText = bottomButtonText;
    }
}
