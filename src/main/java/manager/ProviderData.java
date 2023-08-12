package manager;

import User.Contact;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProviderData {

    @DataProvider
    public Iterator<Object[]> contactDtoSCV() throws IOException {
        Contact contact;
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/phone-book_addNewContacts.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{ contact = Contact.builder()
                    .name(split[0])
                    .lastName(split[1])
                    .phone(split[2])
                    .email(split[3])
                    .address(split[4])
                    .description(split[5])
                    .build()
            });
            line = reader.readLine();
        }
        return list.iterator();
    }




}
