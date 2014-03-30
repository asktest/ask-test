package fm.ask.page

import geb.Page

class PasswordRecoveryResetPage extends Page {

    static at = {
        header.displayed
        saveButton.displayed
    }

    static content = {
        header(wait: true) { $('a', text:'password recovery') }
        newPasswordInput(wait: true) { $("#reset_password_password") }
        repeatNewPasswordInput(wait: true) { $("#reset_password_password_confirmation") }
        saveButton(wait: true) { $("#reset_password_submit") }
    }

    void enterNewPasswordTwice(String password) {
        newPasswordInput.value(password)
        repeatNewPasswordInput.value(password)
    }

    void submitNewPassword() {
        saveButton.click()
    }

}