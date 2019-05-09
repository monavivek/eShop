package emanage.com.eshopy.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import emanage.com.eshopy.R;

public class Display extends AppCompatActivity implements View.OnClickListener {
	Button Login, Register, Guest_user;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display);
		getSupportActionBar().hide();
		Login = (Button) findViewById(R.id.login);
		Register = (Button) findViewById(R.id.register);
		Guest_user = (Button) findViewById(R.id.guestUser);
		Guest_user.setOnClickListener(this);
		Login.setOnClickListener(this);
		Register.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.login:
				Intent intent1=new Intent(Display.this,Login.class);
				startActivity(intent1);
				finish();
				break;

			case R.id.register:
				Intent intent2=new Intent(Display.this,Registration.class);
				startActivity(intent2);
				finish();
				break;

			case R.id.guestUser:
				Intent intent=new Intent(Display.this,Dashboard.class);
				startActivity(intent);
				finish();
				break;

			default:
				break;

		}
	}
}

