package Utilities;

import Numbers.RationalScalar;
import Numbers.RealScalar;
import Numbers.Scalar;
import Polynoms.PolyTerm;
import Polynoms.Polynomial;

import java.util.LinkedList;
import java.util.List;

public class Parser {

    /**
     * Given array of strings that represent polynoms and field, creates array of polynoms according to the specific field
     * @param strPolynoms - Given array of strings
     * @param field - The field that according to him the pars will happen
     * @return polynomials - Array of polynoms
     */
    public Polynomial[] convertStrToPoly(String[] strPolynoms, String field){
        arrangeMinuses(strPolynoms);
        Polynomial[] polynomials = null;
        polynomials = convertToPolynomials(strPolynoms, field);
        return polynomials;
    }

    /**
     * For every occurence of '-', replace to '+-'
     * @param strPolynoms - perform this action on this array
     */
    private void arrangeMinuses(String[] strPolynoms) {
        for (int i = 0; i < strPolynoms.length; i++) {
            if(strPolynoms[i].charAt(0) == '-')
                strPolynoms[i] = strPolynoms[i].charAt(0) + strPolynoms[i].substring(1).replaceAll("-", "+-");
            else
                strPolynoms[i] = strPolynoms[i].replaceAll("-", "+-");
        }
    }

    /**
     * Given a string that represent a number, returns a rational number
     * @param strScalar - The string to parse
     * @return rational number
     */
    public RationalScalar convertStrToRational(String strScalar) {
        return extractRational(strScalar);
    }

    /**
     * Given a string that represent a number, returns a real number
     * @param strScalar - The string to parse
     * @return rational number
     */
    public Scalar convertStrToReal(String strScalar) {
        return extractReal(strScalar);
    }

    /**
     * Converts polynomial to string
     * @param addPoly - The polynomial to convert
     * @param s - Prefix for the print
     * @return s - The string to print after execute operation on the polynomial
     */
    public String convertPolyToStr(Polynomial addPoly, String s) {
        boolean isFirst = true;
        List<PolyTerm> polyTermList = addPoly.getPolinom();
        if (polyTermList.isEmpty())
            return "";

        for (PolyTerm polyTerm: polyTermList) {
            if (polyTerm.getScalar().isNegetive()) {
                s +=  polyTerm.toString();
                isFirst = false;
            }
            else if(isFirst) {
                s += polyTerm.toString();
                isFirst = false;
            }
            else
                s+= "+" + polyTerm.toString();
        }
        return s;
    }

    /**
     * Converts scalar to string
     * @param evalPoly - Scalar to conveert
     * @param s - Prefix for later printing
     * @return - String to print
     */
    public String convertScalarToStr(Scalar evalPoly, String s) {
        return s +" " + evalPoly.toString();
    }

    /**
     * Given an array of strings, creates from them array of polynoms
     * @param strPolynoms - Given array
     * @param field
     * @return polynomials - array of polynoms
     */
    private Polynomial[] convertToPolynomials(String[] strPolynoms, String field) {
        Polynomial[] polynomials = new Polynomial[strPolynoms.length];
        for (int i = 0; i < strPolynoms.length; i++) {
            String[] parts = strPolynoms[i].split("\\+");
            Polynomial poly = extractPolynom(parts, field);
            polynomials[i] = poly;
        }
        return polynomials;
    }

    /**
     * Given a String splitted according to '+' sign, parse and creates a polynom from it
     * @param parts - splitted string that represents a polynom
     * @param field
     * @return polynomial - new polynom
     */
    private Polynomial extractPolynom(String[] parts, String field) {
        List<PolyTerm> polyTerms = new LinkedList<>();
        for (String part: parts) {
            //RationalScalar scalar = null;
            Scalar scalar = null;
            int exp;
            String[] strPolyTerm = part.split("\\^");
            if(strPolyTerm[0].length() == 1 && strPolyTerm[0].charAt(0)=='x'){
                if (field.equals("Q") || field.equals("q"))
                    scalar = RationalScalar.createRational(1, 1);
                else
                    scalar = new RealScalar(1);
            }

            else if(strPolyTerm[0].length() == 2 && strPolyTerm[0].charAt(1) == 'x' && strPolyTerm[0].charAt(0) == '-'){
                if(field.equals("Q") || field.equals("q"))
                    scalar = RationalScalar.createRational(-1, 1);
                else
                    scalar = new RealScalar(-1);
            }

            else if(strPolyTerm[0].length() == 1){
                if(field.equals("Q") || field.equals("q"))
                    scalar = extractRational(strPolyTerm[0]);
                else
                    scalar = extractReal(strPolyTerm[0]);
            }

            else if (strPolyTerm[0].length() > 1){
                if(strPolyTerm[0].charAt(strPolyTerm[0].length()-1) == 'x'){
                    if(field.equals("Q") || field.equals("q"))
                        scalar = extractRational(strPolyTerm[0].substring(0, strPolyTerm[0].length() - 1));
                    else
                        scalar = extractReal(strPolyTerm[0].substring(0, strPolyTerm[0].length() - 1));
                    }

                else {
                    if (field.equals("Q") || field.equals("q"))
                        scalar = extractRational(strPolyTerm[0]);
                    else
                        scalar = extractReal(strPolyTerm[0]);
                }
            }

            if(!(strPolyTerm[0].contains("x"))){
                exp = 0;
            }

            else{
                exp = Integer.parseInt(strPolyTerm[1]);
            }

            PolyTerm polyTerm = PolyTerm.createPolyTerm(scalar, exp);
            polyTerms.add(polyTerm);
        }
        boolean q = field.equals("q") || field.equals("Q");
        return new Polynomial(polyTerms, q);
    }

    /**
     * Given a string from the form of "x/y" create a rational number
     * @param s - string to parse
     * @return rationalNumber - rational number
     */
    private RationalScalar extractRational(String s) {
        RationalScalar rationalScalar;
        String[] devApart = s.split("/");
        if(devApart.length > 1){
            int up = Integer.parseInt(devApart[0]);
            int down = Integer.parseInt(devApart[1]);
            rationalScalar = RationalScalar.createRational(up, down);
        }
        else{
            int up = Integer.parseInt(devApart[0]);
            rationalScalar = RationalScalar.createRational(up, 1);
        }
        return rationalScalar;
    }

    /**
     *  Given a string from the form of "x/y" create a real number
     * @param s - string to parse
     * @return realNumber - real number
     */
    private RealScalar extractReal(String s){
        RealScalar realScalar;
        String[] devApart = s.split("/");
        if(devApart.length > 1){
            Double up = Double.parseDouble(devApart[0]);
            Double down = Double.parseDouble(devApart[1]);
            double doub = up/down;
            realScalar = new RealScalar(doub);
        }
        else{
            realScalar = new RealScalar(Double.parseDouble(devApart[0]));
        }
        return realScalar;
    }

}
