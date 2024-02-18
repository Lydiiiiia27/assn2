package comp533;
import grader.basics.execution.BasicProjectExecution;

import gradingTools.comp533s24.assignment2.S24Assignment2Suite;
import trace.grader.basics.GraderBasicsTraceUtility;
public class RunTests {
	private static final int TRACE = 2000;
	public static void main(final String[] args) {
		// if you set this to false, grader steps will not be traced
		GraderBasicsTraceUtility.setTracerShowInfo(true);	
		// if you set this to false, all grader steps will be traced,
		// not just the ones that failed		
		GraderBasicsTraceUtility.setBufferTracedMessages(true);
		// Change this number if a test trace gets longer than 600 and is clipped
		GraderBasicsTraceUtility.setMaxPrintedTraces(TRACE);
		// Change this number if all traces together are longer than 2000
		GraderBasicsTraceUtility.setMaxTraces(TRACE);
		// Change this number if your process times out prematurely
		BasicProjectExecution.setProcessTimeOut(TRACE);
		// You need to always call such a method
		S24Assignment2Suite.main(args);
	}
}
