package blocks.booking;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import data.BookingData;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by bigdrop on 9/14/2018.
 */
@Block(@FindBy(className = "booking-details"))
public class BookingDetail extends HtmlElement {

    public boolean containsDuration(String duration) {
        if(durationText.getText().contains(duration))
            return true;
        else return false;
    }

    @FindBy(css = ".selected-service li span")
    private HtmlElement durationText;

    public boolean containsService(String service) {
        if(serviceText.getText().contains(service))
            return true;
        else return false;
    }

    @FindBy(css = ".selected-service li")
    private HtmlElement serviceText;

    public boolean containsLocation(String location) {
        if(locationText.getText().contains(location))
            return true;
        else return false;
    }

    @FindBy(css = ".location-info h4")
    private HtmlElement locationText;

    public boolean containsTherapist(String therapist) {
        if(therapistText.getText().contains(therapist))
            return true;
        else return false;
    }

    @FindBy(xpath = "//div[@class='service-info']//i[@class='icon-specific_employee']//ancestor::li")
    private HtmlElement therapistText;

    public boolean containsDate(String date) {
        if(dateText.getText().contains(date))
            return true;
        else return false;
    }

    @FindBy(xpath = "//div[@class='service-info']//i[@class='icon-date']//ancestor::li")
    private HtmlElement dateText;

    @FindBy(xpath = "(//ul[@class='total-list']/li)[1]")
    private HtmlElement subTotaltext;

    @FindBy(xpath = "(//ul[@class='total-list']/li)[2]")
    private HtmlElement taxText;

    @FindBy(xpath = "(//ul[@class='total-list']/li)[3]")
    private HtmlElement totaltext;

    public String getSubTotalText() {
        String arr[] = subTotaltext.getText().split("\n", 10);
        String Word = arr[1];
        return Word;
    }

    public String getTaxText() {
        String arr[] = taxText.getText().split("\n", 10);
        String Word = arr[1];
        return Word;
    }

    public String getTotalText() {
        String arr[] = totaltext.getText().split("\n", 10);
        String Word = arr[1];
        return Word;
    }

    public String getDurationText() {
        return durationText.getText();
    }

    public String getServiceText() {
        String arr[] = serviceText.getText().split("\n", 10);
        String Word = arr[0];
        return Word;
    }

    public String getLocationText() {
        return locationText.getText();
    }

    public String getTherapistText() {
        String arr[] = therapistText.getText().split("\n", 10);
        String Word = arr[1];
        return Word;
    }

    public String getDateText() {
        return dateText.getText();
    }

    public void generateBookingFile() throws IOException {
        File file = new File("src/main/resources/booking.json");
        List<BookingData> bookingData = generateBookingData();
        save(bookingData, file);
    }

    private void save(List<BookingData> bookingData, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(bookingData);
        Writer writer = new BufferedWriter(new FileWriter(file, true));;
        writer.write(json);
        writer.close();
    }

    private List<BookingData> generateBookingData() {
        List<BookingData> bookingData = new ArrayList<>();
        bookingData.add(new BookingData().setCurrentDate(new Date().toString()).setLocation(getLocationText()).setDate(getDateText())
                .setTherapist(getTherapistText()).setService(getServiceText())
                .setDuration(getDurationText()).setSubTotal(getSubTotalText())
                .setTax(getTaxText()).setTotal(getTotalText()));
        return bookingData;

    }

}
