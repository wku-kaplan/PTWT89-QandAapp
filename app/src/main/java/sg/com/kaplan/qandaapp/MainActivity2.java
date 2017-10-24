package sg.com.kaplan.qandaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView questionText = (TextView) findViewById(R.id.QuestionText);

        Bundle extras = getIntent().getExtras();
        if(extras == null) {
            return;
        } else {
            String question = extras.getString("question");
            questionText.setText(question);
        }

        Button button = (Button) findViewById(R.id.AnswerButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText replyText = (EditText) findViewById(R.id.ReplyText);
                String reply = replyText.getText().toString();
                Intent i = new Intent();
                i.putExtra("reply", reply);
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }
}
