package com.example.sadatech.volleylibrary.dbhelper;

import android.app.ProgressDialog;
import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Toshiba-PC on 8/9/2016.
 */
public class DatabaseHelper<T> {
    private ProgressDialog progressDialog;
    Context context;
    private Class<T> clazz;
//    public final Gson gson;

    public DatabaseHelper(Context context) {
//        GsonBuilder gsonBuilder = new GsonBuilder();
        this.context = context;
//        this.gson = gsonBuilder.create();
    }

    public void volleyInsertMethodPOst(final List<Model> list, String url, final Response.Listener<String> listener, final Response.ErrorListener errrorlistener) {
        progressDialog = new ProgressDialog(context);
        progressDialog.show();
        StringRequest strReq = new StringRequest(Request.Method.POST, url
                , new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                JSONArray jsonArray = null;
                progressDialog.dismiss();
                listener.onResponse(s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                progressDialog.dismiss();
                errrorlistener.onErrorResponse(volleyError);
            }
        }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                for (int i = 0; i < list.size(); i++) {
                    params.put(list.get(i).getKey(), list.get(i).getValue());
                }
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(strReq);
    }

    public void volleyInsertMethodPOstwithHeader(int method, final List<Model> list, String url, final String token, final Response.Listener<String> listener, final Response.ErrorListener errrorlistener) {
        progressDialog = new ProgressDialog(context);
        progressDialog.show();
        StringRequest strReq = new StringRequest(method, url
                , new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                JSONArray jsonArray = null;
                progressDialog.dismiss();
                listener.onResponse(s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                progressDialog.dismiss();
                errrorlistener.onErrorResponse(volleyError);
            }
        }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                for (int i = 0; i < list.size(); i++) {
                    params.put(list.get(i).getKey(), list.get(i).getValue());
                }
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> header = new HashMap<>();
                header.put("Authorization", token);
                return header;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(strReq);
    }

    public void volleyGetDatawithParam(int method, final List<Model> list, String url, final Response.Listener<String> listener, final Response.ErrorListener errrorlistener) {
        progressDialog = new ProgressDialog(context);
        progressDialog.show();
        StringRequest strReq = new StringRequest(method, url
                , new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                JSONArray jsonArray = null;
                progressDialog.dismiss();
                listener.onResponse(s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                progressDialog.dismiss();
                errrorlistener.onErrorResponse(volleyError);
            }
        }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                for (int i = 0; i < list.size(); i++) {
                    params.put(list.get(i).getKey(), list.get(i).getValue());
                }
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(strReq);
    }

    public void volleyGetDatawithHeader(int method, String url, final String token, final Response.Listener<String> listener, final Response.ErrorListener errrorlistener) {
        progressDialog = new ProgressDialog(context);
        progressDialog.show();
        StringRequest strReq = new StringRequest(method, url
                , new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                JSONArray jsonArray = null;
                progressDialog.dismiss();
                listener.onResponse(s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                progressDialog.dismiss();
                errrorlistener.onErrorResponse(volleyError);
            }
        }
        ) {
            //            @Override
//            protected Map<String, String> getParams() {
//                Map<String, String> params = new HashMap<String, String>();
//                for (int i = 0; i < list.size(); i++) {
//                    params.put(list.get(i).getKey(), list.get(i).getValue());
//                }
//                return params;
//            }
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> header = new HashMap<>();
                header.put("Authorization", token);
                return header;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(strReq);
    }

    public void volleygetData(int method, String url, final Response.Listener<String> listener, final Response.ErrorListener errrorlistener) {
        progressDialog = new ProgressDialog(context);
        progressDialog.show();
        StringRequest strReq = new StringRequest(method, url
                , new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                JSONArray jsonArray = null;
                progressDialog.dismiss();
                listener.onResponse(s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                progressDialog.dismiss();
                errrorlistener.onErrorResponse(volleyError);
            }
        }
        );
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(strReq);
    }

    public void volleygetData(int method, String url, final boolean progress, final Response.Listener<String> listener, final Response.ErrorListener errrorlistener) {
        if (progress) {
            progressDialog = new ProgressDialog(context);
            progressDialog.show();
        }
        StringRequest strReq = new StringRequest(method, url
                , new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                JSONArray jsonArray = null;
                if (progress) {
                    progressDialog.dismiss();
                }
                listener.onResponse(s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                if (progress) {
                    progressDialog.dismiss();
                }
                errrorlistener.onErrorResponse(volleyError);
            }
        }
        );
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(strReq);
    }

    public void volleygetData(int method, String url, final boolean progress, final Class<T> clazz, final Response.Listener<String> listener, final Response.ErrorListener errrorlistener) {
        if (progress) {
            progressDialog = new ProgressDialog(context);
            progressDialog.show();
        }
        this.clazz = clazz;
        StringRequest strReq = new StringRequest(method, url
                , new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                JSONArray jsonArray = null;
                if (progress) {
                    progressDialog.dismiss();
                }
                listener.onResponse(s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                if (progress) {
                    progressDialog.dismiss();
                }
                errrorlistener.onErrorResponse(volleyError);
            }
        }
        );
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(strReq);
    }

    public void volleyMultipartInsert(int method, String url, final String token, final String path, final String keyfile, final List<Model> list, final Response.Listener<String> listener, final Response.ErrorListener errrorlistener) {
        progressDialog = new ProgressDialog(context);
        progressDialog.show();
        VolleyMultipartRequest multipartRequest = new VolleyMultipartRequest(method, url, new Response.Listener<NetworkResponse>() {
            @Override
            public void onResponse(NetworkResponse response) {

                progressDialog.dismiss();
                String responsedata = new String(response.data);
                listener.onResponse(responsedata);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                errrorlistener.onErrorResponse(error);
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                for (int i = 0; i < list.size(); i++) {
                    params.put(list.get(i).getKey(), list.get(i).getValue());
                }
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> header = new HashMap<>();
                header.put("Authorization", token);
                return header;
            }

            @Override
            protected Map<String, DataPart> getByteData() throws AuthFailureError {
                Map<String, DataPart> params = new HashMap<>();
                String filename = path.substring(path.lastIndexOf("/") + 1);
                String ext = filename.substring(filename.lastIndexOf(".") + 1);
                String jns = "", extension = "";
                if (ext.equals("mp4")) {
                    jns = "video";
                    extension = "mp4";
                } else {
                    jns = "image";
                    extension = "jpeg";
                }
                params.put(keyfile, new DataPart(filename, AppHelper.convertFileToByteArray(path), jns + "/" + extension));
//                params.put("thumbnail", new DataPart(filename, AppHelper.createThumbnail(path), jns + "/" + extension));
                return params;
            }
        };
        VolleySingleton.getInstance(context).addToRequestQueue(multipartRequest);

    }

}
