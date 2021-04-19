package com.sample.saladin.viewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.sample.saladin.model.Materi;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MateriViewModel extends ViewModel {
    private MutableLiveData<ArrayList<Materi>> listsMateri = new MutableLiveData<>();

    public void setMateri() {
        final ArrayList<Materi> listItems = new ArrayList<>();
        AsyncHttpClient client = new AsyncHttpClient();

        client.get("http://saladinapp.web.id/saladin/api/v1/materi/list", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String result = new String(responseBody);
                    JSONObject responseObject = new JSONObject(result);
                    JSONArray list = responseObject.getJSONArray("data");

                    for (int i = 0; i < list.length(); i++) {
                        JSONObject daftar_materi = list.getJSONObject(i);
                        Materi items = new Materi(daftar_materi);
                        listItems.add(items);
                    }
                    listsMateri.postValue(listItems);
                } catch (Exception e) {
                    Log.d("Exception", e.getMessage());
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("onFailure", error.getMessage());
            }
        });
    }

    public LiveData<ArrayList<Materi>> getMateri() {
        return listsMateri;
    }

}
