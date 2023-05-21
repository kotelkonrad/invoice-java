import controllers.faktura;

/**
 * Run program
 */
class Main {
    /**
     * Initialize controller

      Przykladowy wzor rekordu:  Lody_z_rożkiem;sztuka;12;15;20
      Ropa;galon;12;50;20
     */
    public static void main(String[] args) {
        (new faktura()).run();
    }
}