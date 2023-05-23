import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun calculateCommissionInLimitMaestro() {
       val typeCardAccount = "Maestro"
       val amountOfPayCurrentMonth = 0
       val amountCurrentPay= 10_00

       val result = calculateCommission(typeCardAccount, amountCurrentPay , amountOfPayCurrentMonth)

       assertEquals("Комиссия составила 0 руб.0 коп.", result)

    }
    @Test
    fun calculateCommissionInLimitMaestroDef() {
        val typeCardAccount = "Maestro"
        val amountCurrentPay= 10_00

        val result = calculateCommission(typeCardAccount, amountCurrentPay)

        assertEquals("Комиссия составила 0 руб.0 коп.", result)

    }

    @Test
    fun calculateCommissionInCurPayMaestro() {
        val typeCardAccount = "MasterCard"
        val amountOfPayCurrentMonth = 0
        val amountCurrentPay= 10_00

        val result = calculateCommission(typeCardAccount, amountCurrentPay , amountOfPayCurrentMonth)

        assertEquals("Комиссия составила 0 руб.0 коп.", result)

    }


    @Test
    fun calculateCommissionOverLimitMasterCardMaestro() {
        val typeCardAccount = "Maestro"
        val amountOfPayCurrentMonth = 75_000_00
        val amountCurrentPay= 10_00

        val result = calculateCommission(typeCardAccount, amountCurrentPay , amountOfPayCurrentMonth)

        assertEquals("Комиссия составила 20 руб.60 коп.", result)

    }


     @Test
    fun calculateCommissionOverLimitMasterCard() {
        val typeCardAccount = "MasterCard"
        val amountOfPayCurrentMonth = 75_000_00
        val amountCurrentPay= 10_00

        val result = calculateCommission(typeCardAccount, amountCurrentPay , amountOfPayCurrentMonth)

        assertEquals("Комиссия составила 20 руб.60 коп.", result)

    }

    @Test
    fun calculateCommissionInLimitVisaMir() {
        val typeCardAccount = "Visa"
        val amountOfPayCurrentMonth = 0
        val amountCurrentPay= 10_00

        val result = calculateCommission(typeCardAccount, amountCurrentPay , amountOfPayCurrentMonth)

        assertEquals("Комиссия составила 35 руб.0 коп.", result)

    }

    @Test
    fun calculateCommissionOverLimitVisaMir() {
        val typeCardAccount = "Visa"
        val amountOfPayCurrentMonth = 0
        val amountCurrentPay= 1_000_00

        val result = calculateCommission(typeCardAccount, amountCurrentPay , amountOfPayCurrentMonth)

        assertEquals("Комиссия составила 75 руб.0 коп.", result)

    }

    @Test
    fun calculateCommissionInLimitMir() {
        val typeCardAccount = "Мир"
        val amountOfPayCurrentMonth = 0
        val amountCurrentPay= 10_00

        val result = calculateCommission(typeCardAccount, amountCurrentPay , amountOfPayCurrentMonth)

        assertEquals("Комиссия составила 35 руб.0 коп.", result)

    }

    @Test
    fun calculateCommissionOverLimitMir() {
        val typeCardAccount = "Мир"
        val amountOfPayCurrentMonth = 0
        val amountCurrentPay= 1_000_00

        val result = calculateCommission(typeCardAccount, amountCurrentPay , amountOfPayCurrentMonth)

        assertEquals("Комиссия составила 75 руб.0 коп.", result)

    }

    @Test
    fun calculateCommissionOtherCard() {
        val typeCardAccount = "VK Pay"
        val amountOfPayCurrentMonth = 0
        val amountCurrentPay= 1_000_00

        val result = calculateCommission(typeCardAccount, amountCurrentPay , amountOfPayCurrentMonth)

        assertEquals("Комиссия составила 0 руб.0 коп.", result)

    }

     @Test
    fun calculateCommissionInResultPaymentVk() {
        val typeCardAccount = "VK Pay"
        val amountOfPayCurrentMonth = 1_000_00
        val amountCurrentPay= 1_000_00

        val result = resultPayment(typeCardAccount, amountCurrentPay , amountOfPayCurrentMonth)

        assertEquals("Комиссия составила 0 руб.0 коп.", result)

    }


    @Test
    fun calculateCommissionOverResultPaymentVk() {
        val typeCardAccount = "VK Pay"
        val amountOfPayCurrentMonth = 100_000_00
        val amountCurrentPay= 1_000_00

        val result = resultPayment(typeCardAccount, amountCurrentPay , amountOfPayCurrentMonth)

        assertEquals("Лимит VK Pay превышен", result)

    }

    @Test
    fun calculateCommissionOverCurResultPaymentVk() {
        val typeCardAccount = "VK Pay"
        val amountOfPayCurrentMonth = 1_00
        val amountCurrentPay= 100_000_00

        val result = resultPayment(typeCardAccount, amountCurrentPay , amountOfPayCurrentMonth)

        assertEquals("Лимит VK Pay превышен", result)

    }

    @Test
    fun calculateCommissionInResultPayment() {
        val typeCardAccount = "Maestro"
        val amountOfPayCurrentMonth = 1_000_00
        val amountCurrentPay= 76_000_00

        val result = resultPayment(typeCardAccount, amountCurrentPay , amountOfPayCurrentMonth)

        assertEquals("Комиссия составила 140 руб.0 коп.", result)

    }

    @Test
    fun calculateCommissionOverResultPayment() {
        val typeCardAccount = "Maestro"
        val amountOfPayCurrentMonth = 651_000_00
        val amountCurrentPay= 75_100_00

        val result = resultPayment(typeCardAccount, amountCurrentPay , amountOfPayCurrentMonth)

        assertEquals("Лимит карты Maestro превышен", result)

    }

    @Test
    fun calculateCommissionOverCurPayResultPayment() {
        val typeCardAccount = "Maestro"
        val amountOfPayCurrentMonth = 1_000_00
        val amountCurrentPay= 175_100_00

        val result = resultPayment(typeCardAccount, amountCurrentPay , amountOfPayCurrentMonth)

        assertEquals("Лими карты Maestro превышен", result)

    }

}