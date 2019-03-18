package fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.cookingtime.cookingtime.R;

/**
 */
public class DashboardFragment extends Fragment {

    // Key to be used for the user name in this Fragment's arguments
    private static final String USERNAME = "username";

    private String userName;

    /**
     * Required empty public constructor.
     */
    public DashboardFragment() {
    }

    /**
     * Creates a new instance of this Fragment using the provided user name.
     */
    public static DashboardFragment newInstance(String userName) {

        // Create a new instance of the Fragment
        DashboardFragment fragment = new DashboardFragment();
        // Create a Bundle to keep all the provided parameters
        Bundle args = new Bundle();
        // Put the parameters within the Bundle
        args.putString(USERNAME, userName);
        // Set the Bundle as arguments of this Fragment
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Retrieve any parameters available withinh the Fragment's arguments
        if (getArguments() != null) {
            // Get the user name
            userName = getArguments().getString(USERNAME);
        }

        // The Fragment can now add actions to the ActionBar and react when they are clicked
        setHasOptionsMenu(true);
    }

    /**
     * Creates the View associated to this Fragment from a Layout resource.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        // Update the user name according to the obtained argument
        //EditText etUser = (EditText) view.findViewById(R.id.etUserName);
        //etUser.setText(userName);
        return view;
    }

    /**
     * This method is executed when the fragment is created to populate the ActionBar with actions.
     */
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Generate the Menu object from the XML resource file
        inflater.inflate(R.menu.menu_dashboard, menu);
    }

    /**
     * This method is executed when any action from the ActionBar is selected.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Determine the action to take place according to the Id of the action selected
        if (item.getItemId() == R.id.mLogin) {
            // Notify the user that this action has been selected
            Toast.makeText(getContext(), R.string.menu_fragment_dashboard, Toast.LENGTH_SHORT).show();
            return true;
        }
        // There was no custom behaviour for that action, so let the system take care of it
        return super.onOptionsItemSelected(item);
    }
}

