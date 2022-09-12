package testssuites;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages("testcases")
@IncludeTags("Regressao")
public class RegressionTest {
}
