package ch4;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.observables.GroupedObservable;

public class Ch4_18_1 {

    public static void main(String[] args) {
        Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon");
        Observable<GroupedObservable<Integer, String>> byLengths =
                source.groupBy(String::length);
        byLengths.flatMapSingle(Observable::toList)
                .subscribe(System.out::println);

        Observable<City> cityObservable = Observable.create(new ObservableOnSubscribe<City>() {
            @Override
            public void subscribe(ObservableEmitter<City> e) {
                e.onNext(new City(20, "广州", City.POSITION_C));

                e.onNext(new City(668, "茂名", City.POSITION_W));
                e.onNext(new City(751, "韶关", City.POSITION_N));
                e.onNext(new City(753, "梅州", City.POSITION_N));
                e.onNext(new City(754, "汕头", City.POSITION_E));
                e.onNext(new City(755, "深圳", City.POSITION_C));
                e.onNext(new City(756, "珠海", City.POSITION_C));
                e.onNext(new City(768, "潮州", City.POSITION_E));
                e.onNext(new City(769, "东莞", City.POSITION_C));
                e.onNext(new City(663, "揭阳", City.POSITION_E));
                e.onComplete();
            }
        });

        Observable<GroupedObservable<Integer, City>> byCode = cityObservable.groupBy(new Function<City, Integer>() {
            @Override
            public Integer apply(City city) {
                //除以10之后的数据:分类
                return city.code / 10;
            }
        });

        Observable<GroupedObservable<Integer, City>> byPosition = cityObservable.groupBy(new Function<City, Integer>() {
            @Override
            public Integer apply(City city)  {
                return city.position;
            }
        });
        Observable<GroupedObservable<Integer, City>> method = byPosition;


        method.flatMapSingle(new Function<GroupedObservable<Integer, City>, Single<List<City>>>() {
            @Override
            public Single<List<City>> apply(GroupedObservable<Integer, City> integerCityGroupedObservable) {
                //转换：
                return integerCityGroupedObservable.toList();
            }
        }).subscribe(new Consumer<List<City>>() {
            @Override
            public void accept(List<City> cities) {
                //打印转化后的数据
                System.out.println(cities);
                System.out.println("开始分组 --");
                for (City city : cities) {
                    System.out.println(city.name);
                }
                System.out.println("结束分组 --");
            }
        });

    }

    private static final class City {
        /**
         * 粤东
         */
        private static final int POSITION_E = 0;
        /**
         * 珠三角
         */
        private static final int POSITION_C = 1;
        /**
         * 粤西
         */
        private static final int POSITION_W = 2;
        /**
         * 粤北
         */
        private static final int POSITION_N = 3;

        int code;
        String name;
        /**
         * 位置
         */
        int position;

        City(int code, String name, int position) {
            this.code = code;
            this.name = name;
            this.position = position;
        }

        @Override
        public String toString() {
            return "城市{" +
                    "0" + code +
                    ", '" + name + '\'' +
                    "," + position +
                    '}';
        }
    }
}