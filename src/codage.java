import com.sun.nio.file.SensitivityWatchEventModifier;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Math.max;

/**
 * @k est le degre du polynome generateur ==> g(x) = x^k
 * @m(x) est le polynome associe au message ==> m(x) = x^n + x^m + .... + x^p + ....
 * @m'(x) est le produit de g(x) et m(x) ==> m'(x) = g(x) * m(x)
 * @r(x) est le reste de la division euclidienne de m'(x) par g(x)
 * @c(x) est le message envoye ==> c(x) = m'(x) + r(x)
 * */

public class codage {
    public static final int constante = -1;
    private int generatorPower; // Degre du polynome generateur k
    private ArrayList<Integer> generatorDegrees; // Degre des monomes du polynome generateur
    private ArrayList<Integer> associatePolyPower; // tableau des degres des monomes de m(x)
    private ArrayList<Integer> geneassociatProd; // tableau des degres des monomes de m'(x)
    private ArrayList<Integer> resteDegrees; // tableau des degres des monomes de r(x)
    private ArrayList<Integer> messageDegres; // tableau des degres des monoes de c(x)

    public codage() {}

    public int getGeneratorPower() {
        return generatorPower;
    }

    @Override
    public String toString() {
        return "codage{" +
                "generatorPower=" + generatorPower +
                ", generatorDegrees=" + generatorDegrees +
                ", associatePolyPower=" + associatePolyPower +
                ", geneassociatProd=" + geneassociatProd +
                ", resteDegrees=" + resteDegrees +
                ", messageDegres=" + messageDegres +
                '}';
    }

    public void setGeneratorPower() {
        this.generatorPower = this.getGeneratorDegrees().get(0);
    }

    public ArrayList<Integer> getAssociatePolyPower() {
        return associatePolyPower;
    }

    public void setAssociatePolyPower(ArrayList<Integer> associatePolyPower) {
        this.associatePolyPower = associatePolyPower;
    }

    public ArrayList<Integer> getGeneassociatProd() {
        return geneassociatProd;
    }

    public void setGeneassociatProd(ArrayList<Integer> geneassociatProd) {
        this.geneassociatProd = geneassociatProd;
    }

    public ArrayList<Integer> getResteDegrees() {
        return resteDegrees;
    }

    public void setResteDegrees(ArrayList<Integer> resteDegrees) {
        this.resteDegrees = resteDegrees;
    }

    public ArrayList<Integer> getMessageDegres() {
        return messageDegres;
    }

    public void setMessageDegres(ArrayList<Integer> messageDegres) {
        this.messageDegres = messageDegres;
    }

    public ArrayList<Integer> getGeneratorDegrees() {
        return generatorDegrees;
    }

    public void setGeneratorDegrees(ArrayList<Integer> generatorDegrees) {
        this.generatorDegrees = generatorDegrees;
    }

    /**
     * @make( m'(x)) est une fonction qui permet de calculer m'(x) = x^k *m(x)
     * comme m(x) et x^k sont des polynomes en x, les multiplier reviendrait a augmenter de k
     * le degre de chaque monome de m(x)
     * @exemple : x^5 * (x^4 + x^2 + x + 1) = x^(4+5) + x^(2+5) + x^(1+5) + x^(0+5)
     * = x^9 + x^7 + x^6 + x^5
     * Si on consdere les degres des monomes de m(x) ==> [4, 0, 2, 1, 0] et x^5 ==> [5]
     * Si on somme [4, 0, 2, 1, 0] avec chaque degre de [5, 0, 0, 0, 0, 0] on a [9, 0, 7, 6, 5] ce qui donne
     * une ecriture simplifier de m'(x) = x^[9, 0,7,6,5]
     * */

    public void makeMprime() {
        ArrayList<Integer> temp = new ArrayList<>();
        this.messageDegres.forEach(degre ->{
            int degres = (degre !=0) ? degre+this.generatorPower : degre*this.generatorPower;
            temp.add(degres);
        });
        if(temp.get(temp.size()-1) != 0) {
            temp.set(temp.size()-1, this.generatorPower);
        }
        for (int i = 0; i <this.generatorPower ; i++) {
            temp.add(0);
        }
        setAssociatePolyPower(temp);
    }




    public int restDegree(int a, int b) {
        return a != b ? max(a,b) : 0;
    }

}
