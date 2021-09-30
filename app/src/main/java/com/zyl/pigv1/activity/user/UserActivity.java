package com.zyl.pigv1.activity.user;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.zyl.pigv1.R;
import com.zyl.pigv1.databinding.ActivityUserBinding;

public class UserActivity extends AppCompatActivity {

    private ActivityUserBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_user_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_user_list, R.id.navigation_user_add)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_user);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navUserView, navController);
    }

//    public void saveUser(View view) {
//        EditText name = view.findViewById(R.id.userNameText);
//        EditText phone = view.findViewById(R.id.userPhoneText);
//        EditText address = view.findViewById(R.id.userAddressText);
//        User user = new User();
//        user.setName(name.getText().toString());
//        user.setPhone(phone.getText().toString());
//        user.setAddress(address.getText().toString());
//    }

}