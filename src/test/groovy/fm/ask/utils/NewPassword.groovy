package fm.ask.utils

import org.apache.commons.lang3.RandomStringUtils

class NewPassword {

    def static newPasswordHolder = new ThreadLocal<String>()

    static lastGenerated() {
        newPasswordHolder.get()
    }

    static generate() {
        def newPassword = RandomStringUtils.randomAlphanumeric(9)
        newPasswordHolder.set(newPassword)

        newPassword
    }

}
