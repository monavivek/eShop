package emanage.com.eshopy.Activity;

import android.app.ProgressDialog;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import emanage.com.eshopy.Adapter.RecyclerAdapter;
import emanage.com.eshopy.App.Config;
import emanage.com.eshopy.Pojo.Product_Pojo;
import emanage.com.eshopy.R;

public class Dashboard extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener{

	SliderLayout sliderLayout;
	HashMap<String,String> Hash_file_maps ;
	RecyclerView recyclerView;
	String url="http://10.0.0.116/adminPanel/product_list_api.php";

	RequestQueue requestQueue;
	private List<Product_Pojo> productList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dashboard);
		requestQueue=Volley.newRequestQueue(this);
		getSupportActionBar().hide();
		recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
		recyclerView.setHasFixedSize(true);
		//recyclerView.setLayoutManager(new LinearLayoutManager(this));
		RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
		recyclerView.setLayoutManager(mLayoutManager);
		Hash_file_maps = new HashMap<String, String>();
		sliderLayout = (SliderLayout)findViewById(R.id.slider);
		productList = new ArrayList<>();
		final ProgressDialog pDialog = new ProgressDialog(this);
		pDialog.setMessage("Loading...");
		pDialog.show();
		StringRequest stringRequest = new StringRequest(Request.Method.GET, url
				, new Response.Listener<String>() {
			@Override
			public void onResponse(String response) {
				try {

					//getting the whole json object from the response
					JSONObject obj = new JSONObject(response);
					System.out.println("url "+url);
						Log.i("respones", String.valueOf(obj));

					//we have the array named hero inside the object
					//so here we are getting that json array
					JSONArray heroArray = obj.getJSONArray("data");
					Log.i("heroArray", String.valueOf(heroArray));
					//now looping through all the elements of the json array
					for (int i = 0; i < heroArray.length(); i++) {
						//getting the json object of the particular index inside the array
						JSONObject jsonObject = heroArray.getJSONObject(i);
						System.out.println("jsonObject"+jsonObject);
						//creating a hero object and giving them the values from json object
						Product_Pojo hero = new Product_Pojo(jsonObject.getString("product_name"),jsonObject.getString("discription"),jsonObject.getString("price"),jsonObject.getString("image"));
						//adding the hero to herolist
						productList.add(hero);
					}
					//creating custom adapter object
					RecyclerAdapter adapter = new RecyclerAdapter(productList, getApplicationContext());
					//adding the adapter to listview
					recyclerView.setAdapter(adapter);
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
			}, new Response.ErrorListener() {
				@Override
				public void onErrorResponse(VolleyError error) {
					//displaying the error in toast if occurrs
					Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
				}
		});
		requestQueue.add(stringRequest);
//		JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,url
//				, null,
//				new Response.Listener<JSONObject>() {
//
//					@Override
//					public void onResponse(JSONObject response) {
//
//						pDialog.hide();
//					}
//				}, new Response.ErrorListener() {
//
//			@Override
//			public void onErrorResponse(VolleyError error) {
//				//VolleyLog.d(TAG, "Error: " + error.getMessage());
//				// hide the progress dialog
//				pDialog.hide();
//			}
//		});
//		requestQueue.add();
//		productList.add(new Product_Pojo("Chapter One","Item one details","100/-",R.drawable.ga));
//		productList.add(new Product_Pojo("Chapter Two","Item two details","200/-",R.drawable.gaa));
//		productList.add(new Product_Pojo("Chapter three","Item three details","300/-",R.drawable.gaaaa));
//		productList.add(new Product_Pojo("Chapter Four","Item four details","400/-",R.drawable.ga));
//		productList.add(new Product_Pojo("Chapter Five","Item five details","500/-",R.drawable.gaa));
//		productList.add(new Product_Pojo("Chapter Six","Item six details","600/-",R.drawable.gaaaa));
//		productList.add(new Product_Pojo("Chapter Seven","Item seven details","700/-",R.drawable.ga));
		Hash_file_maps.put("Android CupCake", "https://tineye.com/images/widgets/mona.jpg");
		Hash_file_maps.put("Android Donut", "https://tineye.com/images/widgets/mona.jpg");
		Hash_file_maps.put("Android Eclair", "https://tineye.com/images/widgets/mona.jpg");
		Hash_file_maps.put("Android Froyo", "https://tineye.com/images/widgets/mona.jpg");
		Hash_file_maps.put("Android GingerBread", "https://tineye.com/images/widgets/mona.jpg");
//		RecyclerAdapter adapter=new RecyclerAdapter(productList,this);
//		recyclerView.setAdapter(adapter);
		for(String name : Hash_file_maps.keySet()){
			TextSliderView textSliderView = new TextSliderView(Dashboard.this);
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
