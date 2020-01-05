package com.project100pi.cricbuzztask.ui.activities

import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import com.project100pi.cricbuzztask.R
import com.project100pi.cricbuzztask.model.Response
import com.project100pi.cricbuzztask.network.APIClient.getClient
import com.project100pi.cricbuzztask.network.APIInterface
import retrofit2.Call
import retrofit2.Callback


class MainActivity : AppCompatActivity() {

    @BindView(R.id.waiting_sign)
    lateinit var rvVideoList: RecyclerView

    @BindView(R.id.empty_msg)
    lateinit var tvEmptyList: TextView

    @BindView(R.id.waiting_sign)
    lateinit var pgWaiting: ProgressBar



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}
