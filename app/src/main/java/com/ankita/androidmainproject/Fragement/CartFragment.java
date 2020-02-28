package com.ankita.androidmainproject.Fragement;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.ankita.androidmainproject.R;
import com.ankita.androidmainproject.adapter.CartItemData;
import com.ankita.androidmainproject.adapter.CartListAdapter;

import java.util.ArrayList;


public class CartFragment extends Fragment {
    private ListView list;
    private TextView tvTotalPrice;
    private ArrayList<CartItemData> arrayList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_cart, container, false);
        init(v);
        return v;
    }

    private void init(View v) {
        initViews(v);
        setList();
        setCartListAndAdapter();
        counttotalPrice();
    }

    private void initViews(View v) {
        list = v.findViewById(R.id.listcart);
        tvTotalPrice = v.findViewById(R.id.tvTotalPrice);
    }

    private void setCartListAndAdapter() {
        final CartListAdapter adapter = new CartListAdapter(getActivity(), arrayList);
        list.setAdapter(adapter);
        adapter.setOnItemClickListener(new CartListAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position, ArrayList<CartItemData> cartList) {
                switch (view.getId()) {
                    case R.id.btnplus:
                        CartItemData cartItem = cartList.get(position);
                        cartItem.setQty(cartItem.getQty() + 1);
                        arrayList.set(position, cartItem);
                        adapter.notifyDataSetChanged();
                        counttotalPrice();

                        break;
                    case R.id.btnminus:
                        CartItemData cartItem1 = cartList.get(position);
                        if (cartItem1.getQty() == 1) {
                            Toast.makeText(getActivity(), "you can not minus more item its already one", Toast.LENGTH_LONG).show();
                        } else {
                            cartItem1.setQty(cartItem1.getQty() - 1);
                            arrayList.set(position, cartItem1);
                            adapter.notifyDataSetChanged();
                            counttotalPrice();
                        }
                        break;
                }
            }
        });
    }

    private void counttotalPrice() {
        int totalPrice = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            totalPrice = totalPrice + arrayList.get(i).getPrice() * arrayList.get(i).getQty();
        }

        tvTotalPrice.setText(String.valueOf(totalPrice));
    }

    private void setList() {
        arrayList.clear();
        arrayList.add(new CartItemData("Ribeye Stick", "Ribeye Stick", 20, R.drawable.french_fries, R.id.btnplus, R.id.btnminus, 1));
        arrayList.add(new CartItemData("Ribeye Stick", "Ribeye Stick", 20, R.drawable.french_fries, R.id.btnplus, R.id.btnminus, 1));
        arrayList.add(new CartItemData("Ribeye Stick", "Ribeye Stick", 20, R.drawable.french_fries, R.id.btnplus, R.id.btnminus, 1));
        arrayList.add(new CartItemData("Ribeye Stick", "Ribeye Stick", 20, R.drawable.french_fries, R.id.btnplus, R.id.btnminus, 1));
    }


}

