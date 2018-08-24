package rx.example.pengy.rxdemo;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

public class Test {
    public static void main(String[] args) {
        System.out.print("adasda");

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("0");
        list.add("1");
        list.add("2");

        Observable.fromArray(list)
                .flatMap(new Function<List<String>, ObservableSource<?>>() {
                    @Override
                    public ObservableSource<?> apply(List<String> strings) throws Exception {
                        return null;
                    }
                })
                .filter(new Predicate<Object>() {
                    @Override
                    public boolean test(Object o) throws Exception {
                        return false;
                    }
                })
                .map(new Function<Object, Object>() {
                    @Override
                    public Object apply(Object o) throws Exception {
                        return null;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {

                    }
                });

        Observable.just(1, 2, 3, 4)
                .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
                .observeOn(AndroidSchedulers.mainThread()) // 指定 Subscriber 的回调发生在主线程
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        System.out.print(integer);
                    }
                });

    }
}
