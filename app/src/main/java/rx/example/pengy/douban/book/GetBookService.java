package rx.example.pengy.douban.book;

import retrofit.http.GET;
import retrofit.http.Query;
import retrofit2.Call;
import rx.example.pengy.douban.book.bean.Book;

public interface GetBookService {
    @GET("book/search")
    Call<Book> getSearchBook(@Query("q") String name,
                             @Query("tag") String tag,
                             @Query("start") int start,
                             @Query("count") int count);
}
