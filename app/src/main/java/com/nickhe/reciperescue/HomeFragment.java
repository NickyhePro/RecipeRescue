package com.nickhe.reciperescue;


<<<<<<< HEAD
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
=======
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
>>>>>>> master
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
<<<<<<< HEAD
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
=======
import android.widget.ListAdapter;
import android.widget.ListView;

>>>>>>> master


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
private FirebaseAuth firebaseAuth;
private Button logOutBtn;

    ListView listView;
    FakeRecipeRepository fakeRecipeRepository;
    public HomeFragment() {
<<<<<<< HEAD


    }
=======
>>>>>>> master

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
<<<<<<< HEAD
        View mview= inflater.inflate(R.layout.fragment_home,container,false);
        logOutBtn= mview.findViewById(R.id.buttonLog);
        this.firebaseAuth= FirebaseAuth.getInstance();



        // Inflate the layout for this fragment
        return mview;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        logOutBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                firebaseAuth.signOut();
                getActivity().finish();
                startActivity(new Intent(getActivity(),MainLoginActivity.class));

                Toast.makeText(getActivity(),"log out clicked", Toast.LENGTH_LONG).show();
            }
        });
=======
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView = view.findViewById(R.id.home_recipeList);
        fakeRecipeRepository = FakeRecipeRepository.getFakeRecipeRepository(getActivity());
        RecipeListAdapter recipeListAdapter = new RecipeListAdapter(getActivity(), fakeRecipeRepository.getFakeRepo());
        listView.setAdapter(recipeListAdapter);
        setListViewHeightBasedOnChildren(listView);
>>>>>>> master
    }

    /**
     * Make sure the listView will be set by the correct height based on
     * the number of the items it has.
     * @param listView
     */
    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null)
            return;

        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.UNSPECIFIED);
        int totalHeight = 0;
        View view = null;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            view = listAdapter.getView(i, view, listView);
            if (i == 0)
                view.setLayoutParams(new ViewGroup.LayoutParams(desiredWidth, ViewGroup.LayoutParams.WRAP_CONTENT));

            view.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }
}
