package lotto.domain

class Lottos() {

    var lottos = listOf<Lotto>()

    constructor(lottos: List<Lotto>) : this() {
        this.lottos = lottos
    }

    companion object {
        fun of(purchaseCount: Int): Lottos {

            var list = mutableListOf<Lotto>()

            repeat(purchaseCount) {
                list.add(Lotto.of())
            }

            return Lottos(list)
        }
    }
}
