package rx.example.pengy.rxdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.example.pengy.douban.book.GetBookService;
import rx.example.pengy.douban.book.bean.Book;
import rx.example.pengy.util.LogUtils;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        new Thread() {
            @Override
            public void run() {
                super.run();
//                OkHttpClient mOkHttpClient = new OkHttpClient.Builder().build();
//                Request request = new Request.Builder().url("https://api.douban.com/v2/movie/top250?start=0&count=10").build();
//
//                Call call = mOkHttpClient.newCall(request);
//                try {
//                    Response response = call.execute();
//                    String stringResponse = response.body().string();
//                    System.out.println("stringGetResponse ==> " + stringResponse);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                } catch (NetworkOnMainThreadException e) {
//                    e.printStackTrace();
//                }
            }
        }.start();

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.douban.com/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        GetBookService getBookService = retrofit.create(GetBookService.class);
        Call<Book> callback = getBookService.getSearchBook("金瓶梅", "0", 0, 10);
        callback.enqueue(new Callback<Book>() {
            @Override
            public void onResponse(Call<Book> call, Response<Book> response) {
                LogUtils.e(response.message());
            }

            @Override
            public void onFailure(Call<Book> call, Throwable t) {
                LogUtils.e(call.toString());

            }
        });
    }
}
