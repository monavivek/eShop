package emanage.com.eshopy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ViewFlipper;

public class Dashboard extends AppCompatActivity {
	ViewFlipper flipper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dashboard);
		getSupportActionBar().hide();
		flipper=(ViewFlipper)findViewById(R.id.flipp);
	}
}
