package fm.ask.page

import geb.Page

class PasswordRecoveryUpdatePage extends Page {

    static at = {
        header.displayed
        returnToMainPageButton.displayed
    }

    static content = {
        header(wait: true) { $('a', text:'password recovery') }
        successfulMessage(wait: true) { $(".info-ok") }
        returnToMainPageButton(wait: true) { $('a', text:'Return to main page') }
    }

    void expectPasswordSuccessfullyChangedMessage() {
        assert successfulMessage.text().contains('Password successfully changed')
    }

}