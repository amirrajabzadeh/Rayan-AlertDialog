package ir.amirrajabzadeh.alertdialog;

import androidx.appcompat.app.AppCompatActivity;
import ir.amirrajabzadeh.rayanalert.RayanAlert;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.LayoutDirection;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RayanAlert alert=new RayanAlert(this);

        findViewById(R.id.btnShow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert
                        .setLayoutDirection(LayoutDirection.LTR)
                        .setTitle("Title")
                        .setMessage("This is a message")
                        .setImageLoading(getResources().getDrawable(R.drawable.ic_github))
                        .setTextPositiveButton("ok")
                        .setTextNegativeButton("dismiss")
                        .showLoading(true)
                        .show(new RayanAlert.OnClickListener() {
                            @Override
                            public void onPositiveButtonClick() {
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        alert.dismiss();
                                    }
                                },5000);
                            }
                        });
            }
        });

    }
}
