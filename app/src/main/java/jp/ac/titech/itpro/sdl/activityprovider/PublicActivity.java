package jp.ac.titech.itpro.sdl.activityprovider;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class PublicActivity extends AppCompatActivity {

    TextView requestView;
    RadioGroup answerGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public);
        requestView = (TextView)findViewById(R.id.request_view);
        answerGroup = (RadioGroup)findViewById(R.id.answer_group);
        answerGroup.check(R.id.answer_1);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        String request = intent.getStringExtra("request");
        requestView.setText(request);
    }

    public void onClickReturnButton(View view) {
        String answer = null;
        switch (answerGroup.getCheckedRadioButtonId()) {
            case R.id.answer_1:
                answer = getString(R.string.answer_1_text);
                break;
            case R.id.answer_2:
                answer = getString(R.string.answer_2_text);
                break;
            case R.id.answer_3:
                answer = getString(R.string.answer_3_text);
                break;
            case R.id.answer_4:
                answer = getString(R.string.answer_4_text);
                break;
        }
        Intent data = new Intent();
        data.putExtra("answer", answer);
        setResult(RESULT_OK, data);
        finish();
    }
}
