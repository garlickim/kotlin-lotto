package lotto

import lotto.domain.Buyer
import lotto.domain.Lottos
import lotto.view.InputView
import lotto.view.ResultView

object Application {
    @JvmStatic
    fun main(args: Array<String>) {
        val price = InputView.purchasePrice()

        val purchaseCount = Buyer(price).purchaseCount
        ResultView.showPurchaseCount(purchaseCount)

        val lottos = Lottos.of(purchaseCount)
        ResultView.showPurchasedLottos(lottos.lottos)

        val winningNumbers = InputView.lastWinningNumbers()
    }
}
