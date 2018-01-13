package com.company.data.depressionmetre;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    String questions[] = {"Q1\n I feel downhearted and blue",
            "Q2\n Morning is when I feel the best",
            "Q3\n I have crying spell or feel like it",
            "Q4\n I have trouble sleeping at night",
            "Q5\n I eat as much I used to",
            "Q6\n I notice that I am losing weight",
            "Q7\n My heart beats faster than usual",
            "Q8\n I get tired for no reason",
            "Q9\n My mind is clear as it used to be",
            "Q10\n I find it easy to the things i used ton",
            "Q11\n i am restless and can't keep still.",
            "Q12\n I feel hopeless about the future.",
            "Q13\n I am more irritable then Usual.",
            "Q14\n I find it easy to make Decision.",
            "Q15\n I feel that i'm usefull and needed.",
            "Q16\n My life is prettyfull.",
            "Q17\n I feel that others would be better off i were dead",
            "Q18\n I still enjoy the thing i Used to",

};
    int uAns = 0, r = 0;


    TextView q;
    RadioButton r0, r1, r2, r3;
    Button b;
    static int cnt = 0;


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }


    public void MyClick(View v) {
        setContentView(R.layout.displayquestion);
        q = (TextView) findViewById(R.id.q);
        r0 = (RadioButton) findViewById(R.id.radio0);
        r1 = (RadioButton) findViewById(R.id.radio1);
        r2 = (RadioButton) findViewById(R.id.radio2);
        r3 = (RadioButton) findViewById(R.id.radio3);
        b = (Button) findViewById(R.id.button1);
        showQ();
    }

    public void showQ() {
        r0.setChecked(false);
        r1.setChecked(false);
        r2.setChecked(false);
        r3.setChecked(false);
        q.setText(questions[cnt]);
        r0.setText("None of the time");
        r1.setText("Some of the time ");
        r2.setText("A good part of the time");
        r3.setText("Most of the time");
        if (cnt <= 16) {
            b.setText("Next");
        } else {
            b.setText("Finish");
        }
    }

    public void myClickHandler(View view) {

        if (!(b.getText().equals("Finish"))) {
            if (cnt == 1 || cnt == 3 || cnt == 4 || cnt == 7 || cnt == 8 || cnt == 9 || cnt == 10 || cnt == 13 || cnt == 15 || cnt == 19) {
                if (r0.isChecked()) {
                    uAns = uAns + 1;
                }
                if (r1.isChecked()) {
                    uAns = uAns + 2;
                }
                if (r2.isChecked()) {
                    uAns = uAns + 3;
                }
                if (r3.isChecked()) {
                    uAns = uAns + 4;
                }
            } else if (cnt == 2 || cnt == 5 || cnt == 6 || cnt == 11 || cnt == 12 || cnt == 14 || cnt == 16 || cnt == 17 || cnt == 18 || cnt == 20) {
                if (r0.isChecked()) {
                    uAns = uAns + 4;
                }
                if (r1.isChecked()) {
                    uAns = uAns + 3;
                }
                if (r2.isChecked()) {
                    uAns = uAns + 2;
                }
                if (r3.isChecked()) {
                    uAns = uAns + 1;
                }

            }
//            if (uAns == n[cnt]) {
//                r++;
//            }

            cnt++;
            showQ();
        } else {
            setContentView(R.layout.finish);
            TextView res = (TextView) findViewById(R.id.res);


            res.setText("Depression Result : \n" +
                    "Normal (Less then 50) \n" +
                    "Minimal to mild(50-59)\n" +
                    "Moderate to Severe(60-69)\n" +
                    "Severe(70 or more)\n\n\n\t"
                    + "Your result is :" + String.valueOf(uAns)
            );


            b.setText("Test Complte");
        }
    }

    public void ShowVideo(View view) {

        setContentView(R.layout.showvideo);
        getWindow().setFormat(PixelFormat.UNKNOWN);

        VideoView mVideoView = (VideoView) findViewById(R.id.videoview);
        String uriPath = "android.resource://com.android.AndroidVideoPlayer/" + R.raw.a;

        Uri uri = Uri.parse(uriPath);
        mVideoView.setVideoURI(uri);
        mVideoView.requestFocus();
        mVideoView.start();
    }


}
