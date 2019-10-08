import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class tstSendEstimatedBill extends tstBase {
    protected final String TEN_MINUTES_URL = "https://10minutemail.com";

    @BeforeTest
    public void fulfillForm() {
        new tstGoogleCloudForm().tstFulfillGoogleCloudForm();
    }

    @Test
    public void sendEstimatedBill() {
        pages.estimateComponent().sendEstimatedBillOnEmail();
        pages.tenMinutesPage().openLinkInNewTab(TEN_MINUTES_URL);
        String email = pages.tenMinutesPage().getEmail();
        pages.tenMinutesPage().switchToGoogleCloudTab();
        pages.emailEstimateComponent().fulfillEmailInput(email);
        pages.emailEstimateComponent().sendEmail();
        pages.emailEstimateComponent().switchToTenMinutesTab();

        Assert.assertTrue(pages.tenMinutesPage().isMessageSend());
    }

}
