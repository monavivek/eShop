package emanage.com.eshopy.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

import emanage.com.eshopy.R;

public class ProductActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener{
	RecyclerView recyclerView;
	SliderLayout sliderLayout;
	HashMap<String,String> Hash_file_maps ;
	TextView title,detail;
	ImageView image;
	Button cart,buy;
	String image_url="http://10.0.0.116/adminPanel/images/";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_product);
		Intent intent = getIntent();
		title=(TextView)findViewById(R.id.showtitle) ;
		image=(ImageView)findViewById(R.id.showimage);
		detail=(TextView)findViewById(R.id.detail);

		String title1 = intent.getStringExtra("title");
		String detail1=intent.getStringExtra("detail");
		String image1=intent.getStringExtra("image");
		System.out.println("title="+title1);

		title.setText(title1);
		detail.setText(detail1);

		Picasso.with(getApplication()).load(image_url+image1).into(image);

		getSupportActionBar().hide();
		Hash_file_maps = new HashMap<String, String>();
		sliderLayout = (SliderLayout)findViewById(R.id.slider1);
		recyclerView = (RecyclerView) findViewById(R.id.recycler_view1);
//		cart=(Button)findViewById(R.id.cart);
//		buy=(Button)findViewById(R.id.buy);
		Hash_file_maps.put("Android CupCake", "https://tineye.com/images/widgets/mona.jpg");
		Hash_file_maps.put("Android Donut", "https://tineye.com/images/widgets/mona.jpg");
		Hash_file_maps.put("Android Eclair", "https://tineye.com/images/widgets/mona.jpg");
		Hash_file_maps.put("Android Froyo", "https://tineye.com/images/widgets/mona.jpg");
		Hash_file_maps.put("Android GingerBread", "https://tineye.com/images/widgets/mona.jpg");
//		final Animation animation = new TranslateAnimation(0,0,100,0);
//// set Animation for 5 sec
//		animation.setDuration(5000);
////for button stops in the new position.
//		animation.setFillAfter(true);
//		cart.startAnimation(animation);

		for(String name : Hash_file_maps.keySet()){

			TextSliderView textSliderView = new TextSliderView(ProductActivity.this);
			textSliderView
					.description(name)
					.image(Hash_file_maps.get(name))
					.setScaleType(BaseSliderView.ScaleType.Fit)
					.setOnSliderClickListener(this);
			textSliderView.bundle(new Bundle());
			textSliderView.getBundle()
					.putString("extra",name);
			sliderLayout.addSlider(textSliderView);
		}
		sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
		sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
		sliderLayout.setCustomAnimation(new DescriptionAnimation());
		sliderLayout.setDuration(3000);
		sliderLayout.addOnPageChangeListener(this);
	}
	@Override
	protected void onStop() {
		sliderLayout.stopAutoCycle();
		super.onStop();
	}

	@Override
	public void onSliderClick(BaseSliderView slider) {

		Toast.makeText(this,slider.getBundle().get("extra") + "",Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

	@Override
	public void onPageSelected(int position) {

		Log.d("Slider Demo", "Page Changed: " + position);
	}

	@Override
	public void onPageScrollStateChanged(int state) {

	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_card_demo, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}

