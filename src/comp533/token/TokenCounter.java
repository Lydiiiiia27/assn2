/*
package comp533.token;

import gradingTools.comp533s19.assignment0.AMapReduceTracer;
import java.util.HashMap;
import java.util.Scanner;

public class TokenCounter extends AMapReduceTracer {
    private static final String QUIT = "quit";

    public static void main(String[] args) {
        TokenCounter counter = new TokenCounter();
        counter.processInput();
    }
  
    public void processInput() {
        Scanner scanner = new Scanner(System.in);
        traceNumbersPrompt();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase(QUIT)) {
                traceQuit();
                break;
            }

            HashMap<String, Integer> tokenCounts = countTokens(line);
            traceMap(line, tokenCounts.toString());
        }

        scanner.close();
    }

    private HashMap<String, Integer> countTokens(String input) {
        HashMap<String, Integer> tokenCounts = new HashMap<>();
        String[] tokens = input.split(" ");

        for (String token : tokens) {
            tokenCounts.put(token, tokenCounts.getOrDefault(token, 0) + 1);
        }

        return tokenCounts;
    }

    
    @Override
    protected void traceNumbersPrompt() {
        super.traceNumbersPrompt();
    }

    @Override
    protected void traceQuit() {
        super.traceQuit();
    }

    @Override
    protected void traceMap(Object anInputs, Object aKeyValues) {
        super.traceMap(anInputs, aKeyValues);
    }
   
}
*/



package comp533.token;

import comp533.mvc.TokenCounterModel;
import comp533.mvc.TokenCounterView;

import java.beans.PropertyChangeListener;

import comp533.mvc.IController;
import comp533.mvc.IModel;
//import comp533.mvc.IView;
import comp533.mvc.TokenCounterController;


public class TokenCounter {
    public static void main(final String[] args) {
       final TokenCounterModel model = new TokenCounterModel();
       final PropertyChangeListener view = new TokenCounterView();
       final IController controller = new TokenCounterController(model);

        model.addPropertyChangeListener((PropertyChangeListener) view);
        controller.processInput();
    }
}

