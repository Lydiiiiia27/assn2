package comp533.mvc;

import java.util.Scanner;

import gradingTools.comp533s19.assignment0.AMapReduceTracer;

public class TokenCounterController extends AMapReduceTracer implements IController{
    private TokenCounterModel model;
//    private IModel model;

    public TokenCounterController(final TokenCounterModel modelParam) {
        this.model = modelParam;
    }

    @Override
    public void processInput() {
        final Scanner scanner = new Scanner(System.in);

        //System.out.println("Controller: Please enter 'quit' or a line of tokens to be processed separated by spaces");

    /*
        traceThreadPrompt();
        if (scanner.hasNextInt()) {
            int numThreads = scanner.nextInt();
            scanner.nextLine();
            model.setNumThreads(numThreads);
        }
*/
        traceNumbersPrompt();
        while (scanner.hasNextLine()) {
            final String line = scanner.nextLine();
            if (QUIT.equals(line.toLowerCase())) {
                traceQuit();
                break;
            }
            model.setInputString(line);
        }

        scanner.close();
    }

    @Override
    public String toString() {
        return gradingTools.comp533s19.assignment0.AMapReduceTracer.CONTROLLER;
    }
}
