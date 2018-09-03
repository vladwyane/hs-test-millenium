package generators;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import data.UsersData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bigdrop on 9/3/2018.
 */
public class UserDataGenerator {

    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(args[0]);
        File file = new File(args[1]);

        List<UsersData> usersData = generateUsers(count);
        save(usersData, file);
    }

/*    private static void save(List<UsersData> usersData, File file) throws IOException {
        Writer writer = new FileWriter(file);
        for (UsersData user : usersData) {
            writer.write(String.format("%s;%s;%s;%s;%s;%s;%s\n", user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(),
                    user.getConfPassword(), user.getPhone(), user.getLocation()));
        }
        writer.close();
    }*/

    private static void save(List<UsersData> usersData, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(usersData);
        Writer writer = new FileWriter(file);
        writer.write(json);
        writer.close();
    }

    private static List<UsersData> generateUsers(int count) {
        List<UsersData> usersData = new ArrayList<UsersData>();
        for (int i = 0; i < count; i++) {
            usersData.add(new UsersData().setFirstName(String.format("Lebron %s", i + 1)).setLastName(String.format("James %s", i + 1))
                    .setEmail(String.format("vladyslav.chesalov+" + (i + 8) + "@bigdropinc.com")).setPassword(String.format("JR6GMs4ywG"))
                    .setConfPassword(String.format("JR6GMs4ywG")).setPhone(String.format(i + "123456789")).setLocation(String.format("Cherry")));
        }
        return usersData;
    }
}
