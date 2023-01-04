package utilities;

public class ReusableMethod {

    public static void bekle(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {

        }
    }
}
