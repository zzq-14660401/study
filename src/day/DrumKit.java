package day;

class DrumKit {
    boolean topHat = true;
    boolean snare = true;

    void palySnare() {
        System.out.println("bang bang ba-bang");
    }

    void playTopHat() {
        System.out.println("ding ding da-ding");
    }
}

class DrumKitTestDrive {
    public static void main(String[] args) {
        DrumKit d = new DrumKit();
        d.palySnare();
        d.snare = false;
        d.playTopHat();
        if (d.snare == true) {
            d.palySnare();
        }
    }
}
