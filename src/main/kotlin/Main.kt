fun main() {
    println(resultPayment("Maestro", 7_000_00, 100_000_00))
}

fun calculateCommission (typeCardAccount:String,  amountCurrentPay: Int, amountOfPayCurrentMonth:Int = 0,): String {
    val levelFreeCommissionMasterCardMaestro = 75_000_00
    val amountPayOverLevelMasterCardMaestro = amountCurrentPay + amountOfPayCurrentMonth - levelFreeCommissionMasterCardMaestro
    val commissionOverLevelMasterCardMaestro = 0.06
    val commissionOverLevelMasterCardMaestroRur = 20_00
    val commissionVisaMir = 0.075
    val minCommissionVisaMir = 35_00
    val commission = when (typeCardAccount) {
        "MasterCard", "Maestro" -> if ((amountOfPayCurrentMonth + amountCurrentPay) > levelFreeCommissionMasterCardMaestro)
            (amountPayOverLevelMasterCardMaestro * commissionOverLevelMasterCardMaestro).toInt() + commissionOverLevelMasterCardMaestroRur
        else 0
        "Visa", "Мир" -> if (amountCurrentPay * commissionVisaMir > minCommissionVisaMir)
            (amountCurrentPay * commissionVisaMir).toInt()
        else minCommissionVisaMir
        else -> 0
    }


    return "Комиссия составила " + commission/100 + " руб." + commission%100 + " коп."

}

fun resultPayment (typeCardAccount: String, amountCurrentPay: Int, amountOfPayCurrentMonth: Int = 0): String  {
    val maxPaymentCardOnTime = 150_000_00
    val maxPaymentCardMonth = 600_000_00
    val maxPaymentVkPayOnTime = 15_000_00
    val maxPaymentVkPayMonth = 40_000_00
    val amountCurrentPayAll = amountCurrentPay + amountOfPayCurrentMonth
    val result = when (typeCardAccount) {
    "VK Pay" -> if(amountCurrentPay < maxPaymentVkPayOnTime && amountCurrentPayAll < maxPaymentVkPayMonth)
                calculateCommission(typeCardAccount,amountOfPayCurrentMonth,amountCurrentPay)
                else   "Лимит VK Pay превышен"
    else -> if(amountCurrentPay < maxPaymentCardOnTime && amountCurrentPayAll < maxPaymentCardMonth)
                calculateCommission(typeCardAccount,amountOfPayCurrentMonth,amountCurrentPay)
                else  "Лимит карты " + typeCardAccount +  " превышен"

}
    return result
}



