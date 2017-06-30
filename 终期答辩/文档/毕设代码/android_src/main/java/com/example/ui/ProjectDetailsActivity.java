package com.example.ui;

import android.os.Bundle;
import android.webkit.WebView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.com.example.base.BaseActivity;
import com.example.entity.Project;
import com.example.sean.liontest1.R;
import com.example.util.NetworkSingleton;

import java.io.UnsupportedEncodingException;

public class ProjectDetailsActivity extends BaseActivity {

    WebView project_details;
    Project project;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_details);

        setStatusBar();
        initView();
    }

    private void initView() {
        project = (Project)getIntent().getSerializableExtra("project");
        initTopBarForLeft(project.getTitle());
        project_details = (WebView)findViewById(R.id.project_details);
								ShowLog("ddd"+project.getDetails_page());

								StringRequest request = new StringRequest(Request.Method.GET, project.getDetails_page(),
																new Response.Listener<String>() {
																				@Override
																				public void onResponse(String s) {
																								ShowLog("response"+s);
																								String ss = null;
																								try {
																												ss  = new String(s.getBytes("ISO-8859-1"), "UTF-8");
																								} catch (UnsupportedEncodingException e) {
																												e.printStackTrace();
																								}
																								ShowLog(ss);
																								project_details.loadDataWithBaseURL(null,ss,"application/x-www-form-urlencoded","utf-8",null);
																				}
																}, new Response.ErrorListener() {
												@Override
												public void onErrorResponse(VolleyError volleyError) {
																ShowLog("222222"+volleyError.toString());
												}
								});
								request.setRetryPolicy(new DefaultRetryPolicy(10000,3,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
								NetworkSingleton.getInstance(getApplicationContext()).addToRequestQueue(request);


    }

}
