package com.example.amazonstore

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.razorpay.Checkout
import com.razorpay.PaymentResultListener
import org.json.JSONObject

class ItemActivity : AppCompatActivity(), PaymentResultListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)
        Checkout.preload(applicationContext);
        val co=Checkout()
        val img=findViewById<ImageView>(R.id.image)
        val imgId: Int=intent.getIntExtra("ItemImage", 0)
        val title=findViewById<TextView>(R.id.item_list_title_one)
        val longDesc=findViewById<TextView>(R.id.item_list_longDesc)
        val price=findViewById<TextView>(R.id.item_list_price_one)
        val btn=findViewById<Button>(R.id.item_list_cartButton)
        img.setImageResource(imgId)
        title.text=intent.getStringExtra("ItemTitle")
        longDesc.text=intent.getStringExtra("ItemDescLong")
        price.text=intent.getStringExtra("ItemPrice")

        co.setKeyID("rzp_test_EjpOEtpw8AIWPe");
        btn.setOnClickListener {
            startPayment()
        }
    }
    private fun startPayment() {

        val activity: Activity = this
        val co = Checkout()

        try {
            val options = JSONObject()
            options.put("name","Eva Anufrieva")
            options.put("description","Apple products")
            //You can omit the image option to fetch the image from the dashboard
            options.put("image","https://s3.amazonaws.com/rzp-mobile/images/rzp.jpg")
            options.put("theme.color", "#ff0");
            options.put("currency","USD");
            options.put("order_id", "order_MzfFudN9Ql5gGw");
            options.put("amount",10000)

            co.open(activity,options)
        }catch (e: Exception){
            Toast.makeText(activity,"Error in payment: "+ e.message,Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }

    override fun onPaymentSuccess(p0: String?) {
        Toast.makeText(this, "Payment is successful : " + p0, Toast.LENGTH_SHORT).show();

    }

    override fun onPaymentError(p0: Int, p1: String?) {
        Toast.makeText(this, "Payment Failed due to error : " + p1, Toast.LENGTH_LONG).show();
    }

}