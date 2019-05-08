package emanage.com.eshopy.App;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import emanage.com.eshopy.Pojo.Product_Pojo;
import emanage.com.eshopy.R;
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
	private List<Product_Pojo> productList;
	private Context mCtx;

	public RecyclerAdapter(List<Product_Pojo> productList, Context mCtx) {
		this.productList = productList;
		this.mCtx = mCtx;
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
		Product_Pojo pojo=productList.get(i);
		viewHolder.itemTitle.setText(pojo.getTitle());
		viewHolder.itemDetail.setText(pojo.getDetils());
		viewHolder.itemImage.setImageDrawable(mCtx.getResources().getDrawable(pojo.getImage()));
		viewHolder.price.setText(pojo.getPrice());
	}


	@Override
	public int getItemCount() {
		return productList.size();
	}
	class ViewHolder extends RecyclerView.ViewHolder{

		public ImageView itemImage;
		public TextView itemTitle;
		public TextView itemDetail;
		public  TextView price;

		public ViewHolder(View itemView) {
			super(itemView);
			itemImage = (ImageView)itemView.findViewById(R.id.item_image);
			itemTitle = (TextView)itemView.findViewById(R.id.item_title);
			itemDetail = (TextView)itemView.findViewById(R.id.item_detail);
			price=(TextView)itemView.findViewById(R.id.price);

			itemView.setOnClickListener(new View.OnClickListener() {
				@Override public void onClick(View v) {
					int position = getAdapterPosition();

					Snackbar.make(v, "Click detected on item " + position,
							Snackbar.LENGTH_LONG)
							.setAction("Action", null).show();

				}
			});
		}
	}


}