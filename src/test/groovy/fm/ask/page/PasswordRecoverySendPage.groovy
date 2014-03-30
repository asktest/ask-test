package fm.ask.page

import geb.Page

class PasswordRecoverySendPage extends Page {

    static at = {
        header.displayed
        returnToMainPageButton.displayed
    }

    static content = {
        header(wait: true) { $('a', text:'password recovery') }
        successfulMessage(wait: true) { $(".info-ok") }
        returnToMainPageButton(wait: true) { $('a', text:'Return to main page') }
    }

    void expectSuccessfulMessage() {
        assert successfulMessage.text().contains('A message with your username and a link to reset your password has been sent to your email.')
    }

}