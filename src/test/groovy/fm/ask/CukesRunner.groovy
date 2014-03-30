package fm.ask

import org.junit.runner.RunWith

import cucumber.api.junit.Cucumber
import cucumber.api.junit.Cucumber.Options

@RunWith(Cucumber.class)
@Options(strict = true, format = ['html:build/report', 'json:build/cucumber.json'])
public class CukesRunner {
}
