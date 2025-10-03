package Homework.medium;

public class UserDataCloudDataSource implements DataSource<UserData> {
    @Override
    public UserData getData(){
        return new UserData(1, "Nurdaulet", "nurdaulettolegen26@gmail.com");
    }
}
