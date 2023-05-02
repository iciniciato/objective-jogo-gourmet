package br.com.gourmetgame.utils;

public class Constants {

    private Constants() {
    }

    public static final String GAME_GOURMET = "Jogo Gourmet";

    public static final String THINK_A_PLATE_YOU_LIKE = "Pense em um prato que gosta";

    public static final String OK = "OK";

    public static final String PASTA = "massa";

    public static final String LASAGNA = "Lasanha";

    public static final String WITCH_PLATE_DID_YOU_THINK = "Qual prato você pensou?";

    public static final String THE_PLATE_YOU_THOUGHT_OF_IS = "O prato que você pensou é ";

    public static final String INTERROGATION = "?";

    public static final String I_HIT_AGAIN = "Acertei de novo!";

    public static final String CHOCOLATE_CAKE = "Bolo de Chocolate";

    public static final String PASTA_TEXT = Constants.THE_PLATE_YOU_THOUGHT_OF_IS + Constants.PASTA + Constants.INTERROGATION;

    public static final String LASAGNA_TEXT = Constants.THE_PLATE_YOU_THOUGHT_OF_IS + Constants.LASAGNA + Constants.INTERROGATION;

    public static String getButIsNot(String plate, String oldPlate) {
        return plate + " é ___________ mas " + oldPlate + " não";
    }
}