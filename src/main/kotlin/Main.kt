fun main() {
    val amountCommission = calculateCommission("Maestro",7_000_00, 100_000_00)

    println("Комиссия за перевод " + amountCommission/100 + " руб. " + amountCommission%100 + " коп.")

}

fun calculateCommission (typeCardAccount:String, amountOfPayCurrentMonth:Int = 0, amountCurrentPay: Int): Int {
    val levelFreeCommissionMasterCardMaestro = 75_000_00
    val amountPayOverLevelMasterCardMaestro = amountCurrentPay + amountOfPayCurrentMonth - levelFreeCommissionMasterCardMaestro
    val commissionOverLevelMasterCardMaestro = 0.06
    val commissionOverLevelMasterCardMaestroRur = 20_00
    val commissionVisaMir = 0.075
    val minCommissionVisaMir = 35_00
    val commission = when (typeCardAccount) {
        "MasterCard", "Maestro" -> if ((amountOfPayCurrentMonth + amountCurrentPay) > levelFreeCommissionMasterCardMaestro)
                                      (amountPayOverLevelMasterCardMaestro*commissionOverLevelMasterCardMaestro).toInt() + commissionOverLevelMasterCardMaestroRur
                                   else 0
        "Visa", "Мир"          -> if(amountCurrentPay*commissionVisaMir > minCommissionVisaMir )
                                    (amountCurrentPay*commissionVisaMir).toInt()
                                  else minCommissionVisaMir
        else -> 0
    }
    return commission

}