package fitnesse.reporting;

import java.io.IOException;

import fitnesse.testrunner.WikiTestPage;
import util.TimeMeasurement;
import fitnesse.FitNesseContext;
import fitnesse.reporting.TestExecutionReport;
import fitnesse.testsystems.TestSummary;
import fitnesse.wiki.WikiPage;

public class PageHistoryFormatter extends XmlFormatter {

  public PageHistoryFormatter(FitNesseContext context, final WikiPage page, WriterFactory writerFactory) {
    super(context, page, writerFactory);
  }

  @Override
  public void newTestStarted(WikiTestPage testedPage, TimeMeasurement timeMeasurement) {
    testResponse = new TestExecutionReport();
    setPage(testedPage.getSourcePage());
    super.newTestStarted(testedPage, timeMeasurement);
  }

  @Override
  public void testComplete(WikiTestPage test, TestSummary testSummary, TimeMeasurement timeMeasurement) throws IOException {
    super.testComplete(test, testSummary, timeMeasurement);
    writeResults();
  }

  @Override
  public void allTestingComplete(TimeMeasurement totalTimeMeasurement) {
    setTotalRunTimeOnReport(totalTimeMeasurement);
  }

}
