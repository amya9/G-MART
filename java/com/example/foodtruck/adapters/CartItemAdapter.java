package com.example.foodtruck.adapters;

import android.app.Dialog;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodtruck.ProductDetailsActivity;
import com.example.foodtruck.R;
import com.example.foodtruck.models.CartItemModel;

import java.util.List;

public class CartItemAdapter extends RecyclerView.Adapter {
    private List<CartItemModel> cartItemModelList;

    public CartItemAdapter(List<CartItemModel> cartItemModelList) {
        this.cartItemModelList = cartItemModelList;
    }

    @Override
    public int getItemViewType(int position) {
        switch (cartItemModelList.get(position).getType()) {
            case 0:
                return CartItemModel.CART_ITEM_VIEW;
            case 1:
                return CartItemModel.BALANCE_DETAILS_VIEW;
            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case CartItemModel.CART_ITEM_VIEW:
                View cartItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item_layout, parent, false);
                return new cartItemViewHolder(cartItemView);
            case CartItemModel.BALANCE_DETAILS_VIEW:
                View balanceDetailsView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_balance_details_layout, parent, false);
                return new balanceDetailsViewHolder(balanceDetailsView);
            default:
                return null;

        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (cartItemModelList.get(position).getType()) {
            case CartItemModel.CART_ITEM_VIEW:
                int resources = cartItemModelList.get(position).getCartProductImage();
                String name = cartItemModelList.get(position).getCartProductName();
                int freeCoupon = cartItemModelList.get(position).getFreeCouponNumber();
                String originalPrice = cartItemModelList.get(position).getOriginalProductPrice();
                String discountedPrice = cartItemModelList.get(position).getDiscountedProductPrice();
                int offerApplied = cartItemModelList.get(position).getOffersApplied();
                ((cartItemViewHolder) holder).setCartItems(resources, name, freeCoupon, originalPrice, discountedPrice, offerApplied);
                break;
            case CartItemModel.BALANCE_DETAILS_VIEW:
                String itemNumber = cartItemModelList.get(position).getTotalItem();
                String singleProductPrice = cartItemModelList.get(position).getSingleProductPrice();
                String deliveryCharge = cartItemModelList.get(position).getDeliveryCharge();
                String savedAmount = cartItemModelList.get(position).getAmountSaved();
                ((balanceDetailsViewHolder) holder).setCartBalanceDetails(itemNumber, singleProductPrice, deliveryCharge, savedAmount);
                break;
            default:
                return;

        }

    }

    @Override
    public int getItemCount() {
        return cartItemModelList.size();
    }

    public class cartItemViewHolder extends RecyclerView.ViewHolder {
        private ImageView cartProductImage;
        private TextView freeCouponNumber;
        private TextView freeCouponsApplied;
        private TextView offersApplied;
        private TextView productQuantity;
        private TextView cartProductName;
        private TextView originalProductPrice;
        private TextView discountedProductPrice;
        private ImageView freeCouponIcon;
        private LinearLayout removeFromCart;
        private LinearLayout saveForLater;

        public cartItemViewHolder(@NonNull final View itemView) {
            super(itemView);
            cartProductImage = itemView.findViewById(R.id.cart_product_image_iv);
            freeCouponNumber = itemView.findViewById(R.id.cart_free_coupons_available_tv);
            freeCouponsApplied = itemView.findViewById(R.id.cart_coupons_applied_tv);
            offersApplied = itemView.findViewById(R.id.cart_offers_applied_tv);
            productQuantity = itemView.findViewById(R.id.cart_product_quantity_tv);
            cartProductName = itemView.findViewById(R.id.cart_product_name_tv);
            originalProductPrice = itemView.findViewById(R.id.cart_original_price_tv);
            discountedProductPrice = itemView.findViewById(R.id.cart_discounted_price_of_product_tv);
            freeCouponIcon = itemView.findViewById(R.id.cart_free_coupons_image_iv);
            removeFromCart = itemView.findViewById(R.id.cart_remove_product_from_cart_btn);
            saveForLater = itemView.findViewById(R.id.cart_save_later_product_from_cart_btn);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent productDetailsIntent = new Intent(itemView.getContext(), ProductDetailsActivity.class);
                    itemView.getContext().startActivity(productDetailsIntent);
                }
            });

        }

        public void setCartItems(int resources, String productName, int freeCouponNo, String originalPrice, String discountedPrice, int offerApplied) {
            cartProductImage.setImageResource(resources);
            cartProductName.setText(productName);
            if (freeCouponNo > 0) {
                freeCouponNumber.setVisibility(View.VISIBLE);
                freeCouponIcon.setVisibility(View.VISIBLE);
                if (freeCouponNo == 1) {
                    freeCouponNumber.setText(freeCouponNo + " coupon available");
                } else {
                    freeCouponNumber.setText(+freeCouponNo + " coupons available");
                }
            } else {
                freeCouponNumber.setVisibility(View.INVISIBLE);
                freeCouponIcon.setVisibility(View.INVISIBLE);
            }
            originalProductPrice.setText(originalPrice);
            discountedProductPrice.setText(discountedPrice);
            if (offerApplied > 0) {
                offersApplied.setVisibility(View.VISIBLE);
                if (offerApplied == 1) {
                    offersApplied.setText(offerApplied + " offer applied");
                } else {
                    offersApplied.setText(offerApplied + " offers applied");

                }
            } else {
                offersApplied.setVisibility(View.INVISIBLE);
            }

            removeFromCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), "Removed from cart", Toast.LENGTH_LONG).show();
                }
            });

            saveForLater.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), "Product saved", Toast.LENGTH_LONG).show();
                }
            });

            productQuantity.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Dialog quantityDialog = new Dialog(itemView.getContext());
                    quantityDialog.setContentView(R.layout.quantity_dialog);
                    quantityDialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT , LinearLayout.LayoutParams.WRAP_CONTENT);
                    quantityDialog.setCancelable(false);
                    final EditText quantity = (EditText) quantityDialog.findViewById(R.id.quantity_product_et);
                    Button cancelBtn = (Button) quantityDialog.findViewById(R.id.quantity_cancel_btn);
                    Button addQty = (Button) quantityDialog.findViewById(R.id.quantity_add_btn);

                    cancelBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            quantityDialog.dismiss();
                        }
                    });
                    addQty.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            productQuantity.setText("Qty: "+ quantity.getText());
                            quantityDialog.dismiss();
                        }
                    });
                    quantityDialog.show();
                }
            });
        }
    }

    public class balanceDetailsViewHolder extends RecyclerView.ViewHolder {
        private TextView totalItemQuantity;
        private TextView singleProductPrice;
        private TextView deliveryCharge;
        private TextView amountSaved;
        private TextView totalAmount;

        public balanceDetailsViewHolder(@NonNull View itemView) {
            super(itemView);
            totalItemQuantity = itemView.findViewById(R.id.cart_balance_quantity_tv);
            singleProductPrice = itemView.findViewById(R.id.cart_balance_price_of_single_itme_tv);
            deliveryCharge = itemView.findViewById(R.id.cart_balance_delivery_charge_tv);
            amountSaved = itemView.findViewById(R.id.cart_balance_you_will_save_how_much_tv);
            totalAmount = itemView.findViewById(R.id.cart_balance_total_amount_tv);
        }

        public void setCartBalanceDetails(String itemNo, String productPrice, String deliveryAmount, String saved) {
            totalItemQuantity.setText(itemNo);
            singleProductPrice.setText(productPrice);
            deliveryCharge.setText(deliveryAmount);
            amountSaved.setText(saved);
        }
    }
}
