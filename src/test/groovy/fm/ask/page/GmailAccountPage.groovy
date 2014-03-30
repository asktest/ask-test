package fm.ask.page

import geb.Page

class GmailAccountPage extends Page {

    static url = 'https://mail.google.com/mail/#inbox'

    static at = {
        waitFor { title.contains('Inbox') }
    }

    static content = {
        selectAllEmailCheckbox(wait: true) { $(".T-I .T-Jo") }
        deleteButton(wait: true) { $("[aria-label='Delete']") }
        noNewEmailsMessage(wait: 2, required: false) { $('td', text: 'No new emails!') }
        emailSubject { $(".xY b") }
        changePasswordLink(wait: true) { $("[href*='http://ask.fm/remind/reset/']") }
    }


    boolean noNewEmails() {
        noNewEmailsMessage.displayed
    }

    void deleteAllEmails() {
        selectAllEmailCheckbox.click()
        deleteButton.click()
        waitFor { noNewEmails() }
        Thread.sleep(2000)
    }

    void expectChangePasswordEmail() {
        assert waitFor(100) { emailSubject }.text().contains('Change password link')
    }

    void openChangePasswordEmail() {
        emailSubject.click()
        changePasswordLink.displayed
    }

    void followViaChangePasswordLink() {
        changePasswordLink.click()
        switchToBrowserWindow(2)
    }

    void switchToBrowserWindow(int numberOfWindow) {
        waitFor { getDriver().getWindowHandles().toArray().length >= 2 }
        String handle = getDriver().getWindowHandles().toArray()[numberOfWindow - 1].toString()
        getDriver().switchTo().window(handle)
    }

}