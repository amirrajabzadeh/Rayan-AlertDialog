package ir.amirrajabzadeh.rayanalert;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.LayoutDirection;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.airbnb.lottie.LottieAnimationView;

import me.grantland.widget.AutofitTextView;
import mehdi.sakout.fancybuttons.FancyButton;

public class RayanAlert {

    private static AlertDialog alertDialog;
    @SuppressLint("StaticFieldLeak")
    private static FancyButton btnYes, btnNo;
    private static ConstraintLayout cl;
    private static ConstraintLayout clLoading;
    private static ConstraintLayout clParent;
    private final AutofitTextView tvYesButton;
    private final AutofitTextView tvNoButton;
    private final AutofitTextView tvTitle;
    private final AutofitTextView tvMessage;
    private final View header;
    private boolean checkShowLoading = true;
    private final ImageView imgLoading;

    public RayanAlert(Context context) {

        View view = LayoutInflater.from(context).inflate(R.layout.dialog, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(view);

        alertDialog = builder.create();
        alertDialog.setCancelable(false);
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        clParent = view.findViewById(R.id.clParent);
        cl = view.findViewById(R.id.clContent);
        clLoading = view.findViewById(R.id.clLoading);
        LottieAnimationView animationView = view.findViewById(R.id.Loading);
        btnYes = view.findViewById(R.id.btnYes);
        btnNo = view.findViewById(R.id.btnNo);
        tvYesButton = view.findViewById(R.id.tvTextYesButton);
        tvNoButton = view.findViewById(R.id.tvTextNoButton);
        tvTitle = view.findViewById(R.id.tvTitle);
        tvMessage = view.findViewById(R.id.tvMessage);
        header = view.findViewById(R.id.viewHeader);
        imgLoading = view.findViewById(R.id.imgLoading);

        animationView.setAnimation("data.json");
        animationView.setSpeed(1f);
        animationView.playAnimation();


    }

    public interface OnClickListener {
        void onPositiveButtonClicked();

//            void onNegativeButtonClicked();
    }

    public void show(final OnClickListener clickListener) {
        if (!tvTitle.getText().toString().equals(""))
            header.setVisibility(View.GONE);

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onPositiveButtonClicked();

                if (checkShowLoading) {
                    showLoading();
                }
                else {
                    alertDialog.dismiss();
                }
            }
        });

        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
//                    clickListener.onNegativeButtonClicked();
            }
        });

        alertDialog.show();
    }

    public RayanAlert showLoading(boolean isShow) {
        this.checkShowLoading = isShow;
        return this;
    }

    public void dismissAlertDialog() {
        alertDialog.dismiss();
    }

    public void showLoading() {
        cl.setVisibility(View.GONE);
        clLoading.setVisibility(View.VISIBLE);
    }

    public void hideLoading() {
        cl.setVisibility(View.VISIBLE);
        clLoading.setVisibility(View.GONE);
    }

    public RayanAlert setTextPositiveButton(String s) {
        tvYesButton.setText(s);
        return this;
    }

    public RayanAlert setTextNegativeButton(String s) {
        tvNoButton.setText(s);
        return this;
    }

    public RayanAlert setTitle(String title) {
        tvTitle.setText(title);
        return this;
    }

    public RayanAlert setMessage(String message) {
        tvMessage.setText(message);
        return this;
    }

    public RayanAlert setImageLoading(Drawable image) {
        imgLoading.setImageDrawable(image);
        return this;
    }

    public RayanAlert setLayoutDirection(int layoutDirection) {
        switch (layoutDirection) {
            case LayoutDirection.LTR:
                clParent.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
                break;
            case LayoutDirection.RTL:
                clParent.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
                break;
            case LayoutDirection.INHERIT:
                clParent.setLayoutDirection(View.LAYOUT_DIRECTION_INHERIT);
                break;
            case LayoutDirection.LOCALE:
                clParent.setLayoutDirection(View.LAYOUT_DIRECTION_LOCALE);
                break;

        }
        return this;
    }

}
