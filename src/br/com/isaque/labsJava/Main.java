package br.com.isaque.labsJava;

import java.util.ArrayList;
import it.ssc.log.SscLogger;
import it.ssc.pl.milp.*;

public class Main {

    public static void main(String[] args) throws Exception {

        ArrayList< String > constraints = new ArrayList< String >();
        constraints.add("min: x1 + x2 + x3 + x4 + x5 + x6 + x7 + x8 + x9");
        constraints.add("44.7x1 + 8.4x2 + 7.4x3 + 2.2x4 + 2.6x5 + 1.1x6 + 9.6x7 + 14.4x8 + 97x9 >= 2");
        constraints.add("2x1 + 15.1x2 + 16.4x3 + 0.2x4 + 4x5 + 0x6 + 2.7x7 + 3.7x8 + 6.3x9 >= 0.07");
        constraints.add("0x1 + 26x2 + 28.1x3 + 169.2x4 + 7.2x5 + 918.4x6 + 290.7x7 + 5.1x8 + 52x9 >= 6");
        constraints.add("33.3x1 + 23.5x2 + 10.3x3 + 50.8x4 + 4.5x5 + 13.8x6 + 5.4x7 + 38.2x8 + 6.7x9 >= 4.7");
        constraints.add("0x1 + 60x2 + 0x3 + 525x4 + 5369x5 + 2755x6 + 1912x7 + 0x8 + 44x9 >= 65");

        LP lp = new LP(constraints);

        SolutionType solution_type=lp.resolve();

        if(solution_type==SolutionType.OPTIMUM) {
            Solution soluzione=lp.getSolution();
            for(SolutionConstraint solutionConstraint: soluzione.getSolutionConstraint()){
                SscLogger.log(String.valueOf(solutionConstraint.getValue()));
            }
            for(Variable var:soluzione.getVariables()) {
                SscLogger.log("Variável de decisão "+var.getName() + " valor :"+var.getValue());
            }
            SscLogger.log("Z:"+soluzione.getOptimumValue());
        }
    }
}
