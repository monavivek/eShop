package emanage.com.eshopy.Adapter;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.List;
import emanage.com.eshopy.Activity.ProductActivity;
import emanage.com.eshopy.Pojo.Product_Pojo;
import emanage.com.eshopy.R;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
	private List<Product_Pojo> productList;
	private Context mCtx;

	String image_url="http://10.0.0.116/adminPanel/images/";

	public RecyclerAdapter(List<Product_Pojo> productList, Context mCtx) {
		this.productList = productList;
		this.mCtx = mCtx;
	}

	class ViewHolder extends RecyclerView.ViewHolder{

		public ImageView itemImage;
		public TextView itemTitle;
		public TextView itemDetail;
		public  TextView price;
		CardView cardView;


		public ViewHolder(View itemView) {
			super(itemView);
			itemImage = (ImageView)itemView.findViewById(R.id.item_image);
			itemTitle = (TextView)itemView.findViewById(R.id.item_title);
			itemDetail = (TextView)itemView.findViewById(R.id.item_detail);
			price=(TextView)itemView.findViewById(R.id.price);
			cardView=(CardView)itemView.findViewById(R.id.card_view);
//			Picasso.with(mCtx)
//					.load("http://10.0.0.116/adminPanel/images/")
//					// optional
//					.resize(400,400)                        // optional
//					.into(itemImage);

//			itemView.setOnClickListener(new View.OnClickListener() {
//				@Override public void onClick(View v) {
//					int position = getAdapterPosition();
//					//Intent intent=new Intent(mCtx,Registration.class);
//					Intent intent=new Intent(mCtx,ProductActivity.class);
//					v.getContext().startActivity(new Intent(v.getContext(), ProductActivity.class));
//					Snackbar.make(v, "Click detected on item " + position,
//							Snackbar.LENGTH_LONG)
//							.setAction("Action", null).show();
//
//				}
//			});
		}
	}
	@Override
	public ViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
		View v = LayoutInflater.from(viewGroup.getContext())
				.inflate(R.layout.card_layout, viewGroup, false);
		ViewHolder viewHolder = new ViewHolder(v);
		return viewHolder;
	}

	@Override
	public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
		final Product_Pojo pojo=productList.get(i);
		viewHolder.itemTitle.setText(pojo.getTitle());
		viewHolder.itemDetail.setText(pojo.getDetils());
		Picasso.with(mCtx).load(image_url+pojo.getImage()).into(viewHolder.itemImage);
		viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(mCtx, ProductActivity.class);
				intent.putExtra("title",pojo.getTitle());
				intent.putExtra("detail",pojo.getDetils());
				intent.putExtra("image",pojo.getImage());
				mCtx.startActivity(intent);
			}
		});

		//viewHolder.itemImage.setImageDrawable(mCtx.getResources().getDrawable(pojo.getImage()));


		viewHolder.price.setText(pojo.getPrice());
	}
	@Override
	public int getItemCount() {
		return productList.size();

	}
}