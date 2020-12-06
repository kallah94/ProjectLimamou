import java.util.ArrayList;

public class main {

    public static void main(String[] args) {
        /**
         * declaration des differentes variables
         * */
        ArrayList<Integer> generator = new ArrayList<>();
        generator.add(3);
        generator.add(0);
        generator.add(1);
        generator.add(1);

        ArrayList<Integer> message = new ArrayList<>();
        message.add(3);
        message.add(2);
        message.add(0);
        message.add(1);

        codage code = new codage();
        code.setMessageDegres(message);
        code.setGeneratorDegrees(generator);
        code.setGeneratorPower();
        code.makeMprime();
        System.out.println("Test Division "+code.toString());

    }
}