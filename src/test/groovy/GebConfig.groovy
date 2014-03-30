import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxProfile



waiting {
    timeout = 10
}

driver = {
    def driver = new FirefoxDriver(firefoxWithEnglishLocale())
    driver.manage().window().maximize()
    driver
}


FirefoxProfile firefoxWithEnglishLocale() {
    def profile = new FirefoxProfile()
    profile.setPreference("intl.accept_languages", "en")
}
