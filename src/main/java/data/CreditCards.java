package data;

/**
 * Created by bigdrop on 9/14/2018.
 */
public enum CreditCards {

    VISA_STRIPE("Stripe VISA", "4242424242424242", "October", "2020", "123"),
    TEST_CARD("Test Master", "5534727490123983", "May", "2022", "128"),
    MASTERCART_STRIPE("Stripe Master", "5555555555554444", "April", "2021", "989");



    private String cardName;
    private String cardNumber;
    private String cardMonth;
    private String cardYear;
    private String cardCVV;


    public String getCardName() {
        return cardName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardMonth() {
        return cardMonth;
    }

    public String getCardYear() {
        return cardYear;
    }

    public String getCardCVV() {
        return cardCVV;
    }

  ;

    CreditCards(String cardName, String cardNumber, String cardMonth, String cardYear, String cardCVV) {
        this.cardNumber = cardNumber;
        this.cardMonth = cardMonth;
        this.cardYear = cardYear;
        this.cardCVV = cardCVV;
        this.cardName = cardName;
    }
}
