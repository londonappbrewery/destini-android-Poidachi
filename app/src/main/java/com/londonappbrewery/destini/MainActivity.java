package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Console;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private TextView mStoryTextView;
    private Button mTopButton;
    private Button mBottomButton;
    private int mStoryIndex;
    private int mEndingIndex;
    private boolean mEndingFlag;

    private StoryTeller[] mStoryBank = new StoryTeller[]{
            new StoryTeller(R.string.T1_Story, R.string.T1_Ans1, R.string.T1_Ans2),
            new StoryTeller(R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2),
            new StoryTeller(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2)
    };

    private int[] mEndings = new int[]{
            R.string.T4_End,
            R.string.T5_End,
            R.string.T6_End
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = (TextView) findViewById(R.id.storyTextView);
        mTopButton = (Button) findViewById(R.id.buttonTop);
        mBottomButton = (Button) findViewById(R.id.buttonBottom);

        mStoryIndex = 0;
        mEndingIndex = 0;
        mEndingFlag = false;
        mStoryTextView.setText(mStoryBank[mStoryIndex].getStoryText());
        mTopButton.setText(mStoryBank[mStoryIndex].getTopButtonText());
        mBottomButton.setText(mStoryBank[mStoryIndex].getBottomButtonText());

        Log.d(getClass().getName(), "val = " + mStoryBank[mStoryIndex].getStoryText());
        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mStoryIndex == 0 || mStoryIndex == 1)
                {
                    mStoryIndex = 2;
                }
                else if (mStoryIndex == -1)
                {
                    finish();
                }
                else
                {
                    mEndingFlag = true;
                    mEndingIndex = 2;
                }
                updateLevel();
            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mBottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mStoryIndex == 0)
                {
                    mStoryIndex = 1;
                }
                else if (mStoryIndex == 1)
                {
                    mEndingFlag = true;
                    mEndingIndex = 0;
                }
                else if (mStoryIndex == -1)
                {
                    finish();
                }
                else
                {
                    mEndingFlag = true;
                    mEndingIndex = 1;
                }
                updateLevel();
            }
        });

    }

    public void updateLevel()
    {
        if (mEndingFlag != true)
        {
            mStoryTextView.setText(mStoryBank[mStoryIndex].getStoryText());
            mTopButton.setText(mStoryBank[mStoryIndex].getTopButtonText());
            mBottomButton.setText(mStoryBank[mStoryIndex].getBottomButtonText());
        }
        else
        {
            mStoryTextView.setText(mEndings[mEndingIndex]);
            mTopButton.setText("Exit");
            mBottomButton.setText("Exit");
            mStoryIndex = -1;
        }
    }
}
