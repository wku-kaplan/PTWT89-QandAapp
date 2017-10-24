package sg.com.kaplan.qandaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 123;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            String reply = data.getExtras().getString("reply");
            TextView replyText = (TextView) findViewById(R.id.ReplyText);
            replyText.setText(reply);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText questionText = (EditText) findViewById(R.id.QuestionText);

        Button button = (Button) findViewById(R.id.AskButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String question = questionText.getText().toString();
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                i.putExtra("question", question);
                startActivityForResult(i, REQUEST_CODE);
            }
        });
    }
}
