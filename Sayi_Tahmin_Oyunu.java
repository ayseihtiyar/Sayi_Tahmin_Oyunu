import java.util.Scanner;

public class Sayi_Tahmin_Oyunu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            int rndmSayi = randomSayi();
            int denemeSayisi = zorlukSeviyesiniBelirleme(scanner);
            sayiTahmini(scanner,rndmSayi,denemeSayisi);
        }while (devamMi(scanner));
    }

    private static int zorlukSeviyesiniBelirleme(Scanner scanner) {
        int denemeSayisi;
        do {
            System.out.print("\n|Kolay: 10 deneme|\n|Orta : 7  deneme|\n|Zor  : 5  deneme|\nLütfen zorluk seviyesini seçiniz: ");
            String seviye = scanner.nextLine();
            if (seviye.equalsIgnoreCase("kolay") || seviye.equalsIgnoreCase("k")) {
                denemeSayisi = 10;
                break;
            } else if (seviye.equalsIgnoreCase("orta") || seviye.equalsIgnoreCase("o")) {
                denemeSayisi = 7;
                break;
            } else if (seviye.equalsIgnoreCase("zor") || seviye.equalsIgnoreCase("z")) {
                denemeSayisi = 5;
                break;
            } else {
                System.out.println("Geçersiz seçim yaptınız! Tekrar deneyiniz.");
            }
        } while (true);
        return denemeSayisi;
    }

    private static int randomSayi() {
        return (int) ((Math.random() * (99 - 10) + 1) + 10);
    }

    private static void sayiTahmini(Scanner scanner, int rndmSayi, int denemeSayisi) {
        for (int i = 1; i <= denemeSayisi; i++) {
            System.out.print(i + ". Deneme: ");
            if (scanner.hasNextInt()) {
                int tahmin = scanner.nextInt();
                scanner.nextLine();
                if (tahmin > rndmSayi && i != denemeSayisi) {
                    System.out.println("Yanlış tahmin!" + " Kalan hakkınız: " + (denemeSayisi - i) + "\nLütfen daha küçük bir sayı giriniz!");
                } else if (tahmin < rndmSayi && i != denemeSayisi) {
                    System.out.println("Yanlış tahmin!" + " Kalan hakkınız: " + (denemeSayisi - i) + "\nLütfen daha büyük bir sayı giriniz!");
                } else if (tahmin == rndmSayi) {
                    System.out.println("Tebrikler... Doğru tahmin yaptınız.");
                    return;
                } else {
                    System.out.println("Üzgünüz " + rndmSayi + " sayısını " + i + " deneme sonucunda tahmin edemediniz.");
                }
            } else {
                System.out.println("Geçersiz tahmin. Lütfen bir tam sayı girin.");
                scanner.nextLine();
                i--;
            }
        }
    }

    private static boolean devamMi(Scanner scanner) {
        while (true) {
            System.out.print("Oyuna devam etmek istiyor musunuz (E/H)? ");
            String devamMi = scanner.nextLine();
            if (devamMi.equalsIgnoreCase("e") || devamMi.equalsIgnoreCase("evet")) {
                return true;
            } else if (devamMi.equalsIgnoreCase("h") || devamMi.equalsIgnoreCase("hayır")) {
                System.out.println("Oyun sonlandırılıyor...");
                return false;
            } else {
                System.out.println("Lütfen yanlızca Evet(E) ya da Hayır(H) değerini giriniz.");
            }
        }
    }
}