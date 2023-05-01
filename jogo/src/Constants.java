public class Constants {

    static final String GAME_GOURMET = "Jogo Gourmet";

    static final String THINK_A_PLATE_YOU_LIKE = "Pense em um prato que gosta";

    static final String OK = "OK";

    static final String PASTA = "massa";

    static final String LASAGNA = "Lasanha";

    static final String WITCH_PLATE_DID_YOU_THINK = "Qual prato você pensou?";

    static final String THE_PLATE_YOU_THOUGHT_OF_IS = "O prato que você pensou é ";

    static final String INTERROGATION = "?";

    static final String I_HIT_AGAIN = "Acertei de novo!";

    static final String CHOCOLATE_CAKE = "Bolo de Chocolate";

    public static String getButIsNot(String plate, String oldPlate) {
        return plate + " é ___________ mas " + oldPlate + " não";
    }
}