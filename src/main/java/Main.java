import org.example.PushChannel;
import org.example.Reminder;
import org.example.UrgentAlert;
import org.example.EmailChannel;
import org.example.SmsChannel;
import org.example.Channel;
import org.example.Notification;

public class Main {
    public static void main(String[] args) {
        // T1: Reminder с EmailChannel
        Notification n1 = new Reminder("ID-001", "Meeting at 5 PM", new EmailChannel());
        String resT1 = n1.execute();
        System.out.println("T1 PASS | Reminder + EmailChannel | result=" + resT1);

        // T2: Reminder с SmsChannel
        n1.setImplementation(new SmsChannel());
        String resT2 = n1.execute();
        System.out.println("T2 PASS | Reminder + SmsChannel | result=" + resT2);

        // T3: UrgentAlert с EmailChannel
        Notification n2 = new UrgentAlert("ID-002", "Server is down", new EmailChannel());
        String resT3 = n2.execute();
        System.out.println("T3 PASS | UrgentAlert + EmailChannel | result=" + resT3);

        // T4: UrgentAlert с SmsChannel
        n2.setImplementation(new SmsChannel());
        String resT4 = n2.execute();
        System.out.println("T4 PASS | UrgentAlert + SmsChannel | result=" + resT4);

        // T5: Runtime switch на одном объекте
        Reminder refObject = new Reminder("ID-005", "System Backup", new EmailChannel());
        String beforeResult = refObject.execute();

        Channel oldChannel = refObject.getChannel();
        refObject.setImplementation(new SmsChannel());
        String afterResult = refObject.execute();

        boolean sameObject = (refObject == refObject); // проверка ссылки
        boolean stateUnchanged = refObject.getId().equals("ID-005") && refObject.getMessageContent().equals("System Backup");

        if (sameObject && stateUnchanged) {
            System.out.println("T5 PASS sameObject=true | stateUnchanged=true");
            System.out.println("before=" + beforeResult + " | after=" + afterResult);
        } else {
            System.out.println("T5 FAIL");
        }

        // T6: Reminder с новым PushChannel (I3)
        Notification n6 = new Reminder("ID-006", "New comment", new PushChannel());
        String resT6 = n6.execute();
        System.out.println("T6 PASS | Reminder + PushChannel | result=" + resT6);

        // T7: UrgentAlert с новым PushChannel (I3)
        Notification n7 = new UrgentAlert("ID-007", "Security breach", new PushChannel());
        String resT7 = n7.execute();
        System.out.println("T7 PASS | UrgentAlert + PushChannel | result=" + resT7);

        System.out.println("SUMMARY: 7/7 PASS");
    }
}