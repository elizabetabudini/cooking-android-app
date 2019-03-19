package fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cookingtime.cookingtime.R;

import java.util.ArrayList;

import recipe.Recipe;
import recipe.RecipeRecyclerAdapter;

public class FavouriteFragment extends Fragment {
    protected RecyclerView recyclerView;
    protected RecipeRecyclerAdapter adapter;

    /**
     * Required empty public constructor.
     */
    public FavouriteFragment() {
    }

    /**
     * Creates a new instance of this Fragment using the provided user name.
     */
    public static FavouriteFragment newInstance() {
        // Create a new instance of the Fragment
        return new FavouriteFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_favourites, container, false);

        recyclerView = rootView.findViewById(R.id.favouriteRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter = new RecipeRecyclerAdapter(getMockRecipes(), getActivity());
        recyclerView.setAdapter(adapter);

        return rootView;
    }

    private ArrayList<Recipe> getMockRecipes() {
        ArrayList<Recipe> data = new ArrayList<>();
        Recipe recipe = new Recipe();
        recipe.setName("Meat Loaf Dinner");
        recipe.setId(384149);
        recipe.setUrl("https://spoonacular.com/recipes/meat-loaf-dinner-384149");
        data.add(recipe);

        recipe = new Recipe();
        recipe.setName("Blueberry Loaf");
        recipe.setId(635486);
        recipe.setUrl("https://spoonacular.com/recipes/blueberry-loaf-635486");
        data.add(recipe);

        recipe = new Recipe();
        recipe.setName("Meat Loaf Dinner");
        recipe.setId(384149);
        recipe.setUrl("https://spoonacular.com/recipes/meat-loaf-dinner-384149");
        data.add(recipe);

        recipe = new Recipe();
        recipe.setName("Blueberry Loaf");
        recipe.setId(635486);
        recipe.setUrl("https://spoonacular.com/recipes/blueberry-loaf-635486");
        data.add(recipe);

        return data;
    }
}
