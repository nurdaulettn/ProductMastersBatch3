package Homework.medium;

public class Main {
    public static void main(String[] args) {
//        DataSource<MyData> myDataDataSource = new Repository<>(
//                new CachedDataSource<>(), new MyDataCloudDataSource());
//
//        DataSource<GeoData> geoDataDataSource = new GeoRepository(
//                new CachedDataSource<>(), new GeoDataCloudDataSource());
//
//        MyData myData = myDataDataSource.getData();
//        GeoData geoData = geoDataDataSource.getData();
//        System.out.println(myData.toString());
//        System.out.println(geoData.toString());

        DataSource<UserData> userDataDataSource = new UserRepository(
                new CachedDataSource<>(), new UserDataCloudDataSource()
        );
        UserData userData = userDataDataSource.getData();
        System.out.println(userData.toString());
    }

}