package recipe;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cookingtime.cookingtime.R;

import java.util.ArrayList;

public class RecipeRecyclerAdapter extends RecyclerView.Adapter<RecipeRecyclerAdapter.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView image;

        public ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.recipeName);
            image = view.findViewById(R.id.recipeImg);
        }
    }

    private ArrayList<Recipe> data;

    public RecipeRecyclerAdapter(ArrayList<Recipe> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_single_recipe, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.name.setText(data.get(position).getName());
        holder.image.setImageResource(data.get(position).getId()); //TODO set real image value
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}
